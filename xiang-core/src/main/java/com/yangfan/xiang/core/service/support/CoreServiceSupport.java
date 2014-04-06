package com.yangfan.xiang.core.service.support;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.core.web.CoreRequest;
import com.yangfan.xiang.core.web.CoreResponse;
import com.yangfan.xiang.core.web.CoreResponseImpl;

/**
 * 抽象的Service实现，支持缓存服务。
 * 
 * @author 杨帆
 *
 * @param <T> 实体类
 * @param <ID> 主键
 */
public abstract class CoreServiceSupport<T, ID extends Serializable> extends CacheServiceSupport implements CoreService<T, ID> {
	
	protected abstract CoreRepository<T, ID> getRepository();
	
	@Override
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public List<T> findAll(Sort sort) {
		return getRepository().findAll(sort);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		return getRepository().save(entities);
	}

	@Override
	public void flush() {
		getRepository().flush();
	}

	@Override
	public T saveAndFlush(T entity) {
		return getRepository().saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		getRepository().deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		getRepository().deleteAllInBatch();
	}
	
	@Override
	public CoreResponse<T> findAll(CoreRequest coreRequest) {
		CoreResponse<T> coreResponse = new CoreResponseImpl<T>(
				getRepository().findAll(coreRequest), coreRequest.getFilter());
		return coreResponse;
	}

	@Override
	public <S extends T> S save(S entity) {
		return getRepository().save(entity);
	}

	@Override
	public T findOne(ID id) {
		return getRepository().findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return getRepository().exists(id);
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		return getRepository().findAll(ids);
	}

	@Override
	public long count() {
		return getRepository().count();
	}

	@Override
	public void delete(ID id) {
		getRepository().delete(id);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		getRepository().delete(entities);
	}

	@Override
	public void deleteAll() {
		getRepository().deleteAll();
	}
	
}