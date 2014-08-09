package com.yangfan.xiang.controller.config.exceptionhandling;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.core.Ordered;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

@Component
public class CoreExceptionHandlerExceptionResolver extends
		ExceptionHandlerExceptionResolver {
	
	public CoreExceptionHandlerExceptionResolver() {
		getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
	
	private Object exceptionHandler;
	
	private ExceptionHandlerMethodResolver resolver;
	
	@Resource(type=CoreExceptionHandler.class)
	public void setExceptionHandler(Object exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
		resolver = new ExceptionHandlerMethodResolver(exceptionHandler.getClass());
	}

	@Override
	protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
			HandlerMethod handlerMethod, Exception exception) {
		ServletInvocableHandlerMethod exceptionHandlerMethod = super.getExceptionHandlerMethod(handlerMethod, exception);
		if( exceptionHandlerMethod != null ) {
			return exceptionHandlerMethod;
		}
		Method method = resolver.resolveMethod(exception);
		if (method != null) {
			return new ServletInvocableHandlerMethod(exceptionHandler, method);
		}
		return null;
	}

}
