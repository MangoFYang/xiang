package com.yangfan.xiang.controller.config.exceptionhandling;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangfan.xiang.core.logger.Logger;
import com.yangfan.xiang.core.logger.LoggerFactory;

@Component
public class CoreExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handle(Exception exception) {
		logger.error(exception.getMessage(), exception);
		return exception.getMessage();
	}

}
