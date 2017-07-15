package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.service.P2PImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by YanWenyuan on 2017/7/14.
 */
@Service("companyInfoModifyService")
public class CompanyInfoModifyServiceImpl implements CompanyInfoModifyService {

    @Autowired
    private CompanyInfoModifyMapper companyInfoModifyMapper;

    @Autowired
    private P2PImageService p2PImageService;

    @Override
    public List<String> autoComplete(String q) {
        return companyInfoModifyMapper.autoComplete(q);
    }

    @Override
    public CompanyInfo queryCompany(String name) {
        if (CompanyInfo.TYPE_P2P_1 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 网络借贷
            // 1. 获取“公司名 与 平台名” 的对应关系
            PlatListDO platListDO = p2PImageService.getWangdaiCompanyList(name);
            // 2. 获取“平台名”对应的评级信息
            Map<String, Object> platFormStatus = p2PImageService.platFormStatus(platListDO.getPlat_name());
            Map<String, Object> baseInfo = p2PImageService.baseInfo(platListDO.getPlat_name());
//            return platFormStatus.putAll(baseInfo);
        } else if (CompanyInfo.TYPE_XD_2 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 小额贷款
            // company_level
        } else if (CompanyInfo.TYPE_RZDB_3 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 融资担保
            // company_level
        } else if (CompanyInfo.TYPE_XXLC_4 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 线下理财
            // ??
        } else if (CompanyInfo.TYPE_JYS_9 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 交易场所
            // company.risk_level
        } else if (CompanyInfo.TYPE_YFK_11 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 预付卡
            // company_analysis_result.analysis_result
        } else if (CompanyInfo.TYPE_RZZL_13 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 融资租赁
            // finance_lease_risk.risk_status
        }

        return null;
    }
}
