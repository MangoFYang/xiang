package com.yangfan.xiang.model.po.demo.workingcalendar;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

/**
 * 工作日历
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_CALD_WORKCALENDAR")
@SequenceGenerator(name = "WorkingCalendarSequence", sequenceName="CALD_WORKCALENDAR_SEQ")
public class WorkingCalendar {
	
	/**
	 * 标识
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="WorkingCalendarSequence")
	private long id;
	
	/**
	 * 工作日历类型
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="workingCalendarType_id")
	private WorkingCalendarType workingCalendarType;
	
	/**
	 * 工作日期
	 */
	@Temporal(TemporalType.DATE)
	private Date workDate;
	
	/**
	 * 开始时间
	 */
	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	/**
	 * 结束时间
	 */
	@Temporal(TemporalType.TIME)
	private Date endTime;
	
	/**
	 * 日期类型，如：工作日、周末、法定节假日等
	 */
	private String dateType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public WorkingCalendarType getWorkingCalendarType() {
		return workingCalendarType;
	}
	
	public Long getWorkingCalendarType_id() {
		return workingCalendarType.getId();
	}
	
	public String getWorkingCalendarType_typeName() {
		return workingCalendarType.getTypeName();
	}
	
	public void setWorkingCalendarType(WorkingCalendarType workingCalendarType) {
		this.workingCalendarType = workingCalendarType;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	/**
	 * 星期
	 * 
	 * @return
	 */
	public Integer getDayOfWeek() {
		DateTime dt = new DateTime(workDate);
		return dt.getDayOfWeek();
	}
	
}
