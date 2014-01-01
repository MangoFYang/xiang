package com.yangfan.xiang.service.iface.demo.workingcalendar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.model.po.demo.workingcalendar.WorkingCalendarDefinition;

public interface WorkingCalendarDefinitionService extends
		CoreService<WorkingCalendarDefinition, Long> {
	
	public Page<WorkingCalendarDefinition> findByWhere(final WorkingCalendarDefinition workingCalendarDefinition, Pageable pageable);

}
