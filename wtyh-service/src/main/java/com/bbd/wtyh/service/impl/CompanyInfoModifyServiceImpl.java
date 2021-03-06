package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.mapper.CompanyAnalysisResultMapper;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoMudifyUtil;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoQueryUtil;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private CompanyAnalysisResultMapper companyAnalysisResultMapper;

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    private static final String RISK = String.valueOf(CompanyAnalysisResult.RISK.getType());
    @Override
    public CompanyInfo queryCompany(String name) {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(name);
        if (companyInfo == null) {
            return null;
        }
        Byte industry = companyInfo.getIndustry();
        if (industry == null) {
            return companyInfo;
        }

        switch (industry) {

        case CompanyInfo.TYPE_P2P_1:// ????????????
            return companyInfoQueryUtil.getWangdaiInfo(name);

        case CompanyInfo.TYPE_XD_2:// ????????????
            return companyInfoQueryUtil.getLoan(name);

        case CompanyInfo.TYPE_RZDB_3:// ????????????
            return companyInfoQueryUtil.getGuarantee(name);

        case CompanyInfo.TYPE_XXLC_4:// ????????????
            return companyInfoQueryUtil.getOffLineFinance(name);

        case CompanyInfo.TYPE_JYS_9:// ????????????
            return companyInfoQueryUtil.getTradeMarket(name);

        case CompanyInfo.TYPE_YFK_11:// ?????????
            return companyInfoQueryUtil.getPerpaycard(name);

        case CompanyInfo.TYPE_RZZL_13:// ????????????
            return companyInfoQueryUtil.getTenancy(name);

        case CompanyInfo.TYPE_SMJJ_5:// ????????????
            return companyInfoQueryUtil.getPrivateFund(name);

        case CompanyInfo.TYPE_ZC_6: // ??????
            return companyInfoQueryUtil.getCrowdingFund(name);

        case CompanyInfo.TYPE_DD_12: // ??????
            return companyInfoQueryUtil.getPawn(name);

        case CompanyInfo.TYPE_SYBL_10:// ????????????
            return companyInfoQueryUtil.getBusinessInsurance(name);

        case CompanyInfo.TYPE_JR_7:// ??????
            return companyInfoQueryUtil.getOthers(name,CompanyInfo.TYPE_JR_7);

        case CompanyInfo.TYPE_QT_8:// ??????
            return companyInfoQueryUtil.getOthers(name,CompanyInfo.TYPE_QT_8);

        case CompanyInfo.TYPE_WT_30:// ??????????????????
            return companyInfoQueryUtil.getOthers(name,CompanyInfo.TYPE_WT_30);

        case CompanyInfo.TYPE_WT_31:// ????????????
            return companyInfoQueryUtil.getOthers(name,CompanyInfo.TYPE_WT_31);

        case CompanyInfo.TYPE_WT_32:// ????????????
            return companyInfoQueryUtil.getOthers(name,CompanyInfo.TYPE_WT_32);

        case CompanyInfo.TYPE_WT_33:// ????????????
            return companyInfoQueryUtil.getOthers(name,CompanyInfo.TYPE_WT_33);

        case CompanyInfo.TYPE_WT_34:// ???????????????
            return companyInfoQueryUtil.getOthers(name,CompanyInfo.TYPE_WT_34);

        case CompanyInfo.TYPE_WT_35:// ??????????????????
            return companyInfoQueryUtil.getOthers(name,CompanyInfo.TYPE_WT_35);
        default:
            return null;
        }
    }

    /**
     * ???????????? ??????
     *
     * @param modifyData
     * @return
     */
    @Override
    public void modify(ModifyData modifyData, String modifyBy) throws Exception {
        // ???''???????????????????????????????????????????????????SQL?????????
        if (StringUtils.isEmpty(modifyData.getOutLevel())) {
            modifyData.setOutLevel(null);
        }
        if (StringUtils.isEmpty(modifyData.getInnerLevel())) {
            modifyData.setInnerLevel(null);
        }
        if (StringUtils.isEmpty(modifyData.getLiveLevel())) {
            modifyData.setLiveLevel(null);
        }
        if (StringUtils.isEmpty(modifyData.getLevel())) {
            modifyData.setLevel(null);
        }

        RiskChgCoDo data = coRiskChgService.generateNewRecord(modifyData, modifyBy, RiskChgCoSource.MANUAL_MODIFY);

        CompanyInfo ci = companyInfoModifyMapper.queryCompany(modifyData.getName());
        Byte industry = ci.getIndustry();

        if (industry == null) {
            industry = -1;
        }

        switch (industry) {

        case -1:
            companyInfoMudifyUtil.null2Ohter(modifyData);
            break;

        case CompanyInfo.TYPE_P2P_1:// ????????????
            companyInfoMudifyUtil.modifyWangdai2Other(modifyData);
            break;

        case CompanyInfo.TYPE_XD_2:// ????????????
            companyInfoMudifyUtil.modifyLoad2Other(modifyData);
            break;

        case CompanyInfo.TYPE_RZDB_3:// ????????????
            companyInfoMudifyUtil.modifyLoad2Other(modifyData);
            break;

        case CompanyInfo.TYPE_XXLC_4:// ????????????
            companyInfoMudifyUtil.modifyOffLine2Other(modifyData);
            break;

        case CompanyInfo.TYPE_JYS_9:// ????????????
            companyInfoMudifyUtil.modifyExchange2Other(modifyData);
            break;

        case CompanyInfo.TYPE_YFK_11:// ?????????
            companyInfoMudifyUtil.modifyPerpaycard2Other(modifyData);
            break;

        case CompanyInfo.TYPE_RZZL_13:// ????????????
            companyInfoMudifyUtil.modifyFinanceLease2Other(modifyData);
            break;

        case CompanyInfo.TYPE_SMJJ_5:// ????????????
            companyInfoMudifyUtil.modifyPrivateFund2Other(modifyData);
            break;

        case CompanyInfo.TYPE_ZC_6: // ??????
            companyInfoMudifyUtil.modifyCrowdfunding2Other(modifyData);
            break;

        case CompanyInfo.TYPE_DD_12: // ??????
            companyInfoMudifyUtil.modifyPawn2Other(modifyData);
            break;

        case CompanyInfo.TYPE_SYBL_10:// ????????????
            companyInfoMudifyUtil.modifyBizInsurance2Ohter(modifyData);
            break;
        case CompanyInfo.TYPE_JR_7:// ??????
            companyInfoMudifyUtil.newType2Ohter(modifyData);
            break;
        case CompanyInfo.TYPE_QT_8:// ??????
            companyInfoMudifyUtil.newType2Ohter(modifyData);
            break;
        case CompanyInfo.TYPE_WT_30:// ??????????????????
            companyInfoMudifyUtil.newType2Ohter(modifyData);
            break;
        case CompanyInfo.TYPE_WT_31:// ????????????
            companyInfoMudifyUtil.newType2Ohter(modifyData);
            break;
        case CompanyInfo.TYPE_WT_32:// ????????????
            companyInfoMudifyUtil.newType2Ohter(modifyData);
            break;
        case CompanyInfo.TYPE_WT_33:// ????????????
            companyInfoMudifyUtil.newType2Ohter(modifyData);
            break;
        case CompanyInfo.TYPE_WT_34:// ???????????????
            companyInfoMudifyUtil.newType2Ohter(modifyData);
            break;
        case CompanyInfo.TYPE_WT_35:// ??????????????????
            companyInfoMudifyUtil.newType2Ohter(modifyData);
            break;
    }

        if (data != null) {
            coRiskChgService.insert(data);
        }
        if (RISK.equals(modifyData.getLevel())||"????????????".equals(modifyData.getLevel())) {
//            String exposure_date = "2017-12-05";
            Date sqlDate = new java.sql.Date(new Date().getTime());
            CompanyAnalysisResultDO cDO = this.companyAnalysisResultMapper.selectByPrimaryKey(ci.getCompanyId());
            if (cDO == null) {// ??????????????????????????????
                CompanyAnalysisResultDO cDO2 = new CompanyAnalysisResultDO();
                cDO2.setCompanyId(ci.getCompanyId());
                cDO2.setAnalysisResult(new Byte("1"));
                cDO2.setExposureDate(modifyData.getExposureDate());
                cDO2.setCreateBy("companyUpdate");
                cDO2.setCreateDate(sqlDate);
                baseService.insert(cDO2);
            } else {
                cDO.setCompanyId(ci.getCompanyId());
                cDO.setAnalysisResult(new Byte("1"));
                cDO.setExposureDate(modifyData.getExposureDate());
                cDO.setUpdateBy("companyUpdate");
                cDO.setUpdateDate(sqlDate);
                baseService.update(cDO);
                }
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

    @Override
    public CompanyAnalysisResultDO queryCompanyAnalysisResultDO(Integer companyId) {
        return companyAnalysisResultMapper.selectByPrimaryKey(companyId);
    }

}
