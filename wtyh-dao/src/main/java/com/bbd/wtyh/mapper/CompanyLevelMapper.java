package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.LoanModify;
import com.bbd.wtyh.domain.CompanyLevelDO;
import com.bbd.wtyh.domain.EasyExport.LoanData;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyLevelMapper {
    CompanyLevelDO selectByPrimaryKey(Integer companyId);

    List<CompanyLevelDO> selectCompanyLevel(@Param("companyType") Integer companyType, @Param("areaId") Integer areaId, @Param("orderByField") Integer orderByField, @Param("descAsc") String descAsc);

    CompanyInfo getLoanOrGuaranteeByCompanyName(@Param(value = "name") String name);

    List<LoanData> getLoan(ExportCondition exportCondition);

    void recordLoad(LoanModify loanModify);

    void modifyLoad(LoanModify loanModify);
}