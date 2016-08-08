package com.bbd.wtyh.domain.enums;

/**
 * 关联关系结点类型
 * Created by zhaoyuan
 * 2016/5/24.
 */
public enum NodeLabel {
    BBDCompany,
    BBDPerson;

    public static void main(String[] args) {
        System.out.println(NodeLabel.BBDCompany.ordinal());
    }


}
