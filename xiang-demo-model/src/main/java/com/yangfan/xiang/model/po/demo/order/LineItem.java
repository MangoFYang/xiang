package com.yangfan.xiang.model.po.demo.order;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yangfan.xiang.core.po.CorePo;

@Entity
@Table(name="DEMO_LINEITEM")
public class LineItem extends CorePo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1573635636270812763L;

	/**
	 * 商品数量
	 */
	private Integer quantity;
	
	/**
	 * 订单
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id", nullable=false)
	private Order order;
	
	/**
	 * 商品
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id", nullable=false)
	private Product product;

	/**
	 * 商品数量
	 * 
	 * @return
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 商品数量
	 * 
	 * @param quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 订单
	 * 
	 * @return
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * 订单
	 * 
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * 商品
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 商品
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineItem [quantity=").append(quantity)
				.append(", toString()=").append(super.toString()).append("]");
		return builder.toString();
	}

}
