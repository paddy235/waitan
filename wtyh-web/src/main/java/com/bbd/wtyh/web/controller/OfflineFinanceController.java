package com.bbd.wtyh.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbd.wtyh.domain.SubIndexDO;
import com.bbd.wtyh.domain.dto.CreditRiskDataDTO;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.domain.CapitalAmountDO;
import com.bbd.wtyh.domain.MortgageStatisticDO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.vo.DynamicRiskVO;
import com.bbd.wtyh.domain.vo.MonthVO;
import com.bbd.wtyh.domain.vo.RelationDataVO;
import com.bbd.wtyh.domain.vo.StaticRiskVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesLinesBean;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;

/**
 * 线下理财
 *
 * @author tracy zhou
 * @since 2016/8/8
 */
@Controller
@RequestMapping("/offlineFinance/")
public class OfflineFinanceController {

	private static final Logger logger = LoggerFactory.getLogger(OfflineFinanceController.class);

	@Autowired
	private OfflineFinanceService offlineFinanceService;
	@Autowired
	private RelationDataService relationDataService;
	@Autowired
	private PToPMonitorService pToPMonitorService;
	@Autowired
	private LoanController loanController;
	@Autowired
	private MortgageController mortgageController;
	@Autowired
	private FactoringController factoringController;
	@Autowired
	private CrowdFundingController crowdFundingController;
	@Autowired
	private PrepaidCompanyController prepaidCompanyController;
	@Autowired
	private FinanceLeaseController financeLeaseController;
	@Autowired
	private PrivateFundService privateFundService;
	@Autowired
	private ExchangeCompanyService exchangeCompanyService;
	@Autowired
	private MortgageService mortgageService;
	@Autowired
	private GuaranteeController guaranteeController;
	@Autowired
	private HologramQueryService hologramQueryService;
	@Autowired
	private RelationService relationService;
	@Autowired
	private CoCreditScoreService coCreditScoreService;
	@Autowired
	private CompanyStaticRiskScoreService companyStaticRiskScoreService;

	/**
	 * 关联图谱
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryDynamicPicData.do")
	public @ResponseBody ResponseBean queryDynamicPicData(HttpServletRequest request) {
		String companyName = request.getParameter("companyName");
		String dataVersion = request.getParameter("dataVersion");
		String degreesLevel = request.getParameter("degreesLevel");
		try {
			if (StringUtils.isEmpty(companyName)) {
				return ResponseBean.errorResponse("companyName参数为空");
			}
            //与全息关联方保持一致
			RelationDiagramVO result = offlineFinanceService.queryRealRealation(companyName,null, Integer.valueOf(degreesLevel));
			if (result == null) {
				logger.error("无关联方图谱信息 --> 公司[" + companyName + "], dateVersion[" + dataVersion + "],关联度[" + degreesLevel + "]");
			}
			return ResponseBean.successResponse(result);
		} catch (Exception e) {
			logger.error("关联方图谱信息解析出错 --> 公司[" + companyName + "], dateVersion[" + dataVersion + "],关联度[" + degreesLevel + "]");
			logger.error(e.getMessage(), e);
			return ResponseBean.errorResponse("关联方图谱信息正在准备中，请稍后尝试");
		}
	}

	/**
	 * 关联图谱 - 查询(用去全息公司不带版本号)
	 *
	 * @param companyName
	 *            公司name
	 * @param degreesLevel
	 *            关联度(默认1)
	 * @return
	 */
	@RequestMapping(value = "/queryDynamicPicDataRealTime.do")
	@ResponseBody
	public ResponseBean queryDynamicPicDataTwo(@RequestParam String companyName,String bbdQyxxId,@RequestParam(defaultValue = "1") Integer degreesLevel) {
		try {
			RelationDiagramVO result = offlineFinanceService.queryRealRealation(companyName,bbdQyxxId,degreesLevel);

			return ResponseBean.successResponse(result);
		} catch (Exception e) {
			logger.error("RelationController->queryDynamicPicDataTwo", e);
			return ResponseBean.errorResponse("关联方图谱信息正在准备中，请稍后尝试");
		}
	}

	@RequestMapping(value = "/export-related-data")
	@ResponseBody
	public ResponseBean exportRelatedData(@RequestParam String companyName,String bbdQyxxId, HttpServletRequest request) {
		try {
			RelationDiagramVO result = offlineFinanceService.downloadRealRealation(companyName, 3);
			List<RelationDiagramVO.LineVO> lineList = result.getLineList();
			if (CollectionUtils.isEmpty(lineList)) {
				return ResponseBean.errorResponse(companyName + "：没有关联方数据！");
			}
			String excelName = "关联方明细-" + companyName;
			ExportExcel exportExcel = new ExportExcel(excelName);

			int totalCount = lineList.size();
			int pageSize = totalCount > 10000 ? 10000 : totalCount;
			int pageCount = (totalCount + pageSize - 1) / pageSize;

			int fromIndex;
			int toIndex;
			for (int i = 1; i <= pageCount; i++) {

				fromIndex = (i - 1) * pageSize;
				toIndex = fromIndex + pageSize;
				toIndex = toIndex < totalCount ? toIndex : totalCount;

				exportExcel.createSheet(companyName, lineList.subList(fromIndex, toIndex));
			}
			exportExcel.exportExcel();
			UserLogRecord.record("导出【" + companyName + "】关联方", Operation.Type.DATA_EXPORT, Operation.Page.hologram, Operation.System.front,
					request);

			// 数据落地
			relationService.addRelation(result, companyName,bbdQyxxId);

			return ResponseBean.successResponse(exportExcel.getDownloadURL());
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	/**
	 * 风险指数趋势变化图
	 *
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "queryStatistics.do")
	@ResponseBody

	public List<StatisticsVO> queryStatistics(HttpServletRequest request) throws ParseException {
		String companyName = request.getParameter("companyName");
		String tabIndex = request.getParameter("tabIndex");
		String areaCode = request.getParameter("areaCode");
		return offlineFinanceService.queryStatistics(companyName, tabIndex, areaCode);
	}

	/**
	 * 风险指数趋势变化图综合接口
	 *
	 * @param companyName
	 *            公司名称
	 * @param areaCode
	 *            区域代码
	 * @return Map<String,Object>
	 * @throws ParseException
	 * @author suyin
	 */
	@RequestMapping(value = "queryStatisticsMultiple.do")
	@ResponseBody
	public Map<String, Object> queryStatisticsMultiple(String companyName, String areaCode) throws ParseException {

		Map<String, Object> map = new HashMap<>();
		for (int tabIndex = 0; tabIndex < 8; tabIndex++) {
			Object o = offlineFinanceService.queryStatistics(companyName, "" + tabIndex, areaCode);
			map.put("tabIndex" + tabIndex, o);
		}
		map.remove("tabIndex2");
		return map;
	}

	/**
	 * 静态风险指数列表 currentDate 2016-04-07
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryRiskData.do")
	@ResponseBody
	public ResponseBean queryRiskData(HttpServletRequest request) {
		String companyName = request.getParameter("companyName");
		String currentDate = request.getParameter("currentDate");
		String areaCode = request.getParameter("areaCode");
		StaticRiskVO vo = offlineFinanceService.queryCurrentStaticRisk(companyName, currentDate, areaCode);
		SubIndexDO subIndexDO=companyStaticRiskScoreService.searchSubIndex(companyName);
		vo.setNormalHousehold(subIndexDO.getNormalHousehold());
		vo.setUnpaidInsurancePremium(subIndexDO.getUnpaidInsurancePremium());
		vo.setDiscreditExposure(subIndexDO.getDiscreditExposure());
		vo.setAdministrativeSanction(subIndexDO.getAdministrativeSanction());
		return ResponseBean.successResponse(vo);
	}

	/**
	 * 信用信息风险 currentDate 2017-09-07
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "creditRiskData.do")
	@ResponseBody
	public ResponseBean creditRiskData(HttpServletRequest request) {
		String companyName = request.getParameter("companyName");
//		List<CreditRiskDataDTO> list = coCreditScoreService.getResourceCounts(null,companyName);
		SubIndexDO subIndexDO=companyStaticRiskScoreService.searchSubIndex(companyName);
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("resourceName","非正常户认定");
		jsonObject.put("indexs",subIndexDO.getNormalHousehold());
		jsonObject.put("counts",subIndexDO.getNormalHouseholdNum());
		jsonArray.add(jsonObject);
		jsonObject.put("resourceName","用人单位欠缴社会保险费");
		jsonObject.put("indexs",subIndexDO.getUnpaidInsurancePremium());
		jsonObject.put("counts",subIndexDO.getUnpaidInsurancePremiumNum());
		jsonArray.add(jsonObject);
		jsonObject.put("resourceName","失信曝光");
		jsonObject.put("indexs",subIndexDO.getDiscreditExposure());
		jsonObject.put("counts",subIndexDO.getDiscreditExposureNum());
		jsonArray.add(jsonObject);
		jsonObject.put("resourceName","市场监管类行政处罚");
		jsonObject.put("indexs",subIndexDO.getAdministrativeSanction());
		jsonObject.put("counts",subIndexDO.getAdministrativeSanctionNum());
		jsonArray.add(jsonObject);
		jsonObject.put("resourceName","信用信息风险");
		jsonObject.put("indexs","");
		jsonObject.put("counts","");
		JSONArray jarr=new JSONArray();
		JSONObject job=new JSONObject();
		String restrictedExit="否";
		String LimetingHighConsumption="否";
		String onlineRecovery="否";
		if (subIndexDO.getRestrictedExit()>0){
			restrictedExit="是";
		}
		if (subIndexDO.getLimetingHighConsumption()>0){
			LimetingHighConsumption="是";
		}
		if (subIndexDO.getOnlineRecovery()>0){
			onlineRecovery="是";
		}
		job.put("resourceName","限制出境");
		job.put("res",restrictedExit);
		jarr.add(job);
		job.put("resourceName","限制高消费");
		job.put("res",LimetingHighConsumption);
		jarr.add(job);
		job.put("resourceName","网上追逃");
		job.put("res",onlineRecovery);
		jarr.add(job);
		job.put("resourceName","经营异常名录");
		job.put("res",subIndexDO.getExceptionList());
		jarr.add(job);
		job.put("resourceName","行政处罚");
		job.put("res",subIndexDO.getAdministrativeSanction2());
		jarr.add(job);
		job.put("resourceName","对不正当竞争行为处罚");
		job.put("res",subIndexDO.getBehaviorPunishment());
		jarr.add(job);
		jsonObject.put("data",jarr);
		jsonArray.add(jsonObject);
		return ResponseBean.successResponse(jsonArray);
	}

	/**
	 * 动态指数时间轴对比图
	 *
	 * @param companyName
	 * @param month
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "showYEDData.do")
	@ResponseBody
	public ResponseBean showYEDData(String companyName, String month, HttpServletResponse response) throws Exception {
		if (StringUtils.isEmpty(companyName)) {
			return ResponseBean.errorResponse("companyName参数为空");
		}
		if (StringUtils.isEmpty(month)) {
			return ResponseBean.errorResponse("month参数为空");
		}
		month = getDataVersionString(companyName, month);

		try {
			return ResponseBean.successResponse(offlineFinanceService.createYED(companyName, month));
		} catch (Exception e) {
			logger.error("生成关联方图片", "无关联方数据", companyName, month);
			return ResponseBean.errorResponse(e.getMessage());
		}

	}

	/**
	 * 企业关联方特征指数对比
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "dynamicRiskData.do")
	@ResponseBody
	public ResponseBean dynamicRiskData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String companyName = request.getParameter("companyName");
		String areaCode = request.getParameter("areaCode");
		String keyword = request.getParameter("kw");
		if (org.apache.commons.lang.StringUtils.isEmpty(companyName)) {
			throw new Exception("公司名传入为空");
		}
		String currentMonth = request.getParameter("currentMonth");
		String compareMonth = request.getParameter("compareMonth");
		if (!StringUtils.isEmpty(currentMonth) && !StringUtils.isEmpty(compareMonth)) {
			currentMonth = getDataVersionString(companyName, currentMonth);
			compareMonth = getDataVersionString(companyName, compareMonth);
		}
		List<String> dataVersionList = null;
		dataVersionList = relationDataService.queryDateVersion(companyName, areaCode);
		List<MonthVO> monthList = new ArrayList<MonthVO>();
		if (StringUtils.isEmpty(currentMonth) && StringUtils.isEmpty(compareMonth)) {
			if (dataVersionList.size() > 1) {
				currentMonth = dataVersionList.get(0);
				compareMonth = dataVersionList.get(1);
			} else if (dataVersionList.size() == 1) {
				currentMonth = dataVersionList.get(0);
				compareMonth = dataVersionList.get(0);
			} else if (dataVersionList.size() < 1) {
				throw new Exception("对不起，该公司数据不完整");
			}
		}
		Map tempMap = new HashMap();
		for (int i = 0; i < dataVersionList.size(); i++) {
			MonthVO m = new MonthVO();
			String month = getMonth(dataVersionList.get(i));
			if (tempMap.get(month) == null) {
				tempMap.put(month, month);
				m.setKey(month);
				m.setValue(dataVersionList.get(i));
				monthList.add(m);
			}
		}
		// 比较两个月份的关联方数据
		RelationDataVO vo = relationDataService.compareRelationData(companyName, areaCode, currentMonth, compareMonth);
		// 比较两个月动态风险指标结果
		DynamicRiskVO riskvo = relationDataService.compareDynamicRisk(companyName, areaCode, currentMonth, compareMonth);
		Map result = new HashedMap();
		result.put("companyName", companyName);
		result.put("relationData", vo);
		result.put("monthList", monthList);
		result.put("currentMonth", currentMonth);
		result.put("compareMonth", compareMonth);
		result.put("current", getMonth(vo.getCurrentMonth()));
		result.put("compare", getMonth(vo.getCompareMonth()));
		result.put("dynamicRisk", riskvo);
		result.put("keyword", keyword);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 公司舆情
	 *
	 * @return
	 */
	@SuppressWarnings("companyNews")
	@RequestMapping("companyNews.do")
	@ResponseBody
	public ResponseBean companyNews(String companyName) {
		// String data = offlineFinanceService.companyNews(companyName);

		Object data = hologramQueryService.newsConsensusList(companyName,null);

		return ResponseBean.successResponse(data);
	}

	/**
	 * 静态风险指数构成
	 *
	 * @param companyName
	 * @return
	 */
	@RequestMapping("staticRiskIndex.do")
	@ResponseBody
	@LogRecord(logMsg = "浏览【%s】风险页面", params = { "companyName" }, page = Operation.Page.licaiRisk)
	public ResponseBean staticRiskIndex(String companyName) {
		Map data = offlineFinanceService.staticRiskIndex(companyName);
		System.out.println("return:"+ResponseBean.successResponse(data).toString());
		System.out.println("data:"+data.toString());
		return ResponseBean.successResponse(data);
	}

	/**
	 * 公司标签
	 *
	 * @return
	 */
	@SuppressWarnings("companyInfo")
	@RequestMapping("companyInfo.do")
	@ResponseBody
	public ResponseBean companyInfo(String companyName, String bbdQyxxId) {
		Map data = offlineFinanceService.companyInfo(companyName, bbdQyxxId);
		return ResponseBean.successResponse(data);
	}

	/**
	 * 数据版本
	 *
	 * @return
	 */
	@SuppressWarnings("queryDateVersion")
	@RequestMapping("queryDateVersion.do")
	@ResponseBody
	public ResponseBean queryDateVersion(String companyName, String areaCode, Integer isDeal) {
		List<String> dataVersionList = relationDataService.queryDateVersion(companyName, areaCode);
		if (isDeal != null && isDeal == 1) {
			return ResponseBean.successResponse(dataVersionList);
		}
		Map<String, String> result = new LinkedHashMap();
		if (!CollectionUtils.isEmpty(dataVersionList)) {
			for (String string : dataVersionList) {
				if (!StringUtils.isEmpty(string)) {
					StringBuilder sb = new StringBuilder();
					sb.append(string.substring(0, 4)).append("-").append(string.substring(4, 6));
					result.put(sb.toString(), sb.toString());
				}
			}
		}
		return ResponseBean.successResponse(result.values());
	}

	/**
	 * @param dataVersionString
	 * @return
	 */
	public String getMonth(String dataVersionString) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM");
		Date date = null;
		try {
			date = dateformat.parse(dataVersionString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String month = dateformat1.format(date);
		return month;
	}

	/**
	 * @param dataVersionString
	 *            格式yyyy-MM
	 * @return
	 */
	public String getDataVersionString(String companyName, String dataVersionString) {
		if (!StringUtils.isEmpty(dataVersionString)) {
			dataVersionString = dataVersionString.replace("-", "");
		}
		String dataVersion = relationDataService.queryDateVersionByMonth(companyName, dataVersionString);
		return dataVersion;
	}

	/**
	 * 行业监测
	 *
	 * @return
	 */
	@RequestMapping("businessChartShow.do")
	@ResponseBody
	public ResponseBean businessChartShow() {
		// 小贷
		ResponseBean loanResponseBean = loanController.balanceByQuarter();

		// 私募
		List<CapitalAmountDO> capitalAmountList = privateFundService.capitalAmount();
		@SuppressWarnings("unchecked")
		XAxisSeriesLinesBean<String, String> privateDTO = new XAxisSeriesLinesBean<>(new ArrayList<String>(), new ArrayList<String>());

		for (CapitalAmountDO capitalAmountDO : capitalAmountList) {
			privateDTO.getxAxis().add(privateFundService.getTypeById(capitalAmountDO.getTypeId()).getTypeName());
			privateDTO.getSeries()[0].add(CalculateUtils.decimalFormat(capitalAmountDO.getManagedCapitalAmount()));
			privateDTO.getSeries()[1].add(capitalAmountDO.getPublishCompanyNumber().toString());
		}
		// p2p
		XAxisSeriesBarLineBean<Integer, String> pToPMonitorResponseBean = new XAxisSeriesBarLineBean<>();
		try {
			List<IndustryShanghaiDTO> list = pToPMonitorService.getData();
			XAxisSeriesBarLineBean<Integer, String> data = new XAxisSeriesBarLineBean<>();
			data.setTitle("上海新增平台发展趋势");
			if (!CollectionUtils.isEmpty(list)) {
				Map<String, Integer[]> map = new TreeMap<>();
				for (IndustryShanghaiDTO dto : list) {
					Integer[] as = map.get(dto.getSeason());
					if (as == null) {
						as = new Integer[] { 0, 0 };
					}
					as[0] += dto.getTotal_plat_num();
					as[1] += dto.getNew_plat_num();
					map.put(dto.getSeason(), as);
				}
				data.getxAxis().addAll(map.keySet());

				Iterator<Integer[]> it = map.values().iterator();
				while (it.hasNext()) {
					Integer[] newTot = it.next();
					data.getSeries().getBar().add(newTot[0]);
					data.getSeries().getLine().add(newTot[1]);
				}
			}

			pToPMonitorResponseBean = data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 融资租赁
		ResponseBean financeLeaseResponseBean = financeLeaseController.leaseCompanyStatistic();
		// 交易场所分类
		List<Map> exchangeCompanyData = exchangeCompanyService.exchangeCompanyCategory();
		HistogramBean<String, String> exchangeCompanyBean = new HistogramBean<>();

		for (Map map : exchangeCompanyData) {
			exchangeCompanyBean.getxAxis().add(map.keySet().iterator().next().toString());
			exchangeCompanyBean.getseries().add(map.values().iterator().next().toString());
		}
		// 众筹平台
		ResponseBean crowdFundingResponseBean = crowdFundingController.newlyProject();
		// 典当
		ResponseBean mortgageResponseBean = mortgageController.statisticList();
		List<MortgageStatisticDO> mortgageList = mortgageService.getMortgageStatisticList();
		@SuppressWarnings("unchecked")
		XAxisSeriesLinesBean<String, String> mortgageDTO = new XAxisSeriesLinesBean<>(new ArrayList<String>(), new ArrayList<String>());
		if (!CollectionUtils.isEmpty(mortgageList)) {
			for (int k = mortgageList.size() - 1; k > -1; k--) {
				MortgageStatisticDO mortgageStatisticDO = mortgageList.get(k);
				mortgageDTO.getxAxis().add(mortgageStatisticDO.getYear().toString());
				mortgageDTO.getSeries()[0].add(mortgageStatisticDO.getNumber().toString());
				mortgageDTO.getSeries()[1].add(mortgageStatisticDO.getTotalAmout().toString());
			}
		}
		// 商业保理
		Object factoringObject = factoringController.countCapitalBySeason();
		// 预付卡
		ResponseBean prepaidCompanyResponseBean = prepaidCompanyController.amount();
		//
		Map result = new LinkedHashMap();
		result.put("loan", loanResponseBean);
		result.put("private", privateDTO);
		result.put("p2p", pToPMonitorResponseBean);
		result.put("finance", financeLeaseResponseBean.getContent());
		result.put("exchange", exchangeCompanyBean);
		result.put("crowd", crowdFundingResponseBean.getContent());
		result.put("mortgage", mortgageDTO);
		result.put("factoring", factoringObject);
		result.put("prepaid", prepaidCompanyResponseBean.getContent());
		result.put("guarantee", guaranteeController.balanceByQuarter());
		return ResponseBean.successResponse(result);
	}

	/**
	 * 更新index_data静态风险指数+本地模型
	 *
	 * @return
	 */
	@RequestMapping("updateIndexData.do")
	@ResponseBody
	public ResponseBean updateIndexData(String companyName) {
		offlineFinanceService.updateIndexData(companyName);
		return ResponseBean.successResponse("更新成功");
	}

	/**
	 * 更新static_risk_data静态风险指数+本地模型
	 *
	 * @return
	 */
	@RequestMapping("updateStaticRiskData.do")
	@ResponseBody
	public ResponseBean updateStaticRiskData(String companyName, String dataVersion) {
		offlineFinanceService.updateStaticRiskData(companyName, dataVersion);
		return ResponseBean.successResponse("更新成功");
	}

	/**
	 * 保存本地模型分数
	 *
	 * @return
	 */
	@RequestMapping("saveCompanyCreditRisk.do")
	@ResponseBody
	public ResponseBean saveCompanyCreditRisk() {
		offlineFinanceService.saveCompanyCreditRisk();
		return ResponseBean.successResponse("保存成功");
	}
}
