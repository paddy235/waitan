package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cgj on 2017/5/4.
 */

public interface CompanyCreditMapper {



	int countCreditFailInfo(@Param("taskId") Integer taskId);

	int countCreditFailHistoryInfo(@Param("taskId") Integer taskId);

	int countCreditRawInfo(@Param("taskId") Integer taskId);

	int countCreditRawHistoryInfo(@Param("taskId") Integer taskId);

	List<CompanyDO> getCompanyCreditFailByTaskId(@Param("taskId") Integer taskId);



}