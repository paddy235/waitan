package com.bbd.wtyh.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CompanyNewsVO implements Serializable {
	@JSONField(name="bbd_xgxx_id")
	private String bbdXgxxId;
	@JSONField(name="news_site")
	private String newsSite;
	@JSONField(name="bbd_source")
	private String bbdSource;
	@JSONField(name="bbd_uptime")
	private String bbdUptime;
	@JSONField(name="bbd_url")
	private String bbdUrl;
	@JSONField(name="pubdate")
	private String pubDate;
	@JSONField(name="search_key")
	private String searchKey;
	@JSONField(name="news_title")
	private String newsTitle;
	@JSONField(name="bbd_dotime")
	private String bbdDotime;
	@JSONField(name="bbd_type")
	private String bbdType;

	public String getBbdType() {
		return bbdType;
	}

	public void setBbdType(String bbdType) {
		this.bbdType = bbdType;
	}

	public String getBbdXgxxId() {
		return bbdXgxxId;
	}

	public void setBbdXgxxId(String bbdXgxxId) {
		this.bbdXgxxId = bbdXgxxId;
	}

	public String getNewsSite() {
		return newsSite;
	}

	public void setNewsSite(String newsSite) {
		this.newsSite = newsSite;
	}

	public String getBbdSource() {
		return bbdSource;
	}

	public void setBbdSource(String bbdSource) {
		this.bbdSource = bbdSource;
	}

	public String getBbdUptime() {
		return bbdUptime;
	}

	public void setBbdUptime(String bbdUptime) {
		this.bbdUptime = bbdUptime;
	}

	public String getBbdUrl() {
		return bbdUrl;
	}

	public void setBbdUrl(String bbdUrl) {
		this.bbdUrl = bbdUrl;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getBbdDotime() {
		return bbdDotime;
	}

	public void setBbdDotime(String bbdDotime) {
		this.bbdDotime = bbdDotime;
	}

}
