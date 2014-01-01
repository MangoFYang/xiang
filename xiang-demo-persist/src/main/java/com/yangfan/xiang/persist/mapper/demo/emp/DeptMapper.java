package com.yangfan.xiang.persist.mapper.demo.emp;

import com.yangfan.xiang.model.po.demo.emp.Dept;


public interface DeptMapper {
	
	/**
	 * 保存pojo对象，不考虑对象之间的关系。
	 * 
	 * @param dept
	 */
	void savePojo(Dept dept);
	
}
