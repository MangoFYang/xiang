package com.yangfan.xiang.persist.repository.demo.authority;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yangfan.xiang.domain.demo.authority.Menu;
import com.yangfan.xiang.persist.repository.BaseRepositoryTest;

public class MenuRepositoryTest extends BaseRepositoryTest {
	
	@Resource
	private MenuRepository menuRepository;
	
	@Test
	public void testFindRootNode() {
		
		List<Menu> findRootNode = menuRepository.findRootNode();
		System.out.println(findRootNode);
		
	}

	@Test
	public void testSaveAndFlush() {
		
		/*
		Menu root1 = new Menu();
		root1.setId("root1");
		root1.setName("概述");
		root1.setLeaf(false);
		root1.setDescription("概述");
		root1.setOrder(1);
		menuRepository.saveAndFlush(root1);
		
		Menu root11 = new Menu();
		root11.setId("root11");
		root11.setName("快速入门");
		root11.setLeaf(true);
		root11.setDescription("快速入门");
		root11.setParent(root1);
		root11.setOrder(1);
		menuRepository.saveAndFlush(root11);
		
		Menu root2 = new Menu();
		root2.setId("root2");
		root2.setName("概念");
		root2.setLeaf(false);
		root2.setDescription("概念");
		root2.setOrder(2);
		menuRepository.saveAndFlush(root2);
		
		Menu root21 = new Menu();
		root21.setId("root21");
		root21.setName("类系统");
		root21.setLeaf(true);
		root21.setDescription("类系统");
		root21.setParent(root2);
		root21.setOrder(1);
		menuRepository.saveAndFlush(root21);
		
		Menu root3 = new Menu();
		root3.setId("root3");
		root3.setName("组件");
		root3.setLeaf(false);
		root3.setDescription("组件");
		root3.setOrder(3);
		menuRepository.saveAndFlush(root3);
		
		Menu root31 = new Menu();
		root31.setId("root31");
		root31.setName("树");
		root31.setLeaf(true);
		root31.setDescription("树");
		root31.setParent(root3);
		root31.setOrder(1);
		menuRepository.saveAndFlush(root31);
		*/
		
		Menu root4 = new Menu();
		root4.setId("WorkingCalendar");
		root4.setName("工作日历管理");
		root4.setLeaf(false);
		root4.setDescription("工作日历管理");
		root4.setOrder(0);
		menuRepository.saveAndFlush(root4);

		Menu root5 = new Menu();
		root5.setId("WorkingCalendarType");
		root5.setName("工作日历查询");
		root5.setLeaf(true);
		root5.setDescription("工作日历查询");
		root5.setParent(root4);
		root5.setOrder(1);
		menuRepository.saveAndFlush(root5);
		
		Menu root6 = new Menu();
		root6.setId("WorkingCalendarQuery");
		root6.setName("工作日历类型");
		root6.setLeaf(true);
		root6.setDescription("工作日历类型");
		root6.setParent(root4);
		root6.setOrder(2);
		menuRepository.saveAndFlush(root6);
		
	}

}
