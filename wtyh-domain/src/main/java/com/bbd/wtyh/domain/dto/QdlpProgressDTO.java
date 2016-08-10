package com.bbd.wtyh.domain.dto;

import java.util.List;

/**
 * Created by Marco on 2016/8/10.
 */
public class QdlpProgressDTO {

    private String companyName;
    private List<String> shareholders;
    private Float quatas;
    private String progress;
    private String architecture;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<String> getShareholders() {
        return shareholders;
    }

    public void setShareholders(List<String> shareholders) {
        this.shareholders = shareholders;
    }

    public Float getQuatas() {
        return quatas;
    }

    public void setQuatas(Float quatas) {
        this.quatas = quatas;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }
}
