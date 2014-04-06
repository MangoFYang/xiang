package com.yangfan.xiang.core.web;

import java.beans.PropertyEditorSupport;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletRequest;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefaults;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Extracts paging information from web requests and thus allows injecting {@link CoreRequest} instances into controller
 * methods. Request properties to be parsed can be configured. Default configuration uses request properties beginning
 * with {@link #DEFAULT_PREFIX}{@link #DEFAULT_SEPARATOR}.
 * 
 * @author 杨帆
 */
public class CoreRequestArgumentResolver implements WebArgumentResolver {

	private static final CoreRequest DEFAULT_CORE_REQUEST = new CoreRequestImpl(1, 10);
	private static final String DEFAULT_PREFIX = "core";
	private static final String DEFAULT_SEPARATOR = ".";

	private CoreRequest fallbackCoreRequest = DEFAULT_CORE_REQUEST;
	private String prefix = DEFAULT_PREFIX;
	private String separator = DEFAULT_SEPARATOR;

	/**
	 * Setter to configure a fallback instance of {@link CoreRequest} that is being used to back missing parameters. Defaults
	 * to {@link #DEFAULT_CORE_REQUEST}.
	 * 
	 * @param fallbackCoreRequest the fallbackCoreRequest to set
	 */
	public void setFallbackCoreRequest(CoreRequest fallbackCoreRequest) {
		this.fallbackCoreRequest = null == fallbackCoreRequest ? DEFAULT_CORE_REQUEST : fallbackCoreRequest;
	}

	/**
	 * Setter to configure the prefix of request parameters to be used to retrieve paging information. Defaults to
	 * {@link #DEFAULT_PREFIX}.
	 * 
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = null == prefix ? DEFAULT_PREFIX : prefix;
	}

	/**
	 * Setter to configure the separator between prefix and actual property value. Defaults to {@link #DEFAULT_SEPARATOR}.
	 * 
	 * @param separator the separator to set
	 */
	public void setSeparator(String separator) {
		this.separator = null == separator ? DEFAULT_SEPARATOR : separator;
	}

	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) {

		if (methodParameter.getParameterType().equals(CoreRequest.class)) {
			
			assertPageableUniqueness(methodParameter);

			CoreRequest request = getDefaultFromAnnotationOrFallback(methodParameter);
			ServletRequest servletRequest = (ServletRequest) webRequest.getNativeRequest();
			PropertyValues propertyValues = new ServletRequestParameterPropertyValues(servletRequest,
					getPrefix(methodParameter), separator);

			DataBinder binder = new ServletRequestDataBinder(request);

			binder.initDirectFieldAccess();
			
			binder.registerCustomEditor(Sort.class, new SortPropertyEditor());
			binder.registerCustomEditor(Filter.class, new FilterPropertyEditor());
			
			binder.bind(propertyValues);

			return request;
		}

		return UNRESOLVED;
	}

	private CoreRequest getDefaultFromAnnotationOrFallback(MethodParameter methodParameter) {

		// search for PageableDefaults annotation
		for (Annotation annotation : methodParameter.getParameterAnnotations()) {
			if (annotation instanceof PageableDefaults) {
				return getDefaultPageRequestFrom((PageableDefaults) annotation);
			}
		}

		// Construct request with fallback request to ensure sensible
		// default values. Create fresh copy as Spring will manipulate the
		// instance under the covers
		return new CoreRequestImpl(fallbackCoreRequest.getPageNumber(), fallbackCoreRequest.getPageSize(), fallbackCoreRequest.getSort());
	}

	private static CoreRequest getDefaultPageRequestFrom(PageableDefaults defaults) {

		int defaultPageNumber = defaults.pageNumber() == 0 ? defaults.pageNumber() + 1 : defaults.pageNumber();
		int defaultPageSize = defaults.value();

		if (defaults.sort().length == 0) {
			return new CoreRequestImpl(defaultPageNumber, defaultPageSize);
		}

		return new CoreRequestImpl(defaultPageNumber, defaultPageSize, defaults.sortDir(), defaults.sort());
	}

	/**
	 * Resolves the prefix to use to bind properties from. Will prepend a possible {@link Qualifier} if available or
	 * return the configured prefix otherwise.
	 * 
	 * @param parameter
	 * @return
	 */
	private String getPrefix(MethodParameter parameter) {

		for (Annotation annotation : parameter.getParameterAnnotations()) {
			if (annotation instanceof Qualifier) {
				return new StringBuilder(((Qualifier) annotation).value()).append("_").append(prefix).toString();
			}
		}

		return prefix;
	}

	/**
	 * Asserts uniqueness of all {@link CoreRequest} parameters of the method of the given {@link MethodParameter}.
	 * 
	 * @param parameter
	 */
	private void assertPageableUniqueness(MethodParameter parameter) {

		Method method = parameter.getMethod();

		if (containsMoreThanOnePageableParameter(method)) {
			Annotation[][] annotations = method.getParameterAnnotations();
			assertQualifiersFor(method.getParameterTypes(), annotations);
		}
	}

	/**
	 * Returns whether the given {@link Method} has more than one {@link CoreRequest} parameter.
	 * 
	 * @param method
	 * @return
	 */
	private boolean containsMoreThanOnePageableParameter(Method method) {

		boolean pageableFound = false;

		for (Class<?> type : method.getParameterTypes()) {

			if (pageableFound && type.equals(CoreRequest.class)) {
				return true;
			}

			if (type.equals(CoreRequest.class)) {
				pageableFound = true;
			}
		}

		return false;
	}

	/**
	 * Asserts that every {@link CoreRequest} parameter of the given parameters carries an {@link Qualifier} annotation to
	 * distinguish them from each other.
	 * 
	 * @param parameterTypes
	 * @param annotations
	 */
	private void assertQualifiersFor(Class<?>[] parameterTypes, Annotation[][] annotations) {

		Set<String> values = new HashSet<String>();

		for (int i = 0; i < annotations.length; i++) {

			if (CoreRequest.class.equals(parameterTypes[i])) {

				Qualifier qualifier = findAnnotation(annotations[i]);

				if (null == qualifier) {
					throw new IllegalStateException(
							"Ambiguous CoreRequest arguments in handler method. If you use multiple parameters of type CoreRequest you need to qualify them with @Qualifier");
				}

				if (values.contains(qualifier.value())) {
					throw new IllegalStateException("Values of the user Qualifiers must be unique!");
				}

				values.add(qualifier.value());
			}
		}
	}

	/**
	 * Returns a {@link Qualifier} annotation from the given array of {@link Annotation}s. Returns {@literal null} if the
	 * array does not contain a {@link Qualifier} annotation.
	 * 
	 * @param annotations
	 * @return
	 */
	private Qualifier findAnnotation(Annotation[] annotations) {

		for (Annotation annotation : annotations) {
			if (annotation instanceof Qualifier) {
				return (Qualifier) annotation;
			}
		}

		return null;
	}
	
	/**
	 * {@link java.beans.PropertyEditor} to create {@link Sort} instances from textual representations. The implementation
	 * interprets the string as a comma separated list where the first entry is the sort direction ( {@code asc},
	 * {@code desc}) followed by the properties to sort by.
	 * 
	 * @author Oliver Gierke
	 */
	private static class SortPropertyEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String text) {
			// our custom implementation of sorter encoding - turns our sorters into "name#ASC,age#DESC"
			List<Order> orders = new ArrayList<Order>();
			String[] propDirs = text.split(",");
			for (String propDir : propDirs) {
				String[] orderPart = propDir.split("#");
				Direction dir = Direction.ASC;
				if(orderPart.length > 1) {
					dir = Direction.fromString(orderPart[1]);
				}
				Order order = new Order(dir, orderPart[0]);
				orders.add(order);
			}
			setValue(new Sort(orders));
		}
		
	}
	
	private static class FilterPropertyEditor extends PropertyEditorSupport {
		
		@Override
		public void setAsText(String text) {
			// our custom implementation of filter encoding - turns our sorters into "name#mango,age#20"
			MultiValueMap<String, String> queries = new LinkedMultiValueMap<String, String>();
			String[] propDirs = text.split(",");
			for (String propDir : propDirs) {
				String[] queryPart = propDir.split("#");
				if(queryPart.length > 1) {
					queries.add(queryPart[0], queryPart[1]);
				} else {
					queries.add(queryPart[0], "");
				}
			}
			setValue(new Filter(queries));
		}
		
	}
	
}
