package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.dto.RelationDTO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;

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
    RelationDTO getRealation(String companyName, String dateVersion);
}
