package com.yangfan.xiang.model.po.demo.workingcalendar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 工作日历参数类型
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_CALD_PARAMTYPE")
public class ParamType {
	
	@Id
	private String type;
	
	private String label;
	
	@OneToMany(mappedBy="paramType")
	private List<Param> paramList = new ArrayList<Param>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Param> getParamList() {
		return paramList;
	}

	public void setParamList(List<Param> paramList) {
		this.paramList = paramList;
	}
	
}
