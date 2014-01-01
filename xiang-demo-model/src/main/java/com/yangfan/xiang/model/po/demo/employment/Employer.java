package com.yangfan.xiang.model.po.demo.employment;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.yangfan.xiang.core.po.CorePo;

/**
 * 雇主、老板
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_EMPLOYER")
public class Employer extends CorePo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1535311861149113101L;
	
	/**
	 * 姓名
	 */
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employer [name=").append(name).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}
	
}
