package com.yangfan.xiang.core.web.domain;

public class CoreCondition {
	
	private String property;
	
	private String value;
	
	public CoreCondition() {
	}
	
	public CoreCondition(String property, String value) {
		this.property = property;
		this.value = value;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}