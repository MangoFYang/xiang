package com.yangfan.xiang.core.web.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

public class CorePostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof RequestMappingHandlerAdapter) {
			// Modify properties of the adapter
			RequestMappingHandlerAdapter requestMappingHandlerAdapter = ( RequestMappingHandlerAdapter ) bean;
			List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getCustomReturnValueHandlers();
			if(returnValueHandlers == null) {
				returnValueHandlers = new ArrayList<HandlerMethodReturnValueHandler>();
				returnValueHandlers.add(
						new CoreResponseMethodReturnValueHandler(requestMappingHandlerAdapter.getMessageConverters()));
				requestMappingHandlerAdapter.setCustomReturnValueHandlers(returnValueHandlers);
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

}
