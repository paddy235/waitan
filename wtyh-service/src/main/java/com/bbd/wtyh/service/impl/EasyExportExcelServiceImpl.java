
/**
 * @Package com.bbd.wtyh.service.impl
 * @author kv9
 * @date 7017.7.20
 * @version V1.0
 */

package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.EasyExport.*;
import com.bbd.wtyh.service.*;
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

    @Autowired
    private PrivateFundService privateFundService;  // 私募基金

    @Autowired
    private ExchangeCompanyService exchangeCompanyService;  // 交易场所

    @Autowired
    private CrowdFundingService crowdFundingService;    // 众筹

    @Autowired
    private MortgageService mortgageService;    // 典当

    @Override
    public List<WangdaiData> getWangdai(ExportCondition exportCondition) {
        return null;
    }

    @Override
    public List<LoanData> getLoan(ExportCondition exportCondition) {
        return companyLevelService.getLoan(exportCondition);
    }

    @Override
    public List<LoanData> getGuarantee(ExportCondition exportCondition) {
        return companyLevelService.getLoan(exportCondition);
    }

    @Override
    public List<OffLineData> getOffLineFinance(ExportCondition exportCondition) {
        return riskCompanyService.getOffLineFinance(exportCondition);
    }

    @Override
    public List<TradeMarketData> getTradeMarket(ExportCondition exportCondition) {
        return exchangeCompanyService.getTradeMarket(exportCondition);
    }

    @Override
    public List<PrivateOfferedFundData> getPerpaycard(ExportCondition exportCondition) {
        return privateFundService.getPrivateOfferedFund(exportCondition);
    }

    @Override
    public List<PrivateOfferedFundData> getTenancy(ExportCondition exportCondition) {
        return privateFundService.getPrivateOfferedFund(exportCondition);
    }

    @Override
    public List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition) {
        return privateFundService.getPrivateOfferedFund(exportCondition);
    }

    @Override
    public List<CrowdfundData> getCrowdfund(ExportCondition exportCondition) {
        return crowdFundingService.getCrowdfund(exportCondition);
    }

    @Override
    public List<PrivateOfferedFundData> getPawn(ExportCondition exportCondition) {
        return privateFundService.getPrivateOfferedFund(exportCondition);
    }

    @Override
    public List<PrivateOfferedFundData> getInsurance(ExportCondition exportCondition) {
        return privateFundService.getPrivateOfferedFund(exportCondition);
    }
}
