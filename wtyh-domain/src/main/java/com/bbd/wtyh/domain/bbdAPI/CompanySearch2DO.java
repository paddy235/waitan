package com.bbd.wtyh.domain.bbdAPI;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cgj on 2017/7/13.
 */
public class CompanySearch2DO {

    private String total;
    private String sum;
    private List<Rdata> rdata;
    private String err_code;

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public static  class Highlight implements Serializable {
        private List<String> baxx;
        private List<String> gdxx;
        private List<String> frname;
        private List<String> gdxx_person;

        public List<String> getBaxx() {
            return baxx;
        }

        public void setBaxx(List<String> baxx) {
            this.baxx = baxx;
        }

        public List<String> getGdxx() {
            return gdxx;
        }

        public void setGdxx(List<String> gdxx) {
            this.gdxx = gdxx;
        }

        public List<String> getFrname() {
            return frname;
        }

        public void setFrname(List<String> frname) {
            this.frname = frname;
        }

        public List<String> getGdxx_person() {
            return gdxx_person;
        }

        public void setGdxx_person(List<String> gdxx_person) {
            this.gdxx_person = gdxx_person;
        }
    }

    public static  class Rdata implements Serializable { //（不完整，根据需要可补充）
        private String company_name;
        private String bbd_qyxx_id;
        private String credit_code;
        private String regno;
        private String company_type;
        //法人代表
        private String frname;
        // 注册资本
        private String regcap;
        // 成立时间
        private String esdate;
        // 注册地址
        private String address;
        //省
        private String province;
        //市
        private String city;
        //区县
        private String district;
        //董监高
        private List<String> baxx;
        //关键字所属位置
        private Highlight highlight;

        public Highlight getHighlight() {
            return highlight;
        }

        public void setHighlight(Highlight highlight) {
            this.highlight = highlight;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public List<String> getBaxx() {
            return baxx;
        }

        public void setBaxx(List<String> baxx) {
            this.baxx = baxx;
        }

        public String getEsdate() {
            return esdate;
        }

        public void setEsdate(String esdate) {
            this.esdate = esdate;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRegcap() {
            return regcap;
        }

        public void setRegcap(String regcap) {
            this.regcap = regcap;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getRegno() {
            return regno;
        }

        public void setRegno(String regno) {
            this.regno = regno;
        }

        public String getBbd_qyxx_id() {
            return bbd_qyxx_id;
        }

        public void setBbd_qyxx_id(String bbd_qyxx_id) {
            this.bbd_qyxx_id = bbd_qyxx_id;
        }

        public String getCredit_code() {
            return credit_code;
        }

        public void setCredit_code(String credit_code) {
            this.credit_code = credit_code;
        }

        public String getCompany_type() {
            return company_type;
        }

        public void setCompany_type(String company_type) {
            this.company_type = company_type;
        }

        public String getFrname() {
            return frname;
        }

        public void setFrname(String frname) {
            this.frname = frname;
        }
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public List<Rdata> getRdata() {
        return rdata;
    }

    public void setRdata(List<Rdata> rdata) {
        this.rdata = rdata;
    }
}
