package com.yangfan.xiang.core.web.support;

import java.util.List;

import com.yangfan.xiang.core.web.domain.CoreCondition;
import com.yangfan.xiang.core.web.domain.CoreFilter;
import com.yangfan.xiang.core.web.domain.CoreOrder;
import com.yangfan.xiang.core.web.domain.CorePager;
import com.yangfan.xiang.core.web.domain.CoreRequest;
import com.yangfan.xiang.core.web.domain.CoreSorter;
import com.yangfan.xiang.core.web.domain.DefaultCoreRequest;

public abstract class CoreRequestFactory {
	
	/**
	 * 
	 * 根据页码和每页记录数创建CoreRequest
	 * 
	 * @param page 页码，第一页为0
	 * @param size 每页记录数
	 * @return
	 */
	public CoreRequest createCoreRequest(int page, int size) {
		return new DefaultCoreRequest(new CorePager(page, size));
	}
	
	/**
	 * 
	 * 根据页码、每页记录数、单属性排序创建CoreRequest
	 * 
	 * @param page 页码，第一页为0
	 * @param size 每页记录数
	 * @param property 排序属性
	 * @param direction 顺序，ASC(升序)、DESC(降序)
	 * @return
	 */
	public CoreRequest createCoreRequest(int page, int size, String property, String direction) {
		return new DefaultCoreRequest(new CorePager(page, size), new CoreSorter(property, direction), null);
	}
	
	/**
	 * 
	 * 根据页码、每页记录数、多属性排序创建、多过滤条件创建CoreRequest
	 * 
	 * @param page 页码，第一页为0
	 * @param size 每页记录数
	 * @param property 排序属性
	 * @param direction 顺序，ASC(升序)、DESC(降序)
	 * @param conditionList 过滤条件
	 * 				List<CoreCondition> conditionList = new ArrayList<CoreCondition>();
	 * 				conditionList.add(new CoreCondition("prop1", "aaa"));
	 * 				conditionList.add(new CoreCondition("prop2", "bbb"));
	 * @return
	 */
	public CoreRequest createCoreRequest(int page, int size, String property, String direction, List<CoreCondition> conditionList) {
		return new DefaultCoreRequest(new CorePager(page, size), new CoreSorter(property, direction), new CoreFilter(conditionList));
	}
	
	/**
	 * 
	 * 根据页码、每页记录数、多属性排序创建CoreRequest
	 * 
	 * @param page 页码，第一页为0
	 * @param size 每页记录数
	 * @param orderList 顺序列表，ASC(升序)、DESC(降序)
	 * 				List<CoreOrder> orderList = new ArrayList<CoreOrder>()
	 * 				orderList.add(new CoreSorter("prop1", "DESC"));
	 * 				orderList.add(new CoreSorter("prop2", "ASC"));
	 * @return
	 */
	public CoreRequest createCoreRequest(int page, int size, List<CoreOrder> orderList) {
		return new DefaultCoreRequest(new CorePager(page, size), new CoreSorter(orderList), null);
	}
	
	/**
	 * 
	 * 根据页码、每页记录数、多属性排序创建、多过滤条件创建CoreRequest
	 * 
	 * @param page 页码，第一页为0
	 * @param size 每页记录数
	 * @param orderList 顺序列表，ASC(升序)、DESC(降序)
	 * 				List<CoreOrder> orderList = new ArrayList<CoreOrder>();
	 * 				orderList.add(new CoreSorter("prop1", "DESC"));
	 * 				orderList.add(new CoreSorter("prop2", "ASC"));
	 * @param conditionList 过滤条件
	 * 				List<CoreCondition> conditionList = new ArrayList<CoreCondition>();
	 * 				conditionList.add(new CoreCondition("prop1", "aaa"));
	 * 				conditionList.add(new CoreCondition("prop2", "bbb"));
	 * @return
	 */
	public CoreRequest createCoreRequest(int page, int size, List<CoreOrder> orderList, List<CoreCondition> conditionList) {
		return new DefaultCoreRequest(new CorePager(page, size), new CoreSorter(orderList), new CoreFilter(conditionList));
	}
	
	/**
	 * 
	 * 根据单属性排序创建CoreRequest
	 * 
	 * @param property 排序属性
	 * @param direction 顺序，ASC(升序)、DESC(降序)
	 * @return
	 */
	public CoreRequest createCoreRequest(String property, String direction) {
		return new DefaultCoreRequest(new CoreSorter(property, direction));
	}
	
	/**
	 * 
	 * 根据多属性排序创建、多过滤条件创建CoreRequest
	 * 
	 * @param property 排序属性
	 * @param direction 顺序，ASC(升序)、DESC(降序)
	 * @param conditionList 过滤条件
	 * 				List<CoreCondition> conditionList = new ArrayList<CoreCondition>();
	 * 				conditionList.add(new CoreCondition("prop1", "aaa"));
	 * 				conditionList.add(new CoreCondition("prop2", "bbb"));
	 * @return
	 */
	public CoreRequest createCoreRequest(String property, String direction, List<CoreCondition> conditionList) {
		return new DefaultCoreRequest(null, new CoreSorter(property, direction), new CoreFilter(conditionList));
	}
	
	/**
	 * 
	 * 根据多属性排序创建、多过滤条件创建CoreRequest
	 * 
	 * @param orderList 顺序列表，ASC(升序)、DESC(降序)
	 * 				List<CoreOrder> orderList = new ArrayList<CoreOrder>();
	 * 				orderList.add(new CoreSorter("prop1", "DESC"));
	 * 				orderList.add(new CoreSorter("prop2", "ASC"));
	 * @param conditionList 过滤条件
	 * 				List<CoreCondition> conditionList = new ArrayList<CoreCondition>();
	 * 				conditionList.add(new CoreCondition("prop1", "aaa"));
	 * 				conditionList.add(new CoreCondition("prop2", "bbb"));
	 * @return
	 */
	public CoreRequest createCoreRequest(List<CoreOrder> orderList, List<CoreCondition> conditionList) {
		return new DefaultCoreRequest(null, new CoreSorter(orderList), new CoreFilter(conditionList));
	}
	
	/**
	 * 
	 * 根据多过滤条件创建CoreRequest
	 * 
	 * @param conditionList 过滤条件
	 * 				List<CoreCondition> conditionList = new ArrayList<CoreCondition>();
	 * 				conditionList.add(new CoreCondition("prop1", "aaa"));
	 * 				conditionList.add(new CoreCondition("prop2", "bbb"));
	 * @return
	 */
	public CoreRequest createCoreRequest(List<CoreCondition> conditionList) {
		return new DefaultCoreRequest(new CoreFilter(conditionList));
	}
	
	/**
	 * 
	 * 最灵活的构造CoreRequest
	 * 
	 * @param pager 分页信息
	 * @param sorter 排序信息
	 * @param filter 过滤信息
	 * @return 
	 */
	public CoreRequest createCoreRequest(CorePager pager, CoreSorter sorter, CoreFilter filter) {
		return new DefaultCoreRequest(pager, sorter, filter);
	}
	
}
