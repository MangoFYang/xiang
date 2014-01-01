package com.yangfan.xiang.persist.repository.demo.abc;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.persist.repository.BaseRepositoryTest;

public class FooRepositoryTest extends BaseRepositoryTest {
	
	@Resource
	private FooRepository fooRepository;

	@Test
	public final void testFindAll() {
		List<Foo> findAll = fooRepository.findAll();
		System.out.println(findAll);
	}

	@Test
	public final void testSaveIterableOfS() {
	}

	@Test
	public final void testSaveAndFlush() {
		Foo foo = new Foo();
		// foo.setBigDecimalField(new BigDecimal(1.23));
		foo.setDateField(new Date());
		foo.setDoubleBoxField(1.2);
		foo.setDoubleField(1.23);
		foo.setIntegerField(1000);
		foo.setIntField(22);
		foo.setStringField("str");
		Foo saveAndFlush = fooRepository.saveAndFlush(foo);
		assertNotNull(saveAndFlush);
	}

}
