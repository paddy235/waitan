package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.PrivateFundCompanyDTO;

import java.util.List;

/**
 * Created by Marco on 2016/8/10.
 */
public interface PrivateFundService {

    List<QdlpProgressDO> qdlpProgressList();

    List<QflpCompanyDO> qflpCompanyList();

    List<PrivateFundStatisticDO> typeStatisticList();

    PrivateFundTypeDO getTypeById(Integer privateFundTypeId);

    FundProductTypeDO getProductTypeById(Integer productTypeId);

    List<FundProductStatisticDO> productTypeStatisticList();

    List<ProductAmountDO> topProductNumber(Integer numbers);


    List<CapitalAmountDO> capitalAmount();

    List<InvestmentReturnStatisticDO> investmentReturn();

    List<InvestmentStatisticDO> investmentAmount();

    List<PrivateFundCompanyDTO> privateFundExtraList(Integer orderByField, String descAsc, Integer recordStatus);

}
