package com.yangfan.xiang.service.impl.demo.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.order.LineItem;
import com.yangfan.xiang.domain.demo.order.Product;
import com.yangfan.xiang.service.iface.demo.order.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class OrderServiceImplTest {
	
	@Resource
	private OrderService orderService;

	@Test
	public void testOrder() {
		
		// 客户标识(ssj)
		String customerId = "041c3af2-b8d8-44be-93f1-8cfea1e9469d";
		
		// 购买商品列表
		List<LineItem> lineItemList = new ArrayList<LineItem>();
		
		// 5个商品1ae9f1a8-7e84-4294-a775-ededd124f56a(BYD，Build Your Dreams，洗洗更健康。)
		LineItem li1 = new LineItem();
		li1.setQuantity(5);
		Product p1 = new Product();
		p1.setId("1ae9f1a8-7e84-4294-a775-ededd124f56a");
		li1.setProduct(p1);

		// 2个商品e3ac55e3-0a2a-4360-9899-951693350dbe(汇源肾宝，他好我也好。)
		LineItem li2 = new LineItem();
		li2.setQuantity(2);
		Product p2 = new Product();
		p2.setId("e3ac55e3-0a2a-4360-9899-951693350dbe");
		li2.setProduct(p2);
		
		// 将商品加入商品列表
		lineItemList.add(li1);
		lineItemList.add(li2);
		
		orderService.order(customerId, lineItemList);
	}

}
