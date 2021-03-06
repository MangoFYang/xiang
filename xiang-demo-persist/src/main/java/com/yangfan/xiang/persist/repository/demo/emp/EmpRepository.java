package com.yangfan.xiang.persist.repository.demo.emp;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.model.po.demo.emp.Dept;
import com.yangfan.xiang.model.po.demo.emp.Emp;

public interface EmpRepository extends CoreRepository<Emp, String> {
	
	Emp findByEmpNo(Integer empNo);
	
	@Query(value="select e from Emp e where e.mgr is null")
	List<Emp> findByMgrIsNull();

	@Query("select e from Emp e where e.mgr.id = :id")
	List<Emp> findSubordinatesById(@Param("id") String id);
	
	@Query("select e.id from Emp e where e.empNo = :empNo")
	String findIdByEmpNo(@Param("empNo") Integer empNo);
	
	@Query("select e.empNo from Emp e where e.id = :id")
	Integer findEmpNoById(@Param("id") String id);
	
	@Query("select e from Emp e left join fetch e.dept d")
	List<Emp> findEmpAndDept();
	
	/**
	 * 获取指定员工的部门
	 * 
	 * @param empNo 员工标识
	 * @return
	 */
	@Query("select e.dept from Emp e where e.empNo = :empNo")
	Dept findDeptByEmpNo(@Param("empNo") Integer empNo);
	
}
