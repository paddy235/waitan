package com.bbd.wtyh.mapper;


import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.*;
import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.domain.vo.SpectrumVO;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CompanyMapper {

	CompanyDO selectByPrimaryKey(Integer companyId);

	List<Map<String, Object>> countCompany();

	int maxVersion();

	int countByQuery(CompanyQuery query);

	CompanyDO getCompanyById(@Param(value = "companyId") Integer companyId);

	public InBusinessDO countByDate(@Param(value = "parkId") Integer parkId, @Param(value = "start") String start,
			@Param(value = "end") String end);

	public CompanyTypeCountDO countByType(@Param(value = "parkId") Integer parkId, @Param(value = "type") Byte typee);

	public List<CompanyDO> buildingCompany(@Param(value = "buildingId") Integer buildingId, @Param(value = "orderField") Integer orderField,
			@Param(value = "descAsc") String descAsc);

	public CompanyTypeCountDO countTypeByBuild(@Param(value = "buildingId") Integer buildingId, @Param(value = "type") Byte type);

	public CompanyTypeCountDO buildingBackground(@Param(value = "buildingId") Integer buildingId,
			@Param(value = "background") byte background);

	List<CompanyDO> searchCompany(@Param("companyType") Integer companyType, @Param("name") String keyword, @Param("size") Integer size);

	List<CompanyDO> searchCompanyName(Map<String, Object> params);

	int searchCompanyNameCount(Map<String, Object> params);

	CompanyDO selectByName(String companyName);

	List<String> queryCompanyNames(@Param("parkId") Integer parkId, @Param("buildingId") Integer buildingId);

	List<Map<Integer, Object>> companyInfo(String companyName);

	@Select("SELECT company.area_id AS comAreaId, park.area_id AS parkAreaId, park. NAME AS parkName,building.`name` AS buildName FROM " +
			" park,building,company_building,company,park_and_building_relation pabr WHERE park.park_id = pabr.park_id" +
			" AND pabr.building_id = building.building_id AND building.building_id = company_building.building_id" +
			" AND company_building.company_id = company.company_id AND company.`name` = #{companyName}")
	CompanyBuildParkDO queryCompanyBuildParkInfo(String companyName);

	List<CompanyDO> queryCompanyByType(@Param("companyType") Integer companyType, @Param("orderByField") Integer orderByField,
			@Param("descAsc") String descAsc);

	List<SpectrumVO> getSpectrumAnalysis(@Param("risk_level") Integer risk_level, @Param("dateVersion") String dateVersion,
			@Param("companyNumber") Integer companyNumber, @Param("areaId") Integer areaId);

	List<SpectrumVO> getSpectrumAnalysisByRiskLevel(@Param("risk_level") Integer risk_level, @Param("dateVersion") String dateVersion,
										 @Param("companyNumber") Integer companyNumber, @Param("areaId") Integer areaId);

	List<SpectrumVO> getSpectrumAnalysisByRiskLevelOne();

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

	@Select("SELECT b.*,b.building_id AS buildingId FROM building b,company_building cb WHERE cb.company_id = #{compantId} AND b.building_id = cb.building_id limit 1")
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

	List<CompanyDO> getCompanyList(@Param("startId") int startId, @Param("type") String type, @Param("limit") int limit);

	int countAllCompanyByType(@Param("type") String type);

	@Select("SELECT MAX(company_id) FROM company")
	Integer maxCompanyId();

	List<CompanyDO> findCompanyByName( @Param("names") List<String> names );

	/**
	 * 查询传入的企业名称中那些是类金融企业
	 * @param names
	 * @return
	 */
	List<String> findKindredFinanceCompanyNameByCompanyName( @Param("names") List<String> names );

	/**
	 * 更新企业基本信息
	 *
	 */
	@Update("UPDATE company SET `area_id` =#{areaId}, `address` =#{address}, `credit_code` =#{creditCode}, `longitude` =#{longitude}," +
	 	" `latitude` =#{latitude}, `legal_person` =#{legalPerson},`registered_capital` =#{registeredCapital}," +
	 	 " `registered_capital_type` =#{registeredCapitalType}, `registered_date` =#{registeredDate}, `registered_type` =#{registeredType}," +
	 	  " `status` =#{status} ,`business_type`=#{businessType} ,update_date=CURDATE(),update_by='TIMER' WHERE `name` =#{companyName};")
	void updateBasicInfo(@Param("companyName") String companyName, @Param("areaId") Integer areaId, @Param("address") String address,
						     @Param("creditCode") String creditCode,@Param("longitude") Double longitude,@Param("latitude") Double latitude,
							 @Param("legalPerson") String legalPerson,@Param("registeredCapital") Integer registeredCapital,
						     @Param("registeredCapitalType") Integer registeredCapitalType,@Param("registeredDate") String registeredDate,
						     @Param("registeredType") String registeredType,@Param("status") Integer status,@Param("businessType") String businessType);

	List<CompanyDO> getLineCompanyListMoreThanExecuteDate(@Param("executeDate") String executeDate);
}