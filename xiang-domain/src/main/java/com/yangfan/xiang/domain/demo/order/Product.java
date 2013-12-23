package com.yangfan.xiang.domain.demo.order;

import javax.persistence.Entity;

import com.yangfan.xiang.core.domain.CoreDomain;

/**
 * 商品
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_PRODUCT")
public class Product extends CoreDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6764386671620361958L;
	
	/**
	 * 商品名
	 */
	private String name;

	/**
	 * 商品名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 商品名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [name=").append(name).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}
	
}
