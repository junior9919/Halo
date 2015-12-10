/**
 * 
 */
package com.user.wechat.db.daos;

import java.util.List;

import com.user.wechat.db.domains.ArticleCatalog;

/**
 * @author Junior
 * @date 2015年10月10日 下午10:25:05
 * @version 1.0
 * @since
 * @see
 */
public interface ArticleCatalogDao extends AbstractDao<ArticleCatalog> {

	public long getArticlesCount();

	public List<ArticleCatalog> findRecent();

	public List<ArticleCatalog> findArticles(final int firstRow, final int totalRow);

}
