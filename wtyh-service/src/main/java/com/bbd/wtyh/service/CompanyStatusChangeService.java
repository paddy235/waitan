package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyStatusChangeDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/19 0019.
 */
public interface CompanyStatusChangeService {
    public void companyStatusChange(boolean isNew,String companyName,Byte newCompanyType);

    public void companyStatusChange(boolean isNew,CompanyDO companyDO, BaseDataDO.Results bddRst);

    public void companyStatusChangeForNewSource(boolean isNew,CompanyDO companyDO, BaseDataDO.Results bddRst);

    public CompanyStatusChangeDO companyChange(boolean isNew,String companyName,Byte newCompanyType);

    public Map<String,Object> getCompanyInfo(String companyName);
}
