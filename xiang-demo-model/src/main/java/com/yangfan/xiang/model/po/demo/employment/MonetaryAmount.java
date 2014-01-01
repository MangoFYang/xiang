package com.yangfan.xiang.model.po.demo.employment;

import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Embeddable;

/**
 * 货币数量
 * 
 * @author 杨帆
 *
 */
@Embeddable
public class MonetaryAmount {
	
	/**
	 * 数量
	 */
	private BigDecimal amount;
	
	/**
	 * 货币
	 */
	private Currency currency;

	/**
	 * 数量
	 * 
	 * @return
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * 数量
	 * 
	 * @param amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * 货币
	 * 
	 * @return
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * 货币
	 * 
	 * @param currency
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MonetaryAmount [amount=").append(amount)
				.append(", currency=").append(currency).append("]");
		return builder.toString();
	}
	
}
