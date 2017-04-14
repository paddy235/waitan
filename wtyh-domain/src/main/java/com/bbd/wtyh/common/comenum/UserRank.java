package com.bbd.wtyh.common.comenum;

/** //用户等级
 * Created by cgj on 2017/4/1.
 */
public enum UserRank {
    SUPER_A("超管级",10000),
    ADMIN("管理员级",1000),
    GENERAL("普通用户级",10);

    private String name;
    private int rankVal; //等级值，数值越大等级越高

    UserRank(String name, int rank) {
        this.name = name;
        this.rankVal = rank;
    }

    public String getName() {
        return name;
    }

    /**
     * 等级值，int 类型，数值越大等级越高
     * @return
     */
    public int getRankVal() {
        return rankVal;
    }
}
