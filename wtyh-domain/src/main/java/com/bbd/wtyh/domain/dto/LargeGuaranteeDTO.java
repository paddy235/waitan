package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/8/9.
 */
public class LargeGuaranteeDTO {

    private Integer guaranteeId;
    private Integer guaranteedId;
    private String guaranteeName;
    private String guaranteedName;
    private String guaranteedBusinessType;
    private String guaranteedRegisteredCapital;

    public Integer getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Integer guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Integer getGuaranteedId() {
        return guaranteedId;
    }

    public void setGuaranteedId(Integer guaranteedId) {
        this.guaranteedId = guaranteedId;
    }

    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    public String getGuaranteedName() {
        return guaranteedName;
    }

    public void setGuaranteedName(String guaranteedName) {
        this.guaranteedName = guaranteedName;
    }

    public String getGuaranteedBusinessType() {
        return guaranteedBusinessType;
    }

    public void setGuaranteedBusinessType(String guaranteedBusinessType) {
        this.guaranteedBusinessType = guaranteedBusinessType;
    }

    public String getGuaranteedRegisteredCapital() {
        return guaranteedRegisteredCapital;
    }

    public void setGuaranteedRegisteredCapital(String guaranteedRegisteredCapital) {
        this.guaranteedRegisteredCapital = guaranteedRegisteredCapital;
    }
}
