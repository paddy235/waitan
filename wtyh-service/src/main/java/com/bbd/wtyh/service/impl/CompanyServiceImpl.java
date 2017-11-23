package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.BBDParentCompanyDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.DataLoadingMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CompanyService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bbd.wtyh.common.Constants.REDIS_KEY_COMPANY_PARENT;

/**
 * Created by Marco on 2016/8/8.
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private DataLoadingMapper dataLoadingMapper;

	@Autowired
	private RedisDAO redisDAO;

	@Value("${api.bbd_qyxx_parent.url}")
	private String url;

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

	@Override
	public BBDParentCompanyDO getParentCompany(String name){
		final String redisKey = REDIS_KEY_COMPANY_PARENT + "_" + name;
		BBDParentCompanyDO parentCompanyDODO = (BBDParentCompanyDO) redisDAO.getObject(redisKey);
		if(null!=parentCompanyDODO){
			return parentCompanyDODO;
		}
		String qyxxId = dataLoadingMapper.getCompanyQyxxId(name);
		if(org.apache.commons.lang.StringUtils.isEmpty(qyxxId)){
			return null;
		}
		String URL = url + "?company=" + name+"&qyxx_id="+qyxxId;
		HttpTemplate httpTemplate = new HttpTemplate();
		try {
			return httpTemplate.get(URL, new HttpCallback<BBDParentCompanyDO>() {
				@Override
				public boolean valid() {
					return true;
				}

				@Override
				public BBDParentCompanyDO parse(String result) {
					Gson gson = new Gson();
					BBDParentCompanyDO parCom = gson.fromJson(result, BBDParentCompanyDO.class);
					redisDAO.addObject(redisKey,parCom ,
							Constants.cacheDay, BaseDataDO.class);
					return parCom;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
