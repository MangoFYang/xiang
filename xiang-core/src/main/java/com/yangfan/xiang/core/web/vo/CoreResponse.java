package com.yangfan.xiang.core.web.vo;

import java.util.List;

import org.springframework.data.domain.Page;

public interface CoreResponse<T> extends SimpleResponse<T> {
	
	/**
	 * Returns the number of the current page. Is always non-negative and less that {@code Page#getTotalPages()}.
	 * 
	 * @return the number of the current page
	 */
	Integer getNumber();

	/**
	 * Returns the size of the page.
	 * 
	 * @return the size of the page
	 */
	Integer getSize();

	/**
	 * Returns the number of total pages.
	 * 
	 * @return the number of toral pages
	 */
	Integer getTotalPages();

	/**
	 * Returns the number of elements currently on this page.
	 * 
	 * @return the number of elements currently on this page
	 */
	Integer getNumberOfElements();

	/**
	 * Returns the total amount of elements.
	 * 
	 * @return the total amount of elements
	 */
	Long getTotalElements();

	/**
	 * Returns if there is a previous page.
	 * 
	 * @return if there is a previous page
	 */
	Boolean hasPreviousPage();

	/**
	 * Returns whether the current page is the first one.
	 * 
	 * @return
	 */
	Boolean isFirstPage();

	/**
	 * Returns if there is a next page.
	 * 
	 * @return if there is a next page
	 */
	Boolean hasNextPage();

	/**
	 * Returns whether the current page is the last one.
	 * 
	 * @return
	 */
	Boolean isLastPage();

	/**
	 * Returns the page content as {@link List}.
	 * 
	 * @return
	 */
	List<T> getContent();

	/**
	 * Returns whether the {@link Page} has content at all.
	 * 
	 * @return
	 */
	Boolean hasContent();
	
}
