package com.user.wechat.db.daos;

import java.util.List;

import com.user.wechat.db.domains.DeveloperInfo;

public interface DeveloperInfoDao extends AbstractDao<DeveloperInfo> {

	public List<DeveloperInfo> findByDeveloperId(String developerId);
	
	public List<DeveloperInfo> findByUserInfoId(int userInfoId);

}
