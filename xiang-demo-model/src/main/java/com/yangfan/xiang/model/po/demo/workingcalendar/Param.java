package com.yangfan.xiang.model.po.demo.workingcalendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Hibernate;

/**
 * 工作日历参数
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_CALD_PARAM")
@SequenceGenerator(name = "ParamSequence", sequenceName="CALD_PARAM_SEQ")
public class Param  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ParamSequence")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="paramType_id", nullable=false)
	private ParamType paramType;
	
	private String code;
	
	private String label;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ParamType getParamType() {
		return paramType;
	}
	
	public String getParamType_label() {
		if(Hibernate.isInitialized(paramType)) {
			return paramType.getLabel();
		} else {
			return null;
		}
	}

	public void setParamType(ParamType paramType) {
		this.paramType = paramType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
