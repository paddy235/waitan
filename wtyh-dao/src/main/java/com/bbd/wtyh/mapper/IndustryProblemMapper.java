package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndustryProblemDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/15.
 */
public interface IndustryProblemMapper {

    void save(IndustryProblemDO industryProblemDO);

    void deleteByDateArea(@Param("date")String date,@Param("area")String area);
}
