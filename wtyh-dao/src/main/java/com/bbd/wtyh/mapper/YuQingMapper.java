package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/7.
 */
public interface YuQingMapper {

    void save(YuQingDO yuQingDO);

    void deleteByPlatName(@Param("platName")String platName);

}
