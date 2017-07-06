package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Barney on 2017/7/5.
 */
public class ParkDO extends BaseDO {

    @Id
    @Column(name = "park_id")
    private int parkId;
    @Column(name = "name")
    private String name;
    @Column(name = "area_id")
    private int areaId;
    @Column(name = "img_url")
    private String imgUrl;

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
