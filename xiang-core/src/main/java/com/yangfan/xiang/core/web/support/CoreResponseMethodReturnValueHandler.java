package com.yangfan.xiang.core.web.support;

import java.io.IOException;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class CoreResponseMethodReturnValueHandler extends RequestResponseBodyMethodProcessor {
	
	public CoreResponseMethodReturnValueHandler(List<HttpMessageConverter<?>> messageConverters) {
		super(messageConverters);
	}
	
	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return Page.class.isAssignableFrom(returnType.getParameterType());
	}
	
	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
			throws IOException, HttpMediaTypeNotAcceptableException {
		returnValue = ResponseFactory.createCoreResponse((Page<?>)returnValue);
		super.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
	}

}
