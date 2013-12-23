package com.yangfan.xiang.core.ehcache.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;

public class LogBootstrapCacheLoader implements BootstrapCacheLoader {
	
	private final Logger log = LoggerFactory.getLogger(LogBootstrapCacheLoader.class);

	@Override
	public void load(Ehcache cache) throws CacheException {
		log.debug("cache[{}] LogBootstrapCacheLoader.load被调用", cache.getName());
	}

	@Override
	public boolean isAsynchronous() {
		log.debug("LogBootstrapCacheLoader.isAsynchronous被调用");
		return false;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
