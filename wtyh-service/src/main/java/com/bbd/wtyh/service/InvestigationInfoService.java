package com.bbd.wtyh.service;

import java.util.Date;
import java.util.Map;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.InvestigationInfoDO;

/**
 * 排查信息服务接口 Created by cgj on 2017/4/18.
 */
public interface InvestigationInfoService extends BaseService {

	/**
	 * 列出排查信息
	 * @param pageSize
	 * @param pageNumber
	 * @param orderBy
	 * @param companyId
	 * @param companyName
	 * @param recorder
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> listInvestigationInfo(int pageSize, Integer pageNumber, String orderBy, Integer companyId,
													 String companyName, String recorder, Date beginTime, Date endTime
													 ) throws Exception;


	public void saveInvestigationInfo(InvestigationInfoDO iid, String recorder ) throws Exception;

}
