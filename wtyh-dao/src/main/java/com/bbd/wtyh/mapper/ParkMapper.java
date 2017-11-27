package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.ParkCompanyDo;
import com.bbd.wtyh.domain.ParkDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ParkMapper {
   
	public String parkImg(@Param("parkId") Integer parkId);
	/**
	 * 查询某个园区的楼宇公司
	 * @return
	 */
	List<ParkCompanyDo> qeuryParkCompany(Map<String, Object> params);

	/**
	 * 查询某个园区的楼宇公司笔数
	 * @return
	 */
	int qeuryParkCompanyCount(Map<String, Object> params);

	/**
	 * 查询所有园区信息
	 * @return
     */
	List<ParkDO> queryAllPark();

	/**
	 * 根据行政区编码或用户ID查询园区
	 *
	 * @param params
	 * @return
	 */
	List<ParkDO> queryParkList(Map<String, Object> params);

	/**
	 * 根据园区名字查询园区信息
	 *
	 * @param parkName
	 * @return
     */
	ParkDO queryParkByName(String parkName);

	@Select("SELECT config_value from sys_config where config_key = 'companyNewValue'")
	Integer queryCompanyNewValue();

	//地区的企业数量统计
	@Select("SELECT count(1) FROM (SELECT company.company_id AS companyId,company.`name` AS companyName FROM park,building,company_building,company,park_and_building_relation pabr WHERE \n" +
			"park.area_id = ${area_id} AND park.park_id = pabr.park_id AND pabr.building_id = building.building_id AND building.building_id = company_building.building_id AND company_building.company_id = company.company_id\n" +
			"UNION SELECT company.company_id AS companyId,company.`name` AS companyName FROM company WHERE company.area_id = ${area_id}) rs")
	Integer countAreaCompany(@Param("area_id") int area_id);
   
}