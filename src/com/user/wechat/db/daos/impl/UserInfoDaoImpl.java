package com.user.wechat.db.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.wechat.db.daos.UserInfoDao;
import com.user.wechat.db.domains.UserInfo;

/**
 * @author Junior
 * @date 2015年9月15日 下午9:52:35
 * @version 1.0
 * @since
 * @see
 */
@Repository("userInfoDao")
public class UserInfoDaoImpl extends AbstractDaoImpl<UserInfo> implements UserInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findByOpenId(String openId) {
		return (List<UserInfo>) getHibernateTemplate().find("from UserInfo u where u.openId = ?", openId);
	}

}
