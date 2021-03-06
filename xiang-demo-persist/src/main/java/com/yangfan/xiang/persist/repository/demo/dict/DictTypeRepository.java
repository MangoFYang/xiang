package com.yangfan.xiang.persist.repository.demo.dict;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.model.po.demo.dict.DictType;

public interface DictTypeRepository extends CoreRepository<DictType, String> {
	
	@Query("select distinct dt from DictType dt join fetch dt.dicts d")
	List<DictType> findAllJoinFetchDict();
	
}
