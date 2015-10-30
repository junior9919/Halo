/**
 * 
 */
package com.user.wechat.mvc.services.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.wechat.db.daos.UserTraceDao;
import com.user.wechat.db.domains.UserTrace;
import com.user.wechat.mvc.services.UserTraceService;

/**
 * @author Junior
 * @date 2015年10月24日 下午8:16:32
 * @version 1.0
 * @since
 * @see
 */
@Service("userTraceService")
public class UserTraceServiceImpl implements UserTraceService {

	@Autowired
	UserTraceDao userTraceDao;

	@Override
	public int recordUserTrace(String openId, BigDecimal latitude, BigDecimal longitude, BigDecimal prcsn, Integer scale, String label, Date recordTime) {
		UserTrace userTrace = new UserTrace(openId, latitude, longitude, recordTime);
		if (null != prcsn) {
			userTrace.setPrcsn(prcsn);
		}
		if (null != scale) {
			userTrace.setScale(scale);
		}
		if (null != label && !label.isEmpty()) {
			userTrace.setLabel(label);
		}

		return userTraceDao.save(userTrace);
	}

}
