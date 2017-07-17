package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.RiskCompanyInfoDO;

import java.util.List;
import java.util.Map;

public interface RiskCompanyMapper {

    List<RiskCompanyInfoDO> getScanner(Map<String, Object> params);

    int getScannerCount(Map<String, Object> params);

    List<RiskCompanyInfoDO> getTop(Map<String, Object> params);

    int getTopCount(Map<String, Object> params);

    String getLastDataVersion();

    CompanyInfo getOffLineFinanceByName(String name);
}
