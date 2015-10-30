/**
 * 
 */
package com.user.wechat.processors;

import com.halo.wechat.messages.ClickEvent;
import com.halo.wechat.messages.Message;
import com.user.wechat.responsers.KeyResponser;
import com.user.wechat.responsers.KeyResponserBuilder;
import com.user.wechat.responsers.KeyResponserException;
import com.user.wechat.responsers.ResponserException;

/**
 * @author Junior
 * @date 2015年9月27日 上午11:09:58
 * @version 1.0
 * @since
 * @see
 */
public class ClickEventProcessor extends AbstractProcessor implements MessageProcessor<ClickEvent> {

	@Override
	public Message process(ClickEvent requestMessage) throws ProcessorException {
		KeyResponserBuilder keyResponserBuilder = (KeyResponserBuilder) getBean("keyResponserBuilder");
		KeyResponser keyResponser;
		try {
			keyResponser = keyResponserBuilder.buildKeyResponser();
		} catch (KeyResponserException e) {
			throw new ProcessorException("Can't build responser.");
		}
		try {
			return keyResponser.response(requestMessage.getFromUserName(), requestMessage.getToUserName(), requestMessage.getEventKey());
		} catch (ResponserException e) {
			throw new ProcessorException("Error response message.");
		}
	}

}
