package com.yangfan.xiang.service.impl.demo.workingcalendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendar;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarConstants;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarType;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendarType_;
import com.yangfan.xiang.domain.demo.workingcalendar.WorkingCalendar_;
import com.yangfan.xiang.persist.repository.demo.workingcalendar.WorkingCalendarRepository;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarService;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarTypeService;

@Service
public class WorkingCalendarServiceImpl extends
		CoreServiceSupport<WorkingCalendar, Long> implements WorkingCalendarService {
	
	@Resource
	private WorkingCalendarRepository workingCalendarRepository;
	
	@Resource
	private WorkingCalendarTypeService workingCalendarTypeService;

	@Override
	protected CoreRepository<WorkingCalendar, Long> getRepository() {
		return workingCalendarRepository;
	}
	
	public Page<WorkingCalendar> findAllFatchWorkingCalendarType(final WorkingCalendar workingCalendar, Pageable pageable) {
		Page<WorkingCalendar> findAll = this.findByWhere(workingCalendar, pageable);
		return findAll;
	}
	
	public Page<WorkingCalendar> findByWhere(final WorkingCalendar workingCalendar, Pageable pageable) {
		Page<WorkingCalendar> findAll = workingCalendarRepository.findAll(new Specification<WorkingCalendar>() {
			@Override
			public Predicate toPredicate(Root<WorkingCalendar> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				if(workingCalendar != null) {
					List<Predicate> predicateList = new ArrayList<Predicate>();
					if(workingCalendar.getWorkingCalendarType() != null) {
						if(workingCalendar.getWorkingCalendarType().getId() != null) {
							predicateList.add(builder.equal(root.join(WorkingCalendar_.workingCalendarType).get(WorkingCalendarType_.id),
									workingCalendar.getWorkingCalendarType().getId()));
						}
					}
					query.where(predicateList.toArray(new Predicate[predicateList.size()]));
				}
				return null;
			}
		}, pageable);
		for (WorkingCalendar workingCalendar2 : findAll) {
			Hibernate.initialize(workingCalendar2.getWorkingCalendarType());
		}
		return findAll;
	}
	
	public void buildWorkingDateFromStartDateAndEndDate(Long workingCalendarTypeId, String startDateStr, String endDateStr) {
		final WorkingCalendarType workingCalendarType = workingCalendarTypeService.findOne(workingCalendarTypeId);
		// 开始日期
		DateTime startDate = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(startDateStr);
		// 结束日期
		DateTime endDate = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(endDateStr);
		// 开始日期和结束日期相差天数
		int days = Days.daysBetween(startDate, endDate).getDays();
		
		for (int i = 0; i < days + 1; i++) {
			WorkingCalendar wc = new WorkingCalendar();
			final DateTime dt = startDate.dayOfYear().addToCopy(i);
			wc.setWorkDate(dt.toDate());
			wc.setWorkingCalendarType(workingCalendarType);
			if(6 == dt.getDayOfWeek() || 7 == dt.getDayOfWeek()) {
				wc.setDateType(WorkingCalendarConstants.DATETYPE_WEEKEND);
			} else {
				wc.setDateType(WorkingCalendarConstants.DATETYPE_WORKING);
			}
			workingCalendarRepository.save(wc);
		}
	}
	
	public static void main(String[] args) {
		
		DateTime dateTime = DateTime.now();
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
		
		DateTime parseDateTime = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2013-5-25");
		final int dayOfMonth = parseDateTime.getDayOfMonth();
		System.out.println(parseDateTime.toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dayOfMonth);
		
		final DateTime addToCopy = parseDateTime.dayOfYear().addToCopy(1);
		System.out.println(addToCopy.toString("yyyy-MM-dd"));
		
		final DateTime addToCopy2 = parseDateTime.dayOfMonth().addToCopy(3);
		System.out.println(addToCopy2.toString("yyyy-MM-dd"));
		
		final Date date = addToCopy2.toDate();
		System.out.println(date);
		
		System.out.println(Days.daysBetween(addToCopy, addToCopy2).getDays());
		
		final int dayOfWeek = addToCopy2.getDayOfWeek();
		System.out.println(dayOfWeek);
		System.out.println(parseDateTime.getDayOfWeek());
		System.out.println(addToCopy.getDayOfWeek());
		
	}

}
