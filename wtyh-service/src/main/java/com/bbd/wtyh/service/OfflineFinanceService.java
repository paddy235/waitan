package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

/**
 * 线下理财接口层
 * @author zhouxuan
 * @since 2016.08.05
 */
public interface OfflineFinanceService {

    @SuppressWarnings("rawtypes")
	List<Map> relatedGraph();

    public String getRelationFromKunLun(String companyName, String level, String version);
}
