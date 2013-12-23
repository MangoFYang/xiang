package com.yangfan.xiang.core.service;


public interface CacheService {
	
	/**
	 * 获取 Spring Cache 管理器
	 * 
	 * Spring Cache和Ehcache的区别可参见getEhcache()方法。
	 * 
	 * @return org.springframework.cache.CacheManager实例
	 */
	public org.springframework.cache.CacheManager getSpringCacheManager();
	
	/**
	 * 获取 EhCache 管理器
	 * 
	 * Spring Cache和Ehcache的区别可参见getEhcache()方法。
	 * 
	 * @return net.sf.ehcache.CacheManager
	 */
	public net.sf.ehcache.CacheManager getEhcacheManager();
	
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
	public net.sf.ehcache.Ehcache getEhcache(String name);
	
	/**
	 * 获取Spring缓存实例
	 * 
	 * Spring Cache和Ehcache的区别可参见getEhcache()方法。
	 * 
	 * @param name 缓存名
	 * @return
	 */
	public org.springframework.cache.Cache getSpringCache(String name);
	
}
