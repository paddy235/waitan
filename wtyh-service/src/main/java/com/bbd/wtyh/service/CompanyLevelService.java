package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.LoanModify;
import com.bbd.wtyh.domain.EasyExport.LoanData;
import com.bbd.wtyh.domain.dto.CompanyLevelDTO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;

import java.util.List;

/**
 * Created by Marco on 2016/8/8.
 */
public interface CompanyLevelService {
    List<CompanyLevelDTO> getCompanyLevel(Integer companyType, Integer areaId, Integer orderByField, String descAsc);

    CompanyInfo getLoanOrGuaranteeByCompanyName(String name);

    List<LoanData> getLoan(ExportCondition exportCondition, PageBean pagination);

    void recordLoad(LoanModify loanModify);

    void modifyLoad(LoanModify loanModify);
}
