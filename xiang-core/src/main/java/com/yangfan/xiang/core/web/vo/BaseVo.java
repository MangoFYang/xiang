package com.yangfan.xiang.core.web.vo;

import java.io.Serializable;

public class BaseVo implements Serializable {
	
	private static final long serialVersionUID = 339285506162066011L;
	
	private String clientId;
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
}
