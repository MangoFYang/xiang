package com.yangfan.xiang.service.impl.demo.authority;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yangfan.xiang.core.vo.TreeNodeVo;
import com.yangfan.xiang.service.BaseServiceTest;
import com.yangfan.xiang.service.iface.demo.authority.MenuService;

public class MenuServiceImplTest extends BaseServiceTest {
	
	@Resource
	private MenuService menuService;

	@Test
	public void testBuildMenuTree() {
		List<TreeNodeVo> buildMenuTree = menuService.buildMenuTree();
		System.out.println(buildMenuTree);
	}

}
