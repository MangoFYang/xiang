package com.yangfan.xiang.model.po.demo.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yangfan.xiang.core.po.CorePo;

/**
 * 客户
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_CUSTOMER")
public class Customer extends CorePo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1159065467482946135L;
	
	/**
	 * 客户名
	 */
	private String name;
	
	/**
	 * 客户的订单
	 */
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer", targetEntity=Order.class)
	private List<Order> orders = new ArrayList<Order>();

	/**
	 * 客户名
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 客户名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 客户的订单
	 * 
	 * @return
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * 客户的订单
	 * 
	 * @param orders
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [name=").append(name).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}

}
