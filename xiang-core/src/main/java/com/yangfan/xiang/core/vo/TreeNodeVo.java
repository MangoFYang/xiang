package com.yangfan.xiang.core.vo;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeVo extends ExtraDataVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1034084110153137562L;

	/**
	 * 节点标识
	 */
	private String id;
	
	/**
	 * 节点名称
	 */
	private String text;
	
	/**
	 * 子节点
	 */
	private List<TreeNodeVo> children = new ArrayList<TreeNodeVo>();
	
	/**
	 * 是否为叶子节点
	 */
	private Boolean leaf;

	/**
	 * 是否展开
	 */
	private Boolean expanded;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeNodeVo> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNodeVo> children) {
		this.children = children;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}
	
}
