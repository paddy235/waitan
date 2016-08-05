package com.bbd.wtyh.domain.dto;

/**
 * 关联关系类型
 * 关系类型有个优先级，由于枚举类型的默认实现了comparable接口，并且是按ordinal的值升序
 * 所以ordinal小的，有更高的优先级。也就是说，如果同时有几个关系， 则会使用ordinal小的关系。（即排在前面的关系，会覆盖后面的关系）
 * Created by zhaoyuan
 * 2016/5/24.
 */
public enum RelationType {


    /**
     * 投资
     */
    INVEST(1,"股东"),

    /**
     * 法人
     */
    LEGAL(0,"法人"),

    /**
     * 董事
     */
    DIRECTOR(0,"董事"),

    /**
     * 监事
     */
    SUPERVISOR(0,"监事"),

    /**
     * 高管
     */
    EXECUTIVE(0,"高管");

    /**
     * 1代表股东
     * 0代表高管
     */
    private int relation;

    private String relationDesc;

    RelationType(int relation, String relationDesc) {
        this.relation = relation;
        this.relationDesc = relationDesc;
    }

    public int getRelation() {
        return relation;
    }

    public String getRelationDesc() {
        return relationDesc;
    }


    @Override
    public String toString() {
        return relationDesc;
    }
}
