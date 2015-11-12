/**
 * 
 */
package com.user.wechat.mvc.services;

import com.halo.wechat.messages.Message;

/**
 * @author Junior
 * @date 2015年10月25日 上午10:11:57
 * @version 1.0
 * @since
 * @see
 */
public interface ArticleCatalogService {

	public Message getRecentNews(String toUserName, String fromUserName);

}
