package com.yangfan.xiang.service.impl.demo.workingcalendar;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.model.po.demo.workingcalendar.WorkingCalendarType;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class WorkingCalendarTypeServiceImplTest {
	
	@Resource
	private WorkingCalendarTypeService workingCalendarTypeService;

	@Test
	public void testSaveIterableOfS() {

		List<WorkingCalendarType> list = new ArrayList<WorkingCalendarType>();
		WorkingCalendarType t1 = new WorkingCalendarType();
		t1.setTypeName("类型一（伦敦-英镑）");
		list.add(t1);
		WorkingCalendarType t2 = new WorkingCalendarType();
		t2.setTypeName("类型二（银行间）");
		list.add(t2);
		WorkingCalendarType t3 = new WorkingCalendarType();
		t3.setTypeName("类型三（纽约-美元）");
		list.add(t3);
		workingCalendarTypeService.save(list);
		
	}
	
	@Test
	public void testFindByTypeName() {
		final WorkingCalendarType findByTypeName = workingCalendarTypeService.findByTypeName("类型一（伦敦-英镑）");
		System.out.println(findByTypeName);
	}

}
