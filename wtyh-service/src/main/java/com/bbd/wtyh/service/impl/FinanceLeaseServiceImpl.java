package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.vo.FinanceLeaseStatisticVO;
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
import java.util.LinkedHashMap;
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
    public Map leaseCompanyStatistic() {
        List<FinanceLeaseStatisticVO> list = financeLeaseMapper.queryFinanceLeaseStatistic(null);
        List xAxis = new ArrayList();
        List series = new ArrayList();
        List barList = new ArrayList();
        List lineList = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) {
            Map<Integer, Integer> yearCompanyNumberMap = new LinkedHashMap<>();
            Map<Integer, List> yearCapitalMap = new LinkedHashMap<>();


            for (FinanceLeaseStatisticVO financeLeaseStatisticVO : list) {
                List yearCapitalList = new ArrayList();
                Integer year = financeLeaseStatisticVO.getYear();
                if (yearCompanyNumberMap.get(year) != null) {
                    Integer tempCompanyNumber = yearCompanyNumberMap.get(year) == null ? 0 : Integer.parseInt(yearCompanyNumberMap.get(year).toString());
                    tempCompanyNumber += financeLeaseStatisticVO.getCompanyNumber();
                    yearCompanyNumberMap.put(year,tempCompanyNumber);
                } else {
                    yearCompanyNumberMap.put(year,financeLeaseStatisticVO.getCompanyNumber());
                }
                Integer registeredCapital = financeLeaseStatisticVO.getRegisteredCapital();
                if (yearCapitalMap.get(year) != null) {
                    yearCapitalMap.get(year).add(registeredCapital);
                } else {
                    yearCapitalList.add(registeredCapital);
                    yearCapitalMap.put(year,yearCapitalList);
                }
            }

            for (Integer key : yearCompanyNumberMap.keySet()) {
                xAxis.add(key);
                lineList.add(yearCompanyNumberMap.get(key));
            }

            for (Integer key : yearCapitalMap.keySet()) {
                barList.add(yearCapitalMap.get(key));
            }
        }

        Map seriesMap = new HashedMap();
        Map contentMap = new HashedMap();
        seriesMap.put("bar",barList);
        seriesMap.put("line",lineList);
        contentMap.put("xAxis",xAxis);
        contentMap.put("series",seriesMap);
        return contentMap;
    }

    @Override
    public Map leaseCompanyCategory(Integer year) {
        List<Map> list = financeLeaseMapper.queryFinanceLeaseCompanyCategory(year);
        Integer inAreaNumber  = 0;
        Integer outAreaNumber = 0;
        Integer companyNumber = 0;
        if (!CollectionUtils.isEmpty(list)) {
            for (Map map : list) {
                if ((Boolean)map.get("freeTradeZone") == true) {
                    inAreaNumber = Integer.parseInt(map.get("companyNumber").toString());
                } else {
                    outAreaNumber = Integer.parseInt(map.get("companyNumber").toString());
                }
            }
        }
        companyNumber = inAreaNumber + outAreaNumber;
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
