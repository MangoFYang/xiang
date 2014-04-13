package com.yangfan.xiang.core.web.domain;

import java.util.List;

import org.springframework.data.domain.Page;

public interface CoreResponse {
	
	/**
	 * Returns the number of the current page. Is always non-negative and less that {@code Page#getTotalPages()}.
	 * 
	 * @return the number of the current page
	 */
	int getNumber();

	/**
	 * Returns the size of the page.
	 * 
	 * @return the size of the page
	 */
	int getSize();

	/**
	 * Returns the number of total pages.
	 * 
	 * @return the number of toral pages
	 */
	int getTotalPages();

	/**
	 * Returns the number of elements currently on this page.
	 * 
	 * @return the number of elements currently on this page
	 */
	int getNumberOfElements();

	/**
	 * Returns the total amount of elements.
	 * 
	 * @return the total amount of elements
	 */
	long getTotalElements();

	/**
	 * Returns if there is a previous page.
	 * 
	 * @return if there is a previous page
	 */
	boolean hasPreviousPage();

	/**
	 * Returns whether the current page is the first one.
	 * 
	 * @return
	 */
	boolean isFirstPage();

	/**
	 * Returns if there is a next page.
	 * 
	 * @return if there is a next page
	 */
	boolean hasNextPage();

	/**
	 * Returns whether the current page is the last one.
	 * 
	 * @return
	 */
	boolean isLastPage();

	/**
	 * Returns the page content as {@link List}.
	 * 
	 * @return
	 */
	List<?> getContent();

	/**
	 * Returns whether the {@link Page} has content at all.
	 * 
	 * @return
	 */
	boolean hasContent();
	
	public List<CoreOrder> getOrders();
	
	public List<CoreCondition> getFilters();

}
