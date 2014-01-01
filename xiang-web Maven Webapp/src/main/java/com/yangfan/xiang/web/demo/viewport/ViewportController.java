package com.yangfan.xiang.web.demo.viewport;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangfan.xiang.core.vo.TreeNodeVo;
import com.yangfan.xiang.service.iface.demo.authority.MenuService;

@Controller
@RequestMapping("/demo/ViewportController")
public class ViewportController {
	
	@Resource
	private MenuService menuService;

	@RequestMapping("/navigator")
	@ResponseBody
	public List<TreeNodeVo> navigator() {
		List<TreeNodeVo> menuTree = menuService.buildMenuTree();
		return menuTree;
	}
	
}
