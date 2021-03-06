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
    @Select("SELECT o.companyName FROM offline_financial_white o WHERE 1 = 1 AND NOT EXISTS (SELECT 1 FROM company_modify c WHERE o.companyName = c. NAME AND c.afterLevel IS NOT NULL AND c.afterLevel != 'null')\n" +
            "AND NOT EXISTS (SELECT 1 FROM company cm WHERE o.companyId = cm.company_id AND cm.company_type = 4 AND cm.risk_level = 1)")
    List<String> WhiteCompanyList();

    @Select("select risk_level from company where name = '${companyName}'")
    Integer selectOldRiskLevel (@Param("companyName") String companyName);
    //更新company表中的公司风险等级
    @Update("update company set previous_risk_level = ${old_risk_level},risk_level = ${risk_level},update_date=now(),update_by='offlineFinanceRiskLevelCalcJob' where name = '${companyName}'")
    void updateCompanyRisk_level(@Param("companyName") String companyName,@Param("risk_level") int risk_level,@Param("old_risk_level") Integer old_risk_level);

    //前1~200家企业名单 LIMIT 0,200
    //201~1000家企业名单 LIMIT 200,800
    @Select("SELECT a.company_name FROM index_data a INNER JOIN offline_financial_white b ON a.company_name = b.companyName  AND NOT EXISTS (SELECT 1 FROM company_modify c WHERE b.companyName = c. NAME AND c.afterLevel IS NOT NULL AND c.afterLevel != 'null') AND NOT EXISTS (SELECT 1 FROM company cm WHERE b.companyId = cm.company_id AND cm.risk_level = 1) ORDER BY a.static_risk_index desc LIMIT ${start},${size}")
    List<String> find(@Param("start") int start, @Param("size")int size);

    //5万家白名单企业的公信中心数据包含：限制出境、限制高消费和网上追讨的公司名单
    @Select("select a.company_name from company_credit_raw_info a INNER JOIN offline_financial_white b ON a.company_name = b.companyName WHERE " +
            " NOT EXISTS (SELECT 1 FROM company cm WHERE a.company_name = cm.`name` AND cm.risk_level = 1) AND ( a.resource_name ='民事执行-限制出境' or resource_name ='民事执行-网上追查' or resource_name ='民事执行-限制高消费令')")
    List<String> query_raw_info();

    //把company表中线下企业不是白名单的企业风险等级设置成null
    @Update("update company c set c.risk_level = null,update_date=now(),update_by='offlineFinanceRiskLevelCalcJob' WHERE c.company_type = 4 AND c.risk_level != 1 AND  NOT EXISTS (SELECT 1 FROM offline_financial_white o WHERE o.companyId = c.company_id)")
    void updateCompanyIsNotWhite();
}
