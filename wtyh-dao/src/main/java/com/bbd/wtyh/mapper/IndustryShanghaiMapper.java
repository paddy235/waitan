package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndustryShanghaiDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/11.
 */
public interface IndustryShanghaiMapper {

     void save(IndustryShanghaiDO industryShanghaiDO);

     void deleteByDate(@Param("date") String date);
}
