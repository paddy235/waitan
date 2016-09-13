package com.bbd.wtyh.service;


import com.bbd.wtyh.domain.vo.DynamicRiskVO;
import com.bbd.wtyh.domain.vo.RelationDataVO;

import java.util.List;

/**
*
* @author
* @since 2016.08.13
*/
public interface RelationDataService {

	public RelationDataVO compareRelationData(String companyName, String areaCode, String currentMonth, String compareMonth);

	/**
	 *
	 * 比较两个月动态风险指标结果
	 * @param companyName
	 * @param currentMonth
	 * @param compareMonth
	 * @return
	 */
	public DynamicRiskVO compareDynamicRisk(String companyName, String areaCode, String currentMonth, String compareMonth);

	/**
	 *
	 * @param companyName
	 * @param areaCode
     * @return
     */
	public List<String> queryDateVersion(String companyName, String areaCode);

	/**
	 * 获取最新的数据版本
     * @return
     */
	public String getNewestDataVersion();

	/**
	 *
	 * @param companyName
	 * @param areaCode
	 * @return
	 */
	public String queryDateVersionByMonth(String companyName, String areaCode);

}
