package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;

import java.util.List;
import java.util.Map;

/**
 * Created by YanWenyuan on 2016/8/15.
 */
public interface RealTimeMonitorService {
    List<CompanyAnalysisResult> spectrumAnalysisEmphasis();

    List<CompanyAnalysisResult> spectrumAnalysisUsual();

    List<CompanyAnalysisResult> spectrumAnalysisNormal();

    List<CompanyAnalysisResult> spectrumAnalysisAlready();

    Map<String, Object> ChinaMap();

    Map<String, Object> shMap();

    List<List> spectrumAnalysis();
}
