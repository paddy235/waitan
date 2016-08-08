package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

/**
 * 线下理财接口层
 * @author zhouxuan
 * @since 2016.08.05
 */
public interface OfflineFinanceService {
    /**
     * 关联方图谱
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List<Map> relatedGraph();

    /**
     * 公司舆情
     * @param companyName
     * @return
     */
    public List<Map> companyNews(String companyName);

    /**
     * 静态风险指数构成
     * @param companyName
     * @return
     */
    public List<Map> staticRiskIndex(String companyName);

    /**
     * 静态风险指数列表
     * @param companyName
     * @return
     */
    public List<Map> staticRiskList(String companyName);

    /**
     * 风险指数趋势变化图
     * @param riskTypeId
     * @return
     */
    public List<Map> riskTrendGraph(Integer riskTypeId);

    /**
     * 动态指数时间轴对比图
     * @param companyName
     * @param dateA
     * @param dateB
     * @return
     */
    List<Map> dynamicComparisonChart(String companyName, String dateA, String dateB);

    /**
     * 企业关联方特征指数对比
     * @param companyName
     * @param dateA
     * @param dateB
     * @return
     */
    public List<Map> companyRelatedComparisonChart(String companyName, String dateA, String dateB);

    public String getRelationFromKunLun(String companyName, String level, String version);

}
