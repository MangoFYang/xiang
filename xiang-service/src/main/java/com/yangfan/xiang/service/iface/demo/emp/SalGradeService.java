package com.yangfan.xiang.service.iface.demo.emp;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.domain.demo.emp.SalGrade;

public interface SalGradeService extends CoreService<SalGrade, Integer>  {
	
	/**
	 * 根据等级属性查询薪资等级对象，不查询数据库
	 * 
	 * @param grade
	 * @return
	 */
	SalGrade findByGradeFromCache(Integer grade);
	
	/**
	 * 查询指定薪水所在的薪资等级
	 * 
	 * @param sal
	 * @return
	 */
	SalGrade findByLosalGreaterThanAndHisalLessThan(Double sal);

	SalGrade findOne(Integer grade);
	
	/**
	 * 保存pojo对象，不考虑对象之间的关系。
	 * 
	 * @param salGrade
	 */
	void savePojo(SalGrade salGrade);
	
}
