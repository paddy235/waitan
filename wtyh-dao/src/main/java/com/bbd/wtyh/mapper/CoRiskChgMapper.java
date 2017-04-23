package com.bbd.wtyh.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-04-19 16:50.
 */
public interface CoRiskChgMapper {

	//@Select("SELECT b.building_id AS id,b.`name` FROM building b,park p WHERE b.park_id = p.park_id AND p.area_id IN (${areaSet})")
	List<Map<String, Object>> riskChgCoBuilding(@Param("areaSet") String areaSet);

}
