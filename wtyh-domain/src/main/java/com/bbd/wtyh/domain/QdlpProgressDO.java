package com.bbd.wtyh.domain;

public class QdlpProgressDO {
    private Integer companyId;

    private String foreignShareholder;

    private String chinaShareholder;

    private Float quatas;

    private Byte progress;

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
}