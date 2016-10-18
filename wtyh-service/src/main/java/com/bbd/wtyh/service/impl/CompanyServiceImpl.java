package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/8/8.
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
    public List<Map<String, Object>> countCompanyNum() {
        return companyMapper.countCompany();
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
    public CompanyDO getCompanyByName(String companyName) {
        return companyMapper.selectByName(companyName);
    }

    @Override
    public CompanyDO getCompanyByName(String companyName, boolean changeFullWidth) {
        if (changeFullWidth) {
            companyName = companyName.replace("(", "（").replace(")", "）");
        }
        return getCompanyByName(companyName);
    }

    @Override
    public List<CompanyDO> searchCompany(Integer companyType, String keyword, Integer size) {
        return companyMapper.searchCompany(companyType, keyword, size);
    }

    @Override
    public List<CompanyDO> queryCompanyByType(Integer companyType, Integer orderByField, String descAsc) {
        return companyMapper.queryCompanyByType(companyType, orderByField, descAsc);
    }

    @Override
    public List<CompanyDO> searchCompanyName(Map<String, Object> params) {
        return companyMapper.searchCompanyName(params);
    }

    @Override
    public int searchCompanyNameCount(String keyword, String dataVersion) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("keyword", keyword);
    	params.put("dataVersion", dataVersion);
        return companyMapper.searchCompanyNameCount(params);
    }
}
