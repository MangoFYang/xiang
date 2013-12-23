package com.yangfan.xiang.web.demo.workingcalendar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yangfan.xiang.domain.demo.workingcalendar.Param;
import com.yangfan.xiang.domain.demo.workingcalendar.ParamType;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarDefinition;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarType;
import com.yangfan.xiang.service.iface.demo.workingcalendar.ParamService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.ParamTypeService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarDefinitionService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarTypeService;
import com.yangfan.xiang.vo.Return2Web;

@Controller
@RequestMapping("/demo/WorkingCalendarMaintainController")
public class WorkingCalendarMaintainController {
	
	@Resource
	private ParamTypeService paramTypeService;
	
	@Resource
	private ParamService paramService;
	
	@Resource
	private WorkingCalendarDefinitionService workingCalendarDefinitionService;
	
	@Resource
	private WorkingCalendarTypeService workingCalendarTypeService;
	
	@RequestMapping("/maintain")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/demo/workingcalendar/maintain");
		mav.addObject("paramType", paramTypeService.findAll());
		return mav;
	}
	
	@RequestMapping("/paramType")
	@ResponseBody
	public Map<String, Object> paramType() {
		Map<String, Object> paramTypeMap = new HashMap<String, Object>();
		paramTypeMap.put("paramType", paramTypeService.findAll());
		return paramTypeMap;
	}

	@RequestMapping("/paramByParamType")
	@ResponseBody
	public Map<String, Object> paramByParamType(String paramType) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("param", paramService.findParamListByParamType(paramType));
		return paramMap;
	}	
	
	@RequestMapping("/param")
	public String param() {
		return "/demo/workingcalendar/param";
	}
	
	@RequestMapping("/listParamType")
	@ResponseBody
	public Page<ParamType> listParamType(Pageable pageable) {
		final long start = System.currentTimeMillis();
		Page<ParamType> findAll = paramTypeService.findAll(pageable);
		System.out.println(System.currentTimeMillis() - start);
		return findAll;
	}
	
	@RequestMapping("/listParam")
	@ResponseBody
	public Page<Param> listParam(Param param, Pageable pageable) {
		Page<Param> findAll = paramService.findByWhere(param, pageable);
		return findAll;
	}
	
	@RequestMapping("/listWorkingCalendarType")
	@ResponseBody
	public Page<WorkingCalendarType> listWorkingCalendarType(Pageable pageable) {
		Page<WorkingCalendarType> findAll = workingCalendarTypeService.findAll(pageable);
		return findAll;
	}
	
	@RequestMapping("/listWorkingCalendarDefinition")
	@ResponseBody
	public Page<WorkingCalendarDefinition> listWorkingCalendarDefinition(WorkingCalendarDefinition workingCalendarDefinition, Pageable pageable) {
		Page<WorkingCalendarDefinition> findAll = workingCalendarDefinitionService.findByWhere(workingCalendarDefinition, pageable);
		return findAll;
	}
	
	@RequestMapping("/findParamListByParamType")
	@ResponseBody
	public List<Param> findParamListByParamType(String paramType) {
		List<Param> findParamListByParamType = paramService.findParamListByParamType(paramType);
		return findParamListByParamType;
	}
	
	@RequestMapping("/addWorkingCalendarType")
	@ResponseBody
	public Return2Web addWorkingCalendarType(WorkingCalendarType workingCalendarType) {
		Return2Web r2w = new Return2Web();
		try {
			workingCalendarTypeService.addWorkingCalendarType(workingCalendarType);
			r2w.setSuccess(true);
		} catch(Exception e) {
			r2w.setSuccess(false);
			r2w.setMessage(e.getMessage());
			r2w.setOtherInfo(e);
			e.printStackTrace();
		}
		return r2w;
	}
	
}
