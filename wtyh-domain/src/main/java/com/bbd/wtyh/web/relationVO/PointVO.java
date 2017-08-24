package com.bbd.wtyh.web.relationVO;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class PointVO {

    /** 落地数据使用字段 */
    private String queriedCompany;
    /** 关联方ID */
    private String name;
    /** 关联方名称 */
    private String cname;
    /** 所处关联度数 */
    private String level;
    /** 是否是个人（0：公司；1：个人） */
    private String isPerson;
    /** 是否为子公司（0：否；1：是） */
    private String isSonCom;

    public String getQueriedCompany() {
        return queriedCompany;
    }

    public void setQueriedCompany(String queriedCompany) {
        this.queriedCompany = queriedCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(String isPerson) {
        this.isPerson = isPerson;
    }

    public String getIsSonCom() {
        return isSonCom;
    }

    public void setIsSonCom(String isSonCom) {
        this.isSonCom = isSonCom;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
