package com.yangfan.xiang.core.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * 支持id和status属性的Domain抽象类，如果不需要乐观锁时可继承此类，需要乐观锁时继承CoreDomain
 * 
 * @author 杨帆
 *
 */
@MappedSuperclass
public abstract class IdDomain implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8848287461948410810L;
	
	/**
	 * 主键，所有表都必须有主键，并且主键字段名为id。
	 */
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy = "uuid2")
	protected String id;
	
	/**
	 * 状态，有效/无效。
	 */
	protected Boolean status = true;

	/**
	 * 主键
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 主键
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 状态，有效/无效。
	 * 
	 * @return
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * 状态，有效/无效。
	 * 
	 * @param status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IdDomain [id=").append(id).append(", status=")
				.append(status).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		IdDomain other = (IdDomain) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
