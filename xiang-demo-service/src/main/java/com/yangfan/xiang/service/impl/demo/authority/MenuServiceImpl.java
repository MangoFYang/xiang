package com.yangfan.xiang.service.impl.demo.authority;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.core.web.vo.TreeNodeVo;
import com.yangfan.xiang.model.po.demo.authority.Menu;
import com.yangfan.xiang.persist.repository.demo.authority.MenuRepository;
import com.yangfan.xiang.service.iface.demo.authority.MenuService;

@Service
public class MenuServiceImpl extends CoreServiceSupport<Menu, String> implements MenuService {
	
	@Resource
	private MenuRepository menuRepository;

	@Override
	protected CoreRepository<Menu, String> getRepository() {
		return menuRepository;
	}

	public List<TreeNodeVo> buildMenuTree() {
		// 存放构建完成的菜单树
		List<TreeNodeVo> treeNodeList = new ArrayList<TreeNodeVo>();
		// 查询所有菜单
		List<Menu> menuList = this.findAll(new Sort(new Order("order")));
		if(menuList != null) {
			List<Menu> rootNodeList = this.findRootNode(menuList);
			for (Menu root : rootNodeList) {
				TreeNodeVo treeNode = this.menu2TreeNode(root);
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
	private void fillChildrenNode(TreeNodeVo parentNode, Menu parentMenu, List<Menu> menuList) {
		for (Menu menu : menuList) {
			if(parentMenu == menu.getParent()) {
				TreeNodeVo childNode = this.menu2TreeNode(menu);
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
	private TreeNodeVo menu2TreeNode(Menu menu) {
		TreeNodeVo node = new TreeNodeVo();
		node.setId(menu.getId());
		node.setText(menu.getName());
		node.setLeaf(menu.getLeaf());
		node.setExpanded(menu.getExpanded());
//		node.getExtraData().put("viewName", menu.getViewName());
		return node;
	}

}
