package com.bbd.wtyh.mapper;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import org.apache.ibatis.annotations.Param;

public interface CompanyAnalysisResultMapper {

    @Deprecated
    List<CompanyAnalysisResult> getSpectrumAnalysisAll();

    CompanyAnalysisResultDO selectByPrimaryKey(Integer companyId);

    List<CompanyAnalysisResultDO> queryRiskByBuilding(Integer buildingId);

    List<CompanyAnalysisResult> getSpectrumAnalysis(int type);

    List<CompanyAnalysisResultDO> shMap(@Param(value = "analysisResult") Integer analysisResult,
                                        @Param(value = "dateVersion")String dateVersion);
}