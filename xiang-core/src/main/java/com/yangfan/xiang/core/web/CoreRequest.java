package com.yangfan.xiang.core.web;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * 
 * 核心请求接口，对Pageable的扩展，增加了对查询条件的存储支持。
 * 
 * 默认实现  com.yangfan.xiang.core.web.CoreRequestImpl
 * 
 * @author 杨帆
 *
 */
public interface CoreRequest extends Pageable {
	
	/**
	 * 
	 * 获取过滤器
	 * 
	 * @return
	 */
	public Filter getFilter();

	/**
	 * 
	 * 根据 key 获取所有值, 经常一个key对应多个value
	 * 
	 * @param key 查询键
	 * @return key对应的值的List
	 */
	public List<String> getValues(String key);
	
	/**
	 * 
	 * 根据 key 获取value, 如果有多个, 取第一个
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key);
	
}
