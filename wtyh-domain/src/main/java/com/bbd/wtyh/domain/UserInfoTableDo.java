package com.bbd.wtyh.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cgj on 2017/2/28.
 */

public class UserInfoTableDo implements Serializable {

    private Integer id; //主键

    private String status;  //用户状态（F：冻结；A：激活）

//    private boolean foreUserFlag; //前台用户标志

//    private boolean backUserFlag; //后台用户标志

    private String userType; //用户类型（F：前台；B：后台；A：前后台；U：待定）

    private String loginName; //登录名

    private String forePwd; //前台登录密码

    private String backPwd; //后台登录密码

    private String realName; //真实姓名

    private String fixPhone; //联系固话

    private String mobile; //联系手机

    private String email; //电子信箱

    private String department; //部门

    private String areaCode; //地区代码

    private Date createDate; //创建日期

    private String createBy; //创建人

    private Date updateDate; //修改日期

    private String updateBy; //修改人


    @Override
    public String toString(){
        String tmp = "id=%d，" +
                     "登录名=%s，" +
                     "用户状态（F：冻结；A：激活）=%s," +
                     //"前台用户标志" +
                    // "后台用户标志" +
                "用户类型（F：前台；B：后台；A：前后台；U：待定）=%s,"+
                     "前台登录密码=%s," +
                     "后台登录密码=%s," +
                     "真实姓名=%s," +
                     "固话=%s," +
                     "手机=%s," +
                     "电子信箱=%s," +
                     "部门=%s," +
                     "地区代码=%s," +
                     "创建人=%s," +
                     "修改人=%s," +
                     "创建时间=%s，" +
                     "修改时间=%s";
        return String.format(tmp,getId(),
                                getLoginName(),
                                getStatus(),
                //isForeUserFlag(),
                //isBackUserFlag(),
                                getUserType(),
                                getForePwd(),
                                getBackPwd(),
                                getRealName(),
                getFixPhone(),
                                getMobile(),
                                getEmail(),
                                getDepartment(),
                                getAreaCode(),
                                getCreateBy(),
                                getUpdateBy(),
                                getCreateDate(),
                                getUpdateDate());
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getForePwd() {
        return forePwd;
    }

    public void setForePwd(String forePwd) {
        this.forePwd = forePwd;
    }

    public String getBackPwd() {
        return backPwd;
    }

    public void setBackPwd(String backPwd) {
        this.backPwd = backPwd;
    }

/*    public boolean isForeUserFlag() {
        return foreUserFlag;
    }

    public void setForeUserFlag(boolean foreUserFlag) {
        this.foreUserFlag = foreUserFlag;
    }

    public boolean isBackUserFlag() {
        return backUserFlag;
    }

    public void setBackUserFlag(boolean backUserFlag) {
        this.backUserFlag = backUserFlag;
    }*/

    public String getFixPhone() {
        return fixPhone;
    }

    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone;
    }
}