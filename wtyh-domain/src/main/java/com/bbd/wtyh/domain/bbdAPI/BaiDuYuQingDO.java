package com.bbd.wtyh.domain.bbdAPI;

/**
 * Created by YanWenyuan on 2016/8/13.
 */
public class BaiDuYuQingDO {
    private String news_title;
    private String news_site;
    private String pubdate;
    private String content; // TODO 新闻内容

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_site() {
        return news_site;
    }

    public void setNews_site(String news_site) {
        this.news_site = news_site;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
