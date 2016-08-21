package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.BuildingNumberInAreaDO;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyGroupByAreaDO;
import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;
import com.bbd.wtyh.domain.dto.StaticRiskDTO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.service.RealTimeMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private RelatedCompanyStatisticMapper relatedCompanyStatisticMapper;

    @Autowired
    private StaticRiskMapper staticRiskMapper;

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private RealTimeMonitorDao realTimeMonitorDao;

    private final Integer MAX = null;
    private final Integer EMPHASIS = 70;
    private final Integer USUAL = 60;
    private final Integer MIN = null;

    @Override
    public List<List> spectrumAnalysis() {
        List<StaticRiskDTO> spectrumAnalysisEmphasis = staticRiskMapper.getSpectrumAnalysis(EMPHASIS, MAX);
        List<StaticRiskDTO> spectrumAnalysisUsual = staticRiskMapper.getSpectrumAnalysis(USUAL, EMPHASIS);
        List<StaticRiskDTO> spectrumAnalysisNormal = staticRiskMapper.getSpectrumAnalysis(MIN, USUAL);
        List<CompanyAnalysisResult> spectrumAnalysisAlready = spectrumAnalysisAlready();

        List<List> rst = new ArrayList<>();
        rst.add(spectrumAnalysisEmphasis);
        rst.add(spectrumAnalysisUsual);
        rst.add(spectrumAnalysisNormal);
        rst.add(spectrumAnalysisAlready);
        return rst;
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
        List<RelatedCompanyStatisticDO> list = relatedCompanyStatisticMapper.getChinaMap();
        Map<String, Object> map = new HashMap<>();
        List<Object> resultList = new ArrayList<>();
        for (RelatedCompanyStatisticDO re : list) {
            List<Map<String, Object>> result = new ArrayList<>();
            Map<String, Object> data1 = new HashMap<>();
            Map<String, Object> data2 = new HashMap<>();
            data1.put("name", re.getAreaName());
            data1.put("value", re.getRelatedCompany());
            data2.put("name", "上海");
            result.add(data1);
            result.add(data2);
            resultList.add(result);
        }
        map.put("SHData", resultList);
        return map;
    }

    @Override
    public List<List<CompanyAnalysisResultDO>> shMap() {
        // 公司名、经纬度、风险类型、静态风险值、暴露风险时间
        final String dateVersion = staticRiskMapper.maxDataVersion();
        List<CompanyAnalysisResultDO> exposures = companyAnalysisResultMapper.shMap(CompanyAnalysisResultDO.EXPOSURE, dateVersion);
        List<CompanyAnalysisResultDO> highs = companyAnalysisResultMapper.shMap(CompanyAnalysisResultDO.HIGH, dateVersion);
        List<CompanyAnalysisResultDO> focuses = companyAnalysisResultMapper.shMap(CompanyAnalysisResultDO.FOCUS, dateVersion);
        List<CompanyAnalysisResultDO> normals = companyAnalysisResultMapper.shMap(CompanyAnalysisResultDO.NORMAL, dateVersion);

        List<List<CompanyAnalysisResultDO>> rst = new ArrayList<>();
        rst.add(exposures);
        rst.add(highs);
        rst.add(focuses);
        rst.add(normals);
        return rst;
    }


    @Override
    public Map<String, Map> shArea() {
        List<BuildingNumberInAreaDO> buildingNumberInArea = buildingMapper.countByArea();
        List<CompanyGroupByAreaDO> companyGroupByArea = buildingMapper.companyGroupByArea();

        Map<String, List> companyGroupByAreaMap = new HashMap<>();
        for (CompanyGroupByAreaDO e : companyGroupByArea) {
            if (companyGroupByAreaMap.containsKey(e.getArea())) {
                companyGroupByAreaMap.get(e.getArea()).add(e.getCompanyName());
            } else {
                List<String> companys = new ArrayList<>();
                companys.add(e.getCompanyName());
                companyGroupByAreaMap.put(e.getArea(), companys);
            }
        }
        Map<String, Map> rst = new HashMap<>();
        for (BuildingNumberInAreaDO buildingNumberInAreaDO : buildingNumberInArea) {
            Map<String, String> num = new HashMap<>();
            num.put("num", buildingNumberInAreaDO.getCount());
            rst.put(buildingNumberInAreaDO.getName(), num);

            Map<String, List> companyName = new HashMap<>();
            companyName.put("companyName", companyGroupByAreaMap.get(buildingNumberInAreaDO.getName()));
            rst.put(buildingNumberInAreaDO.getName(), companyName);
        }
        return rst;
    }

    /**
     * 上海地图--左上角监测，下面滚动条
     * @return
     */
    @Override
    public Map<String, Object> shMapMonitor() {
        Map<String, Object> data = realTimeMonitorDao.shMapMonitor();
        return data;
    }


}
