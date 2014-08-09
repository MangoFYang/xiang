package com.yangfan.xiang.model.vo.demo.abc;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.yangfan.xiang.core.ConvertException;
import com.yangfan.xiang.core.web.vo.BaseVo;
import com.yangfan.xiang.model.po.demo.abc.Foo;

public class FooVo extends BaseVo {
	
	private static final long serialVersionUID = 6301404444861881799L;

	private long id;
	
	private int intField;
	
	private double doubleField;
	
	private Integer integerField;
	
	private Double doubleBoxField;
	
	private String stringField;
	
	private Date dateField;
	
	private BigDecimal bigDecimalField;
	
	public Foo toFoo() {
		try {
			Foo foo = new Foo();
			PropertyUtils.copyProperties(foo, this);
			return foo;
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			throw new ConvertException(e);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
	
}
