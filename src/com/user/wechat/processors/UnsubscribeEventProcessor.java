package com.user.wechat.processors;

import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.UnsubscribeEvent;
import com.user.wechat.mvc.services.DeveloperInfoService;

public class UnsubscribeEventProcessor extends AbstractProcessor implements MessageProcessor<UnsubscribeEvent> {

	@Override
	public Message process(UnsubscribeEvent requestMessage) throws ProcessorException {
		DeveloperInfoService developerInfoService = (DeveloperInfoService) getServletBean("developerInfoService");
		developerInfoService.withdrawUserInfo(requestMessage.getFromUserName());
		return null;
	}

}
