package com.yangfan.xiang.service.iface.demo.workingcalendar;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.model.po.demo.workingcalendar.WorkingCalendarType;

public interface WorkingCalendarTypeService extends CoreService<WorkingCalendarType, Long> {
	
	public void addWorkingCalendarType(WorkingCalendarType workingCalendarType);
	
	public WorkingCalendarType findByTypeName(String typeName);

}
