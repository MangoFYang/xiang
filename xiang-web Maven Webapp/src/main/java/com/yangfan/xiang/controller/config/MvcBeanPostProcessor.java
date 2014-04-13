package com.yangfan.xiang.controller.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.yangfan.xiang.core.web.support.CoreRequestHandlerMethodArgumentResolver;
import com.yangfan.xiang.core.web.support.CoreResponseMethodReturnValueHandler;

@Component
public class MvcBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof RequestMappingHandlerAdapter) {
			// Modify properties of the adapter
			RequestMappingHandlerAdapter requestMappingHandlerAdapter = ( RequestMappingHandlerAdapter ) bean;
			
			List<HandlerMethodArgumentResolver> customArgumentResolvers = requestMappingHandlerAdapter.getCustomArgumentResolvers();
			List<HandlerMethodReturnValueHandler> customReturnValueHandlers = requestMappingHandlerAdapter.getCustomReturnValueHandlers();
			if(customArgumentResolvers == null) {
				customArgumentResolvers = new ArrayList<HandlerMethodArgumentResolver>();
			}
			if(customReturnValueHandlers == null) {
				customReturnValueHandlers = new ArrayList<HandlerMethodReturnValueHandler>();
			}
			customReturnValueHandlers.add(
					new CoreResponseMethodReturnValueHandler(requestMappingHandlerAdapter.getMessageConverters()));
			customArgumentResolvers.add(new CoreRequestHandlerMethodArgumentResolver());
			
			requestMappingHandlerAdapter.setCustomArgumentResolvers(customArgumentResolvers);
			requestMappingHandlerAdapter.setCustomReturnValueHandlers(customReturnValueHandlers);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

}
