package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrepaidCompanyStatisticMapper {

    PrepaidCompanyStatisticDO selectByPrimaryKey(Integer year);

    List<PrepaidCompanyStatisticDO> prepaidAll();

    List<PrepaidCompanyDO> prepaidCompanyAll(@Param(value = "companyName") String companyName);

    CompanyInfo getPerpaycardByCompanyName(@Param(value = "name") String name);

    void modifyPerpaycard(@Param(value = "recordInfo")RecordInfo recordInfo);

    void addPerpaycard(@Param(value = "recordInfo")RecordInfo recordInfo);

    void deleteByCompanyId(@Param(value = "recordInfo")RecordInfo recordInfo);

    void addCompanyAnalysisResultWhenBlack(@Param(value = "analysis")CompanyAnalysisResultDO companyAnalysisResultDO);

    int updateCompanyAnalysisResultWhenBlack(@Param(value = "analysis")CompanyAnalysisResultDO companyAnalysisResultDO);
}