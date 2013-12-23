package com.yangfan.xiang.domain.demo.dict;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 字典类型(字典的字典)
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_DICTTYPE")
public class DictType {
	
	/**
	 * 类型
	 */
	@Id
	@Column(length=60)
	private String type;
	
	/**
	 * 类型名
	 */
	@Column(unique=true, length=100)
	private String label;
	
	/**
	 * 字典集合
	 * 
	 * mappedBy属性说明将关系交由对方定义和维护
	 */
	@OneToMany(fetch=FetchType.LAZY, mappedBy="dictType", targetEntity=Dict.class)
	private Set<Dict> dicts = new HashSet<Dict>();

	/**
	 * 类型
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 类型
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 类型名
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 类型名
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 字典集合
	 * @return
	 */
	public Set<Dict> getDicts() {
		return dicts;
	}

	/**
	 * 字典集合
	 * @param dicts
	 */
	public void setDicts(Set<Dict> dicts) {
		this.dicts = dicts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DictType [type=").append(type).append(", label=")
				.append(label).append("]");
		return builder.toString();
	}

}
