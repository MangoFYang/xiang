package com.yangfan.xiang.domain.demo.workingcalendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * 当前工作日
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_CALD_CWORKCALENDAR")
@SequenceGenerator(name = "CurrentWorkingCalendarSequence", sequenceName="CALD_CWORKCALENDAR_SEQ")
public class CurrentWorkingCalendar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CurrentWorkingCalendarSequence")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workingCalendarType_id", nullable=false, unique=true)
	private WorkingCalendarType workingCalendarType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workingCalendar_id", nullable=false)
	private WorkingCalendar workingCalendar;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public WorkingCalendarType getWorkingCalendarType() {
		return workingCalendarType;
	}

	public void setWorkingCalendarType(WorkingCalendarType workingCalendarType) {
		this.workingCalendarType = workingCalendarType;
	}

	public WorkingCalendar getWorkingCalendar() {
		return workingCalendar;
	}

	public void setWorkingCalendar(WorkingCalendar workingCalendar) {
		this.workingCalendar = workingCalendar;
	}
	
}
