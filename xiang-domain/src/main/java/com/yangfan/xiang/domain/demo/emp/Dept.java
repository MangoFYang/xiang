package com.yangfan.xiang.domain.demo.emp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * 部门
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_DEPT")
public class Dept implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7639358309709139231L;

	/**
	 * 部门编号
	 */
	@Id
	private Integer deptNo;
	
	/**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 部门所在地
	 */
	private String loc;

	/**
	 * 部门编号
	 * 
	 * @return
	 */
	public Integer getDeptNo() {
		return deptNo;
	}

	/**
	 * 部门编号
	 * 
	 * @param deptNo
	 */
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	/**
	 * 部门名称
	 * 
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 部门名称
	 * 
	 * @param dName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 部门所在地
	 * 
	 * @return
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * 部门所在地
	 * 
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dept [deptNo=").append(deptNo).append(", dName=")
				.append(deptName).append(", loc=").append(loc).append("]");
		return builder.toString();
	}

}
