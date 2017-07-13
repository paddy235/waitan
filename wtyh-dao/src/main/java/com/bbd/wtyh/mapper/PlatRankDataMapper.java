package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PlatRankDataDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/11.
 */
public interface PlatRankDataMapper {

    void save(PlatRankDataDO platRankDataDO);

    void deleteByPlatName(@Param("platName")String platName);
}
