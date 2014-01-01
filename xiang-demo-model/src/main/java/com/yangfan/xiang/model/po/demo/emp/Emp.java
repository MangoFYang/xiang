package com.yangfan.xiang.model.po.demo.emp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 员工
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_EMP")
public class Emp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3672629501254571903L;

	/**
	 * 员工编号
	 */
	@Id
	private Integer empNo;
	
	/**
	 * 员工姓名
	 */
	private String eName;
	
	/**
	 * 工作种类
	 */
	private String job;
	
	/**
	 * 经理
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mgr")
	private Emp mgr;
	
	/**
	 * 下属
	 */
	@OneToMany(fetch=FetchType.LAZY, mappedBy="mgr", targetEntity=Emp.class)
	private List<Emp> subordinates = new ArrayList<Emp>();
	
	/**
	 * 雇佣日期
	 */
	@Temporal(TemporalType.DATE) // @Temporal定义日期类型
	private Date hireDate;
	
	/**
	 * 薪资
	 */
	private Double sal;
	
	/**
	 * 紧贴
	 */
	private Double comm;
	
	/**
	 * 所属部门
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deptno")
	private Dept dept;

	/**
	 * 员工编号
	 * 
	 * @return
	 */
	public Integer getEmpNo() {
		return empNo;
	}

	/**
	 * 员工编号
	 * 
	 * @param empNo
	 */
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	/**
	 * 员工姓名
	 * 
	 * @return
	 */
	public String geteName() {
		return eName;
	}

	/**
	 * 员工姓名
	 * 
	 * @param eName
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}

	/**
	 * 经理
	 * 
	 * @return
	 */
	public Emp getMgr() {
		return mgr;
	}

	/**
	 * 经理
	 * 
	 * @param mgr
	 */
	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}

	/**
	 * 雇佣日期
	 * 
	 * @return
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * 雇佣日期
	 * 
	 * @param hireDate
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * 薪资
	 * 
	 * @return
	 */
	public Double getSal() {
		return sal;
	}

	/**
	 * 薪资
	 * 
	 * @param sal
	 */
	public void setSal(Double sal) {
		this.sal = sal;
	}

	/**
	 * 紧贴
	 * 
	 * @return
	 */
	public Double getComm() {
		return comm;
	}

	/**
	 * 紧贴
	 * 
	 * @param comm
	 */
	public void setComm(Double comm) {
		this.comm = comm;
	}

	/**
	 * 所属部门
	 * 
	 * @return
	 */
	public Dept getDept() {
		return dept;
	}

	/**
	 * 所属部门
	 * 
	 * @param dept
	 */
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	/**
	 * 工作种类
	 * 
	 * @return
	 */
	public String getJob() {
		return job;
	}

	/**
	 * 工作种类
	 * 
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}
	
	/**
	 * 下属
	 * 
	 * @return
	 */
	public List<Emp> getSubordinates() {
		return subordinates;
	}

	/**
	 * 下属
	 * 
	 * @param subordinates
	 */
	public void setSubordinates(List<Emp> subordinates) {
		this.subordinates = subordinates;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [empNo=").append(empNo).append(", eName=")
				.append(eName).append(", job=").append(job)
				.append(", hireDate=").append(hireDate).append(", sal=")
				.append(sal).append(", comm=").append(comm)
				.append(", toString()=").append(super.toString()).append("]");
		return builder.toString();
	}

}
