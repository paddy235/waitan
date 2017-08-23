package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.AreaIndexDO;
import com.bbd.wtyh.domain.dto.AreaIndexDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lixudong on 2017/7/12.
 */
public interface AreaIndexMapper {

    void save(AreaIndexDO areaIndexDO);

    void deleteByArea(@Param("area") String area);

    @Select("SELECT * FROM (SELECT * FROM area_index ORDER BY create_date DESC LIMIT 99999999999999) T" +
            " GROUP BY T.area ORDER BY T.rank")
    /*@Results({
            @Result(column = "competitiveness", property = "competitiveness"),
            @Result(column = "area", property = "area")
    })*/
    List<AreaIndexDTO> getAreaIndexFromDb();
}
