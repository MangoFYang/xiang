package com.yangfan.xiang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * 
	 * mapping for index
	 * 
	 * change this for test
	 * 
	 */
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
	public String test() {
		return null;
	}
	
}
