package com.bbd.wtyh.domain.vo;

import java.io.Serializable;

/**
 * Created by lixudong on 2017/7/27.
 */
public class PriFundProductTypeVO  implements Serializable {
    private static final long serialVersionUID = -616782924305426256L;
    private Integer adviserManage;//顾问管理
    private Integer entrustedManage;//受托管理
    private Integer selfManage;//自我管理

    public Integer getAdviserManage() {
        return adviserManage;
    }

    public void setAdviserManage(Integer adviserManage) {
        this.adviserManage = adviserManage;
    }

    public Integer getEntrustedManage() {
        return entrustedManage;
    }

    public void setEntrustedManage(Integer entrustedManage) {
        this.entrustedManage = entrustedManage;
    }

    public Integer getSelfManage() {
        return selfManage;
    }

    public void setSelfManage(Integer selfManage) {
        this.selfManage = selfManage;
    }

    @Override
    public String toString() {
        return "PriFundProductTypeVO{" +
                "adviserManage=" + adviserManage +
                ", entrustedManage=" + entrustedManage +
                ", selfManage=" + selfManage +
                '}';
    }
}
