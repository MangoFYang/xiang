package com.yangfan.xiang.model.po.demo.work;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 作者
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_AUTHOR")
public class Author extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1150103321822588243L;

	/**
	 * 别名
	 */
	private String alias;
	
	/**
	 * 作品
	 * 
	 * 声明作者和作品为多对多关系，mappedBy表示此关系的定义和维护由对方实现。
	 * 双向关系一定要设置mappedBy属性
	 */
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="authors")
	private Set<Work> works = new HashSet<Work>();

	/**
	 * 别名
	 * 
	 * @return
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * 别名
	 * 
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * 作品
	 * 
	 * @return
	 */
	public Set<Work> getWorks() {
		return works;
	}

	/**
	 * 作品
	 * 
	 * @param works
	 */
	public void setWorks(Set<Work> works) {
		this.works = works;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [alias=").append(alias).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}
	
}
