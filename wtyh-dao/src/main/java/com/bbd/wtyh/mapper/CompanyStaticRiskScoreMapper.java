package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.CompanyStaticRiskScoreDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 查询bbd线下理财信息
     *
     * @param newDataVersion 最新的版本
     *
     * */

    List<CompanyStaticRiskScoreDO> getOfflineCompanyInfo(@Param(value = "newDataVersion") String newDataVersion);


    /**
     * 存储风险值
     * */

    int updateStaticRisk(@Param(value = "dataVersion") String dataVersion ,@Param(value = "companyName") String companyName ,@Param(value = "index") float index);

}
