package com.yangfan.xiang.core.web.domain;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface CoreRequest {
	
	public CorePager getPager();

	public CoreSorter getSorter();

	public CoreFilter getFilter();
	
	public Pageable getPageable();
	
	public Sort getSort();
	
	public String getCondition(String param);
	
	public List<?> getConditions(String param);
	
	public boolean hasCondition();

}
