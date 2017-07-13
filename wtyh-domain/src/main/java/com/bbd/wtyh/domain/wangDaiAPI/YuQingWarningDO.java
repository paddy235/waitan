package com.bbd.wtyh.domain.wangDaiAPI;

import com.bbd.wtyh.domain.BaseDO;

/**
 * Created by lixudong on 2017/7/9.
 */
public class YuQingWarningDO  extends BaseDO {

    private String platName;
    private String title;
    private String content;
    private String source;
    private String date;

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "YuQingWarningDO{" +
                "platName='" + platName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
