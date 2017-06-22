package com.bbd.wtyh.domain.dto;

/**
 * Created by cgj on 2017/6/21.
 */
public class PlatCompanyDTO {

    /** 平台名称*/
    private String plat_name;

    /** 平台对应公司的名称*/
    private String company_name;

    /** 平台logo网站 */
    private String logo_url;

    public String getPlat_name() {
        return plat_name;
    }

    public void setPlat_name(String plat_name) {
        this.plat_name = plat_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }
}
