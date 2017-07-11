package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndustryShanghaiAreaDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/11.
 */
public interface IndustryShanghaiAreaMapper {

    void save(IndustryShanghaiAreaDO industryShanghaiAreaDO);

    void deleteByDate(@Param("date") String date);
}
