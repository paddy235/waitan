package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.InvestigationInfoDO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2017/4/18.
 */

public interface InvestigationInfoMapper {

	List<Map<String, Object>> listInvestigationInfo(HashMap<String, Object> params);

	void saveInvestigationInfo( InvestigationInfoDO investigationInfoDO  );

}