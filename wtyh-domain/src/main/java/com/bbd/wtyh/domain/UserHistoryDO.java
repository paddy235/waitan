package com.bbd.wtyh.domain;

import java.util.Date;

/**
* 用户行为轨迹
* @author Ian.Su
* @since 2016年8月12日 下午7:10:34
*/
public class UserHistoryDO extends BaseDO{

	private Integer userId;
	private String url;
	private String keyword;
	private Date operateDate;
	private String ip;
	private String oriUrl;
	private String userAgent;
	private int isLogin;

	
	public Integer getUserId() {
		return userId;
	}
	
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getUrl() {
		return url;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getKeyword() {
		return keyword;
	}
	
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	public Date getOperateDate() {
		return operateDate;
	}
	

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
	
	public String getIp() {
		return ip;
	}
	

	public void setIp(String ip) {
		this.ip = ip;
	}

	
	public String getOriUrl() {
		return oriUrl;
	}
	
	
	public void setOriUrl(String oriUrl) {
		this.oriUrl = oriUrl;
	}
	
	
	public String getUserAgent() {
		return userAgent;
	}
	

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	
	public int getIsLogin() {
		return isLogin;
	}
	

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}
	
	
}
