package com.yangfan.xiang.core.vo;


public class ReturnVo extends ExtraDataVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4189862821316647482L;
	
	/**
	 * 是否成功
	 */
	private Boolean success;
	
	/**
	 * 成功/错误信息
	 */
	private String message;
	
	public ReturnVo() {
	}
	
	public ReturnVo(Boolean success) {
		super();
		this.success = success;
	}

	public ReturnVo(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
