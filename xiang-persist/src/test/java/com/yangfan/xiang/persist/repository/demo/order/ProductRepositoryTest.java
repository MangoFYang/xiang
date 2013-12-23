package com.yangfan.xiang.persist.repository.demo.order;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.order.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-persist.xml")
public class ProductRepositoryTest {
	
	@Resource
	private ProductRepository productRepository;

	@Test
	public void testSaveAndFlush() {
		Product p1 = new Product();
		p1.setName("益达无糖口香糖");
		productRepository.saveAndFlush(p1);
		
		Product p2 = new Product();
		p2.setName("汇源肾宝，他好我也好。");
		productRepository.saveAndFlush(p2);
		
		Product p3 = new Product();
		p3.setName("汇源果汁，喝前摇一摇。");
		productRepository.saveAndFlush(p3);
		
		Product p4 = new Product();
		p4.setName("BYD，Build Your Dreams，洗洗更健康。");
		productRepository.saveAndFlush(p4);
	}

	@Test
	public void testFindOneID() {
		// productRepository.findOne(id);
	}

}
