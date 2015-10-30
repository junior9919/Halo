/**
 * 
 */
package com.user.wechat.mvc.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.wechat.db.daos.DeveloperInfoDao;
import com.user.wechat.db.daos.TempDeveloperInfoDao;
import com.user.wechat.db.daos.UnscribedUserInfoDao;
import com.user.wechat.db.daos.UserInfoDao;
import com.user.wechat.db.domains.DeveloperInfo;
import com.user.wechat.db.domains.TempDeveloperInfo;
import com.user.wechat.db.domains.UnscribedUserInfo;
import com.user.wechat.db.domains.UserInfo;
import com.user.wechat.mvc.services.DeveloperInfoService;

/**
 * @author Junior
 * @date 2015年9月19日 上午10:59:47
 * @version 1.0
 * @since
 * @see
 */
@Service("developerInfoService")
public class DeveloperInfoServiceImpl implements DeveloperInfoService {

	@Autowired
	private DeveloperInfoDao developerInfoDao;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private TempDeveloperInfoDao tempDeveloperInfoDao;

	@Autowired
	UnscribedUserInfoDao unscribedUserInfoDao;

	@Override
	public boolean isSubscriber(String developerId, String openId) {
		List<DeveloperInfo> developerInfos = developerInfoDao.findByDeveloperId(developerId);
		List<UserInfo> userInfos = userInfoDao.findByOpenId(openId);
		return !developerInfos.isEmpty() || !userInfos.isEmpty();
	}

	@Override
	public boolean isTemporaryDeveloperExist(String developerId, String openId) {
		return tempDeveloperInfoDao.isExist(developerId, openId);
	}

	@Override
	public int preRegistDeveloperInfo(String developerId, String openId) {
		TempDeveloperInfo tempDeveloperInfo = new TempDeveloperInfo(developerId, openId, new Date());
		return tempDeveloperInfoDao.save(tempDeveloperInfo);
	}

	@Override
	public void registUserAndDeveloper(String openId) {
		UserInfo userInfo = new UserInfo(openId, (byte) 0, new Date());
		int userInfoId = userInfoDao.save(userInfo);

		List<TempDeveloperInfo> tempDeveloperInfos = tempDeveloperInfoDao.findByOpenId(openId);
		for (TempDeveloperInfo tempDeveloperInfo : tempDeveloperInfos) {
			List<DeveloperInfo> developerInfos = developerInfoDao.findByDeveloperId(tempDeveloperInfo.getDeveloperId());
			if (developerInfos.isEmpty()) {
				DeveloperInfo developerInfo = new DeveloperInfo(userInfoId, tempDeveloperInfo.getDeveloperId(), new Date());
				developerInfoDao.save(developerInfo);
			}
		}
	}

	@Override
	public void withdrawUserInfo(String openId) {
		List<UserInfo> userInfos = userInfoDao.findByOpenId(openId);

		if (!userInfos.isEmpty()) {
			UserInfo userInfo = userInfos.get(0);
			userInfoDao.delete(userInfo);

			UnscribedUserInfo unscribedUserInfo = new UnscribedUserInfo(userInfo, new Date());
			unscribedUserInfoDao.save(unscribedUserInfo);

			List<DeveloperInfo> developerInfos = developerInfoDao.findByUserInfoId(userInfo.getId());
			for (DeveloperInfo developerInfo : developerInfos) {
				developerInfoDao.delete(developerInfo);
			}
		}
	}

}
