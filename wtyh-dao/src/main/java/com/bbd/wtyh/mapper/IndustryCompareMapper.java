package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndustryCompareDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/11.
 */
public interface IndustryCompareMapper {

    void save(IndustryCompareDO industryCompareDO);

    void deleteByDateArea(@Param("date")String date,@Param("area") String area);

}
