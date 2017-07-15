package com.bbd.wtyh.domain;

/**
 * Created by lixudong on 2017/7/14.
 */
public class PlatformDO extends BaseDO{
    private String platName;
    private String companyName;
    private String logoUrl;
    private String areaId;

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "PlatformDO{" +
                "platName='" + platName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", areaId='" + areaId + '\'' +
                '}';
    }
}
