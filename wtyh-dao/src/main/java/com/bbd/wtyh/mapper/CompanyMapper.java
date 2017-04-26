package com.bbd.wtyh.mapper;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.BuildingDO;
import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.domain.vo.SpectrumVO;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

public interface CompanyMapper {

	CompanyDO selectByPrimaryKey(Integer companyId);

	List<Map<String, Object>> countCompany();

	int maxVersion();

	int countByQuery(CompanyQuery query);

	List<CompanyDO> queryCompany(CompanyQuery query);

	public InBusinessDO countByDate(@Param(value = "areaId") Integer areaId, @Param(value = "start") String start,
			@Param(value = "end") String end);

	public CompanyTypeCountDO countByType(@Param(value = "areaId") Integer areaId, @Param(value = "type") Byte type);

	public List<CompanyDO> buildingCompany(@Param(value = "buildingId") Integer buildingId, @Param(value = "orderField") Integer orderField,
			@Param(value = "descAsc") String descAsc);

	public CompanyTypeCountDO countTypeByBuild(@Param(value = "buildingId") Integer buildingId, @Param(value = "type") Byte type);

	public CompanyTypeCountDO buildingBackground(@Param(value = "buildingId") Integer buildingId,
			@Param(value = "background") byte background);

	List<CompanyDO> searchCompany(@Param("companyType") Integer companyType, @Param("name") String keyword, @Param("size") Integer size);

	List<CompanyDO> searchCompanyName(Map<String, Object> params);

	int searchCompanyNameCount(Map<String, Object> params);

	CompanyDO selectByName(String companyName);

	List<String> queryCompanyNames(@Param("areaId") Integer areaId, @Param("buildingId") Integer buildingId);

	List<Map<Integer, Object>> companyInfo(String companyName);

	List<CompanyDO> queryCompanyByType(@Param("companyType") Integer companyType, @Param("orderByField") Integer orderByField,
			@Param("descAsc") String descAsc);

	List<SpectrumVO> getSpectrumAnalysis(@Param("risk_level") Integer risk_level, @Param("dateVersion") String dateVersion,
			@Param("companyNumber") Integer companyNumber, @Param("areaId") Integer areaId);

	/**
	 * 获取总条数
	 * 
	 * @return
	 */
	int countAllCompany();

	/**
	 * 分页获取企业信息
	 * 
	 * @param params
	 * @return
	 */
	List<CompanyDO> findByPage(Map<String, Object> params);

	/**
	 * 更新企业光谱
	 * 
	 * @param riskLevel
	 * @param companyId
	 */
	void updateRiskLevel(@Param("riskLevel") Integer riskLevel, @Param("previousRiskLevel") Integer previousRiskLevel,
			@Param("companyId") Integer companyId, @Param("updateBy") String updateBy);

	CompanyDO queryCompanyByName(@Param(value = "company") String company);

	/**
	 * 获取配置的地图展示光谱分析的点
	 * 
	 * @return
	 */
	List<Map<String, Integer>> getRiskLevelNumber();

	@Select("SELECT b.*,b.building_id AS buildingId FROM building b,company_building cb WHERE cb.company_id = #{compantId} AND b.building_id = cb.building_id")
	BuildingDO getCompanyBuild(Integer compantId);

	/**
	 * 更新企业区代、地址等
	 * 
	 * @param companyName
	 *            名称
	 * @param areaId
	 *            区代
	 * @param address
	 *            地址
	 * @param creditCode
	 *            统一社会信用代码
	 */
	@Update("UPDATE company SET `area_id` =#{areaId}, `address` =#{address}, `credit_code` =#{creditCode} WHERE `name` =#{companyName};")
	void updateAreaIdAndAddress(@Param("companyName") String companyName, @Param("areaId") Integer areaId, @Param("address") String address,
			@Param("creditCode") String creditCode);

	/**
	 * 大于id 的公司总数量
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT COUNT(*) AS count FROM company c WHERE c.company_id > #{id} ORDER BY c.company_id")
	int countCompanyGTId(@Param("id") int id);

}