/**
 * 
 */
package com.user.wechat.responsers;

import java.sql.Timestamp;
import java.util.Random;

import com.halo.spring.utils.NullApplicationContextException;
import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.TextMessage;

/**
 * @author Junior
 * @date 2015年9月27日 上午11:41:38
 * @version 1.0
 * @since
 * @see
 */
public abstract class KeyResponser {

	private KeyResponser nextResponser;

	protected TextMessage responseTextMessage(String toUserName, String fromUserName, String content) {
		Random rand = new Random();
		long msgId = rand.nextLong();
		return new TextMessage(toUserName, fromUserName, new Timestamp(System.currentTimeMillis()), MsgType.TEXT, content, msgId);
	}

	protected Object getServletBean(String beanId) throws ResponserException {
		Object bean = null;
		try {
			bean = SpringUtils.getServletBean("mvcFramework", beanId);
		} catch (NullApplicationContextException e) {
			throw new ResponserException("Can't get bean servlet mvcFramework.", e);
		}
		return bean;
	}

	/**
	 * @return the nextResponser
	 */
	public KeyResponser getNextResponser() {
		return nextResponser;
	}

	/**
	 * @param nextResponser
	 *            the nextResponser to set
	 */
	public void setNextResponser(KeyResponser nextResponser) {
		this.nextResponser = nextResponser;
	}

	public abstract Message response(String toUserName, String fromUserName, String eventKey) throws ResponserException;

}
