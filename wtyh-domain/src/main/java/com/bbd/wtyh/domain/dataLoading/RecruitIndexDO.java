package com.bbd.wtyh.domain.dataLoading;


/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class RecruitIndexDO {

    private String company_name;
    private String recruit_industryratio;
    private String recruit_salaryratio;
    private String index;
    private String dt;
    private Integer task_id;

    public RecruitIndexDO() {
    }
    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getRecruit_industryratio() {
        return recruit_industryratio;
    }

    public void setRecruit_industryratio(String recruit_industryratio) {
        this.recruit_industryratio = recruit_industryratio;
    }

    public String getRecruit_salaryratio() {
        return recruit_salaryratio;
    }

    public void setRecruit_salaryratio(String recruit_salaryratio) {
        this.recruit_salaryratio = recruit_salaryratio;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }
}