package com.bbd.wtyh.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.domain.CapitalAmountDO;
import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.MortgageStatisticDO;
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


    /**
     * 光谱分析 - 只做标识，前端区分
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysis")
    @ResponseBody
    public ResponseBean spectrumAnalysis() {
        List<List> content = realTimeMonitorService.spectrumAnalysis();
        return ResponseBean.successResponse(content);
    }

    /**
     * 全国地图
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
     * 上海地图
     *
     * @return
     */
    @RequestMapping("/shMap")
    @ResponseBody
    public ResponseBean shMap() {
        List<List<CompanyAnalysisResultDO>> content = realTimeMonitorService.shMap();
        // 返回值结构
        Map<String, List> sHposition = new HashMap<>();
        List<Map> sHsereis = new ArrayList<>();
        Map<String, String> sHhoverDot = new HashMap<>();
        for (List<CompanyAnalysisResultDO> l : content) {
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
        Map<String, Map> sHhoverArea = realTimeMonitorService.shArea();
        Map<String, Object> rst = new HashMap<>();
        rst.put("SHposition", sHposition);
        rst.put("SHsereis", sHsereis);
        rst.put("SHhoverDot", sHhoverDot);
        rst.put("SHhoverArea", sHhoverArea);
        String rstJson = JSON.toJSONString(rst);
        final String key = "wtyh:realtimeMonitor:shMap";
        if (jedisPool.getResource().get(key) == null) {
            jedisPool.getResource().set(key, rstJson);
            return ResponseBean.successResponse(rst);
        } else {
            String rstJsonRedis = jedisPool.getResource().get(key);
            //parse Json
            JSONObject jsonObject = JSON.parseObject(rstJsonRedis);
            Map<String, Object> map = new HashMap<>();
            map.put("SHposition", jsonObject.get("SHposition"));
            map.put("SHsereis", jsonObject.get("SHsereis"));
            map.put("SHhoverDot", jsonObject.get("SHhoverDot"));
            map.put("SHhoverArea", jsonObject.get("SHhoverArea"));
            return ResponseBean.successResponse(map);
        }
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
