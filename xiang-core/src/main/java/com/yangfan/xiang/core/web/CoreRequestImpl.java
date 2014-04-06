package com.yangfan.xiang.core.web;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.MultiValueMap;

/**
 * Basic Java Bean implementation of {@code CoreRequest}.
 * 
 * @author 杨帆
 */
/**
 * @author Administrator
 *
 */
public class CoreRequestImpl implements CoreRequest, Serializable {

	private static final long serialVersionUID = 7313461232140379011L;
	
	private final int page;
	
	private final int size;
	
	private final Sort sort;
	
	private final Filter filter;

	/**
	 * Creates a new {@link CoreRequest}. Pages are 1 indexed, thus providing 1 for {@code page} will return the first
	 * page.
	 * 
	 * @param size
	 * @param page
	 */
	public CoreRequestImpl(int page, int size) {
		this(page, size, null);
	}

	/**
	 * Creates a new {@link CoreRequest} with sort parameters applied.
	 * 
	 * @param page
	 * @param size
	 * @param direction
	 * @param properties
	 */
	public CoreRequestImpl(int page, int size, Direction direction, String... properties) {
		this(page, size, new Sort(direction, properties));
	}
	
	/**
	 * Creates a new {@link CoreRequest} with sort parameters applied.
	 * 
	 * @param page
	 * @param size
	 * @param sort
	 */
	public CoreRequestImpl(int page, int size, Sort sort) {
		this(page, size, sort, null);
	}

	/**
	 * Creates a new {@link CoreRequest} with sort parameters applied.
	 * 
	 * @param page
	 * @param size
	 * @param sort
	 */
	public CoreRequestImpl(int page, int size, Sort sort, Filter filter) {
		if (1 > page) {
			throw new IllegalArgumentException("Page index must not be less than 1!");
		}
		if (0 >= size) {
			throw new IllegalArgumentException("Page size must not be less than or equal to zero!");
		}
		this.page = page;
		this.size = size;
		this.sort = sort;
		this.filter = filter;
	}

	public int getPageSize() {
		return size;
	}

	public int getPageNumber() {
		return page;
	}

	public int getOffset() {
		return (page - 1) * size;
	}

	public Sort getSort() {
		return sort;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CoreRequestImpl)) {
			return false;
		}
		CoreRequestImpl that = (CoreRequestImpl) obj;
		boolean pageEqual = this.page == that.page;
		boolean sizeEqual = this.size == that.size;
		boolean sortEqual = this.sort == null ? that.sort == null : this.sort.equals(that.sort);
		return pageEqual && sizeEqual && sortEqual;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + page;
		result = 31 * result + size;
		result = 31 * result + (null == sort ? 0 : sort.hashCode());
		return result;
	}
	
	public Filter getFilter() {
		return filter;
	}

	private MultiValueMap<String, String> getQueries() {
		return this.filter.getQueries();
	}
	
	@Override
	public List<String> getValues(String key) {
		return this.getQueries().get(key);
	}
	
	@Override
	public String getValue(String key) {
		return this.getQueries().getFirst(key);
	}
	
}
