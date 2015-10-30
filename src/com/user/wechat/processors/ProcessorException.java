/**
 * 
 */
package com.user.wechat.processors;

/**
 * @author Junior
 * @date 2015年9月26日 上午11:56:05
 * @version 1.0
 * @since
 * @see
 */
public class ProcessorException extends Exception {

	private static final long serialVersionUID = -5764136487632028619L;

	public ProcessorException(String message) {
		super(message);
	}

	public ProcessorException(String message, Throwable cause) {
		super(message, cause);
	}

}
