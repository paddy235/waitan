package com.bbd.wtyh.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.vo.StatisticsVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.dao.RealTimeMonitorDao;
import com.bbd.wtyh.domain.BuildingNumberInAreaDO;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyGroupByAreaDO;
import com.bbd.wtyh.domain.CountCompanyByAreaDO;
import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;
import com.bbd.wtyh.domain.RelatedSubsidiaryStatisticDO;
import com.bbd.wtyh.domain.dto.StaticRiskDTO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.domain.vo.SpectrumVO;
import com.bbd.wtyh.mapper.BuildingMapper;
import com.bbd.wtyh.mapper.CompanyAnalysisResultMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.RelatedCompanyStatisticMapper;
import com.bbd.wtyh.mapper.RelatedSubsidiaryStatisticMapper;
import com.bbd.wtyh.mapper.StaticRiskMapper;
import com.bbd.wtyh.service.RealTimeMonitorService;

/**
 * Created by YanWenyuan on 2016/8/15.
 */
@Service("realTimeMonitorService")
public class RealTimeMonitorServiceImpl implements RealTimeMonitorService {

    Logger logger = LoggerFactory.getLogger(RealTimeMonitorServiceImpl.class);

    @Autowired
    private CompanyAnalysisResultMapper companyAnalysisResultMapper;

    @Autowired
    private RelatedSubsidiaryStatisticMapper relatedSubsidiaryStatisticMapper;

    @Autowired
    private RelatedCompanyStatisticMapper relatedCompanyStatisticMapper;

    @Autowired
    private StaticRiskMapper staticRiskMapper;

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private RealTimeMonitorDao realTimeMonitorDao;

    private final Integer MAX = null;
    private final Integer EMPHASIS = 70;
    private final Integer USUAL = 60;
    private final Integer MIN = null;
    private final boolean NORMAL_FLAG = true;

    // 2:????????????(???) 3:????????????(???) 4:??????(???)'???1:????????????(???)
    private final Integer FOCUS_LEVEL = 2;
    private final Integer USUAL_LEVEL = 3;
    private final Integer NORMAL_LEVEL = 4;
    private final Integer RISK_LEVEL = 1;

    @Override
    public List<List<SpectrumVO>> spectrumAnalysis(Integer areaId) {
        final String dateVersion = staticRiskMapper.maxDataVersion();
        List<Map<String, Integer>> riskLevelNumber = companyMapper.getRiskLevelNumber();
        Integer black = 400, red = 400, yellow = 400, green = 400;
        if (CollectionUtils.isNotEmpty(riskLevelNumber)) {

            for (Map<String, Integer> map : riskLevelNumber) {
                Integer riskLevel = map.get("riskLevel");
                Integer companyNumber = map.get("companyNumber");
                if (riskLevel != null) {
                    if (riskLevel == 1) {
                        black = companyNumber;
                    } else if (riskLevel == 2) {
                        red = companyNumber;
                    } else if (riskLevel == 3) {
                        yellow = companyNumber;
                    } else if (riskLevel == 4) {
                        green = companyNumber;
                    }
                }
            }
        }

        List<SpectrumVO> spectrumAnalysisFocus = companyMapper.getSpectrumAnalysisByRiskLevel(FOCUS_LEVEL, dateVersion, red, areaId);
        List<SpectrumVO> spectrumAnalysisUsual = companyMapper.getSpectrumAnalysisByRiskLevel(USUAL_LEVEL, dateVersion, yellow, areaId);
        List<SpectrumVO> spectrumAnalysisNormal = companyMapper.getSpectrumAnalysisByRiskLevel(NORMAL_LEVEL, dateVersion, green, areaId);
        List<SpectrumVO> spectrumAnalysisRisk = companyMapper.getSpectrumAnalysisByRiskLevelOne();

        List<List<SpectrumVO>> rst = new ArrayList<>();
        rst.add(spectrumAnalysisFocus);
        rst.add(spectrumAnalysisUsual);
        rst.add(spectrumAnalysisNormal);
        rst.add(spectrumAnalysisRisk);
        return rst;
    }

    @Override
    public BigDecimal getCompanyStaticIndexByName(String cpyName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("companyName", cpyName);
        LocalDate ld = LocalDate.now().plusMonths(-1);
        params.put("date", ld.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        //params.put("areaCode", new Integer(104));
        StatisticsVO sv = staticRiskMapper.queryComStatistics(params);
        if (null != sv) {
            return sv.getRiskIndex();
        }
        return null;
    }

    public List<List> spectrumAnalysisBackup() {
        List<StaticRiskDTO> spectrumAnalysisEmphasis = staticRiskMapper.getSpectrumAnalysis(EMPHASIS, MAX, !NORMAL_FLAG);
        List<StaticRiskDTO> spectrumAnalysisUsual = staticRiskMapper.getSpectrumAnalysis(USUAL, EMPHASIS, !NORMAL_FLAG);
        List<StaticRiskDTO> spectrumAnalysisNormal = staticRiskMapper.getSpectrumAnalysis(MIN, USUAL, NORMAL_FLAG);
        List<CompanyAnalysisResult> spectrumAnalysisAlready = spectrumAnalysisAlready();

        List<List> rst = new ArrayList<>();
        rst.add(spectrumAnalysisEmphasis);
        rst.add(spectrumAnalysisUsual);
        rst.add(spectrumAnalysisNormal);
        rst.add(spectrumAnalysisAlready);
        return rst;
    }

    @Override
    public List<CompanyAnalysisResult> spectrumAnalysisAlready() {
        return companyAnalysisResultMapper.getSpectrumAnalysis(CompanyAnalysisResult.RISK.getType());
    }

    @Override
    public Map<String, Object> ChinaMap() {
        // final String key = "wtyh:realtimeMonitor:ChinaMap";
        // List<RelatedCompanyStatisticDO> list =
        // (List<RelatedCompanyStatisticDO>) redisDAO.getObject(key);
        // if (null == list || list.size() == 0) {
        List<RelatedCompanyStatisticDO> list = relatedCompanyStatisticMapper.getChinaMap();
        // if (null != list && list.size() >= 1) {
        // redisDAO.addObject(key, list, Constants.REDIS_10, List.class);
        // }
        // }
        List<Object> resultList = new ArrayList<>();
        for (RelatedCompanyStatisticDO re : list) {
            List<Map<String, Object>> result = new ArrayList<>();
            Map<String, Object> data1 = new LinkedHashMap<>();
            Map<String, Object> data2 = new LinkedHashMap<>();
            data1.put("name", re.getAreaName());
            data1.put("value", re.getRelatedCompany());
            data2.put("name", "??????");
            result.add(data1);
            result.add(data2);
            resultList.add(result);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("SHData", resultList);
        return map;
    }

    @Override
    public Map<String, Object> ChinaMapSubsidiary() {
        List<RelatedSubsidiaryStatisticDO> list = relatedSubsidiaryStatisticMapper.getChinaMapSubsidiary();

        List<Object> resultList = new ArrayList<>();
        for (RelatedSubsidiaryStatisticDO re : list) {
            List<Map<String, Object>> result = new ArrayList<>();
            Map<String, Object> data1 = new LinkedHashMap<>();
            Map<String, Object> data2 = new LinkedHashMap<>();
            data1.put("name", "??????");
            data2.put("name", re.getAreaName());
            data2.put("value", re.getRelatedSubsidiary());
            result.add(data1);
            result.add(data2);
            resultList.add(result);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("SHData1", resultList);
        return map;
    }

    @Override
    public List<List<CompanyAnalysisResultDO>> shMap() {
        // ???????????????????????????????????????????????????????????????????????????
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
    public Map<String, Map> shArea(Integer areaId) {
        List<BuildingNumberInAreaDO> buildingNumberInArea = buildingMapper.countByArea();
        List<CompanyGroupByAreaDO> companyGroupByArea = buildingMapper.companyGroupByArea();
        List<CountCompanyByAreaDO> countCompanyByArea = buildingMapper.countCompanyByArea();

        Map<String, List> companyGroupByAreaMap = new HashMap<>();
        for (CompanyGroupByAreaDO e : companyGroupByArea) {
            if (companyGroupByAreaMap.containsKey(e.getArea())) {
                companyGroupByAreaMap.get(e.getArea()).add(e.getBuildingName());
            } else {
                List<String> companys = new ArrayList<>();
                companys.add(e.getBuildingName());
                companyGroupByAreaMap.put(e.getArea(), companys);
            }
        }

        Map<String, String> countCompanyByAreaMap = new HashMap<>();
        for (CountCompanyByAreaDO e : countCompanyByArea) {
            countCompanyByAreaMap.put(e.getArea(), e.getCount());
        }

        Map<String, Map> rst = new HashMap<>();
        for (BuildingNumberInAreaDO buildingNumberInAreaDO : buildingNumberInArea) {
            Map<String, Object> data = new HashMap<>();
            data.put("num", buildingNumberInAreaDO.getCount());
            data.put("areaId", buildingNumberInAreaDO.getAreaId());
            if (areaId != null) {
                data.put("permission", areaId.equals(buildingNumberInAreaDO.getAreaId()));
            } else {
                data.put("permission", true);
            }
            data.put("buildingName", companyGroupByAreaMap.get(buildingNumberInAreaDO.getName()));
            data.put("companyNum", countCompanyByAreaMap.get(buildingNumberInAreaDO.getName()));
            rst.put(buildingNumberInAreaDO.getName(), data);
        }
        return rst;
    }

    /**
     * ????????????--?????????????????????????????????
     *
     * @return
     */
    @Override
    public Map<String, Object> shMapMonitor() {
        Map<String, Object> data = realTimeMonitorDao.shMapMonitor();
        return data;
    }

}
