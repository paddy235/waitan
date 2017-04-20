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
			Integer changeTpye, Integer source, Integer closedType, Integer page, Integer pageSize) {

		// 查询结果
		Map<String, Object> result = new HashMap<>();

		// 查询条件
		Map<String, Object> param = new HashMap<>();

		// 如果选择了全部，则不作为条件
		if(null!=areaIds){
			String[] as=areaIds.split(",");

			param.put("areaId", Arrays.asList(as));
		}

		if (null != companyTypes) {
			String[] cs=companyTypes.split(",");
			param.put("companyType", Arrays.asList(cs));
		}

		if (null != beginDate) {
			param.put("beginDate", beginDate+"-01");
		}
		if (null != endDate) {
			param.put("endDate", endDate+"-31");
		}
		if (null != changeTpye) {
			param.put("changeTpye", changeTpye);
		}
		if (null != source) {
			param.put("source", source);
		}
		if (null != closedType) {
			param.put("closedType", closedType);
		}

		param.put("pages", null);
		// 先查询总条数
		List<CompanyStatusChangeDO> listTotal = coAddOrCloseMapper.queryCompanyStatusChg(param);
		result.put("total", listTotal.get(0).getId());

		// 再查询每页信息
		if (pageSize <= 0 || page < 1) {
			param.put("pages", null);
		} else {
			param.put("pageSize", pageSize);
			if ((null != page) && (page > 0)) {
				page = (page - 1) * pageSize; // pageNumber的意义已经变为了“Offset”
				param.put("page", page);
			}
			param.put("pages", 1);

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
