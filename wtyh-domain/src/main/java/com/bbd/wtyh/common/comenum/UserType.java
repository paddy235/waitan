package com.bbd.wtyh.common.comenum;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2017/3/31.
 */
public enum UserType {
    SUPER_ADMIN("S", "超级管理员", true, true, UserRank.SUPER_A),
    BACK_ADMIN("B", "系统管理员", false, true, UserRank.ADMIN),
    BUSINESS_MANAGER("M", "业务数据管理员",true, true, UserRank.ADMIN),
    GENERAL("F", "普通用户", true, false, UserRank.GENERAL),
    DISTRICT_USER("D", "区县用户", true, false, UserRank.GENERAL);

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
        if( StringUtils.isBlank(tpCode) ) {
            return  null;
        }
        for( UserType ut: UserType.values() ) {
            if( ut.getTypeCode().equals(tpCode) ) {
                return  ut;
            }
        }
        return null;
    }

    /**
     * 获取用户类型列表，按条件生成
     * @param joinT true：加入“T/全部”列
     * @param loginRank 当非空时 只生成小于传入等级的用户类型列表
     * @return List<Map<String, String>> 类型, 其中Map<"tpCode","tpName">
     */
    public static List<Map<String, String>> getUserTypeList( boolean joinT, UserRank loginRank ) {
        List<Map<String, String>> userTypeList =new ArrayList<Map<String, String>>() {{
            if( joinT ) {
                add(new HashMap<String, String>() {{
                    put("tpCode", "T");
                    put("tpName", "全部");
                }});
            }
            for (  UserType uType  :  UserType.values() ) {
                if( null ==loginRank ||( uType.getUserRank().getRankVal() <loginRank.getRankVal() ) ) {
                    add(new HashMap<String, String>() {{
                        put("tpCode", uType.getTypeCode());
                        put("tpName", uType.getTypeName());
                    }});
                }
            }
        }};
        return userTypeList;
    }
}