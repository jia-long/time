package common.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import common.dao.BaseDao;
import common.model.Page;
import common.service.BaseService;

public class BaseServiceImpl<T extends Serializable, PK extends Serializable> implements BaseService<T, PK> {
	
	public BaseDao<T, PK> baseDao;

	public void setBaseDao(BaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public T get(PK id) {
		return baseDao.get(id);
	}

	@Override
	public T load(PK id) {
		
		return baseDao.load(id);
	}

	@Override
	public List<T> loadAll() {
		return baseDao.loadAll();
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void save(T entity) {
		baseDao.save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<T> entities) {
		baseDao.saveOrUpdateAll(entities);
	}

	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	public void deleteByKey(PK id) {
		baseDao.deleteByKey(id);
	}

	@Override
	public void deleteAll(Collection<T> entities) {
		baseDao.deleteAll(entities);
	}

	@Override
	public List<?> getListForPage(String hql, int pageNo, int pageContSize) {
		return baseDao.getListForPage(hql, pageNo, pageContSize);
	}

	@Override
	public Page getPage(String hql, int pageNo, int pageCountSize) {
		return baseDao.getPage(hql, pageNo, pageCountSize);
	}

	@Override
	public int bulkUpdate(String queryString) {
		return baseDao.bulkUpdate(queryString);
	}

	@Override
	public int bulkUpdate(String queryString, Object... values) {
		return baseDao.bulkUpdate(queryString, values);
	}

	@Override
	public List<T> find(String queryString) {
		return baseDao.find(queryString);
	}

	@Override
	public List<T> find(String queryString, Object value) {
		return baseDao.find(queryString, value);
	}

	@Override
	public List<T> find(String queryString, Object... values) {
		return baseDao.find(queryString, values);
	}

	@Override
	public List<T> findByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		
		return baseDao.findByNamedParam(queryString, paramNames, values);
	}

	@Override
	public List<T> findByNamedQuery(String queryName) {
		return baseDao.findByNamedQuery(queryName);
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object value) {
		return baseDao.findByNamedQuery(queryName, value);
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object... values) {
		return baseDao.findByNamedQuery(queryName, values);
	}

	@Override
	public List<T> findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) {
		return baseDao.findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	@Override
	public Iterator<T> iterate(String queryString) {
		return baseDao.iterate(queryString);
	}

	@Override
	public Iterator<T> iterate(String queryString, Object... values) {
		return baseDao.iterate(queryString, values);
	}

	@Override
	public void closeIterator(Iterator<T> it) {
		baseDao.closeIterator(it);
	}

	@Override
	public void flush() {
		baseDao.flush();
	}
	
}
