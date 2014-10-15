package common.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import common.dao.BaseDao;
import common.model.Page;

public class BaseDaoImpl<T extends Serializable, PK extends Serializable>
		extends HibernateDaoSupport implements BaseDao<T, PK> {

	private Class<T> entityClass;

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void clear() {
		super.getSession().clear();
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	// 插入记录
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	// 更新相应是实体记录
	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);

	}

	// 删除相应实体记录
	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);

	}

	// 根据主键获取实体。如果没有相应的实体，返回 null。
	@Override
	public T get(PK id) {
		return getHibernateTemplate().get(getEntityClass(), id);
	}

	// 根据主键获取实体。如果没有相应的实体，抛出异常。
	@Override
	public T load(PK id) {
		return getHibernateTemplate().load(getEntityClass(), id);
	}

	// 获取全部实体。
	@Override
	public List<T> loadAll() {

		return getHibernateTemplate().loadAll(getEntityClass());
	}

	// 保存或更新
	@Override
	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);

	}

	// 返回分页对象
	@SuppressWarnings("unchecked")
	@Override
	public Page getPage(final String hql, final int pageNo,
			final int pageCountSize) {
		return getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query queryCount = session.createQuery("SELECT COUNT(*)  "
						+ hql);
				Integer totalSize = (new Integer(queryCount.uniqueResult()
						.toString())).intValue();
				Query query = session.createQuery(hql);
				query.setFirstResult((pageNo - 1) * pageCountSize);
				query.setMaxResults(pageCountSize);
				List<?> list = query.list();
				return new Page(pageNo, pageCountSize, totalSize, list);
			}

		});

	}

	// 获取分页list集合
	@SuppressWarnings("unchecked")
	public List<?> getListForPage(final String hql, final int pageNo,
			final int pageCountSize) {
		return getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageNo - 1) * pageCountSize);
				query.setMaxResults(pageCountSize);
				return query.list();
			}
		});
	}

	@Override
	public void saveOrUpdateAll(Collection<T> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);

	}

	@Override
	public void deleteByKey(PK id) {
		delete(get(id));
	}

	@Override
	public void deleteAll(Collection<T> entities) {
		getHibernateTemplate().deleteAll(entities);
	}

	@Override
	public int bulkUpdate(String queryString) {

		return getHibernateTemplate().bulkUpdate(queryString);
	}

	@Override
	public int bulkUpdate(String queryString, Object... values) {
		return getHibernateTemplate().bulkUpdate(queryString, values);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String queryString, Object... values) {
		return getHibernateTemplate().find(queryString, values);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String queryString, Object value) {
		
		return getHibernateTemplate().find(queryString, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String queryName, Object value) {
		return getHibernateTemplate().findByNamedQuery(queryName, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		return getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String queryString) {
		return getHibernateTemplate().find(queryString);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String queryName, Object... values) {
		
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) {
		
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterate(String queryString) {
		
		return getHibernateTemplate().iterate(queryString);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterate(String queryString, Object... values) {
		
		return getHibernateTemplate().iterate(queryString, values);
	}

	@Override
	public void closeIterator(Iterator<T> it) {
		getHibernateTemplate().closeIterator(it);

	}

	@Override
	public void flush() {
		getHibernateTemplate().flush();

	}

}
