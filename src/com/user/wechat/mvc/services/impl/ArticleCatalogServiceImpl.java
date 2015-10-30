/**
 * 
 */
package com.user.wechat.mvc.services.impl;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.NewsMessage;
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
	public NewsMessage getRecentNews(String toUserName, String fromUserName) {
		List<ArticleCatalog> articleCatalogs = articleCatalogDao.findRecent();

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
