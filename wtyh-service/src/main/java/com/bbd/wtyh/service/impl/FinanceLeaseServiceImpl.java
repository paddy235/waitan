package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.FinanceLeaseStatisticDO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import com.bbd.wtyh.mapper.FinanceLeaseMapper;
import com.bbd.wtyh.service.FinanceLeaseService;
import com.bbd.wtyh.util.CalculateUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 融资租赁接口实现层
 * @author zhouxuan
 * @since  2016.08.10
 */
@Service("financeLeaseService")
public class FinanceLeaseServiceImpl implements FinanceLeaseService {
    private Logger logger = LoggerFactory.getLogger(FinanceLeaseServiceImpl.class);

    @Resource
    private FinanceLeaseMapper financeLeaseMapper;

    @Override
    public Map leaseCompanyNumber() {
        List<FinanceLeaseStatisticDO> list = financeLeaseMapper.queryFinanceLeaseStatisticDO(null);
        List xAxis = new ArrayList();
        List series = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) {
            for (FinanceLeaseStatisticDO financeLeaseStatisticDO : list) {
                xAxis.add(financeLeaseStatisticDO.getYear());
                series.add(financeLeaseStatisticDO.getCompanyNumber());
            }
        }
        Map map = new HashedMap();
        map.put("xAxis", xAxis);
        map.put("series", series);
        return map;
    }

    @Override
    public Map leaseCompanyCategory(Integer year) {
        List<FinanceLeaseStatisticDO> list = financeLeaseMapper.queryFinanceLeaseStatisticDO(year);
        Integer inAreaNumber  = 0;
        Integer outAreaNumber = 0;
        Integer companyNumber = 0;
        if (!CollectionUtils.isEmpty(list)) {
            FinanceLeaseStatisticDO financeLeaseStatisticDO = list.get(0);
            inAreaNumber = financeLeaseStatisticDO.getInAreaNumber();
            outAreaNumber = financeLeaseStatisticDO.getOutAreaNumber();
            companyNumber = financeLeaseStatisticDO.getCompanyNumber();
        }
        double inRate  = CalculateUtils.divide(inAreaNumber, companyNumber, 2);
        double outRate = CalculateUtils.divide(outAreaNumber, companyNumber, 2);
        Map<String, String> map = new HashedMap();
        map.put("inAreaNumber", inAreaNumber.toString());
        map.put("outAreaNumber", outAreaNumber.toString());
        map.put("inRate", String.valueOf(inRate));
        map.put("outRate", String.valueOf(outRate));
        return map;
    }

    @Override
    public Map leaseCompanyAmount() {
        List<FinanceLeaseStatisticDO> list = financeLeaseMapper.queryFinanceLeaseStatisticDO(null);
        Map content = new HashedMap();
        List seriesList  = new ArrayList();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List xAxis = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) {
            for (FinanceLeaseStatisticDO financeLeaseStatisticDO : list) {
                list1.add(financeLeaseStatisticDO.getTotalAmout());
                list2.add(financeLeaseStatisticDO.getBalance());
                xAxis.add(financeLeaseStatisticDO.getYear());
            }
        }
        seriesList.add(list1);
        seriesList.add(list2);
        content.put("xAxis", xAxis);
        content.put("series", seriesList);
        return content;
    }

    @Override
    public Map leaseCompanyBadRatioAndAmount() {
        List<FinanceLeaseStatisticDO> list = financeLeaseMapper.queryFinanceLeaseStatisticDO(null);
        Map content = new HashedMap();
        Map series = new HashedMap();
        List bar = new ArrayList();
        List line = new ArrayList();
        List xAxis = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) {
            for (FinanceLeaseStatisticDO financeLeaseStatisticDO : list) {
                bar.add(financeLeaseStatisticDO.getBadAmout());
                line.add(financeLeaseStatisticDO.getBadRatio());
                xAxis.add(financeLeaseStatisticDO.getYear());
            }
        }
        series.put("bar",bar);
        series.put("line",line);
        content.put("xAxis", xAxis);
        content.put("series", series);
        return content;
    }

    @Override
    public List<FinanceLeaseVO> leaseCompanyList(Integer areaId, Integer analysisResult, Integer riskA, Integer riskB, Integer riskC, Integer riskD) {
        Map map = new HashedMap();
        riskA = riskA == null ? 2 : riskA;
        riskB = riskB == null ? 2 : riskB;
        riskC = riskC == null ? 2 : riskC;
        riskD = riskD == null ? 2 : riskD;
        map.put("areaId", areaId);
        map.put("analysisResult", analysisResult);
        map.put("riskA", riskA);
        map.put("riskB", riskB);
        map.put("riskC", riskC);
        map.put("riskD", riskD);
        List<FinanceLeaseVO> list = financeLeaseMapper.queryLeaseCompanyList(map);
        if (!CollectionUtils.isEmpty(list)) {
            for (FinanceLeaseVO financeLeaseVO : list) {
                financeLeaseVO.setRiskA(riskA);
                financeLeaseVO.setRiskB(riskB);
                financeLeaseVO.setRiskC(riskC);
                financeLeaseVO.setRiskD(riskD);
            }
        }
        return list;
    }
}
