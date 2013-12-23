package com.yangfan.xiang.domain.demo.abc;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="DEMO_FOO")
@SequenceGenerator(name = "FooSequence", sequenceName="FOO_SEQUENCE")
public class Foo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="FooSequence")
	private long id;
	
	private int intField;
	
	private double doubleField;
	
	private Integer integerField;
	
	private Double doubleBoxField;
	
	private String stringField;
	
	private Date dateField;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(precision=32, scale=16)
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Foo [intField=").append(intField)
				.append(", doubleField=").append(doubleField)
				.append(", integerField=").append(integerField)
				.append(", doubleBoxField=").append(doubleBoxField)
				.append(", stringField=").append(stringField)
				.append(", dateField=").append(dateField)
				.append(", bigDecimalField=").append(bigDecimalField)
				.append(", toString()=").append(super.toString()).append("]");
		return builder.toString();
	}

}