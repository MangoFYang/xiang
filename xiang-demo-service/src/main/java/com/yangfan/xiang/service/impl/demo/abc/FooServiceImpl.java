package com.yangfan.xiang.service.impl.demo.abc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.core.support.DateUtils;
import com.yangfan.xiang.core.web.domain.CoreRequest;
import com.yangfan.xiang.model.po.demo.abc.Foo;
import com.yangfan.xiang.model.po.demo.abc.Foo_;
import com.yangfan.xiang.persist.repository.demo.abc.FooRepository;
import com.yangfan.xiang.service.iface.demo.abc.FooService;

@Service
public class FooServiceImpl extends CoreServiceSupport<Foo, Long> implements FooService {
	
	@Resource
	private FooRepository fooRepository;

	@Override
	protected CoreRepository<Foo, Long> getRepository() {
		return fooRepository;
	}

	@Override
	public Page<Foo> findAll(final CoreRequest coreRequest) {
		Page<Foo> findAll = fooRepository.findAll(new Specification<Foo>() {
			@Override
			public Predicate toPredicate(Root<Foo> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(coreRequest.hasCondition()) {
					List<Predicate> predicateList = new ArrayList<Predicate>();
					String stringField = coreRequest.getCondition("stringField");
					if(stringField != null) {
						// predicateList.add(cb.like(root.<String>get("stringField"), "%" + stringField + "%"));
						predicateList.add(
								cb.like(root.get(Foo_.stringField), "%" + stringField + "%"));
					}
					String fromDateString = coreRequest.getCondition("fromDate");
					if(fromDateString != null) {
						predicateList.add(
								cb.greaterThanOrEqualTo(root.get(Foo_.dateField), DateUtils.parseDate(fromDateString)));
					}
					String toDateString = coreRequest.getCondition("toDate");
					if(toDateString != null) {
						predicateList.add(
								cb.lessThan(root.get(Foo_.dateField), DateUtils.parseDate(toDateString)));
					}
					query.where(predicateList.toArray(new Predicate[predicateList.size()]));
				}
				return null;
			}
		}, coreRequest.getPageable());
		return findAll;
	}

}
