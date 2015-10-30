/**
 * 
 */
package com.user.wechat.responsers;

/**
 * @author Junior
 * @date 2015年10月10日 下午10:51:36
 * @version 1.0
 * @since
 * @see
 */
public class ResponserException extends Exception {

	private static final long serialVersionUID = 3230036572573466546L;

	public ResponserException(String message) {
		super(message);
	}

	public ResponserException(String message, Throwable cause) {
		super(message, cause);
	}

}
