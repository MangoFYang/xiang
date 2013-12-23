package com.yangfan.xiang.service.impl.demo.workingcalendar;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.workingcalendar.Param;
import com.yangfan.xiang.domain.demo.workingcalendar.ParamType;
import com.yangfan.xiang.service.iface.demo.workingcalendar.ParamService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.ParamTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class ParamServiceImplTest {

	@Resource
	private ParamTypeService paramTypeService;
	
	@Resource
	private ParamService paramService;
	
	@Test
	public void testSaveIterableOfS() {
		
		List<Param> paramList = new ArrayList<Param>();
		
		ParamType type1 = paramTypeService.findOne("CCB_WorkCalendar_MarketType");
		Param p1 = new Param();
		p1.setParamType(type1);
		p1.setCode("01");
		p1.setLabel("银行间");
		paramList.add(p1);
		
		Param p2 = new Param();
		p2.setParamType(type1);
		p2.setCode("02");
		p2.setLabel("交易所");
		paramList.add(p2);
		
		ParamType type2 = paramTypeService.findOne("CCB_WorkCalendar_MoneyType");
		Param p3 = new Param();
		p3.setParamType(type2);
		p3.setCode("01");
		p3.setLabel("人民币");
		paramList.add(p3);
		
		Param p4 = new Param();
		p4.setParamType(type2);
		p4.setCode("02");
		p4.setLabel("英镑");
		paramList.add(p4);
		
		Param p5 = new Param();
		p5.setParamType(type2);
		p5.setCode("03");
		p5.setLabel("美元");
		paramList.add(p5);
		
		ParamType type3 = paramTypeService.findOne("CCB_WorkCalendar_Region");
		Param p6 = new Param();
		p6.setParamType(type3);
		p6.setCode("01");
		p6.setLabel("上海");
		paramList.add(p6);
		
		Param p7 = new Param();
		p7.setParamType(type3);
		p7.setCode("02");
		p7.setLabel("伦敦");
		paramList.add(p7);
		
		Param p8 = new Param();
		p8.setParamType(type3);
		p8.setCode("03");
		p8.setLabel("纽约");
		paramList.add(p8);
		
		ParamType type4 = paramTypeService.findOne("CCB_WorkCalendar_TimeZone");
		Param p9 = new Param();
		p9.setParamType(type4);
		p9.setCode("01");
		p9.setLabel("东8");
		paramList.add(p9);
		
		paramService.save(paramList);
		
	}

}
