package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "qflp_company")
public class QflpCompanyDO extends BaseDO {
    @Id
    @Column(name = "company_id")
    private Integer companyId;

    private Float scale;

    private Float dollorPart;

    private Float rmbPart;

    private Integer indexNum;

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

    public Integer getIndexNum() {
        return indexNum;
    }

    public void setIndexNum(Integer indexNum) {
        this.indexNum = indexNum;
    }
}