package com.yangfan.xiang.core.web;

import java.io.Serializable;

import org.springframework.util.MultiValueMap;

/**
 * 
 * 过滤和查询
 * 
 * @author 杨帆
 *
 */
public class Filter implements Serializable {

	private static final long serialVersionUID = 8165283586045124755L;
	
	private final MultiValueMap<String, String> queries;
	
	public Filter(MultiValueMap<String, String> queries) {
		if (queries == null || queries.isEmpty()) {
			throw new IllegalArgumentException("You have to provide at least one property to filter by!");
		}
		this.queries = queries;
	}
	
	public MultiValueMap<String, String> getQueries() {
		return queries;
	}

	@Override
	public String toString() {
		return queries.toString();
	}
	
}
