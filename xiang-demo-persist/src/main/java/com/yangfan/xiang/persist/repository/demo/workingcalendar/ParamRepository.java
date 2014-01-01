package com.yangfan.xiang.persist.repository.demo.workingcalendar;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.model.po.demo.workingcalendar.Param;

public interface ParamRepository extends CoreRepository<Param, Long> {
	
	@Query("select p from Param p join p.paramType t where t.type = :paramType")
	public List<Param> findParamListByParamType(
			@org.springframework.data.repository.query.Param("paramType") String paramType);
	
	@Query("select p from Param p join p.paramType t where p.code = :code and t.type = :paramType")
	public Param findByCodeAndParamType(
			@org.springframework.data.repository.query.Param("code") String code, 
			@org.springframework.data.repository.query.Param("paramType") String paramType);

}
