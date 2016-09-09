package com.bbd.wtyh.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.LoanBalanceDTO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesLinesBean;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import java.util.*;

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
    private JedisPool jedisPool;

    @Autowired
    private RedisDAO redisDAO;


    /**
     * 光谱分析 - 只做标识，前端区分
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysis")
    @ResponseBody
    public ResponseBean spectrumAnalysis() {
//        final String key = "wtyh:realtimeMonitor:guangPu1";
//        List<List> list = (List<List>) redisDAO.getObject(key);
//        if (null == list || list.size() == 0) {
        List<List> list = realTimeMonitorService.spectrumAnalysis();
//            if (null != list && list.size() >= 1) {
////                redisDAO.addSet(key, String.valueOf(list), Constants.REDIS_10);
//                redisDAO.addObject(key, list, Constants.REDIS_10, List.class);
//            }
//        }
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
        return ResponseBean.successResponse(content);

    }

    /**
     * 全国地图 - 子公司
     *
     * @return
     */
    @RequestMapping("/ChinaMapSubsidiary")
    @ResponseBody
    public ResponseBean ChinaMapSubsidiary() {
        Map<String, Object> content = realTimeMonitorService.ChinaMapSubsidiary();
        return ResponseBean.successResponse(content);

    }

    /**
     * 上海地图
     *
     * @return
     */
    @RequestMapping("/shMap")
    @ResponseBody
    public ResponseBean shMap() {
        final String key = "wtyh:realtimeMonitor:shMap1";
        List<List<CompanyAnalysisResultDO>> list = (List<List<CompanyAnalysisResultDO>>) redisDAO.getObject(key);
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
        for (List<CompanyAnalysisResultDO> l : list) {
            for (CompanyAnalysisResultDO companyAnalysisResultDO : l) {
                sHposition.put(companyAnalysisResultDO.getName(), Arrays.asList(companyAnalysisResultDO.getLongitude(), companyAnalysisResultDO.getLatitude()));

                Map<String, String> eSHsereis = new HashMap<>();
                eSHsereis.put("name", companyAnalysisResultDO.getName());
                eSHsereis.put("value", String.valueOf(companyAnalysisResultDO.getAnalysisResult()));
                sHsereis.add(eSHsereis);

                if (companyAnalysisResultDO.getAnalysisResult() == CompanyAnalysisResultDO.EXPOSURE) {
                    sHhoverDot.put(companyAnalysisResultDO.getName(), companyAnalysisResultDO.getExposureDate());
                } else {
                    sHhoverDot.put(companyAnalysisResultDO.getName(), companyAnalysisResultDO.getStaticRiskIndex());
                }
            }
        }
        final String key2 = "wtyh:realtimeMonitor:shMap2";
        Map<String, Map> sHhoverArea = (Map<String, Map>) redisDAO.getObject(key2);
        if (null == sHhoverArea || sHhoverArea.size() == 0) {
            sHhoverArea = realTimeMonitorService.shArea();
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
