package com.bbd.wtyh.domain.dto;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Marco on 2016/8/10.
 */
public class PrivateFundTypeStatisticDTO {

    private String typeName;

    private Integer amount;

    private List<PrivateFundTypeStatisticDTO> children = Lists.newArrayList();


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<PrivateFundTypeStatisticDTO> getChildren() {
        return children;
    }

    public void setChildren(List<PrivateFundTypeStatisticDTO> children) {
        this.children = children;
    }
}
