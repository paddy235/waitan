package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyStatusChangeDO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/18 0018.
 */
public interface CoChgMonitorMapper {

    List<CompanyStatusChangeDO> queryCompanyStatusChg(Map<String, Object> param);
}
