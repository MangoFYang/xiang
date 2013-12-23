package com.yangfan.xiang.persist.repository.demo.order;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yangfan.xiang.domain.demo.order.LineItem;
import com.yangfan.xiang.domain.demo.order.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-persist.xml")
public class OrderRepositoryTest {
	
	@Resource
	private OrderRepository orderRepository;
	
	@Resource
	private CustomerRepository customerRepository;
	
	@Resource
	private ProductRepository productRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void testSaveAndFlush() {
		Order o = new Order();
		o.setOrderDate(new Date());
		
		LineItem li1 = new LineItem();
		li1.setQuantity(3);
		li1.setProduct(productRepository.findOne("65119969-322b-41b0-9874-9dd5e147faa0"));
		li1.setOrder(o);
		o.getLineItems().add(li1);
		o.setCustomer(customerRepository.findOne("3978d2d2-a488-4476-bfab-0b6a4bc6459e"));
		
		orderRepository.saveAndFlush(o);
	}
	
}
