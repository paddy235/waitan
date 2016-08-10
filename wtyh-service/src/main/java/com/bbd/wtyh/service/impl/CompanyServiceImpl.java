package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.service.CompanyService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marco on 2016/8/8 0008.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int countCompanyNum(CompanyQuery query) {
        return companyMapper.countByQuery(query);
    }

    @Override
    public String getNameById(Integer companyId) {
        return companyMapper.selectByPrimaryKey(companyId).getName();
    }


    @Override
    public CompanyDO getCompanyById(Integer companyId) {
        return companyMapper.selectByPrimaryKey(companyId);
    }

    @Override
    public List<CompanyDO> searchCompany(Integer companyType, String keyword) {
        List<Integer> companyIds = companyMapper.searchCompany(companyType, keyword);
        List<CompanyDO> companyList = Lists.newArrayList();
        for (Integer companyId : companyIds) {
            CompanyDO companyDO = new CompanyDO();
            companyDO.setCompanyId(companyId);
            companyDO.setName(getNameById(companyId));
            companyList.add(companyDO);
        }
        return companyList;

    }
}