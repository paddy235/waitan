package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.ParkMapper;
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
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private ParkMapper parkMapper;

	@Override
	public int countCompanyNum(CompanyQuery query) {
		return companyMapper.countByQuery(query);
	}

	@Override
	public List<Map<String, Object>> countCompanyNum() {
		List<Map<String, Object>> listMap = companyMapper.countCompany();
		for (Map<String, Object> map:listMap) {
			Integer num = this.parkMapper.countAreaCompany((int)map.get("area_id"));
			map.put("num",num);
		}
		return listMap;
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
	public int searchCompanyNameCount(String keyword, String dataVersion, Integer areaId) {
		Map<String, Object> params = new HashMap<>();
		params.put("keyword", keyword);
		params.put("dataVersion", dataVersion);
		params.put("areaId", areaId);
		return companyMapper.searchCompanyNameCount(params);
	}

	@Override
	public BuildingDO getCompanyBuild(Integer companyId) throws Exception {
		return this.companyMapper.getCompanyBuild(companyId);
	}
}
