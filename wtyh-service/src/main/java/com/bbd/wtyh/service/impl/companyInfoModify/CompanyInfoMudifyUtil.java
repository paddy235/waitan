package com.bbd.wtyh.service.impl.companyInfoModify;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by YanWenyuan on 2017/7/17.
 */
@Component
public class CompanyInfoMudifyUtil {
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
     * 修改 company 修改风险等级
     * @param name
     * @param wangdaiModify
     */
    public void modifyLevel(String name, WangdaiModify wangdaiModify) {
        riskCompanyService.modifyLevel(name, wangdaiModify.getAfterLevel());
    }

    /**
     * 网络借贷 -记录修改日志
     * @param wangdaiModify
     */
    public void recordWangdai(WangdaiModify wangdaiModify) {
        p2PImageService.recordWangdai(wangdaiModify);
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
