package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/18.
 */
public class RecruitPeopleDistributeDO {
    private String msg;
    private String total;
    private List<Rdata> rdata;

    public class Rdata {
        private String x_value;
        private String y_value;

        public String getX_value() {
            return x_value;
        }

        public void setX_value(String x_value) {
            this.x_value = x_value;
        }

        public String getY_value() {
            return y_value;
        }

        public void setY_value(String y_value) {
            this.y_value = y_value;
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Rdata> getRdata() {
        return rdata;
    }

    public void setRdata(List<Rdata> rdata) {
        this.rdata = rdata;
    }
}
