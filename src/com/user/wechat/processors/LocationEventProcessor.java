/**
 * 
 */
package com.user.wechat.processors;

import java.math.BigDecimal;
import java.util.Date;

import com.halo.wechat.messages.LocationEvent;
import com.halo.wechat.messages.Message;
import com.user.wechat.mvc.services.UserTraceService;

/**
 * @author Junior
 * @date 2015年9月26日 下午4:58:28
 * @version 1.0
 * @since
 * @see
 */
public class LocationEventProcessor extends AbstractProcessor implements MessageProcessor<LocationEvent> {

	@Override
	public Message process(LocationEvent requestMessage) throws ProcessorException {
		UserTraceService userTraceService = (UserTraceService) getServletBean("userTraceService");
		userTraceService.recordUserTrace(requestMessage.getFromUserName(), new BigDecimal(requestMessage.getLatitude()),
				new BigDecimal(requestMessage.getLongitude()), new BigDecimal(requestMessage.getPrecision()), null, null, new Date());

		return null;
	}

}
