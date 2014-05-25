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
	public Integer getNumber() {
		return page == null ? null : page.getNumber() + 1;
	}

	@Override
	public Integer getSize() {
		return page == null ? null : page.getSize();
	}

	@Override
	public Integer getTotalPages() {
		return page == null ? null : page.getTotalPages();
	}

	@Override
	public Integer getNumberOfElements() {
		return page == null ? null : page.getNumberOfElements();
	}

	@Override
	public Long getTotalElements() {
		return page == null ? null : page.getTotalElements();
	}

	@Override
	public Boolean hasPreviousPage() {
		return page == null ? null : page.hasPreviousPage();
	}

	@Override
	public Boolean isFirstPage() {
		return page == null ? null : page.isFirstPage();
	}

	@Override
	public Boolean hasNextPage() {
		return page == null ? null : page.hasNextPage();
	}

	@Override
	public Boolean isLastPage() {
		return page == null ? null : page.isLastPage();
	}

	@Override
	public List<?> getContent() {
		return page == null ? null : page.getContent();
	}

	@Override
	public Boolean hasContent() {
		return page == null ? null : page.hasContent();
	}

	@Override
	public List<CoreOrder> getOrders() {
		return ( coreRequest == null || coreRequest.getSorter() == null ) ? null : coreRequest.getSorter().getOrderList();
	}

	@Override
	public List<CoreCondition> getFilters() {
		return ( coreRequest == null || coreRequest.getFilter() == null ) ? null : coreRequest.getFilter().getConditionList();
	}

}
