package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.mapper.CompanyAnalysisResultMapper;
import com.bbd.wtyh.service.RealTimeMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YanWenyuan on 2016/8/15.
 */
@Service("realTimeMonitorService")
public class RealTimeMonitorServiceImpl implements RealTimeMonitorService {
    @Autowired
    private CompanyAnalysisResultMapper companyAnalysisResultMapper;


    @Override
    public List<CompanyAnalysisResult> spectrumAnalysis() {
        return companyAnalysisResultMapper.getSpectrumAnalysisAll();
    }

    @Override
    public List<CompanyAnalysisResult> spectrumAnalysisEmphasis() {
        return companyAnalysisResultMapper.getSpectrumAnalysis(CompanyAnalysisResult.IMPORT_FOCUS.getType());
    }

    @Override
    public List<CompanyAnalysisResult> spectrumAnalysisUsual() {
        return companyAnalysisResultMapper.getSpectrumAnalysis(CompanyAnalysisResult.COMMON_FOCUS.getType());
    }

    @Override
    public List<CompanyAnalysisResult> spectrumAnalysisNormal() {
        return companyAnalysisResultMapper.getSpectrumAnalysis(CompanyAnalysisResult.NORMAL.getType());
    }

    @Override
    public List<CompanyAnalysisResult> spectrumAnalysisAlready() {
        return companyAnalysisResultMapper.getSpectrumAnalysis(CompanyAnalysisResult.RISK.getType());
    }

    @Override
    public Map<String, Object> ChinaMap() {
        RelatedCompanyStatisticDO relatedCompanyStatisticDO = (RelatedCompanyStatisticDO) companyAnalysisResultMapper.getChinaMap();
        Map<String, Object> data = new HashMap<>();
        System.out.println(relatedCompanyStatisticDO.getArea_name());
        System.out.println(relatedCompanyStatisticDO.getRelated_company());
//        data.put("areaName", relatedCompanyStatisticDO.getArea_name());
//        data.put("", relatedCompanyStatisticDO.getRelated_company());
        return data;
    }

    @Override
    public Map<String, Object> shMap() {
//        return realTimeMonitorDao.shMap();
        return null;
    }

}
