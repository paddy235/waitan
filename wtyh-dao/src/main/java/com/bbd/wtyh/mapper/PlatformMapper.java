package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.domain.PlatformDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * Created by lixudong on 2017/7/12.
 */
public interface PlatformMapper {

    void save(PlatformDO platListDO);

    void deleteByPlatName(@Param("platName") String platName);

    void recordWangdai(WangdaiModify companyInfo);

    @Select("SELECT * FROM (SELECT * FROM plat_list ORDER BY create_date DESC LIMIT 99999999999999) T" + " GROUP BY T.plat_name")
    @Results({ @Result(column = "plat_name", property = "plat_name"), @Result(column = "company_name", property = "company_name"),
            @Result(column = "logo_url", property = "logo_url"), @Result(column = "area_id", property = "area_id") })
    List<PlatListDO> getPlatListFromDb();

    @Select("SELECT * FROM plat_list WHERE `plat_name` =#{platName} ORDER BY create_date DESC LIMIT 1")
    @Results({ @Result(column = "plat_name", property = "plat_name"), @Result(column = "company_name", property = "company_name"),
            @Result(column = "logo_url", property = "logo_url"), @Result(column = "area_id", property = "area_id") })
    PlatListDO queryPlatByPlatName(@Param("platName") String platName);

    @Select("SELECT count(1) FROM (SELECT count(1) AS total FROM ktgg kt JOIN  qyxx_basic qb ON qb.bbd_qyxx_id = kt.bbd_qyxx_id AND qb.company_name = #{coName} GROUP by kt.id) t")
    Long countKtgg(@Param("coName") String companyName);

}
