package com.yangfan.xiang.core.web.support;

import org.springframework.data.domain.Page;

import com.yangfan.xiang.core.web.domain.CoreRequest;
import com.yangfan.xiang.core.web.domain.CoreResponse;
import com.yangfan.xiang.core.web.domain.DefaultCoreResponse;

public abstract class CoreResponseFactory {
	
	public static CoreResponse createCoreResponse(CoreRequest coreRequest, Page<?> page) {
		return new DefaultCoreResponse(page, coreRequest);
	}

}
