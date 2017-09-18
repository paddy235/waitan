package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.domain.vo.StaticRiskVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;

import java.io.ByteArrayOutputStream;
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
     * 实时查询关联方信息
     *
     * @param companyName 公司名称
     * @param degree      纬度
     */
    RelationDiagramVO queryRealRealation(String companyName,String bbdQyxxId, Integer degree);
    /**
     * 下载关联方图谱
     *
     * @param companyName 公司名称
     * @param degree      纬度
     */
    RelationDiagramVO downloadRealRealation(String companyName, Integer degree);
    /**
     * 从数据库查询关联方信息
     *
     * @param companyName 公司名称
     * @param degree      纬度
     */
    RelationDiagramVO queryRealationFromDb(String companyName, Integer degree);

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

    //获取最新的关联方图谱图片
    public byte[] createNewestYEDtoStream(String companyName);

    Map companyInfo(String companyName, String bbdQyxxId);

    public TaskResultDO updateCompanyRiskLevel(Integer taskId) throws Exception;

    TaskResultDO executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId) throws Exception;

    public void updateIndexData(String companyName);

    public void updateStaticRiskData(String companyName, String dataVersion);

    public BigDecimal getSRI(BigDecimal staticRiskIndex, String companyName);

    void saveCompanyCreditRisk();

    public void stopTask();


}
