package com.yangfan.xiang.controller.demo.abc;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.service.iface.demo.abc.FooService;

@Controller
@RequestMapping("/demo/abc/FooController")
public class FooController {
	
	@Resource
	private FooService fooService;

	@RequestMapping("/index")
	@ResponseBody
	public Page<Foo> index(Pageable pageable) {
		Page<Foo> findAll = fooService.findAll(pageable);
		return findAll;
	}
	
}
