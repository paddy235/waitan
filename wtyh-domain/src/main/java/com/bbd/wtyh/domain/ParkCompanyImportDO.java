package com.bbd.wtyh.domain;

/**
 * Created by Barney on 2017/7/7.
 */
public class ParkCompanyImportDO extends BaseDO {

    private String importNo;
    private String companyName;
    private String buildingName;
    private int companyId;
    private int buildingId;
    private String errorCompany;
    private String errorBuilding;

    public String getImportNo() {
        return importNo;
    }

    public void setImportNo(String importNo) {
        this.importNo = importNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getErrorCompany() {
        return errorCompany;
    }

    public void setErrorCompany(String errorCompany) {
        this.errorCompany = errorCompany;
    }

    public String getErrorBuilding() {
        return errorBuilding;
    }

    public void setErrorBuilding(String errorBuilding) {
        this.errorBuilding = errorBuilding;
    }
}
