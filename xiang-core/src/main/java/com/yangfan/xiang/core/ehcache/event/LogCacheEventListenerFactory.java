package com.yangfan.xiang.core.ehcache.event;

import java.util.Properties;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogCacheEventListenerFactory extends CacheEventListenerFactory {

	private final Logger log = LoggerFactory.getLogger(LogCacheEventListenerFactory.class);
	
	@Override
	public CacheEventListener createCacheEventListener(Properties properties) {
		log.debug("创建LogCacheEventListener使用配置: {}", properties);
		return new LogCacheEventListener();
	}

}
