/**
 * 
 */
package com.user.wechat.processors;

import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.ScanEvent;

/**
 * @author Junior
 * @date 2015年9月25日 下午10:20:30
 * @version 1.0
 * @since
 * @see
 */
public class ScanEventProcessor extends AbstractProcessor implements MessageProcessor<ScanEvent> {

	@Override
	public Message process(ScanEvent requestMessage) throws ProcessorException {
		return null;
	}

}
