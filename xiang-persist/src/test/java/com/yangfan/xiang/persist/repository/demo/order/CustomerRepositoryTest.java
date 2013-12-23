package com.yangfan.xiang.persist.repository.demo.order;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.order.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-persist.xml")
public class CustomerRepositoryTest {
	
	@Resource
	private CustomerRepository customerRepository;

	@Test
	public void testSaveAndFlush() {
		Customer c = new Customer();
		c.setName("香");
		customerRepository.saveAndFlush(c);
	}

	@Test
	public void testFindOne() {
		Customer findOne = customerRepository.findOne("3978d2d2-a488-4476-bfab-0b6a4bc6459e");
		System.out.println(findOne);
	}

}
