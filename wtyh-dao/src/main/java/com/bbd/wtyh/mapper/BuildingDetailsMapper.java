package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;

import java.util.List;
import java.util.Map;

/**
 * 楼宇详情
 * @author tracy zhou
 * @since  2016/8/8
 */
public interface BuildingDetailsMapper {

    List<Map> queryCompanyAnalysiResult(Integer buildingId);

    List<CompanyDO> queryExposedCompanyList(Integer buildingId);

}
