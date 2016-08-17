package com.bbd.wtyh.domain.vo;

/**
 * Created by Administrator on 2016/8/17 0017.
 */
public class LevelSortVO {
    private String levelCode;

    private Integer id;

    private Integer fid;

    private String funcName;

    private String url;

    private String actionName;

    private String methodName;

    private Integer isMenu;

    private String menuImg;

    private String useFlag;

    private String permissionCode;

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    @Override
    public String toString() {
        return "LevelSortVO{" +
                "levelCode='" + levelCode + '\'' +
                ", id=" + id +
                ", fid=" + fid +
                ", funcName='" + funcName + '\'' +
                ", url='" + url + '\'' +
                ", actionName='" + actionName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", isMenu=" + isMenu +
                ", menuImg='" + menuImg + '\'' +
                ", useFlag='" + useFlag + '\'' +
                ", permissionCode='" + permissionCode + '\'' +
                '}';
    }

}
