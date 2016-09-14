package com.bbd.wtyh.domain;

import java.io.Serializable;

/**
 * Created by win7 on 2016/9/7.
 */
public class IndexDataPK implements Serializable {
    private String companyName;
    private String area;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
