/**
 * 
 */
package com.user.wechat.mvc.services;

import com.halo.wechat.mvc.services.ServiceException;

/**
 * @author Junior
 * @date 2015年10月18日 上午9:47:02
 * @version 1.0
 * @since
 * @see
 */
public interface MaterialService {

	public String saveNewsToLocal(short materialCount) throws ServiceException;
	
}
