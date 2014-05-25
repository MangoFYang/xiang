package com.yangfan.xiang.core.web.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class DefaultCoreRequest implements CoreRequest, Serializable {
	
	private static final long serialVersionUID = 3308184917876917350L;

	private CorePager pager;
	
	private CoreSorter sorter;
	
	private CoreFilter filter;
	
	private Pageable pageable;
	
	private Sort sort;
	
	private MultiValueMap<String, String> filterMap;
	
	public DefaultCoreRequest() {
	}

	public DefaultCoreRequest(CorePager pager) {
		this(pager, null, null);
	}
	
	public DefaultCoreRequest(CoreSorter sorter) {
		this(null, sorter, null);
	}

	public DefaultCoreRequest(CoreFilter filter) {
		this(null, null, filter);
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
		if(pageable != null ) {
			return pageable;
		}
		return new PageRequest(pager.getPage() - 1, pager.getSize(), getSort());
	}
	
	public Sort getSort() {
		if(sort != null) {
			return sort;
		}
		if(sorter != null && sorter.getOrderList() != null && !sorter.getOrderList().isEmpty()) {
			List<Order> orderList = new ArrayList<Order>();
			for (CoreOrder coreOrder : sorter.getOrderList()) {
				Order o = new Order(
						Direction.fromStringOrNull(coreOrder.getDirection()), coreOrder.getProperty());
				orderList.add(o);
			}
			return sort = new Sort(orderList);
		}
		return null;
	}
	
	private void populateFilterMap() {
		filterMap = new LinkedMultiValueMap<String, String>();
		List<CoreCondition> conditionList = filter.getConditionList();
		if(conditionList != null) {
			for (CoreCondition coreCondition : conditionList) {
				filterMap.add(coreCondition.getProperty(), coreCondition.getValue());
			}
		}
	}

	@Override
	public String getCondition(String param) {
		if(!hasCondition()) {
			return null;
		} 
		if(filterMap == null) {
			populateFilterMap();
		}
		return filterMap.getFirst(param);
	}

	@Override
	public List<?> getConditions(String param) {
		if(!hasCondition()) {
			return null;
		} 
		if(filterMap == null) {
			populateFilterMap();
		}
		return filterMap.get(param);
	}

	@Override
	public boolean hasCondition() {
		if(filter == null) {
			return false;
		}
		if(filter.getConditionList() == null) {
			return false;
		}
		if(filter.getConditionList().isEmpty()) {
			return false;
		}
		return true;
	}

}
