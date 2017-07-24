package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoMudifyUtil;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoQueryUtil;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public CompanyInfo modifyLevel(ModifyData modifyData) {
        if (CompanyInfo.TYPE_P2P_1 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 网络借贷
            CompanyInfo wangdai = companyInfoQueryUtil.getWangdaiInfo(modifyData.getName());
            WangdaiModify wangdaiModify = new WangdaiModify();
            wangdaiModify.setName(modifyData.getName());
            wangdaiModify.setPlatName(wangdai.getPlatName());
            wangdaiModify.setBeforeLevel(wangdai.getCurrentLevel());
            wangdaiModify.setAfterLevel(modifyData.getLevel());
            companyInfoMudifyUtil.recordWangdai(wangdaiModify);
        } else if (CompanyInfo.TYPE_XD_2 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 小额贷款

        } else if (CompanyInfo.TYPE_RZDB_3 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 融资担保

        } else if (CompanyInfo.TYPE_XXLC_4 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 线下理财

        } else if (CompanyInfo.TYPE_JYS_9 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 交易场所

        } else if (CompanyInfo.TYPE_YFK_11 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 预付卡

        } else if (CompanyInfo.TYPE_RZZL_13 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 融资租赁

        }
        return null;
    }
}
