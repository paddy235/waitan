package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/8/8 0008.
 */
public class HotAreaDTO {

    private Integer areaId;
    private String areaName;

    /**
     * 企业总数
     */
    private Integer all;
    /**
     * 国企数量
     */
    private Integer stateOwned;
    /**
     * 民营企业数量
     */
    private Integer privateCompany;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getStateOwned() {
        return stateOwned;
    }

    public void setStateOwned(Integer stateOwned) {
        this.stateOwned = stateOwned;
    }

    public Integer getPrivateCompany() {
        return privateCompany;
    }

    public void setPrivateCompany(Integer privateCompany) {
        this.privateCompany = privateCompany;
    }
}
