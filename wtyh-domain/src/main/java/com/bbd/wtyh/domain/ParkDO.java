package com.bbd.wtyh.domain;

import org.springframework.beans.factory.annotation.Value;

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
    private String user ;//作为creat_by或update_by字段使用

    public static final String DEFAULT_PARK_IMG = "data/img/park/park_default.png";
    private String isSelected;

    public String getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

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
