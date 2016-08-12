package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.NvDO;

import java.util.List;

/**
* 公司舆情接口
* @author tracy zhou
* @since  2016.8.12
*/
public interface CompanyNewsService {

	public List getCompanyNews(String company);
}
