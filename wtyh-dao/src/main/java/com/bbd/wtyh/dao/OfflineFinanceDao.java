package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.dto.RelationDTO;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import com.bbd.wtyh.web.relationVO.SubGraphVO;


/**
 *
 */
public interface OfflineFinanceDao {
    /**
     * 实时查询关联方信息
     *
     * @param companyName
     */
    RelationDTO queryRealation(String companyName, String dateVersion);

    /**
     * 获取实时关联方数据
     *
     * @param unikey 公司唯一id
     * @param degree 纬度
     */
    SubGraphVO queryRealTimeRelation(String unikey, String degree);
    /**
     * 获取关联方数据
     *
     * @param companyName 公司名称
     * @param degree 纬度
     */
    RelationDiagramVO queryRealationFromDb(String companyName,String bbdQyxxId, Integer degree);
}
