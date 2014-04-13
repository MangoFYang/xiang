package com.yangfan.xiang.core.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface CoreService<T, ID extends Serializable> {
	
	/**
	 * 返回所有给定类型的对象列表
	 * 
	 * @return 所有对象的列表
	 */
	public List<T> findAll();

	/**
	 * 通过给定的排序规则返回被排序的对象列表
	 * 
	 * @param sort 排序规则
	 * @return all 被排序的对象列表
	 */
	public List<T> findAll(Sort sort);
	
	/**
	 * 返回符合分页规则的对象列表
	 * 
	 * @param pageable 分页规则
	 * @return 符合分页规则的对象列表
	 */
	public Page<T> findAll(Pageable pageable);

	/**
	 * 保存给定的所有对象
	 * 
	 * @param entities 待保存的对象列表
	 * @return 被保存的对象列表
	 * @throws IllegalArgumentException 如果某个对象为null.
	 */
	public <S extends T> List<S> save(Iterable<S> entities);

	/**
	 * 将数据同步到数据库
	 */
	public void flush();

	/**
	 * 保存并立即同步到数据库
	 * 
	 * @param entity 待保存对象
	 * @return 已保存对象
	 */
	public T saveAndFlush(T entity);

	/**
	 * 批处理删除给定对象，这就意味着在一个单独的Query中。
	 * 
	 * @param entities 给定对象
	 */
	public void deleteInBatch(Iterable<T> entities);

	/**
	 * 批处理删除所有数据
	 */
	public void deleteAllInBatch();
	
	/**
	 * 保存给定对象
	 * 
	 * @param entity 待保存对象
	 * @return 已保存对象
	 */
	public <S extends T> S save(S entity);

	/**
	 * 返回给定id的对象
	 * 
	 * @param 对象id，不能为空
	 * @return 返回给定id的对象，如果没找到返回null
	 * @throws IllegalArgumentException 如果id为空
	 */
	public T findOne(ID id);

	/**
	 * 给定id的对象是否存在
	 * 
	 * @param id 不能为空
	 * @return true 如果给定id的对象存在, 否则false
	 * @throws IllegalArgumentException 如果id不存在
	 */
	public boolean exists(ID id);

	/**
	 * 返回给定id列表的对象列表
	 * 
	 * @param ids 给定id列表
	 * @return 给定id列表的对象列表
	 */
	public Iterable<T> findAll(Iterable<ID> ids);

	/**
	 * 返回记录总数
	 * 
	 * @return the number of entities
	 */
	public long count();

	/**
	 * 删除给定id的对象
	 * 
	 * @param id 对象id，不能为空
	 * @throws IllegalArgumentException 如果id为空
	 */
	public void delete(ID id);

	/**
	 * 删除给定对象
	 * 
	 * @param entity 待删除对象
	 * @throws IllegalArgumentException 如果entity为空
	 */
	public void delete(T entity);

	/**
	 * 删除给定对象列表
	 * 
	 * @param 待删除对象列表
	 * @throws IllegalArgumentException 如果entities为空
	 */
	public void delete(Iterable<? extends T> entities);

	/**
	 * 删除所有数据
	 */
	public void deleteAll();

}
