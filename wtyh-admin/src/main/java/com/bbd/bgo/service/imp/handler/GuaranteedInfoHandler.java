package com.bbd.bgo.service.imp.handler;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.GuaranteeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * mvntest
 *
 * @author Created by ZhaoHongWen on 2017-07-25 14:34.
 */
@Component
@Scope("prototype")
public class GuaranteedInfoHandler extends AbstractImportHandler<GuaranteedInfoDO> {

	private Logger log = LoggerFactory.getLogger(GuaranteedInfoHandler.class);

	@Autowired
	private CompanyService companyService;
	@Autowired
	private GuaranteeService guaranteeService;

	private List<GuaranteedInfoDO> insertList = null;

	private CompanyDO guaranteeCompanyDO;

	@Override
	public void start(HttpServletRequest request) throws Exception {
		log.info("开始导入融资担保-大额被担保人信息列表");
		insertList = new ArrayList<>();
	}

	@Override
	public void startRow(Map<String, String> row) throws Exception {

	}

	@Override
	public boolean validateRow(Map<String, String> row) throws Exception {
		//担保公司校验
		String guaranteeCompany = row.get("guaranteeCompany");
		String guaranteedCompany = row.get("guaranteedCompany");
		if(StringUtils.isBlank( guaranteeCompany ) || guaranteeCompany.length() >40 ) {
			addError("担保公司名称格式错误");
			return false;
		}
		//被担保公司校验
		if(StringUtils.isBlank( guaranteedCompany ) || guaranteedCompany.length() >40 ) {
			addError("被担保公司名称格式错误");
			return false;
		}
		//担保公司和被担保公司不能下相同
		if(guaranteeCompany.equals(guaranteedCompany)){
			addError("该担保公司和被担保公司相同");
			return false;
		}
		guaranteeCompanyDO = this.companyService.getCompanyByName(guaranteeCompany);
		if (guaranteeCompanyDO == null) {
			addError("该担保公司不存在，请先导入企业名单");
			return false;
		}
		CompanyDO guaranteedComp = this.companyService.getCompanyByName(guaranteedCompany);
		if (guaranteedComp == null) {
			addError("该被担保公司不存在，请先导入企业名单");
			return false;
		}
		row.put("guaranteeId", guaranteeCompanyDO.getCompanyId().toString());
		row.put("guaranteedId", guaranteedComp.getCompanyId().toString());
		return true;
	}

	@Override
	public void endRow(Map<String, String> row, GuaranteedInfoDO bean) throws Exception {
		//GuaranteedInfoDO guaranteedInfoDO = guaranteeService.selectByPrimaryKey(bean.getId());
		String sqlWhere= "guarantee_id=" +bean.getGuaranteeId() +" AND guaranteed_id="
				+bean.getGuaranteedId()+" LIMIT 1";
		GuaranteedInfoDO guaranteedInfo = guaranteeService.selectOne(GuaranteedInfoDO.class,sqlWhere);
		if(null==guaranteedInfo){
			bean.setCreateBy("导入融资担保-大额被担保人信息");
			bean.setCreateDate(new Date());
			insertList.add(bean);
		}
	}

	@Override
	@Transactional
	public void end() throws Exception {
		if( errorList().size() >0 ) {
			addError("用户上传的数据有误，所有数据均不予入库");
			log.warn("用户上传的数据有误，所有数据均不予入库");
			return;
		}
		this.guaranteeService.insertList(insertList);
		log.info("导入融资担保-大额被担保人信息列表结束");
	}

	@Override
	public void exception(Exception e) {
		addError("服务器异常：" + e.getMessage());
		e.printStackTrace();
	}
}
