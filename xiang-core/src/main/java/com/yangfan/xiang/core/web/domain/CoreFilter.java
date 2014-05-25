package com.yangfan.xiang.core.web.domain;

import java.util.ArrayList;
import java.util.List;

public class CoreFilter {
	
	private List<CoreCondition> conditionList;
	
	public CoreFilter() {
	}
	
	public CoreFilter(String property, String value) {
		List<CoreCondition> conditionList = new ArrayList<CoreCondition>();
		conditionList.add(new CoreCondition(property, value));
		this.conditionList = conditionList;
	}
	
	public CoreFilter(List<CoreCondition> conditionList) {
		this.conditionList = conditionList;
	}

	public List<CoreCondition> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<CoreCondition> conditionList) {
		this.conditionList = conditionList;
	}

}
