package com.bbd.wtyh.domain.vo;

/**
 * @Author:WLL
 * @Date:Create on 15:082017/12/12
 */
public class UseHotPage {
    private String  name;

    private String  request_desc;

    private Integer countCode;

    private Integer sumCode;

    public Integer getSumCode() {
        return sumCode;
    }

    public void setSumCode(Integer sumCode) {
        this.sumCode = sumCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequest_desc() {
        return request_desc;
    }

    public void setRequest_desc(String request_desc) {
        this.request_desc = request_desc;
    }

    public Integer getCountCode() {
        return countCode;
    }

    public void setCountCode(Integer countCode) {
        this.countCode = countCode;
    }
}
