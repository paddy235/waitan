package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.query.CompanyQuery;

import java.util.List;

/**
 * Created by Marco on 2016/8/8.
 */
public interface CompanyService {

    int countCompanyNum(CompanyQuery query);

    String getNameById(Integer companyId);

    CompanyDO getCompanyById(Integer companyId);

    List<CompanyDO> searchCompany(Integer companyType, String keyword);

}