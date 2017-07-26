package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.LoanModify;
import com.bbd.wtyh.domain.CompanyInfoModify.OffLineModify;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoMudifyUtil;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoQueryUtil;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
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

    @Override
    public List<String> autoComplete(String q) {
        return companyInfoModifyMapper.autoComplete(q);
    }

    @Override
    public CompanyInfo queryCompany(String name) {
        if (companyInfoModifyMapper.queryCompany(name) == null) {
            return null;
        }
        if (CompanyInfo.TYPE_P2P_1 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 网络借贷
            return companyInfoQueryUtil.getWangdaiInfo(name);
        } else if (CompanyInfo.TYPE_XD_2 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 小额贷款
            return companyInfoQueryUtil.getLoan(name);
        } else if (CompanyInfo.TYPE_RZDB_3 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 融资担保
            return companyInfoQueryUtil.getGuarantee(name);
        } else if (CompanyInfo.TYPE_XXLC_4 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 线下理财
            return companyInfoQueryUtil.getOffLineFinance(name);
        } else if (CompanyInfo.TYPE_JYS_9 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 交易场所
            return companyInfoQueryUtil.getTradeMarket(name);
        } else if (CompanyInfo.TYPE_YFK_11 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 预付卡
            return companyInfoQueryUtil.getPerpaycard(name);
        } else if (CompanyInfo.TYPE_RZZL_13 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 融资租赁
            return companyInfoQueryUtil.getTenancy(name);
        }
        return null;
    }

    /**
     * 风险等级 修改
     * @param modifyData
     * @return
     */
    @Override
    public void modifyLevel(ModifyData modifyData) throws Exception {
        if (CompanyInfo.TYPE_P2P_1 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 网络借贷
            CompanyInfo wangdai = companyInfoQueryUtil.getWangdaiInfo(modifyData.getName());
            WangdaiModify wangdaiModify = new WangdaiModify();
            wangdaiModify.setName(modifyData.getName());
            wangdaiModify.setPlatName(wangdai.getPlatName());
            wangdaiModify.setBeforeLevel(wangdai.getCurrentLevel());
            wangdaiModify.setAfterLevel(modifyData.getLevel());
            wangdaiModify.setBeforeIndustry(CompanyInfo.TYPE_P2P_1);
            // 记录行为
            companyInfoMudifyUtil.recordWangdai(wangdaiModify);
            // 记录company值
            companyInfoMudifyUtil.modifyLevel(modifyData.getName(), wangdaiModify);
        } else if (CompanyInfo.TYPE_XD_2 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 小额贷款
            CompanyInfo companyInfo = companyInfoQueryUtil.getLoan(modifyData.getName());
            LoanModify loanModify = new LoanModify();
            loanModify.setName(companyInfo.getName());
            loanModify.setBeforeOutLevel(companyInfo.getOutLevel());
            loanModify.setBeforeInnnerLevel(companyInfo.getInnnerLevel());
            loanModify.setBeforeLiveLevel(companyInfo.getLiveLevel());
            loanModify.setAfterOutLevel(modifyData.getOutLevel());
            loanModify.setAfterInnnerLevel(modifyData.getInnnerLevel());
            loanModify.setAfterLiveLevel(modifyData.getLiveLevel());
            loanModify.setBeforeIndustry(CompanyInfo.TYPE_XD_2);
            // 记录行为
            companyInfoMudifyUtil.recordLoad(loanModify);
            // 修改值
            companyInfoMudifyUtil.modifyLoad(loanModify);
        } else if (CompanyInfo.TYPE_RZDB_3 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 融资担保
            CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
            LoanModify loanModify = new LoanModify();
            loanModify.setName(companyInfo.getName());
            loanModify.setBeforeOutLevel(companyInfo.getOutLevel());
            loanModify.setBeforeInnnerLevel(companyInfo.getInnnerLevel());
            loanModify.setBeforeLiveLevel(companyInfo.getLiveLevel());
            loanModify.setAfterOutLevel(modifyData.getOutLevel());
            loanModify.setAfterInnnerLevel(modifyData.getInnnerLevel());
            loanModify.setAfterLiveLevel(modifyData.getLiveLevel());
            loanModify.setBeforeIndustry(CompanyInfo.TYPE_RZDB_3);
            // 记录行为
            companyInfoMudifyUtil.recordLoad(loanModify);
            // 修改值
            companyInfoMudifyUtil.modifyLoad(loanModify);
        } else if (CompanyInfo.TYPE_XXLC_4 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 线下理财
            CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
            OffLineModify offLineModify = new OffLineModify();
            offLineModify.setName(companyInfo.getName());
            offLineModify.setBeforeLevel(companyInfo.getCurrentLevel());
            offLineModify.setAfterLevel(modifyData.getLevel());
            offLineModify.setBeforeIndustry(CompanyInfo.TYPE_XXLC_4);
            // 记录行为
            companyInfoMudifyUtil.recordOffLine(offLineModify);
            // 修改值
            companyInfoMudifyUtil.modifyOffLine(offLineModify);
        } else if (CompanyInfo.TYPE_JYS_9 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 交易场所
            CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
            OffLineModify offLineModify = new OffLineModify();
            offLineModify.setName(companyInfo.getName());
            offLineModify.setBeforeLevel(companyInfo.getCurrentLevel());
            offLineModify.setAfterLevel(modifyData.getLevel());
            offLineModify.setBeforeIndustry(CompanyInfo.TYPE_JYS_9);
            // 记录行为
            companyInfoMudifyUtil.recordOffLine(offLineModify);
            // 修改值
            companyInfoMudifyUtil.modifyOffLine(offLineModify);
        } else if (CompanyInfo.TYPE_YFK_11 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 预付卡
            CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
            OffLineModify offLineModify = new OffLineModify();
            offLineModify.setName(companyInfo.getName());
            offLineModify.setBeforeLevel(companyInfo.getCurrentLevel());
            offLineModify.setAfterLevel(modifyData.getLevel());
            offLineModify.setBeforeIndustry(CompanyInfo.TYPE_JYS_9);
            // 记录行为
            companyInfoMudifyUtil.recordOffLine(offLineModify);
            // 修改值
            companyInfoMudifyUtil.modifyOffLine(offLineModify);
        } else if (CompanyInfo.TYPE_RZZL_13 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 融资租赁
            CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
            OffLineModify offLineModify = new OffLineModify();
            offLineModify.setName(companyInfo.getName());
            offLineModify.setBeforeLevel(companyInfo.getCurrentLevel());
            offLineModify.setAfterLevel(modifyData.getLevel());
            offLineModify.setBeforeIndustry(CompanyInfo.TYPE_JYS_9);
            // 记录行为
            companyInfoMudifyUtil.recordOffLine(offLineModify);
            // 修改值
            companyInfoMudifyUtil.modifyOffLine(offLineModify);
        }
        // 修改行业
        if (!StringUtils.isEmpty(modifyData.getIndustry())) {
            companyInfoMudifyUtil.modifyIndustry(modifyData.getName(), modifyData.getIndustry());
        }
    }

    @Override
    public Boolean isModify(String name) {
        List<String> names = companyInfoModifyMapper.queryModifyCompany(name);
        if (names.isEmpty()) {
            return false;
        }
        return true;
    }

}
