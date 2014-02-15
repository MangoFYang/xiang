package com.yangfan.xiang.service.impl.demo.abc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.domain.Page;

import com.yangfan.xiang.core.web.PageRequest;
import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.service.iface.demo.abc.FooService;
import com.yangfan.xiang.test.CoreTest;

public class FooServiceImplTest extends CoreTest {
	
	@Resource
	private FooService fooService;

	@Test
	public void testFindOne() {
		Foo findOne = fooService.findOne(1L);
		System.out.println(findOne);
	}
	
	@Test
	public void testFindAllPageable() {
		Page<Foo> findAll = fooService.findAll(new PageRequest(1, 2));
		System.out.println(findAll);
	}
	
	@Test
	public void test() {
		List<Foo> fooList = new ArrayList<Foo>();
		for (int i = 0; i < 100; i++) {
			Foo foo = new Foo();
			foo.setBigDecimalField(new BigDecimal("3.693693").add(new BigDecimal(i)));
			foo.setDateField(new Date());
			foo.setDoubleBoxField(1.2 + i);
			foo.setDoubleField(1.999 + i);
			foo.setIntegerField(9000 + i);
			foo.setIntField(999 + i);
			foo.setStringField("111strstr111" + i);
			fooList.add(foo);
		}
		fooService.save(fooList);
	}

}
