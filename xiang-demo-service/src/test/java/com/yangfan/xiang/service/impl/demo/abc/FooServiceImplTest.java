package com.yangfan.xiang.service.impl.demo.abc;

import javax.annotation.Resource;

import org.junit.Test;

import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.service.BaseServiceTest;
import com.yangfan.xiang.service.iface.demo.abc.FooService;

public class FooServiceImplTest extends BaseServiceTest {
	
	@Resource
	private FooService fooService;

	@Test
	public void testFindOne() {
		Foo findOne = fooService.findOne(1L);
		System.out.println(findOne);
	}

}
