package com.yangfan.xiang.model.po.demo.workingcalendar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 工作日历类型
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_CALD_WORKCALENDARTYPE")
@SequenceGenerator(name = "WorkingCalendarTypeSequence", sequenceName="CALD_WORKCALENDARTYPE_SEQ")
public class WorkingCalendarType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="WorkingCalendarTypeSequence")
	@Access(AccessType.PROPERTY)
	private Long id;
	
	private String typeName;
	
	@OneToMany(mappedBy="workingCalendarType")
	private List<WorkingCalendarDefinition> workingCalendarDefinitionList = new ArrayList<WorkingCalendarDefinition>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<WorkingCalendarDefinition> getWorkingCalendarDefinitionList() {
		return workingCalendarDefinitionList;
	}

	public void setWorkingCalendarDefinitionList(
			List<WorkingCalendarDefinition> workingCalendarDefinitionList) {
		this.workingCalendarDefinitionList = workingCalendarDefinitionList;
	}
	
}
