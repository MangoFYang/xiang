package com.yangfan.xiang.service.impl.support.ehcache;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.service.support.CacheServiceSupport;
import com.yangfan.xiang.model.po.demo.dict.Dict;
import com.yangfan.xiang.model.po.demo.emp.SalGrade;
import com.yangfan.xiang.service.iface.demo.dict.DictService;
import com.yangfan.xiang.service.iface.demo.emp.SalGradeService;
import com.yangfan.xiang.service.iface.support.ehcache.CacheLoaderService;

/**
 * 启动服务，加载缓存服务实现类
 * 
 * @author 杨帆
 *
 */
@Service
public class CacheLoaderServiceImpl extends CacheServiceSupport implements CacheLoaderService {
	
	private final String START_LOG = "开始加载[{}]缓存...";
	private final String END_LOG = "加载[{}]缓存完成, 用时: {} ms.";
	
	private final String SAL_GRADE = "薪资等级";
	private final String DICT = "数据字典";

	@Resource
	private SalGradeService salGradeService;
	@Resource
	private DictService dictService;

	@Override
	@PostConstruct
	public void load() {
		
		// 加载薪资等级缓存
		//this.loadSalGradeCache();
		
		// 加载数据字典缓存
		//this.loadDictCache();
	}
	
	/**
	 * 加载薪资等级缓存
	 * @param dataType 数据类型
	 */
	public void loadSalGradeCache() {
		this.logger.info(START_LOG, SAL_GRADE);
		long start = System.currentTimeMillis();
		Cache cache = this.getSpringCache("SalGradeCache");
		List<SalGrade> findAll = salGradeService.findAll();
		for (Iterator<SalGrade> iterator = findAll.iterator(); iterator.hasNext();) {
			SalGrade salGrade = iterator.next();
			cache.put(salGrade.getGrade(), salGrade);
		}
		this.logger.info(END_LOG, SAL_GRADE, System.currentTimeMillis() - start);
	}

	/**
	 * 加载薪资等级缓存
	 * @param dataType 数据类型
	 */
	public void loadDictCache() {
		this.logger.info(START_LOG, DICT);
		long start = System.currentTimeMillis();
		Cache cache = this.getSpringCache("DictCache");
		List<Dict> findAll = dictService.findAllJoinFetchDictType();
		for (Iterator<Dict> iterator = findAll.iterator(); iterator.hasNext();) {
			Dict dict = iterator.next();
			cache.put(dict.getId(), dict);
		}
		this.logger.info(END_LOG, DICT, System.currentTimeMillis() - start);
	}

	
}
