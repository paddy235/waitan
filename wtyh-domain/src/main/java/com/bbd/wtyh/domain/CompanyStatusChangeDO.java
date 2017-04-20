package com.bbd.wtyh.domain;

import com.bbd.wtyh.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/18 0018.
 */
@Entity
@Table(name = "company_status_change")
public class CompanyStatusChangeDO {

    public static final byte TYPE_CUR_1 = 1;//人民币
    public static final byte TYPE_CUR_2 = 2;//美元

    public static final String CLOSE_TYPE_NAME_1 = "吊销";
    public static final String CLOSE_TYPE_NAME_2= "注销";
    public static final String CLOSE_TYPE_NAME_3= "拟吊销";
    public static final String CLOSE_TYPE_NAME_4= "拟注销";
    public static final String CLOSE_TYPE_NAME_5= "停业";
    public static final String CLOSE_TYPE_NAME_6= "迁出";
    public static final String CLOSE_TYPE_NAME_7= "撤销";
    public static final String CLOSE_TYPE_NAME_8= "清算";
    public static final String CLOSE_TYPE_NAME_9= "经营期限届满";
    public static final String CLOSE_TYPE_NAME_10= "其他";

    public static final String CHG_TYPE_NAME_1= "新增";
    public static final String CHG_TYPE_NAME_2= "停业";

    public static final String SOURCE_TYPE_NAME_1= "新注册";
    public static final String SOURCE_TYPE_NAME_2= "新发现";
    public static final String SOURCE_TYPE_NAME_3= "人工修改";


    /** ID */
    @Id
    @Column(name = "id")
    private Long id;

    /** 公司ID */
    @Column(name = "company_id")
    private Integer companyId;

    /** 企业名称 */
    @Excel(exportName = "企业名称")
    @Column(name = "company_name")
    private String companyName;

    /** 组织机构代码 */
    @Column(name = "organization_code")
    private String organizationCode;

    /** 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁  */
    @Column(name = "company_type")
    private Integer companyType;

    @Excel(exportName = "新金融类别")
    private String companyTypeName;

    /** 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁  */
    @Column(name = "old_company_type")
    private Integer oldCompanyType;


    @Excel(exportName = "原始类别")
    private String oldCompanyTypeName;

    /** 区域ID */
    @Column(name = "area_id")
    private Integer areaId;

    /** 区域名称 */
    @Excel(exportName = "所在区域")
    @Column(name = "area_name")
    private String areaName;

    /** 注册时间 */
    @Excel(exportName = "注册时间")
    @Column(name = "register_date")
    private Date registerDate;

    /** 调整时间 */
    @Excel(exportName = "调整时间")
    @Column(name = "adjust_date")
    private Date adjustDate;

    /** 停业时间 */
    @Excel(exportName = "停业时间")
    @Column(name = "closed_date")
    private Date closedDate;

    /** 排序时间 */
    @Column(name = "order_date")
    private Date orderDate;

    /** 注册资本 */
    @Excel(exportName = "注册资本")
    @Column(name = "registered_capital")
    private Integer registeredCapital;

    /** 注册资本类型 */
    @Column(name = "registered_capital_type")
    private Integer registeredCapitalType;

    /** 注册资本类型名称*/
    private String registeredCapitalTypeName;

    /** 变化类型 1:新增,2:停业 */
    @Column(name = "change_tpye")
    private Integer changeTpye;

    @Excel(exportName = "变化类型")
    private String changeTpyeName;

    /** 新增来源 1:新注册,2:新发现,3:人工修改 */
    @Column(name = "source")
    private Integer source;

    @Excel(exportName = "新增来源")
    private String sourceName;

    /** 停业原因 */
    @Column(name = "closed_type")
    private Integer closedType;

    @Excel(exportName = "停业原因")
    private String closedTypeName;

    /** 注册地址 */
    @Excel(exportName = "注册地址")
    @Column(name = "address")
    private String address;

    /** 创建人 */
    @Column(name = "create_by")
    private String createBy;

    /** 创建时间 */
    @Column(name = "create_date")
    private Date createDate;

    /** 修改人 */
    @Column(name = "update_by")
    private String updateBy;

    /** 修改时间 */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 获取 ID
     *
     * @return id ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 公司ID
     *
     * @return companyId 公司ID
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置 公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取 企业名称
     *
     * @return companyName 企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置 企业名称
     *
     * @param companyName 企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取 组织机构代码
     *
     * @return organizationCode 组织机构代码
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 设置 组织机构代码
     *
     * @param organizationCode 组织机构代码
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    /**
     * 获取 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
     *
     * @return companyType 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
     */
    public Integer getCompanyType() {
        return companyType;
    }

    /**
     * 设置 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
     *
     * @param companyType 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
     */
    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    /**
     * 获取 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
     *
     * @return oldCompanyType 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
     */
    public Integer getOldCompanyType() {
        return oldCompanyType;
    }

    /**
     * 设置 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
     *
     * @param oldCompanyType 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
     */
    public void setOldCompanyType(Integer oldCompanyType) {
        this.oldCompanyType = oldCompanyType;
    }

    /**
     * 获取 区域ID
     *
     * @return areaId 区域ID
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置 区域ID
     *
     * @param areaId 区域ID
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取 区域名称
     *
     * @return areaName 区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置 区域名称
     *
     * @param areaName 区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取 注册时间
     *
     * @return registerDate 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * 设置 注册时间
     *
     * @param registerDate 注册时间
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * 获取 调整时间
     *
     * @return adjustDate 调整时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getAdjustDate() {
        return adjustDate;
    }

    /**
     * 设置 调整时间
     *
     * @param adjustDate 调整时间
     */
    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    /**
     * 获取 停业时间
     *
     * @return closedDate 停业时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getClosedDate() {
        return closedDate;
    }

    /**
     * 设置 停业时间
     *
     * @param closedDate 停业时间
     */
    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    /**
     * 获取 排序时间
     *
     * @return orderDate 排序时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 设置 排序时间
     *
     * @param orderDate 排序时间
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 获取 注册资本
     *
     * @return registeredCapital 注册资本
     */
    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * 设置 注册资本
     *
     * @param registeredCapital 注册资本
     */
    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Integer getRegisteredCapitalType() {
        return registeredCapitalType;
    }

    public void setRegisteredCapitalType(Integer registeredCapitalType) {
        this.registeredCapitalType = registeredCapitalType;
    }
    /**
     * 获取 变化类型 1:新增,2:停业
     *
     * @return changeTpye 变化类型 1:新增,2:停业
     */
    public Integer getChangeTpye() {
        return changeTpye;
    }

    /**
     * 设置 变化类型 1:新增,2:停业
     *
     * @param changeTpye 变化类型 1:新增,2:停业
     */
    public void setChangeTpye(Integer changeTpye) {
        this.changeTpye = changeTpye;
    }

    /**
     * 获取 新增来源 1:新注册,2:新发现,3:人工修改
     *
     * @return source 新增来源 1:新注册,2:新发现,3:人工修改
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置 新增来源 1:新注册,2:新发现,3:人工修改
     *
     * @param source 新增来源 1:新注册,2:新发现,3:人工修改
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 获取 停业原因
     *
     * @return closedType 停业原因
     */
    public Integer getClosedType() {
        return closedType;
    }

    /**
     * 设置 停业原因
     *
     * @param closedType 停业原因
     */
    public void setClosedType(Integer closedType) {
        this.closedType = closedType;
    }

    /**
     * 获取 注册地址
     *
     * @return address 注册地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 注册地址
     *
     * @param address 注册地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取 创建人
     *
     * @return createBy 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取 创建时间
     *
     * @return createDate 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置 创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取 修改人
     *
     * @return updateBy 修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置 修改人
     *
     * @param updateBy 修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取 修改时间
     *
     * @return updateDate 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置 修改时间
     *
     * @param updateDate 修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCompanyTypeName() {
        return CompanyDO.companyTypeCN(this.companyType==null?null:this.companyType.byteValue());
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    public String getOldCompanyTypeName() {

        return CompanyDO.companyTypeCN(this.oldCompanyType==null?null:this.oldCompanyType.byteValue());
    }

    public void setOldCompanyTypeName(String oldCompanyTypeName) {
        this.oldCompanyTypeName = oldCompanyTypeName;
    }

    public String getChangeTpyeName() {

        if (null == changeTpye) {
            return "";
        }
        switch (changeTpye) {
            case 1:
                return CHG_TYPE_NAME_1;
            case 2:
                return CHG_TYPE_NAME_2;
            default:
                return "";

        }
    }

    public void setChangeTpyeName(String changeTpyeName) {
        this.changeTpyeName = changeTpyeName;
    }

    public String getSourceName() {

            if (null == source) {
                return "";
            }
            switch (source) {
                case 1:
                    return SOURCE_TYPE_NAME_1;
                case 2:
                    return SOURCE_TYPE_NAME_2;
                case 3:
                    return SOURCE_TYPE_NAME_3;
                default:
                    return "";

            }

    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getClosedTypeName() {

            if (null == closedType) {
                return "";
            }
            switch (closedType) {
                case 1:
                    return CLOSE_TYPE_NAME_1;
                case 2:
                    return CLOSE_TYPE_NAME_2;
                case 3:
                    return CLOSE_TYPE_NAME_3;
                case 4:
                    return CLOSE_TYPE_NAME_4;
                case 5:
                    return CLOSE_TYPE_NAME_5;
                case 6:
                    return CLOSE_TYPE_NAME_6;
                case 7:
                    return CLOSE_TYPE_NAME_7;
                case 8:
                    return CLOSE_TYPE_NAME_8;
                case 9:
                    return CLOSE_TYPE_NAME_9;
                case 10:
                    return CLOSE_TYPE_NAME_10;
                default:
                    return "";


        }
    }

    public void setClosedTypeName(String closedTypeName) {
        this.closedTypeName = closedTypeName;
    }

    public String getRegisteredCapitalTypeName() {
            if (null == registeredCapitalType) {
                return "";
            }
            switch (registeredCapitalType.byteValue()) {
                case TYPE_CUR_1:
                    return "人民币";
                case TYPE_CUR_2:
                    return "美元";
                default:
                    return "";
            }
    }


    public void setRegisteredCapitalTypeName(String registeredCapitalTypeName) {
        this.registeredCapitalTypeName = registeredCapitalTypeName;
    }
}
