package com.bbd.wtyh.common.comenum;

/**
 * Created by Administrator on 2017/3/31.
 */
public enum UserType {
    superManager("S", "超级管理员"),
    general("F", "普通用户"),
    backAdmin("B", "系统管理员");
    //businessManager("M", "业务数据管理员"); //todo 4.10 之后用

    private String typeCode;
    private String typeName;

    UserType(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    static public UserType getUserTypeByCode(String tpCode) {
        if( null ==tpCode ) {
            return  null;
        }
        for( UserType ut: UserType.values() ) {
            if( ut.getTypeCode().equals(tpCode) ) {
                return  ut;
            }
        }
        return null;
    }
}