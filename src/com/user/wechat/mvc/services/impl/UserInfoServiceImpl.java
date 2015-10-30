package com.user.wechat.mvc.services.impl;

import java.util.List;

import com.user.wechat.db.daos.UserInfoDao;
import com.user.wechat.db.domains.UserInfo;
import com.user.wechat.mvc.services.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Junior
 * @date 2015年9月15日 下午10:12:28
 * @version 1.0
 * @since
 * @see
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public boolean isSubscriber(String openId) {
		List<UserInfo> userInfos = userInfoDao.findByOpenId(openId);
		return !userInfos.isEmpty();
	}

}
