package com.yangfan.xiang.service.impl.demo.emp;

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
import com.yangfan.xiang.domain.demo.emp.Dept;
import com.yangfan.xiang.persist.mapper.demo.DeptMapper;
import com.yangfan.xiang.persist.repository.demo.emp.DeptRepository;
import com.yangfan.xiang.service.iface.demo.emp.DeptService;

@Service
public class DeptServiceImpl extends CoreServiceSupport<Dept, String> implements DeptService {
	
	@Resource
	private DeptMapper deptMapper;
	
	@Resource
	private DeptRepository deptRepository;

	@Override
	protected CoreRepository<Dept, String> getRepository() {
		return deptRepository;
	}

	@Override
	public Dept findByDeptNo(Integer deptNo) {
		return deptRepository.findByDeptNo(deptNo);
	}

	@Override
	public void savePojo(Dept dept) {
		deptMapper.savePojo(dept);
	}
	
	@Override
	public Page<Dept> findByWhere(final Dept dept, Pageable pageable) {
		final long start = System.currentTimeMillis();
		Page<Dept> findAll = deptRepository.findAll(new Specification<Dept>() {
			@Override
			public Predicate toPredicate(Root<Dept> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				if(dept != null) {
					if(dept.getDeptName() != null) {
						Predicate or = cb.or(cb.like(root.<String>get("deptName"), "%"+dept.getDeptName().toLowerCase()+"%"), 
								cb.like(root.<String>get("deptName"), "%"+dept.getDeptName().toUpperCase()+"%"));
						predicateList.add(or);
					}
					if(dept.getLoc() != null) {
						Predicate or = cb.or(cb.like(root.<String>get("loc"), "%"+dept.getLoc().toLowerCase()+"%"), 
								cb.like(root.<String>get("loc"), "%"+dept.getLoc().toUpperCase()+"%"));
						predicateList.add(or);
					}
				}
				query.where(cb.and(predicateList.toArray(new Predicate[predicateList.size()])));
				return null;
			}
		}, pageable);
		this.logger.info(String.valueOf(System.currentTimeMillis() - start));
		return findAll;
	}
	
}
