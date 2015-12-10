/**
 * 
 */
package com.user.wechat.db.daos.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.user.wechat.db.daos.ArticleCatalogDao;
import com.user.wechat.db.domains.ArticleCatalog;

/**
 * @author Junior
 * @date 2015年10月10日 下午10:31:17
 * @version 1.0
 * @since
 * @see
 */
@Repository("articleCatalogDao")
public class ArticleCatalogDaoImpl extends AbstractDaoImpl<ArticleCatalog> implements ArticleCatalogDao {

	@Override
	public long getArticlesCount() {
		String hql = "select count(*) from ArticleCatalog";
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hql);
		long count = (long) query.iterate().next();
		trans.commit();

		return count;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ArticleCatalog> findRecent() {
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setMaxResults(5);
		return (List<ArticleCatalog>) hibernateTemplate.find("from ArticleCatalog order by publishTime desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleCatalog> findArticles(final int firstRow, final int totalRow) {
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(ArticleCatalog.class);
		criteria.setFirstResult(firstRow);
		criteria.setMaxResults(totalRow);
		List<ArticleCatalog> results = (List<ArticleCatalog>) criteria.list();
		trans.commit();

		return results;
	}

}
