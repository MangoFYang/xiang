package com.yangfan.xiang.core.ehcache.event;

import java.util.Properties;

import net.sf.ehcache.exceptionhandler.CacheExceptionHandler;
import net.sf.ehcache.exceptionhandler.CacheExceptionHandlerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogCacheExceptionHandlerFactory extends CacheExceptionHandlerFactory {

	private final Logger log = LoggerFactory.getLogger(LogCacheExceptionHandler.class);
	
	@Override
	public CacheExceptionHandler createExceptionHandler(Properties properties) {
		log.debug("创建LogCacheExceptionHandler使用配置: {}", properties);
		return new LogCacheExceptionHandler();
	}

}
