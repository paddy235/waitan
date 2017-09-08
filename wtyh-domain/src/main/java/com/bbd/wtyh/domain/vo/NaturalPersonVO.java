package com.bbd.wtyh.domain.vo;

import com.bbd.wtyh.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by cgj on 2017/7/14
 */
public class NaturalPersonVO implements Serializable {
    @Excel(exportName ="序号")
    private int idx;
    //自然人姓名
    @Excel(exportName ="自然人姓名")
    private String nalName;
    //关联企业名称
    @Excel(exportName ="关联公司")
    private String relatedCompany;
    @Excel(exportName ="职务")
    private String position;
    //成立时间
    @Excel(exportName ="成立时间")
    private String esDate;
    //法人代表
    @Excel(exportName ="法定代表人")
    private String frName;
    //注册资本
    @Excel(exportName ="注册资本")
    private String regCapital;
    //注册地址
    @Excel(exportName ="注册地址")
    private String regAddress;
    //范围
    @Excel(exportName ="所属范围")
    private String range;

    //BBD企业信息ID
    private String bbdQyxxId;

    //是否是董监高
    boolean Djg;

    //是否是法人股东
    boolean FrGud;

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getNalName() {
        return nalName;
    }

    public void setNalName(String nalName) {
        this.nalName = nalName;
    }

    public String getRelatedCompany() {
        return relatedCompany;
    }

    public void setRelatedCompany(String relatedCompany) {
        this.relatedCompany = relatedCompany;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEsDate() {
        return esDate;
    }

    public void setEsDate(String esDate) {
        this.esDate = esDate;
    }

    public String getFrName() {
        return frName;
    }

    public void setFrName(String frName) {
        this.frName = frName;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getBbdQyxxId() {
        return bbdQyxxId;
    }

    public void setBbdQyxxId(String bbdQyxxId) {
        this.bbdQyxxId = bbdQyxxId;
    }

    public boolean isDjg() {
        return Djg;
    }

    public void setDjg(boolean djg) {
        Djg = djg;
    }

    public boolean isFrGud() {
        return FrGud;
    }

    public void setFrGud(boolean frGud) {
        FrGud = frGud;
    }
}
