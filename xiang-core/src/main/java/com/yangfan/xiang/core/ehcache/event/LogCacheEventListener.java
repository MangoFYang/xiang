package com.yangfan.xiang.core.ehcache.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

public class LogCacheEventListener implements CacheEventListener {

	private final Logger log = LoggerFactory.getLogger(LogCacheEventListener.class);
	
	@Override
	public void notifyElementRemoved(Ehcache cache, Element element)
			throws CacheException {
		log.debug("cache[{}] LogCacheEventListener.notifyElementRemoved被调用。参数：{}", cache.getName() , element);
	}

	@Override
	public void notifyElementPut(Ehcache cache, Element element)
			throws CacheException {
		log.debug("cache[{}] LogCacheEventListener.notifyElementPut被调用。参数：{}", cache.getName() , element);
	}

	@Override
	public void notifyElementUpdated(Ehcache cache, Element element)
			throws CacheException {
		log.debug("cache[{}] LogCacheEventListener.notifyElementUpdated被调用。参数：{}", cache.getName() , element);
	}

	@Override
	public void notifyElementExpired(Ehcache cache, Element element) {
		log.debug("cache[{}] LogCacheEventListener.notifyElementExpired被调用。参数：{}", cache.getName() , element);
	}

	@Override
	public void notifyElementEvicted(Ehcache cache, Element element) {
		log.debug("cache[{}] LogCacheEventListener.notifyElementEvicted被调用。参数：{}", cache.getName() , element);
	}

	@Override
	public void notifyRemoveAll(Ehcache cache) {
		log.debug("cache[{}] LogCacheEventListener.notifyRemoveAll被调用。", cache.getName());
	}

	@Override
	public void dispose() {
		log.debug("LogCacheEventListener.dispose被调用。");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
