package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;

import java.util.List;

/**
 *
 * Created by YanWenyuan on 2017/7/13.
 */
public interface CompanyInfoModifyService {

    List<String> autoComplete(String q);

    CompanyInfo queryCompany(String name);

    CompanyAnalysisResultDO queryCompanyAnalysisResultDO(Integer companyId);

    void modify(ModifyData name, String modifyBy) throws Exception;

    Boolean isModify(String name);

    Boolean isModifyByAfterRisk(String name);
}
