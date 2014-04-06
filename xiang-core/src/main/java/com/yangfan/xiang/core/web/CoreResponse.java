package com.yangfan.xiang.core.web;

import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;

/**
 * 
 * 核心响应接口，对Page的扩展，增加了对查询条件的存储支持。
 * 
 * @author 杨帆
 *
 * @param <T>
 */
public interface CoreResponse<T> extends Page<T> {
	
	/**
	 * 
	 * 获取过滤条件键值对
	 * 
	 * @return
	 */
	public MultiValueMap<String, String> getFilter();
	
}
