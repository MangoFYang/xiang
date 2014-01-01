package com.yangfan.xiang.service.iface.demo.emp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.model.po.demo.emp.Dept;

public interface DeptService extends CoreService<Dept, String> {
	
	Dept findByDeptNo(Integer deptNo);
	
	void savePojo(Dept dept);
	
	public Page<Dept> findByWhere(Dept dept, Pageable pageable);
	
}
