package com.yangfan.xiang.model.po.demo.authority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 菜单
 * 
 * @author 杨帆
 */
@Entity
@Table(name="DEMO_MENU")
@JsonIgnoreProperties({"parent"})
public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5374113015762893768L;
	
	/**
	 * 菜单标识
	 */
	@Id
	private String id;
	
	/**
	 * 菜单名
	 */
	@Column(nullable=false)
	private String name;
	
	/**
	 * 父菜单
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private Menu parent;
	
	/**
	 * 子菜单
	 */
	@OneToMany(fetch=FetchType.LAZY, mappedBy="parent")
	private List<Menu> children = new ArrayList<Menu>();
	
	/**
	 * 是否为叶子菜单
	 */
	@Column(nullable=false)
	private Boolean leaf;
	
	/**
	 * 是否展开
	 */
	private Boolean expanded;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 此菜单对应的视图名
	 */
	private String viewName;
	
	/**
	 * 菜单顺序
	 */
	@Column(name="menu_order")
	private Integer order;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getText() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}
	
}
