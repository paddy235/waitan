package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import org.apache.ibatis.annotations.Param;

public interface CrowdFundingCompanyMapper {
	
    CrowdFundingCompanyDO selectByPrimaryKey(Integer companyId);

	List<CrowdFundingCompanyDO> allCompanys();


    List<String> queryCompany(String keyword);

    void saveForDataLand(CrowdFundingCompanyDO crowdFundingCompanyDO);

    void deleteByCompanyName(@Param("companyName")String companyName);
}