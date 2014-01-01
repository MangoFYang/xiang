package com.yangfan.xiang.service.impl.demo.emp;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.model.po.demo.emp.SalGrade;
import com.yangfan.xiang.service.iface.demo.emp.SalGradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class SalGradeServiceImplTest {
	
	@Resource
	private SalGradeService salGradeService;
	
	@Test
	public void testFindOne() {
		SalGrade findOne = salGradeService.findOne(1);
		System.out.println(findOne);
	}

	@Test
	public void testFindAll() {
		List<SalGrade> findAll = salGradeService.findAll();
		for (Iterator<SalGrade> iterator = findAll.iterator(); iterator.hasNext();) {
			SalGrade salGrade = iterator.next();
			System.out.println(salGrade);
		}
	}
	
	@Test
	public void testFindByGrade() {
		SalGrade findByGrade = salGradeService.findByGradeFromCache(5);
		System.out.println(findByGrade);
	}
	
	@Test
	public void testFindByLosalGreaterThanAndHisalLessThan() {
		SalGrade findByGrade = salGradeService.findByLosalGreaterThanAndHisalLessThan((double)2001);
		System.out.println(findByGrade);
	}

	@Test
	public void testFindAllSort() {
	}

	@Test
	public void testSave() {
	}

	@Test
	public void testFlush() {
	}

	@Test
	public void testSaveAndFlush() {
	}

	@Test
	public void testDeleteInBatch() {
	}

	@Test
	public void testDeleteAllInBatch() {
	}

	@Test
	public void testFindAllPageable() {
	}

}
