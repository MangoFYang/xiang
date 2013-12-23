package com.yangfan.xiang.service.impl.demo.workingcalendar;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarDefinition;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarType;
import com.yangfan.xiang.persist.repository.demo.workingcalendar.WorkingCalendarTypeRepository;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarDefinitionService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarTypeService;

@Service
public class WorkingCalendarTypeServiceImpl extends
		CoreServiceSupport<WorkingCalendarType, Long> implements WorkingCalendarTypeService {

	@Resource
	private WorkingCalendarTypeRepository workingCalendarTypeRepository;
	
	@Resource
	private WorkingCalendarDefinitionService workingCalendarDefinitionService;
	
	@Override
	protected CoreRepository<WorkingCalendarType, Long> getRepository() {
		return workingCalendarTypeRepository;
	}

	@Override
	public void addWorkingCalendarType(WorkingCalendarType workingCalendarType) {
		workingCalendarTypeRepository.save(workingCalendarType);
		List<WorkingCalendarDefinition> workingCalendarDefinitionList = workingCalendarType.getWorkingCalendarDefinitionList();
		for (WorkingCalendarDefinition workingCalendarDefinition : workingCalendarDefinitionList) {
			workingCalendarDefinition.setWorkingCalendarType(workingCalendarType);
		}
		workingCalendarDefinitionService.save(workingCalendarDefinitionList);
	}

	@Override
	public WorkingCalendarType findByTypeName(String typeName) {
		return workingCalendarTypeRepository.findByTypeName(typeName);
	}

}
