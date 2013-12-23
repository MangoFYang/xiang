package com.yangfan.xiang.service.iface.demo.order;

import java.util.List;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.domain.demo.order.LineItem;
import com.yangfan.xiang.domain.demo.order.Order;

public interface OrderService extends CoreService<Order, String> {
	
	/**
	 * 下订单
	 * 
	 * 输入校验：
	 * <pre>
		Assert.notNull(customerId, "[断言失败] - customerId(客户标识)不能为空");
		Assert.notNull(lineItemList, "[断言失败] - lineItemList(订单项列表)不能为空");
		for (LineItem lineItem : lineItemList) {
			Assert.notNull(lineItem.getQuantity(), "[断言失败] - lineItem.getQuantity()(商品数量)不能为空");
			Assert.notNull(lineItem.getProduct(), "[断言失败] - lineItem.getProduct()(商品)不能为空");
			Assert.notNull(lineItem.getProduct().getId(), "[断言失败] - lineItem.getProduct().getId()(商品标识)不能为空");
		}
	 * </pre>
	 * @param customerId 客户标识
	 * @param lineItemList 订单项列表
	 */
	public void order(String customerId, List<LineItem> lineItemList);

}
