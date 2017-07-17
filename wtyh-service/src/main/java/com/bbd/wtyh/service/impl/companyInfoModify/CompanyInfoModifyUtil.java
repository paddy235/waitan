package com.bbd.wtyh.service.impl.companyInfoModify;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.service.CompanyLevelService;
import com.bbd.wtyh.service.ExchangeCompanyService;
import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.service.RiskCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by YanWenyuan on 2017/7/17.
 */
@Component
public class CompanyInfoModifyUtil {
    @Autowired
    private P2PImageService p2PImageService;    // 网络借贷

    @Autowired
    private CompanyLevelService companyLevelService;    // 小额贷款、融资担保

    @Autowired
    private RiskCompanyService riskCompanyService;  // 线下理财

    @Autowired
    private ExchangeCompanyService exchangeCompanyService;  // 交易场所

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
        return companyInfo;
    }

    /**
     * 融资担保
     * @param name
     * @return
     */
    public CompanyInfo getGuarantee(String name) {
        CompanyInfo companyInfo = companyLevelService.getLoanOrGuaranteeByCompanyName(name);
        return companyInfo;
    }

    /**
     * 线下理财
     * @param name
     * @return
     */
    public CompanyInfo getOffLineFinance(String name) {
        return riskCompanyService.getOffLineFinanceByCompanyName(name);
    }

    /**
     * 交易场所
     * @param name
     * @return
     */
    public CompanyInfo getTradeMarket(String name) {
        return riskCompanyService.getOffLineFinanceByCompanyName(name);
    }
}
