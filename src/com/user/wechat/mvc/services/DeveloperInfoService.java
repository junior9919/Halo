package com.user.wechat.mvc.services;

public interface DeveloperInfoService {

	public boolean isSubscriber(String developerId, String openId);

	public boolean isTemporaryDeveloperExist(String developerId, String openId);

	public int preRegistDeveloperInfo(String developerId, String openId);

	public void registUserAndDeveloper(String openId);

	public void withdrawUserInfo(String openId);

}
