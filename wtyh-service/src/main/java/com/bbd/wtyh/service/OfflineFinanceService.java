package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.vo.StaticRiskVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 线下理财接口层
 * @author zhouxuan
 * @since  2016.08.05
 */
public interface OfflineFinanceService {
    /**
     * 关联方图谱
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map<String,List> queryRelation(String companyName, String dataVersion) throws Exception;

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
     * @param companyName
     * @param tabIndex
     * @param areaCode
     * @return
     */
    public List<StatisticsVO> queryStatistics(String companyName, String tabIndex, String areaCode) throws ParseException;

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

    /**
     * 列表展示量化后的风险系数
     * @return
     */
    public List<Map> riskFactor();

    public StaticRiskVO queryCurrentStaticRisk(String companyName, String currentDate, String areaCode);

    public String createYED(String companyName, String month) throws Exception;
}
