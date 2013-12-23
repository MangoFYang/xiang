package com.yangfan.xiang.domain.demo.employment;

import javax.persistence.Entity;

import com.yangfan.xiang.core.domain.CoreDomain;

/**
 * 雇员
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_EMPLOYEE")
public class Employee extends CoreDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6498071488054259279L;
	
	/**
	 * 姓名
	 */
	private Name name;
	
	/**
	 * 税单号
	 */
	private String taxFileNumber;

	/**
	 * 姓名
	 * 
	 * @return
	 */
	public Name getName() {
		return name;
	}

	/**
	 * 姓名
	 * 
	 * @param name
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * 税单号
	 * 
	 * @return
	 */
	public String getTaxFileNumber() {
		return taxFileNumber;
	}

	/**
	 * 税单号
	 * 
	 * @param taxFileNumber
	 */
	public void setTaxFileNumber(String taxFileNumber) {
		this.taxFileNumber = taxFileNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=").append(name)
				.append(", taxFileNumber=").append(taxFileNumber).append("]");
		return builder.toString();
	}	
	
}
