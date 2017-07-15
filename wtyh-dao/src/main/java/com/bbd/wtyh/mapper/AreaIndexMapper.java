package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.AreaIndexDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/12.
 */
public interface AreaIndexMapper {

    void save(AreaIndexDO areaIndexDO);

    void deleteByArea(@Param("area") String area);
}
