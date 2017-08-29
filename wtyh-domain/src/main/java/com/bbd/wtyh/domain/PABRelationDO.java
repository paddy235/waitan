package com.bbd.wtyh.domain;

/**
 * Created by Barney on 2017/8/29.
 */
public class PABRelationDO extends BaseDO {

    private Integer parkId;
    private Integer buildingId;

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

}
