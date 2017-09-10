package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.SubscriptionListDO;
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

    /**
     * 取tag表中数据的最大版本
     * @return
     */
    @Select("SELECT IFNULL( MAX(dt), 0 ) FROM qyxx_tag")
    int maxDataVersion();

    /**
     * 清空指定表
     * @param tableName
     */
    @Select("TRUNCATE ${tbName}")
    void clearTable(@Param("tbName") String tableName);

    /**
     * 删除指定表
     * @param tableName
     */
    @Select("DROP TABLE ${tbName}")
    void deleteTable(@Param("tbName") String tableName);

    /**
     * 重命名指定表
     * @param tableName
     * @param newName
     */
    @Select("RENAME TABLE ${tbName} TO ${newName}")
    void renameTable(@Param("tbName") String tableName, @Param("newName") String newName);

    /**
     * 将tag表中的company_name字段去重后插入到subscription_list表中
     */
    @Select("INSERT INTO subscription_list(`company_name`) SELECT distinct `company_name` FROM qyxx_tag")
    void companyNameTagToSubscriptionList( );

    /**
     * 找出qyxx_tag表中有subscription_list表中没有的`company_name`去重后存入subscription_list_append表中
     */
    @Select("INSERT INTO subscription_list_append(`company_name`) SELECT distinct `company_name` FROM " +
     "qyxx_tag as qt WHERE NOT EXISTS (SELECT * FROM subscription_list WHERE qt.company_name = company_name)")
    void companyNameToSubscriptionListAppend( );


    /**
     * 找出subscription_list表中有qyxx_tag表中没有的`company_name`去重后存入subscription_list_remove表中
     */
    @Select("INSERT INTO subscription_list_remove(`company_name`) SELECT distinct `company_name` FROM " +
     "subscription_list as sl WHERE NOT EXISTS (SELECT * FROM  qyxx_tag WHERE sl.company_name = company_name)")
    void companyNameToSubscriptionListRemove( );

    /**
     * 找出qyxx_tag表中有subscription_list表中没有的`company_name`去重后添加到subscription_list表中
     */
    @Select("INSERT INTO subscription_list(`company_name`) SELECT distinct `company_name` FROM " +
            "qyxx_tag as qt WHERE NOT EXISTS (SELECT * FROM subscription_list WHERE qt.company_name = company_name)")
    void companyNameAppendSubscriptionList( );

     //复制表
    @Select("Create table ${newTable} ( Select * from ${currTable} )")
    void currTableIntoNewTable(@Param("currTable") String currTable, @Param("newTable") String newTable);

    //获取待新增的企业名单列表
    @Select("SELECT * FROM `subscription_list_append` Limit 1000000")
    @Results({ @Result(column = "company_name", property = "companyName") })
    List<SubscriptionListDO> getCompanyNamesFromSubscriptionListAppend();


    /*@Select("SELECT * FROM (SELECT * FROM plat_list ORDER BY create_date DESC LIMIT 99999999999999) T" + " GROUP BY T.plat_name")
    @Results({ @Result(column = "plat_name", property = "plat_name"), @Result(column = "company_name", property = "company_name"),
            @Result(column = "logo_url", property = "logo_url"), @Result(column = "area_id", property = "area_id") })
    List<PlatListDO> getPlatListFromDb();

    @Select("SELECT count(1) FROM (SELECT count(1) AS total FROM ktgg kt JOIN  qyxx_basic qb ON qb.bbd_qyxx_id = kt.bbd_qyxx_id AND qb.company_name = #{coName} GROUP by kt.id) t")
    Long countKtgg(@Param("coName") String companyName);*/

}
