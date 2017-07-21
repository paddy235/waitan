package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CrowdFundingCommonDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/19.
 */
public interface CrowdFundingCommonMapper {

    void save(CrowdFundingCommonDO crowdFundingCommonDO);

    void deleteByType(@Param("type")String type);
}

