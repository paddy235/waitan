package com.bbd.wtyh.domain;

public class RecruitData extends RecruitDataKey {
    private String recruitDetail;

    public String getRecruitDetail() {
        return recruitDetail;
    }

    public void setRecruitDetail(String recruitDetail) {
        this.recruitDetail = recruitDetail == null ? null : recruitDetail.trim();
    }
}