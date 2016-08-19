package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.vo.FinanceLeaseStatisticVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import com.bbd.wtyh.mapper.FinanceLeaseMapper;
import com.bbd.wtyh.service.FinanceLeaseService;
import com.bbd.wtyh.util.CalculateUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
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

            Set<Integer> yearSet = new LinkedHashSet<>();
            Map<Integer, Integer> yearCompanyNumberMap = new LinkedHashMap<>();
            for (FinanceLeaseStatisticVO financeLeaseStatisticVO : list) {
                Integer year = financeLeaseStatisticVO.getYear();
                yearSet.add(year);

                if (yearCompanyNumberMap.get(year) != null) {
                    Integer tempCompanyNumber = yearCompanyNumberMap.get(year) == null ? 0 : Integer.parseInt(yearCompanyNumberMap.get(year).toString());
                    tempCompanyNumber += financeLeaseStatisticVO.getCompanyNumber();
                    yearCompanyNumberMap.put(year, tempCompanyNumber);
                } else {
                    yearCompanyNumberMap.put(year, financeLeaseStatisticVO.getCompanyNumber());
                }
            }
            Map paramMap = new HashedMap();
            for (Integer year : yearSet) {
                for (int j=1; j<3; j++) {
                    paramMap.put("year", year);
                    paramMap.put("registeredCapitalType", j);
                    List<FinanceLeaseStatisticVO> tempList = financeLeaseMapper.queryFinanceLeaseStatistic(paramMap);
                    if (j == 1) {
                        if (CollectionUtils.isEmpty(tempList)) {
                            barList1.add(0);
                        } else {
                            barList1.add(tempList.get(0).getRegisteredCapital());
                        }
                    } else {
                        if (CollectionUtils.isEmpty(tempList)) {
                            barList2.add(0);
                        } else {
                            barList2.add(tempList.get(0).getRegisteredCapital());
                        }
                    }
                }
            }
            for (Integer key : yearCompanyNumberMap.keySet()) {
                xAxis.add(key);
                lineList.add(yearCompanyNumberMap.get(key));
            }
        }
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
    public List<FinanceLeaseVO> leaseCompanyList(String areaName, Integer analysisResult, Integer riskA, Integer riskB, Integer riskC, Integer riskD) {
        Map map = new HashedMap();
        map.put("areaName", areaName);
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
                Integer riskType   = financeLeaseVO.getRiskType();
                Integer riskStatus = financeLeaseVO.getRiskStatus();
                String riskStatusString = "";
                if (riskStatus == 1) {
                    riskStatusString = "是";
                } else if (riskStatus == 0) {
                    riskStatusString = "否";
                }
                if (resultMap.get(companyName) == null) {
                    FinanceLeaseVO vo = new FinanceLeaseVO();
                    vo.setCompany(financeLeaseVO.getCompany());
                    vo.setAddress(financeLeaseVO.getAddress());
                    vo.setStatus("正常");
                    if (riskStatus == 1) {
                        vo.setStatus("潜在");
                    }
                    if (riskType != null && riskType == 1) {
                        vo.setRiskA(riskStatusString);
                    } else if (riskType != null && riskType == 2) {
                        vo.setRiskB(riskStatusString);
                    } else if (riskType != null && riskType == 3) {
                        vo.setRiskC(riskStatusString);
                    } else if (riskType != null && riskType == 4) {
                        vo.setRiskD(riskStatusString);
                    } else {
                        //do nothing
                    }
                    resultMap.put(companyName, vo);
                } else {

                    if (riskStatus == 1) {
                        resultMap.get(companyName).setStatus("潜在");
                    }

                    if (riskType != null && riskType == 1) {
                        resultMap.get(companyName).setRiskA(riskStatusString);
                    } else if (riskType != null && riskType == 2) {
                        resultMap.get(companyName).setRiskB(riskStatusString);
                    } else if (riskType != null && riskType == 3) {
                        resultMap.get(companyName).setRiskC(riskStatusString);
                    } else if (riskType != null && riskType == 4) {
                        resultMap.get(companyName).setRiskD(riskStatusString);
                    } else {
                        //do nothing
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
