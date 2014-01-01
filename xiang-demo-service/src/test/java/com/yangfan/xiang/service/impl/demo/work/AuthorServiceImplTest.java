package com.yangfan.xiang.service.impl.demo.work;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.model.po.demo.work.Author;
import com.yangfan.xiang.service.iface.demo.work.AuthorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class AuthorServiceImplTest {
	
	@Resource
	private AuthorService authorService;

	@Test
	public void testSaveAndFlush() {
		Author a1 = new Author();
		a1.setName("杨帆");
		a1.setAlias("香");
		authorService.saveAndFlush(a1);
		System.out.println(a1);
	}

}
