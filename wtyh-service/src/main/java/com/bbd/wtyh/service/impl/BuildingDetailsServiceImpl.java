package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.mapper.BuildingDetailsMapper;
import com.bbd.wtyh.mapper.BuildingMapper;
import com.bbd.wtyh.service.BuildingDetailsService;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 楼宇详情接口实现层
 * @author zhouxuan
 * @since  2016.08.05
 */
@Service("buildingDetailsService")
public class BuildingDetailsServiceImpl implements BuildingDetailsService {
    private Logger logger = LoggerFactory.getLogger(BuildingDetailsServiceImpl.class);
    @Autowired
    private BuildingDetailsMapper buildingDetailsMapper;

    @Override
    public Map<T, T> buildingPicture(Integer buildingId) {
        List<Map> companyAnalysiResult = buildingDetailsMapper.queryCompanyAnalysiResult(buildingId);
        List<CompanyDO> ss = buildingDetailsMapper.queryExposedCompanyList(buildingId);
        return null;
    }
}
