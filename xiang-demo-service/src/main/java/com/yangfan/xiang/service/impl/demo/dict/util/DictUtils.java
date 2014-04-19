package com.yangfan.xiang.service.impl.demo.dict.util;

import java.util.List;

import com.yangfan.xiang.core.support.ApplicationContextHolder;
import com.yangfan.xiang.model.po.demo.dict.Dict;
import com.yangfan.xiang.service.iface.demo.dict.DictService;

/**
 * 字典工具类
 * 
 * 支持常见的获取数据字典的操作
 * 
 * @author 杨帆
 *
 */
public class DictUtils {
	
	private static DictService getDictService() {
		return ApplicationContextHolder.getBean(DictService.class);
	}
	
	/**
	 * 返回给定id的对象
	 * 
	 * @param id
	 * @return
	 */
	public static Dict findOne(String id) {
		return getDictService().findOne(id);
	}
	
	/**
	 * 根据字典类型查询字典列表，在缓存中查找，不再访问数据库。
	 * 
	 * @param dictType 字典类型
	 * @return 字典列表
	 */
	public static List<Dict> findByDictTypeFromCache(String dictType) {
		return getDictService().findByDictTypeFromCache(dictType);
	}
	
	/**
	 * 根据字典类型和字典代码查询数据字典，在缓存中查找，不再访问数据库。
	 * 
	 * @param dictType 字典类型
	 * @param code 字典代码
	 * @return
	 */
	public static Dict findByDictTypeAndCodeFromCache(String dictType, String code) {
		return getDictService().findByDictTypeAndCodeFromCache(dictType, code);
	}
	
	/**
	 * 根据字典类型和字典代码列表查询数据字典列表，在缓存中查找，不再访问数据库。
	 * 如果没找到，则返回null。
	 * 
	 * @param dictType
	 * @param codeList
	 * @return
	 */
	public List<Dict> findByDictTypeAndCodeFromCache(String dictType, List<String> codeList) {
		return getDictService().findByDictTypeAndCodeFromCache(dictType, codeList);
	}
	
	/**
	 * 根据字典类型和字典代码列表查询数据字典列表，在缓存中查找，不再访问数据库。
	 * 如果没找到，则返回null。
	 * 
	 * @param dictType
	 * @param codeList
	 * @return
	 */	
	public List<Dict> findByDictTypeAndCodeFromCache(String dictType, String[] codeList) {
		return getDictService().findByDictTypeAndCodeFromCache(dictType, codeList);
	}

}
