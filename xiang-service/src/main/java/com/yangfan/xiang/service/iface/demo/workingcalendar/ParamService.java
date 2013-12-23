package com.yangfan.xiang.service.iface.demo.workingcalendar;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.domain.demo.workingcalendar.Param;

public interface ParamService extends CoreService<Param, Long> {
	
	public Page<Param> findByWhere(final Param param, Pageable pageable);
	
	public List<Param> findParamListByParamType(String paramType);
	
	public Param findByCodeAndParamType(String code, String paramType);

}
