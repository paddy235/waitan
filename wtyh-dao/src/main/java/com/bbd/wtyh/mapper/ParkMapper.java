package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.ParkCompanyDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParkMapper {
   
	public String parkImg(Integer areaId);
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
   
}