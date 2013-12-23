package com.yangfan.xiang.domain.demo.employment;

import javax.persistence.Entity;

import com.yangfan.xiang.core.domain.CoreDomain;

/**
 * 雇主、老板
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_EMPLOYER")
public class Employer extends CoreDomain {

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
