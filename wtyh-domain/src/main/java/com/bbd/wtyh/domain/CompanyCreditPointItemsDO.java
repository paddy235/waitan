package com.bbd.wtyh.domain;

public class CompanyCreditPointItemsDO extends BaseDO {
	
   
	private Integer id;

    private String item;

    private Integer point;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }



}