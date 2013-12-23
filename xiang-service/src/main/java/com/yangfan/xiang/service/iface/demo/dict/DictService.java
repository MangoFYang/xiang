package com.yangfan.xiang.service.iface.demo.dict;

import java.util.List;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.domain.demo.dict.Dict;

public interface DictService extends CoreService<Dict, String> {
	
	/**
	 * 根据字典类型查询字典列表，在缓存中查找，不再访问数据库。
	 * 如果没找到，则返回null。
	 * 
	 * @param dictType 字典类型
	 * @return 字典列表
	 */
	List<Dict> findByDictTypeFromCache(String dictType);
	
	/**
	 * 根据字典类型和字典代码查询数据字典，在缓存中查找，不再访问数据库。
	 * 如果没找到，则返回null。
	 * 
	 * @param dictType 字典类型
	 * @param code 字典代码
	 * @return
	 */
	Dict findByDictTypeAndCodeFromCache(String dictType, String code);
	
	/**
	 * 根据字典类型和字典代码列表查询数据字典列表，在缓存中查找，不再访问数据库。
	 * 如果没找到，则返回null。
	 * 
	 * @param dictType
	 * @param codeList
	 * @return
	 */
	public List<Dict> findByDictTypeAndCodeFromCache(String dictType, List<String> codeList);

	/**
	 * 根据字典类型和字典代码列表查询数据字典列表，在缓存中查找，不再访问数据库。
	 * 如果没找到，则返回null。
	 * 
	 * @param dictType
	 * @param codeList
	 * @return
	 */	
	public List<Dict> findByDictTypeAndCodeFromCache(String dictType, String[] codeList);
	
	/**
	 * 查询所有数据字典，并抓取对应字典类型
	 * 
	 * @return
	 */
	List<Dict> findAllJoinFetchDictType();
	
}
