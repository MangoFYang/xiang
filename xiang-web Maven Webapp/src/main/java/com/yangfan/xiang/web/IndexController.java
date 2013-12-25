package com.yangfan.xiang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * 
	 * mapping for index
	 * 
	 */
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
}
