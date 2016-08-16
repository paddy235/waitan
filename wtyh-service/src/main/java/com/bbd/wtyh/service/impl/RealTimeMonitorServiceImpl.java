package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.mapper.CompanyAnalysisResultMapper;
import com.bbd.wtyh.service.RealTimeMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//        {
//            geoCoordMap：{
//            '上海': [121.4648,31.2891], // zanshi bu zuo
//            '东莞': [113.8953,22.901],
//            '东营': [118.7073,37.5513]
//        }，
//            SHData：[
//            [{name:'包头',value:95},{name:'上海'}],
//            [{name:'昆明',value:90},{name:'上海'}],
//            [{name:'广州',value:80},{name:'上海'}]
//            ]
//        }
//        Map<String, String> rst = new HashMap<>();
//
//
//        return
        return null;
    }

    @Override
    public Map<String, Object> shMap() {
//        return realTimeMonitorDao.shMap();
        return null;
    }
}
