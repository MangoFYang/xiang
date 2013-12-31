package com.yangfan.xiang.core.po;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * 
 * VersionPo抽象类
 * 
 * 支持乐观锁
 * 
 * 内置属性:
 * id: 标识，使用UUID。
 * status: 状态，有效/无效。
 * version: 版本号，用于乐观锁。
 * 
 * @author 杨帆
 *
 */
@MappedSuperclass
public abstract class VersionPo extends CorePo {
	
	private static final long serialVersionUID = -2561720478176048205L;

	/**
	 * 版本号，用于乐观锁。
	 */
	@Version
	protected Integer version;

	/**
	 * 版本号，用于乐观锁。
	 * 
	 * @return
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本号，用于乐观锁。
	 * 
	 * @param version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersionPo other = (VersionPo) obj;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VersionPo [version=");
		builder.append(version);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
