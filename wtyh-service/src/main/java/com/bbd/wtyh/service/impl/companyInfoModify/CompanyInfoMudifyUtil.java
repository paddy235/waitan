package com.bbd.wtyh.service.impl.companyInfoModify;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.mapper.IndexDataMapper;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by YanWenyuan on 2017/7/17.
 */
@Component
public class CompanyInfoMudifyUtil {
    Logger logger = LoggerFactory.getLogger(CompanyInfoMudifyUtil.class);

    private static String TAG = "外滩线下理财企业";

    @Value("${api.appkey}")
    private String appkey;

    @Autowired
    private P2PImageService p2PImageService;    // 网络借贷

    @Autowired
    private CompanyLevelService companyLevelService;    // 小额贷款、融资担保

    @Autowired
    private RiskCompanyService riskCompanyService;  // 线下理财、交易场所
    @Autowired
    private IndexDataMapper indexDataMapper;

    @Autowired
    private PrepaidCompanyStaticService prepaidCompanyStaticService;    //  预付卡

    @Autowired
    private ExchangeCompanyService exchangeCompanyService;

    @Autowired
    private CompanyStatusChangeService companyStatusChangeService;//企业状态变化

    @Autowired
    private FinanceLeaseService financeLeaseService;    // 融资租赁

    @Autowired
    private CompanyInfoModifyMapper companyInfoModifyMapper;

    @Autowired
    private CompanyInfoQueryUtil companyInfoQueryUtil;

    /**
     * 记录变更
     *
     * @param companyInfo
     */
    public RecordInfo recordModify(ModifyData modifyData, CompanyInfo companyInfo) {
        RecordInfo recordInfo = new RecordInfo();
        recordInfo.setCompanyId(companyInfo.getCompanyId());
        recordInfo.setName(companyInfo.getName());
        recordInfo.setBeforeIndustry(companyInfo.getIndustry());
        recordInfo.setAfterIndustry(Byte.valueOf(modifyData.getIndustry()));
        // 前 风险等级
        if (CompanyInfo.TYPE_P2P_1 == Byte.valueOf(companyInfo.getIndustry())) {  // 网络借贷
            recordInfo.setPlatName(companyInfo.getPlatName());
        } else if (CompanyInfo.TYPE_XXLC_4 == Byte.valueOf(companyInfo.getIndustry())   // 线下理财
                || CompanyInfo.TYPE_JYS_9 == Byte.valueOf(companyInfo.getIndustry())    // 交易场所
                || CompanyInfo.TYPE_YFK_11 == Byte.valueOf(companyInfo.getIndustry())   // 预付卡
                || CompanyInfo.TYPE_RZZL_13 == Byte.valueOf(companyInfo.getIndustry())) { // 融资租赁
            recordInfo.setBeforeLevel(companyInfo.getCurrentLevel());
        } else if (CompanyInfo.TYPE_XD_2 == Byte.valueOf(companyInfo.getIndustry()) // 小额贷款
                || CompanyInfo.TYPE_RZDB_3 == Byte.valueOf(companyInfo.getIndustry())) {  // 融资担保
            recordInfo.setBeforeOutLevel(companyInfo.getOutLevel());
            recordInfo.setBeforeInnnerLevel(companyInfo.getInnnerLevel());
            recordInfo.setBeforeLiveLevel(companyInfo.getLiveLevel());
        }
        // 后 风险等级
        if (CompanyInfo.TYPE_P2P_1 == Byte.valueOf(modifyData.getIndustry())) {  // 网络借贷
            recordInfo.setPlatName(companyInfo.getPlatName());
        } else if (CompanyInfo.TYPE_XXLC_4 == Byte.valueOf(modifyData.getIndustry())   // 线下理财
                || CompanyInfo.TYPE_JYS_9 == Byte.valueOf(modifyData.getIndustry())    // 交易场所
                || CompanyInfo.TYPE_YFK_11 == Byte.valueOf(modifyData.getIndustry())   // 预付卡
                || CompanyInfo.TYPE_RZZL_13 == Byte.valueOf(modifyData.getIndustry())) { // 融资租赁
            recordInfo.setAfterLevel(modifyData.getLevel());
        } else if (CompanyInfo.TYPE_XD_2 == Byte.valueOf(modifyData.getIndustry()) // 小额贷款
                || CompanyInfo.TYPE_RZDB_3 == Byte.valueOf(modifyData.getIndustry())) {  // 融资担保
            recordInfo.setAfterOutLevel(modifyData.getOutLevel());
            recordInfo.setAfterInnnerLevel(modifyData.getInnnerLevel());
            recordInfo.setAfterLiveLevel(modifyData.getLiveLevel());
        } else if (CompanyInfo.TYPE_SMJJ_5 == Byte.valueOf(modifyData.getIndustry())   // 私募基金
                || CompanyInfo.TYPE_ZC_6 == Byte.valueOf(modifyData.getIndustry())    // 众筹
                || CompanyInfo.TYPE_SYBL_10 == Byte.valueOf(modifyData.getIndustry())   // 商业保理
                || CompanyInfo.TYPE_DD_12 == Byte.valueOf(modifyData.getIndustry())) { // 典当
            recordInfo.setAfterLevel(null);
        }
        companyInfoModifyMapper.recordModify(recordInfo);
        return recordInfo;
    }

    /**
     * 修改行业
     *
     * @throws Exception
     */
    private void modifyIndustry(RecordInfo recordInfo) {
        // 是否修改行业 或者  行业是否变化
        if (StringUtils.isEmpty(recordInfo.getAfterIndustry())
                || recordInfo.getBeforeIndustry() == recordInfo.getAfterIndustry()) {
            return;
        }
        // 记录企业状态变化-放在修改之前，因为要记录修改前的类型
        companyStatusChangeService.companyStatusChange(false, recordInfo.getName(), Byte.valueOf(recordInfo.getAfterIndustry()));
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
    public void modifyWangdai(ModifyData modifyData) throws Exception {
        CompanyInfo wangdai = companyInfoQueryUtil.getWangdaiInfo(modifyData.getName());
        WangdaiModify wangdaiModify = new WangdaiModify();
        wangdaiModify.setName(modifyData.getName());
        wangdaiModify.setPlatName(wangdai.getPlatName());
        wangdaiModify.setBeforeLevel(wangdai.getCurrentLevel());
        wangdaiModify.setAfterLevel(modifyData.getLevel());
        wangdaiModify.setBeforeIndustry(CompanyInfo.TYPE_P2P_1);
        wangdaiModify.setAfterIndustry(Byte.valueOf(modifyData.getIndustry()));
        // 记录行为
        p2PImageService.recordWangdai(wangdaiModify);
        // 修改行业
        RecordInfo recordInfo = new RecordInfo();
        recordInfo.setName(modifyData.getName());
        recordInfo.setPlatName(wangdai.getPlatName());
        recordInfo.setBeforeLevel(wangdai.getCurrentLevel());
        recordInfo.setAfterLevel(null);//从网贷转网贷，riskLevel无须修改(本身即应为空)
        recordInfo.setBeforeIndustry(CompanyInfo.TYPE_P2P_1);
        recordInfo.setAfterIndustry(Byte.valueOf(modifyData.getIndustry()));
        modifyIndustry(recordInfo);
        //清空风险等级
        riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());

    }

    /**
     * 留给定时任务-企业与网贷平台对照表更新 and 众筹数更新-更新企业类型专用
     *
     * @param modifyData
     */
    public void modifyTimingTask(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 修改风险等级
        // 因修改后皆为网贷，故不做风险等级修改--暂时还是清空风险等级
        riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 小额贷款、融资担保
     *
     * @param modifyData
     */
    public void modifyLoad(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 修改风险等级
        if (CompanyInfo.TYPE_P2P_1 == recordInfo.getAfterIndustry()) { // 网络借贷
            // do nothing, just record
        } else if (CompanyInfo.TYPE_XD_2 == recordInfo.getAfterIndustry()   // 小额贷款
                || CompanyInfo.TYPE_RZDB_3 == recordInfo.getAfterIndustry()) {  // 融资担保
            companyLevelService.modifyLoadLevel(recordInfo);
        } else if (CompanyInfo.TYPE_XXLC_4 == recordInfo.getAfterIndustry()) { // 线下理财
            riskCompanyService.modifyOffLineLevel(recordInfo);
            indexDataMapper.addOffLineLevel(recordInfo);
        } else if (CompanyInfo.TYPE_JYS_9 == recordInfo.getAfterIndustry()) {  // 交易场所
            riskCompanyService.modifyOffLineLevel(recordInfo);
            exchangeCompanyService.addExchange(recordInfo);
        } else if (CompanyInfo.TYPE_RZZL_13 == recordInfo.getAfterIndustry()) { // 融资租赁
            if (!financeLeaseService.isExistFinanceLease(recordInfo)) {
                financeLeaseService.addFinanceLease(recordInfo);
            } else {
                financeLeaseService.modifyFinanceLease(recordInfo);
            }
        } else if (CompanyInfo.TYPE_YFK_11 == recordInfo.getAfterIndustry()) {   // 预付卡
            prepaidCompanyStaticService.addPerpaycard(recordInfo);
        } else if (CompanyInfo.TYPE_SMJJ_5 == recordInfo.getAfterIndustry()   // 私募基金
                || CompanyInfo.TYPE_ZC_6 == recordInfo.getAfterIndustry()    // 众筹
                || CompanyInfo.TYPE_SYBL_10 == recordInfo.getAfterIndustry()   // 商业保理
                || CompanyInfo.TYPE_DD_12 == recordInfo.getAfterIndustry()) { // 典当
            //这几种行业没有风险值，故从别的行业转过来的时候需要将风险值设空
            riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());
        }
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 线下理财
     *
     * @param modifyData
     * @return
     */
    public void modifyOffLine(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 修改风险等级
        if (CompanyInfo.TYPE_P2P_1 == recordInfo.getAfterIndustry()) { // 网络借贷
            // do nothing, just record
        } else if (CompanyInfo.TYPE_XD_2 == recordInfo.getAfterIndustry()   // 小额贷款
                || CompanyInfo.TYPE_RZDB_3 == recordInfo.getAfterIndustry()) {  // 融资担保
            companyLevelService.addLoadLevel(recordInfo);
        } else if (CompanyInfo.TYPE_XXLC_4 == recordInfo.getAfterIndustry()) { // 线下理财
            riskCompanyService.modifyOffLineLevel(recordInfo);
        } else if (CompanyInfo.TYPE_JYS_9 == recordInfo.getAfterIndustry()) {  // 交易场所
            riskCompanyService.modifyOffLineLevel(recordInfo);
            exchangeCompanyService.addExchange(recordInfo);
        } else if (CompanyInfo.TYPE_RZZL_13 == recordInfo.getAfterIndustry()) { // 融资租赁
            if (!financeLeaseService.isExistFinanceLease(recordInfo)) {
                financeLeaseService.addFinanceLease(recordInfo);
            } else {
                financeLeaseService.modifyFinanceLease(recordInfo);
            }
        } else if (CompanyInfo.TYPE_YFK_11 == recordInfo.getAfterIndustry()) { // 预付卡
            prepaidCompanyStaticService.addPerpaycard(recordInfo);
        } else if (CompanyInfo.TYPE_SMJJ_5 == recordInfo.getAfterIndustry()   // 私募基金
                || CompanyInfo.TYPE_ZC_6 == recordInfo.getAfterIndustry()    // 众筹
                || CompanyInfo.TYPE_SYBL_10 == recordInfo.getAfterIndustry()   // 商业保理
                || CompanyInfo.TYPE_DD_12 == recordInfo.getAfterIndustry()) { // 典当
            //这几种行业没有风险值，故从别的行业转过来的时候需要将风险值设空
            riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());
        }
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 交易场所
     *
     * @param modifyData
     * @return
     */
    public void modifyExchange(ModifyData modifyData) {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 修改风险等级
        if (CompanyInfo.TYPE_P2P_1 == recordInfo.getAfterIndustry()) { // 网络借贷
            // do nothing, just record
        } else if (CompanyInfo.TYPE_XD_2 == recordInfo.getAfterIndustry()   // 小额贷款
                || CompanyInfo.TYPE_RZDB_3 == recordInfo.getAfterIndustry()) {  // 融资担保
            companyLevelService.addLoadLevel(recordInfo);
        } else if (CompanyInfo.TYPE_XXLC_4 == recordInfo.getAfterIndustry()) { // 线下理财
            riskCompanyService.modifyOffLineLevel(recordInfo);
            indexDataMapper.addOffLineLevel(recordInfo);
        } else if (CompanyInfo.TYPE_JYS_9 == recordInfo.getAfterIndustry()) {  // 交易场所
            riskCompanyService.modifyOffLineLevel(recordInfo);
        } else if (CompanyInfo.TYPE_RZZL_13 == recordInfo.getAfterIndustry()) { // 融资租赁
            if (!financeLeaseService.isExistFinanceLease(recordInfo)) {
                financeLeaseService.addFinanceLease(recordInfo);
            } else {
                financeLeaseService.modifyFinanceLease(recordInfo);
            }
        } else if (CompanyInfo.TYPE_YFK_11 == recordInfo.getAfterIndustry()) { // 预付卡
            prepaidCompanyStaticService.addPerpaycard(recordInfo);
        } else if (CompanyInfo.TYPE_SMJJ_5 == recordInfo.getAfterIndustry()   // 私募基金
                || CompanyInfo.TYPE_ZC_6 == recordInfo.getAfterIndustry()    // 众筹
                || CompanyInfo.TYPE_SYBL_10 == recordInfo.getAfterIndustry()   // 商业保理
                || CompanyInfo.TYPE_DD_12 == recordInfo.getAfterIndustry()) { // 典当
            //这几种行业没有风险值，故从别的行业转过来的时候需要将风险值设空
            riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());
        }
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 融资租赁
     *
     * @param modifyData
     */
    public void modifyFinanceLease(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 判断风险等级是否发生变化
        if ((recordInfo.getBeforeLevel() != recordInfo.getAfterLevel()
                || (recordInfo.getBeforeOutLevel() != recordInfo.getAfterOutLevel())
                || (recordInfo.getBeforeInnnerLevel() != recordInfo.getAfterInnnerLevel())
                || (recordInfo.getBeforeLiveLevel() != recordInfo.getAfterLiveLevel()))) {
            // 修改风险等级
            if (CompanyInfo.TYPE_P2P_1 == recordInfo.getAfterIndustry()) { // 网络借贷
                // do nothing, just record
            } else if (CompanyInfo.TYPE_XD_2 == recordInfo.getAfterIndustry()   // 小额贷款
                    || CompanyInfo.TYPE_RZDB_3 == recordInfo.getAfterIndustry()) {  // 融资担保
                companyLevelService.addLoadLevel(recordInfo);
            } else if (CompanyInfo.TYPE_XXLC_4 == recordInfo.getAfterIndustry()) { // 线下理财
                riskCompanyService.modifyOffLineLevel(recordInfo);
                indexDataMapper.addOffLineLevel(recordInfo);
            } else if (CompanyInfo.TYPE_JYS_9 == recordInfo.getAfterIndustry()) {  // 交易场所
                riskCompanyService.modifyOffLineLevel(recordInfo);
                exchangeCompanyService.addExchange(recordInfo);
            } else if (CompanyInfo.TYPE_RZZL_13 == recordInfo.getAfterIndustry()) { // 融资租赁
                if (!financeLeaseService.isExistFinanceLease(recordInfo)) {
                    financeLeaseService.addFinanceLease(recordInfo);
                } else {
                    financeLeaseService.modifyFinanceLease(recordInfo);
                }
            } else if (CompanyInfo.TYPE_YFK_11 == recordInfo.getAfterIndustry()) {// 预付卡
                prepaidCompanyStaticService.addPerpaycard(recordInfo);
            } else if (CompanyInfo.TYPE_SMJJ_5 == recordInfo.getAfterIndustry()   // 私募基金
                    || CompanyInfo.TYPE_ZC_6 == recordInfo.getAfterIndustry()    // 众筹
                    || CompanyInfo.TYPE_SYBL_10 == recordInfo.getAfterIndustry()   // 商业保理
                    || CompanyInfo.TYPE_DD_12 == recordInfo.getAfterIndustry()) { // 典当
                //这几种行业没有风险值，故从别的行业转过来的时候需要将风险值设空
                riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());
            }
        }
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 预付卡
     *
     * @param modifyData
     */
    public void modifyPerpaycard(ModifyData modifyData) {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 修改风险等级
        if (CompanyInfo.TYPE_P2P_1 == recordInfo.getAfterIndustry()) { // 网络借贷
            // do nothing, just record
        } else if (CompanyInfo.TYPE_XD_2 == recordInfo.getAfterIndustry()   // 小额贷款
                || CompanyInfo.TYPE_RZDB_3 == recordInfo.getAfterIndustry()) {  // 融资担保
            companyLevelService.addLoadLevel(recordInfo);
        } else if (CompanyInfo.TYPE_XXLC_4 == recordInfo.getAfterIndustry()) { // 线下理财
            riskCompanyService.modifyOffLineLevel(recordInfo);
            indexDataMapper.addOffLineLevel(recordInfo);
        } else if (CompanyInfo.TYPE_JYS_9 == recordInfo.getAfterIndustry()) {  // 交易场所
            riskCompanyService.modifyOffLineLevel(recordInfo);
            exchangeCompanyService.addExchange(recordInfo);
        } else if (CompanyInfo.TYPE_RZZL_13 == recordInfo.getAfterIndustry()) { // 融资租赁
            if (!financeLeaseService.isExistFinanceLease(recordInfo)) {
                financeLeaseService.addFinanceLease(recordInfo);
            } else {
                financeLeaseService.modifyFinanceLease(recordInfo);
            }
//            financeLeaseService.modifyFinanceLease(recordInfo);
        } else if (CompanyInfo.TYPE_YFK_11 == recordInfo.getAfterIndustry()) {// 预付卡
            prepaidCompanyStaticService.modifyPerpaycard(recordInfo);
        } else if (CompanyInfo.TYPE_SMJJ_5 == recordInfo.getAfterIndustry()   // 私募基金
                || CompanyInfo.TYPE_ZC_6 == recordInfo.getAfterIndustry()    // 众筹
                || CompanyInfo.TYPE_SYBL_10 == recordInfo.getAfterIndustry()   // 商业保理
                || CompanyInfo.TYPE_DD_12 == recordInfo.getAfterIndustry()) { // 典当
            //这几种行业没有风险值，故从别的行业转过来的时候需要将风险值设空
            riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());
        }
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 私募基金、众筹、典当、商业保理
     */
    private void modifyLevelBeforeWithoutLevel(RecordInfo recordInfo) {
        // 修改风险等级
        if (CompanyInfo.TYPE_P2P_1 == recordInfo.getAfterIndustry()) { // 网络借贷
            // do nothing, just record
        } else if (CompanyInfo.TYPE_XD_2 == recordInfo.getAfterIndustry()   // 小额贷款
                || CompanyInfo.TYPE_RZDB_3 == recordInfo.getAfterIndustry()) {  // 融资担保
            companyLevelService.addLoadLevel(recordInfo);
        } else if (CompanyInfo.TYPE_XXLC_4 == recordInfo.getAfterIndustry()) { // 线下理财
            riskCompanyService.modifyOffLineLevel(recordInfo);
            indexDataMapper.addOffLineLevel(recordInfo);
        } else if (CompanyInfo.TYPE_JYS_9 == recordInfo.getAfterIndustry()) {  // 交易场所
            riskCompanyService.modifyOffLineLevel(recordInfo);
            exchangeCompanyService.addExchange(recordInfo);
        } else if (CompanyInfo.TYPE_RZZL_13 == recordInfo.getAfterIndustry()) { // 融资租赁
            if (!financeLeaseService.isExistFinanceLease(recordInfo)) {
                financeLeaseService.addFinanceLease(recordInfo);
            } else {
                financeLeaseService.modifyFinanceLease(recordInfo);
            }
        } else if (CompanyInfo.TYPE_YFK_11 == recordInfo.getAfterIndustry()) {// 预付卡
            prepaidCompanyStaticService.addPerpaycard(recordInfo);
        }else if (CompanyInfo.TYPE_SMJJ_5 == recordInfo.getAfterIndustry()   // 私募基金
                || CompanyInfo.TYPE_ZC_6 == recordInfo.getAfterIndustry()    // 众筹
                || CompanyInfo.TYPE_SYBL_10 == recordInfo.getAfterIndustry()   // 商业保理
                || CompanyInfo.TYPE_DD_12 == recordInfo.getAfterIndustry()) { // 典当
            //这几种行业没有风险值，即使是相互转换，也在清空一次风险等级，确保之前的错误数据，存档后可以正确
            riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());
        }
    }

    /**
     * 私募基金
     *
     * @param modifyData
     * @throws Exception
     */
    public void modifyPrivateFund(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 修改风险等级
        modifyLevelBeforeWithoutLevel(recordInfo);
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 众筹
     *
     * @param modifyData
     */
    public void modifyCrowdfunding(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        //虽然众筹和网贷需要数据落地才能修改，暂时还是清空风险等级
        riskCompanyService.modifyLevel(recordInfo.getName(),recordInfo.getAfterLevel());
        // 修改行业
        modifyIndustry(recordInfo);

    }

    /**
     * 典当
     *
     * @param modifyData
     */
    public void modifyPawn(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 修改风险等级
        modifyLevelBeforeWithoutLevel(recordInfo);
        // 修改行业
        modifyIndustry(recordInfo);
    }

    /**
     * 商业保理
     *
     * @param modifyData
     */
    public void modifyBusinessInsurance(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        RecordInfo recordInfo = recordModify(modifyData, companyInfo);
        // 修改风险等级
        modifyLevelBeforeWithoutLevel(recordInfo);
        // 修改行业
        modifyIndustry(recordInfo);
    }
}
