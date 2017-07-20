package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.EasyExport.*;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.ResponseBean;

import java.util.List;

public interface EasyExportExeclService {
    List<WangdaiData> getWangdai(ExportCondition exportCondition);

    List<LoanData> getLoan(ExportCondition exportCondition);

    List<GuaranteeData> getGuarantee(ExportCondition exportCondition);

    List<OffLineData> getOffLineFinance(ExportCondition exportCondition);

    List<TradeMarketData> getTradeMarket(ExportCondition exportCondition);

    List<PerpaycardData> getPerpaycard(ExportCondition exportCondition);

    List<TenancyData> getTenancy(ExportCondition exportCondition);

    List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition);

    List<CrowdfundData> getCrowdfund(ExportCondition exportCondition);

    List<PawnData> getPawn(ExportCondition exportCondition);

    List<InsuranceData> getInsurance(ExportCondition exportCondition);

}
