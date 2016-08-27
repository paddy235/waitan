package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.query.CompanyQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/8/8.
 */
public interface CompanyService {

    int countCompanyNum(CompanyQuery query);

    String getNameById(Integer companyId);

    CompanyDO getCompanyById(Integer companyId);

    CompanyDO getCompanyByName(String companyName);

    List<CompanyDO> searchCompany(Integer companyType, String keyword, Integer size);

    List<CompanyDO> queryCompanyByType(Integer companyType, Integer orderByField, String descAsc);

    List<CompanyDO> searchCompanyName(Map<String, Object> params);

    int searchCompanyNameCount(String keyword, String dataVersion);

}
