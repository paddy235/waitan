package com.bbd.bgo.service.imp.handler.prifund;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.GuaranteedInfoDO;
import com.bbd.wtyh.domain.PrivateFundExtraDO;
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
 * @author Created by ZhaoHongWen on 2017-07-26 14:34.
 */
@Component
@Scope("prototype")
public class PrivateFundExtraHandler extends AbstractImportHandler<PrivateFundExtraDO> {

	private Logger log = LoggerFactory.getLogger(PrivateFundExtraHandler.class);

	@Autowired
	private CompanyService companyService;

	private List<PrivateFundExtraDO> insertList = null;

	private List<PrivateFundExtraDO> updateList = null;

	private CompanyDO companyDO;

	@Override
	public void start(HttpServletRequest request) throws Exception {
		log.info("开始导入私募企业列表");
		insertList = new ArrayList<>();
		updateList = new ArrayList<>();
	}

	@Override
	public void startRow(Map<String, String> row) throws Exception {

	}

	@Override
	public boolean validateRow(Map<String, String> row) throws Exception {
		String company_Name = row.get("company_Name");
		companyDO = this.companyService.getCompanyByName(company_Name);
		if (companyDO == null) {
			addError("该机构不存在，请先导入机构名单");
			return false;
		}
		row.put("companyId", companyDO.getCompanyId().toString());
//		String websiteStr = row.get("website");
//		String websiteReg ="^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$";
//		if(!websiteStr.matches(websiteReg)){
//			addError("机构网址格式错误");
//			return false;
//		}
		return true;
	}

	@Override
	public void endRow(Map<String, String> row, PrivateFundExtraDO bean) throws Exception {
		//GuaranteedInfoDO guaranteedInfoDO = guaranteeService.selectByPrimaryKey(bean.getId());
		String sqlWhere= "company_id = " +bean.getCompanyId();
		PrivateFundExtraDO privateFundExtra = companyService.selectOne(PrivateFundExtraDO.class,sqlWhere);
		if(null==privateFundExtra){
			bean.setCreateBy("导入私募企业信息");
			bean.setCreateDate(new Date());
			insertList.add(bean);
		}else{
			bean.setUpdateBy("导入私募企业信息");
			bean.setUpdateDate(new Date());
			updateList.add(bean);
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
		this.companyService.insertList(insertList);
		this.companyService.updateList(updateList);
		log.info("导入私募企业列表结束");
	}

	@Override
	public void exception(Exception e) {
		addError("服务器异常：" + e.getMessage());
		e.printStackTrace();
	}
}
