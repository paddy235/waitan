
/**
 * @Package com.bbd.wtyh.service.impl
 * @author kv9
 * @date 7017.7.20
 * @version V1.0
 */

package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.EasyExport.*;
import com.bbd.wtyh.domain.enums.WangDaiRiskLevel;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("easyExportExeclService")
public class EasyExportExcelServiceImpl implements EasyExportExeclService {

    @Autowired
    private P2PImageService p2PImageService; // 网络借贷

    @Autowired
    private RiskCompanyService riskCompanyService; // 线下理财

    @Autowired
    private CompanyLevelService companyLevelService; // 小额贷款、融资担保

    @Autowired
    private PrivateFundService privateFundService; // 私募基金

    @Autowired
    private ExchangeCompanyService exchangeCompanyService; // 交易场所

    @Autowired
    private CrowdFundingService crowdFundingService; // 众筹

    @Autowired
    private FinanceLeaseService financeLeaseService; //融资租赁

    @Override
    public List<WangdaiData> getWangdai(ExportCondition exportCondition, PageBean pageBean) {
        // TODO: 2017/7/21
        String curLevel = exportCondition.getCurrentLevel();
        if (null != curLevel) {

            exportCondition.setCurrentLevel(WangDaiRiskLevel.getRiskType(curLevel) + "");
        }
        return p2PImageService.getWangdai(exportCondition, pageBean);
    }

    @Override
    public List<WaiTanData> getWaiTanOther(ExportCondition exportCondition, PageBean pageBean) {
        return p2PImageService.getWaiTanOther(exportCondition, pageBean);
    }

    @Override
    public List<LoanData> getLoan(ExportCondition exportCondition, PageBean pageBean) {
        return companyLevelService.getLoan(exportCondition, pageBean);
    }

    @Override
    public List<LoanData> getGuarantee(ExportCondition exportCondition, PageBean pageBean) {
        return companyLevelService.getLoan(exportCondition, pageBean);
    }

    @Override
    public List<OffLineData> getOffLineFinance(ExportCondition exportCondition, PageBean pageBean) {
        return riskCompanyService.getOffLineFinance(exportCondition, pageBean);
    }

    @Override
    public List<TradeMarketData> getTradeMarket(ExportCondition exportCondition, PageBean pageBean) {
        return exchangeCompanyService.getTradeMarket(exportCondition, pageBean);
    }

    @Override
    public List<PrivateOfferedFundData> getPerpaycard(ExportCondition exportCondition, PageBean pageBean) {
        return privateFundService.getPrivateOfferedFund(exportCondition, pageBean);
    }

    @Override
    public List<FinanceLeaseData> getTenancy(ExportCondition exportCondition, PageBean pageBean) {
        return financeLeaseService.getFinanceLease(exportCondition, pageBean);
    }

    @Override
    public List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition, PageBean pageBean) {
        return privateFundService.getPrivateOfferedFund(exportCondition, pageBean);
    }

    @Override
    public List<CrowdfundData> getCrowdfund(ExportCondition exportCondition, PageBean pageBean) {
        return crowdFundingService.getCrowdfund(exportCondition, pageBean);
    }

    @Override
    public List<PrivateOfferedFundData> getPawn(ExportCondition exportCondition, PageBean pageBean) {
        return privateFundService.getPrivateOfferedFund(exportCondition, pageBean);
    }

    @Override
    public List<PrivateOfferedFundData> getInsurance(ExportCondition exportCondition, PageBean pageBean) {
        return privateFundService.getPrivateOfferedFund(exportCondition, pageBean);
    }

    @Override
    public Map<String, Integer> area() {
        return riskCompanyService.area();
    }
}
