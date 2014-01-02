package com.yangfan.xiang.core.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ExtraDataVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 339285506162066011L;
	
	/**
	 * 额外的数据, 想放什么放什么.
	 */
	private Map<String, Object> extraData = new HashMap<String, Object>();

	public Map<String, Object> getExtraData() {
		return extraData;
	}

	public void setExtraData(Map<String, Object> extraData) {
		this.extraData = extraData;
	}
	
}
