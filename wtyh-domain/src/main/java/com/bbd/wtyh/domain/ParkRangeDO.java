package com.bbd.wtyh.domain;

/**
 * Created by Barney on 2017/8/29.
 */
public class ParkRangeDO extends BaseDO {

    private Integer userId;
    private Integer parkId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

}
