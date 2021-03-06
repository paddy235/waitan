package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndexDataDO;
import com.bbd.wtyh.domain.StaticRiskDataDO;
import com.bbd.wtyh.domain.dto.StaticRiskDTO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StaticRiskMapper {

    public List<StatisticsVO> queryIndStatistics(Map<String, Object> params);

    public List<StatisticsVO> queryIndStsSJKZR(Map<String, Object> params);

    public List<StatisticsVO> queryIndStsGSKZLJ(Map<String, Object> params);

    public List<StatisticsVO> queryIndStsZXJJH(Map<String, Object> params);

    public List<StatisticsVO> queryIndStsFFRZYS(Map<String, Object> params);

    public List<StatisticsVO> queryIndStsDQZL(Map<String, Object> params);

    public List<StatisticsVO> queryIndStsFFRZWG(Map<String, Object> params);

    public List<StatisticsVO> queryIndStsRCJG(Map<String, Object> params);

    public StatisticsVO queryComStatistics(Map<String, Object> params);

    public StatisticsVO queryComStsSJKZR(Map<String, Object> params);

    public StatisticsVO queryComStsGSKZLJ(Map<String, Object> params);

    public StatisticsVO queryComStsZXJJH(Map<String, Object> params);

    public StatisticsVO queryComStsFFRZYS(Map<String, Object> params);

    public StatisticsVO queryComStsDQZL(Map<String, Object> params);

    public StatisticsVO queryComStsFFRZWG(Map<String, Object> params);

    public StatisticsVO queryComStsRCJG(Map<String, Object> params);

    public StaticRiskDTO queryLastStaticRisk(Map<String, Object> params);

    List<StaticRiskDTO> getSpectrumAnalysis(@Param("low") Integer low, @Param("upper") Integer upper, @Param("normal_flag")boolean normal_flag);

    public List<String> queryDateVersion(Map<String, Object> params);

    String maxDataVersion();

    void save(StaticRiskDataDO staticRiskDataDO);

    String queryDateVersionByMonth(Map<String, Object> params);

    Float queryStaticsRiskIndex(String companyName);

    Float queryCapitalBgRisk(String companyName);

    StaticRiskDataDO queryStaticsRiskData(String companyName);

    String getNewestDataVersion();

    int getDataVersionCount(Map<String, Object> params);

    public void update(StaticRiskDataDO staticRiskDataDO);

    List<StaticRiskDataDO> findByPage(Map<String, Object> params);
}