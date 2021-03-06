package com.user.wechat.db.domains;

// Generated 2015-10-8 21:55:38 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TempDeveloperInfo generated by hbm2java
 */
public class TempDeveloperInfo implements java.io.Serializable {

	private static final long serialVersionUID = 8030476123119121547L;
	
	private Integer id;
	
	private String developerId;
	
	private String openId;
	
	private Date preRegistTime;

	public TempDeveloperInfo() {
	}

	public TempDeveloperInfo(String developerId, String openId, Date preRegistTime) {
		this.developerId = developerId;
		this.openId = openId;
		this.preRegistTime = preRegistTime;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeveloperId() {
		return this.developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getPreRegistTime() {
		return this.preRegistTime;
	}

	public void setPreRegistTime(Date preRegistTime) {
		this.preRegistTime = preRegistTime;
	}

}
