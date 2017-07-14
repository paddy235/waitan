package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PlatCoreDataDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/12.
 */
public interface PlatCoreDataMapper {

    void save(PlatCoreDataDO platCoreDataDO);

    void deleteByPlatName(@Param("platName")String platName);
}
