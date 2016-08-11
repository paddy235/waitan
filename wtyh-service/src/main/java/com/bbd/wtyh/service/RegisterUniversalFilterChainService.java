package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.*;

import java.util.List;


/**
*/
public interface RegisterUniversalFilterChainService {

	public List<List<Object>> HierarchicalFuzzySearchDataJTTP(String company,String dataVersion) throws Exception;

}
