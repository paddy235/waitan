package com.bbd.wtyh.mapper;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.LargeLoanDO;
import com.bbd.wtyh.domain.dto.LargeLoanDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LargeLoanMapper {

	LargeLoanDO selectByPrimaryKey(Integer id);

	List<LargeLoanDO> listLargeLoan(@Param("pagination") Pagination pagination, @Param("orderByField") Integer orderByField,
			@Param("descAsc") String descAsc);

	int countLargeLoan();

	@Select("SELECT COUNT(*) FROM company WHERE company_type = 2;")
	long countLoanCompany();
}