package com.user.wechat.db.daos;

import java.util.List;

import com.user.wechat.db.domains.UserInfo;

public interface UserInfoDao extends AbstractDao<UserInfo> {

	public List<UserInfo> findByOpenId(String openId);

}
