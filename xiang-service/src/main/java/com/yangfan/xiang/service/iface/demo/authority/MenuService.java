package com.yangfan.xiang.service.iface.demo.authority;

import java.util.List;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.domain.demo.authority.Menu;
import com.yangfan.xiang.vo.demo.TreeNode;

public interface MenuService extends CoreService<Menu, String> {
	
	/**
	 * 构建菜单树
	 * 
	 * @return
	 */
	public List<TreeNode> buildMenuTree();
	
}
