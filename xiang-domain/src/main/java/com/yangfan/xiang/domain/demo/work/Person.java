package com.yangfan.xiang.domain.demo.work;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.yangfan.xiang.core.domain.CoreDomain;

@Entity(name="DEMO_PERSON")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person extends CoreDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10104330089893577L;
	
	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 姓名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}
	
}
