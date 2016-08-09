package com.bbd.wtyh.domain.query;

import java.io.Serializable;

/**
 * Created by Marco on 2016/8/8 .
 */
public class CompanyQuery implements Serializable {


    private Integer companyType;
    private Integer areaId;
    private Integer background;

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getBackground() {
        return background;
    }

    public void setBackground(Integer background) {
        this.background = background;
    }
}
