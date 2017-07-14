package com.bbd.wtyh.domain.wangDaiAPI;

import com.bbd.wtyh.domain.BaseDO;

/**
 * Created by YanWenyuan on 2016/8/13.
 */
public class YuQingDO extends BaseDO{
    private String platName;
    private String score;
    private String warning;


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    @Override
    public String toString() {
        return "YuQingDO{" +
                "platName='" + platName + '\'' +
                ", score='" + score + '\'' +
                ", warning='" + warning + '\'' +
                '}';
    }
}
