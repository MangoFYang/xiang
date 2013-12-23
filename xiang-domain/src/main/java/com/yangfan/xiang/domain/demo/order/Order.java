package com.yangfan.xiang.domain.demo.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.yangfan.xiang.core.domain.CoreDomain;

/**
 * 订单
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_ORDER")
public class Order extends CoreDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -266256497973203765L;
	
	/**
	 * 订货时间
	 */
	private Date orderDate;
	
	/**
	 * 所属顾客
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
	
	/**
	 * 订单项
	 */
	@OneToMany(mappedBy="order", 
			fetch=FetchType.LAZY, 
			cascade={CascadeType.ALL},
			targetEntity=LineItem.class)
	private List<LineItem> lineItems = new ArrayList<LineItem>();

	/**
	 * 订货时间
	 * 
	 * @return
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * 订货时间
	 * 
	 * @param orderDate
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * 所属顾客
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * 所属顾客
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * 订单项
	 * 
	 * @return
	 */
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	/**
	 * 订单项
	 * 
	 * @param lineItems
	 */
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderDate=").append(orderDate)
				.append(", toString()=").append(super.toString()).append("]");
		return builder.toString();
	}

}
