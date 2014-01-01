package com.yangfan.xiang.model.po.demo.employment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yangfan.xiang.core.po.CorePo;

/**
 * 雇佣关系
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_EMPLOYMENT")
public class Employment extends CorePo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2818399445177906922L;
	
	/**
	 * 开始时间
	 */
	private Date startDate;
	
	/**
	 * 结束时间
	 */
	private Date endDate;
	
	/**
	 * 雇主
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employer_id", nullable=false)
	private Employer employer;
	
	/**
	 * 雇员
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id", nullable=false)
	private Employee employee;
	
	/**
	 * 薪资/小时
	 */
	private MonetaryAmount hourlyRate;

	/**
	 * 开始时间
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 开始时间
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 结束时间
	 * 
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 结束时间
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 雇主
	 * 
	 * @return
	 */
	public Employer getEmployer() {
		return employer;
	}

	/**
	 * 雇主
	 * 
	 * @param employer
	 */
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	/**
	 * 雇员
	 * 
	 * @return
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * 雇员
	 * 
	 * @param employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * 薪资/小时
	 * 
	 * @return
	 */
	public MonetaryAmount getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * 薪资/小时
	 * 
	 * @param hourlyRate
	 */
	public void setHourlyRate(MonetaryAmount hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employment [startDate=").append(startDate)
				.append(", endDate=").append(endDate).append(", hourlyRate=")
				.append(hourlyRate).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}
	
}
