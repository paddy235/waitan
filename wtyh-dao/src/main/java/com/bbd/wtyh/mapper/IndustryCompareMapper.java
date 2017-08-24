package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndustryCompareDO;
import com.bbd.wtyh.domain.dto.IndustryCompareDTO;
import com.bbd.wtyh.domain.dto.IndustryProblemDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lixudong on 2017/7/11.
 */
public interface IndustryCompareMapper {

    void save(IndustryCompareDO industryCompareDO);

    void deleteByDateArea(@Param("date")String date,@Param("area") String area);

    @Select("SELECT * FROM industry_compare ORDER BY create_date DESC LIMIT 2")
    @Results({
            @Result(column = "balance_loans", property = "balance_loans")
    })
    List<IndustryCompareDTO> getIndustryCompareFromDb();

}
