/**
 * 
 */
package com.user.wechat.processors;

import java.sql.Timestamp;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.SubscribeEvent;
import com.halo.wechat.messages.TextMessage;
import com.user.wechat.mvc.services.DeveloperInfoService;

/**
 * @author Junior
 * @date 2015年9月26日 下午8:41:45
 * @version 1.0
 * @since
 * @see
 */
public class SubscribeEventProcessor extends AbstractProcessor implements MessageProcessor<SubscribeEvent> {

	@Override
	public Message process(SubscribeEvent requestMessage) throws ProcessorException {
		Message responseMessage = null;
		String responseText = SpringUtils.getMessage("response.welcome", null);

		String openId = requestMessage.getFromUserName();
		DeveloperInfoService developerInfoService = (DeveloperInfoService) getServletBean("developerInfoService");
		developerInfoService.registUserAndDeveloper(openId);

		responseMessage = new TextMessage(requestMessage.getFromUserName(), requestMessage.getToUserName(), new Timestamp(System.currentTimeMillis()),
				MsgType.TEXT, responseText, 0);
		return responseMessage;
	}

}
