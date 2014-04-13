package com.yangfan.xiang.core.web.domain;

import java.io.Serializable;
import java.util.List;

public class CoreSorter implements Serializable {
	
	private static final long serialVersionUID = -3389102519495051544L;
	
	private List<CoreOrder> orderList;
	
	public CoreSorter() {
	}
	
	public CoreSorter(List<CoreOrder> orderList) {
		this.orderList = orderList;
	}

	public List<CoreOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<CoreOrder> orderList) {
		this.orderList = orderList;
	}
	
}
