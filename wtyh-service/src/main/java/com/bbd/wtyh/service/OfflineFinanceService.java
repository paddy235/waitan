package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.vo.StaticRiskVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;

import java.math.BigDecimal;
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
    public RelationDiagramVO queryRelation(String companyName, String dataVersion, String degreesLevel) throws Exception;

    /**
     * 公司舆情
     * @param companyName
     * @return
     */
    public String companyNews(String companyName);

    /**
     * 静态风险指数构成
     * @param companyName
     * @return
     */
    public Map staticRiskIndex(String companyName);

    /**
     * 风险指数趋势变化图
     * @param companyName
     * @param tabIndex
     * @param areaCode
     * @return
     */
    public List<StatisticsVO> queryStatistics(String companyName, String tabIndex, String areaCode) throws ParseException;

    public StaticRiskVO queryCurrentStaticRisk(String companyName, String currentDate, String areaCode);

    public String createYED(String companyName, String month) throws Exception;

    Map companyInfo(String companyName);

    public void updateCompanyRiskLevel();

    public void updateIndexData(String companyName);

    public void updateStaticRiskData(String companyName, String dataVersion);

    public BigDecimal getSRI(BigDecimal staticRiskIndex, String companyName);

    void saveCompanyCreditRisk();
}
