package com.yangfan.xiang.service.impl.demo.emp;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.core.web.PageRequest;
import com.yangfan.xiang.domain.demo.emp.Dept;
import com.yangfan.xiang.service.iface.demo.emp.DeptService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class DeptServiceImplTest {
	
	@Resource
	private DeptService deptService;

	@Test
	public void testFindAll() {
		List<Dept> findAll = deptService.findAll();
		for (Iterator<Dept> iterator = findAll.iterator(); iterator.hasNext();) {
			Dept dept = iterator.next();
			System.out.println(dept);
		}
	}
	
	@Test
	public void testFindAllPageable() {
		Page<Dept> findAll = deptService.findAll(new PageRequest(1, 2));
		System.out.println(findAll.getContent());
	}
	
	@Test
	public void testFindByWhere() {
		Dept dept = new Dept();
		dept.setDeptName("s");
		final Page<Dept> findByWhere = deptService.findByWhere(dept, new PageRequest(4, 1));
		for (Dept dept2 : findByWhere) {
			System.out.println(dept2);
		}
	}
	
	@Test
	public void testSavePojo() {
		Dept d = new Dept();
		d.setDeptNo(99);
		d.setDeptName("n99");
		d.setLoc("l99");
		deptService.savePojo(d);
	}
	
}
