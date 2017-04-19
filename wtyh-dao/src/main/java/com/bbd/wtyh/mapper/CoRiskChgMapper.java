package com.bbd.wtyh.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-04-19 16:50.
 */
public interface CoRiskChgMapper {

	@Select("SELECT building_id AS id,`name` FROM building")
	List<Map<String, Object>> riskChgCoBuilding();

}
