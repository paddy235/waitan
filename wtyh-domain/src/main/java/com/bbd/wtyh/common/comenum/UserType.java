package com.bbd.wtyh.common.comenum;

/**
 * Created by cgj on 2017/3/31.
 */
public enum UserType {
    SUPER_ADMIN("S", "超级管理员", true, true, UserRank.SUPER_A),
    BACK_ADMIN("B", "系统管理员", false, true, UserRank.ADMIN),
    BUSINESS_MANAGER("M", "业务数据管理员",true, true, UserRank.ADMIN),
    GENERAL("F", "普通用户", true, false, UserRank.GENERAL),
    DISTRICT_MANAGER("D", "区县管理员", true, false, UserRank.GENERAL);

    private String typeCode;
    private String typeName;
    private boolean foreMask; //前台标志
    private boolean backMask; //后台标志
    private UserRank userRank; //用户等级

    UserType(String typeCode, String typeName, boolean foreMask, boolean backMask, UserRank userRank) {
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.foreMask = foreMask;
        this.backMask = backMask;
        this.userRank = userRank;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean isForeMask() {
        return foreMask;
    }

    public boolean isBackMask() {
        return backMask;
    }

    public UserRank getUserRank() {
        return userRank;
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