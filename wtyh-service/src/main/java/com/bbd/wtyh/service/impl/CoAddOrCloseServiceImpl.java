package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyStatusChangeDO;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.mapper.CoAddOrCloseMapper;
import com.bbd.wtyh.service.CoAddOrCloseService;
import com.bbd.wtyh.service.CompanyService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/4/18 0018.
 */
@Service
public class CoAddOrCloseServiceImpl extends BaseServiceImpl implements CoAddOrCloseService {

	private final Logger LOGGER = LoggerFactory.getLogger(CoAddOrCloseServiceImpl.class);

	@Autowired
	private CoAddOrCloseMapper coAddOrCloseMapper;

	@Autowired
	private CompanyService companyService;

	@Override
	public Map<String, Object> queryCompanyStatusChg(String areaIds, String companyTypes, String beginDate, String endDate,
			Integer changeType, Integer source, Integer closedType, Integer page, Integer pageSize) {

		// 查询结果
		Map<String, Object> result = new HashMap<>();

		// 查询条件
		Map<String, Object> param = new HashMap<>();

		// 如果选择了全部，则不作为条件
		if(StringUtils.isNotBlank(areaIds)){
			String[] as=areaIds.split(",");
			if(as.length>0 && !"0".equals(as[0])) {
				param.put("areaId", Arrays.asList(as));
			}
		}

		if (StringUtils.isNotBlank(companyTypes)) {
			String[] cs=companyTypes.split(",");
			if(cs.length>0 && !"0".equals(cs[0])) {
				param.put("companyType", Arrays.asList(cs));
			}
		}

		if (StringUtils.isNotBlank(beginDate)) {
			param.put("beginDate", beginDate+"-01");
		}
		if (StringUtils.isNotBlank(endDate)) {
			param.put("endDate", endDate+"-31");
		}
		if (null != changeType && 0!=changeType) {
			param.put("changeType", changeType);
		}
		if (null != source && 0!=source) {
			param.put("source", source);
		}
		if (null != closedType && 0!=closedType) {
			param.put("closedType", closedType);
		}

		param.put("count", "1");
		// 先查询总条数
		List<CompanyStatusChangeDO> listTotal = coAddOrCloseMapper.queryCompanyStatusChg(param);
		result.put("total", listTotal.get(0).getId());

		param.put("count", "2");
		// 再查询每页信息
		if(pageSize > 0 && page >=1){
			param.put("pageSize", pageSize);
			page = (page - 1) * pageSize; // pageNumber的意义已经变为了“Offset”
			param.put("page", page);
			param.put("isPage", 1);
		}

		List<CompanyStatusChangeDO> list = coAddOrCloseMapper.queryCompanyStatusChg(param);
		result.put("results", list);

		return result;
	}

	@Override
	public void saveRiskChgCo(RiskChgCoDo riskChgCoDo) throws Exception {
		if (riskChgCoDo == null) {
			return;
		}
		// 区域
		AreaDO areaDO = this.selectById(AreaDO.class, riskChgCoDo.getAreaId());
		if (areaDO != null) {
			riskChgCoDo.setAreaName(areaDO.getName());
		}

		// 楼宇
		BuildingDO buildingDO = this.companyService.getCompanyBuild(riskChgCoDo.getCompanyId());
		if (buildingDO != null) {
			riskChgCoDo.setBuildingId(buildingDO.getBuildingId());
			riskChgCoDo.setBuildingName(buildingDO.getName());
		}

		riskChgCoDo.setChangeDate(new Date());
		riskChgCoDo.setCreateDate(new Date());

		riskChgCoDo.setUpdateBy(null);
		riskChgCoDo.setUpdateDate(null);

		this.insert(riskChgCoDo);

		LOGGER.warn("保存风险变化公司，riskChgCoId：{},companyId：{}", riskChgCoDo.getId(), riskChgCoDo.getCompanyId());
	}
}
