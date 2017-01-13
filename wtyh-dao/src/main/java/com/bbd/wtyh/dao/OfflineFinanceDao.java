package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.dto.RelationDTO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
import com.bbd.wtyh.web.relationVO.SubGraphVO;

import java.util.List;
import java.util.Map;

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
}
