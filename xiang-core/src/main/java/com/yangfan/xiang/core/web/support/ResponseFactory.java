package com.yangfan.xiang.core.web.support;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yangfan.xiang.core.web.vo.SimpleResponse;
import com.yangfan.xiang.core.web.vo.CoreResponse;
import com.yangfan.xiang.core.web.vo.DefaultCoreResponse;
import com.yangfan.xiang.core.web.vo.DefaultSimpleResponse;

public final class ResponseFactory {
	
	private ResponseFactory() {
	}
	
	public static <T> CoreResponse<T> createCoreResponse(Page<T> page) {
		return new DefaultCoreResponse<T>(page);
	}
	
	public static <T> CoreResponse<T> createCoreResponse(Boolean success, String message, Page<T> page) {
		return new DefaultCoreResponse<T>(success, message, page);
	}
	
	public static <T> SimpleResponse<T> createSimpleResponse(T t) {
		return new DefaultSimpleResponse<T>(t);
	}
	
	public static <T> SimpleResponse<T> createSimpleResponse(List<T> content) {
		return new DefaultSimpleResponse<T>(content);
	}
	
	public static <T> SimpleResponse<T> createSimpleResponse(Boolean success, String message) {
		return new DefaultSimpleResponse<T>(success, message);
	}
	
	public static <T> SimpleResponse<T> createSimpleResponse(Boolean success, String message, List<T> content) {
		return new DefaultSimpleResponse<T>(success, message, content);
	}

}
