package com.yangfan.xiang.model.po.demo.employment;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.yangfan.xiang.core.po.CorePo;

/**
 * 雇员
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_EMPLOYEE")
public class Employee extends CorePo {
	
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
