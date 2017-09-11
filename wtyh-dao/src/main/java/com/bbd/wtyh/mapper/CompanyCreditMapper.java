package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyCreditDataItemsDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.dto.CreditInfoDTO;
import com.bbd.wtyh.domain.dto.CreditRiskDataDTO;
import com.bbd.wtyh.web.PageBean;
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

	List<TaskFailInfoDO> getCreditFailInfoByTaskId(@Param("taskId") Integer taskId);

	List<CreditInfoDTO> getCreditCompany(@Param("companyName") String companyName);

	List<CreditInfoDTO> getCreditInfo(@Param("companyName") String companyName,
									  @Param("dataType") List<String> dataType,
									  @Param(value = "pagination")PageBean pagination);
	long countCreditInfo(@Param("companyName") String companyName,
									  @Param("dataType") List<String> dataType);

	List<CompanyCreditDataItemsDO> getCreditDataItems();

	void truncateCreditFailInfo();

	int countCreditFailInfoBy999(@Param("taskId") Integer taskId);

	List<CreditRiskDataDTO> getResourceCounts(@Param("companyId") Integer companyId,
											  @Param("companyName") String companyName);



}