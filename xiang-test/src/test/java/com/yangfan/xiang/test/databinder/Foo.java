package com.yangfan.xiang.test.databinder;

import java.math.BigDecimal;
import java.util.Date;

public class Foo {
	
	private long id;
	
	private int intField;
	
	private double doubleField;
	
	private Integer integerField;
	
	private Double doubleBoxField;
	
	private String stringField;
	
	private Date dateField;
	
	private Bar bar;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private BigDecimal bigDecimalField;

	public int getIntField() {
		return intField;
	}

	public void setIntField(int intField) {
		this.intField = intField;
	}

	public double getDoubleField() {
		return doubleField;
	}

	public void setDoubleField(double doubleField) {
		this.doubleField = doubleField;
	}

	public Integer getIntegerField() {
		return integerField;
	}

	public void setIntegerField(Integer integerField) {
		this.integerField = integerField;
	}

	public Double getDoubleBoxField() {
		return doubleBoxField;
	}

	public void setDoubleBoxField(Double doubleBoxField) {
		this.doubleBoxField = doubleBoxField;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public Date getDateField() {
		return dateField;
	}

	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}

	public BigDecimal getBigDecimalField() {
		return bigDecimalField;
	}

	public void setBigDecimalField(BigDecimal bigDecimalField) {
		this.bigDecimalField = bigDecimalField;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

}
