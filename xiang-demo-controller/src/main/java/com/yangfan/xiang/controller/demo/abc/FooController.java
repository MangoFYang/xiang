package com.yangfan.xiang.controller.demo.abc;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangfan.xiang.core.web.domain.CoreRequest;
import com.yangfan.xiang.core.web.domain.CoreResponse;
import com.yangfan.xiang.core.web.support.CoreResponseFactory;
import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.service.iface.demo.abc.FooService;

@Controller
@RequestMapping("/demo/abc/FooController")
public class FooController {
	
	@Resource
	private FooService fooService;

	@RequestMapping("/index")
	@ResponseBody
	public CoreResponse index(CoreRequest coreRequest) {
		Page<Foo> findAll = fooService.findAll(coreRequest.getPageable());
		return CoreResponseFactory.createCoreResponse(coreRequest, findAll);
	}
	
}
