package com.bbd.bgo.service.imp.handler.xiaodai;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.LargeLoanDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;
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
 * 小贷-大额借款人处理器
 *
 * @author Created by LiYao on 2017-07-24 18:05.
 */
@Component
@Scope("prototype")
public class LargeBorrowerHandler extends AbstractImportHandler<LargeLoanDO> {

	private Logger log = LoggerFactory.getLogger(LargeBorrowerHandler.class);

	@Autowired
	private CompanyService companyService;

	private List<LargeLoanDO> insertList = null;

	private String loginName = "";

	@Override
	public void start(HttpServletRequest request) throws Exception {
		log.info("导入小贷-大额借款人开始");
		insertList = new ArrayList<>();

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
		// 借款公司
		String borrowerName = row.get("borrower");
		CompanyDO borrower = this.companyService.getCompanyByName(borrowerName);
		boolean haveError = false;
		if (borrower == null) {
			addError("借款公司不存在，请先导入企业名单");
			haveError = true;
		}
		// 贷款公司
		String lenderName = row.get("lender");
		CompanyDO lender = this.companyService.getCompanyByName(lenderName);
		if (lender == null) {
			addError("贷款公司不存在，请先导入企业名单");
			haveError = true;
		}

		if (borrowerName.equals(lenderName)) {
			addError("借款公司与贷款公司不能相同");
			haveError = true;
		}

		if (haveError) {
			return false;
		}

		int borrowerId = borrower.getCompanyId();
		int lenderId = lender.getCompanyId();

		LargeLoanDO largeLoanDO = this.companyService.selectOne(LargeLoanDO.class,
				"borrower_id = " + borrowerId + " AND lender_id = " + lenderId);
		if (largeLoanDO != null) {
//			addError("该贷方与借方对应关系已存在");
//			return false;
			return true;
		}
		row.put("borrowerId", borrowerId + "");
		row.put("lenderId", lenderId + "");
		return true;
	}

	@Override
	public void endRow(Map<String, String> row, LargeLoanDO bean) throws Exception {
		// 借款公司
		String borrowerName = row.get("borrower");
		CompanyDO borrower = this.companyService.getCompanyByName(borrowerName);
		// 贷款公司
		String lenderName = row.get("lender");
		CompanyDO lender = this.companyService.getCompanyByName(lenderName);
		int borrowerId = borrower.getCompanyId();
		int lenderId = lender.getCompanyId();
		LargeLoanDO largeLoanDO = this.companyService.selectOne(LargeLoanDO.class,
				"borrower_id = " + borrowerId + " AND lender_id = " + lenderId);
		if (largeLoanDO == null) {
			bean.setCreateBy(loginName);
			bean.setCreateDate(new Date());
			insertList.add(bean);
		}

	}

	@Override
	public void end() throws Exception {
		if (errorList().isEmpty()) {
			this.companyService.insertList(insertList);
		} else {
			addError("用户上传的大额借款人中的数据有误，所有数据均不予入库");
		}
		log.info("导入小贷-大额借款人结束");
	}

	@Override
	public void exception(Exception e) {
		addError("服务器异常：" + e.getMessage());
		log.error("导入小贷-大额借款人服务器异常！", e);
	}
}
