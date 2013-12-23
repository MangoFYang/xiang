package com.yangfan.xiang.domain.demo.employment;

import javax.persistence.Embeddable;

/**
 * 姓名
 * 
 * @author 杨帆
 *
 */
@Embeddable
public class Name {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 全拼，姓名完整拼音
	 * 
	 * 例如：xiaolongxia(小龙虾)
	 */
	private String fullSpell;
	
	/**
	 * 短拼，姓名拼音首字母缩写
	 * 
	 * 例如：xlx(小龙虾)
	 */
	private String shortSpell;

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

	/**
	 * 全拼，姓名完整拼音
	 * 
	 * 例如：xiaolongxia(小龙虾)
	 * 
	 * @return
	 */
	public String getFullSpell() {
		return fullSpell;
	}

	/**
	 * 全拼，姓名完整拼音
	 * 
	 * 例如：xiaolongxia(小龙虾)
	 * 
	 * @param fullSpell
	 */
	public void setFullSpell(String fullSpell) {
		this.fullSpell = fullSpell;
	}

	/**
	 * 短拼，姓名拼音首字母缩写
	 * 
	 * 例如：xlx(小龙虾)
	 * 
	 * @return
	 */
	public String getShortSpell() {
		return shortSpell;
	}

	/**
	 * 短拼，姓名拼音首字母缩写
	 * 
	 * 例如：xlx(小龙虾)
	 * 
	 * @param shortSpell
	 */
	public void setShortSpell(String shortSpell) {
		this.shortSpell = shortSpell;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fullSpell == null) ? 0 : fullSpell.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((shortSpell == null) ? 0 : shortSpell.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (fullSpell == null) {
			if (other.fullSpell != null)
				return false;
		} else if (!fullSpell.equals(other.fullSpell))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (shortSpell == null) {
			if (other.shortSpell != null)
				return false;
		} else if (!shortSpell.equals(other.shortSpell))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name [name=").append(name).append(", fullSpell=")
				.append(fullSpell).append(", shortSpell=").append(shortSpell)
				.append("]");
		return builder.toString();
	}
	
}
