package com.yangfan.xiang.service.impl.demo.workingcalendar;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class WorkingCalendarServiceImplTest {
	
	@Resource
	private WorkingCalendarService workingCalendarService;

	@Test
	public void testSaveIterableOfS() {
		workingCalendarService.buildWorkingDateFromStartDateAndEndDate(2L, "2013-01-01", "2013-05-31");
	}
	
	@Test
	public void testFindAllFatchWorkingCalendarType() {
		workingCalendarService.findAllFatchWorkingCalendarType(null, new PageRequest(1, 3));
	}

}
