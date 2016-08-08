package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线下理财
 * @author tracy zhou
 * @since 2016.08.05
 */
@Controller
@RequestMapping("/offlineFinance")
public class OfflineFinanceController {

    @Autowired
    private OfflineFinanceService offlineFinanceService;

    /**
     * 关联方图谱
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/relatedGraph")
    @ResponseBody
    public ResponseBean relatedGraph() {
        List<Map> data = offlineFinanceService.relatedGraph();
        Map<String, List> result = new HashMap<>();
        result.put("hello", data);
        return ResponseBean.successResponse(result);
    }

    /**
     * 公司舆情
     * @return
     */
    @SuppressWarnings("companyNews")
    @RequestMapping("/companyNews")
    @ResponseBody
    public ResponseBean companyNews(String companyName) {
        List<Map> data = offlineFinanceService.companyNews(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     * 静态风险指数构成
     * @param companyName
     * @return
     */
    @RequestMapping("/staticRiskIndex")
    @ResponseBody
    public ResponseBean staticRiskIndex(String companyName) {
        List<Map> data = offlineFinanceService.staticRiskIndex(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     * 静态风险指数列表
     * @param companyName
     * @return
     */
    @RequestMapping("/staticRiskList")
    @ResponseBody
    public ResponseBean staticRiskList(String companyName) {
        List<Map> data = offlineFinanceService.staticRiskList(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     * 风险指数趋势变化图
     * @param riskTypeId
     * @return
     */
    @RequestMapping("/riskTrendGraph")
    @ResponseBody
    public ResponseBean riskTrendGraph(Integer riskTypeId) {
        List<Map> data = offlineFinanceService.riskTrendGraph(riskTypeId);
        return ResponseBean.successResponse(data);
    }

    /**
     * 动态指数时间轴对比图
     * @param companyName
     * @param dateA
     * @param dateB
     * @return
     */
    @RequestMapping("/dynamicComparisonChart")
    @ResponseBody
    public ResponseBean dynamicComparisonChart(String companyName, String dateA, String dateB) {
        List<Map> data = offlineFinanceService.dynamicComparisonChart(companyName, dateA, dateB);
        return ResponseBean.successResponse(data);
    }

    /**
     * 企业关联方特征指数对比
     * @param companyName 企业名称
     * @param dateA 对比时间
     * @param dateB 对比时间
     * @param typeId 对比内容
     * @return
     */
    @RequestMapping("/companyRelatedComparisonChart")
    @ResponseBody
    public ResponseBean companyRelatedComparisonChart(String companyName, String dateA, String dateB, Integer typeId) {
        List<Map> data = offlineFinanceService.companyRelatedComparisonChart(companyName, dateA, dateB);
        return ResponseBean.successResponse(data);
    }

}
