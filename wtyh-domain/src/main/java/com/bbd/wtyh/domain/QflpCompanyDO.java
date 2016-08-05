package com.bbd.wtyh.domain;

public class QflpCompanyDO extends BaseDO {
    private Integer companyId;

    private Float scale;

    private Float dollorPart;

    private Float rmbPart;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Float getScale() {
        return scale;
    }

    public void setScale(Float scale) {
        this.scale = scale;
    }

    public Float getDollorPart() {
        return dollorPart;
    }

    public void setDollorPart(Float dollorPart) {
        this.dollorPart = dollorPart;
    }

    public Float getRmbPart() {
        return rmbPart;
    }

    public void setRmbPart(Float rmbPart) {
        this.rmbPart = rmbPart;
    }
}