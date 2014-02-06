package com.yangfan.xiang.persist.mapper.demo.emp;

import javax.annotation.Resource;

import org.junit.Test;

import com.yangfan.xiang.model.po.demo.emp.Dept;
import com.yangfan.xiang.test.CoreTest;

public class DeptMapperTest extends CoreTest {
	
	@Resource
	private DeptMapper deptMapper;

	@Test
	public void testSavePojo() {
		Dept dept = new Dept();
		dept.setDeptNo(1005);
		dept.setDeptName("name1005");
		dept.setLoc("loc1005");
		deptMapper.savePojo(dept);
	}

}
