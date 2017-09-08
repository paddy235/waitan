package com.bbd.wtyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;

/**
 * 
 * Created by cgj on 2017/9/6.
 */
public interface QyxxTagMapper {

    @Select("SELECT IFNULL(MAX(dt), 0 ) FROM qyxx_tag")
    int maxDataVersion();

    @Select("TRUNCATE ${tbName}")
    void clearTable(@Param("tbName") String tableName);

    @Select("DROP TABLE ${tbName}")
    void deleteTable(@Param("tbName") String tableName);

    @Select("RENAME TABLE ${tbName} TO ${newName}")
    void renameTable(@Param("tbName") String tableName, @Param("newName") String newName);

    /*@Select("Create table ${newTable} ( Select * from ${oldTable} )")
    void oldTableIntoNewTable(@Param("oldTable") String oldTable, @Param("newTable") String newTable);*/

    /*@Select("SELECT * FROM (SELECT * FROM plat_list ORDER BY create_date DESC LIMIT 99999999999999) T" + " GROUP BY T.plat_name")
    @Results({ @Result(column = "plat_name", property = "plat_name"), @Result(column = "company_name", property = "company_name"),
            @Result(column = "logo_url", property = "logo_url"), @Result(column = "area_id", property = "area_id") })
    List<PlatListDO> getPlatListFromDb();

    @Select("SELECT * FROM plat_list WHERE `plat_name` =#{platName} ORDER BY create_date DESC LIMIT 1")
    @Results({ @Result(column = "plat_name", property = "plat_name"), @Result(column = "company_name", property = "company_name"),
            @Result(column = "logo_url", property = "logo_url"), @Result(column = "area_id", property = "area_id") })
    PlatListDO queryPlatByPlatName(@Param("platName") String platName);

    @Select("SELECT count(1) FROM (SELECT count(1) AS total FROM ktgg kt JOIN  qyxx_basic qb ON qb.bbd_qyxx_id = kt.bbd_qyxx_id AND qb.company_name = #{coName} GROUP by kt.id) t")
    Long countKtgg(@Param("coName") String companyName);*/

}
