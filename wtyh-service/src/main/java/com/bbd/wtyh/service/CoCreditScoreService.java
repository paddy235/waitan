package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;

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
	void creditScoreCalculate();

	/**
	 * 关闭分值计算
	 */
	void colseScoreCalculate();

	void executefailCompany(String[] companyNames, String resultCode, String dataVersion, Integer pageNumber, Integer pageSize);

	List<CompanyCreditFailInfoDO> queryfailCompany(String[] companyNames, String resultCode, String dataVersion, Integer pageNumber,
			Integer pageSize);

	int queryfailCompanyCounts(String[] companyNames, String resultCode, String dataVersion, Integer pageNumber, Integer pageSize);
}
