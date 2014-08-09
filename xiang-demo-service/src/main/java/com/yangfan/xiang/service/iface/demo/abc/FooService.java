package com.yangfan.xiang.service.iface.demo.abc;

import org.springframework.data.domain.Page;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.core.web.vo.CoreRequest;
import com.yangfan.xiang.model.po.demo.abc.Foo;


public interface FooService extends CoreService<Foo, Long> {
	
	public Page<Foo> findAll(CoreRequest coreRequest);
	
	public Foo update(Foo foo);

}
