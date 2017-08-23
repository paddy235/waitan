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

     /*@Select("SELECT * FROM (SELECT * FROM area_index ORDER BY create_date DESC LIMIT 99999999999999) T" +
             " GROUP BY T.area ORDER BY T.rank")
     @Results({
             @Result(column = "competitiveness", property = "competitiveness"),
             @Result(column = "area", property = "area")
     })
     List<IndustryShanghaiDTO> getIndustryShanghaiFromDb();*/
}
