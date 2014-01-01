package com.yangfan.xiang.service.impl.demo.abc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.persist.repository.demo.abc.FooRepository;
import com.yangfan.xiang.service.iface.demo.abc.FooService;

@Service
public class FooServiceImpl extends CoreServiceSupport<Foo, Long> implements FooService {
	
	@Resource
	private FooRepository fooRepository;

	@Override
	protected CoreRepository<Foo, Long> getRepository() {
		return fooRepository;
	}

}
