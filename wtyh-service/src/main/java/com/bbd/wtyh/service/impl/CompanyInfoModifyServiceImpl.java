package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoMudifyUtil;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoQueryUtil;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by YanWenyuan on 2017/7/14.
 */
@Service("companyInfoModifyService")
public class CompanyInfoModifyServiceImpl implements CompanyInfoModifyService {

    @Autowired
    private CompanyInfoModifyMapper companyInfoModifyMapper;

    @Autowired
    private CompanyInfoQueryUtil companyInfoQueryUtil;

    @Autowired
    private CompanyInfoMudifyUtil companyInfoMudifyUtil;

    @Autowired
    private CoRiskChgService coRiskChgService;

    @Override
    public List<String> autoComplete(String q) {
        return companyInfoModifyMapper.autoComplete(q);
    }

    @Override
    public CompanyInfo queryCompany(String name) {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(name);
        if (companyInfo == null) {
            return null;
        }
        byte industry = companyInfoModifyMapper.queryCompany(name).getIndustry();

        switch (industry) {

        case CompanyInfo.TYPE_P2P_1:// 网络借贷
            return companyInfoQueryUtil.getWangdaiInfo(name);

        case CompanyInfo.TYPE_XD_2:// 小额贷款
            return companyInfoQueryUtil.getLoan(name);

        case CompanyInfo.TYPE_RZDB_3:// 融资担保
            return companyInfoQueryUtil.getGuarantee(name);

        case CompanyInfo.TYPE_XXLC_4:// 线下理财
            return companyInfoQueryUtil.getOffLineFinance(name);

        case CompanyInfo.TYPE_JYS_9:// 交易场所
            return companyInfoQueryUtil.getTradeMarket(name);

        case CompanyInfo.TYPE_YFK_11:// 预付卡
            return companyInfoQueryUtil.getPerpaycard(name);

        case CompanyInfo.TYPE_RZZL_13:// 融资租赁
            return companyInfoQueryUtil.getTenancy(name);

        case CompanyInfo.TYPE_SMJJ_5:// 私募基金
            return companyInfoQueryUtil.getPrivateFund(name);

        case CompanyInfo.TYPE_ZC_6: // 众筹
            return companyInfoQueryUtil.getCrowdingFund(name);

        case CompanyInfo.TYPE_DD_12: // 典当
            return companyInfoQueryUtil.getPawn(name);

        case CompanyInfo.TYPE_SYBL_10:// 商业保理
            return companyInfoQueryUtil.getBusinessInsurance(name);
        default:
            return null;
        }
    }

    /**
     * 风险等级 修改
     *
     * @param modifyData
     * @return
     */
    @Override
    public void modify(ModifyData modifyData, String modifyBy) throws Exception {
        // 以''空字串的形式更新小额贷款和融资担保SQL会报错
        if (StringUtils.isEmpty(modifyData.getOutLevel())) {
            modifyData.setOutLevel(null);
        }
        if (StringUtils.isEmpty(modifyData.getInnnerLevel())) {
            modifyData.setInnnerLevel(null);
        }
        if (StringUtils.isEmpty(modifyData.getLiveLevel())) {
            modifyData.setLiveLevel(null);
        }
        if (StringUtils.isEmpty(modifyData.getLevel())) {
            modifyData.setLevel(null);
        }

        RiskChgCoDo data = coRiskChgService.generateNewRecord(modifyData, modifyBy, RiskChgCoSource.MANUAL_MODIFY);

        byte industry = companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry();

        switch (industry) {

        case CompanyInfo.TYPE_P2P_1:// 网络借贷
            companyInfoMudifyUtil.modifyWangdai2Other(modifyData);
            break;

        case CompanyInfo.TYPE_XD_2:// 小额贷款
            companyInfoMudifyUtil.modifyLoad2Other(modifyData);
            break;

        case CompanyInfo.TYPE_RZDB_3:// 融资担保
            companyInfoMudifyUtil.modifyLoad2Other(modifyData);
            break;

        case CompanyInfo.TYPE_XXLC_4:// 线下理财
            companyInfoMudifyUtil.modifyOffLine2Other(modifyData);
            break;

        case CompanyInfo.TYPE_JYS_9:// 交易场所
            companyInfoMudifyUtil.modifyExchange2Other(modifyData);
            break;

        case CompanyInfo.TYPE_YFK_11:// 预付卡
            companyInfoMudifyUtil.modifyPerpaycard2Other(modifyData);
            break;

        case CompanyInfo.TYPE_RZZL_13:// 融资租赁
            companyInfoMudifyUtil.modifyFinanceLease2Other(modifyData);
            break;

        case CompanyInfo.TYPE_SMJJ_5:// 私募基金
            companyInfoMudifyUtil.modifyPrivateFund2Other(modifyData);
            break;

        case CompanyInfo.TYPE_ZC_6: // 众筹
            companyInfoMudifyUtil.modifyCrowdfunding2Other(modifyData);
            break;

        case CompanyInfo.TYPE_DD_12: // 典当
            companyInfoMudifyUtil.modifyPawn2Other(modifyData);
            break;

        case CompanyInfo.TYPE_SYBL_10:// 商业保理
            companyInfoMudifyUtil.modifyBizInsurance2Ohter(modifyData);
            break;
        }

        if (data != null) {
            coRiskChgService.insert(data);
        }
        companyInfoMudifyUtil.clearRedisCache("wtyh:realtimeMonitor:guangPu1");

    }

    @Override
    public Boolean isModify(String name) {
        List<String> names = companyInfoModifyMapper.queryModifyCompany(name);
        return !names.isEmpty();
    }

    @Override
    public Boolean isModifyByAfterRisk(String name) {
        List<String> names = companyInfoModifyMapper.queryModifyCompanyByAfterRisk(name);
        return !names.isEmpty();
    }

}
