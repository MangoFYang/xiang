package com.yangfan.xiang.web.demo.workingcalendar;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yangfan.xiang.core.vo.ReturnVo;
import com.yangfan.xiang.model.po.demo.workingcalendar.WorkingCalendar;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarTypeService;

@Controller
@RequestMapping("/demo/WorkingCalendarController")
public class WorkingCalendarController {
	
	@Resource
	private WorkingCalendarService workingCalendarService;
	
	@Resource
	private WorkingCalendarTypeService workingCalendarTypeService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/demo/workingcalendar/index");
		mav.addObject("workingCalendarType", workingCalendarTypeService.findAll());
		return mav;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Page<WorkingCalendar> list(final WorkingCalendar workingCalendar, Pageable pageable) {
		Page<WorkingCalendar> findAll = workingCalendarService.findAllFatchWorkingCalendarType(workingCalendar, pageable);
		return findAll;
	}
	
	@RequestMapping("/buildWorkingDateFromStartDateAndEndDate")
	@ResponseBody
	public ReturnVo buildWorkingDateFromStartDateAndEndDate(Long workingCalendarTypeId, String startDateStr, String endDateStr) {
		ReturnVo r = new ReturnVo();
		try {
			workingCalendarService.buildWorkingDateFromStartDateAndEndDate(workingCalendarTypeId, startDateStr, endDateStr);
			r.setSuccess(true);
		} catch(Exception e) {
			r.setSuccess(false);
			r.setMessage(e.getMessage());
			r.getExtraData().put("e", e);
			e.printStackTrace();
		}
		return r;
	}

}
