package com.bbd.bgo.service.imp.handler.xiaodai;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.LoanBalanceDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 小贷-贷款余额
 *
 * @author Created by LiYao on 2017-07-25 14:21.
 */
@Component
@Scope("prototype")
public class LoanBalanceHandler extends AbstractImportHandler<LoanBalanceDO> {

	private Logger log = LoggerFactory.getLogger(LoanBalanceHandler.class);

	@Autowired
	private LoanService loanService;
	private List<LoanBalanceDO> insertList = null;
	private List<LoanBalanceDO> updateList = null;

	private long loanComanyTotal;
	private String loginName = "";

	@Override
	public void start(HttpServletRequest request) throws Exception {
		log.info("导入小贷-贷款余额开始");
		insertList = new ArrayList<>();
		updateList = new ArrayList<>();
		loanComanyTotal = this.loanService.countLoanCompany();

		String tmpName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
		if (tmpName != null) {
			loginName = tmpName;
		}
	}

	@Override
	public void startRow(Map<String, String> row) throws Exception {

	}

	@Override
	public boolean validateRow(Map<String, String> row) throws Exception {
		row.put("companyAmount", loanComanyTotal + "");
		return true;
	}

	@Override
	public void endRow(Map<String, String> row, LoanBalanceDO bean) throws Exception {
		int year = bean.getYear();
		int month = bean.getMonth();
		List<LoanBalanceDO> list = this.loanService.selectAll(LoanBalanceDO.class, "year = " + year + " AND month = " + month);
		if (list.isEmpty()) {
			bean.setCreateBy(loginName);
			bean.setCreateDate(new Date());
			this.insertList.add(bean);
			return;
		}
		if (list.size() > 1) {
			addError("找到" + list.size() + "条数据，请检查！");
			return;
		}
		LoanBalanceDO tmp = list.get(0);
		bean.setId(tmp.getId());
		bean.setCreateBy(tmp.getCreateBy());
		bean.setCreateDate(tmp.getCreateDate());
		bean.setUpdateBy(loginName);
		bean.setUpdateDate(new Date());
		this.updateList.add(bean);

	}

	@Override
	public void end() throws Exception {
		if (errorList().isEmpty()) {
			this.loanService.insertList(insertList);
			this.loanService.updateList(updateList);
		}
		log.info("导入小贷-贷款余额结束");
	}

	@Override
	public void exception(Exception e) {
		addError("服务器异常：" + e.getMessage());
		log.error("导入小贷-贷款余额服务器异常！", e);
	}
}
