package com.yangfan.xiang.service.iface.demo.emp;

import java.util.List;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.domain.demo.emp.Emp;
import com.yangfan.xiang.domain.demo.emp.SalGrade;

public interface EmpService extends CoreService<Emp, String> {
	
	Emp findByEmpNo(Integer empNo);
	
	List<Emp> findByMgrIsNull();
	
	List<Emp> findSubordinatesByMgr(String mgrId);

	List<Emp> findSubordinatesByEmpNo(Integer empNo);
	
	SalGrade findSalGradeByEmpNo(Integer empNo);
	
	Integer findEmpNoById(String id);
	
}
