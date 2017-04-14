package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.ParkCompanyDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkMapper {
   
	public String parkImg(Integer areaId);
	/**
	 * 查询某个园区的楼宇公司
	 *
	 * @param areaId
	 * @return
	 */
	List<ParkCompanyDo> qeuryParkCompany(@Param("areaId") Integer areaId);
   
}