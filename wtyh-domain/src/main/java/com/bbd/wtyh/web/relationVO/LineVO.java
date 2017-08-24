package com.bbd.wtyh.web.relationVO;

import com.bbd.wtyh.excel.annotation.Excel;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class LineVO {

    @Excel(exportName = "序号")
    private int num;

    /** 落地数据使用字段 */
    private String queriedCompany;

    /** 源 */
    private String orig;

    /** 源 */
    @Excel(exportName = "投资方")
    private String origName;

    /** 目标 */
    private String target;

    /** 目标 */
    @Excel(exportName = "被投资方")
    private String targetName;

    /** 是否为实线（0：否；1：是） */
    private String isFullLine;

    /** 关联方类型 */
    @Excel(exportName = "关联关系")
    private String type;

    /** 关联方关系（0：公司与公司；1：人与公司） */
    private String relationship;

    /** 源维度 */
    @Excel(exportName = "投资方关联维度")
    private String origLevel;

    /** 目标维度 */
    @Excel(exportName = "被投资方关联维度")
    private String tarLevel;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getQueriedCompany() {
        return queriedCompany;
    }

    public void setQueriedCompany(String queriedCompany) {
        this.queriedCompany = queriedCompany;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIsFullLine() {
        return isFullLine;
    }

    public void setIsFullLine(String isFullLine) {
        this.isFullLine = isFullLine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getOrigLevel() {
        return origLevel;
    }

    public void setOrigLevel(String origLevel) {
        this.origLevel = origLevel;
    }

    public String getTarLevel() {
        return tarLevel;
    }

    public void setTarLevel(String tarLevel) {
        this.tarLevel = tarLevel;
    }

    public String getOrigName() {
        return origName;
    }

    public void setOrigName(String origName) {
        this.origName = origName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}
