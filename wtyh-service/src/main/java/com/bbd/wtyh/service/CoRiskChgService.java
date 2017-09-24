package com.bbd.wtyh.service;

import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;

import java.util.List;
import java.util.Map;

/**
 * 企业变化监测-风险变化企业
 *
 * @author Created by LiYao on 2017-04-19 16:45.
 */
public interface CoRiskChgService extends BaseService {

    /**
     * 企业变化监测-风险变化企业-所有楼宇
     * 
     * @return
     * @param areaSet
     */
    List<Map<String, Object>> riskChgCoBuilding(String areaSet);

    /**
     * 查询分页数据
     * 
     * @param paramMap
     * @param page
     * @return
     */
    List<RiskChgCoDo> queryPageData(Map<String, String> paramMap, Pagination page);

    /**
     * 查询所有数据
     * 
     * @param paramMap
     * @return
     */
    List<RiskChgCoDo> queryAllData(Map<String, String> paramMap);

    /**
     * 生成一条新的记录。<br>
     * modifyData 中的level,innerLevel,outLevel,liveLevel字段。 除了公司类型为网络借贷（保持中文描述不变）以外，应该全部转为数值形式的字符串。
     * 
     * @param modifyData
     * @see ModifyData
     * @param createBy 记录创建人
     * @param riskChgCoSource 来源，枚举类
     * @return RiskChgCoDo 不为空表示风险状态有变化。为空表示风险状态没有变化
     */
    RiskChgCoDo generateNewRecord(ModifyData modifyData, String createBy, RiskChgCoSource riskChgCoSource);
}
