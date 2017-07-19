package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.RiskCompanyInfoDO;

import java.util.List;
import java.util.Map;

public interface RiskCompanyService {

    List<RiskCompanyInfoDO> getScanner(Map<String, Object> params);

    List<RiskCompanyInfoDO> getTop(Map<String, Object> params);

    int getTopCount(Map<String, Object> params);

    String getLastDataVersion();

    CompanyInfo getOffLineFinanceByCompanyName(String name);
}
