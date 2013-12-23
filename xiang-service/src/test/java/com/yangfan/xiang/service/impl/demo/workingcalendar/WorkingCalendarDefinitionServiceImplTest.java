package com.yangfan.xiang.service.impl.demo.workingcalendar;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarDefinition;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarType;
import com.yangfan.xiang.service.iface.demo.workingcalendar.ParamService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarDefinitionService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class WorkingCalendarDefinitionServiceImplTest {

	@Resource
	private WorkingCalendarDefinitionService workingCalendarDefinitionService;
	
	@Resource
	private WorkingCalendarTypeService workingCalendarTypeService;
	
	@Resource
	private ParamService paramService;
	
	@Test
	public void testSaveIterableOfS() {
	
		List<WorkingCalendarDefinition> list = new ArrayList<WorkingCalendarDefinition>();
		
		WorkingCalendarType t1 = workingCalendarTypeService.findByTypeName("类型一（伦敦-英镑）");

		WorkingCalendarDefinition d1 = new WorkingCalendarDefinition();
		d1.setWorkingCalendarType(t1);
		d1.setParam(paramService.findByCodeAndParamType("02", "CCB_WorkCalendar_Region"));
		list.add(d1);
		WorkingCalendarDefinition d2 = new WorkingCalendarDefinition();
		d2.setWorkingCalendarType(t1);
		d2.setParam(paramService.findByCodeAndParamType("02", "CCB_WorkCalendar_MoneyType"));
		list.add(d2);
		
		WorkingCalendarType t2 = workingCalendarTypeService.findByTypeName("类型二（银行间）");
		
		WorkingCalendarDefinition d3 = new WorkingCalendarDefinition();
		d3.setWorkingCalendarType(t2);
		d3.setParam(paramService.findByCodeAndParamType("01", "CCB_WorkCalendar_MarketType"));
		list.add(d3);
		
		WorkingCalendarType t3 = workingCalendarTypeService.findByTypeName("类型三（纽约-美元）");
		
		WorkingCalendarDefinition d4 = new WorkingCalendarDefinition();
		d4.setWorkingCalendarType(t3);
		d4.setParam(paramService.findByCodeAndParamType("03", "CCB_WorkCalendar_Region"));
		list.add(d4);
		WorkingCalendarDefinition d5 = new WorkingCalendarDefinition();
		d5.setWorkingCalendarType(t3);
		d5.setParam(paramService.findByCodeAndParamType("03", "CCB_WorkCalendar_MoneyType"));
		list.add(d5);
		
		workingCalendarDefinitionService.save(list);
		
	}

}
