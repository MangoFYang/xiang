package com.yangfan.xiang.core.web.vo;

import java.util.ArrayList;
import java.util.List;

public class DefaultSimpleResponse<T> implements SimpleResponse<T> {
	
	private Boolean success;
	
	private String message;
	
	private List<T> content;
	
	public DefaultSimpleResponse() {
	}
	
	public DefaultSimpleResponse(T t) {
		this(true, null);
		List<T> content = new ArrayList<T>(1);
		content.add(t);
		this.content = content;
	}
	
	public DefaultSimpleResponse(List<T> content) {
		this(true, null, content);
	}
	
	public DefaultSimpleResponse(Boolean success) {
		this(success, null, null);
	}
	
	public DefaultSimpleResponse(Boolean success, String message) {
		this(success, message, null);
	}

	public DefaultSimpleResponse(Boolean success, String message, List<T> content) {
		this.success = success;
		this.message = message;
		this.content = content;
	}

	@Override
	public Boolean getSuccess() {
		return success;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
	
}
