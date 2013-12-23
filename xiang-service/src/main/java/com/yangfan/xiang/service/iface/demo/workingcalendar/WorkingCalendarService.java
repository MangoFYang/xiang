package com.yangfan.xiang.service.iface.demo.workingcalendar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendar;

public interface WorkingCalendarService extends CoreService<WorkingCalendar, Long> {
	
	/**
	 * 开始日期到结束日期之间的所有日期
	 * 
	 * 包括开始日期和结束日期，字符串格式为：yyyy-MM-dd
	 * 
	 * @param startDateStr 开始日期 
	 * @param endDateStr 结束日期
	 */
	public void buildWorkingDateFromStartDateAndEndDate(Long workingCalendarTypeId, String startDateStr, String endDateStr);

	/**
	 * 分页获取工作日，并加载工作日类型。
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<WorkingCalendar> findAllFatchWorkingCalendarType(final WorkingCalendar workingCalendar, Pageable pageable);
	
}
