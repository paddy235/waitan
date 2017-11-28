package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;
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
    void updateCompanyRisk_level(@Param("companyName") String companyName,@Param("risk_level") int risk_level);

    //前1~200家企业名单 LIMIT 0,200
    //201~1000家企业名单 LIMIT 200,800
    @Select("SELECT a.company_name FROM index_data a INNER JOIN offline_financial_white b ON a.company_name = b.companyName ORDER BY a.static_risk_index desc LIMIT ${start},${size}")
    List<String> find(@Param("start") int start, @Param("size")int size);

    //5万家白名单企业的公信中心数据包含：限制出境、限制高消费和网上追讨的公司名单
    @Select("select a.company_name from company_credit_raw_info a INNER JOIN offline_financial_white b ON a.company_name = b.companyName WHERE a.resource_name ='限制出境' or resource_name ='限制高消费' or resource_name ='网上追讨'")
    List<String> query_raw_info();

    //把company表中线下企业不是白名单的企业风险等级设置成null
    @Update("update company c set c.risk_level = null WHERE c.company_type = 4 AND  NOT EXISTS (SELECT 1 FROM offline_financial_white o WHERE o.companyId = c.company_id)")
    void updateCompanyIsNotWhite();
}
