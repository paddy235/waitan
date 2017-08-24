package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndustryProblemDO;
import com.bbd.wtyh.domain.dto.IndustryProblemDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lixudong on 2017/7/15.
 */
public interface IndustryProblemMapper {

    void save(IndustryProblemDO industryProblemDO);

    void deleteByDateArea(@Param("date")String date,@Param("area")String area);

    @Select("SELECT * FROM industry_problem ORDER BY create_date DESC LIMIT 12")
    @Results({
            @Result(column = "problem_plat_number", property = "problem_plat_number")
    })
    List<IndustryProblemDTO> getIndustryProblemFromDb();
}
