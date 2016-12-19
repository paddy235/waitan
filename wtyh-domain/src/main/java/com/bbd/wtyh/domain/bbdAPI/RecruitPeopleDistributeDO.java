package com.bbd.wtyh.domain.bbdAPI;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/18.
 */
public class RecruitPeopleDistributeDO {
    private String msg;
    private String total;
    private List<Rdata> rdata;

    public static class Rdata {
        @JSONField(name = "x_unit")
        private String name;

        @JSONField(name = "x_value")
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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
