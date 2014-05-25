package com.yangfan.xiang.core.web.domain;

public class CoreOrder {
	
	private String property;
	
	private String direction;
	
	public CoreOrder() {
	}
	
	public CoreOrder(String property, String direction) {
		this.property = property;
		this.direction = direction;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
