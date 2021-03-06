package com.yangfan.xiang.persist.repository.demo.dict;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.web.vo.LabelValueVo;
import com.yangfan.xiang.model.po.demo.dict.Dict;

public interface DictRepository extends CoreRepository<Dict, String> {
	
	/**
	 * 根据字典类型查询数据字典列表。
	 * @param dictType
	 * @return
	 */
	@Query("select d from Dict d where d.dictType.type = :dictType")
	List<Dict> findByDictType_type(@Param("dictType") String dictType);
	
	/**
	 * 查询所有数据字典，并抓取对应的字典类型。
	 * join fetch
	 * @return
	 */
	@Query("select d from Dict d join fetch d.dictType dt")
	List<Dict> findAllJoinFetchDictType();
	
	/**
	 * JPQL是一种强类型语言，一个JPQL语句中每个表达式都有类型。
	 * JPQL支持查询实体属性，但是要注意返回值，必要时需要再次手动构造对象。
	 * 
	 * @return
	 */
	@Query("select d.code, d.label from Dict d")
	List<Object[]> findCodeAndLabel();
	
	/**
	 * 构造器函数(CONSTRUCTOR EXPRESSION)
	 * 创建一个新的对象作为查询结果。这个对象不要求是实体，但要有一个构造器，它的顺序与类型与SELECT语句一致。
	 * 
	 * @return
	 */
	@Query("select new com.yangfan.xiang.core.web.vo.LabelValueVo(d.code, d.label) from Dict d")
	List<LabelValueVo> findCodeAndLabelNew();
	
}
