package com.yangfan.xiang.core.ehcache.event;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.event.CacheManagerEventListener;
import net.sf.ehcache.event.CacheManagerEventListenerFactory;

public class LogCacheManagerEventListenerFactory extends CacheManagerEventListenerFactory {
	
	private final Logger log = LoggerFactory.getLogger(LogCacheManagerEventListenerFactory.class);

	@Override
	public CacheManagerEventListener createCacheManagerEventListener(
			CacheManager cacheManager, Properties properties) {
		log.debug("创建LogCacheManagerEventListenerFactory使用配置: {}", properties);
		return new LogCacheManagerEventListener();
	}

}
