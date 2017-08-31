package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.EasyExport.*;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;

import java.util.List;
import java.util.Map;

public interface EasyExportExeclService {
    List<WangdaiData> getWangdai(ExportCondition exportCondition, PageBean pagination);

    List<WaiTanData> getWaiTanOther(ExportCondition exportCondition, PageBean pagination);

    List<LoanData> getLoan(ExportCondition exportCondition, PageBean pagination);

    List<LoanData> getGuarantee(ExportCondition exportCondition, PageBean pagination);

    List<OffLineData> getOffLineFinance(ExportCondition exportCondition, PageBean pagination);

    List<TradeMarketData> getTradeMarket(ExportCondition exportCondition, PageBean pagination);

    List<PrivateOfferedFundData> getPerpaycard(ExportCondition exportCondition, PageBean pagination);

    List<FinanceLeaseData> getTenancy(ExportCondition exportCondition, PageBean pagination);

    List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition, PageBean pagination);

    List<CrowdfundData> getCrowdfund(ExportCondition exportCondition, PageBean pagination);

    List<PrivateOfferedFundData> getPawn(ExportCondition exportCondition, PageBean pagination);

    List<PrivateOfferedFundData> getInsurance(ExportCondition exportCondition, PageBean pagination);

    Map<String,String> area();

}
