package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//@Table(name = "finance_lease_risk")
public class DistrictCodeDO  implements Serializable {
    //@Id
    //@Column(name = "id")
    //区县代码
    private Integer code;
    //区县名称
    private String name;
    //省代码
    private Integer pCode;
    //市代码
    private Integer cCode;
    //县代码
    private Integer tCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getpCode() {
        return pCode;
    }

    public void setpCode(Integer pCode) {
        this.pCode = pCode;
    }

    public Integer getcCode() {
        return cCode;
    }

    public void setcCode(Integer cCode) {
        this.cCode = cCode;
    }

    public Integer gettCode() {
        return tCode;
    }

    public void settCode(Integer tCode) {
        this.tCode = tCode;
    }
}