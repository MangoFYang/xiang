package com.yangfan.xiang.core.ehcache.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Status;
import net.sf.ehcache.event.CacheManagerEventListener;

public class LogCacheManagerEventListener implements CacheManagerEventListener {
	
	private final Logger log = LoggerFactory.getLogger(LogCacheManagerEventListener.class);

	@Override
	public void init() throws CacheException {
		log.debug("LogCacheManagerEventListener.init被调用。");
	}

	@Override
	public Status getStatus() {
		log.debug("LogCacheManagerEventListener.getStatus被调用。");
		return null;
	}

	@Override
	public void dispose() throws CacheException {
		log.debug("LogCacheManagerEventListener.dispose被调用。");
	}

	@Override
	public void notifyCacheAdded(String cacheName) {
		log.debug("LogCacheManagerEventListener.notifyCacheAdded被调用，cache[{}]", cacheName);
	}

	@Override
	public void notifyCacheRemoved(String cacheName) {
		log.debug("LogCacheManagerEventListener.getStatus被调用，cache[{}]", cacheName);
	}

}
