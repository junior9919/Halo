/**
 * 
 */
package com.user.wechat.mvc.services;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Junior
 * @date 2015年10月24日 下午8:08:34
 * @version 1.0
 * @since
 * @see
 */
public interface UserTraceService {

	public int recordUserTrace(String openId, BigDecimal latitude, BigDecimal longitude, BigDecimal prcsn, Integer scale, String label, Date recordTime);
	
}
