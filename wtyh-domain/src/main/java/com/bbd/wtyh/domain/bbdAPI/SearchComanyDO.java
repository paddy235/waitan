package com.bbd.wtyh.domain.bbdAPI;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/16.
 */
public class SearchComanyDO {

    private String total;
    private String sum;
    private List<Rdata> rdata;

    public static  class Rdata implements Serializable {
        private String company_name;
        private String regno;
        private String company_type;
        private String frname;
        // 注册资本
        private String regcap;
        // 成立时间
        private String esdate;
        // 注册地址
        private String address;
        // BBD内置ID
        @JSONField(name = "bbd_qyxx_id")
        private String bbdQyxxId;
        @JSONField(name = "bbd_history_name")
        private List<String> bbdHistoryName;
        private String showHisName;

        public String getShowHisName() {
            return showHisName;
        }

        public void setShowHisName(String showHisName) {
            this.showHisName = showHisName;
        }

        public List<String> getBbdHistoryName() {
            return bbdHistoryName;
        }

        public void setBbdHistoryName(List<String> bbdHistoryName) {
            this.bbdHistoryName = bbdHistoryName;
        }

        public String getBbdQyxxId() {
            return bbdQyxxId;
        }

        public void setBbdQyxxId(String bbdQyxxId) {
            this.bbdQyxxId = bbdQyxxId;
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
