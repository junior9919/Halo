/**
 * 
 */
package com.user.wechat.db.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.wechat.db.daos.DeveloperInfoDao;
import com.user.wechat.db.domains.DeveloperInfo;

/**
 * @author Junior
 * @date 2015年9月19日 上午10:52:06
 * @version 1.0
 * @since
 * @see
 */
@Repository("developerInfoDao")
public class DeveloperInfoDaoImpl extends AbstractDaoImpl<DeveloperInfo> implements DeveloperInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DeveloperInfo> findByDeveloperId(String developerId) {
		return (List<DeveloperInfo>) getHibernateTemplate().find("from DeveloperInfo d where d.developerId = ?", developerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DeveloperInfo> findByUserInfoId(int userInfoId) {
		return (List<DeveloperInfo>) getHibernateTemplate().find("from DeveloperInfo d where d.userInfoId = ?", userInfoId);
	}

}
