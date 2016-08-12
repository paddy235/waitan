package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.dto.StaticRiskDTO;
import com.bbd.wtyh.domain.vo.LineVO;
import com.bbd.wtyh.domain.vo.PointVO;
import com.bbd.wtyh.domain.vo.StaticRiskVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import com.bbd.wtyh.mapper.StaticRiskMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.BuildFileService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.RelationCompanyService;
import com.bbd.wtyh.service.impl.relation.RegisterUniversalFilterChainImp;
import com.bbd.wtyh.service.impl.relation.common.APIConstants;
import com.bbd.wtyh.service.impl.relation.exception.BbdException;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.util.DateUtils;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 线下理财接口实现层
 * @author zhouxuan
 * @since  2016.08.05
 */
@Service("offlineFinanceService")
public class OfflineFinanceServiceImpl implements OfflineFinanceService {
    private Logger logger = LoggerFactory.getLogger(OfflineFinanceServiceImpl.class);
    @Resource
    private HttpTemplate httpTemplate;
    @Resource
    private StaticRiskMapper staticRiskMapper;
    @Resource
    private RelationCompanyService relationCompanyService;
    @Resource
    private RegisterUniversalFilterChainImp registerUniversalFilterChainImp;
    @Resource
    private BuildFileService buildFileService;
    @Resource
    private RedisDAO redisDAO;

    private static final String RISE = "1";
    private static final String FALL = "-1";
    private final String file_type_1 = "yed";

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Map<String, List> queryRelation(String companyName, String dataVersion) throws Exception  {
        List<List<String>> list = null;
        JSONArray jsonArr = null;
        String json = redisDAO.getString(companyName + APIConstants.redis_relation_LinksDataJTTP + dataVersion);
        if (StringUtils.isEmpty(json)) {
            json = relationCompanyService.getAPIDynamicRelatedPartUploadJTTP(companyName, APIConstants.show_relation_E, dataVersion);
        }
        if (StringUtils.isEmpty(json)) {
            json="[]"; // 没有查询到数据的情况
        }
        jsonArr = JSONArray.fromObject(json);
        list = JSONArray.toList(jsonArr, new String(), new JsonConfig());
        Map<String, List> map = this.getRelationData(list);
        return map;
    }

    @Override
    public List<Map> companyNews(String companyName) {
        return null;
    }

    @Override
    public List<Map> staticRiskIndex(String companyName) {
        return null;
    }

    @Override
    public List<Map> staticRiskList(String companyName) {
        return null;
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
    public List<Map> dynamicComparisonChart(String companyName, String dateA, String dateB) {
        return null;
    }

    @Override
    public List<Map> companyRelatedComparisonChart(String companyName, String dateA, String dateB) {
        return null;
    }

    @Override
    public List<Map> riskFactor() {
        return null;
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
                } else {} // 保持结构完整
            }
        }
        return vo;
    }

    @Override
    public String createYED(String companyName, String month) throws Exception{
        String filePath = "";
        String attDirectory = Constants.shareDir+File.separator+Constants.attDir;
        String redis_key = assembleRedisKey(companyName,file_type_1,month);
        String redis_value = redisDAO.getString(redis_key);
        boolean flag = true;
        if(!new File(attDirectory).exists())
        {
            flag = new File(attDirectory).mkdirs();
        }
        if(redis_value == null)
        {
            if(flag)
            {
                try {
                    filePath = this.createOriginYED(companyName,attDirectory,month);
                    redis_value = Constants.attDir+File.separator+new File(filePath).getName();
                    redisDAO.addString(redis_key,redis_value, Constants.cacheDay);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }

            }

        }else
        {
            filePath =  Constants.shareDir+File.separator+redis_value;
            File attFile = new File(filePath);
            if(!attFile.exists())
            {
                try {
                    filePath = this.createOriginYED(companyName,attDirectory,month);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            }else{
                if(attFile.length()==0)
                {
                    attFile.delete();
                    throw new BbdException("对不起，您搜索的公司关联方数据正在分析更新中，暂时无法提供信息，请稍后再试。",true);
                }
            }
        }

        return filePath;
    }

    public String createOriginYED(String companyName,String attDirectory,String month) throws Exception
    {
        List<List<Object>> data =  registerUniversalFilterChainImp.HierarchicalFuzzySearchDataJTTP(companyName,month,3);
        if(data.size()==0)
        {
            throw new BbdException(companyName + "：对不起，您搜索的公司关联方数据正在分析更新中，暂时无法提供信息，请稍后再试。",true);
        }
        String	filePath = attDirectory+File.separator+companyName+month+".gif";
        File yedFile = new File(filePath);
        boolean result = true;
        if(!yedFile.exists())
        {
            result = buildFileService.buildImage(data, companyName, filePath, false);
        }
        if(result)
        {
            return filePath;
        }else
        {
            return null;
        }

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

    private String assembleRedisKey(String companyName,String fileType,String month)
    {
        String redis_key = companyName+APIConstants.redis_attPath+"_"+fileType+"_"+month;
        return redis_key;
    }
}
