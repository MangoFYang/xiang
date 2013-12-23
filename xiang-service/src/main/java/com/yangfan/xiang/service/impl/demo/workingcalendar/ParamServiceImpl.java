package com.yangfan.xiang.service.impl.demo.workingcalendar;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.domain.demo.workingcalendar.Param;
import com.yangfan.xiang.domain.demo.workingcalendar.ParamType_;
import com.yangfan.xiang.domain.demo.workingcalendar.Param_;
import com.yangfan.xiang.persist.repository.demo.workingcalendar.ParamRepository;
import com.yangfan.xiang.service.iface.demo.workingcalendar.ParamService;

@Service
public class ParamServiceImpl extends CoreServiceSupport<Param, Long> implements ParamService {

	@Resource
	private ParamRepository paramRepository;
	
	@Override
	protected CoreRepository<Param, Long> getRepository() {
		return paramRepository;
	}
	
	public Page<Param> findByWhere(final Param param, Pageable pageable) {
		Page<Param> findAll = paramRepository.findAll(new Specification<Param>() {
			@Override
			public Predicate toPredicate(Root<Param> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				if(param != null) {
					List<Predicate> predicateList = new ArrayList<Predicate>();
					if(param.getParamType() != null) {
						if(param.getParamType().getType() != null) {
							predicateList.add(builder.equal(root.join(Param_.paramType).get(ParamType_.type), param.getParamType().getType()));
						}
					}
					query.where(predicateList.toArray(new Predicate[predicateList.size()]));
				}
				return null;
			}
		}, pageable);
		return findAll;
	}

	@Override
	public List<Param> findParamListByParamType(String paramType) {
		List<Param> findParamListByParamType = paramRepository.findParamListByParamType(paramType);
		return findParamListByParamType;
	}

	@Override
	public Param findByCodeAndParamType(String code, String paramType) {
		return paramRepository.findByCodeAndParamType(code, paramType);
	}

}
