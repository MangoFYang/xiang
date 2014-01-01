package com.yangfan.xiang.persist.mapper.demo.emp;

import com.yangfan.xiang.model.po.demo.emp.SalGrade;

/**
 * 
 * 
 * @author 杨帆
 *
 */
public interface SalGradeMapper {
	
	/**
	 * 保存pojo对象，不考虑对象之间的关系。
	 * 
	 * @param salGrade
	 */
	void savePojo(SalGrade salGrade);

}
