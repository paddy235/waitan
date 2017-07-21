package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyLevelDO;
import com.bbd.wtyh.domain.EasyExport.LoanData;
import com.bbd.wtyh.domain.dto.CompanyLevelDTO;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.mapper.CompanyLevelMapper;
import com.bbd.wtyh.service.CompanyLevelService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marco on 2016/8/8.
 */
@Service
public class CompanyLevelServiceImpl implements CompanyLevelService {
    @Autowired
    private CompanyLevelMapper companyLevelMapper;
    @Autowired
    private CompanyService companyService;


    @Override
    public List<CompanyLevelDTO> getCompanyLevel(Integer companyType, Integer areaId, Integer orderByField, String descAsc) {
        if (null == companyType || companyType <= 0) {
            throw new RuntimeException("companyType must be not null");
        }
        List<CompanyLevelDO> list = companyLevelMapper.selectCompanyLevel(companyType, areaId, orderByField, descAsc);
        List<CompanyLevelDTO> result = Lists.newArrayList();
        for (CompanyLevelDO levelDO : list) {
            CompanyLevelDTO levelDTO = new CompanyLevelDTO();
            levelDTO.setCompanyName(companyService.getNameById(levelDO.getCompanyId()));
            if (levelDO.getLiveLevel() != null) {
                levelDTO.setLiveLevel(CompanyLevel.getByOrdinal(levelDO.getLiveLevel()).getValue());
            }
            if (levelDO.getOutLevel() != null) {
                levelDTO.setOutLevel(CompanyLevel.getByOrdinal(levelDO.getOutLevel()).getValue());
            }
            if (levelDO.getInnerLevel() != null) {
                levelDTO.setInnerLevel(CompanyLevel.getByOrdinal(levelDO.getInnerLevel()).getValue());
            }
            result.add(levelDTO);
        }
        return result;
    }

    @Override
    public CompanyInfo getLoanOrGuaranteeByCompanyName(String name) {
        return companyLevelMapper.getLoanOrGuaranteeByCompanyName(name);
    }

    @Override
    public List<LoanData> getLoan(ExportCondition exportCondition) {
        return companyLevelMapper.getLoan(exportCondition);
    }
}
