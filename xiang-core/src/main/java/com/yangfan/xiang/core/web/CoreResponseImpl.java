package com.yangfan.xiang.core.web;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.util.MultiValueMap;

public class CoreResponseImpl<T> implements CoreResponse<T>, Serializable {

	private static final long serialVersionUID = 656804249304990850L;

	private Page<T> pager;

	private Filter filter;

	public CoreResponseImpl(Page<T> pager) {
		this(pager, null);
	}

	public CoreResponseImpl(Page<T> pager, Filter filter) {
		this.pager = pager;
		this.filter = filter;
	}

	public MultiValueMap<String, String> getFilter() {
		if (filter != null) {
			return filter.getQueries();
		}
		return null;
	}

	@Override
	public int getNumber() {
		return pager.getNumber();
	}

	@Override
	public int getSize() {
		return pager.getSize();
	}

	@Override
	public int getTotalPages() {
		return pager.getTotalPages();
	}

	@Override
	public int getNumberOfElements() {
		return pager.getNumberOfElements();
	}

	@Override
	public long getTotalElements() {
		return pager.getTotalElements();
	}

	@Override
	public boolean hasPreviousPage() {
		return pager.getNumber() > 1;
	}

	@Override
	public boolean isFirstPage() {
		return !hasPreviousPage();
	}

	@Override
	public boolean hasNextPage() {
		return pager.hasNextPage();
	}

	@Override
	public boolean isLastPage() {
		return pager.isLastPage();
	}

	@Override
	public Iterator<T> iterator() {
		return pager.iterator();
	}

	@Override
	public List<T> getContent() {
		return pager.getContent();
	}

	@Override
	public boolean hasContent() {
		return pager.hasContent();
	}

	@Override
	public Sort getSort() {
		return pager.getSort();
	}

	@Override
	public String toString() {
		return pager.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return pager.equals(obj);
	}

	@Override
	public int hashCode() {
		return pager.hashCode();
	}

}
