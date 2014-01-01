package com.yangfan.xiang.service.impl.demo.emp;

import java.util.List;

import javax.annotation.Resource;

import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.expression.EqualTo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.emp.SalGrade;
import com.yangfan.xiang.persist.mapper.demo.emp.SalGradeMapper;
import com.yangfan.xiang.persist.repository.demo.emp.SalGradeRepository;
import com.yangfan.xiang.service.iface.demo.emp.SalGradeService;

@Service
public class SalGradeServiceImpl extends CoreServiceSupport<SalGrade, Integer> implements SalGradeService {
	
	/**
	 * 薪资等级的缓存名
	 */
	private static final String SAL_GRADE_CACHE_NAME = "SalGradeCache";

	/**
	 * grade属性，用于在缓存中查找
	 */
	private static final String GRADE_ATTR = "grade";
	
	@Resource
	private SalGradeMapper salGradeMapper;
	
	@Resource
	private SalGradeRepository salGradeRepository;
	
	@Override
	protected CoreRepository<SalGrade, Integer> getRepository() {
		return salGradeRepository;
	}

	@Override
	public SalGrade findByGradeFromCache(Integer grade) {
		SalGrade findByGrade = null;
		Query createQuery = this.getEhcache(SAL_GRADE_CACHE_NAME).createQuery();
		List<Result> all = createQuery
			.addCriteria(new EqualTo(GRADE_ATTR, grade))
			.includeValues()
			.execute().all();
		if(!all.isEmpty()) {
			findByGrade = (SalGrade)all.get(0).getValue();
		}
		return findByGrade;
	}

	@Override
	public SalGrade findByLosalGreaterThanAndHisalLessThan(Double sal) {
		return salGradeRepository.findByLosalGreaterThanAndHisalLessThan(sal);
	}

	@Override
	@Cacheable(value="SalGradeCache")
	public SalGrade findOne(Integer grade) {
		return super.findOne(grade);
	}

	@Override
	public void savePojo(SalGrade salGrade) {
		salGradeMapper.savePojo(salGrade);
	}
	
}
