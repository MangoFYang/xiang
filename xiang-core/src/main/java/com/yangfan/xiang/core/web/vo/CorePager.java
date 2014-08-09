package com.yangfan.xiang.core.web.vo;

public class CorePager {
	
	private int page;
	
	private int size;
	
	public CorePager() {
	}
	
	public CorePager(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
