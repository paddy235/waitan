package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lixudong on 2017/7/14.
 */
@Table(name = "plat_list")
public class PlatformDO extends BaseDO{
    //@Id
    @Column(name = "plat_name")
    private String platName;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "logo_url")
    private String logoUrl;
    @Column(name = "area_id")
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
