package com.yangfan.xiang.core.vo;

import java.io.Serializable;

public class ReturnVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4189862821316647482L;
	
	private boolean success;
	
	private String message;
	
	private Object otherData;

	public ReturnVo() {
	}
	
	public ReturnVo(boolean success) {
		super();
		this.success = success;
	}

	public ReturnVo(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public ReturnVo(boolean success, Object otherData) {
		super();
		this.success = success;
		this.otherData = otherData;
	}

	public ReturnVo(boolean success, String message, Object otherData) {
		super();
		this.success = success;
		this.message = message;
		this.otherData = otherData;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getOtherData() {
		return otherData;
	}

	public void setOtherData(Object otherData) {
		this.otherData = otherData;
	}

}
