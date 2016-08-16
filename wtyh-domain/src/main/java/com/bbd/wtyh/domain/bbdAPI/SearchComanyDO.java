package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/16.
 */
public class SearchComanyDO {

    private int total;
    private int sum;
    private List<Rdata> rdata;

    public class Rdata {
        private String company_name;
        private String regno;
        private String company_type;
        private String frname;
        // TODO: 暂缺 注册资本
        // TODO: 暂缺 成立时间
        // TODO: 暂缺 注册地址


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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<Rdata> getRdata() {
        return rdata;
    }

    public void setRdata(List<Rdata> rdata) {
        this.rdata = rdata;
    }
}
