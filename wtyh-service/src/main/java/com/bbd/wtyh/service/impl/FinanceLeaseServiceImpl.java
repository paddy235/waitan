package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.vo.CompanyCapitalVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseStatisticVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import com.bbd.wtyh.domain.vo.FinanceLeasecCompanyVO;
import com.bbd.wtyh.mapper.FinanceLeaseMapper;
import com.bbd.wtyh.service.FinanceLeaseService;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesBarsLineBean;
import org.apache.commons.beanutils.converters.DoubleConverter;
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


    /**
     * @author suyin
     *
     * */
    public XAxisSeriesBarsLineBean companysAndMoney(){
        List<CompanyCapitalVO> list = financeLeaseMapper.queryCompanysAndCapital();
        XAxisSeriesBarsLineBean<Double,Integer> bean = new XAxisSeriesBarsLineBean();

        int rmb = 0;
        int us = 0;
        int company = 0;
        for (int k=0;k<list.size();k++) {
            CompanyCapitalVO vo = list.get(k);
            us+=vo.getUs();
            company+=vo.getCompanyNumber();
            rmb+=vo.getRmb();
            if(k>list.size()-6){
                bean.getxAxis().add(vo.getYear());
                bean.getSeries().getLine().add((double)company);
                bean.getSeries().getBar()[0].add(CalculateUtils.divide(rmb,10000,2));
                bean.getSeries().getBar()[1].add(CalculateUtils.divide(us,10000,2));
            }

        }

        return bean;
    }

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


            Integer minYear = financeLeaseMapper.queryFinanceLeaseMinYear();
            Integer maxYear = financeLeaseMapper.queryFinanceLeaseMaxYear();
            Map<Integer, Integer> tempMap = new LinkedHashMap<>();
            for (int i=minYear; i<=maxYear; i++) {
                tempMap.put(i, i);
            }
            Map paramMap = new HashedMap();
            for (Integer key : tempMap.keySet()) {
                if (yearCompanyNumberMap.get(key) == null) {
                    xAxis.add(key);
                    lineList.add(0);
                } else {
                    xAxis.add(key);
                    lineList.add(yearCompanyNumberMap.get(key));
                }


                for (int j=1; j<3; j++) {
                    paramMap.put("year", key);
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
    public List<FinanceLeasecCompanyVO> leaseCompanyList(String areaName, Integer analysisResult, Integer riskA, Integer riskB, Integer riskC, Integer riskD) {
        Map paramsMap = new HashedMap();

        paramsMap.put("areaName", areaName);

        List<FinanceLeasecCompanyVO> tempList = new ArrayList<>();
        List<FinanceLeaseVO> set = financeLeaseMapper.queryLeaseCompanyList(paramsMap);
        Map<String, FinanceLeasecCompanyVO> resultMap = new HashedMap();

        if (!CollectionUtils.isEmpty(set)) {
            for (FinanceLeaseVO financeLeaseVO : set) {
                String companyName = financeLeaseVO.getCompanyName();
                String address = financeLeaseVO.getAddress();
                Integer riskType = financeLeaseVO.getRiskType();
                Integer riskStatus = financeLeaseVO.getRiskStatus();
                String riskStatusString = null;
                if (riskStatus != null && riskStatus == 1) {
                    riskStatusString = "是";
                }
                if (resultMap.get(companyName) == null) {
                    FinanceLeasecCompanyVO financeLeasecCompanyVO = new FinanceLeasecCompanyVO();
                    financeLeasecCompanyVO.setCompanyName(companyName);
                    financeLeasecCompanyVO.setAddress(address);
                    financeLeasecCompanyVO.setRiskStatus("正常");
                    if (riskStatus != null && riskStatus == 1) {
                        financeLeasecCompanyVO.setRiskStatus("潜在");
                    }
                    if (riskType != null && riskType == 1) {
                        financeLeasecCompanyVO.setRiskStatusA(riskStatusString);
                    } else if (riskType != null && riskType == 2) {
                        financeLeasecCompanyVO.setRiskStatusB(riskStatusString);
                    } else if (riskType != null && riskType == 3) {
                        financeLeasecCompanyVO.setRiskStatusC(riskStatusString);
                    } else if (riskType != null && riskType == 4) {
                        financeLeasecCompanyVO.setRiskStatusD(riskStatusString);
                    } else {
                        //do nothing
                    }
                    resultMap.put(companyName, financeLeasecCompanyVO);
                } else {
                    if (riskStatus == 1) {
                        resultMap.get(companyName).setRiskStatus("潜在");
                    }
                    if (riskType != null && riskType == 1) {
                        resultMap.get(companyName).setRiskStatusA(riskStatusString);
                    } else if (riskType != null && riskType == 2) {
                        resultMap.get(companyName).setRiskStatusB(riskStatusString);
                    } else if (riskType != null && riskType == 3) {
                        resultMap.get(companyName).setRiskStatusC(riskStatusString);
                    } else if (riskType != null && riskType == 4) {
                        resultMap.get(companyName).setRiskStatusD(riskStatusString);
                    } else {
                        //do nothing
                    }
                }
            }
        }
        List<FinanceLeasecCompanyVO> resultList = new ArrayList<>();
        if (resultMap != null) {
            for (String key : resultMap.keySet()) {
                tempList.add(resultMap.get(key));
            }
        }
        if (!CollectionUtils.isEmpty(tempList)) {

            for (FinanceLeasecCompanyVO financeLeasecCompanyVO : tempList) {
                String riskStatus = financeLeasecCompanyVO.getRiskStatus();
                if (analysisResult == null) {
                    resultList.add(financeLeasecCompanyVO);
                } else if (analysisResult != null && analysisResult == 0 && "正常".equals(riskStatus)) {
                    resultList.add(financeLeasecCompanyVO);
                } else if (analysisResult != null && analysisResult == 1 && "潜在".equals(riskStatus)) {
                    resultList.add(financeLeasecCompanyVO);
                }
            }
            if (analysisResult != null && analysisResult == 1) {
                List<FinanceLeasecCompanyVO> resultListRisk = new ArrayList();
                for (FinanceLeasecCompanyVO financeLeasecCompanyVO : resultList) {
                    String riskStatusA = financeLeasecCompanyVO.getRiskStatusA();
                    String riskStatusB = financeLeasecCompanyVO.getRiskStatusB();
                    String riskStatusC = financeLeasecCompanyVO.getRiskStatusC();
                    String riskStatusD = financeLeasecCompanyVO.getRiskStatusD();

                    if(riskA != null && riskA == 1 && !"是".equals(riskStatusA)) {
                        continue;
                    }
                    if(riskB != null && riskB == 1 && !"是".equals(riskStatusB)) {
                        continue;
                    }
                    if(riskC != null && riskC == 1 && !"是".equals(riskStatusC)) {
                        continue;
                    }
                    if(riskD != null && riskD == 1 && !"是".equals(riskStatusD)) {
                        continue;
                    }
                    resultListRisk.add(financeLeasecCompanyVO);
                }
                return resultListRisk;
            }
        }

        return resultList;
    }

    @Override
    public List<String> getYears() {
        return financeLeaseMapper.getYears();
    }

    @Override
    public CompanyInfo getTenancy(String name) {
        return financeLeaseMapper.getTenancyByName(name);
    }
}
