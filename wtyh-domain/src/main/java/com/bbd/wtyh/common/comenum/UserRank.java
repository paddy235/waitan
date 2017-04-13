package com.bbd.wtyh.common.comenum;

/** //用户等级
 * Created by cgj on 2017/4/1.
 */
public enum UserRank {
    SUPER_A("超管级",0),
    ADMIN("管理员级",10),
    GENERAL("普通用户级",100);

    private String name;
    private int rank; //等级代码，从0开始，越小等级越高

    UserRank(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }
}
