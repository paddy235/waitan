package com.bbd.wtyh.domain;

import java.util.Date;

public class CompanyNewsDO extends BaseDO {
    private Integer newsId;

    private Integer companyId;

    private String title;

    private String content;

    private String fromSite;

    private Date date;

    private String url;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFromSite() {
        return fromSite;
    }

    public void setFromSite(String fromSite) {
        this.fromSite = fromSite == null ? null : fromSite.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}