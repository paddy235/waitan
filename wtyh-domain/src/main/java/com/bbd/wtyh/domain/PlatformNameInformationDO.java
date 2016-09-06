
/**
 * @Title: Area.java
 * @Package com.bbd.wtyh.entity
 * @Description: TODO
 * @author Ian.Su
 * @date 2016年8月5日 上午11:58:52
 * @version V1.0
 */

package com.bbd.wtyh.domain;


/**
 * 平台信息
 * @author
 * @since 2016.08.21
 */
public class PlatformNameInformationDO {
    private Integer companyId;
    private String platformName;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
}
