package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;

public interface CompanyAnalysisResultMapper {

    List<CompanyAnalysisResult> getSpectrumAnalysisAll();

    CompanyAnalysisResultDO selectByPrimaryKey(Integer companyId);

    List<CompanyAnalysisResultDO> queryRiskByBuilding(Integer buildingId);

    List<CompanyAnalysisResult> getSpectrumAnalysis(int type);

    List<RelatedCompanyStatisticDO> getChinaMap();
}