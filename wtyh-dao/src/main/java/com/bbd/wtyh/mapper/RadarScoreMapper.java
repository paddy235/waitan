package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.RadarScoreDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/13.
 */
public interface RadarScoreMapper {

    void save(RadarScoreDO radarScoreDO);

    void deleteByPlatName(@Param("platName")String platName);
}
