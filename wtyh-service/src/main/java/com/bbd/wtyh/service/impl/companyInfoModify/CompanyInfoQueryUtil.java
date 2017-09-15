package com.bbd.wtyh.service.impl.companyInfoModify;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by YanWenyuan on 2017/7/17.
 */
@Component
public class CompanyInfoQueryUtil {

    @Autowired
    private P2PImageService p2PImageService; // 网络借贷

    @Autowired
    private CompanyLevelService companyLevelService; // 小额贷款、融资担保

    @Autowired
    private RiskCompanyService riskCompanyService; // 线下理财、交易场所

    @Autowired
    private PrepaidCompanyStaticService prepaidCompanyStaticService; // 预付卡

    @Autowired
    private FinanceLeaseService financeLeaseService; // 融资租赁

    @Autowired
    private CompanyInfoModifyMapper companyInfoModifyMapper;

    /**
     * 网络借贷
     *
     * @param name
     *            公司名称
     * @return
     */
    public CompanyInfo getWangdaiInfo(String name) {
        // 1. 获取“公司名 与 平台名” 的对应关系
        PlatListDO platListDO = p2PImageService.getWangdaiCompanyList(name);
        // 2. 获取“平台名”对应的评级信息
        Map<String, Object> platFormStatus = null;
        if (platListDO != null) {
            platFormStatus = p2PImageService.platFormStatus(platListDO.getPlat_name());
        }

        // 3. 返回数据
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(name);
        if(null==companyInfo){
            return null;
        }
        companyInfo.setIndustry(CompanyInfo.TYPE_P2P_1); // 行业
        if (platFormStatus != null) {
            companyInfo.setPlatName(obj2String(platFormStatus.get("platname"))); // 平台名称
            companyInfo.setCurrentLevel(obj2String(platFormStatus.get("score"))); // 转换后的
            companyInfo.setOriginalStatus(obj2String(platFormStatus.get("status")));
        } else {
            companyInfo.setPlatName(""); // 平台名称
            companyInfo.setCurrentLevel(""); // 转换后的 评分：A B C D
            companyInfo.setOriginalStatus(""); // 网贷之家API原始评分："优良";"一般关注";"重点关注";"问题及停业平台";
        }
        return companyInfo;
    }

    private String obj2String(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /**
     * 小额贷款
     *
     * @param name
     *            公司名称
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
        if (StringUtils.isEmpty(companyInfo.getCurrentLevel())) {
            companyInfo.setCurrentLevel("4"); // 正常
        }
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
        List<CompanyInfo> companyInfos = financeLeaseService.getTenancy(name);
        if (null == companyInfos) {
            return null;
        }
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setName(name);
        companyInfo.setCurrentLevel("1"); // 正常
        companyInfo.setIndustry(CompanyInfo.TYPE_RZZL_13);
        if (!CollectionUtils.isEmpty(companyInfos)) {
            for (CompanyInfo temp : companyInfos) {
                if (temp.getCurrentLevel() != null && temp.getCurrentLevel().equals("0")) {
                    companyInfo.setCurrentLevel("0"); // 潜在
                }
            }
        }
        return companyInfo;
    }

    /**
     * 私募基金
     *
     * @param name
     * @return
     */
    public CompanyInfo getPrivateFund(String name) {
        CompanyInfo companyInfo = riskCompanyService.getOffLineFinanceByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_SMJJ_5);
        return companyInfo;
    }

    /**
     * 众筹
     *
     * @param name
     * @return
     */
    public CompanyInfo getCrowdingFund(String name) {
        CompanyInfo companyInfo = riskCompanyService.getOffLineFinanceByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_ZC_6);
        return companyInfo;
    }

    /**
     * 典当
     *
     * @param name
     * @return
     */
    public CompanyInfo getPawn(String name) {
        CompanyInfo companyInfo = riskCompanyService.getOffLineFinanceByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_DD_12);
        return companyInfo;
    }

    /**
     * 商业保理
     *
     * @param name
     * @return
     */
    public CompanyInfo getBusinessInsurance(String name) {
        CompanyInfo companyInfo = riskCompanyService.getOffLineFinanceByCompanyName(name);
        companyInfo.setIndustry(CompanyInfo.TYPE_SYBL_10);
        return companyInfo;
    }
}
