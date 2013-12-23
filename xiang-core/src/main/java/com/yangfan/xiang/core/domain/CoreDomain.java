package com.yangfan.xiang.core.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * 
 * 酷睿Domain抽象类
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
public abstract class CoreDomain extends IdDomain {
	
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoreDomain [version=").append(version)
				.append(", toString()=").append(super.toString()).append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoreDomain other = (CoreDomain) obj;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
