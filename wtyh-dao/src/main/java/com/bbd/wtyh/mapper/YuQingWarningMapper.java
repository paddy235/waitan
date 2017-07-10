package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.wangDaiAPI.YuQingWarningDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lixudong on 2017/7/9.
 */
public interface YuQingWarningMapper {

    List<YuQingWarningDO> selectByPlatName(@Param("platName") String platName);

    void save(YuQingWarningDO yuQingWarningDO);

    void delByPlatName(@Param("platName") String platName);
}
