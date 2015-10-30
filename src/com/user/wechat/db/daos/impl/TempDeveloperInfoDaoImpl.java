/**
 * 
 */
package com.user.wechat.db.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.wechat.db.daos.TempDeveloperInfoDao;
import com.user.wechat.db.domains.TempDeveloperInfo;

/**
 * @author Junior
 * @date 2015年9月21日 下午10:01:51
 * @version 1.0
 * @since
 * @see
 */
@Repository("tempDeveloperInfoDao")
public class TempDeveloperInfoDaoImpl extends AbstractDaoImpl<TempDeveloperInfo> implements TempDeveloperInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TempDeveloperInfo> findByOpenId(String openId) {
		return (List<TempDeveloperInfo>) getHibernateTemplate().find("from TempDeveloperInfo td where td.openId = ? order by td.preRegistTime DESC limit 1",
				openId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExist(String developerId, String openId) {
		List<TempDeveloperInfo> tempDeveloperInfos = (List<TempDeveloperInfo>) getHibernateTemplate().find(
				"from TempDeveloperInfo td where td.developerId = ? and td.openId = ?", developerId, openId);
		return !tempDeveloperInfos.isEmpty();
	}

}
