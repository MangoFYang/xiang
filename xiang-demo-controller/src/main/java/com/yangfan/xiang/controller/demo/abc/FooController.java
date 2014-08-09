package com.yangfan.xiang.controller.demo.abc;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangfan.xiang.core.web.support.ResponseFactory;
import com.yangfan.xiang.core.web.vo.CoreRequest;
import com.yangfan.xiang.core.web.vo.CoreResponse;
import com.yangfan.xiang.core.web.vo.SimpleResponse;
import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.model.vo.demo.abc.FooVo;
import com.yangfan.xiang.service.iface.demo.abc.FooService;

@Controller
@RequestMapping("/demo/abc/FooController")
public class FooController {
	
	@Resource
	private FooService fooService;

	@RequestMapping("/index")
	@ResponseBody
	public CoreResponse<Foo> index(CoreRequest coreRequest) {
		Page<Foo> findAll = fooService.findAll(coreRequest);
		CoreResponse<Foo> coreResponse = ResponseFactory.createCoreResponse(findAll);
		return coreResponse;
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public SimpleResponse<Foo> del(@RequestBody Foo foo) {
		fooService.delete(foo);
		SimpleResponse<Foo> simpleResponse = ResponseFactory.createSimpleResponse(true, "Deleted Foo");
		return simpleResponse;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public SimpleResponse<FooVo> update(@RequestBody FooVo fooVo) {
		fooService.update(fooVo.toFoo());
		SimpleResponse<FooVo> simpleResponse = ResponseFactory.createSimpleResponse(true, "Updated Foo");
		return simpleResponse;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public SimpleResponse<FooVo> create(@RequestBody FooVo fooVo) {
		Foo saved = fooService.save(fooVo.toFoo());
		fooVo.setId(saved.getId());
		SimpleResponse<FooVo> simpleResponse = ResponseFactory.createSimpleResponse(fooVo);
		return simpleResponse;
	}
	
}
