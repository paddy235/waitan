package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.LoanModify;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.CompanyLevelDO;
import com.bbd.wtyh.domain.EasyExport.LoanData;
import com.bbd.wtyh.domain.dto.CompanyLevelDTO;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.mapper.CompanyLevelMapper;
import com.bbd.wtyh.service.CompanyLevelService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
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
    public List<LoanData> getLoan(ExportCondition exportCondition, PageBean pageBean) {
        pageBean.setTotalCount(companyLevelMapper.countLoan(exportCondition));
        return companyLevelMapper.getLoan(exportCondition, pageBean);
    }

    @Override
    public Integer countCompanyBackground(String background,String companyType) {
        return companyLevelMapper.countCompanyBackground(background,companyType);
    }

    @Override
    public void recordLoad(LoanModify loanModify) {
        companyLevelMapper.recordLoad(loanModify);
    }

    @Override
    public void modifyLoadLevel(RecordInfo recordInfo) {
        if (null == companyLevelMapper.queryByCompanyId(recordInfo)) {
            addLoadLevel(recordInfo);
        }
        companyLevelMapper.modifyLoadLevel(recordInfo);
    }

    @Override
    public void addLoadLevel(RecordInfo recordInfo) {
        companyLevelMapper.addLoadLevel(recordInfo);
    }

    @Override
    public void deleteByCompanyId(RecordInfo recordInfo) {
        companyLevelMapper.deleteLoadLevel(recordInfo);
    }
}
