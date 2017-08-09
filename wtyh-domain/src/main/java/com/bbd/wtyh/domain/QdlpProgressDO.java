package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "qdlp_progress")
public class QdlpProgressDO extends BaseDO {
    @Id
    @Column(name = "company_id")
    private Integer companyId;

    private String foreignShareholder;

    private String chinaShareholder;

    private Float quatas;

    private Byte progress;

    private String architecture;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getForeignShareholder() {
        return foreignShareholder;
    }

    public void setForeignShareholder(String foreignShareholder) {
        this.foreignShareholder = foreignShareholder == null ? null : foreignShareholder.trim();
    }

    public String getChinaShareholder() {
        return chinaShareholder;
    }

    public void setChinaShareholder(String chinaShareholder) {
        this.chinaShareholder = chinaShareholder == null ? null : chinaShareholder.trim();
    }

    public Float getQuatas() {
        return quatas;
    }

    public void setQuatas(Float quatas) {
        this.quatas = quatas;
    }

    public Byte getProgress() {
        return progress;
    }

    public void setProgress(Byte progress) {
        this.progress = progress;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }
}