package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.ParkCompanyDo;
import com.bbd.wtyh.domain.ParkDO;
import org.apache.ibatis.annotations.Param;

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
   
}