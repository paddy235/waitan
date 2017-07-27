package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
@Table(name = "company_credit_data_items")
public class CompanyCreditDataItemsDO extends BaseDO{
    @Id
    @Column(name = "id")
    private Integer id;

    private String resourceName;

    private String dataItem;

    private String dataItemName;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDataItem() {
        return dataItem;
    }

    public void setDataItem(String dataItem) {
        this.dataItem = dataItem;
    }

    public String getDataItemName() {
        return dataItemName;
    }

    public void setDataItemName(String dataItemName) {
        this.dataItemName = dataItemName;
    }
}

