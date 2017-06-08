package com.bbd.wtyh.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.vo.*;
import com.bbd.wtyh.service.*;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wellspring.common.service.facade.relation.LineTypeEnum;
import com.bbd.wellspring.common.service.facade.relation.NodeVoSymbolEnum;
import com.bbd.wellspring.common.service.facade.relation.NodeVoTypeEnum;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.dao.OfflineFinanceDao;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.dto.RelationDTO;
import com.bbd.wtyh.domain.dto.StaticRiskDTO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.mapper.CompanyAnalysisResultMapper;
import com.bbd.wtyh.mapper.CompanyCreditDetailMapper;
import com.bbd.wtyh.mapper.CompanyCreditInformationMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.IndexDataMapper;
import com.bbd.wtyh.mapper.RiskCompanyMapper;
import com.bbd.wtyh.mapper.StaticRiskMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.impl.relation.RegisterUniversalFilterChainImp;
import com.bbd.wtyh.service.impl.relation.common.APIConstants;
import com.bbd.wtyh.service.impl.relation.exception.BbdException;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.util.DateUtils;
import com.bbd.wtyh.web.relationVO.LinkVO;
import com.bbd.wtyh.web.relationVO.NodeVO;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import com.bbd.wtyh.web.relationVO.SubGraphVO;
import com.google.common.collect.Lists;

/**
 * 线下理财接口实现层
 * 
 * @author zhouxuan
 * @since 2016.08.05
 */
@Service("offlineFinanceService")
public class OfflineFinanceServiceImpl implements OfflineFinanceService {

	private Logger logger = LoggerFactory.getLogger(OfflineFinanceServiceImpl.class);
	@Resource
	private StaticRiskMapper staticRiskMapper;
	@Resource
	private CompanyCreditDetailMapper companyCreditDetailMapper;
	@Resource
	private BuildFileService buildFileService;
	@Resource
	private RedisDAO redisDAO;
	@Autowired
	private CompanyNewsService companyNewsService;
	@Autowired
	private OfflineFinanceDao offlineFinanceDao;
	@Autowired
	private P2PImageDao p2PImageDao;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private RiskCompanyMapper riskCompanyMapper;
	@Autowired
	private IndexDataMapper indexDataMapper;
	@Autowired
	private CompanyAnalysisResultMapper companyAnalysisResultMapper;
	@Autowired
	private PToPMonitorService pToPMonitorService;

	@Autowired
	private RealTimeMonitorService realTimeMonitorService;

	@Autowired
	private CoAddOrCloseService coChgMonitorService;

	@Value("${share.path}")
	private String shareDir;

	@Value("${mapping.path}")
	private String mappingPath;

	private static final String RISE = "1";
	private static final String FALL = "-1";
	private final String file_type_1 = "yed";

	/* @Scheduled(cron = "0 20 16 * * *") */
	@Override
	public void updateCompanyRiskLevel() {
		logger.info("start update company risk level");
		try {
			final Map<Integer, Integer> platRankMapData = pToPMonitorService.getPlatRankMapData();

			int totalCount = companyMapper.countAllCompany();
			Pagination pagination = new Pagination();
			pagination.setPageSize(1000);
			pagination.setCount(totalCount);
			int total = pagination.getLastPageNumber();
			Map<String, Object> params = new HashMap<>();

			ExecutorService dataExecutorService = Executors.newFixedThreadPool(20);

			for (int i = 1; i <= total; i++) {
				pagination.setPageNumber(i);
				params.put("pagination", pagination);

				List<CompanyDO> list = companyMapper.findByPage(params);

				if (!CollectionUtils.isEmpty(list)) {
					for (final CompanyDO companyDO : list) {
						dataExecutorService.submit(new Runnable() {

							@Override
							public void run() {
								updateCompanRiskLevel(platRankMapData, companyDO);
							}
						});
					}
				}
			}

			dataExecutorService.shutdown();
			dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("end update company risk level");
	}

	@Override
	public void updateIndexData(String companyNameParam) {
		Map<String, Object> paramsMap = new HashMap<>();
		int totalCount = riskCompanyMapper.getTopCount(paramsMap);
		if (totalCount > 0) {
			Pagination pagination = new Pagination();
			pagination.setPageSize(1000);
			pagination.setCount(totalCount);
			int totalPage = pagination.getLastPageNumber();
			Map<String, Object> params = new HashMap<>();
			ExecutorService dataExecutorService = Executors.newFixedThreadPool(20);
			for (int pageNo = 1; pageNo <= totalPage; pageNo++) {
				pagination.setPageNumber(pageNo);
				params.put("pagination", pagination);
				List<IndexDataDO> pageList = indexDataMapper.findByPage(params);
				if (!CollectionUtils.isEmpty(pageList)) {
					for (final IndexDataDO indexDataDO : pageList) {
						final String companyName = indexDataDO.getCompanyName();
						if (StringUtils.isNotEmpty(companyNameParam) && !companyNameParam.equals(companyName)) {
							continue;
						}
						BigDecimal staticRiskIndex = indexDataDO.getStaticRiskIndex();
						staticRiskIndex = this.getSRI(staticRiskIndex, companyName);
						indexDataDO.setStaticRiskIndex(staticRiskIndex);
						dataExecutorService.submit(new Runnable() {

							@Override
							public void run() {
								indexDataMapper.update(indexDataDO);
							}
						});
					}
				}
			}
			dataExecutorService.shutdown();
			try {
				dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
			} catch (InterruptedException e) {
				logger.error(e.getMessage(), e);
			}
		}

	}

	@Override
	public void updateStaticRiskData(String companyNameParam, String dataVersion) {
		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("dataVersion", dataVersion);
		int totalCount = staticRiskMapper.getDataVersionCount(paramsMap);
		if (totalCount > 0) {
			Pagination pagination = new Pagination();
			pagination.setPageSize(1000);
			pagination.setCount(totalCount);
			int totalPage = pagination.getLastPageNumber();
			Map<String, Object> params = new HashMap<>();
			ExecutorService dataExecutorService = Executors.newFixedThreadPool(20);
			for (int pageNo = 1; pageNo <= totalPage; pageNo++) {
				pagination.setPageNumber(pageNo);
				params.put("pagination", pagination);
				params.put("dataVersion", dataVersion);
				List<StaticRiskDataDO> pageList = staticRiskMapper.findByPage(params);
				if (!CollectionUtils.isEmpty(pageList)) {
					for (final StaticRiskDataDO staticRiskDataDO : pageList) {
						final String companyName = staticRiskDataDO.getCompanyName();
						if (StringUtils.isNotEmpty(companyNameParam) && !companyNameParam.equals(companyName)) {
							continue;
						}
						BigDecimal staticRiskIndex = staticRiskDataDO.getStaticRiskIndex();
						staticRiskIndex = this.getSRI(staticRiskIndex, companyName);
						staticRiskDataDO.setStaticRiskIndex(staticRiskIndex);
						dataExecutorService.submit(new Runnable() {

							@Override
							public void run() {
								logger.warn("start updateStaticRiskData companyName:" + companyName);
								staticRiskMapper.update(staticRiskDataDO);
							}
						});
					}
				}
			}
			dataExecutorService.shutdown();
			try {
				dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
			} catch (InterruptedException e) {
				logger.error(e.getMessage(), e);
			}
		}

	}

	static Integer staticRiskIndexToLevel(BigDecimal staticsRiskIndex) {
		Integer riskLevel = CompanyAnalysisResult.NORMAL.getType();
		// 大于65.9
		if (staticsRiskIndex.compareTo(new BigDecimal("65.9")) == 1) {
			riskLevel = CompanyAnalysisResult.IMPORT_FOCUS.getType();
			// 大于等于57.8 小于65.9
		} else if (staticsRiskIndex.compareTo(new BigDecimal("57.8")) > -1 && staticsRiskIndex.compareTo(new BigDecimal("65.9")) == -1) {
			riskLevel = CompanyAnalysisResult.COMMON_FOCUS.getType();
		} else if (staticsRiskIndex.compareTo(new BigDecimal("57.8")) == -1) {
			riskLevel = CompanyAnalysisResult.NORMAL.getType();
		}
		return riskLevel;
	}

	/**
	 * 更新光谱分析结果
	 * 
	 * @param platRankMapData
	 * @param companyDO
	 */
	private void updateCompanRiskLevel(Map<Integer, Integer> platRankMapData, CompanyDO companyDO) {
		Integer companyId = companyDO.getCompanyId();
		Integer oldRiskLevel = companyDO.getRiskLevel();
		Integer companyType = (int) companyDO.getCompanyType();
		CompanyAnalysisResultDO companyAnalysisResultDO = companyAnalysisResultMapper.findCompanyAnalysisResultByCompanyId(companyId);
		StaticRiskDataDO staticRiskDataDO = staticRiskMapper.queryStaticsRiskData(companyDO.getName());
		Integer riskLevel = oldRiskLevel;
		Integer riskLevelForPToP = platRankMapData.get(companyId);

		if (riskLevelForPToP != null && riskLevelForPToP > 0) {
			logger.warn("companyId:{} riskLevelForP2P:{}", companyId, riskLevelForPToP);
			riskLevel = riskLevelForPToP;
		}

		if (staticRiskDataDO != null) {
			BigDecimal staticsRiskIndex = staticRiskDataDO.getStaticRiskIndex();
			riskLevel = staticRiskIndexToLevel(staticsRiskIndex);
			logger.warn("companyId:{} riskLevel from static_risk_data:{}", companyId, riskLevel);
		}

		if (companyAnalysisResultDO != null) {
			// 预付卡不考虑黑名单
			if (companyType != CompanyDO.TYPE_YFK_11) {
				riskLevel = (int) companyAnalysisResultDO.getAnalysisResult();
				logger.warn("companyId:{} riskLevel from company_analysis_result:{}", companyId, riskLevel);
			}
		}
		/*
		 * boolean immUpdatePreviousRiskLevel =false; if( null ==oldRiskLevel &&
		 * StringUtils.isNotBlank(companyDO.getName()) ) { BigDecimal bdl =
		 * realTimeMonitorService.getCompanyStaticIndexByName(companyDO.getName(
		 * )); if( null !=bdl ) { int level =
		 * OfflineFinanceService.staticRiskIndexToLevel(bdl); oldRiskLevel
		 * =level; immUpdatePreviousRiskLevel =true; } }
		 */
		// LocalDate ld = LocalDate.now();
		if (!riskLevel.equals(oldRiskLevel)) { // 只记录前一次变化的，这是最新的产品需求
			companyMapper.updateRiskLevel(riskLevel, oldRiskLevel, companyId, "TIMER");
		} else {
			companyMapper.updateRiskLevel(riskLevel, null, companyId, "TIMER");
		}

		if (!riskLevel.equals(oldRiskLevel)) {
			logger.error("riskLevel changed: companyId={} oldRiskLevel={} newRiskLevel:{}", companyId, oldRiskLevel, riskLevel);

			// 添加风险变化公司
			BeanCopier beanCopier = BeanCopier.create(CompanyDO.class, RiskChgCoDo.class, false);
			RiskChgCoDo rcco = new RiskChgCoDo();
			beanCopier.copy(companyDO, rcco, null);

			rcco.setCompanyName(companyDO.getName());
			rcco.setCompanyType(companyType);

			rcco.setOldRiskLevel(oldRiskLevel);
			rcco.setRiskLevel(riskLevel);
			rcco.setSource(RiskChgCoSource.MODEL_SCORE.type());

			rcco.setCreateBy("updateCoRiskLevelTask");

			try {
				this.coChgMonitorService.saveRiskChgCo(rcco);
			} catch (Exception e) {
				logger.error("保存风险变化公司失败！companyId：" + companyId, e);
			}
		}
	}

	@Override
	public Map companyInfo(String companyName) {
		List<Map<Integer, Object>> list = companyMapper.companyInfo(companyName);

		Map<String, Object> result = new HashMap<>();

		List backgroud = new ArrayList();
		if (!CollectionUtils.isEmpty(list)) {
			result.put("status", list.get(0).get("status"));

			result.put("comTypeCN", "");

			Object objType = list.get(0).get("companyType");
			if (objType != null) {
				result.put("comTypeCN", CompanyDO.companyTypeCN(Byte.parseByte(objType.toString())));
			}

			if (list.get(0).get("riskLevel") != null) {
				result.put("analysisResult", CompanyAnalysisResult.getName(Integer.parseInt(list.get(0).get("riskLevel").toString())));
			}

			String backgroudString = "";
			for (Map map : list) {
				Object obj = map.get("background");
				if (null == obj) {
					continue;
				}
				int back = (int) map.get("background");
				if (map.get("name") != null) {
					continue;
				}
				if (back == 1) {
					backgroudString = "上市公司";
				} else if (back == 2) {
					backgroudString = "非上市公司";
				} else if (back == 3) {
					backgroudString = "国企";
				} else if (back == 4) {
					backgroudString = "民营企业";
				} else if (back == 5) {
					backgroudString = "外资企业";
				} else {
					// do nothing
				}
				backgroud.add(backgroudString);
			}
		}

		result.put("companyName", companyName);
		result.put("backgroud", backgroud);
		return result;
	}

	@Override
	public RelationDiagramVO queryRealRealation(String companyName, Integer degree) {
		RelationDiagramVO relationDiagramVO = new RelationDiagramVO();
		BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(companyName);
		List<BaseDataDO.Results> resultsList = (null == baseDataDO) ? null : baseDataDO.getResults();
		String unikey = "";
		if (!CollectionUtils.isEmpty(resultsList)) {
			unikey = resultsList.get(0).getJbxx().getBbd_qyxx_id();
		} else {
			return relationDiagramVO;
		}

		// 拿出包装类数据
		SubGraphVO subGraphVO = offlineFinanceDao.queryRealTimeRelation(unikey, degree + "");

		if (subGraphVO == null) {
			return relationDiagramVO;
		}

		// 页面连线
		List<LinkVO> lineVOs = (List<LinkVO>) subGraphVO.getLinks();
		// 页面描点集合
		List<NodeVO> nodeVOs = (List<NodeVO>) subGraphVO.getNodes();
		// 处理节点
		Map<String, Object> map = getPointList(nodeVOs);
		// 处理线集合
		relationDiagramVO.setLineList(getLineList((Map<String, NodeVO>) map.get("pointDegree"), lineVOs));
		// 处理点集合
		relationDiagramVO.setPointList((List<RelationDiagramVO.PointVO>) map.get("pointList"));
		return relationDiagramVO;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public RelationDiagramVO queryRelation(String companyName, String dataVersion, String degreesLevel) throws Exception {
		RelationDTO relationDTO = offlineFinanceDao.queryRealation(companyName, dataVersion);
		return convert2RelationDiagramVO(relationDTO, companyName, Integer.valueOf(degreesLevel));
	}

	private RelationDiagramVO convert2RelationDiagramVO(RelationDTO relationDTO, String companyName, int degree) {
		RelationDiagramVO relationDiagramVO = new RelationDiagramVO();

		// 如果没有关联方信息
		if (org.apache.commons.collections.CollectionUtils.isEmpty(relationDTO.getResults())) {
			relationDiagramVO.setLineList(new ArrayList<RelationDiagramVO.LineVO>());
			relationDiagramVO.setPointList(new ArrayList<RelationDiagramVO.PointVO>());
			return relationDiagramVO;
		}
		// 连线集合
		List<RelationDiagramVO.LineVO> lineVOs = new ArrayList<>();
		// 点集合
		List<RelationDiagramVO.PointVO> pointVOs = new ArrayList<>();
		// 用于去重描点
		List<String> sets = new ArrayList<>();
		RelationDiagramVO.PointVO pointVOOne = new RelationDiagramVO.PointVO();
		// 默认一个中心点
		pointVOOne.setName(companyName);
        pointVOOne.setCname(companyName);
		pointVOOne.setIsPerson("0");
		pointVOOne.setLevel("0");
		pointVOOne.setIsSonCom("0");
		pointVOs.add(pointVOOne);
		sets.add(companyName);
		// 循环遍历处理企业
		for (RelationDTO.Result result : relationDTO.getResults()) {
			// 三度公司
			if (degree >= 1) {
				if (Integer.parseInt(result.getInvestee_degree()) <= 1 && Integer.parseInt(result.getInvestor_degree()) <= 1) {
					hanldeResult(companyName, 1, lineVOs, pointVOs, result, sets);
				}
			}
			if (degree >= 2) {
				if (Integer.parseInt(result.getInvestee_degree()) <= 2 && Integer.parseInt(result.getInvestee_degree()) >= 1
						&& Integer.parseInt(result.getInvestor_degree()) <= 2 && Integer.parseInt(result.getInvestor_degree()) >= 1) {
					hanldeResult(companyName, 2, lineVOs, pointVOs, result, sets);
				}
			}
			if (degree >= 3) {
				if (Integer.parseInt(result.getInvestee_degree()) <= 3 && Integer.parseInt(result.getInvestee_degree()) >= 2
						&& Integer.parseInt(result.getInvestor_degree()) <= 3 && Integer.parseInt(result.getInvestor_degree()) >= 2) {
					hanldeResult(companyName, 3, lineVOs, pointVOs, result, sets);
				}
			}

		}
		relationDiagramVO.setPointList(pointVOs);
		relationDiagramVO.setLineList(lineVOs);
		return relationDiagramVO;

	}

	private void hanldeResult(String companyName, Integer degree, List<RelationDiagramVO.LineVO> lineVOs,
			List<RelationDiagramVO.PointVO> pointVOs, RelationDTO.Result result, List<String> set) {
		RelationDiagramVO.LineVO lineVO = new RelationDiagramVO.LineVO();
		lineVO.setOrig(result.getInvestor());
        lineVO.setOrigName(result.getInvestor());
		lineVO.setTarget(result.getInvestee());
        lineVO.setTargetName(result.getInvestee());
		lineVO.setIsFullLine(result.getRelType() + "");
		lineVO.setRelationship(result.getIsNatural() + "");
		lineVO.setOrigLevel(result.getInvestor_degree());
		lineVO.setTarLevel(result.getInvestee_degree());
		lineVO.setType(result.getType());
		boolean flag = false;
		// 如果是自然人
		if (result.getIsNatural() == 1) {
			if (!set.contains(result.getInvestor())) {
				RelationDiagramVO.PointVO pointVO = new RelationDiagramVO.PointVO();
				pointVO.setName(result.getInvestor());
                pointVO.setCname(result.getInvestor());
				set.add(result.getInvestor());
				pointVO.setLevel(result.getInvestor_degree() + "");
				pointVO.setIsPerson("1");
				pointVO.setIsSonCom(result.getInvestor().equals(companyName) ? "1" : "0");
				// 如果是重复则不增加这个节点
				pointVOs.add(pointVO);
			}
			if (!set.contains(result.getInvestee())) {
				RelationDiagramVO.PointVO pointVO = new RelationDiagramVO.PointVO();
				pointVO.setIsPerson("0");
				pointVO.setName(result.getInvestee());
                pointVO.setCname(result.getInvestee());
				set.add(result.getInvestee());
				pointVO.setLevel(result.getInvestee_degree() + "");
				pointVO.setIsSonCom(result.getInvestor().equals(companyName) ? "1" : "0");
				// 如果是重复则不增加这个节点
				pointVOs.add(pointVO);
			}
		} else {
			if (!set.contains(result.getInvestor())) {
				RelationDiagramVO.PointVO pointVO = new RelationDiagramVO.PointVO();
				pointVO.setIsPerson("0");

				pointVO.setName(result.getInvestor());
                pointVO.setCname(result.getInvestor());
				set.add(result.getInvestor());
				if (result.getIsNatural() == 1) {
					pointVO.setIsPerson("1");
				}
				pointVO.setLevel(result.getInvestor_degree() + "");
				pointVO.setIsSonCom(result.getInvestor().equals(companyName) ? "1" : "0");
				// 如果是重复则不增加这个节点
				pointVOs.add(pointVO);
			}
			if (!set.contains(result.getInvestee())) {
				RelationDiagramVO.PointVO pointVO = new RelationDiagramVO.PointVO();
				pointVO.setIsPerson("0");
				pointVO.setIsPerson("0");
				pointVO.setName(result.getInvestee());
                pointVO.setCname(result.getInvestee());
				set.add(result.getInvestee());
				pointVO.setLevel(result.getInvestee_degree() + "");
				pointVO.setIsSonCom(result.getInvestor().equals(companyName) ? "1" : "0");
				// 如果是重复则不增加这个节点
				pointVOs.add(pointVO);
			}

		}

		lineVOs.add(lineVO);

	}

	@Override
	public String companyNews(String companyName) {
		String string = companyNewsService.findCompanyNews(companyName);
		return string;
	}

	@Override
	public Map staticRiskIndex(String companyName) {
		Map result = new HashMap();

		result.put("creditInfoRisk", this.getCreditInfoRisk(companyName));

		Float capitalBgRisk = 0f;
		capitalBgRisk = staticRiskMapper.queryCapitalBgRisk(companyName);
		result.put("capitalRisk", capitalBgRisk);
		return result;
	}

	/**
	 * 本地模型
	 * 
	 * @param companyName
	 * @return
	 */
	public BigDecimal getCreditInfoRisk(String companyName) {
		return new BigDecimal(companyCreditDetailMapper.getCompanyRiskInfoByCompanyName(companyName));
	}

	@Override
	public List<StatisticsVO> queryStatistics(String companyName, String tabIndex, String areaCode) throws ParseException {
		List<StatisticsVO> avgList = new ArrayList<>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyName", companyName);
		params.put("areaCode", areaCode);
		avgList = this.getAvgRiskIndex(params, tabIndex);
		this.getRiskIndex(avgList, params, tabIndex);
		List<StatisticsVO> result = new ArrayList<StatisticsVO>();
		if (ListUtil.isEmpty(avgList)) {
			/* 查询无结果，返回坐标系为零数据 */
			for (int i = 0; i < 6; i++) {
				StatisticsVO vo = new StatisticsVO();
				vo.setAvgRiskIndex(BigDecimal.ZERO);
				vo.setRiskIndex(BigDecimal.ZERO);
				vo.setDate(DateUtils.getLastMonth(new Date(), i - 5));
				vo.setRiskName(this.getTableText(tabIndex));
				result.add(vo);
			}
		} else {
			DateFormat df = new SimpleDateFormat("yyyy-MM");
			StatisticsVO lastVO = avgList.get(avgList.size() - 1);
			StatisticsVO firstVO = avgList.get(0);
			int subMonth = this.getSubMonth(lastVO, firstVO); // 月份差
			if (subMonth == 0) { // 这里表示只有一个月有数据
				/* 以有数据月份为准，向前推5个月的为零数据 */
				for (int i = 0; i < 5; i++) {
					StatisticsVO vo = new StatisticsVO();
					vo.setAvgRiskIndex(BigDecimal.ZERO);
					vo.setRiskIndex(BigDecimal.ZERO);
					vo.setDate(DateUtils.getLastMonth(df.parse(firstVO.getDate()), i - 5));
					vo.setRiskName(this.getTableText(tabIndex));
					result.add(vo);
				}
				result.add(firstVO);
			} else {
				result.add(firstVO);
				/* 填充最大、最小时间之间的数据 */
				for (int i = 1; i < subMonth; i++) {
					String date = DateUtils.getLastMonth(df.parse(firstVO.getDate()), i);
					StatisticsVO existVO = this.getExistVO(avgList, date);
					if (null != existVO) { // 存在数据
						result.add(existVO);
						continue;
					}
					/* 未存在数据则填充零数据 */
					StatisticsVO vo = new StatisticsVO();
					vo.setAvgRiskIndex(BigDecimal.ZERO);
					vo.setRiskIndex(BigDecimal.ZERO);
					vo.setDate(date);
					vo.setRiskName(this.getTableText(tabIndex));
					result.add(vo);
				}
				result.add(lastVO);
				int resultSize = result.size();
				List<StatisticsVO> supplementList = new ArrayList<StatisticsVO>();
				/* 最终结果依然小于半年数据，则在最早时间前填充零数据 */
				if (resultSize < 6) {
					for (int i = 0; i < 6 - resultSize; i++) {
						StatisticsVO vo = new StatisticsVO();
						vo.setAvgRiskIndex(BigDecimal.ZERO);
						vo.setRiskIndex(BigDecimal.ZERO);
						vo.setDate(DateUtils.getLastMonth(df.parse(firstVO.getDate()), (i - 6 + resultSize)));
						vo.setRiskName(this.getTableText(tabIndex));
						supplementList.add(vo);
					}
				}
				List<StatisticsVO> allList = new ArrayList<StatisticsVO>();
				allList.addAll(supplementList);
				allList.addAll(result);
				return allList;
			}
		}
		return result;
	}

	/**
	 * 获取行业平均风险
	 * 
	 * @param params
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<StatisticsVO> getAvgRiskIndex(Map<String, Object> params, String type) {
		List<StatisticsVO> avgList = null;
		if (!StringUtils.isEmpty(type)) {
			switch (type) {
			case "0":
				avgList = (List<StatisticsVO>) redisDAO.getObject(Constants.REDIS_KEY_STATIC_RISK_INDEX);
				if (ListUtil.isEmpty(avgList)) {
					avgList = staticRiskMapper.queryIndStatistics(params);
					if (ListUtil.isNotEmpty(avgList)) {
						redisDAO.addObject(Constants.REDIS_KEY_STATIC_RISK_INDEX, avgList, Constants.cacheDay, List.class);
					}
				}
				break;
			case "1":
				avgList = (List<StatisticsVO>) redisDAO.getObject(Constants.REDIS_KEY_SJKZR_RISK);
				if (ListUtil.isEmpty(avgList)) {
					avgList = staticRiskMapper.queryIndStsSJKZR(params);
					if (ListUtil.isNotEmpty(avgList)) {
						redisDAO.addObject(Constants.REDIS_KEY_SJKZR_RISK, avgList, Constants.cacheDay, List.class);
					}
				}
				break;
			case "2":
				avgList = (List<StatisticsVO>) redisDAO.getObject(Constants.REDIS_KEY_GSKZLJ_RISK);
				if (ListUtil.isEmpty(avgList)) {
					avgList = staticRiskMapper.queryIndStsGSKZLJ(params);
					if (ListUtil.isNotEmpty(avgList)) {
						redisDAO.addObject(Constants.REDIS_KEY_GSKZLJ_RISK, avgList, Constants.cacheDay, List.class);
					}
				}
				break;
			case "3":
				avgList = (List<StatisticsVO>) redisDAO.getObject(Constants.REDIS_KEY_ZXJJH_RISK);
				if (ListUtil.isEmpty(avgList)) {
					avgList = staticRiskMapper.queryIndStsZXJJH(params);
					if (ListUtil.isNotEmpty(avgList)) {
						redisDAO.addObject(Constants.REDIS_KEY_ZXJJH_RISK, avgList, Constants.cacheDay, List.class);
					}
				}
				break;
			case "4":
				avgList = (List<StatisticsVO>) redisDAO.getObject(Constants.REDIS_KEY_FFRZYS_RISK);
				if (ListUtil.isEmpty(avgList)) {
					avgList = staticRiskMapper.queryIndStsFFRZYS(params);
					if (ListUtil.isNotEmpty(avgList)) {
						redisDAO.addObject(Constants.REDIS_KEY_FFRZYS_RISK, avgList, Constants.cacheDay, List.class);
					}
				}
				break;
			case "5":
				avgList = (List<StatisticsVO>) redisDAO.getObject(Constants.REDIS_KEY_DQZL_RISK);
				if (ListUtil.isEmpty(avgList)) {
					avgList = staticRiskMapper.queryIndStsDQZL(params);
					if (ListUtil.isNotEmpty(avgList)) {
						redisDAO.addObject(Constants.REDIS_KEY_DQZL_RISK, avgList, Constants.cacheDay, List.class);
					}
				}
				break;
			case "6":
				avgList = (List<StatisticsVO>) redisDAO.getObject(Constants.REDIS_KEY_FFRZWG_RISK);
				if (ListUtil.isEmpty(avgList)) {
					avgList = staticRiskMapper.queryIndStsFFRZWG(params);
					if (ListUtil.isNotEmpty(avgList)) {
						redisDAO.addObject(Constants.REDIS_KEY_FFRZWG_RISK, avgList, Constants.cacheDay, List.class);
					}
				}
				break;
			case "7":
				avgList = (List<StatisticsVO>) redisDAO.getObject(Constants.REDIS_KEY_RCJG_RISK);
				if (ListUtil.isEmpty(avgList)) {
					avgList = staticRiskMapper.queryIndStsRCJG(params);
					if (ListUtil.isNotEmpty(avgList)) {
						redisDAO.addObject(Constants.REDIS_KEY_RCJG_RISK, avgList, Constants.cacheDay, List.class);
					}
				}
				break;
			default:
				break;
			}
		}
		return avgList;
	}

	private void getRiskIndex(List<StatisticsVO> avgList, Map<String, Object> params, String type) {
		if (ListUtil.isNotEmpty(avgList)) {
			for (StatisticsVO vo : avgList) {
				if (null != params && !StringUtils.isEmpty(type)) {
					params.put("date", vo.getDate());
					StatisticsVO comVO = null;
					switch (type) {
					case "0":
						comVO = staticRiskMapper.queryComStatistics(params);
						break;
					case "1":
						comVO = staticRiskMapper.queryComStsSJKZR(params);
						break;
					case "2":
						comVO = staticRiskMapper.queryComStsGSKZLJ(params);
						break;
					case "3":
						comVO = staticRiskMapper.queryComStsZXJJH(params);
						break;
					case "4":
						comVO = staticRiskMapper.queryComStsFFRZYS(params);
						break;
					case "5":
						comVO = staticRiskMapper.queryComStsDQZL(params);
						break;
					case "6":
						comVO = staticRiskMapper.queryComStsFFRZWG(params);
						break;
					case "7":
						comVO = staticRiskMapper.queryComStsRCJG(params);
						break;
					default:
						break;
					}
					if (null != comVO) {
						vo.setRiskIndex(comVO.getRiskIndex());
					} else {
						vo.setRiskIndex(BigDecimal.ZERO);
					}
				}
			}
		}
	}

	@Override
	public StaticRiskVO queryCurrentStaticRisk(String companyName, String currentDate, String areaCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyName", companyName);
		params.put("riskDateStr", currentDate);
		params.put("areaCode", areaCode);
		StaticRiskDTO dto = staticRiskMapper.queryLastStaticRisk(params);
		StaticRiskVO vo = this.staticRiskPo2Vo(dto);
		if (null != dto) {
			params.put("riskDateStr", DateUtils.getLastMonth(dto.getRiskDate()));
			StaticRiskDTO lastPO = staticRiskMapper.queryLastStaticRisk(params);
			if (null != lastPO) {
				if (dto.getStcRiskIndex().compareTo(lastPO.getStcRiskIndex()) > 0) {
					vo.setRise(RISE);
				} else if (dto.getStcRiskIndex().compareTo(lastPO.getStcRiskIndex()) < 0) {
					vo.setRise(FALL);
				} else {
				} // 保持结构完整
			}
		}
		return vo;
	}

	/**
	 * 静态风险指数+本地模型
	 * 
	 * @param staticRiskIndex
	 * @param companyName
	 * @return
	 */
	@Override
	public BigDecimal getSRI(BigDecimal staticRiskIndex, String companyName) {
		System.out.println("---old--static--" + staticRiskIndex);
		staticRiskIndex = staticRiskIndex.add(this.getCreditInfoRisk(companyName));
		System.out.println("---new--static--" + staticRiskIndex);
		if (staticRiskIndex.compareTo(new BigDecimal(100)) == 1) {
			staticRiskIndex = new BigDecimal(100);
		}
		double f1 = staticRiskIndex.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return new BigDecimal(f1);
	}

	@Override
	public void saveCompanyCreditRisk() {
	}

	@Override
	public String createYED(String companyName, String month) throws Exception {
		String filePath = "";
		String attDirectory = shareDir + File.separator + Constants.attDir;
		String redis_key = assembleRedisKey(companyName, file_type_1, month);
		String redis_value = redisDAO.getString(redis_key);
		boolean flag = true;
		if (!new File(attDirectory).exists()) {
			flag = new File(attDirectory).mkdirs();
		}
		if (redis_value == null) {
			if (flag) {
				try {
					filePath = this.createOriginYED(companyName, attDirectory, month);
					redis_value = Constants.attDir + File.separator + new File(filePath).getName();
					redisDAO.addString(redis_key, redis_value, Constants.cacheDay);
				} catch (Exception e) {
					logger.info("数据平台不存在该公司的数据版本", e);
					return "";
				}

			}

		} else {
			filePath = Constants.shareDir + File.separator + redis_value;
			File attFile = new File(filePath);
			if (!attFile.exists()) {
				try {
					filePath = this.createOriginYED(companyName, attDirectory, month);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			} else {
				if (attFile.length() == 0) {
					attFile.delete();
					throw new BbdException("对不起，您搜索的公司关联方数据正在分析更新中，暂时无法提供信息，请稍后再试。", true);
				}
			}
		}
		String targetPath = "";
		if (new File(filePath).exists()) {
			targetPath = mappingPath + File.separator + Constants.attDir + File.separator + new File(filePath).getName();
		}

		return targetPath;
	}

	public String createOriginYED(String companyName, String attDirectory, String month) throws Exception {

		RelationDTO relationDTO = offlineFinanceDao.queryRealation(companyName, month);
		List<List<Object>> data = convertRelationDTO(relationDTO);
		if (data.size() == 0) {
			throw new BbdException(companyName + "：对不起，您搜索的公司关联方数据正在分析更新中，暂时无法提供信息，请稍后再试。", true);
		}
		String filePath = attDirectory + File.separator + companyName + month + ".gif";
		File yedFile = new File(filePath);
		boolean result = true;
		if (!yedFile.exists()) {
			result = buildFileService.buildImage(data, companyName, filePath, false);
		}
		if (result) {
			return filePath;
		} else {
			return null;
		}
	}

	//获取最新的关联方图谱图片
	public ByteArrayOutputStream createNewestYEDtoStream(String companyName)  {
		try {
			String month = staticRiskMapper.getNewestDataVersion();
			RelationDTO relationDTO = offlineFinanceDao.queryRealation(companyName, month);
			List<List<Object>> data = convertRelationDTO(relationDTO);
			if (data.size() == 0) {
				return null; //throw new BbdException(companyName + "：对不起，您搜索的公司关联方数据正在分析更新中，暂时无法提供信息，请稍后再试。", true);
			}
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			if( buildFileService.buildImageToFileOrStream(data, companyName, null, bos, false) ) {
				return bos;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	private List<List<Object>> convertRelationDTO(RelationDTO relationDTO) {
		// 原字符串数据 0列 投资方 1列 被投资方 2列 职位 3列 投资方度数 4列 被投资方度数 5列 线条 0 虚线 1 实线
		// * 6列 关系 0 公司 1 人
		return Lists.transform(relationDTO.getResults(), (RelationDTO.Result result) -> {
			List<Object> list = Lists.newArrayList();
			list.add(result.getInvestor());
			list.add(result.getInvestee());
			list.add(result.getType());
			list.add(result.getInvestor_degree());
			list.add(result.getInvestee_degree());
			list.add(result.getRelType());
			list.add(result.getIsNatural());
			return list;
		});
	}

	@SuppressWarnings("rawtypes")
	private Map<String, List> getRelationData(List<List<String>> list) {
		Map<String, List> map = new HashMap<String, List>();
		if (!CollectionUtils.isEmpty(list)) {
			map.put("pointList", this.getPointList(list));
			map.put("lineList", this.getLineList(list));
		}
		return map;
	}

	/**
	 * PO 2 VO
	 *
	 * @param dto
	 * @return
	 */
	private StaticRiskVO staticRiskPo2Vo(StaticRiskDTO dto) {
		StaticRiskVO vo = null;
		if (null != dto) {
			vo = new StaticRiskVO();
			vo.setAdvisory(CalculateUtils.bigDecimal2Str(dto.getAdvisory(), 1));
			vo.setAvgPerNum(CalculateUtils.bigDecimal2Str(dto.getAvgPerNum(), 1));
			vo.setCldComConPerNum(CalculateUtils.bigDecimal2Str(dto.getCldComConPerNum(), 1));
			vo.setCldCtlNum(CalculateUtils.bigDecimal2Str(dto.getCldCtlNum(), 1));
			vo.setComExpRisk(CalculateUtils.bigDecimal2Str(dto.getComExpRisk(), 1));
			vo.setCompanyList(dto.getCompanyList());
			vo.setCompanyName(dto.getCompanyName());
			vo.setConCom(dto.getConCom());
			vo.setCoreCldCom(dto.getCoreCldCom());
			vo.setCoreTwoCom(dto.getCoreTwoCom());
			vo.setCtlCldComNum(CalculateUtils.bigDecimal2Str(dto.getCtlCldComNum(), 1));
			vo.setDataVersion(dto.getDataVersion());
			vo.setFactoring(CalculateUtils.bigDecimal2Str(dto.getFactoring(), 1));
			vo.setFlwUnderNum(CalculateUtils.bigDecimal2Str(dto.getFlwUnderNum(), 1));
			vo.setIllFinRisk(CalculateUtils.bigDecimal2Str(dto.getIllFinRisk(), 1));
			vo.setIllMoneyFinRisk(CalculateUtils.bigDecimal2Str(dto.getIllMoneyFinRisk(), 1));
			vo.setInvestment(CalculateUtils.bigDecimal2Str(dto.getInvestment(), 1));
			vo.setLease(CalculateUtils.bigDecimal2Str(dto.getLease(), 1));
			vo.setMaxComNum(CalculateUtils.bigDecimal2Str(dto.getMaxComNum(), 1));
			vo.setOneComNum(CalculateUtils.bigDecimal2Str(dto.getOneComNum(), 1));
			vo.setOneLvlPer(dto.getOneLvlPer());
			vo.setPerStructRisk(CalculateUtils.bigDecimal2Str(dto.getPerStructRisk(), 1));
			vo.setRealConRisk(CalculateUtils.bigDecimal2Str(dto.getRealConRisk(), 1));
			vo.setRectSum(CalculateUtils.bigDecimal2Str(dto.getRectSum(), 1));
			vo.setRelCompanySum(CalculateUtils.bigDecimal2Str(dto.getRelCompanySum(), 1));
			vo.setRelInRisk(CalculateUtils.bigDecimal2Str(dto.getRelInRisk(), 1));
			vo.setShortRisk(CalculateUtils.bigDecimal2Str(dto.getShortRisk(), 1));
			vo.setSixMonNewCom(dto.getSixMonNewCom());
			vo.setSixMonNewComNum(CalculateUtils.bigDecimal2Str(dto.getSixMonNewComNum(), 1));
			vo.setStcRiskIndex(CalculateUtils.bigDecimal2Str(dto.getStcRiskIndex(), 1));
			vo.setThrPerNum(CalculateUtils.bigDecimal2Str(dto.getThrPerNum(), 1));
			vo.setTop5RecSum(dto.getTop5RecSum());
			vo.setToYearNewComNum(CalculateUtils.bigDecimal2Str(dto.getToYearNewComNum(), 1));
			vo.setTrade(CalculateUtils.bigDecimal2Str(dto.getTrade(), 1));
			vo.setTwoComNum(CalculateUtils.bigDecimal2Str(dto.getTwoComNum(), 1));
			vo.setUnderNum(CalculateUtils.bigDecimal2Str(dto.getUnderNum(), 1));
			vo.setUpperUnderNum(CalculateUtils.bigDecimal2Str(dto.getUpperUnderNum(), 1));
			vo.setAreaCode(dto.getAreaCode());
		}
		return vo;
	}

	/**
	 * 获取线集合数据
	 *
	 * @return
	 */
	private List<RelationDiagramVO.LineVO> getLineList(Map<String, NodeVO> pointDegree, Collection<LinkVO> links) {
		List<RelationDiagramVO.LineVO> lineList = Lists.newArrayList();
		if (!CollectionUtils.isEmpty(links)) {
			int i = 0;
			for (LinkVO vo : links) {
				RelationDiagramVO.LineVO lineVO = new RelationDiagramVO.LineVO();
				lineVO.setIsFullLine(LineTypeEnum.line.equals(vo.getLine()) ? "1" : "0");
				lineVO.setOrig(pointDegree.get(vo.getSource()).getName());//用点的ID
                lineVO.setOrigName(pointDegree.get(vo.getSource()).getCname());
				lineVO.setOrigLevel(String.valueOf(pointDegree.get(vo.getSource()).getCategory()));
				lineVO.setRelationship(vo.getRelatedParyName());
				lineVO.setTarget(pointDegree.get(vo.getTarget()).getName());//用点的ID
                lineVO.setTargetName(pointDegree.get(vo.getTarget()).getCname());
				lineVO.setTarLevel(String.valueOf(pointDegree.get(vo.getTarget()).getCategory()));
				lineVO.setType(vo.getGuanlian());
				lineVO.setNum(++i);
				lineList.add(lineVO);
			}
		}
		return lineList;
	}

	/**
	 * 获取线集合数据
	 * 
	 * @param list
	 * @return
	 */
	private List<LineVO> getLineList(List<List<String>> list) {
		List<LineVO> lineList = new ArrayList<LineVO>();
		for (List<String> l : list) {
			if (ListUtil.isNotEmpty(l) && l.size() == 7) {
				LineVO line = new LineVO();
				line.setOrig(l.get(0));
				line.setTarget(l.get(1));
				line.setType(l.get(2));
				line.setIsFullLine(l.get(5));
				line.setRelationship(l.get(6));
				line.setOrigLevel(l.get(3));
				line.setTarLevel(l.get(4));

				lineList.add(line);
			}
		}
		return lineList;
	}

	/**
	 * 获取点集合数据
	 *
	 * @param nodes
	 * @return
	 */
	private Map<String, Object> getPointList(Collection<NodeVO> nodes) {
		Map<String, Object> map = new HashMap<>();

		List<RelationDiagramVO.PointVO> pointList = Lists.newArrayList();
		Map<String, NodeVO> pointDegree = new HashMap<>();
		if (!CollectionUtils.isEmpty(nodes)) {
			for (NodeVO vo : nodes) {
				pointDegree.put(vo.getName(), vo);

				RelationDiagramVO.PointVO pointVO = new RelationDiagramVO.PointVO();
				pointVO.setIsPerson(NodeVoSymbolEnum.circle.equals(vo.getSymbol()) ? "1" : "0");
				pointVO.setIsSonCom(NodeVoTypeEnum.INVESTED.getRgb().equals(vo.getColor()) ? "1" : "0");
				pointVO.setLevel(String.valueOf(vo.getCategory()));
				pointVO.setName(vo.getName());//需要通过ID关联，因为可能出现多个相同的名字，就会导致游离的点出现
				pointVO.setCname(vo.getCname());

				pointList.add(pointVO);
			}
		}
		map.put("pointList", pointList);
		map.put("pointDegree", pointDegree);
		return map;
	}

	/**
	 * 获取点集合数据
	 * 
	 * @param list
	 * @return
	 */
	private List<PointVO> getPointList(List<List<String>> list) {
		List<PointVO> pointList = new ArrayList<PointVO>();
		List<String> points = new ArrayList<String>();
		Map<String, String> sonComMap = new HashMap<String, String>();
		for (List<String> l : list) {
			/* 统计点 */
			String value1 = l.get(0) + "," + l.get(3) + "," + l.get(6) + "_0";
			if (!points.contains(value1)) {
				points.add(value1);
			}
			String value2 = l.get(1) + "," + l.get(4) + ",0_0";
			if ("1".equals(l.get(4)) && "0".equals(l.get(3))) { // 投资方关联度数为0，被投资方关联度数为1，即视为投资方子公司
				sonComMap.put(l.get(1), l.get(1)); // 统计子公司
			}
			if (!points.contains(value2)) {
				points.add(value2);
			}
		}
		if (ListUtil.isNotEmpty(points)) {
			for (String s : points) {
				s = s.replaceAll("_", ",");
				String[] arr = s.split(",");

				PointVO point = new PointVO();
				point.setIsPerson(arr[2]);
				if (sonComMap.containsKey(arr[0]) && "1".equals(arr[1])) {
					point.setIsSonCom("1"); // 子公司
				} else {
					point.setIsSonCom(arr[3]);
				}
				point.setLevel(arr[1]);
				point.setName(arr[0]);

				pointList.add(point);
			}
		}
		return pointList;
	}

	private String getTableText(String tabIndex) {
		String text = null;
		switch (tabIndex) {
		case "0":
			text = "静态风险指数";
			break;
		case "1":
			text = "实际控制人风险";
			break;
		case "2":
			text = "公司扩张路径风险";
			break;
		case "3":
			text = "中心积聚化风险";
			break;
		case "4":
			text = "非法融资衍生风险";
			break;
		case "5":
			text = "短期逐利风险";
			break;
		case "6":
			text = "非法融资违规风险";
			break;
		case "7":
			text = "人才结构风险";
			break;
		default:
			break;
		}
		return text;
	}

	private int getSubMonth(StatisticsVO lastVO, StatisticsVO firstVO) {
		int sub = 0;
		if (null != lastVO && null != firstVO) {
			int lastYear = Integer.parseInt(lastVO.getDate().substring(0, 4));
			int lastMonth = Integer.parseInt(lastVO.getDate().substring(5));
			int firstYear = Integer.parseInt(firstVO.getDate().substring(0, 4));
			int firstMonth = Integer.parseInt(firstVO.getDate().substring(5));
			sub = (lastYear - firstYear) * 12 + lastMonth - firstMonth;
		}
		return sub;
	}

	private StatisticsVO getExistVO(List<StatisticsVO> list, String dateStr) {
		for (StatisticsVO vo : list) {
			if (dateStr.equals(vo.getDate())) {
				return vo;
			}
		}
		return null;
	}

	private String assembleRedisKey(String companyName, String fileType, String month) {
		String redis_key = companyName + APIConstants.redis_attPath + "_" + fileType + "_" + month;
		return redis_key;
	}
}
