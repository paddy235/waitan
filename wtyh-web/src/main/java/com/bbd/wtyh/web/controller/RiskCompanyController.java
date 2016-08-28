package com.bbd.wtyh.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bbd.wtyh.domain.vo.CompanySearchVO;
import com.bbd.wtyh.domain.vo.CompanyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RiskCompanyInfoDO;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.RiskCompanyService;
import com.bbd.wtyh.util.relation.StringUtils;
import com.bbd.wtyh.web.ResponseBean;

@Controller
@RequestMapping(value = "/risk")
public class RiskCompanyController {

	@Autowired
	private RiskCompanyService riskCompanyService;
	@Autowired
	private CompanyService companyService;
	private static final String BG_GQ_MARK = "0"; // 0：国企背景
	private static final String BG_SS_MARK = "1"; // 1：上市公司背景
	private static final int MAX_COUNT = 201; // 最大查询返回数据量
	private static final int MAX_PAGE_NO = 21; // 最大分页页数
	private static final String SPE_STR = "[`~!@#$%^&*+=|{}':;',//[//].<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]";

	@RequestMapping(value = "/getScanner")
	@ResponseBody
	public ResponseBean getScanner(@RequestParam(required = false) String area,
			@RequestParam(required = false) String minRegCapital, @RequestParam(required = false) String maxRegCapital,
			@RequestParam(required = false) String companyQualification,
			@RequestParam(required = false) String minReviewTime,
			@RequestParam(required = false) String maxReviewTime) {
		Map<String, Object> params = this.fillMap(area, minRegCapital, maxRegCapital, companyQualification,
				minReviewTime, maxReviewTime);
		return ResponseBean.successResponse(riskCompanyService.getScanner(params));
	}

	@RequestMapping(value = "/getTop")
	@ResponseBody
	public ResponseBean getTop(@RequestParam(required = false) String area,
			@RequestParam(required = false) String minRegCapital, @RequestParam(required = false) String maxRegCapital,
			@RequestParam(required = false) String companyQualification,
			@RequestParam(required = false) String minReviewTime, @RequestParam(required = false) String maxReviewTime,
			@RequestParam(defaultValue = "0") String sortType, @RequestParam int pageNo) {
		Map<String, Object> params = this.fillMap(area, minRegCapital, maxRegCapital, companyQualification,
				minReviewTime, maxReviewTime);
		params.put("sortType", sortType); // 排序方式
		int count = riskCompanyService.getTopCount(params);
		Pagination pagination = new Pagination();
		pagination.setCount(count >= MAX_COUNT ? MAX_COUNT - 1 : count); // 搜索结果最多保留200条数据
		if (pageNo >= MAX_PAGE_NO || pageNo <= -1) {
			pagination.setList(null);
			return ResponseBean.errorResponse("错误的分页请求参数！");
		}
		pagination.setPageNumber(pageNo);
		params.put("pagination", pagination);
		List<RiskCompanyInfoDO> list = riskCompanyService.getTop(params);
		if (null != list && list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				RiskCompanyInfoDO tmp = list.get(i);
				if ("0".equals(sortType)) {
					tmp.setRanking(pagination.getCount() - i - (pagination.getPageNumber() - 1) * pagination.getPageSize());
				} else {
					tmp.setRanking(i + 1 + (pagination.getPageNumber() - 1) * pagination.getPageSize());
				}
			}
		}
		pagination.setList(list);
		return ResponseBean.successResponse(pagination);
	}

	private Map<String, Object> fillMap(String area, String minRegCapital, String maxRegCapital,
			String companyQualification, String minReviewTime, String maxReviewTime) {
		Map<String, Object> map = new HashMap<>();
		map.put("area", area);
		map.put("minRegCapital", StringUtils.isNotNullOrEmpty(minRegCapital) ? new BigDecimal(minRegCapital) : null);
		map.put("maxRegCapital", StringUtils.isNotNullOrEmpty(maxRegCapital) ? new BigDecimal(maxRegCapital) : null);
		if (BG_GQ_MARK.equals(companyQualification))
			map.put("companyQualification", "0|1");
		else if (BG_SS_MARK.equals(companyQualification))
			map.put("companyQualification", "1|0");
		map.put("minReviewTime", StringUtils.isNotNullOrEmpty(minReviewTime) ? new BigDecimal(minReviewTime) : null);
		map.put("maxReviewTime", StringUtils.isNotNullOrEmpty(maxReviewTime) ? new BigDecimal(maxReviewTime) : null);
		return map;
	}

	@RequestMapping(value = "/doSearch")
	@ResponseBody
	public ResponseBean doSearch(@RequestParam(required = false) String keyword, @RequestParam int pageNo) {
		keyword = this.strFilter(keyword);
		String dataVersion = riskCompanyService.getLastDataVersion();
		int count = companyService.searchCompanyNameCount(keyword, dataVersion);
		Pagination pagination = new Pagination();
		pagination.setCount(count >= MAX_COUNT ? MAX_COUNT - 1 : count); // 搜索结果最多保留200条数据
		if (pageNo >= MAX_PAGE_NO || pageNo <= -1) {
			pagination.setList(null);
			return ResponseBean.errorResponse("错误的分页请求参数！");
		}
		pagination.setPageNumber(pageNo);
		pagination.setPageSize(8); // 每页展示8个
		Map<String, Object> params = new HashMap<>();
		params.put("keyword", keyword);
		params.put("pagination", pagination);
		params.put("dataVersion", dataVersion);
		List<CompanyDO> list = companyService.searchCompanyName(params);
		List<CompanySearchVO> resultList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(list)) {
			for (CompanyDO companyDO : list) {
				CompanySearchVO companySearchVO = new CompanySearchVO();
				companySearchVO.setName(companyDO.getName());
				companySearchVO.setAddress(companyDO.getAddress());
				companySearchVO.setCompanyType(companyDO.getCompanyType());
				companySearchVO.setLegalPerson(companyDO.getLegalPerson());
				companySearchVO.setStaticRisk(companyDO.getStaticRisk());
				companySearchVO.setRegisteredDate(companyDO.getRegisteredDate());
				if (companyDO.getRegisteredCapitalType() != null) {
					if (companyDO.getRegisteredCapitalType() == 1) {
						companySearchVO.setRegisteredCapital(companyDO.getRegisteredCapital() + "万人民币");
					}
					if (companyDO.getRegisteredCapitalType() == 2) {
						companySearchVO.setRegisteredCapital(companyDO.getRegisteredCapital() + "万美元");
					}
				}
				resultList.add(companySearchVO);
			}
		}

		pagination.setList(resultList);

		return ResponseBean.successResponse(pagination);
	}

	/**
	 * 特殊字符过滤
	 *
	 * @param s
	 * @return
	 */
	private String strFilter(String s) {
		if (StringUtils.isNotNullOrEmpty(s)) {
			Pattern p = Pattern.compile(SPE_STR);
			Matcher m = p.matcher(s);
			return m.replaceAll("").trim();
		}
		return null;
	}

}
