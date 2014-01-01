package com.yangfan.xiang.service.iface.demo.authority;

import java.util.List;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.core.vo.TreeNodeVo;
import com.yangfan.xiang.model.po.demo.authority.Menu;

public interface MenuService extends CoreService<Menu, String> {
	
	/**
	 * 构建菜单树
	 * 
	 * @return
	 */
	public List<TreeNodeVo> buildMenuTree();
	
}
