package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.vo.FinanceLeaseVO;

import java.util.List;
import java.util.Map;

/**
 * 融资租赁接口层
 * @author zhouxuan
 * @since  2016.08.10
 */
public interface FinanceLeaseService {

    public Map leaseCompanyStatistic();

    public Map leaseCompanyCategory(Integer year);

    public List<FinanceLeaseVO> leaseCompanyList(Integer areaId, Integer analysisResult, Integer riskA, Integer riskB, Integer riskC, Integer riskD);

}
