package com.bbd.wtyh.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author:WLL
 * @Date:Create on 9:532017/11/21
 */
public interface UpdateWhiteCompanyRiskGradeMapper {
    //白名单企业名称
    @Select("select companyName from offline_financial_white")
    List<String> WhiteCompanyList();

    //更新company表中的公司风险等级
    @Update("update company set risk_level = ${risk_level} where name = '${companyName}'")
    void updateCompanyRisk_level(@Param("companyName") String companyName, @Param("risk_level") int risk_level);

    //前1~200家企业名单
    //201~1000家企业名单
    @Select("SELECT company_name FROM static_risk_data WHERE EXISTS (SELECT * FROM (select b.company_name, MAX(b.data_version) maxtime,b.static_risk_index from static_risk_data  b INNER JOIN offline_financial_white a on b.company_name=a.companyName GROUP BY b.company_name ) x WHERE x.company_name = static_risk_data.company_name AND x.maxtime = static_risk_data.data_version) ORDER BY static_risk_index DESC LIMIT ${start},${size}")
    List<String> find(@Param("start") int start, @Param("size") int size);

    //5万家白名单企业的公信中心数据包含：限制出境、限制高消费和网上追讨的公司名单
    @Select("select a.company_name from company_credit_raw_info a INNER JOIN offline_financial_white b ON a.company_name = b.companyName WHERE a.resource_name ='限制出境' or resource_name ='限制高消费' or resource_name ='网上追讨'")
    List<String> query_raw_info();
}
