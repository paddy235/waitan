package com.bbd.wtyh.domain.bbdAPI;

import com.bbd.wtyh.common.comenum.UserType;
import org.apache.commons.lang.StringUtils;

/**
 * 企业全息信息查询--企业工商信息--行业枚举
 *
 * @author wangchenge
 * @since 2016.08.15
 */
public enum IndustryCodeDO {
    A("农、林、牧、渔业"),
    B("采矿业"),
    C("制造业"),
    D("电力、热力、燃气及水生产和供应业"),
    E("建筑业"),
    F("批发和零售业"),
    G("交通运输、仓储和邮政业"),
    H("住宿和餐饮业"),
    I("信息传输、软件和信息技术服务业"),
    J("金融业"),
    K("房地产业"),
    L("租赁和商务服务业"),
    M("科学研究和技术服务业"),
    N("水利、环境和公共设施管理业"),
    O("居民服务、修理和其他服务业"),
    P("教育"),
    Q("卫生和社会工作"),
    R("文化、体育和娱乐业"),
    S("公共管理、社会保障和社会组织"),
    T("国际组织");


    private final String value;

    public String getValue() {
        return value;
    }

    IndustryCodeDO(String value) {
        this.value = value;
    }

    public static String getValueByNameStr( String name ) {
        if( StringUtils.isBlank(name) ) {
            return  "";
        }
        for( IndustryCodeDO ut: IndustryCodeDO.values() ) {
            if( ut.name().equals(name) ) {
                return  ut.getValue();
            }
        }
        return "";
    }
}
