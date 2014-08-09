package com.yangfan.xiang.controller.config.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yangfan.xiang.core.logger.Logger;
import com.yangfan.xiang.core.logger.LoggerFactory;
import com.yangfan.xiang.core.web.support.ResponseFactory;
import com.yangfan.xiang.core.web.vo.SimpleResponse;

@Component
public class CoreExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public SimpleResponse<Object> handle(Exception exception) {
		logger.error(exception.getMessage(), exception);
		SimpleResponse<Object> response = ResponseFactory.createSimpleResponse(false, exception.getMessage());
		return response;
	}

}
