package com.yangfan.xiang.core.web.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangfan.xiang.core.logger.Logger;
import com.yangfan.xiang.core.logger.LoggerFactory;
import com.yangfan.xiang.core.web.domain.CoreCondition;
import com.yangfan.xiang.core.web.domain.CoreFilter;
import com.yangfan.xiang.core.web.domain.CoreOrder;
import com.yangfan.xiang.core.web.domain.CorePager;
import com.yangfan.xiang.core.web.domain.CoreRequest;
import com.yangfan.xiang.core.web.domain.CoreSorter;
import com.yangfan.xiang.core.web.domain.DefaultCoreRequest;

public class CoreRequestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	
	private static final String DEFAULT_PREFIX = "core";
	private static final String DEFAULT_QUALIFIER_DELIMITER = ".";
	
	// pager
	private static final CorePager DEFAULT_PAGER = new CorePager(1, 10);
	private static final String DEFAULT_PAGE_PARAMETER = "page";
	private static final String DEFAULT_SIZE_PARAMETER = "size";
	private static final int DEFAULT_MAX_PAGE_SIZE = 2000;
	
	// sorters
	private static final String DEFAULT_SORTERS_PARAMETER = "sorters";
	
	// filters
	private static final String DEFAULT_FILTERS_PARAMETER = "filters";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private String prefix = DEFAULT_PREFIX;
	private String qualifierDelimiter = DEFAULT_QUALIFIER_DELIMITER;
	
	private CorePager fallbackPager = DEFAULT_PAGER;
	private String pageParameterName = DEFAULT_PAGE_PARAMETER;
	private String sizeParameterName = DEFAULT_SIZE_PARAMETER;
	private int maxPageSize = DEFAULT_MAX_PAGE_SIZE;
	
	private String sortersParameterName = DEFAULT_SORTERS_PARAMETER;
	
	private String filtersParameterName = DEFAULT_FILTERS_PARAMETER;

	public CoreRequestHandlerMethodArgumentResolver() {
	}
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return CoreRequest.class.equals(parameter.getParameterType());
	}

	@Override
	public CoreRequest resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		DefaultCoreRequest coreRequest = new DefaultCoreRequest();
		
		CorePager defaultOrFallback = new CorePager(fallbackPager.getPage(), fallbackPager.getSize());
		
		// pager
		String pageString = webRequest.getParameter(getParameterNameToUse(pageParameterName, parameter));
		String pageSizeString = webRequest.getParameter(getParameterNameToUse(sizeParameterName, parameter));
		
		int page = StringUtils.hasText(pageString) ? parseAndApplyBoundaries(pageString, 1, Integer.MAX_VALUE) : defaultOrFallback.getPage();
		int pageSize = StringUtils.hasText(pageSizeString) ? parseAndApplyBoundaries(pageSizeString, 1, maxPageSize) : defaultOrFallback.getSize();
		
		// Limit lower bound
		pageSize = pageSize < 1 ? defaultOrFallback.getPage() : pageSize;
		// Limit upper bound
		pageSize = pageSize > maxPageSize ? maxPageSize : pageSize;
		
		coreRequest.setPager(new CorePager(page, pageSize));
		
		// sorters
		String sorters = webRequest.getParameter(getParameterNameToUse(sortersParameterName, parameter));
		if(StringUtils.hasText(sorters)) {
			List<CoreOrder> orderList = objectMapper.readValue(sorters, new TypeReference<List<CoreOrder>>() {});
			if(orderList != null && !orderList.isEmpty()) {
				coreRequest.setSorter(new CoreSorter(orderList));
			}
		}
		
		// filters
		String filters = webRequest.getParameter(getParameterNameToUse(filtersParameterName, parameter));
		if(StringUtils.hasText(filters)) {
			List<CoreCondition> conditionList = objectMapper.readValue(filters, new TypeReference<List<CoreCondition>>() {});
			if(conditionList != null && !conditionList.isEmpty()) {
				coreRequest.setFilter(new CoreFilter(conditionList));
			}
		}
		
//		webRequest.setAttribute("CoreRequest", coreRequest, RequestAttributes.SCOPE_REQUEST);
		
		return coreRequest;
	}
	
	/**
	 * Returns the name of the request parameter to find the {@link Pageable} information in. Inspects the given
	 * {@link MethodParameter} for {@link Qualifier} present and prefixes the given source parameter name with it.
	 * 
	 * @param source the basic parameter name.
	 * @param parameter the {@link MethodParameter} potentially qualified.
	 * @return the name of the request parameter.
	 */
	protected String getParameterNameToUse(String source, MethodParameter parameter) {
		String paramePrefix = (parameter != null && parameter.hasParameterAnnotation(Qualifier.class)) ? parameter.getParameterAnnotation(Qualifier.class).value() : prefix;
		StringBuilder builder = new StringBuilder(paramePrefix);
		builder.append(qualifierDelimiter);
		return builder.append(source).toString();
	}
	
	/**
	 * Tries to parse the given {@link String} into an integer and applies the given boundaries. Will return the lower
	 * boundary if the {@link String} cannot be parsed.
	 * 
	 * @param parameter
	 * @param lower
	 * @param upper
	 * @return
	 */
	private int parseAndApplyBoundaries(String parameter, int lower, int upper) {
		try {
			int parsed = Integer.parseInt(parameter);
			return parsed < lower ? lower : parsed > upper ? upper : parsed;
		} catch (NumberFormatException e) {
			logger.error("Parameter [{}] can not parse to int.", e, parameter);
			return lower;
		}
	}

}
