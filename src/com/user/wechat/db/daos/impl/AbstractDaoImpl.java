package com.user.wechat.db.daos.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.user.wechat.db.daos.AbstractDao;

/**
 * @author Junior
 * @date 2015年9月15日 下午9:44:43
 * @version 1.0
 * @since
 * @see
 */
public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		if (null == hibernateTemplate) {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
		return hibernateTemplate;
	}

	public T get(Class<T> clazz, Integer id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public Integer save(T obj) {
		return (Integer) getHibernateTemplate().save(obj);
	}

	public void update(T obj) {
		getHibernateTemplate().update(obj);
	}

	public void delete(Class<T> clazz, Integer id) {
		getHibernateTemplate().delete(get(clazz, id));
	}

	public void delete(T obj) {
		getHibernateTemplate().delete(obj);
	}

}
