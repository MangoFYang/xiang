package com.yangfan.xiang.core.service.support;

import javax.annotation.Resource;

import com.yangfan.xiang.core.infrastructure.Infrastructure;
import com.yangfan.xiang.core.service.CacheService;

/**
 * 抽象的缓存服务类，继承此类后将拥有缓存服务，或者直接注入com.yangfan.xiang.core.service.CacheService。
 * 
 * @author 杨帆
 *
 */
public abstract class CacheServiceSupport extends Infrastructure {
	
	@Resource
	private CacheService cacheService;
	
	/**
	 * 获取 Spring Cache 管理器
	 * 
	 * Spring Cache和Ehcache的区别可参见getEhcache()方法。
	 * 
	 * @return org.springframework.cache.CacheManager实例
	 */
	public org.springframework.cache.CacheManager getSpringCacheManager() {
		return cacheService.getSpringCacheManager();
	}
	
	/**
	 * 获取 EhCache 管理器
	 * 
	 * Spring Cache和Ehcache的区别可参见getEhcache()方法。
	 * 
	 * @return net.sf.ehcache.CacheManager
	 */
	public net.sf.ehcache.CacheManager getEhcacheManager() {
		return cacheService.getEhcacheManager();
	}

	/**
	 * 获取Ehcache实例
	 * 
	 * net.sf.ehcache.Ehcache和org.springframework.cache.Cache的区别：
	 * Spring抽象了缓存的接口，默认支持Ehcache的实现。
	 * 
	 * org.springframework.cache.Cache为Spring缓存抽象API。
	 * net.sf.ehcache.Ehcache为Ehcache原生API。
	 * 
	 * Spring提供的接口比较简单，使用也更为方便，建议使用Spring提供的接口，
	 * 如需要实现更加复杂的需求(比如：使用非Key属性对缓存查询)可以直接使用Ehcache原生API。
	 * 
	 * @param name Ehcache的名字
	 * @return
	 */
	public net.sf.ehcache.Ehcache getEhcache(String name) {
		return this.getEhcacheManager().getEhcache(name);
	}
	
	/**
	 * 获取Spring缓存实例
	 * 
	 * Spring Cache和Ehcache的区别可参见getEhcache()方法。
	 * 
	 * @param name 缓存名
	 * @return
	 */
	public org.springframework.cache.Cache getSpringCache(String name) {
		return this.getSpringCacheManager().getCache(name);
	}
	
}
