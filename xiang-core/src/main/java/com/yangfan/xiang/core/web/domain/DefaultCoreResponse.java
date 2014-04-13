package com.yangfan.xiang.core.web.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public class DefaultCoreResponse implements CoreResponse, Serializable {

	private static final long serialVersionUID = 3935090936065712570L;
	
	private Page<?> page;
	
	private CoreRequest coreRequest;
	
	public DefaultCoreResponse() {
	}
	
	public DefaultCoreResponse(Page<?> page, CoreRequest coreRequest) {
		this.page = page;
		this.coreRequest = coreRequest;
	}

	public void setPage(Page<?> page) {
		this.page = page;
	}

	public void setCoreRequest(CoreRequest coreRequest) {
		this.coreRequest = coreRequest;
	}

	@Override
	public int getNumber() {
		return page.getNumber() + 1;
	}

	@Override
	public int getSize() {
		return page.getSize();
	}

	@Override
	public int getTotalPages() {
		return page.getTotalPages();
	}

	@Override
	public int getNumberOfElements() {
		return page.getNumberOfElements();
	}

	@Override
	public long getTotalElements() {
		return page.getTotalElements();
	}

	@Override
	public boolean hasPreviousPage() {
		return page.hasPreviousPage();
	}

	@Override
	public boolean isFirstPage() {
		return page.isFirstPage();
	}

	@Override
	public boolean hasNextPage() {
		return page.hasNextPage();
	}

	@Override
	public boolean isLastPage() {
		return page.isLastPage();
	}

	@Override
	public List<?> getContent() {
		return page.getContent();
	}

	@Override
	public boolean hasContent() {
		return page.hasContent();
	}

	@Override
	public List<CoreOrder> getOrders() {
		return coreRequest.getSorter() == null ? null : coreRequest.getSorter().getOrderList();
	}

	@Override
	public List<CoreCondition> getFilters() {
		return coreRequest.getFilter() == null ? null : coreRequest.getFilter().getConditionList();
	}

}
