package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndustryShanghaiDO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lixudong on 2017/7/11.
 */
public interface IndustryShanghaiMapper {

     void save(IndustryShanghaiDO industryShanghaiDO);

     void deleteByDate(@Param("date") String date);

     @Select("SELECT * FROM industry_shanghai ORDER BY create_date DESC LIMIT 6")
     @Results({
             @Result(column = "total_plat_num", property = "total_plat_num"),
             @Result(column = "new_plat_num", property = "new_plat_num"),
             @Result(column = "interest_rate", property = "interest_rate"),
             @Result(column = "borrowed_num", property = "borrowed_num"),
             @Result(column = "invest_num", property = "invest_num"),
             @Result(column = "area_num", property = "areaNumJs")
     })
     List<IndustryShanghaiDTO> getIndustryShanghaiFromDb();
}
