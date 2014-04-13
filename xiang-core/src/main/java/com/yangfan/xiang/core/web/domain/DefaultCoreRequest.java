package com.yangfan.xiang.core.web.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class DefaultCoreRequest implements CoreRequest, Serializable {
	
	private static final long serialVersionUID = 3308184917876917350L;

	private CorePager pager;
	
	private CoreSorter sorter;
	
	private CoreFilter filter;
	
	private Pageable pageable;
	
	public DefaultCoreRequest() {
	}

	public DefaultCoreRequest(CorePager pager, CoreSorter sorter, CoreFilter filter) {
		this.pager = pager;
		this.sorter = sorter;
		this.filter = filter;
	}

	public CorePager getPager() {
		return pager;
	}

	public void setPager(CorePager pager) {
		this.pager = pager;
	}

	public CoreSorter getSorter() {
		return sorter;
	}

	public void setSorter(CoreSorter sorter) {
		this.sorter = sorter;
	}

	public CoreFilter getFilter() {
		return filter;
	}

	public void setFilter(CoreFilter filter) {
		this.filter = filter;
	}
	
	public Pageable getPageable() {
		if(pageable == null ) {
			Sort sort = null;
			if(sorter != null && sorter.getOrderList() != null && !sorter.getOrderList().isEmpty()) {
				List<Order> orderList = new ArrayList<Order>();
				for (CoreOrder coreOrder : sorter.getOrderList()) {
					Order o = new Order(
							Direction.fromStringOrNull(coreOrder.getDirection()), coreOrder.getProperty());
					orderList.add(o);
				}
				sort = new Sort(orderList);
			}
			pageable = new PageRequest(pager.getPage() - 1, pager.getSize(), sort);
		}
		return pageable;
	}

}
