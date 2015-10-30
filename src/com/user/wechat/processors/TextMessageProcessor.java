/**
 * 
 */
package com.user.wechat.processors;

import java.sql.Timestamp;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.TextMessage;

/**
 * @author Junior
 * @date 2015年10月25日 下午3:25:49
 * @version 1.0
 * @since
 * @see
 */
public class TextMessageProcessor extends AbstractProcessor implements MessageProcessor<TextMessage> {

	@Override
	public Message process(TextMessage requestMessage) throws ProcessorException {
		String responseText = SpringUtils.getMessage("response.hello", null);
		return new TextMessage(requestMessage.getFromUserName(), requestMessage.getToUserName(), new Timestamp(System.currentTimeMillis()), MsgType.TEXT,
				responseText, 0);
	}

}
