package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.EasyExport.CrowdfundData;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import org.apache.ibatis.annotations.Param;

public interface CrowdFundingCompanyMapper {
	
    CrowdFundingCompanyDO selectByPrimaryKey(Integer companyId);

	List<CrowdFundingCompanyDO> allCompanys();


    List<String> queryCompany(String keyword);

    void saveForDataLand(CrowdFundingCompanyDO crowdFundingCompanyDO);

    void deleteByPlatName(@Param("platformName")String platformName);

    List<CrowdfundData> getCrowdfund(@Param(value = "exportCondition")ExportCondition exportCondition,
                                     @Param(value = "pagination")PageBean pagination);

    Long countCrowdfund(@Param(value = "exportCondition")ExportCondition exportCondition);

    List<CrowdFundingCompanyDO> queryBaseOfPlat();
}