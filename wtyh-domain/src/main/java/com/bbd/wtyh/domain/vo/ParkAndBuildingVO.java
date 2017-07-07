package com.bbd.wtyh.domain.vo;

/**
 * Created by Barney on 2017/7/5.
 */
public class ParkAndBuildingVO {

    private String parkName;
    private String buildingName;
    private String createDate;
    private int companyCount;
    private int finCompanyCount;

    public int getCompanyCount() {
        return companyCount;
    }

    public void setCompanyCount(int companyCount) {
        this.companyCount = companyCount;
    }

    public int getFinCompanyCount() {
        return finCompanyCount;
    }

    public void setFinCompanyCount(int finCompanyCount) {
        this.finCompanyCount = finCompanyCount;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
