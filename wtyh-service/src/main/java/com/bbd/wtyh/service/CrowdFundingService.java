package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.EasyExport.CrowdfundData;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;

/**
* 众筹企业相关接口
* @author Ian.Su
* @since 2016年8月11日 下午3:43:20
*/
public interface CrowdFundingService {
	
	public List<NvDO> lastMonthData();

	
	public Map<String, String> lastMonthType(String dataType);

	
	public List<CrowdFundingCompanyDO> allCompanys();


	public List<String> queryCompany(String keyword);


	/**
	 * 众筹数据落地
	 * @param taskId
	 * @return
	 */
	Map crowdFundingDataLandTask(Integer taskId);

	List<CrowdfundData> getCrowdfund(ExportCondition exportCondition, PageBean pagination);

	/**
	 *重新执行数据落地失败任务
	 * @param runMode
	 * @param oldTaskId
	 * @param taskId
	 * @return
	 */
	Map executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId);

}
