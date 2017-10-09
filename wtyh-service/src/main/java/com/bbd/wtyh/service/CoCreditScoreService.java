package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import com.bbd.wtyh.domain.dto.CompanyCreditRawInfoDTO;
import com.bbd.wtyh.domain.dto.CreditInfoDTO;
import com.bbd.wtyh.domain.dto.CreditRiskDataDTO;
import com.bbd.wtyh.web.PageBean;

import java.util.List;

/**
 * 公司信用评分接口
 *
 * @author Created by LiYao on 2017-04-25 14:52.
 */
public interface CoCreditScoreService {

	/**
	 * 信用分值计算
	 */
	TaskResultDO creditScoreCalculate(Integer taskId, Integer runMode);

	/**
	 * 关闭分值计算
	 */
	void colseScoreCalculate();

	void executefailCompany(String[] companyNames, String resultCode, Integer taskId, Integer pageNumber, Integer pageSize);

	TaskResultDO executeFailCompanyByTaskId(Integer runMode,Integer oldTaskId,Integer taskId);

	List<CompanyCreditFailInfoDO> queryfailCompany(String[] companyNames, String resultCode, Integer taskId, Integer pageNumber,
			Integer pageSize);

	int queryfailCompanyCounts(String[] companyNames, String resultCode, Integer taskId, Integer pageNumber, Integer pageSize);

	List<TaskFailInfoDO> getCreditFailInfoByTaskId(Integer taskId);

	List<CreditInfoDTO> getCreditInfo(String companyName, String dataType, PageBean pageBean);

	List<CompanyCreditRawInfoDTO> getCreditInfoByCompanyAndType(String companyName, String dataType, PageBean pageBean);

	List<CreditRiskDataDTO> getResourceCounts(Integer companyId ,String companyName);
}
