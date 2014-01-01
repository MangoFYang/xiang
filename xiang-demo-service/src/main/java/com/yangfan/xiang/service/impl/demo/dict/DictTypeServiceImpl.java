package com.yangfan.xiang.service.impl.demo.dict;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.dict.DictType;
import com.yangfan.xiang.persist.repository.demo.dict.DictTypeRepository;
import com.yangfan.xiang.service.iface.demo.dict.DictTypeService;

@Service
public class DictTypeServiceImpl extends CoreServiceSupport<DictType, String> implements DictTypeService {
	
	@Resource
	private DictTypeRepository dictTypeRepository;

	@Override
	protected CoreRepository<DictType, String> getRepository() {
		return dictTypeRepository;
	}

}
