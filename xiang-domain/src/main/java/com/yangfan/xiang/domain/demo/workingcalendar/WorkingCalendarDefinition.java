package com.yangfan.xiang.domain.demo.workingcalendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.Hibernate;

/**
 * 工作日历定义
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_CALD_WORKCALENDARDEF")
@SequenceGenerator(name = "WorkingCalendarDefinitionSequence", sequenceName="CALD_WORKCALENDARDEF_SEQ")
@JsonIgnoreProperties({"workingCalendarType", "param"})
public class WorkingCalendarDefinition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="WorkingCalendarDefinitionSequence")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workingCalendarType_id", nullable=false)
	private WorkingCalendarType workingCalendarType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="param_id", nullable=false)
	private Param param;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public WorkingCalendarType getWorkingCalendarType() {
		return workingCalendarType;
	}
	
	public String getWorkingCalendarType_typeName() {
		if(Hibernate.isInitialized(workingCalendarType)) {
			return workingCalendarType.getTypeName();
		} else {
			return null;
		}
	}

	public void setWorkingCalendarType(WorkingCalendarType workingCalendarType) {
		this.workingCalendarType = workingCalendarType;
	}

	public Param getParam() {
		return param;
	}
	
	public String getParam_label() {
		if(Hibernate.isInitialized(param)) {
			return param.getLabel();
		} else {
			return null;
		}
	}
	
	public String getParamType_label() {
		if(Hibernate.isInitialized(param)) {
			return param.getParamType_label();
		} else {
			return null;
		}
	}

	public void setParam(Param param) {
		this.param = param;
	}
	
}
