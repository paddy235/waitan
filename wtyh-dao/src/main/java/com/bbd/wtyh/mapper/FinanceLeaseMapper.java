package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.vo.CompanyCapitalVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseStatisticVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FinanceLeaseMapper {

    public List<FinanceLeaseStatisticVO> queryFinanceLeaseStatistic(Map map);

    public List<Map> queryFinanceLeaseCompanyCategory(@Param("year") Integer year);

    public List<FinanceLeaseVO> queryLeaseCompanyList(Map map);

    List<String> getYears();

    List<CompanyCapitalVO> queryCompanysAndCapital();

    public Integer queryFinanceLeaseMinYear();

    public Integer queryFinanceLeaseMaxYear();

    List<CompanyInfo> getTenancyByName(@Param("name") String name);

    void modifyFinanceLease(@Param("recordInfo") RecordInfo recordInfo);

    void addFinanceLease(@Param("recordInfo") RecordInfo recordInfo);

    List<CompanyInfo> isExistFinanceLease(@Param("recordInfo")RecordInfo recordInfo);
}