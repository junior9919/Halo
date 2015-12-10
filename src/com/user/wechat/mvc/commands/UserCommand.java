/**
 *
 */
package com.user.wechat.mvc.commands;

import com.halo.spring.utils.NullApplicationContextException;
import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.messages.Event;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.mvc.commands.Command;
import com.halo.wechat.mvc.commands.CommandException;
import com.user.wechat.processors.MessageProcessor;
import com.user.wechat.processors.ProcessorException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;

/**
 * @author Junior
 * @version 1.0
 * @file UserCommand.java
 * @date 2015年8月9日 上午11:21:44
 */
@Component
public class UserCommand implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public Message processMessage(Message receiveMessage) throws CommandException {
		String processorBeanId = receiveMessage.getMsgType().toLowerCase() + "_message_processor";
		MessageProcessor<MsgType> messageProcessor;
		try {
			messageProcessor = (MessageProcessor<MsgType>) SpringUtils.getBean(processorBeanId);
		} catch (NullApplicationContextException | NoSuchBeanDefinitionException e) {
			throw new CommandException("Get message processor bean failed.", e);
		}

		Message responseMessage;
		try {
			responseMessage = messageProcessor.process(receiveMessage);
		} catch (ProcessorException e) {
			throw new CommandException("Process message error.", e);
		}
		return responseMessage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Message processEvent(Event receiveEvent) throws CommandException {
		if ("view".equals(receiveEvent.getEvent().toLowerCase())) {
			return null;
		}
		
		String processorBeanId = receiveEvent.getEvent().toLowerCase() + "_event_processor";

		MessageProcessor<MsgType> messageProcessor;
		try {
			messageProcessor = (MessageProcessor<MsgType>) SpringUtils.getBean(processorBeanId);
		} catch (NullApplicationContextException | NoSuchBeanDefinitionException e) {
			throw new CommandException("Get event processor bean failed.", e);
		}

		Message responseMessage;
		try {
			responseMessage = messageProcessor.process(receiveEvent);
		} catch (ProcessorException e) {
			throw new CommandException("Process event error.", e);
		}
		return responseMessage;
	}

}
