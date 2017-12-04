package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.EasyExport.FinanceLeaseData;
import com.bbd.wtyh.domain.vo.FinanceLeasecCompanyVO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import com.bbd.wtyh.web.XAxisSeriesBarsLineBean;

import java.util.List;
import java.util.Map;

/**
 * 融资租赁接口层
 *
 * @author zhouxuan
 * @since 2016.08.10
 */
public interface FinanceLeaseService {

    public Map leaseCompanyStatistic();

    public Map leaseCompanyCategory(Integer year);

    public List<FinanceLeasecCompanyVO> leaseCompanyList(String areaName, Integer analysisResult, Integer riskA, Integer riskB, Integer riskC, Integer riskD, String companyName);

    List<String> getYears();

    XAxisSeriesBarsLineBean companysAndMoney();

    List<CompanyInfo> getTenancy(String name);

    void modifyFinanceLease(RecordInfo recordInfo);

    void addFinanceLease(RecordInfo recordInfo);

    boolean isExistFinanceLease(RecordInfo recordInfo);

    public List<FinanceLeaseData> getFinanceLease(ExportCondition exportCondition, PageBean pagination);
}
