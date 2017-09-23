package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;

/**
* 预付卡相关接口
* @author Ian.Su
* @since 2016年8月12日 上午9:33:44
*/
public interface PrepaidCompanyStaticService {
	
	List<PrepaidCompanyStatisticDO> prepaidAll();

	List<PrepaidCompanyDO> prepaidCompanyAll();

	CompanyInfo getPerpaycardByCompanyName(String name);

	void modifyPerpaycard(RecordInfo recordInfo);

	void addPerpaycard(RecordInfo recordInfo);

	void deleteByCompanyId(RecordInfo recordInfo);

	void addCompanyAnalysisResultWhenBlack(CompanyAnalysisResultDO companyAnalysisResultDO);

	int updateCompanyAnalysisResultWhenBlack(CompanyAnalysisResultDO companyAnalysisResultDO);
}
