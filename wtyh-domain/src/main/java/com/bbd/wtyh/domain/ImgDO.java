package com.bbd.wtyh.domain;

/**
 * Created by Barney on 2017/7/6.
 */
public class ImgDO extends BaseDO {

    private String picName;
    private String picUrl;
    private byte[] pic;
    private int picType; // 1：园区；2：楼宇
    private int picParkId;
    private int picBuildingId;
    private int status;
    private int lastStatus;
    private String ip;
    private String user;//作为creat_by或update_by字段使用

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(int lastStatus) {
        this.lastStatus = lastStatus;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public int getPicType() {
        return picType;
    }

    public void setPicType(int picType) {
        this.picType = picType;
    }

    public int getPicParkId() {
        return picParkId;
    }

    public void setPicParkId(int picParkId) {
        this.picParkId = picParkId;
    }

    public int getPicBuildingId() {
        return picBuildingId;
    }

    public void setPicBuildingId(int picBuildingId) {
        this.picBuildingId = picBuildingId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
