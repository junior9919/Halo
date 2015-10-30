/**
 * 
 */
package com.user.wechat.db.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.wechat.db.domains.TempDeveloperInfo;

/**
 * @author Junior
 * @date 2015年9月21日 下午10:00:20
 * @version 1.0
 * @since
 * @see
 */
@Repository
public interface TempDeveloperInfoDao extends AbstractDao<TempDeveloperInfo> {

	public List<TempDeveloperInfo> findByOpenId(String openId);

	public boolean isExist(String developerId, String openId);

}
