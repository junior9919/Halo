/**
 * 
 */
package com.user.wechat.responsers;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.messages.Message;
import com.user.wechat.mvc.services.ArticleCatalogService;

/**
 * @author Junior
 * @date 2015年10月10日 下午10:41:10
 * @version 1.0
 * @since
 * @see
 */
public class TechArticleResponser extends KeyResponser {

	@Override
	public Message response(String toUserName, String fromUserName, String eventKey) throws ResponserException {
		if ("tech_article".equals(eventKey)) {
			ArticleCatalogService articleCatalogService = (ArticleCatalogService) getServletBean("articleCatalogService");
			return articleCatalogService.getRecentNews(toUserName, fromUserName);
		} else {
			if (null != getNextResponser()) {
				return getNextResponser().response(toUserName, fromUserName, eventKey);
			} else {
				String content = SpringUtils.getMessage("response.do_not_touch", null);
				return responseTextMessage(toUserName, fromUserName, content);
			}
		}
	}

}
