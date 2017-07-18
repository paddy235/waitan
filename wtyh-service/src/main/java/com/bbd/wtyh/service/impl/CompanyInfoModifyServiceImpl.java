package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoModifyUtil;
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
    private CompanyInfoModifyUtil companyInfoModifyUtil;

    @Override
    public List<String> autoComplete(String q) {
        return companyInfoModifyMapper.autoComplete(q);
    }

    @Override
    public CompanyInfo queryCompany(String name) {
        if (CompanyInfo.TYPE_P2P_1 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 网络借贷
            return companyInfoModifyUtil.getWangdaiInfo(name);
        } else if (CompanyInfo.TYPE_XD_2 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 小额贷款
            return companyInfoModifyUtil.getLoan(name);
        } else if (CompanyInfo.TYPE_RZDB_3 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 融资担保
            return companyInfoModifyUtil.getGuarantee(name);
        } else if (CompanyInfo.TYPE_XXLC_4 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 线下理财
            return companyInfoModifyUtil.getOffLineFinance(name);
        } else if (CompanyInfo.TYPE_JYS_9 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 交易场所
            return companyInfoModifyUtil.getTradeMarket(name);
        } else if (CompanyInfo.TYPE_YFK_11 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 预付卡
            return companyInfoModifyUtil.getPerpaycard(name);
        } else if (CompanyInfo.TYPE_RZZL_13 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 融资租赁
            return companyInfoModifyUtil.getTenancy(name);
        }
        return null;
    }
}
