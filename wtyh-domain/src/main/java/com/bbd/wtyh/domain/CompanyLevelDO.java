package com.bbd.wtyh.domain;

public class CompanyLevelDO extends BaseDO {
    private Integer companyId;

    private Integer outLevel;

    private Integer innerLevel;

    private Integer liveLevel;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getOutLevel() {
        return outLevel;
    }

    public void setOutLevel(Integer outLevel) {
        this.outLevel = outLevel;
    }

    public Integer getInnerLevel() {
        return innerLevel;
    }

    public void setInnerLevel(Integer innerLevel) {
        this.innerLevel = innerLevel;
    }

    public Integer getLiveLevel() {
        return liveLevel;
    }

    public void setLiveLevel(Integer liveLevel) {
        this.liveLevel = liveLevel;
    }
}