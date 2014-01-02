package com.yangfan.xiang.core.vo;


public class LabelValueVo extends ExtraDataVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1024229985543899246L;

	/**
	 * 标签，用于显示。
	 */
	private String label;
	
	/**
	 * 值，用于传递。
	 */
	private String value;
	
	
	public LabelValueVo() {
	}

	public LabelValueVo(String label, String value) {
		super();
		this.label = label;
		this.value = value;
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

}
