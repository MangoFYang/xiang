package com.yangfan.xiang.persist.repository.demo.abc;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.persist.BasePersistTest;

public class FooRepositoryTest extends BasePersistTest {
	
	@Resource
	private FooRepository fooRepository;

	@Test
	public final void testFindAll() {
		List<Foo> findAll = fooRepository.findAll();
		System.out.println(findAll);
	}
	
	@Test
	public void testFindOne() {
		Foo findOne = fooRepository.findOne(1L);
		System.out.println(findOne);
	}

	@Test
	public final void testSaveIterableOfS() {
	}

	@Test
	public final void testSaveAndFlush() {
		Foo foo = new Foo();
		foo.setBigDecimalField(new BigDecimal("3.693693"));
		foo.setDateField(new Date());
		foo.setDoubleBoxField(1.2);
		foo.setDoubleField(1.999);
		foo.setIntegerField(9000);
		foo.setIntField(999);
		foo.setStringField("111strstr111");
		Foo saveAndFlush = fooRepository.saveAndFlush(foo);
		assertNotNull(saveAndFlush);
	}

}
