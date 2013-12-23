package com.yangfan.xiang.persist.repository.demo.workingcalendar;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarType;

public interface WorkingCalendarTypeRepository extends
		CoreRepository<WorkingCalendarType, Long> {
	
	public WorkingCalendarType findByTypeName(String typeName);

}
