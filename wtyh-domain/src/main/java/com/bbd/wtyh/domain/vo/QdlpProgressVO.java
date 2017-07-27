package com.bbd.wtyh.domain.vo;

/**
 * Created by lixudong on 2017/7/26.
 */
public class QdlpProgressVO {

    private String companyName;

    private String foreignShareholder;

    private String chinaShareholder;

    private Float quatas;

    private String progress;

    private String architecture;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getForeignShareholder() {
        return foreignShareholder;
    }

    public void setForeignShareholder(String foreignShareholder) {
        this.foreignShareholder = foreignShareholder;
    }

    public String getChinaShareholder() {
        return chinaShareholder;
    }

    public void setChinaShareholder(String chinaShareholder) {
        this.chinaShareholder = chinaShareholder;
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

    @Override
    public String toString() {
        return "QdlpProgressVO{" +
                "companyName='" + companyName + '\'' +
                ", foreignShareholder='" + foreignShareholder + '\'' +
                ", chinaShareholder='" + chinaShareholder + '\'' +
                ", quatas=" + quatas +
                ", progress=" + progress +
                ", architecture='" + architecture + '\'' +
                '}';
    }
}
