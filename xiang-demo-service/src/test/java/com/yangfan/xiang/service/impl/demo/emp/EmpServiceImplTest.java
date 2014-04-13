package com.yangfan.xiang.service.impl.demo.emp;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.model.po.demo.emp.Dept;
import com.yangfan.xiang.model.po.demo.emp.Emp;
import com.yangfan.xiang.model.po.demo.emp.SalGrade;
import com.yangfan.xiang.service.iface.demo.emp.EmpService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class EmpServiceImplTest {
	
	@Resource
	private EmpService empService;

	@Test
	public void testFindByEmpNo() {
		Emp findByEmpNo = empService.findByEmpNo(7369);
		System.out.println(findByEmpNo);
	}

	@Test
	public void testFindAll() {
		List<Emp> findAll = empService.findAll();
		System.out.println(findAll);
	}

	@Test
	public void testFindAllPageable() {
		Page<Emp> findAll = empService.findAll(new PageRequest(2, 5));
		System.out.println(findAll);
	}
	
	@Test
	public void testFindByMgrIsNull() {
		List<Emp> findByMgrIsNull = empService.findByMgrIsNull();
		for (Iterator<Emp> iterator = findByMgrIsNull.iterator(); iterator.hasNext();) {
			Emp emp = iterator.next();
			System.out.println(emp);
		}
	}
	
	@Test
	public void testFindEmpSubordinatesByEmpNo() {
		List<Emp> findCByByEmpNo = empService.findSubordinatesByEmpNo(7839);
		for (Iterator<Emp> iterator = findCByByEmpNo.iterator(); iterator.hasNext();) {
			Emp emp = iterator.next();
			System.out.println(emp);
		}
	}
	
	@Test
	public void testFindSalGradeByEmpNo() {
		SalGrade findSalGradeByEmpNo = empService.findSalGradeByEmpNo(7839);
		System.out.println(findSalGradeByEmpNo);
	}
	
	@Test
	public void testFindEmpNoById() {
		Integer findEmpNoById = empService.findEmpNoById("4ed83a30-590a-4875-bdaf-6b5c87ef78f9");
		System.out.println(findEmpNoById);
	}
	
	@Test
	public void testSavePojo() {
		Emp emp = new Emp();
		emp.setEmpNo(9999);
		emp.seteName("en9999");
		emp.setComm(99.9);
		
		Dept dept = new Dept();
		dept.setDeptNo(10);
		emp.setDept(dept);
		
		empService.save(emp);
	}
	
}
