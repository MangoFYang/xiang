package com.yangfan.xiang.web.demo.abc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller接收并处理客户端的请求。
 * 
 * 请求映射为：/demo/abc/FooController，首个"/"代表项目根路径，比如：http://localhost:8080/xiang-web
 * 
 * Controller访问地址为：http://localhost:8080/xiang-web/demo/abc/FooController
 * 
 * @author 杨帆
 *
 */
@Controller
@RequestMapping("/demo/abc/FooController")
public class FooController {

	/**
	 * 请求映射为：/index
	 * 
	 * 此方法访问地址 = Controller访问地址 + 此方法的请求映射，如下：
	 * 
	 * http://localhost:8080/xiang-web/demo/abc/FooController/index
	 * 
	 * 返回字符串类型，代表视图资源。
	 * 
	 * @return 视图路径
	 */
	@RequestMapping("/index")
	public String index() {
		
		/*
		 * 返回视图资源。
		 * 项目中所有视图(JSP页面)都放在src/main/webapp/WEB-INF/views/jstl文件夹中，
		 * 所以返回的路径只需从此目录开始写起即可，
		 * 注意：必须以"/"开头，不用以".jsp"结尾。
		 * 
		 * 最后指向完整的JSP页面资源为：
		 * src/main/webapp/WEB-INF/views/jstl/demo/abc/index.jsp
		 */
		return "/demo/abc/index";
	}
	
}
