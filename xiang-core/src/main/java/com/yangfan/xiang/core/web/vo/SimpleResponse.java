package com.yangfan.xiang.core.web.vo;

import java.util.List;

public interface SimpleResponse<T> {
	
	Boolean getSuccess();
	
	String getMessage();
	
	List<T> getContent();

}
