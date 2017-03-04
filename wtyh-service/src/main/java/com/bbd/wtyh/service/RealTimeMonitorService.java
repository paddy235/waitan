package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.domain.vo.SpectrumVO;

import java.util.List;
import java.util.Map;

/**
 * Created by YanWenyuan on 2016/8/15.
 */
public interface RealTimeMonitorService {

    List<CompanyAnalysisResult> spectrumAnalysisAlready();

    Map<String, Object>  ChinaMap();

    List<List<CompanyAnalysisResultDO>> shMap();

    Map<String, Object> shMapMonitor();

    List<List<SpectrumVO>> spectrumAnalysis(Integer areaId);

    Map<String, Map> shArea(Integer areaId);

    Map<String,Object> ChinaMapSubsidiary();
}
