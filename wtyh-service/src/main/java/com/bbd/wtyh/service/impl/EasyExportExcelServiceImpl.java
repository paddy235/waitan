
/**
 * @Title: AreaServiceImpl.java
 * @Package com.bbd.wtyh.service.impl
 * @Description: TODO
 * @author Ian.Su
 * @date 2016年8月5日 下午1:48:36
 * @version V1.0
 */

package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.EasyExport.*;
import com.bbd.wtyh.service.CompanyLevelService;
import com.bbd.wtyh.service.EasyExportExeclService;
import com.bbd.wtyh.service.RiskCompanyService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("easyExportExeclService")
public class EasyExportExcelServiceImpl implements EasyExportExeclService {

    @Autowired
    private RiskCompanyService riskCompanyService;  // 线下理财

    @Autowired
    private CompanyLevelService companyLevelService;    // 小额贷款、融资担保

    @Override
    public List<WangdaiData> getWangdai(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<LoanData> getLoan(ExportCondition exportCondition) {
        return companyLevelService.getLoan(exportCondition);
    }

    @Override
    public List<GuaranteeData> getGuarantee(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<OffLineData> getOffLineFinance(ExportCondition exportCondition) {
        return riskCompanyService.getOffLineFinance(exportCondition);
    }

    @Override
    public List<TradeMarketData> getTradeMarket(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<PerpaycardData> getPerpaycard(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<TenancyData> getTenancy(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<CrowdfundData> getCrowdfund(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<PawnData> getPawn(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<InsuranceData> getInsurance(ExportCondition exportCondition) {
        return null;
    }
}
