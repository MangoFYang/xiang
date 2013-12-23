package com.yangfan.xiang.service.impl.demo.authority;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.domain.demo.authority.Menu;
import com.yangfan.xiang.persist.repository.demo.authority.MenuRepository;
import com.yangfan.xiang.service.iface.demo.authority.MenuService;
import com.yangfan.xiang.vo.demo.TreeNode;

@Service
public class MenuServiceImpl extends CoreServiceSupport<Menu, String> implements MenuService {
	
	@Resource
	private MenuRepository menuRepository;

	@Override
	protected CoreRepository<Menu, String> getRepository() {
		return menuRepository;
	}

	public List<TreeNode> buildMenuTree() {
		// 存放构建完成的菜单树
		List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
		// 查询所有菜单
		List<Menu> menuList = this.findAll(new Sort(new Order("order")));
		if(menuList != null) {
			List<Menu> rootNodeList = this.findRootNode(menuList);
			for (Menu root : rootNodeList) {
				TreeNode treeNode = this.menu2TreeNode(root);
				treeNodeList.add(treeNode);
				this.fillChildrenNode(treeNode, root, menuList);
			}
		}
		return treeNodeList;
	}
	
	/**
	 * 填充子节点
	 * 
	 * @param parentNode
	 * @param parentMenu
	 * @param menuList
	 */
	private void fillChildrenNode(TreeNode parentNode, Menu parentMenu, List<Menu> menuList) {
		for (Menu menu : menuList) {
			if(parentMenu == menu.getParent()) {
				TreeNode childNode = this.menu2TreeNode(menu);
				parentNode.getChildren().add(childNode);
				if(!menu.getLeaf()) {
					this.fillChildrenNode(childNode, menu, menuList);
				}
			}
		}
	}
	
	/**
	 * 查询根节点
	 * 
	 * @return 所有根节点
	 */
	private List<Menu> findRootNode(List<Menu> menuList) {
		List<Menu> roots = new ArrayList<Menu>();
		for (Menu menu : menuList) {
			if(menu.getParent() == null) {
				roots.add(menu);
			}
		}
		return roots;
	}
	
	/**
	 * 将菜单转化成树节点
	 * 
	 * @param menu
	 * @return
	 */
	private TreeNode menu2TreeNode(Menu menu) {
		TreeNode node = new TreeNode();
		node.setId(menu.getId());
		node.setText(menu.getName());
		node.setLeaf(menu.getLeaf());
		node.setExpanded(menu.getExpanded());
		node.putExtraData("viewName", menu.getViewName());
		return node;
	}

}