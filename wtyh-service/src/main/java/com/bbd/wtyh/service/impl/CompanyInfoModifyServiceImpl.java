package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoMudifyUtil;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoQueryUtil;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private RedisDAO redisDAO;

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
        } else if (CompanyInfo.TYPE_SMJJ_5 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 私募基金
            return companyInfoQueryUtil.getPrivateFund(name);
        } else if (CompanyInfo.TYPE_ZC_6 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 众筹
            return companyInfoQueryUtil.getCrowdingFund(name);
        } else if (CompanyInfo.TYPE_DD_12 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 典当
            return companyInfoQueryUtil.getPawn(name);
        } else if (CompanyInfo.TYPE_SYBL_10 == companyInfoModifyMapper.queryCompany(name).getIndustry()) { // 商业保理
            return companyInfoQueryUtil.getBusinessInsurance(name);
        }
        return null;
    }

    /**
     * 风险等级 修改
     *
     * @param modifyData
     * @return
     */
    @Override
    public void modify(ModifyData modifyData) throws Exception {
        //以''空字串的形式更新小额贷款和融资担保SQL会报错
        if(StringUtils.isEmpty(modifyData.getOutLevel())){
            modifyData.setOutLevel(null);
        }
        if(StringUtils.isEmpty(modifyData.getInnnerLevel())){
            modifyData.setInnnerLevel(null);
        }
        if(StringUtils.isEmpty(modifyData.getLiveLevel())){
            modifyData.setLiveLevel(null);
        }
        if(StringUtils.isEmpty(modifyData.getLevel())){
            modifyData.setLevel(null);
        }
        if (CompanyInfo.TYPE_P2P_1 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 网络借贷
            companyInfoMudifyUtil.modifyWangdai(modifyData);
        } else if (CompanyInfo.TYPE_XD_2 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 小额贷款
            companyInfoMudifyUtil.modifyLoad(modifyData);
        } else if (CompanyInfo.TYPE_RZDB_3 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 融资担保
            companyInfoMudifyUtil.modifyLoad(modifyData);
        } else if (CompanyInfo.TYPE_XXLC_4 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 线下理财
            companyInfoMudifyUtil.modifyOffLine(modifyData);
        } else if (CompanyInfo.TYPE_JYS_9 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 交易场所
            companyInfoMudifyUtil.modifyExchange(modifyData);
        } else if (CompanyInfo.TYPE_YFK_11 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 预付卡
            companyInfoMudifyUtil.modifyPerpaycard(modifyData);
        } else if (CompanyInfo.TYPE_RZZL_13 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 融资租赁
            companyInfoMudifyUtil.modifyFinanceLease(modifyData);
        } else if (CompanyInfo.TYPE_SMJJ_5 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 私募基金
            companyInfoMudifyUtil.modifyPrivateFund(modifyData);
        } else if (CompanyInfo.TYPE_ZC_6 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 众筹
            companyInfoMudifyUtil.modifyCrowdfunding(modifyData);
        } else if (CompanyInfo.TYPE_DD_12 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 典当
            companyInfoMudifyUtil.modifyPawn(modifyData);
        } else if (CompanyInfo.TYPE_SYBL_10 == companyInfoModifyMapper.queryCompany(modifyData.getName()).getIndustry()) { // 商业保理
            companyInfoMudifyUtil.modifyBusinessInsurance(modifyData);
        }
        redisDAO.flushAll();
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
