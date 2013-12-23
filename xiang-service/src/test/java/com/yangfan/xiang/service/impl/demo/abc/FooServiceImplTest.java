package com.yangfan.xiang.service.impl.demo.abc;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.abc.Foo;
import com.yangfan.xiang.service.iface.demo.abc.FooService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class FooServiceImplTest {
	
	@Resource
	private FooService fooService;

	@Test
	public void testFindOne() {
		Foo findOne = fooService.findOne("680a05bc-1cd5-4a5f-9728-c798d7f8a18f");
		System.out.println(findOne);
	}

}
