package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.ProductAmountDO;
import com.bbd.wtyh.domain.query.CompanyQuery;

/**
 * Created by cgj on 2017-7-23.
 */
public interface ProductAmountService extends BaseService {

	ProductAmountDO selectByPrimaryKey(Integer companyId);

	List<ProductAmountDO> topProductNumber(Integer numbers);

	//void update( ProductAmountDO pa );
}
