package com.yangfan.xiang.service.impl.demo.authority;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yangfan.xiang.core.vo.TreeNodeVo;
import com.yangfan.xiang.service.iface.demo.authority.MenuService;
import com.yangfan.xiang.test.CoreTest;

public class MenuServiceImplTest extends CoreTest {
	
	@Resource
	private MenuService menuService;

	@Test
	public void testBuildMenuTree() {
		List<TreeNodeVo> buildMenuTree = menuService.buildMenuTree();
		System.out.println(buildMenuTree);
	}

}
