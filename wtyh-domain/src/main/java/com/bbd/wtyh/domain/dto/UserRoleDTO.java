package com.bbd.wtyh.domain.dto;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public class UserRoleDTO {

    private Integer id; // 主键

    private String loginName; // 登录名

    private String realName; // 真实姓名

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
