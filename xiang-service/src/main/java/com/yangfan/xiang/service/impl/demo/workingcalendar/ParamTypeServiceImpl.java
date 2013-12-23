package com.yangfan.xiang.service.impl.demo.workingcalendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.domain.demo.workingcalendar.ParamType;
import com.yangfan.xiang.persist.repository.demo.workingcalendar.ParamTypeRepository;
import com.yangfan.xiang.service.iface.demo.workingcalendar.ParamTypeService;

@Service
public class ParamTypeServiceImpl extends CoreServiceSupport<ParamType, String> implements ParamTypeService {

	@Resource
	private ParamTypeRepository paramTypeRepository;
	
	@Override
	protected CoreRepository<ParamType, String> getRepository() {
		return paramTypeRepository;
	}
	
}
