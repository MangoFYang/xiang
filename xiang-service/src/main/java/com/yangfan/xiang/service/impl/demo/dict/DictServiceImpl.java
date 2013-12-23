package com.yangfan.xiang.service.impl.demo.dict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.expression.EqualTo;
import net.sf.ehcache.search.expression.InCollection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.domain.demo.dict.Dict;
import com.yangfan.xiang.persist.repository.demo.dict.DictRepository;
import com.yangfan.xiang.service.iface.demo.dict.DictService;

@Service
public class DictServiceImpl extends CoreServiceSupport<Dict, String> implements DictService {
	
	/**
	 * 字典缓存名
	 */
	private static final String DICT_CACHE = "DictCache";
	
	@Resource
	private DictRepository dictRepository;

	@Override
	protected CoreRepository<Dict, String> getRepository() {
		return dictRepository;
	}

	@Override
	public List<Dict> findByDictTypeFromCache(String dictType) {
		Assert.notNull(dictType, "参数dictType不能为null。");
		List<Dict> dictList = null;
		Query createQuery = this.getEhcache(DICT_CACHE).createQuery();
		List<Result> all = createQuery
				.addCriteria(new EqualTo("dictType", dictType))
				.includeValues()
				.execute().all();
		for (Result result : all) {
			if(dictList == null) {
				dictList = new ArrayList<Dict>();
			}
			Dict d = (Dict) result.getValue();
			dictList.add(d);
		}
		return dictList;
		/*
		List<Dict> findByDictType = dictRepository.findByDictType(dictType);
		return findByDictType;
		*/
	}
	
	@Override
	public List<Dict> findByDictTypeAndCodeFromCache(String dictType, String[] codeList) {
		return this.findByDictTypeAndCodeFromCache(dictType, Arrays.asList(codeList));
	}

	@Override
	public List<Dict> findByDictTypeAndCodeFromCache(String dictType, List<String> codeList) {
		Assert.notNull(dictType, "参数dictType不能为null。");
		Assert.notNull(codeList, "参数codeList不能为null。");
		List<Dict> dictList = null;
		Query createQuery = this.getEhcache(DICT_CACHE).createQuery();
		List<Result> all = createQuery
				.addCriteria(new EqualTo("dictType", dictType))
				.addCriteria(new InCollection("code", codeList))
				.includeValues()
				.execute().all();
		for (Result result : all) {
			if(dictList == null) {
				dictList = new ArrayList<Dict>();
			}
			Dict d = (Dict) result.getValue();
			dictList.add(d);
		}
		return dictList;
	}
	
	@Override
	public Dict findByDictTypeAndCodeFromCache(String dictType, String code) {
		Assert.notNull(dictType, "参数dictType不能为null。");
		Assert.notNull(code, "参数code不能为null。");
		Dict d = null;
		Query createQuery = this.getEhcache(DICT_CACHE).createQuery();
		List<Result> all = createQuery
				.addCriteria(new EqualTo("dictType", dictType))
				.addCriteria(new EqualTo("code", code))
				.includeValues()
				.execute().all();
		if(!all.isEmpty()) {
			d = (Dict) all.get(0).getValue();
		}
		return d;
	}
	
	@Override
	@Cacheable("DictCache")
	public Dict findOne(String id) {
		return super.findOne(id);
	}

	@Override
	public List<Dict> findAllJoinFetchDictType() {
		return dictRepository.findAllJoinFetchDictType();
	}

}
