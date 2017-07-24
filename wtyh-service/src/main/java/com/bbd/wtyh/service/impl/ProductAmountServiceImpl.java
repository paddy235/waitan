package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.ProductAmountDO;
import com.bbd.wtyh.mapper.ProductAmountMapper;
import com.bbd.wtyh.service.ProductAmountService;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.core.base.BaseServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cgj on 2017-7-23.
 */
@Service
public class ProductAmountServiceImpl extends BaseServiceImpl implements ProductAmountService {

	@Resource
	private ProductAmountMapper productAmountMapper;

	@Override
	public ProductAmountDO selectByPrimaryKey(Integer companyId) {
		return productAmountMapper.selectByPrimaryKey(companyId);
	}

	@Override
	public List<ProductAmountDO> topProductNumber(Integer numbers) {
		return productAmountMapper.topProductNumber(numbers);
	}
}
