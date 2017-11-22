package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.BbdSubIndexDO;
import com.bbd.wtyh.domain.CompanyStaticRiskScoreDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by puyuan on 2017/11/16
 */
public interface CompanyStaticRiskScoreMapper {

    /**
     * 查询上海本地工信指标指标
     * @param resourceName 资源名称
     *
     * @param companyId  公司id
     * */
    int getShanghaitarget(@Param(value = "resourceName") String resourceName ,@Param(value = "companyId") Integer companyId);


    /**
     * 查询最新的数据版本
     * */
    String getNewDataVersion();

    /**
     * 分页查询bbd线下理财信息
     *
     * */

    List<CompanyStaticRiskScoreDO> findByPage(Map<String, Object> params);


    /**
     * 存储风险值
     * */

    int updateStaticRisk(@Param(value = "companyName") String companyName,@Param(value = "dataVersion") String dataVersion ,@Param(value = "index") float index);

    /**
     * 存储指标值
     * */
    int updateSubIndex(BbdSubIndexDO bbdSubIndexDO);


    /**
     * 查询公司数量
     * */

    int findCompanyCount(@Param(value = "newDataVersion") String newDataVersion);

    /**
     * 根据公司名称查询
     * */
    List<CompanyStaticRiskScoreDO> findByCompanyName(@Param(value = "companyName") String companyName ,@Param(value = "newDataVersion") String dataVersion);

    /**
     * 查询白名单企业对应资源的数量
     * */
    int getWhiteCompany(@Param(value = "companyId") Integer companyId,@Param(value = "resourceName1") String resourceName1,@Param(value = "resourceName2") String resourceName2,@Param(value = "resourceName3") String resourceName3);

    /**
     * 根据版本号查询bbd的六个值
     * */

    CompanyStaticRiskScoreDO findCompany(@Param(value = "companyId") Integer companyId,@Param(value = "newDataVersion") String dataVersion);


}
