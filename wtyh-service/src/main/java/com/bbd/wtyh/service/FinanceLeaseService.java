package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import com.bbd.wtyh.domain.vo.FinanceLeasecCompanyVO;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesBarsLineBean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 融资租赁接口层
 * @author zhouxuan
 * @since  2016.08.10
 */
public interface FinanceLeaseService {

    public Map leaseCompanyStatistic();

    public Map leaseCompanyCategory(Integer year);

    public List<FinanceLeasecCompanyVO> leaseCompanyList(String areaName, Integer analysisResult, Integer riskA, Integer riskB, Integer riskC, Integer riskD);

    List<String> getYears();

    XAxisSeriesBarsLineBean companysAndMoney();
}
