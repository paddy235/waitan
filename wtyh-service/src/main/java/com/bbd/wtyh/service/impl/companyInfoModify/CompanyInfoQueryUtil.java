package com.bbd.wtyh.service.impl.companyInfoModify;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by YanWenyuan on 2017/7/17.
 */
@Component
public class CompanyInfoQueryUtil {
    @Autowired
    private P2PImageService p2PImageService;    // 网络借贷

    @Autowired
    private CompanyLevelService companyLevelService;    // 小额贷款、融资担保

    @Autowired
    private RiskCompanyService riskCompanyService;  // 线下理财、交易场所

    @Autowired
    private PrepaidCompanyStaticService prepaidCompanyStaticService; // 预付卡

    @Autowired
    private FinanceLeaseService financeLeaseService;    // 融资租赁


    /**
     * 网络借贷
     *
     * @param name 公司名称
     * @return
     */
    public CompanyInfo getWangdaiInfo(String name) {
        // 1. 获取“公司名 与 平台名” 的对应关系
        PlatListDO platListDO = p2PImageService.getWangdaiCompanyList(name);
        // 2. 获取“平台名”对应的评级信息
        Map<String, Object> platFormStatus = p2PImageService.platFormStatus(platListDO.getPlat_name());
        Map<String, Object> baseInfo = p2PImageService.baseInfo(platListDO.getPlat_name());
        // 3. 返回数据
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setName(String.valueOf(platFormStatus.get("companyName"))); // 公司名称
        companyInfo.setPlatName(String.valueOf(platFormStatus.get("platname")));    // 平台名称
        companyInfo.setLegalPerson(String.valueOf(baseInfo.get("legalPeople")));    // 法人
        companyInfo.setRegisteredCapital(String.valueOf(baseInfo.get("capital")));  // 注册资本
        companyInfo.setIndustry(CompanyInfo.TYPE_P2P_1);    // 行业
        companyInfo.setCurrentLevel(String.valueOf(platFormStatus.get("score")));   // 转换后的 评分：A B C D
        companyInfo.setOriginalStatus(String.valueOf(platFormStatus.get("status")));    // 网贷之家API原始评分："优良";"一般关注";"重点关注";"问题及停业平台";
        return companyInfo;
    }

    /**
     * 小额贷款
     *
     * @param name 公司名称
     * @return
     */
    public CompanyInfo getLoan(String name) {
        CompanyInfo companyInfo = companyLevelService.getLoanOrGuaranteeByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_XD_2);
        return companyInfo;
    }

    /**
     * 融资担保
     *
     * @param name
     * @return
     */
    public CompanyInfo getGuarantee(String name) {
        CompanyInfo companyInfo = companyLevelService.getLoanOrGuaranteeByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_RZDB_3);
        return companyInfo;
    }

    /**
     * 线下理财
     *
     * @param name
     * @return
     */
    public CompanyInfo getOffLineFinance(String name) {
        CompanyInfo companyInfo = riskCompanyService.getOffLineFinanceByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_XXLC_4);
        return companyInfo;
    }

    /**
     * 交易场所
     *
     * @param name
     * @return
     */
    public CompanyInfo getTradeMarket(String name) {
        CompanyInfo companyInfo = riskCompanyService.getOffLineFinanceByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_JYS_9);
        return companyInfo;
    }

    /**
     * 预付卡
     *
     * @param name
     * @return
     */
    public CompanyInfo getPerpaycard(String name) {
        CompanyInfo companyInfo = prepaidCompanyStaticService.getPerpaycardByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_YFK_11);
        return companyInfo;
    }

    /**
     * 融资租赁
     *
     * @param name
     * @return
     */
    public CompanyInfo getTenancy(String name) {
        CompanyInfo companyInfo = financeLeaseService.getTenancy(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_RZZL_13);
        return companyInfo;
    }
}
