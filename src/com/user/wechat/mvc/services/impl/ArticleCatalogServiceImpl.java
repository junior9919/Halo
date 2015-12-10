/**
 * 
 */
package com.user.wechat.mvc.services.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.NewsMessage;
import com.halo.wechat.messages.TextMessage;
import com.user.wechat.db.daos.ArticleCatalogDao;
import com.user.wechat.db.domains.ArticleCatalog;
import com.user.wechat.mvc.services.ArticleCatalogService;

/**
 * @author Junior
 * @date 2015年10月25日 上午10:13:19
 * @version 1.0
 * @since
 * @see
 */
@Service("articleCatalogService")
public class ArticleCatalogServiceImpl implements ArticleCatalogService {

	@Autowired
	ArticleCatalogDao articleCatalogDao;

	@Override
	public Message getRecentNews(String toUserName, String fromUserName) {
		List<ArticleCatalog> articleCatalogs = articleCatalogDao.findRecent();

		if (articleCatalogs.isEmpty()) {
			TextMessage message = new TextMessage();
			message.setToUserName(toUserName);
			message.setFromUserName(fromUserName);
			message.setCreateTime(new Timestamp(System.currentTimeMillis()));
			message.setMsgType(MsgType.TEXT);
			message.setContent(SpringUtils.getMessage("response.NotHaveArticle", null));

			return message;
		} else {
			NewsMessage message = new NewsMessage();
			List<NewsMessage.Item> items = new LinkedList<NewsMessage.Item>();
			int i = 0;
			for (ArticleCatalog articleCatalog : articleCatalogs) {
				NewsMessage.Item item = message.new Item();
				item.setTitle(articleCatalog.getTitle());
				item.setDescription(articleCatalog.getDescription());
				if (0 == i) {
					item.setPicUrl(articleCatalog.getBigPicUrl());
				} else {
					item.setPicUrl(articleCatalog.getSmallPicUrl());
				}
				item.setUrl(articleCatalog.getUrl());
				items.add(item);
				i++;
			}

			message.setToUserName(toUserName);
			message.setFromUserName(fromUserName);
			message.setCreateTime(new Timestamp(System.currentTimeMillis()));
			message.setMsgType(MsgType.NEWS);
			message.setArticleCount(items.size());
			NewsMessage.Articles articles = message.new Articles();
			articles.setItems(items);
			message.setArticles(articles);

			return message;
		}
	}

	@Override
	public long getArticlesCount() {
		return articleCatalogDao.getArticlesCount();
	}

	@Override
	public List<Map<String, String>> searchArticles(int firstRow, int totalRow) {
		List<ArticleCatalog> articles = articleCatalogDao.findArticles(firstRow, totalRow);
		List<Map<String, String>> results = new LinkedList<Map<String, String>>();
		for (ArticleCatalog articleCatalog : articles) {
			Map<String, String> article = new HashMap<String, String>();
			article.put("url", articleCatalog.getUrl());
			article.put("title", articleCatalog.getTitle());
			results.add(article);
		}
		return results;
	}

}
