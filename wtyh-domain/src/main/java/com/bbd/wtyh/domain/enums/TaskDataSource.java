package com.bbd.wtyh.domain.enums;

/**
 * Created by Marco on 2016/8/7 0007.
 */
public enum TaskDataSource {
    DS_BBD(1, "BBD"),
    DS_WANGDAI(2, "网贷之家"),
    DS_CREDIT(3, "公信中心");

    private int type;
    private String desc;

    TaskDataSource(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer type() {
        return this.type;
    }

    public String desc() {
        return this.desc;
    }

    public static  String getDataSourceName(Integer dataSource){
        if (null == dataSource) {
            return "";
        }

        TaskDataSource[] types = TaskDataSource.values();
        for (TaskDataSource t : types) {
            if (dataSource.equals(t.type)) {
                return t.desc();
            }
        }

        return "";
    }


}
