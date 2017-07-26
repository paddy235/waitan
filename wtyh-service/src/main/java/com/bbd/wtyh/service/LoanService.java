package com.bbd.wtyh.service;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.LargeLoanDO;
import com.bbd.wtyh.domain.LoanBalanceDO;
import com.bbd.wtyh.domain.dto.LoanBalanceByQuarterDTO;

import java.util.List;

/**
 * Created by Marco on 2016/8/8 0008.
 */
public interface LoanService extends BaseService {

	List<LoanBalanceDO> getLoanBalanceByYear();

	List<LoanBalanceDO> getLoanBalanceByMonth();

	List<LoanBalanceByQuarterDTO> getLoanBalanceByQuater();

	List<LargeLoanDO> listLargeLoan(Pagination pagination, Integer orderByField, String descAsc);

	int countLargeLoan();

	/**
	 * 统计所有小贷公司数量
	 * 
	 * @return
	 */
	long countLoanCompany();
}
