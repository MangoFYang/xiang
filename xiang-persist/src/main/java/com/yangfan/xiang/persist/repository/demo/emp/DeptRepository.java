package com.yangfan.xiang.persist.repository.demo.emp;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.domain.demo.emp.Dept;

public interface DeptRepository extends CoreRepository<Dept, String> {
	
	Dept findByDeptNo(Integer deptNo);

}
