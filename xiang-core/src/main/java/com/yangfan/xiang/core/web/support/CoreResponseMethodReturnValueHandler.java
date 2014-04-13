package com.yangfan.xiang.core.web.support;

import java.io.IOException;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.yangfan.xiang.core.web.domain.CoreResponse;

public class CoreResponseMethodReturnValueHandler extends RequestResponseBodyMethodProcessor {
	
	public CoreResponseMethodReturnValueHandler(List<HttpMessageConverter<?>> messageConverters) {
		super(messageConverters);
	}
	
	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return CoreResponse.class.equals(returnType.getParameterType());
	}
	
	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
			throws IOException, HttpMediaTypeNotAcceptableException {
		// DefaultCoreRequest coreRequest = (DefaultCoreRequest) webRequest.getAttribute("CoreRequest", RequestAttributes.SCOPE_REQUEST);
		super.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
	}

}
