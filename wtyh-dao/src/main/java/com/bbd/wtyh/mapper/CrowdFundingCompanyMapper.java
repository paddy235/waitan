package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;

public interface CrowdFundingCompanyMapper {
	
    CrowdFundingCompanyDO selectByPrimaryKey(Integer companyId);

	List<CrowdFundingCompanyDO> allCompanys();


    List<String> queryCompany(String keyword);

    void saveForDataLand(CrowdFundingCompanyDO crowdFundingCompanyDO);
}