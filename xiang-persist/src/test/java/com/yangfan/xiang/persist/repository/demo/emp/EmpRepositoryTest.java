package com.yangfan.xiang.persist.repository.demo.emp;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.emp.Dept;
import com.yangfan.xiang.domain.demo.emp.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-persist.xml")
public class EmpRepositoryTest {
	
	@Resource
	private EmpRepository empRepository;

	@Test
	public void testFindByEmpNo() {
		List<Emp> findTest = empRepository.findEmpAndDept();
		System.out.println(findTest);
	}
	
	@Test
	public void testFindAll() {
		List<Emp> findAll = empRepository.findAll();
		System.out.println(findAll);
	}

	@Test
	public void testFindByMgrIsNull() {
	}

	@Test
	public void testFindSubordinatesById() {
	}

	@Test
	public void testFindIdByEmpNo() {
	}

	@Test
	public void testFindEmpNoById() {
	}
	
	@Test
	public void testFindDeptByEmpNo() {
		Dept findDeptByEmpNo = empRepository.findDeptByEmpNo(7839);
		System.out.println(findDeptByEmpNo);
	}

}
