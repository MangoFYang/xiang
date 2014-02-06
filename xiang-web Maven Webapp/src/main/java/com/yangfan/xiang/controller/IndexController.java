package com.yangfan.xiang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "It is worked !";
	}
	
	@RequestMapping(value="/json", produces="application/json")
	@ResponseBody
	public List<String> json() {
		List<String> list = new ArrayList<String>();
		list.add("s1");
		list.add("s2");
		list.add("s3");
		return list;
	}
	
}
