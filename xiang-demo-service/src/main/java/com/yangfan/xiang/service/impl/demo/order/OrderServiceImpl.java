package com.yangfan.xiang.service.impl.demo.order;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.order.LineItem;
import com.yangfan.xiang.model.po.demo.order.Order;
import com.yangfan.xiang.persist.repository.demo.order.OrderRepository;
import com.yangfan.xiang.service.iface.demo.order.CustomerService;
import com.yangfan.xiang.service.iface.demo.order.OrderService;
import com.yangfan.xiang.service.iface.demo.order.ProductService;

@Service
public class OrderServiceImpl extends CoreServiceSupport<Order, String> implements OrderService {

	@Resource
	private OrderRepository orderRepository;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private CustomerService customerService;
	
	@Override
	protected CoreRepository<Order, String> getRepository() {
		return orderRepository;
	}
	
	/**
	 * 校验order方法输入参数
	 * 
	 * @param customerId
	 * @param lineItemList
	 */
	private void checkInput4Order(String customerId, List<LineItem> lineItemList) {
		Assert.notNull(customerId, "[断言失败] - customerId(客户标识)不能为null");
		Assert.notNull(lineItemList, "[断言失败] - lineItemList(订单项列表)不能为null");
		for (LineItem lineItem : lineItemList) {
			Assert.notNull(lineItem.getQuantity(), "[断言失败] - lineItem.getQuantity()(商品数量)不能为null");
			Assert.notNull(lineItem.getProduct(), "[断言失败] - lineItem.getProduct()(商品)不能为null");
			Assert.notNull(lineItem.getProduct().getId(), "[断言失败] - lineItem.getProduct().getId()(商品标识)不能为null");
		}
	}
	
	@Override
	public void order(String customerId, List<LineItem> lineItemList) {
		// 输入校验
		this.checkInput4Order(customerId, lineItemList);
		
		Order o = new Order();
		o.setOrderDate(new Date());
		
		// 订单项和设置产品的关联关系、订单项和订单的关联关系。
		for (LineItem lineItem : lineItemList) {
			lineItem.setProduct(productService.findOne(lineItem.getProduct().getId()));
			lineItem.setOrder(o);
			o.getLineItems().add(lineItem);
		}
		
		// 设置订单和客户的关联关系
		o.setCustomer(customerService.findOne(customerId));
		
		// 保存订单
		orderRepository.save(o);
	}

}
