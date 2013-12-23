package com.yangfan.xiang.core.ehcache.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.exceptionhandler.CacheExceptionHandler;

public class LogCacheExceptionHandler implements CacheExceptionHandler {
	
	private final Logger log = LoggerFactory.getLogger(LogCacheExceptionHandler.class);

	@Override
	public void onException(Ehcache ehcache, Object key, Exception exception) {
		log.debug("cache[{}] LogCacheExceptionHandler.notifyElementRemoved被调用。key：{}", ehcache.getName() , key);
		log.debug("异常堆栈: ", exception);
	}

}
