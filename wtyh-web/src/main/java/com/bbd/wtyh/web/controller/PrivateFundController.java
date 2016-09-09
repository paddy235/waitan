package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.domain.enums.CompanyProgress;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.PrivateFundService;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/8/10.
 */
@RestController
@RequestMapping("/privateFund/")
public class PrivateFundController {

    @Autowired
    private PrivateFundService privateFundService;
    @Autowired
    private CompanyService companyService;


    @RequestMapping("qdlpProgressList.do")
    public ResponseBean qdlpProgressList() {
        List<QdlpProgressDO> progressDOList = privateFundService.qdlpProgressList();
        List<QdlpProgressDTO> dtoList = Lists.newArrayList();
        Multimap<String, String> architectureMap = ArrayListMultimap.create();
        for (QdlpProgressDO progressDO : progressDOList) {
            QdlpProgressDTO progressDTO = new QdlpProgressDTO();
            progressDTO.setCompanyName(companyService.getNameById(progressDO.getCompanyId()));
            progressDTO.setProgress(CompanyProgress.getName(progressDO.getProgress()));
            progressDTO.setQuatas(progressDO.getQuatas());
            progressDTO.setArchitecture(progressDO.getArchitecture());
            List<String> shareholders = Lists.newArrayList();
            if (StringUtils.isNotEmpty(progressDO.getChinaShareholder())) {
                shareholders.add(progressDO.getChinaShareholder());
            }
            if (StringUtils.isNotEmpty(progressDO.getForeignShareholder())) {
                shareholders.add(progressDO.getForeignShareholder());
            }
            progressDTO.setShareholders(shareholders);
            dtoList.add(progressDTO);
            architectureMap.put(progressDTO.getArchitecture(), progressDTO.getCompanyName());
        }


        Map<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("list", dtoList);
        resultMap.put("architectureMap", architectureMap.asMap());
        return ResponseBean.successResponse(resultMap);
    }


    @RequestMapping("qflpInfoList.do")
    public ResponseBean qflpInfoList() {
        List<QflpCompanyDO> companyDOList = privateFundService.qflpCompanyList();
        List<QflpCompanyDTO> result = Lists.newArrayList();
        for (QflpCompanyDO companyDO : companyDOList) {
            QflpCompanyDTO companyDTO = new QflpCompanyDTO();
            companyDTO.setCompanyName(companyService.getNameById(companyDO.getCompanyId()));
            companyDTO.setDollarPart(companyDO.getDollorPart());
            companyDTO.setRmbTotal(companyDO.getRmbPart());
            companyDTO.setTotal(companyDO.getScale());
            result.add(companyDTO);
        }
        return ResponseBean.successResponse(result);
    }


    @RequestMapping("typeStatistic.do")
    public ResponseBean typeStatistic() {
        List<PrivateFundStatisticDO> statisticList = privateFundService.typeStatisticList();
        Map<Integer, PrivateFundTypeStatisticDTO> typeId2DTO = Maps.newHashMap();
        for (PrivateFundStatisticDO statisticDO : statisticList) {
            PrivateFundTypeStatisticDTO statisticDTO = new PrivateFundTypeStatisticDTO();
            statisticDTO.setAmount(statisticDO.getAmount());
            statisticDTO.setTypeName(privateFundService.getTypeById(statisticDO.getTypeId().intValue()).getTypeName());
            typeId2DTO.put(statisticDO.getTypeId().intValue(), statisticDTO);
        }
        List<PrivateFundTypeStatisticDTO> statisticDTOList = Lists.newArrayList();
        for (PrivateFundStatisticDO statisticDO : statisticList) {
            int parentId = privateFundService.getTypeById(statisticDO.getTypeId().intValue()).getTypeParentId();
            if (parentId > 0) {
                typeId2DTO.get(parentId).getChildren().add(typeId2DTO.get(statisticDO.getTypeId().intValue()));
            } else {
                statisticDTOList.add(typeId2DTO.get(statisticDO.getTypeId().intValue()));
            }
        }
        return ResponseBean.successResponse(statisticDTOList);


    }


    @RequestMapping("productTypeStatistic.do")
    public ResponseBean productTypeStatistic() {
        List<FundProductStatisticDO> productTypeStaticticList = privateFundService.productTypeStatisticList();
        List<PrivateFundProductTypeStatisticDTO> result = Lists.newArrayList();
        for (FundProductStatisticDO statisticDO : productTypeStaticticList) {
            PrivateFundProductTypeStatisticDTO statisticDTO = new PrivateFundProductTypeStatisticDTO();
            statisticDTO.setTypeName(privateFundService.getProductTypeById(statisticDO.getProductTypeId()).getProductTypeName());
            statisticDTO.setAmount(statisticDO.getProductNumber());
            result.add(statisticDTO);
        }
        return ResponseBean.successResponse(result);
    }


    @RequestMapping("topProductNumber.do")
    public ResponseBean topProductNumber(Integer numbers) {
        if (null == numbers || numbers <= 0) {
            numbers = 10;
        }

        List<ProductAmountDO> productAmountDOs = privateFundService.topProductNumber(numbers);
        List<Map<String, Object>> result = Lists.newArrayList();
        for (ProductAmountDO amountDO : productAmountDOs) {
            Map<String, Object> topProductNumber = Maps.newHashMap();
            topProductNumber.put("companyName", companyService.getNameById(amountDO.getCompanyId()));
            topProductNumber.put("productNumber", amountDO.getProductNumber());
            result.add(topProductNumber);
        }
        return ResponseBean.successResponse(result);
    }


    @RequestMapping("capitalAmount.do")
    public ResponseBean capitalAmount() {
        List<CapitalAmountDO> capitalAmountList = privateFundService.capitalAmount();
        List<Map<String, Object>> result = Lists.newArrayList();

        for (CapitalAmountDO capitalAmountDO : capitalAmountList) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("typeName", privateFundService.getTypeById(capitalAmountDO.getTypeId()).getTypeName());
            map.put("managedCapitalAmount", capitalAmountDO.getManagedCapitalAmount());
            map.put("publishCompanyNumber", capitalAmountDO.getPublishCompanyNumber());
            result.add(map);
        }

        return ResponseBean.successResponse(result);


    }

    @RequestMapping("investmentReturn.do")
    public ResponseBean investmentReturn() {
        List<InvestmentReturnStatisticDO> statisticList = privateFundService.investmentReturn();
        return ResponseBean.successResponse(statisticList);

    }


    @RequestMapping("investmentAmount.do")
    public ResponseBean investmentAmount() {
        List<InvestmentStatisticDO> list = privateFundService.investmentAmount();

        for (InvestmentStatisticDO irs : list) {
            //从百万元转换单位为亿元
            irs.setInvestmentAmount(CalculateUtils.divide(irs.getInvestmentAmount(), 100, 2));
        }

        return ResponseBean.successResponse(list);
    }


    @RequestMapping("privateFundList.do")
    public ResponseBean privateFundList(Integer orderByField, String descAsc, Integer recordStatus) {
        if (null != recordStatus && recordStatus <= 0) {
            recordStatus = null;
        }
        return ResponseBean.successResponse(privateFundService.privateFundExtraList(orderByField, descAsc, recordStatus));
    }


}
