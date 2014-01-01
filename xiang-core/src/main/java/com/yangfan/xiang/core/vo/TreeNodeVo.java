package com.yangfan.xiang.core.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNodeVo {
	
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
	List<TreeNodeVo> children = new ArrayList<TreeNodeVo>();
	
	/**
	 * 是否为叶子节点
	 */
	private Boolean leaf;

	/**
	 * 是否展开
	 */
	private Boolean expanded;
	
	/**
	 * 额外的数据
	 */
	private Map<String, String> extraData = new HashMap<String, String>();
	
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

	public Map<String, String> getExtraData() {
		return extraData;
	}

	public void setExtraData(Map<String, String> extraData) {
		this.extraData = extraData;
	}
	
	public void putExtraData(String key, String value) {
		extraData.put(key, value);
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}
	
}
