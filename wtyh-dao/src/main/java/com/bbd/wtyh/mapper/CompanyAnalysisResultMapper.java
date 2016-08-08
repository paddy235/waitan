package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.CompanyAnalysisResultDO;

public interface CompanyAnalysisResultMapper {
	
    CompanyAnalysisResultDO selectByPrimaryKey(Integer companyId);
    
    List<CompanyAnalysisResultDO> queryRiskByBuilding(Integer buildingId);
}