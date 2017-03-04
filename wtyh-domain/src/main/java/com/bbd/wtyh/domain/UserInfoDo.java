package com.bbd.wtyh.domain;

import java.io.Serializable;
import java.util.Date;

/** veo
 * Created by Administrator on 2017/3/2.
 */
public class UserInfoDo implements Serializable {
    //登录名
    private String loginName;

    //新指定的登录名
    private String newLoginName;

    //前台用户标记
    private boolean foreUserMk;

    //前台用户登录密码
    private String forePassword;

    //后台用户标记
    private boolean backUserMk;

    //后台用户登录密码
    private String backPassword;

    //真实姓名
    private String realName;

    //联系电话
    private String mobile;

    //电子信箱
    private String email;

    //部门
    private String department;

    //地区代码
    private String areaCode;

    //创建人
    private String createBy;

    //修改人
    private String updateBy;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNewLoginName() {
        return newLoginName;
    }

    public void setNewLoginName(String newLoginName) {
        this.newLoginName = newLoginName;
    }

    public boolean isForeUserMk() {
        return foreUserMk;
    }

    public void setForeUserMk(boolean foreUserMk) {
        this.foreUserMk = foreUserMk;
    }

    public String getForePassword() {
        return forePassword;
    }

    public void setForePassword(String forePassword) {
        this.forePassword = forePassword;
    }

    public boolean isBackUserMk() {
        return backUserMk;
    }

    public void setBackUserMk(boolean backUserMk) {
        this.backUserMk = backUserMk;
    }

    public String getBackPassword() {
        return backPassword;
    }

    public void setBackPassword(String backPassword) {
        this.backPassword = backPassword;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
