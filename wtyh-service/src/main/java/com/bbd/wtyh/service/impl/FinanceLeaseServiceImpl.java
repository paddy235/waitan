package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.vo.FinanceLeaseStatisticVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import com.bbd.wtyh.mapper.FinanceLeaseMapper;
import com.bbd.wtyh.service.FinanceLeaseService;
import com.bbd.wtyh.util.CalculateUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

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
        List barList = new ArrayList();
        List barList1 = new ArrayList();
        List barList2 = new ArrayList();
        List lineList = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) {
            Map<Integer, Integer> yearCompanyNumberMap = new LinkedHashMap<>();
            Map<Integer, Integer> yearCapitalMap = new LinkedHashMap<>();
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
                    registeredCapital += yearCapitalMap.get(year);
                    yearCapitalMap.put(year, registeredCapital);
                } else {
                    yearCapitalMap.put(year,registeredCapital);
                }
            }

            for (Integer key : yearCompanyNumberMap.keySet()) {
                xAxis.add(key);
                lineList.add(yearCompanyNumberMap.get(key));
            }

            for (Integer key : yearCapitalMap.keySet()) {
                System.out.println("----"+key+"---"+yearCapitalMap.get(key));
//                barList.add(yearCapitalMap.get(key));
            }
        }
        barList1.add(111);
        barList1.add(122);
        barList1.add(1232);
        barList1.add(12341);
        barList2.add(111);
        barList2.add(122);
        barList2.add(1232);
        barList2.add(12341);
        barList.add(barList1);
        barList.add(barList2);
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
                if (map.get("freeTradeZone") == null) {
                    continue;
                }
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
        map.put("areaId", areaId);
        map.put("analysisResult", analysisResult);
        map.put("riskA", riskA);
        map.put("riskB", riskB);
        map.put("riskC", riskC);
        map.put("riskD", riskD);
        Map<String, FinanceLeaseVO> resultMap = new HashMap();
        List<FinanceLeaseVO> resultList = new ArrayList<>();
        List<FinanceLeaseVO> list = financeLeaseMapper.queryLeaseCompanyList(map);
        if (!CollectionUtils.isEmpty(list)) {
            for (FinanceLeaseVO financeLeaseVO : list) {
                String companyName = financeLeaseVO.getCompany();
                if (resultMap.get(companyName) == null) {
                    FinanceLeaseVO vo = new FinanceLeaseVO();
                    vo.setCompany(financeLeaseVO.getCompany());
                    vo.setAddress(financeLeaseVO.getAddress());
                    resultMap.put(companyName, vo);
                } else {
                    Integer riskType = financeLeaseVO.getRiskType();
                    Integer riskStatus = financeLeaseVO.getRiskStatus();
                    String status = financeLeaseVO.getStatus();
                    if (riskType != null && riskType == 1) {
                        resultMap.get(companyName).setRiskA(riskStatus);
                    } else if (riskType != null && riskType == 2) {
                        resultMap.get(companyName).setRiskB(riskStatus);
                    } else if (riskType != null && riskType == 3) {
                        resultMap.get(companyName).setRiskC(riskStatus);
                    } else if (riskType != null && riskType == 4) {
                        resultMap.get(companyName).setRiskD(riskStatus);
                    } else if (!StringUtils.isEmpty(status)) {
                        int statusInt = Integer.parseInt(status);
                        String statusString = "";
                        if (statusInt == 4) {
                            statusString = "正常";
                        } else if (statusInt == 3) {
                            statusString = "潜在";
                        } else if (statusInt == 2) {
                            statusString = "高危";
                        } else {
                            //do nothing
                        }
                        resultMap.get(companyName).setStatus(statusString);
                    }
                }
            }
        }
        if (resultMap != null) {
            for (String key : resultMap.keySet()) {
                resultList.add(resultMap.get(key));
            }
        }
        return resultList;
    }
}
