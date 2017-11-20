package com.bbd.wtyh.service;


import com.bbd.wtyh.domain.CompanyStaticRiskScoreDO;
import com.bbd.wtyh.domain.SubIndexDO;

import java.util.List;

/**
 * Created by puyuan on 2017/11/16.
 */
public interface CompanyStaticRiskScoreService {

    /**
     * 获取所有线下理财类企业
     * */
    void updateOffLineCompany(String newDataVersion ,CompanyStaticRiskScoreDO CompanyStaticRiskScoreDO);

    /**
     * 获取10个子指标初始值
     * */
    SubIndexDO searchSubIndex(String newDataVersion , Integer companyId);


}
