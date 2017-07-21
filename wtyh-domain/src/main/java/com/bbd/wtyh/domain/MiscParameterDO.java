package com.bbd.wtyh.domain;

import java.io.Serializable;

/**
 * Created by cgj on 2017/7/20.
 */
public class MiscParameterDO implements Serializable {
    int para_id;
    String name;
    String description;
    Integer value1;
    Integer value2;
    Integer value3;
    String str;

    public int getPara_id() {
        return para_id;
    }

    public void setPara_id(int para_id) {
        this.para_id = para_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getValue1() {
        return value1;
    }

    public void setValue1(Integer value1) {
        this.value1 = value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

    public Integer getValue3() {
        return value3;
    }

    public void setValue3(Integer value3) {
        this.value3 = value3;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
