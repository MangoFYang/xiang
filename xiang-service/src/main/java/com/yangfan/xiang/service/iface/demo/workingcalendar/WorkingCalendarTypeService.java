package com.yangfan.xiang.service.iface.demo.workingcalendar;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarType;

public interface WorkingCalendarTypeService extends CoreService<WorkingCalendarType, Long> {
	
	public void addWorkingCalendarType(WorkingCalendarType workingCalendarType);
	
	public WorkingCalendarType findByTypeName(String typeName);

}
