package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.EasyExport.*;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;

import java.util.List;

public interface EasyExportExeclService {
    List<WangdaiData> getWangdai(ExportCondition exportCondition);

    List<LoanData> getLoan(ExportCondition exportCondition);

    List<LoanData> getGuarantee(ExportCondition exportCondition);

    List<OffLineData> getOffLineFinance(ExportCondition exportCondition);

    List<TradeMarketData> getTradeMarket(ExportCondition exportCondition);

    List<PrivateOfferedFundData> getPerpaycard(ExportCondition exportCondition);

    List<PrivateOfferedFundData> getTenancy(ExportCondition exportCondition);

    List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition);

    List<CrowdfundData> getCrowdfund(ExportCondition exportCondition);

    List<PrivateOfferedFundData> getPawn(ExportCondition exportCondition);

    List<PrivateOfferedFundData> getInsurance(ExportCondition exportCondition);

}
