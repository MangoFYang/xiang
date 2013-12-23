package com.yangfan.xiang.persist.repository.demo.abc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.abc.Foo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-persist.xml")
public class FooRepositoryTest {
	
	@Resource
	private FooRepository fooRepository;

	@Test
	public void testSaveS() {
		Foo foo = new Foo();
		foo.setBigDecimalField(new BigDecimal("12345.6789"));
		foo.setDateField(new Date());
		foo.setDoubleBoxField(1.0001);
		Foo save = fooRepository.save(foo);
		System.out.println(save);
	}
	
	@Test
	public void testFindAll() {
		List<Foo> findAll = fooRepository.findAll();
		for (Foo foo : findAll) {
			System.out.println(foo);
		}
	}	

}
