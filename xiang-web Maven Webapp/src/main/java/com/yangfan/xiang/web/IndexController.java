package com.yangfan.xiang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
	
	
	
	public String bbb() {
		return null;
	}
	
}
