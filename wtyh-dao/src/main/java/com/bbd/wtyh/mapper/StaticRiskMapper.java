package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

}