package com.yangfan.xiang.core.vo;

import java.io.Serializable;

public class ReturnVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4189862821316647482L;

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

	public ReturnVo(boolean success, String message, Object otherInfo) {
		super();
		this.success = success;
		this.message = message;
		this.otherInfo = otherInfo;
	}

	private boolean success;
	
	private String message;
	
	private Object otherInfo;

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

	public Object getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(Object otherInfo) {
		this.otherInfo = otherInfo;
	}
	
}
