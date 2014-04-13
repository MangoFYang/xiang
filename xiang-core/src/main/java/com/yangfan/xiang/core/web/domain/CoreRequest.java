package com.yangfan.xiang.core.web.domain;

import org.springframework.data.domain.Pageable;

public interface CoreRequest {
	
	public CorePager getPager();

	public CoreSorter getSorter();

	public CoreFilter getFilter();
	
	public Pageable getPageable();

}
