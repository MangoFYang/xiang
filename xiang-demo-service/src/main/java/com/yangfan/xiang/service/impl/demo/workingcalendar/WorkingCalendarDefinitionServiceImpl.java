package com.yangfan.xiang.service.impl.demo.workingcalendar;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.workingcalendar.WorkingCalendarDefinition;
import com.yangfan.xiang.model.po.demo.workingcalendar.WorkingCalendarDefinition_;
import com.yangfan.xiang.model.po.demo.workingcalendar.WorkingCalendarType_;
import com.yangfan.xiang.persist.repository.demo.workingcalendar.WorkingCalendarDefinitionRepository;
import com.yangfan.xiang.service.iface.demo.workingcalendar.WorkingCalendarDefinitionService;

@Service
public class WorkingCalendarDefinitionServiceImpl extends
		CoreServiceSupport<WorkingCalendarDefinition, Long> implements WorkingCalendarDefinitionService {

	@Resource
	private WorkingCalendarDefinitionRepository workingCalendarDefinitionRepository;
	
	@Override
	protected CoreRepository<WorkingCalendarDefinition, Long> getRepository() {
		return workingCalendarDefinitionRepository;
	}
	
	public Page<WorkingCalendarDefinition> findByWhere(final WorkingCalendarDefinition workingCalendarDefinition, Pageable pageable) {
		Page<WorkingCalendarDefinition> findAll = workingCalendarDefinitionRepository.findAll(new Specification<WorkingCalendarDefinition>() {
			@Override
			public Predicate toPredicate(Root<WorkingCalendarDefinition> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				if(workingCalendarDefinition != null) {
					List<Predicate> predicateList = new ArrayList<Predicate>();
					if(workingCalendarDefinition.getWorkingCalendarType() != null) {
						if(workingCalendarDefinition.getWorkingCalendarType().getId() != null) {
							predicateList.add(builder.equal(root.get(WorkingCalendarDefinition_.workingCalendarType).get(WorkingCalendarType_.id),
									workingCalendarDefinition.getWorkingCalendarType().getId()));
						}
					}
					query.where(predicateList.toArray(new Predicate[predicateList.size()]));
				}
				return null;
			}
		}, pageable);
		for (WorkingCalendarDefinition workingCalendarDefinition2 : findAll) {
			Hibernate.initialize(workingCalendarDefinition2.getParam().getParamType());
		}
		return findAll;
	}

}
