/**
 * 
 */
package com.user.wechat.processors;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.messages.LocationMessage;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.TextMessage;
import com.user.wechat.mvc.services.UserTraceService;

/**
 * @author Junior
 * @date 2015年10月24日 下午8:34:21
 * @version 1.0
 * @since
 * @see
 */
public class LocationMessageProcessor extends AbstractProcessor implements MessageProcessor<LocationMessage> {

	@Override
	public Message process(LocationMessage requestMessage) throws ProcessorException {
		UserTraceService userTraceService = (UserTraceService) getServletBean("userTraceService");
		int id = userTraceService.recordUserTrace(requestMessage.getFromUserName(), new BigDecimal(requestMessage.getLocation_X()), new BigDecimal(
				requestMessage.getLocation_Y()), null, new Integer(requestMessage.getScale()), requestMessage.getLabel(), new Date());

		String responseText = "";
		if (0 <= id) {
			responseText = SpringUtils.getMessage("response.location",
					new String[] { String.valueOf(requestMessage.getLocation_Y()), String.valueOf(requestMessage.getLocation_X()), requestMessage.getLabel() });
		} else {
			responseText = SpringUtils.getMessage("response.record_fail", null);
		}
		return new TextMessage(requestMessage.getFromUserName(), requestMessage.getToUserName(), new Timestamp(System.currentTimeMillis()), MsgType.TEXT,
				responseText, 0);
	}

}
