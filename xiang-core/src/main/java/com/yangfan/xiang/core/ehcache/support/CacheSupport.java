package com.yangfan.xiang.core.ehcache.support;

import com.yangfan.xiang.core.service.CacheService;
import com.yangfan.xiang.core.support.ApplicationContextHolder;

/**
 * EhCache帮助类
 * 
 * 此类在ApplicationContextHolder神器实例化之前不能使用。
 * 项目启动需要执行的代码中禁止使用此帮助类。
 * 
 * 如有涉及此类中的功能可直接注入相关Bean。
 * 
 * @author 杨帆
 *
 */
public class CacheSupport {
	
	/**
	 * 获取默认的缓存服务类
	 * 
	 * @return com.yangfan.xiang.core.service.CacheService
	 */
	public static CacheService getDefaultCacheService() {
		return ApplicationContextHolder.getBean(CacheService.class);
	}
	
}
