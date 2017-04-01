package com.bbd.wtyh.common.comenum;

/** //用户等级
 * Created by cgj on 2017/4/1.
 */
public enum UserRank {
    superA("超管级别"), //超管级别
    bAdmin("普管级别"), //普管级别
    general("普通级别"); //普通级别

    String name;

    UserRank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
