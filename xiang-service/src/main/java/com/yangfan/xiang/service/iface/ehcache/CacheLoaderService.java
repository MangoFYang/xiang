package com.yangfan.xiang.service.iface.ehcache;

/**
 * 启动服务，加载缓存服务类
 * 
 * @author 杨帆
 *
 */
public interface CacheLoaderService {
	
	/**
	 * 加载缓存数据
	 */
	void load();

}
