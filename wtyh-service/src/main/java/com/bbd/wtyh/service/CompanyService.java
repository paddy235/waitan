package com.bbd.wtyh.service;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.BBDParentCompanyDO;
import com.bbd.wtyh.domain.query.CompanyQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/8/8.
 */
public interface CompanyService extends BaseService {

	int countCompanyNum(CompanyQuery query);

	List<Map<String, Object>> countCompanyNum();

	String getNameById(Integer companyId);

	CompanyDO getCompanyById(Integer companyId);

	CompanyDO getCompanyByName(String companyName);

	CompanyDO getCompanyByName(String companyName, boolean changeFullWidth);

	List<CompanyDO> searchCompany(Integer companyType, String keyword, Integer size);

	List<CompanyDO> queryCompanyByType(Integer companyType, Integer orderByField, String descAsc);

	List<CompanyDO> searchCompanyName(Map<String, Object> params);

	int searchCompanyNameCount(String keyword, String dataVersion, Integer areaId);

	BuildingDO getCompanyBuild(Integer companyId) throws Exception;

	BBDParentCompanyDO getParentCompany(String name);

}
