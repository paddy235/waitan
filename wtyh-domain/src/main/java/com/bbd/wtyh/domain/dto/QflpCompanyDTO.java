package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/8/10.
 */
public class QflpCompanyDTO {

    private String companyName;

    private Float total;

    private Float dollarPart;

    private Float rmbTotal;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getDollarPart() {
        return dollarPart;
    }

    public void setDollarPart(Float dollarPart) {
        this.dollarPart = dollarPart;
    }

    public Float getRmbTotal() {
        return rmbTotal;
    }

    public void setRmbTotal(Float rmbTotal) {
        this.rmbTotal = rmbTotal;
    }
}
