/**
 * 
 */
package com.user.wechat.processors;

import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;

/**
 * @author Junior
 * @date 2015年9月25日 下午10:15:46
 * @version 1.0
 * @since
 * @see
 */
public interface MessageProcessor<T extends MsgType> {

	public Message process(T requestMessage) throws ProcessorException;

}
