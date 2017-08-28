package com.bbd.wtyh.domain.wangDaiAPI;

import com.bbd.wtyh.domain.BaseDO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Created by lixudong on 2017/7/9.
 */
@Table(name = "yuqing_warning")
public class YuQingWarningDO extends BaseDO {

    @Id
    private Integer id;

    @Column(name = "plat_name")
    private String platName;

    @Column
    private String score;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String source;

    @Column
    private String date;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

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
        return "YuQingWarningDO{" + "platName='" + platName + '\'' + ", score='" + score + '\'' + ", title='" + title + '\'' + ", content='"
                + content + '\'' + ", source='" + source + '\'' + ", date='" + date + '\'' + '}';
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
