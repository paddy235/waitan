package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.bbdAPI.RecordCompanyDO;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.domain.enums.CompanyProgress;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.PrivateFundService;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.web.PageBean;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

	@Autowired
	private HologramQueryDao hologramQueryDao;

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
	@LogRecord(logMsg = "浏览私募基金页面", page = Operation.Page.privateFund)
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


	@RequestMapping("capitalAmount.do")
	public ResponseBean capitalAmount() {
		List<CapitalAmountDO> capitalAmountList = privateFundService.capitalAmount();
		List<Map<String, Object>> result = Lists.newArrayList();

		for (CapitalAmountDO capitalAmountDO : capitalAmountList) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("typeName", privateFundService.getTypeById(capitalAmountDO.getTypeId()).getTypeName());
			map.put("managedCapitalAmount", capitalAmountDO.getManagedCapitalAmount());
			map.put("publishCompanyNumber", capitalAmountDO.getPublishCompanyNumber());
			map.put("dataVersion", capitalAmountDO.getDataVersion());
			result.add(map);
		}

		return ResponseBean.successResponse(result);

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



	@RequestMapping("investmentReturn.do")
	public ResponseBean investmentReturn() {
		LinkedList<InvestmentReturnStatisticDO> statisticList = privateFundService.investmentReturn();
		return ResponseBean.successResponse(statisticList);

	}

	@RequestMapping("investmentAmount.do")
	public ResponseBean investmentAmount() {
		LinkedList<InvestmentStatisticDO> list = privateFundService.investmentAmount();

		for (InvestmentStatisticDO irs : list) {
			// 从万元转换单位为亿元
			irs.setInvestmentAmount(CalculateUtils.divide(irs.getInvestmentAmount(), 10000, 4));
		}

		return ResponseBean.successResponse(list);
	}

	//新增私募企业查询接口
	@RequestMapping("privateFundQueryList.do")
	public ResponseBean privateFundQueryList(String companyName,Integer orderByField,String descAsc,Integer recordStatus,@RequestParam(defaultValue = "10") Integer pageSize,
											 @RequestParam(defaultValue = "1") Integer currentPage){
		int start = (currentPage-1)*pageSize;
		PageBean<PrivateFundCompanyDTO> pageInfo = privateFundService.privateFundQueryList(companyName,orderByField,descAsc,recordStatus,start,pageSize);

		if(CollectionUtils.isEmpty(pageInfo.getItems())){
			return ResponseBean.successResponse(pageInfo);
		}
		for (PrivateFundCompanyDTO dto : pageInfo.getItems()) {
			if (StringUtils.isNotEmpty(dto.getWebsite()) && !dto.getWebsite().startsWith("http")) {
				dto.setWebsite("http://" + dto.getWebsite());
			}
			String  res = hologramQueryDao.getCompanyInfo(dto.getName());
			if("1".equals(res)){
				dto.setRecordStatus(1);
			}

		}
		return ResponseBean.successResponse(pageInfo);
	}

	@RequestMapping("privateFundList.do")
	public ResponseBean privateFundList(Integer orderByField, String descAsc, Integer recordStatus,@RequestParam(defaultValue = "10") Integer pageSize,
										@RequestParam(defaultValue = "1") Integer currentPage) {
		if (null != recordStatus && recordStatus <= 0) {
			recordStatus = null;
		}
		Integer status = new Integer(2);
		//取消备案
		if(status.equals(recordStatus)){
			PageBean<PrivateFundCompanyDTO> pageInfo2 = privateFundService.privateFundExtraList(orderByField, descAsc, recordStatus,-1,pageSize);
			for (PrivateFundCompanyDTO dto : pageInfo2.getItems()) {
                if (StringUtils.isNotEmpty(dto.getWebsite()) && !dto.getWebsite().startsWith("http")) {
                    dto.setWebsite("http://" + dto.getWebsite());
                }
            }
			Long num = 0L;
            List<PrivateFundCompanyDTO> totalList = pageInfo2.getItems();
			List<PrivateFundCompanyDTO> totalList2 = totalList;
			for(int i=0;i<totalList.size();i++) {
				String  res2 = hologramQueryDao.getCompanyInfo(totalList.get(i).getName());
				if("1".equals(res2)){
					totalList2.remove(i);
					num++;
				}
			}
			Long  t_count = num;
			pageInfo2.setTotalCount(pageInfo2.getTotalCount()-t_count);
			pageInfo2.setCurrentPage(currentPage);
			pageInfo2.setPageSize(pageSize);
			int formIndex = (currentPage-1)*pageSize;
			int endIndex = currentPage*pageSize;
			if(endIndex>totalList.size()){
				endIndex = totalList.size();
			}
			pageInfo2.setItems(totalList2.subList(formIndex,endIndex));
			return ResponseBean.successResponse(pageInfo2);

		}

		//全部/已备案
		int start = (currentPage-1)*pageSize;
		PageBean<PrivateFundCompanyDTO> pageInfo = privateFundService.privateFundExtraList(orderByField, descAsc, recordStatus,start,pageSize);

		for (PrivateFundCompanyDTO dto : pageInfo.getItems()) {
			if (StringUtils.isNotEmpty(dto.getWebsite()) && !dto.getWebsite().startsWith("http")) {
				dto.setWebsite("http://" + dto.getWebsite());
			}
				String  res = hologramQueryDao.getCompanyInfo(dto.getName());
				if("1".equals(res)){
					dto.setRecordStatus(1);
				}

		}
		return ResponseBean.successResponse(pageInfo);
	}

}
