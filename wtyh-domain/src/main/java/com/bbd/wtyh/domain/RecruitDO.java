package com.bbd.wtyh.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
/**
 * Created by cgj on 2017/6/28.
 */
public class RecruitDO implements Serializable {
    private String msg;
    private String err_code;
    private Integer rsize;
    private String total;
    private List<Recruit> results;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public Integer getRsize() {
        return rsize;
    }

    public void setRsize(Integer rsize) {
        this.rsize = rsize;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Recruit> getResults() {
        return results;
    }

    public void setResults(List<Recruit> results) {
        this.results = results;
    }

    /**
     * Created by wish on 2017/4/20.
     */
//@ApiModel(value = "招聘数据信息")
    public static class Recruit implements Serializable {
        //@ApiModelProperty(value = "公司名称")
        @SerializedName("company_name")
        private String company_name;
        //@ApiModelProperty(value = "job_title")
        @SerializedName("job_title")
        private String job_title;
        //@ApiModelProperty(value = "工作地点")
        @SerializedName("location")
        private String location;
        //@ApiModelProperty(value = "招聘人数")
        @SerializedName("recruit_numbers")
        private String recruit_numbers;
        //@ApiModelProperty(value = "发布时间")
        @SerializedName("pubdate")
        private String pubdate;
        //@ApiModelProperty(value = "数据表")
        @SerializedName("bbd_type")
        private String bbd_type;
        //@ApiModelProperty(value = "职位描述")
        @SerializedName("job_descriptions")
        private String job_descriptions;
        //@ApiModelProperty(value = "福利待遇")
        @SerializedName("benefits")
        private String benefits;
        //@ApiModelProperty(value = "职位薪资")
        @SerializedName("salary")
        private String salary;
        //@ApiModelProperty(value = "工作年限")
        @SerializedName("service_year")
        private String service_year;
        //@ApiModelProperty(value = "公司网址")
        @SerializedName("website_address")
        private String website_address;
        //@ApiModelProperty(value = "招聘会地点")
        @SerializedName("jobfair_location")
        private String jobfair_location;
        //@ApiModelProperty(value = "招聘会时间")
        @SerializedName("jobfair_time")
        private String jobfair_time;
        //@ApiModelProperty(value = "语言要求")
        @SerializedName("language_required")
        private String language_required;
        //@ApiModelProperty(value = "工作性质")
        @SerializedName("job_nature")
        private String job_nature;
        //@ApiModelProperty(value = "职位职能")
        @SerializedName("job_functions")
        private String job_functions;
        //@ApiModelProperty(value = "学历要求")
        @SerializedName("education_required")
        private String education_required;
        //@ApiModelProperty(value = "企业规模")
        @SerializedName("enscale")
        private String enscale;
        //@ApiModelProperty(value = "年龄要求")
        @SerializedName("agerequired")
        private String agerequired;
        //@ApiModelProperty(value = "邮编")
        @SerializedName("postcode")
        private String postcode;
        //@ApiModelProperty(value = "邮箱")
        @SerializedName("e_mail")
        private String e_mail;
        //@ApiModelProperty(value = "联系人及联系方式")
        @SerializedName("contact_information")
        private String contact_information;
        //@ApiModelProperty(value = "公司简介")
        @SerializedName("company_introduction")
        private String company_introduction;
        //@ApiModelProperty(value = "所属行业")
        @SerializedName("industry")
        private String industry;
        //@ApiModelProperty(value = "企业性质")
        @SerializedName("company_nature")
        private String company_nature;
        //@ApiModelProperty(value = "专业要求")
        @SerializedName("majors_required")
        private String majors_required;
        //@ApiModelProperty(value = "所属部门")
        @SerializedName("department")
        private String department;
        //@ApiModelProperty(value = "下属人数")
        @SerializedName("underling_numbers")
        private String underling_numbers;
        //@ApiModelProperty(value = "查看率")
        @SerializedName("view_rate")
        private String view_rate;
        //@ApiModelProperty(value = "性别要求")
        @SerializedName("sex_required")
        private String sex_required;
        //@ApiModelProperty(value = "bbd招聘人数")
        @SerializedName("bbd_recruit_num")
        private Integer bbd_recruit_num;
        //@ApiModelProperty(value = "bbd行业划分")
        @SerializedName("bbd_industry")
        private String bbd_industry;
        //@ApiModelProperty(value = "反馈率")
        @SerializedName("responserate")
        private String responserate;
        //@ApiModelProperty(value = "bbd职位薪资")
        @SerializedName("bbd_salary")
        private String bbd_salary;
        //@ApiModelProperty(value = "薪资体系")
        @SerializedName("salary_system")
        private String salary_system;
        //@ApiModelProperty(value = "汇报对象")
        @SerializedName("reportto")
        private String reportto;
        //@ApiModelProperty(value = "有效日期")
        @SerializedName("validdate")
        private String validdate;
        //@ApiModelProperty(value = "简历投递时间")
        @SerializedName("delivery_time")
        private String delivery_time;
        //@ApiModelProperty(value = "招聘页面内容")
        @SerializedName("page_content")
        private String page_content;
        //@ApiModelProperty(value = "source")
        @SerializedName("source")
        private String source;
        //@ApiModelProperty(value = "发布时间(排重)")
        @SerializedName("pubdate_doublet")
        private String pubdate_doublet;

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getJob_title() {
            return job_title;
        }

        public void setJob_title(String job_title) {
            this.job_title = job_title;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getRecruit_numbers() {
            return recruit_numbers;
        }

        public void setRecruit_numbers(String recruit_numbers) {
            this.recruit_numbers = recruit_numbers;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getBbd_type() {
            return bbd_type;
        }

        public void setBbd_type(String bbd_type) {
            this.bbd_type = bbd_type;
        }

        public String getJob_descriptions() {
            return job_descriptions;
        }

        public void setJob_descriptions(String job_descriptions) {
            this.job_descriptions = job_descriptions;
        }

        public String getBenefits() {
            return benefits;
        }

        public void setBenefits(String benefits) {
            this.benefits = benefits;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getService_year() {
            return service_year;
        }

        public void setService_year(String service_year) {
            this.service_year = service_year;
        }

        public String getWebsite_address() {
            return website_address;
        }

        public void setWebsite_address(String website_address) {
            this.website_address = website_address;
        }

        public String getJobfair_location() {
            return jobfair_location;
        }

        public void setJobfair_location(String jobfair_location) {
            this.jobfair_location = jobfair_location;
        }

        public String getJobfair_time() {
            return jobfair_time;
        }

        public void setJobfair_time(String jobfair_time) {
            this.jobfair_time = jobfair_time;
        }

        public String getLanguage_required() {
            return language_required;
        }

        public void setLanguage_required(String language_required) {
            this.language_required = language_required;
        }

        public String getJob_nature() {
            return job_nature;
        }

        public void setJob_nature(String job_nature) {
            this.job_nature = job_nature;
        }

        public String getJob_functions() {
            return job_functions;
        }

        public void setJob_functions(String job_functions) {
            this.job_functions = job_functions;
        }

        public String getEducation_required() {
            return education_required;
        }

        public void setEducation_required(String education_required) {
            this.education_required = education_required;
        }

        public String getEnscale() {
            return enscale;
        }

        public void setEnscale(String enscale) {
            this.enscale = enscale;
        }

        public String getAgerequired() {
            return agerequired;
        }

        public void setAgerequired(String agerequired) {
            this.agerequired = agerequired;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getE_mail() {
            return e_mail;
        }

        public void setE_mail(String e_mail) {
            this.e_mail = e_mail;
        }

        public String getContact_information() {
            return contact_information;
        }

        public void setContact_information(String contact_information) {
            this.contact_information = contact_information;
        }

        public String getCompany_introduction() {
            return company_introduction;
        }

        public void setCompany_introduction(String company_introduction) {
            this.company_introduction = company_introduction;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getCompany_nature() {
            return company_nature;
        }

        public void setCompany_nature(String company_nature) {
            this.company_nature = company_nature;
        }

        public String getMajors_required() {
            return majors_required;
        }

        public void setMajors_required(String majors_required) {
            this.majors_required = majors_required;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getUnderling_numbers() {
            return underling_numbers;
        }

        public void setUnderling_numbers(String underling_numbers) {
            this.underling_numbers = underling_numbers;
        }

        public String getView_rate() {
            return view_rate;
        }

        public void setView_rate(String view_rate) {
            this.view_rate = view_rate;
        }

        public String getSex_required() {
            return sex_required;
        }

        public void setSex_required(String sex_required) {
            this.sex_required = sex_required;
        }

        public Integer getBbd_recruit_num() {
            return bbd_recruit_num;
        }

        public void setBbd_recruit_num(Integer bbd_recruit_num) {
            this.bbd_recruit_num = bbd_recruit_num;
        }

        public String getBbd_industry() {
            return bbd_industry;
        }

        public void setBbd_industry(String bbd_industry) {
            this.bbd_industry = bbd_industry;
        }

        public String getResponserate() {
            return responserate;
        }

        public void setResponserate(String responserate) {
            this.responserate = responserate;
        }

        public String getBbd_salary() {
            return bbd_salary;
        }

        public void setBbd_salary(String bbd_salary) {
            this.bbd_salary = bbd_salary;
        }

        public String getSalary_system() {
            return salary_system;
        }

        public void setSalary_system(String salary_system) {
            this.salary_system = salary_system;
        }

        public String getReportto() {
            return reportto;
        }

        public void setReportto(String reportto) {
            this.reportto = reportto;
        }

        public String getValiddate() {
            return validdate;
        }

        public void setValiddate(String validdate) {
            this.validdate = validdate;
        }

        public String getDelivery_time() {
            return delivery_time;
        }

        public void setDelivery_time(String delivery_time) {
            this.delivery_time = delivery_time;
        }

        public String getPage_content() {
            return page_content;
        }

        public void setPage_content(String page_content) {
            this.page_content = page_content;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPubdate_doublet() {
            return pubdate_doublet;
        }

        public void setPubdate_doublet(String pubdate_doublet) {
            this.pubdate_doublet = pubdate_doublet;
        }
    }
}
