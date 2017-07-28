package com.bbd.bgo.service.imp.handler;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.GuaranteeBalanceDO;
import com.bbd.wtyh.domain.GuaranteedInfoDO;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mvntest
 *
 * @author Created by ZhaoHongWen on 2017-07-26 14:34.
 */
@Component
@Scope("prototype")
public class GuaranteeBalanceHandler extends AbstractImportHandler<GuaranteeBalanceDO> {

	private Logger log = LoggerFactory.getLogger(GuaranteeBalanceHandler.class);

	@Autowired
	private GuaranteeService guaranteeService;

	private List<GuaranteeBalanceDO> insertList = null;

	private List<GuaranteeBalanceDO> updateList = null;

	@Override
	public void start(HttpServletRequest request) throws Exception {
		log.info("开始导入融资担保-担保责任余额信息列表");
		insertList = new ArrayList<>();
		updateList = new ArrayList<>();
	}

	@Override
	public void startRow(Map<String, String> row) throws Exception {

	}

	@Override
	public boolean validateRow(Map<String, String> row) throws Exception {
		String yearStr = row.get("year");
		if(StringUtils.isBlank( yearStr )) {
			addError("年份格式错误");
			return false;
		}
		String yearReg = "[0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}";
		if(!yearStr.matches(yearReg)){
			addError("年份格式错误");
			return false;
		}
		String monthStr = row.get("month");
		if(StringUtils.isBlank( monthStr )) {
			addError("月份格式错误");
			return false;
		}
		String monthReg = "0?[1-9]|1[0-2]";
		if(!monthStr.matches(monthReg)){
			addError("月份格式错误");
			return false;
		}
		return true;
	}

	@Override
	public void endRow(Map<String, String> row, GuaranteeBalanceDO bean) throws Exception {
		bean.setCreateBy("导入融资担保-担保责任余额");
		bean.setCreateDate(new Date());
		String sqlWhere= "year=" +bean.getYear() +" AND month="
				+bean.getMonth()+" LIMIT 1";
		GuaranteeBalanceDO balanceDO = guaranteeService.selectOne(GuaranteeBalanceDO.class,sqlWhere);
		if(null==balanceDO){
			insertList.add(bean);
		}else{
			bean.setId(balanceDO.getId());
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
		this.guaranteeService.insertList(insertList);
		this.guaranteeService.updateList(updateList);
		log.info("导入融资担保-担保责任余额信息列表结束");
	}

	@Override
	public void exception(Exception e) {
		addError("服务器异常：" + e.getMessage());
		e.printStackTrace();
	}
}
