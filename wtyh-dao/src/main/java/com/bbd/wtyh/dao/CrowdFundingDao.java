package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.dto.RelationDTO;
import com.bbd.wtyh.domain.wangDaiAPI.CrowdFundingStatisticsDTO;
import com.bbd.wtyh.web.relationVO.SubGraphVO;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface CrowdFundingDao {
    /**
     *
     * @param
     */
    List<CrowdFundingCompanyDO> allCompanys();

    Map<String, String> lastMonthType(String dataType);
}
