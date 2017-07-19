package com.bbd.bgo.service.imp.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-07-03 14:34.
 */
@Component("testHandler")
@Scope("prototype")
public class CompanyLevelHandler extends AbstractImportHandler<CompanyLevelDO> {

	private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

	@Autowired
	private CompanyService companyService;

	private List<CompanyLevelDO> insertList = null;
	private List<CompanyLevelDO> updateList = null;
	private List<RiskChgCoDo> riskChgCoList = null;

	private CompanyDO companyDO;

	@Override
	public void start(HttpServletRequest request) throws Exception {
		log.info("开始导入企业评级");
		insertList = new ArrayList<>();
		updateList = new ArrayList<>();
		riskChgCoList = new ArrayList<>();
	}

	@Override
	public void startRow(Map<String, String> row) throws Exception {

	}

	@Override
	public boolean validateRow(Map<String, String> row) throws Exception {
		String companyName = row.get("companyName");
		companyDO = this.companyService.getCompanyByName(companyName);
		if (companyDO == null) {
			addError("该公司不存在，请检查!");
			return false;
		}
		String outLevelStr = row.get("outLevel");
		String innerLevelStr = row.get("innerLevel");
		String liveLevelStr = row.get("liveLevel");

		String outLevel = null;
		if (StringUtils.isNotBlank(outLevelStr)) {
			outLevel = CompanyLevel.getByValue(outLevelStr).ordinal() + "";
		}
		String innerLevel = null;
		if (StringUtils.isNotBlank(innerLevelStr)) {
			innerLevel = CompanyLevel.getByValue(innerLevelStr).ordinal() + "";
		}
		String liveLevel = null;
		if (StringUtils.isNotBlank(liveLevelStr)) {
			liveLevel = CompanyLevel.getByValue(liveLevelStr).ordinal() + "";
		}

		row.put("companyId", companyDO.getCompanyId() + "");
		row.put("outLevel", outLevel);
		row.put("innerLevel", innerLevel);
		row.put("liveLevel", liveLevel);
		return true;
	}

	@Override
	public void endRow(Map<String, String> row, CompanyLevelDO bean) throws Exception {
		CompanyLevelDO levelDO = this.companyService.selectById(CompanyLevelDO.class, bean.getCompanyId());
		if (levelDO == null) {
			bean.setCreateBy("导入公司评级");
			bean.setCreateDate(new Date());
			insertList.add(bean);
			addRiskChgCo(levelDO, bean);
			return;
		}
		boolean haveChange = false;

		Integer newOutLevel = bean.getOutLevel();
		Integer oldOutLevel = levelDO.getOutLevel();
		if (newOutLevel != null && !newOutLevel.equals(oldOutLevel) || oldOutLevel != null && !oldOutLevel.equals(newOutLevel)) {
			haveChange = true;
			// levelDO.setOutLevel(newOutLevel);
		}

		Integer newInnerLevel = bean.getInnerLevel();
		Integer oldInnerLevel = levelDO.getInnerLevel();
		if (newInnerLevel != null && !newInnerLevel.equals(oldInnerLevel)
				|| oldInnerLevel != null && !oldInnerLevel.equals(newInnerLevel)) {
			haveChange = true;
			// levelDO.setInnerLevel(newInnerLevel);
		}

		Integer newLiveLevel = bean.getLiveLevel();
		Integer oldLiveLevel = levelDO.getLiveLevel();
		if (newLiveLevel != null && !newLiveLevel.equals(oldLiveLevel) || oldLiveLevel != null && !oldLiveLevel.equals(newLiveLevel)) {
			haveChange = true;
			// levelDO.setLiveLevel(newLiveLevel);
		}

		if (haveChange) {
			bean.setUpdateBy("导入公司评级");
			bean.setUpdateDate(new Date());
			updateList.add(bean);
			addRiskChgCo(levelDO, bean);
		}

	}

	private void addRiskChgCo(CompanyLevelDO oldLevelDO, CompanyLevelDO newLevelDO) {
		RiskChgCoDo riskChgCoDo = new RiskChgCoDo();
		BeanCopier beanCopier = BeanCopier.create(CompanyDO.class, RiskChgCoDo.class, false);
		beanCopier.copy(companyDO, riskChgCoDo, null);

		riskChgCoDo.setCompanyName(companyDO.getName());
		riskChgCoDo.setCompanyType(companyDO.getCompanyType().intValue());

		if (oldLevelDO == null) {
			oldLevelDO = new CompanyLevelDO();
		}

		riskChgCoDo.setOutLevel(newLevelDO.getOutLevel());
		riskChgCoDo.setOldOutLevel(oldLevelDO.getOutLevel());

		riskChgCoDo.setInnerLevel(newLevelDO.getInnerLevel());
		riskChgCoDo.setOldInnerLevel(oldLevelDO.getInnerLevel());

		riskChgCoDo.setLiveLevel(newLevelDO.getLiveLevel());
		riskChgCoDo.setOldLiveLevel(oldLevelDO.getLiveLevel());
		// 1表示手工修改
		riskChgCoDo.setSource(1);

		// 区域
		AreaDO areaDO = this.companyService.selectById(AreaDO.class, riskChgCoDo.getAreaId());
		if (areaDO != null) {
			riskChgCoDo.setAreaName(areaDO.getName());
		}

		// 楼宇
		BuildingDO buildingDO = this.companyService.selectById(BuildingDO.class, riskChgCoDo.getCompanyId());
		if (buildingDO != null) {
			riskChgCoDo.setBuildingId(buildingDO.getBuildingId());
			riskChgCoDo.setBuildingName(buildingDO.getName());
		}
		riskChgCoDo.setChangeDate(new Date());
		riskChgCoDo.setCreateBy("导入公司评级");
		riskChgCoDo.setCreateDate(new Date());
		riskChgCoDo.setUpdateBy(null);
		riskChgCoDo.setUpdateDate(null);

		this.riskChgCoList.add(riskChgCoDo);

	}

	@Override
	@Transactional
	public void end() throws Exception {
		this.companyService.insertList(insertList);
		this.companyService.updateList(updateList, false, false);
		this.companyService.insertList(riskChgCoList);
		log.info("导入企业评级结束");
	}

	@Override
	public void exception(Exception e) {
		addError("服务器异常：" + e.getMessage());
		e.printStackTrace();
	}
}