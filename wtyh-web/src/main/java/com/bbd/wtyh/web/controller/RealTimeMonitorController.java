package com.bbd.wtyh.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.vo.SpectrumVO;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.RealTimeMonitorService;
import com.bbd.wtyh.web.ResponseBean;

import redis.clients.jedis.JedisPool;

/**
 * 实时监控页面
 *
 * @author yanwenyuan
 * @since 2016.08.13
 */
@Controller
@RequestMapping("/realTimeMonitor")
public class RealTimeMonitorController {
    @Autowired
    private RealTimeMonitorService realTimeMonitorService;

    @Autowired
    private JedisPool              jedisPool;

    @Autowired
    private RedisDAO               redisDAO;

    @Autowired
    private AreaService            areaService;

    /**
     * 光谱分析 - 只做标识，前端区分
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysis")
    @ResponseBody
    @LogRecord(logMsg = "实时监测页面", page = Operation.Page.home, type = Operation.Type.query, before = true)
    public ResponseBean spectrumAnalysis(HttpSession session) {

        Integer areaId = areaService.getAreaId(session);

        final String key = "wtyh:realtimeMonitor:guangPu1" + areaId;

        List<List<SpectrumVO>> list = (List<List<SpectrumVO>>) redisDAO.getObject(key);
        if (null == list || list.size() == 0) {
            list = realTimeMonitorService.spectrumAnalysis(areaId);

            if (null != list && list.size() >= 1) {
                for (List<SpectrumVO> spectrumVOList : list) {
                    for (SpectrumVO spectrumVO1 : spectrumVOList) {
                        spectrumVO1.setLocation(
                            Arrays.asList(spectrumVO1.getLongitude(), spectrumVO1.getLatitude()));
                    }
                }
                //                redisDAO.addSet(key, String.valueOf(list), Constants.REDIS_10);
                redisDAO.addObject(key, list, Constants.REDIS_10, List.class);
            }
        }
        return ResponseBean.successResponse(list);
    }

    /**
     * 全国地图 - 股东
     *
     * @return
     */
    @RequestMapping("/ChinaMap")
    @ResponseBody
    public ResponseBean ChinaMap() {
        Map<String, Object> content = realTimeMonitorService.ChinaMap();
        Map<String, Object> content1 = realTimeMonitorService.ChinaMapSubsidiary();
        content.putAll(content1);
        return ResponseBean.successResponse(content);

    }

    /**
     * 上海地图
     *
     * @return
     */
    @RequestMapping("/shMap")
    @ResponseBody
    public ResponseBean shMap(HttpSession session) {
        final String key = "wtyh:realtimeMonitor:shMap1";
        List<List<CompanyAnalysisResultDO>> list = (List<List<CompanyAnalysisResultDO>>) redisDAO
            .getObject(key);
        if (null == list || list.size() == 0) {
            list = realTimeMonitorService.shMap();
            if (null != list && list.size() >= 1) {
                redisDAO.addObject(key, list, Constants.REDIS_10, List.class);
            }
        }
        // 返回值结构
        Map<String, List> sHposition = new HashMap<>();
        List<Map> sHsereis = new ArrayList<>();
        Map<String, String> sHhoverDot = new HashMap<>();
        if (ListUtil.isNotEmpty(list)) {
            for (List<CompanyAnalysisResultDO> l : list) {
                for (CompanyAnalysisResultDO companyAnalysisResultDO : l) {
                    sHposition.put(companyAnalysisResultDO.getName(),
                        Arrays.asList(companyAnalysisResultDO.getLongitude(),
                            companyAnalysisResultDO.getLatitude()));

                    Map<String, String> eSHsereis = new HashMap<>();
                    eSHsereis.put("name", companyAnalysisResultDO.getName());
                    eSHsereis.put("value",
                        String.valueOf(companyAnalysisResultDO.getAnalysisResult()));
                    sHsereis.add(eSHsereis);

                    if (companyAnalysisResultDO
                        .getAnalysisResult() == CompanyAnalysisResultDO.EXPOSURE) {
                        sHhoverDot.put(companyAnalysisResultDO.getName(),
                            companyAnalysisResultDO.getExposureDate());
                    } else {
                        sHhoverDot.put(companyAnalysisResultDO.getName(),
                            companyAnalysisResultDO.getStaticRiskIndex());
                    }
                }
            }
        }

        Integer areaId = areaService.getAreaId(session);

        final String key2 = "wtyh:realtimeMonitor:shMap2" + areaId;
        Map<String, Map> sHhoverArea = (Map<String, Map>) redisDAO.getObject(key2);
        if (null == sHhoverArea || sHhoverArea.size() == 0) {
            sHhoverArea = realTimeMonitorService.shArea(areaId);
            if (null != sHhoverArea && sHhoverArea.size() >= 1) {
                redisDAO.addObject(key2, sHhoverArea, Constants.REDIS_10, Map.class);
            }
        }
        Map<String, Object> rst = new HashMap<>();
        rst.put("SHposition", sHposition);
        rst.put("SHsereis", sHsereis);
        rst.put("SHhoverDot", sHhoverDot);
        rst.put("SHhoverArea", sHhoverArea);
        return ResponseBean.successResponse(rst);
    }

    /**
     * 上海地图--左上角监测，下面滚动条
     *
     * @return
     */
    @RequestMapping("/shMapMonitorAndRoll")
    @ResponseBody
    public ResponseBean shMapMonitor() {
        Map<String, Object> content = realTimeMonitorService.shMapMonitor();
        return ResponseBean.successResponse(content);
    }

}
