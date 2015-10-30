/**
 * 
 */
package com.user.wechat.responsers;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.messages.Message;

/**
 * @author Junior
 * @date 2015年9月27日 下午12:21:15
 * @version 1.0
 * @since
 * @see
 */
public class TipResponser extends KeyResponser {

	@Override
	public Message response(String toUserName, String fromUserName, String eventKey) throws ResponserException {
		String content = "";

		if ("tip".equals(eventKey)) {
			content = SpringUtils.getMessage("response.tip", null);
			return responseTextMessage(toUserName, fromUserName, content);
		} else {
			if (null != getNextResponser()) {
				return getNextResponser().response(toUserName, fromUserName, eventKey);
			} else {
				content = SpringUtils.getMessage("response.do_not_touch", null);
				return responseTextMessage(toUserName, fromUserName, content);
			}
		}
	}

}
