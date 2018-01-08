package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.domain.PlatRankDataDO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lixudong on 2017/7/11.
 */
public interface PlatRankDataMapper {

    void save(PlatRankDataDO platRankDataDO);

    void deleteByPlatName(@Param("platName")String platName);

    WangdaiModify getWangdaiModify(@Param("platName")String platName);

    @Select(" SELECT company.area_id,T1.plat_name,T1.amount,T1.income_rate,T1.loan_period,T1.stay_still_of_total,T1.plat_status,T1.registered_address from (" +
            " SELECT * FROM (SELECT * FROM plat_rank_data ORDER BY create_date DESC LIMIT 99999999999999) T " +
            "            GROUP BY T.plat_name ORDER BY T.rank) T1 LEFT JOIN ( " +
            "    SELECT * FROM ( SELECT * FROM plat_list where 1 = 1 " +
            "    ORDER BY  create_date DESC  LIMIT 99999999999999  ) T  GROUP BY   T.plat_name)T2 " +
            " on T1.plat_name=T2.plat_name " +
            " LEFT JOIN company on company.`name`= T2.company_name ")
    @Results({
            @Result(column = "plat_name", property = "plat_name"),
            @Result(column = "income_rate", property = "income_rate"),
            @Result(column = "loan_period", property = "loan_period"),
            @Result(column = "stay_still_of_total", property = "stay_still_of_total"),
            @Result(column = "plat_status", property = "plat_status"),
            @Result(column = "registered_address", property = "registered_address"),
            @Result(column = "area_id", property = "area_id")
    })
    List<PlatRankDataDTO> getPlatRankData();

}
