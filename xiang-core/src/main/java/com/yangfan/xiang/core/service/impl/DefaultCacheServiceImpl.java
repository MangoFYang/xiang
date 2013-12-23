package com.yangfan.xiang.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.service.CacheService;

@Service
public class DefaultCacheServiceImpl implements CacheService {
	
	@Resource
	private org.springframework.cache.CacheManager springCacheManager;
	
	@Resource
	private net.sf.ehcache.CacheManager ehcacheManager;
	
	@Override
	public org.springframework.cache.CacheManager getSpringCacheManager() {
		return springCacheManager;
	}
	
	@Override
	public net.sf.ehcache.CacheManager getEhcacheManager() {
		return ehcacheManager;
	}
	
	@Override
	public net.sf.ehcache.Ehcache getEhcache(String name) {
		return this.getEhcacheManager().getEhcache(name);
	}
	
	@Override
	public org.springframework.cache.Cache getSpringCache(String name) {
		return this.getSpringCacheManager().getCache(name);
	}
	
}
