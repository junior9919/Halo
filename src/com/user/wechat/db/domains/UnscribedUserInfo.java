package com.user.wechat.db.domains;

// Generated 2015-9-26 21:34:15 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * UnscribedUserInfo generated by hbm2java
 */
public class UnscribedUserInfo implements java.io.Serializable {

	private static final long serialVersionUID = -5184853296326557232L;

	private Integer id;

	private String openId;

	private String nickname;

	private byte sex;

	private String city;

	private String country;

	private String province;

	private String language;

	private String headImgUrl;

	private Date subscribeTime;

	private String unionId;

	private String remark;

	private Byte groupid;

	private Date unsubscribeTime;

	public UnscribedUserInfo() {
	}

	public UnscribedUserInfo(String openId, byte sex, Date subscribeTime, Date unsubscribeTime) {
		this.openId = openId;
		this.sex = sex;
		this.subscribeTime = subscribeTime;
		this.unsubscribeTime = unsubscribeTime;
	}

	public UnscribedUserInfo(String openId, String nickname, byte sex, String city, String country, String province, String language, String headImgUrl,
			Date subscribeTime, String unionId, String remark, Byte groupid, Date unsubscribeTime) {
		this.openId = openId;
		this.nickname = nickname;
		this.sex = sex;
		this.city = city;
		this.country = country;
		this.province = province;
		this.language = language;
		this.headImgUrl = headImgUrl;
		this.subscribeTime = subscribeTime;
		this.unionId = unionId;
		this.remark = remark;
		this.groupid = groupid;
		this.unsubscribeTime = unsubscribeTime;
	}

	public UnscribedUserInfo(UserInfo userInfo, Date unsubscribeTime) {
		this.openId = userInfo.getOpenId();
		this.nickname = userInfo.getNickname();
		this.sex = userInfo.getSex();
		this.city = userInfo.getCity();
		this.country = userInfo.getCountry();
		this.province = userInfo.getProvince();
		this.language = userInfo.getLanguage();
		this.headImgUrl = userInfo.getHeadImgUrl();
		this.subscribeTime = userInfo.getSubscribeTime();
		this.unionId = userInfo.getUnionId();
		this.remark = userInfo.getRemark();
		this.groupid = userInfo.getGroupid();
		this.unsubscribeTime = unsubscribeTime;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public byte getSex() {
		return this.sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadImgUrl() {
		return this.headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public Date getSubscribeTime() {
		return this.subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getUnionId() {
		return this.unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Byte getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Byte groupid) {
		this.groupid = groupid;
	}

	public Date getUnsubscribeTime() {
		return this.unsubscribeTime;
	}

	public void setUnsubscribeTime(Date unsubscribeTime) {
		this.unsubscribeTime = unsubscribeTime;
	}

}
