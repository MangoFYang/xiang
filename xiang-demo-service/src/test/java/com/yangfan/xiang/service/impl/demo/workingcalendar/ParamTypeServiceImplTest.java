package com.yangfan.xiang.service.impl.demo.workingcalendar;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.model.po.demo.workingcalendar.ParamType;
import com.yangfan.xiang.service.iface.demo.workingcalendar.ParamTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class ParamTypeServiceImplTest {
	
	@Resource
	private ParamTypeService paramTypeService;

	@Test
	public void testSaveIterableOfS() {
		List<ParamType> ParamTypeList = new ArrayList<ParamType>();
		
		ParamType type1 = new ParamType();
		type1.setType("CCB_WorkCalendar_MarketType");
		type1.setLabel("市场类型");
		ParamTypeList.add(type1);
		
		ParamType type2 = new ParamType();
		type2.setType("CCB_WorkCalendar_MoneyType");
		type2.setLabel("币种");
		ParamTypeList.add(type2);
		
		ParamType type3 = new ParamType();
		type3.setType("CCB_WorkCalendar_Region");
		type3.setLabel("地区");
		ParamTypeList.add(type3);
		
		ParamType type4 = new ParamType();
		type4.setType("CCB_WorkCalendar_TimeZone");
		type4.setLabel("时区");
		ParamTypeList.add(type4);
		
		paramTypeService.save(ParamTypeList);
	}

}
