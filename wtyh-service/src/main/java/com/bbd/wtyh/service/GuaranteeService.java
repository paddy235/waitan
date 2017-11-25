package com.bbd.wtyh.service;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.GuaranteeBalanceDO;
import com.bbd.wtyh.domain.GuaranteedInfoDO;
import com.bbd.wtyh.domain.dto.GuaranteeBalanceByQuaterDTO;

import java.util.List;

/**
 * Created by Marco on 2016/8/8 0008.
 */
public interface GuaranteeService extends BaseService {

    List<GuaranteeBalanceDO> getGuaranteeBalanceByYear();

    List<GuaranteeBalanceDO> getGuaranteeBalanceByMonth();

    List<GuaranteeBalanceByQuaterDTO> getGuaranteeBalanceByQuarter();

    List<GuaranteedInfoDO> listLargeGuarantee(Pagination pagination, Integer orderByField, String descAsc);

    int countLargeGuarantee();

    GuaranteedInfoDO selectByPrimaryKey(Integer id);

    void updateG(GuaranteedInfoDO guaranteedInfoDO);
}
