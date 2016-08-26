package com.bbd.wtyh.domain;

/**
 * Created by YanWenyuan on 2016/8/19.
 */
public class BuildingNumberInAreaDO {
    private String name;
    private String count;
    private int areaId;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
