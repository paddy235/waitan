package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by cgj on 2017-09-06.
 */
@Table(name = "qyxx_tag")
public class QyxxTagDO {
    @Id
    @Column(name = "kid")
    private Integer kid;

    @Column(name = "bbd_qyxx_id")
    private String bbdQyxxId;

    @Column(name = "tag")
    private String tag;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "uptime")
    private Date uptime;

    @Column(name = "dt")
    private Integer dt;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getBbdQyxxId() {
        return bbdQyxxId;
    }

    public void setBbdQyxxId(String bbdQyxxId) {
        this.bbdQyxxId = bbdQyxxId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getDt() {
        return dt;
    }
}
