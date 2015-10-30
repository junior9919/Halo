/**
 * 
 */
package com.user.wechat.processors;

import org.springframework.beans.BeansException;

import com.halo.spring.utils.NullApplicationContextException;
import com.halo.spring.utils.SpringUtils;

/**
 * @author Junior
 * @date 2015年9月26日 上午11:53:31
 * @version 1.0
 * @since
 * @see
 */
public abstract class AbstractProcessor {

	public Object getServletBean(String beanId) throws ProcessorException {
		Object bean = null;
		try {
			bean = SpringUtils.getServletBean("mvcFramework", beanId);
		} catch (NullApplicationContextException e) {
			throw new ProcessorException("Can't get bean servlet mvcFramework.", e);
		}
		return bean;
	}

	public Object getBean(String beanId) throws ProcessorException {
		Object bean = null;
		try {
			bean = SpringUtils.getBean(beanId);
		} catch (NullApplicationContextException | BeansException e) {
			throw new ProcessorException("Can't get bean " + beanId, e);
		}
		return bean;
	}

}
