/**
 * 
 */
package com.user.wechat.db.daos.impl;

import java.util.List;

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

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ArticleCatalog> findRecent() {
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setMaxResults(5);
		return (List<ArticleCatalog>) hibernateTemplate.find("from ArticleCatalog order by publishTime desc");
	}

}
