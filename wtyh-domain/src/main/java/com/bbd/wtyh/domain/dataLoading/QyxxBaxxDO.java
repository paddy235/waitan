package com.bbd.wtyh.domain.dataLoading;

import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class QyxxBaxxDO {
    private Integer id;
    private Date bbd_dotime;//抓取时间
    private String bbd_qyxx_id;//企业唯一ID
    private Integer bbd_uptime;//时间戳
    private String company_name;//名称
    private String no;//序号
    private String position;//职务
    private String sex;//性别
    private String type;//职务类型
    private String idno;//证照号码
    private String idtype;//证照类型
    private String name;//姓名
    private String name_id;//自然人唯一ID
    private String resume;//简历（上市公司）
    private String salary;//薪酬（上市公司）
    private String salasstartingary;//任职起始（上市公司）
    private Integer task_id;

    public QyxxBaxxDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBbd_dotime() {
        return bbd_dotime;
    }

    public void setBbd_dotime(Date bbd_dotime) {
        this.bbd_dotime = bbd_dotime;
    }

    public String getBbd_qyxx_id() {
        return bbd_qyxx_id;
    }

    public void setBbd_qyxx_id(String bbd_qyxx_id) {
        this.bbd_qyxx_id = bbd_qyxx_id;
    }

    public Integer getBbd_uptime() {
        return bbd_uptime;
    }

    public void setBbd_uptime(Integer bbd_uptime) {
        this.bbd_uptime = bbd_uptime;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_id() {
        return name_id;
    }

    public void setName_id(String name_id) {
        this.name_id = name_id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSalasstartingary() {
        return salasstartingary;
    }

    public void setSalasstartingary(String salasstartingary) {
        this.salasstartingary = salasstartingary;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }
}