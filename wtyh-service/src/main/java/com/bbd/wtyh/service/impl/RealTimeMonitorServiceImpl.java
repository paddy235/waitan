package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.dao.RealTimeMonitorDao;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.StaticRiskDTO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.domain.vo.SpectrumVO;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.RealTimeMonitorService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private CompanyMapper companyMapper;

    @Autowired
    private RealTimeMonitorDao realTimeMonitorDao;

    @Autowired
    private RedisDAO redisDAO;

    private final Integer MAX = null;
    private final Integer EMPHASIS = 70;
    private final Integer USUAL = 60;
    private final Integer MIN = null;
    private final boolean NORMAL_FLAG = true;

    //  2:重点关注(红) 3:一般关注(黄) 4:正常(绿)'，1:已出风险(黑)
    private final Integer FOCUS_LEVEL = 2;
    private final Integer USUAL_LEVEL = 3;
    private final Integer NORMAL_LEVEL = 4;
    private final Integer RISK_LEVEL = 1;

    @Override
    public List<List> spectrumAnalysis() {
        List<SpectrumVO> spectrumAnalysisFocus = companyMapper.getSpectrumAnalysis(FOCUS_LEVEL);
        List<SpectrumVO> spectrumAnalysisUsual = companyMapper.getSpectrumAnalysis(USUAL_LEVEL);
        List<SpectrumVO> spectrumAnalysisNormal = companyMapper.getSpectrumAnalysis(NORMAL_LEVEL);
        List<SpectrumVO> spectrumAnalysisRisk = companyMapper.getSpectrumAnalysis(RISK_LEVEL);

        List<List> rst = new ArrayList<>();
        rst.add(spectrumAnalysisFocus);
        rst.add(spectrumAnalysisUsual);
        rst.add(spectrumAnalysisNormal);
        rst.add(spectrumAnalysisRisk);
        return rst;
    }

    public List<List> spectrumAnalysisBackup() {
        List<StaticRiskDTO> spectrumAnalysisEmphasis = staticRiskMapper.getSpectrumAnalysis(EMPHASIS, MAX, !NORMAL_FLAG);
        List<StaticRiskDTO> spectrumAnalysisUsual = staticRiskMapper.getSpectrumAnalysis(USUAL, EMPHASIS,  !NORMAL_FLAG);
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
        final String key = "wtyh:realtimeMonitor:ChinaMap";
        List<RelatedCompanyStatisticDO> list = (List<RelatedCompanyStatisticDO>) redisDAO.getObject(key);
        if (null == list || list.size() == 0) {
            list = relatedCompanyStatisticMapper.getChinaMap();
            if (null != list && list.size() >= 1) {
                redisDAO.addObject(key, list, Constants.REDIS_10, List.class);
            }
        }
        Map<String, Object> map = new LinkedHashMap<>();
        List<Object> resultList = new ArrayList<>();
        for (RelatedCompanyStatisticDO re : list) {
            List<Map<String, Object>> result = new ArrayList<>();
            Map<String, Object> data1 = new LinkedHashMap<>();
            Map<String, Object> data2 = new LinkedHashMap<>();
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
            data.put("buildingName", companyGroupByAreaMap.get(buildingNumberInAreaDO.getName()));
            data.put("companyNum", countCompanyByAreaMap.get(buildingNumberInAreaDO.getName()));
            rst.put(buildingNumberInAreaDO.getName(), data);
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
