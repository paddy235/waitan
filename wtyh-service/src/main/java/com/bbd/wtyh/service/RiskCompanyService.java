package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.OffLineModify;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.EasyExport.OffLineData;
import com.bbd.wtyh.domain.RiskCompanyInfoDO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;

import java.util.List;
import java.util.Map;

public interface RiskCompanyService {

    List<RiskCompanyInfoDO> getScanner(Map<String, Object> params);

    List<RiskCompanyInfoDO> getTop(Map<String, Object> params);

    int getTopCount(Map<String, Object> params);

    String getLastDataVersion();

    CompanyInfo getOffLineFinanceByCompanyName(String name);

    List<OffLineData> getOffLineFinance(ExportCondition exportCondition, PageBean pagination);

    void modifyLevel(String name, String afterLevel);

    void recordOffLine(OffLineModify offLineModify);

    void modifyOffLineLevel(RecordInfo offLineModify);

    void modifyIndustry(String name, String industry);

    Map<String,String> area();

}
