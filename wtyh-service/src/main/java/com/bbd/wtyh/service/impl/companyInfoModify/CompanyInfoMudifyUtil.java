package com.bbd.wtyh.service.impl.companyInfoModify;

import com.bbd.wtyh.constants.CompanyType;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.core.utils.redis.RedisUtil;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.enums.WangDaiRiskLevel;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.mapper.IndexDataMapper;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 
 * Created by YanWenyuan on 2017/7/17.
 */
@Component
public class CompanyInfoMudifyUtil extends BaseServiceImpl {

    @Value("${api.appkey}")
    private String appkey;

    @Autowired
    private CompanyLevelService companyLevelService; // 小额贷款、融资担保

    @Autowired
    private RiskCompanyService riskCompanyService; // 线下理财、交易场所
    @Autowired
    private IndexDataMapper indexDataMapper;

    @Autowired
    private PrepaidCompanyStaticService prepaidCompanyStaticService; // 预付卡

    @Autowired
    private ExchangeCompanyService exchangeCompanyService;

    @Autowired
    private CompanyStatusChangeService companyStatusChangeService;// 企业状态变化

    @Autowired
    private FinanceLeaseService financeLeaseService; // 融资租赁

    @Autowired
    private CompanyInfoModifyMapper companyInfoModifyMapper;

    @Autowired
    private CompanyInfoQueryUtil companyInfoQueryUtil;

    private RecordInfo addCompanyModify(ModifyData modifyData, CompanyInfo companyInfo, boolean isInsert) {
        RecordInfo recordInfo = new RecordInfo();
        recordInfo.setCompanyId(companyInfo.getCompanyId());
        recordInfo.setName(companyInfo.getName());

        String strAfterIndustry = modifyData.getIndustry();

        recordInfo.setBeforeIndustry(companyInfo.getIndustry());
        recordInfo.setAfterIndustry(strAfterIndustry == null ? null : Byte.valueOf(strAfterIndustry));
        recordInfo.setPlatName(companyInfo.getPlatName());

        // 前 风险等级

        recordInfo.setBeforeLevel(companyInfo.getCurrentLevel());
        // 网贷特殊处理，转为中文存储。与AfterLevel对应
        if (isP2PLending(companyInfo.getIndustry())) {
            Integer levelNum = NumberUtils.toInt(companyInfo.getCurrentLevel(), -1);
            recordInfo.setBeforeLevel(WangDaiRiskLevel.getRiskDesc(levelNum));
        }

        recordInfo.setBeforeOutLevel(companyInfo.getOutLevel());
        recordInfo.setBeforeInnnerLevel(companyInfo.getInnerLevel());
        recordInfo.setBeforeLiveLevel(companyInfo.getLiveLevel());
        // 后 风险等级
        recordInfo.setAfterLevel(modifyData.getLevel());
        recordInfo.setAfterOutLevel(modifyData.getOutLevel());
        recordInfo.setAfterInnnerLevel(modifyData.getInnnerLevel());
        recordInfo.setAfterLiveLevel(modifyData.getLiveLevel());

        if (isInsert) {
            companyInfoModifyMapper.recordModify(recordInfo);
        }
        return recordInfo;
    }

    private boolean isP2PLending(Object type) {
        Integer typeNum = byteToInt(type);
        return CompanyType.TYPE_P2P_1.type().equals(typeNum);
    }

    private Integer byteToInt(Object type) {
        if (type == null) {
            return null;
        }
        Integer typeNum = null;
        if (type.getClass().equals(Byte.class) || type.getClass().equals(byte.class)) {
            Byte tmp = (Byte) type;
            typeNum = tmp.intValue();
        }
        if (type.getClass().equals(Integer.class) || type.getClass().equals(int.class)) {
            typeNum = (Integer) type;
        }
        return typeNum;
    }

    /**
     * 记录变更
     *
     * @param companyInfo
     */
    private RecordInfo recordModify(ModifyData modifyData, CompanyInfo companyInfo) {
        return addCompanyModify(modifyData, companyInfo, true);
    }

    /**
     * 记录变更-不需要记录到企业变更表
     *
     * @param companyInfo
     */
    public RecordInfo recordModifyForTask(ModifyData modifyData, CompanyInfo companyInfo) {
        return addCompanyModify(modifyData, companyInfo, false);
    }

    /**
     * 修改行业
     *
     * @throws Exception
     */
    private void modifyIndustry(RecordInfo recordInfo) {

        // 是否修改行业 或者 行业是否变化
        if (recordInfo == null || StringUtils.isEmpty(recordInfo.getAfterIndustry())
                || recordInfo.getAfterIndustry().equals(recordInfo.getBeforeIndustry())) {
            return;
        }
        // 记录企业状态变化-放在修改之前，因为要记录修改前的类型
        companyStatusChangeService.companyStatusChange(false, recordInfo.getName(), recordInfo.getAfterIndustry());
        // 修改company的行业类型
        riskCompanyService.modifyIndustry(recordInfo.getName(), String.valueOf(recordInfo.getAfterIndustry()));

        // 线下理财
        if (CompanyInfo.TYPE_XXLC_4 == recordInfo.getBeforeIndustry()) {
            // delete index_data
            indexDataMapper.deleteByCompanyName(recordInfo);
        }

        // 预付卡
        if (CompanyInfo.TYPE_YFK_11 == recordInfo.getBeforeIndustry()) {
            // delete index_data
            prepaidCompanyStaticService.deleteByCompanyId(recordInfo);
        }

        // 交易场所
        if (CompanyInfo.TYPE_JYS_9 == recordInfo.getBeforeIndustry()) {
            // delete index_data
            exchangeCompanyService.deleteByCompanyId(recordInfo);
        }

        // 小额贷款、融资担保
        if ((CompanyInfo.TYPE_XD_2 == recordInfo.getBeforeIndustry() || CompanyInfo.TYPE_RZDB_3 == recordInfo.getBeforeIndustry())
                && !(CompanyInfo.TYPE_XD_2 == recordInfo.getAfterIndustry() || CompanyInfo.TYPE_RZDB_3 == recordInfo.getAfterIndustry())) {
            // delete index_data
            companyLevelService.deleteByCompanyId(recordInfo);
        }
    }

    /**
     * 修改行业-不需要记录到状态变化监测表
     *
     * @throws Exception
     */
    private void modifyIndustryForTask(RecordInfo recordInfo) {

        // 是否修改行业 或者 行业是否变化
        if (StringUtils.isEmpty(recordInfo.getAfterIndustry())
                || Objects.equals(recordInfo.getBeforeIndustry(), recordInfo.getAfterIndustry())) {
            return;
        }
        // 修改company的行业类型
        riskCompanyService.modifyIndustry(recordInfo.getName(), String.valueOf(recordInfo.getAfterIndustry()));

        // 线下理财
        if (CompanyInfo.TYPE_XXLC_4 == recordInfo.getBeforeIndustry()) {
            // delete index_data
            indexDataMapper.deleteByCompanyName(recordInfo);
        }

        // 预付卡
        if (CompanyInfo.TYPE_YFK_11 == recordInfo.getBeforeIndustry()) {
            // delete index_data
            prepaidCompanyStaticService.deleteByCompanyId(recordInfo);
        }

        // 交易场所
        if (CompanyInfo.TYPE_JYS_9 == recordInfo.getBeforeIndustry()) {
            // delete index_data
            exchangeCompanyService.deleteByCompanyId(recordInfo);
        }

        // 小额贷款、融资担保
        if ((CompanyInfo.TYPE_XD_2 == recordInfo.getBeforeIndustry() || CompanyInfo.TYPE_RZDB_3 == recordInfo.getBeforeIndustry())
                && !(CompanyInfo.TYPE_XD_2 == recordInfo.getAfterIndustry() || CompanyInfo.TYPE_RZDB_3 == recordInfo.getAfterIndustry())) {
            // delete index_data
            companyLevelService.deleteByCompanyId(recordInfo);
        }
    }

    /**
     * 网络借贷
     *
     * @param modifyData
     */
    public void modifyWangdai2Other(ModifyData modifyData) throws Exception {
        RecordInfo recordInfo = modifyRiskLevel(modifyData, null, null);
        // 修改行业
        modifyIndustry(recordInfo);
        clearRedisCache("BASE_INFO_BBD_DATA" + modifyData.getName(), "wtyh:pToPMonitor:platRank", "wtyh:P2PImage:platFormStatus");
    }

    public void clearRedisCache(String... patterns) {
        Set<String> keys = new HashSet<>();
        for (String pattern : patterns) {
            keys.addAll(RedisUtil.keys(pattern + "*"));
        }
        if (keys.isEmpty()) {
            return;
        }
        RedisUtil.del(keys.toArray(new String[0]));
    }

    /**
     * 留给定时任务-企业与网贷平台对照表更新 and 众筹数更新-更新企业类型专用
     *
     * @param modifyData
     */
    public void modifyForTask(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        if (null == companyInfo) {
            return;
        }
        RecordInfo recordInfo = recordModifyForTask(modifyData, companyInfo);
        // 修改风险等级
        // 因修改后皆为网贷，故不做风险等级修改--暂时还是清空风险等级
        // 其他行业转网贷，需要清空原来的风险等级；其他行业转众筹，因为众筹本身没有风险等级，也需要清空
        riskCompanyService.modifyLevel(recordInfo.getName(), recordInfo.getAfterLevel());
        // 修改行业
        modifyIndustryForTask(recordInfo);
    }

    public RecordInfo modifyRiskLevel(ModifyData modifyData, CompanyInfo companyInfo, RecordInfo recordInfo) {
        if (companyInfo == null) {
            companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        }
        if (companyInfo == null) {
            return null;
        }
        if (recordInfo == null) {
            recordInfo = recordModify(modifyData, companyInfo);
        }

        Integer afterIndustry = recordInfo.getAfterIndustry() == null ? null : recordInfo.getAfterIndustry().intValue();
        // 修改风险等级
        if (CompanyType.TYPE_P2P_1.type().equals(afterIndustry)) { // 网络借贷

            // 产品需求将网贷的风险等级一起修改
            Integer type = WangDaiRiskLevel.getRiskType(recordInfo.getAfterLevel());
            riskCompanyService.modifyLevel(recordInfo.getName(), type == null ? null : type.toString());

            // 小额贷款 融资担保
        } else if (CompanyType.TYPE_XD_2.type().equals(afterIndustry) || CompanyType.TYPE_RZDB_3.type().equals(afterIndustry)) {
            companyLevelService.modifyLoadLevel(recordInfo);
            // 小贷，融担的风险等级在 company_level 表，需要将company中的风险等级清空
            clearCompanyRiskLevel(companyInfo.getCompanyId());
        } else if (CompanyType.TYPE_XXLC_4.type().equals(afterIndustry)) { // 线下理财
            riskCompanyService.modifyOffLineLevel(recordInfo);

        } else if (CompanyType.TYPE_JYS_9.type().equals(afterIndustry)) { // 交易场所
            riskCompanyService.modifyOffLineLevel(recordInfo);
            exchangeCompanyService.addExchange(recordInfo);

        } else if (CompanyType.TYPE_RZZL_13.type().equals(afterIndustry)) { // 融资租赁
            //融资租赁 的风险等级在 finance_lease_risk，需要将company中的风险等级清空
            clearCompanyRiskLevel(companyInfo.getCompanyId());
            if (!financeLeaseService.isExistFinanceLease(recordInfo)) {
                financeLeaseService.addFinanceLease(recordInfo);
            } else {
                financeLeaseService.modifyFinanceLease(recordInfo);
            }

        } else if (CompanyType.TYPE_YFK_11.type().equals(afterIndustry)) { // 预付卡
            //预付卡 的风险等级在 company_analysis_result，需要将company中的风险等级清空
            clearCompanyRiskLevel(companyInfo.getCompanyId());
            prepaidCompanyStaticService.deleteByCompanyId(recordInfo);
            prepaidCompanyStaticService.addPerpaycard(recordInfo);

        } else if (CompanyType.TYPE_SMJJ_5.type().equals(afterIndustry) // 私募基金
                || CompanyType.TYPE_ZC_6.type().equals(afterIndustry) // 众筹
                || CompanyType.TYPE_SYBL_10.type().equals(afterIndustry) // 商业保理
                || CompanyType.TYPE_DD_12.type().equals(afterIndustry)) { // 典当

            // 这几种行业没有风险值，故从别的行业转过来的时候需要将风险值设空
            clearCompanyRiskLevel(companyInfo.getCompanyId());
        }

        return recordInfo;
    }

    private void clearCompanyRiskLevel(Integer companyId) {
        executeCUD("UPDATE company SET previous_risk_level = null, risk_level = null WHERE company_id = ?", companyId);
    }

    /**
     * 小额贷款、融资担保
     *
     * @param modifyData
     */
    public void modifyLoad2Other(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyLevelService.getLoanOrGuaranteeByCompanyName(modifyData.getName());

        RecordInfo recordInfo = modifyRiskLevel(modifyData, companyInfo, null);
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 线下理财
     *
     * @param modifyData
     * @return
     */
    public void modifyOffLine2Other(ModifyData modifyData) throws Exception {
        RecordInfo recordInfo = modifyRiskLevel(modifyData, null, null);
        // 修改行业
        modifyIndustry(recordInfo);
        clearRedisCache("YED_", "RK_", "REDIS_KEY_RELATION_URL");
    }

    /**
     * 交易场所
     *
     * @param modifyData
     * @return
     */
    public void modifyExchange2Other(ModifyData modifyData) {
        RecordInfo recordInfo = modifyRiskLevel(modifyData, null, null);// 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 融资租赁
     *
     * @param modifyData
     */
    public void modifyFinanceLease2Other(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoQueryUtil.getTenancy(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);

        // 判断风险等级是否发生变化
        if (!Objects.equals(recordInfo.getBeforeLevel(), recordInfo.getAfterLevel())
                || !Objects.equals(recordInfo.getBeforeOutLevel(), recordInfo.getAfterOutLevel())
                || Objects.equals(recordInfo.getBeforeInnnerLevel(), recordInfo.getAfterInnnerLevel())
                || Objects.equals(recordInfo.getBeforeLiveLevel(), recordInfo.getAfterLiveLevel())) {

            modifyRiskLevel(modifyData, companyInfo, recordInfo);
        }
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 预付卡
     *
     * @param modifyData
     */
    public void modifyPerpaycard2Other(ModifyData modifyData) {
        CompanyInfo companyInfo = prepaidCompanyStaticService.getPerpaycardByCompanyName(modifyData.getName());
        RecordInfo recordInfo = modifyRiskLevel(modifyData, companyInfo, null);// 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 私募基金
     *
     * @param modifyData
     * @throws Exception
     */
    public void modifyPrivateFund2Other(ModifyData modifyData) throws Exception {
        RecordInfo recordInfo = modifyRiskLevel(modifyData, null, null);// 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 众筹
     *
     * @param modifyData
     */
    public void modifyCrowdfunding2Other(ModifyData modifyData) throws Exception {
        RecordInfo recordInfo = modifyRiskLevel(modifyData, null, null);// 修改行业
        // 修改行业
        modifyIndustry(recordInfo);

    }

    /**
     * 典当
     *
     * @param modifyData
     */
    public void modifyPawn2Other(ModifyData modifyData) throws Exception {
        RecordInfo recordInfo = modifyRiskLevel(modifyData, null, null);// 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 商业保理
     *
     * @param modifyData
     */
    public void modifyBizInsurance2Ohter(ModifyData modifyData) throws Exception {
        RecordInfo recordInfo = modifyRiskLevel(modifyData, null, null);// 修改行业
        modifyIndustry(recordInfo);
    }
}
