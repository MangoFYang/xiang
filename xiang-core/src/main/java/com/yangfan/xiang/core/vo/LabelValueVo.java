package com.yangfan.xiang.core.vo;

import java.io.Serializable;

public class LabelValueVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1024229985543899246L;

	private String label;
	
	private String value;
	
	private Object otherData;
	
	public LabelValueVo() {
	}

	public LabelValueVo(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	
	public LabelValueVo(String label, String value, Object otherData) {
		super();
		this.label = label;
		this.value = value;
		this.otherData = otherData;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Object getOtherData() {
		return otherData;
	}

	public void setOtherData(Object otherData) {
		this.otherData = otherData;
	}

}
