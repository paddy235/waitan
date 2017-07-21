package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyStatusChangeDO;

import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/19 0019.
 */
public interface CompanyStatusChangeService {
    public CompanyStatusChangeDO companyIsChange(boolean isNew,Integer companyId,String companyName,
                                                 Integer oldCompanyType,Integer newCompanyType);

    public CompanyStatusChangeDO companyChange(boolean isNew,Integer companyId,String companyName,
                                               Integer oldCompanyType,Integer newCompanyType);

    public Map<String,Object> getCompanyInfo(String companyName);
}
