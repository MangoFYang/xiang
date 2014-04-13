package com.yangfan.xiang.core.web.domain;

import java.util.List;

public class CoreFilter {
	
	private List<CoreCondition> conditionList;
	
	public CoreFilter() {
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
