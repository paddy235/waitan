package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyStatusChangeDO;
import com.bbd.wtyh.mapper.CoChgMonitorMapper;
import com.bbd.wtyh.service.CoChgMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/18 0018.
 */
@Service
public class CoChgMonitorServiceImpl implements CoChgMonitorService {

	@Autowired
	private CoChgMonitorMapper coChgMonitorMapper;

	@Override
	public Map<String, Object> queryCompanyStatusChg(Integer areaId, Integer companyType, String beginDate, String endDate,
			Integer changeTpye, Integer source, Integer closedType, Integer page, Integer pageSize) {

		// 查询结果
		Map<String, Object> result = new HashMap();

		// 查询条件
		Map<String, Object> param = new HashMap();

		// 如果选择了全部，则不作为条件
		if (null != areaId && !areaId.equals(104)) {
			param.put("areaId", areaId);
		}

		if (null != companyType) {
			param.put("companyType", companyType);
		}

		if (null != beginDate) {
			param.put("beginDate", beginDate);
		}
		if (null != endDate) {
			param.put("endDate", endDate);
		}
		if (null != changeTpye) {
			param.put("changeTpye", changeTpye);
		}
		if (null != source) {
			param.put("source", source);
		}
		if (null != closedType) {
			param.put("closedType", closedType);
		}

		param.put("pages", null);
		// 先查询总条数
		List<CompanyStatusChangeDO> listTotal = coChgMonitorMapper.queryCompanyStatusChg(param);
		result.put("total", listTotal.get(0).getId());

		// 再查询每页信息
		if (pageSize <= 0 || page < 1) {
			param.put("pages", null);
		} else {
			param.put("pageSize", pageSize);
			if ((null != page) && (page > 0)) {
				page = (page - 1) * pageSize; // pageNumber的意义已经变为了“Offset”
				param.put("page", page);
			}
			param.put("pages", 1);

		}
		List<CompanyStatusChangeDO> list = coChgMonitorMapper.queryCompanyStatusChg(param);
		result.put("results", list);

		return result;
	}
}
