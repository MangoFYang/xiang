package com.yangfan.xiang.core.web.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public class DefaultCoreResponse<T> extends DefaultSimpleResponse<T> implements CoreResponse<T>, Serializable {

	private static final long serialVersionUID = 3935090936065712570L;
	
	private Page<T> page;
	
	public DefaultCoreResponse() {
	}
	
	public DefaultCoreResponse(Page<T> page) {
		this.page = page;
	}
	
	public DefaultCoreResponse(Boolean success, String message, Page<T> page) {
		super(success, message);
		this.page = page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}
	
	@Override
	public List<T> getContent() {
		return page == null ? null : page.getContent();
	}

	@Override
	public Boolean hasContent() {
		return page == null ? null : page.hasContent();
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

}
