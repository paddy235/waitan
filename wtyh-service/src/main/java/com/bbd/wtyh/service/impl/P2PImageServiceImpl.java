package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.domain.EasyExport.WaiTanData;
import com.bbd.wtyh.domain.EasyExport.WangdaiData;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.wangDaiAPI.*;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * P2P平台状态信息业务层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Service("p2PImageService")
public class P2PImageServiceImpl extends BaseServiceImpl implements P2PImageService, TaskService {

    @Autowired
    private P2PImageDao p2PImageDao;

    @Autowired
    private YuQingWarningMapper yuQingWarningMapper;

    @Autowired
    private PlatformMapper platformMapper;

    @Autowired
    private PlatCoreDataMapper platCoreDataMapper;

    @Autowired
    private RadarScoreMapper radarScoreMapper;

    @Autowired
    private TaskFailInfoMapper taskFailInfoMapper;

    @Autowired
    private DataLoadingMapper dataLoadingMapper;

    @Autowired
    private HologramQueryService hologramQueryService;

    @Autowired
    private CompanyInfoModifyService companyInfoModify;

    @Autowired
    private PToPMonitorService pToPMonitorService;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CoAddOrCloseService coChgMonitorService;

    private volatile boolean isShutdown = false;// 任务停止标志

    // private static final String PLAT_FORM_STATUS_CACHE_PRIFIX = "wtyh:P2PImage:platFormStatus";
    private Logger logger = LoggerFactory.getLogger(P2PImageServiceImpl.class);

    @Override
    public PlatCoreDataDO getPlatCoreData(String platName) {
        if (StringUtils.isBlank(platName)) {
            return null;
        }
        return this.selectOne(PlatCoreDataDO.class, "plat_name = ? ORDER BY create_date DESC,id DESC LIMIT 1", platName);
    }

    public <T extends Number > T objectToBaseNumber (T t, Class tt){
        if(t != null){
            return t;
        }
        double x = 0.0;

        if(tt.equals(Double.class) ){
            Double xx = 0.0;
            return (T) xx;
        }else{
            Integer xx = 0;
            return (T) xx;
        }
    }


    @Override
    public  PlatDataDO getPlatData(String platName) {
        PlatCoreDataDO platCoreDataDO =this.getPlatCoreData(platName);
        PlatDataDO platDataDO;
        //如果本地没有就从线上取
        if ( null ==platCoreDataDO ) {
            platDataDO =p2PImageDao.getPlatData(platName);
            return platDataDO;
        }
        platDataDO =new PlatDataDO();
        platDataDO.setAmount_total( objectToBaseNumber(platCoreDataDO.getAmountTotal(), Double.class) );
        platDataDO.setBid_num_stay_stil( objectToBaseNumber( platCoreDataDO.getBidNumStayStil(), Integer.class ) );
        platDataDO.setBor_num_stay_stil( objectToBaseNumber( platCoreDataDO.getBorNumStayStil(), Integer.class ) );
        platDataDO.setCompany_name(platCoreDataDO.getCompanyName());
        platDataDO.setDay30_net_inflow( objectToBaseNumber( platCoreDataDO.getDay30NetInflow(), Double.class ) );
        platDataDO.setInterest_rate( objectToBaseNumber( platCoreDataDO.getInterestRate(), Double.class ) );
        platDataDO.setMoney_stock( objectToBaseNumber( platCoreDataDO.getMoneyStock(), Double.class ));
        platDataDO.setOther_sum_amount( objectToBaseNumber( platCoreDataDO.getOtherSumAmount(), Double.class ) );
        platDataDO.setPlat_name(platCoreDataDO.getPlatName());
        //platDataDO.setPlat_score(platCoreDataDO.get?);
        //platDataDO.setPlat_status(platCoreDataDO.get?);
        platDataDO.setTop1_sum_amount( objectToBaseNumber( platCoreDataDO.getTop1SumAmount(), Double.class ) );
        platDataDO.setTop10_sum_amount( objectToBaseNumber( platCoreDataDO.getTop10SumAmount(), Double.class ));
        try {
             Type type = new TypeToken<ArrayList<PlatDataDO.PlatDataSixMonth>>() {}.getType();
            platDataDO.setPlat_data_six_month(
                    (new Gson()).fromJson( platCoreDataDO.getPlatDataSixMonth(), type ) );
        } catch (Exception e) {
            platDataDO.setPlat_data_six_month(new LinkedList<>());
        }
        return  platDataDO;
    }

    @Override
    public Map<String, Object> platFormStatus(String platName) {
        if (StringUtils.isBlank(platName)) {
            return null;
        }
        String where = "plat_name = ? ORDER BY create_date DESC LIMIT 1";
        PlatformDO pn = this.selectOne(PlatformDO.class, where, platName);
        if (null == pn) {
            return null;
        }

        PlatRankDataDO rankData = this.selectOne(PlatRankDataDO.class, where, platName);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("logo", pn.getLogoUrl());// logo
        result.put("score", (null == rankData) ? "" : rankData.getPlatRank()); // 评级
        result.put("platname", pn.getPlatName()); // 平台名称
        result.put("companyName", pn.getCompanyName()); // 公司名称
        result.put("status", (null == rankData) ? "" : rankData.getPlatStatus()); // 营业状态
        return result;
    }

    @Override
    public PlatListDO findFromWangdaiPlatList(String platName) {
        return platformMapper.queryPlatByPlatName(platName);
        //return getWangdaiPlatList().get(platName);
    }

    @Override
    public Map<String, PlatListDO> getWangdaiPlatList() {
        Map<String, PlatListDO> wangdaiPlatList = new HashMap<>();
        for (PlatListDO platListDO : p2PImageDao.baseInfoWangDaiApi()) {
            String name = platListDO.getCompany_name();
            if (null == name) {
                continue;
            }
            platListDO.setCompany_name(name.trim());
            wangdaiPlatList.put(platListDO.getPlat_name(), platListDO);
        }
        return wangdaiPlatList;
    }

    @Override
    public YuQingDTO platformConsensus(String platName) {

        List<YuQingWarningDO> list = this.selectAll(YuQingWarningDO.class, "plat_name = ?", platName);

        // 本地没有数据则走接口获取
        if (CollectionUtils.isEmpty(list)) {
            return p2PImageDao.platformConsensus(platName);
        }

        YuQingDTO yuQingDTO = new YuQingDTO();

        List<YuQingDTO.Warning> warningList = new ArrayList<>(list.size());

        list.forEach(yuQingWarningDO -> {
            yuQingDTO.setPlat_name(yuQingWarningDO.getPlatName());
            yuQingDTO.setScore(yuQingWarningDO.getScore());

            YuQingDTO.Warning warning = new YuQingDTO.Warning();
            warning.setTitle(yuQingWarningDO.getTitle());
            warning.setContent(yuQingWarningDO.getContent());
            warning.setSource(yuQingWarningDO.getSource());
            warning.setDate(yuQingWarningDO.getDate());
            warningList.add(warning);
        });
        yuQingDTO.setWarning(warningList);
        return yuQingDTO;
    }

    private PlatformDO getPlatListData(String platName) {
        if (StringUtils.isBlank(platName)) {
            return null;
        }
        return this.selectOne(PlatformDO.class, "plat_name = ? ORDER BY create_date DESC ,id DESC LIMIT 1", platName);
    }

    @Override
    public Map<String, Object> lawsuitMsg(String platName) {

        PlatformDO platDataDO = this.getPlatListData(platName);
        if (null == platDataDO) {
            return null;
        }
        String companyName = platDataDO.getCompanyName()!=null?platDataDO.getCompanyName().trim():platDataDO.getCompanyName();
        /*Long total = platformMapper.countKtgg(companyName);
        if (total == null || total == 0) {
            return p2PImageDao.lawsuitMsg(companyName);
        }*/
        Map<String, Integer> resultH =hologramQueryService.litigationTotal(companyName, null);
        if( resultH ==null || resultH.size() <1 ) {
            return null;
        }
        Integer total = resultH.get("lawsuitTotal");
        if (total == null || total == 0) {
            return null;
        }
        Map<String, Object> result = new HashMap<>(1);
        result.put("total", total);
        return result;
    }

    @Override
    public Map<String, Object> radarScore(String platName) {

        RadarScoreDO scoreDO = this.selectOne(RadarScoreDO.class, "plat_name = ? ORDER BY create_date DESC LIMIT 1", platName);
        if (scoreDO == null) {
            return p2PImageDao.radarScore(platName);
        }
        Map<String, Object> source = new LinkedHashMap<>();
        source.put("运营能力", scoreDO.getOperation());
        source.put("违约成本", scoreDO.getPenaltyCost());
        source.put("分散度", scoreDO.getDispersion());
        source.put("资本充足", scoreDO.getCapital());
        source.put("流动性", scoreDO.getFluidity());
        source.put("信息披露", scoreDO.getInfoDisclosure());
        // 数据格式化
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> indicator = new ArrayList<>();
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            Map<String, Object> score = new HashMap<>();
            score.put("name", entry.getKey());
            score.put("max", entry.getValue());
            indicator.add(score);
        }
        List<List<Object>> series = new ArrayList<>();
        List<Object> serie = new ArrayList<>();
        serie.add(source.get("运营能力"));
        serie.add(source.get("违约成本"));
        serie.add(source.get("分散度"));
        serie.add(source.get("资本充足"));
        serie.add(source.get("流动性"));
        serie.add(source.get("信息披露"));
        series.add(serie);
        result.put("indicator", indicator);
        result.put("series", series);
        result.put("code", "1");
        return result;
    }

    @Override
    public String findCompanyNameFromDbThenAPI(String platName, Map<String, PlatListDO> wangdaiList) {
        PlatformNameInformationDO platformNameInformationDO = p2PImageDao.hasOrNotCompany(platName);
        PlatListDO platListDO;
        if (null == wangdaiList) {
            platListDO = platformMapper.queryPlatByPlatName(platName);
        } else {
            platListDO = wangdaiList.get(platName);
        }

        String companyName;
        if (null != platformNameInformationDO) {
            companyName = platformNameInformationDO.getName();
        } else if (null != platListDO) {
            companyName = platListDO.getCompany_name();
        } else {
            return null;
        }
        return companyName;
    }

    @Override
    public Map<String, Object> baseInfo(String platName) {
        PlatformDO platDataDO = this.getPlatListData(platName);

        if (null == platDataDO) {
            return null;
        }
        String tempName=platDataDO.getCompanyName()!=null?platDataDO.getCompanyName().trim():platDataDO.getCompanyName();
        if (StringUtils.isBlank(tempName)) {
            return null;
        }
        String companyName = tempName;

        // 组织机构数据
        ZuZhiJiGoudmDO zuZhiJiGoudmDO = p2PImageDao.baseInfoZuZhiJiGou(companyName);
        if (null == zuZhiJiGoudmDO) {
            return null;
        }
        // 本地取数
        Map<String, Object> map = dataLoadingMapper.wangdaiBaseInfo(companyName);
        // 本地无数据，则取接口
        if (map == null || map.isEmpty()) {
            BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(companyName, null);
            if (null == baseDataDO) {
                return null;
            }
            map = new HashMap<>();
            for (BaseDataDO.Results result : baseDataDO.getResults()) {
                map.put("legalPeople", result.getJbxx().getFrname());
                map.put("capital", result.getJbxx().getRegcap());
                map.put("address", result.getJbxx().getAddress());
                map.put("openedTime", result.getJbxx().getEsdate());
                map.put("verifiedTime", result.getJbxx().getApproval_date());
                map.put("registerOffice", result.getJbxx().getRegorg());
            }
        }

        for (ZuZhiJiGoudmDO.Result result : zuZhiJiGoudmDO.getResults()) {
            map.put("companyCode", result.getJgdm());
        }

        map.put("platName", platName);
        map.put("companyName", companyName);
        return map;
    }

    @Override
    public Map<String, Object> coreDataInfo(String platName) {
        PlatCoreDataDO platCoreDataDO = this.getPlatCoreData(platName);
        if (platCoreDataDO == null) {
            return p2PImageDao.coreDataInfo(platName);
        }

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("amount_total", platCoreDataDO.getAmountTotal());
        data.put("money_stock", platCoreDataDO.getMoneyStock());
        data.put("interest_rate", platCoreDataDO.getInterestRate());
        data.put("month_net_inflow", platCoreDataDO.getDay30NetInflow());
        data.put("bid_num_stay_stil", platCoreDataDO.getBidNumStayStil());
        data.put("bor_num_stay_stil", platCoreDataDO.getBorNumStayStil());
        data.put("top1_sum_amount", platCoreDataDO.getTop1SumAmount());
        data.put("top10_sum_amount", platCoreDataDO.getTop10SumAmount());
        return data;
    }

    @Override
    public List<List<String>> coreDataDealTrend(String platName) {
        return parsePlatDataSixMonth(platName, 29, "day_amount");
    }

    @Override
    public List<PlatformNameInformationDO> queryPlatFromPlatList(String platName) {
        return platformMapper.queryPlatFromPlatList(platName);
    }


    @Override
    public List<List<String>> coreDataInterestRateTrend(String plat_name) {
        return parsePlatDataSixMonth(plat_name, 29, "day_interest_rate");
    }

    @Override
    public List<List<String>> coreDataLoadOverage(String plat_name) {
        return parsePlatDataSixMonth(plat_name, 29, "day_money_stock");
    }


    /**
     * 解析近6个月每日详情数据
     * 
     * @param platName 平台数据
     * @param startNum 取前多少条数据，如果大于总条数则等于总条数
     * @param jsonKey 具体数据KEY
     */
    private List<List<String>> parsePlatDataSixMonth(String platName, int startNum, String jsonKey) {
        PlatCoreDataDO platCoreDataDO = this.getPlatCoreData(platName);
        if (platCoreDataDO == null) {
            return null;
        }
        String platDataSixMonthStr = platCoreDataDO.getPlatDataSixMonth();
        if (StringUtils.isBlank(platDataSixMonthStr)) {
            return null;
        }

        JSONArray jsonArray = JSONArray.parseArray(platDataSixMonthStr);
        List<String> days = new ArrayList<>();
        List<String> amounts = new ArrayList<>();

//        if (jsonArray.size() < startNum) {
//        }
//        startNum = jsonArray.size();
        for (int i = 0; i <jsonArray.size(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            BigDecimal dayAmount = json.getBigDecimal(jsonKey);
            if(dayAmount.compareTo(new BigDecimal("0"))<=0){
                continue;
            }
            days.add(json.getString("date"));
            amounts.add(dayAmount.toPlainString());
            if(amounts.size()>=29){
                break;
            }
        }
        if(amounts.size()==0&&days.size()==0){
//            if (jsonArray.size() < startNum) {
//                startNum = jsonArray.size();
//            }
            for (int i = 0; i <jsonArray.size(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                BigDecimal dayAmount = json.getBigDecimal(jsonKey);
                days.add(json.getString("date"));
                amounts.add(dayAmount.toPlainString());
                if(amounts.size()>=29){
                    break;
                }
            }
        }
        //倒序取，省得后面排序
        if(amounts.size()>0&&days.size()>0){
            Collections.reverse(days);
            Collections.reverse(amounts);
        }
        List<List<String>> result = new ArrayList<>();
        result.add(days);
        result.add(amounts);
        return result;
    }

    @Override
    public PlatformNameInformationDO hasOrNotCompany(String platName) {
        return p2PImageDao.hasOrNotCompany(platName);
    }

    @Override
    public List<PlatformNameInformationDO> associatedCompanys(String platName) {
        List<PlatformNameInformationDO> rst = new ArrayList<>();
        List<PlatformNameInformationDO> platNames = p2PImageDao.associatedPlatName(platName);
        rst.addAll(platNames);
        // 拼接 5 个元素的列表
        if (5 > platNames.size()) {
            List<PlatformNameInformationDO> companyNames = p2PImageDao.associatedCompanyName(platName, 5 - platNames.size());
            rst.addAll(companyNames);
        }
        return rst;
    }

    @Override
    public TaskResultDO p2pImageDataLandTask(Integer taskId) {
        logger.info("--- p2p image data job begin ---");
        isShutdown = false;
        TaskResultDO taskResultDO = new TaskResultDO();
        List<PlatListDO> platList;
        try {
            platList = p2PImageDao.baseInfoWangDaiApiFromNet();
            if (platList == null) {
                throw new Exception("dataType=plat_list 调用异常");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            taskResultDO.setPlanCount(1);
            taskResultDO.setSuccessCount(0);
            taskResultDO.setFailCount(1);
            taskResultDO.setState(TaskState.ERROR);
            addWangdaiTaskInfo(taskId, "网贷平台列表(plat_list)", e.getClass().getSimpleName());
            return taskResultDO;
        }
        Map<Integer, Integer> platRankMapData = null;
        try {
            platRankMapData = pToPMonitorService.getPlatRankMapData();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        Integer planCount = platList == null ? 0 : platList.size();
        Integer failCount = 0;
        taskResultDO.setPlanCount(planCount);

        for (PlatListDO plat : platList) {
            if (isShutdown) {
                break;
            }
            logger.info(String.format("start update %s data", plat.getPlat_name()));
            try {
                // 保存platList 基本信息
                updatePlatList(plat);

                // 保存平台核心数据
                updatePlatCoreData(plat);

                // 保存舆情数据
                updateWangDaiYuQing(plat.getPlat_name());

                // 保存雷达数据
                updateRadarScore(plat);

                if(null!=platRankMapData){
                    updateP2PCompanyLevel(plat,platRankMapData);
                }

            } catch (Exception e) {
                taskResultDO.setState(TaskState.ERROR);
                logger.error(e.getMessage(), e);
                addWangdaiTaskInfo(taskId, plat.getPlat_name(), e.getClass().getSimpleName());
                failCount++;
            }
            logger.info(String.format("end update %s data", plat.getPlat_name()));
        }

        if (isShutdown) {
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        } else {
            taskResultDO.setFailCount(failCount);
            taskResultDO.setSuccessCount(planCount - failCount);
        }
        logger.info("--- p2p image data job end ---");
        return taskResultDO;
    }

    @Override
    public TaskResultDO executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId) {
        logger.info("--- p2p image data handle begin ---");
        isShutdown = false;
        TaskResultDO taskResultDO = new TaskResultDO();
        List<TaskFailInfoDO> list = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
        List<String> platNameList = list.stream().filter(Objects::nonNull).map(TaskFailInfoDO::getFailName).collect(Collectors.toList());
        List<PlatListDO> platList = new ArrayList<>();
        try {
            platList = p2PImageDao.baseInfoWangDaiApiFromNet();
            platList = platList.stream().filter(n -> platNameList.contains(n.getPlat_name())).collect(Collectors.toList());
            if (platList == null) {
                throw new Exception("dataType=plat_list 调用异常");
            }
        } catch (Exception e) {
            taskResultDO.setState(TaskState.ERROR);
            logger.error(e.getMessage(), e);
        }
        Integer planCount = platList.size();
        Integer failCount = 0;
        for (PlatListDO plat : platList) {
            if (isShutdown) {
                break;
            }
            logger.info(String.format("start update %s data", plat.getPlat_name()));
            try {
                // 保存platList 基本信息
                updatePlatList(plat);

                // 保存平台核心数据
                updatePlatCoreData(plat);

                // 保存舆情数据
                updateWangDaiYuQing(plat.getPlat_name());

                // 保存雷达数据
                updateRadarScore(plat);

            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                addWangdaiTaskInfo(taskId, plat.getPlat_name(), e.getClass().getSimpleName());
                failCount++;
                taskResultDO.setState(TaskState.ERROR);
            }
            logger.info(String.format("end update %s data", plat.getPlat_name()));
        }

        taskResultDO.setPlanCount(planCount);
        if (isShutdown) {
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        } else {
            taskResultDO.setFailCount(failCount);
            taskResultDO.setSuccessCount(planCount - failCount);
        }
        logger.info("--- p2p image data handle end ---");
        return taskResultDO;
    }

    protected void addWangdaiTaskInfo(Integer taskId, String api, String failName) {
        TaskFailInfoDO taskFailInfoDO = new TaskFailInfoDO();
        taskFailInfoDO.setTaskId(taskId);
        taskFailInfoDO.setFailName(api);
        switch (failName) {
        case "ConnectTimeoutException":
            taskFailInfoDO.setFailReason("接口连接超时");
            break;
        case "JsonSyntaxException":
            taskFailInfoDO.setFailReason("接口返回数据解析失败");
            break;
        case "SQLException":
            taskFailInfoDO.setFailReason("入库失败");
            break;
        default:
            taskFailInfoDO.setFailReason("接口调用失败");
        }
        taskFailInfoDO.setCreateBy("system");
        taskFailInfoDO.setCreateDate(new Date());
        taskFailInfoMapper.addTaskFailInfo(taskFailInfoDO);
    }

    protected void updateWangDaiYuQing(String platName) {
        if (isShutdown) {
            return;
        }
        try {
            YuQingDTO yuQingDTO = p2PImageDao.platformConsensus(platName);
            if (yuQingDTO != null) {
                yuQingWarningMapper.delByPlatName(yuQingDTO.getPlat_name());
                for (YuQingDTO.Warning warning : yuQingDTO.getWarning()) {
                    YuQingWarningDO warningDO = new YuQingWarningDO();
                    warningDO.setPlatName(yuQingDTO.getPlat_name());
                    warningDO.setScore(yuQingDTO.getScore());
                    warningDO.setTitle(warning.getTitle());
                    warningDO.setContent(warning.getContent());
                    warningDO.setDate(warning.getDate());
                    warningDO.setSource(warning.getSource());
                    warningDO.setCreateBy("system");
                    warningDO.setCreateDate(new Date());
                    yuQingWarningMapper.save(warningDO);
                }
            }
        } catch (JsonSyntaxException e) {
            logger.error(String.format("dataType＝yuqing&plat_name=%s  return bad value", platName));
        }
    }

    protected void updatePlatList(PlatListDO dto) {
        if (isShutdown) {
            return;
        }
        PlatformDO platListDO = new PlatformDO();
        platListDO.setPlatName(dto.getPlat_name());
        platListDO.setCompanyName(dto.getCompany_name()!=null?dto.getCompany_name().trim():dto.getCompany_name());
        platListDO.setLogoUrl(dto.getLogo_url());
        platListDO.setAreaId(dto.getArea_id());
        platListDO.setCreateBy("system");
        platListDO.setCreateDate(new Date());

        // platformMapper.deleteByPlatName(dto.getPlat_name());
        platformMapper.save(platListDO);
    }

    protected void updatePlatCoreData(PlatListDO platListDO) throws Exception {
        if (isShutdown) {
            return;
        }
        try {
            PlatCoreDataDTO platDataDO = p2PImageDao.getPlatCoreData(platListDO.getPlat_name());
            if (platDataDO != null) {
                PlatCoreDataDO platCoreDataDO = new PlatCoreDataDO();
                platCoreDataDO.setPlatName(platDataDO.getPlat_name());
                platCoreDataDO.setOtherSumAmount(platDataDO.getOther_sum_amount());
                platCoreDataDO.setInterestRate(platDataDO.getInterest_rate());
                platCoreDataDO.setBidNumStayStil(platDataDO.getBid_num_stay_stil());
                platCoreDataDO.setBorNumStayStil(platDataDO.getBor_num_stay_stil());
                platCoreDataDO.setPlatDataSixMonth(platDataDO.getPlat_data_six_month().toString().replace("=", ":"));
                platCoreDataDO.setCompanyName(platDataDO.getCompany_name()!=null ? platDataDO.getCompany_name().trim():platDataDO.getCompany_name());
                platCoreDataDO.setTop10SumAmount(platDataDO.getTop10_sum_amount());
                platCoreDataDO.setMoneyStock(platDataDO.getMoney_stock());
                platCoreDataDO.setDay30NetInflow(platDataDO.getDay30_net_inflow());
                platCoreDataDO.setTop1SumAmount(platDataDO.getTop1_sum_amount());
                platCoreDataDO.setAmountTotal(platDataDO.getAmount_total());
                platCoreDataDO.setCreateBy("system");
                platCoreDataDO.setCreateDate(new Date());

                // platCoreDataMapper.deleteByPlatName(platDataDO.getPlat_name());
                platCoreDataMapper.save(platCoreDataDO);
            }
        } catch (JsonSyntaxException e) {
            logger.error(String.format("dataType＝plat_data&plat_name=%s  return bad value", platListDO.getPlat_name()));
        }

    }

    protected void updateRadarScore(PlatListDO plat) throws Exception {
        if (isShutdown) {
            return;
        }
        try {
            RadarScoreDTO object = p2PImageDao.getRadarScore(plat.getPlat_name());
            RadarScoreDO radarScoreDO = new RadarScoreDO();
            if (object != null && object.getPlat_name() != null) {
                radarScoreDO.setPlatName(object.getPlat_name());
                radarScoreDO.setInfoDisclosure(object.getInfo_disclosure());
                radarScoreDO.setFluidity(object.getFluidity());
                radarScoreDO.setDispersion(object.getDispersion());
                radarScoreDO.setCapital(object.getCapital());
                radarScoreDO.setPenaltyCost(object.getPenalty_cost());
                radarScoreDO.setOperation(object.getOperation());
                radarScoreDO.setCreateBy("system");
                radarScoreDO.setCreateDate(new Date());

                // radarScoreMapper.deleteByPlatName(object.getPlat_name());
                radarScoreMapper.save(radarScoreDO);
            }
        } catch (JsonSyntaxException e) {
            logger.error(String.format("dataType＝leida&plat_name=%s return bad value", plat.getPlat_name()));
        }
    }

    protected void updateP2PCompanyLevel(PlatListDO plat,Map<Integer, Integer> platRankMapData) throws Exception {
        if (isShutdown) {
            return;
        }
        try {
            //风险等级被人工修改过，则不再更新
            if (companyInfoModify.isModifyByAfterRisk(plat.getCompany_name())) {
                return;
            }
            CompanyDO companyDO = companyMapper.selectByName(plat.getCompany_name());
            if(null == companyDO){
                return;
            }
            Integer companyId = companyDO.getCompanyId();
            Integer oldRiskLevel = companyDO.getRiskLevel();
            Integer riskLevelForPToP = platRankMapData.get(companyId);
            Integer companyType=(companyDO!=null && companyDO.getCompanyType() != null)?companyDO.getCompanyType().intValue():-1;

            if(null==riskLevelForPToP){
                return;
            }
            if (!riskLevelForPToP.equals(oldRiskLevel)) { // 只记录前一次变化的，这是最新的产品需求
                companyMapper.updateRiskLevel(riskLevelForPToP, oldRiskLevel, companyId, "system");
                logger.error("riskLevel changed: companyId={} oldRiskLevel={} newRiskLevel:{}", companyId, oldRiskLevel, riskLevelForPToP);
                // 添加风险变化公司
                BeanCopier beanCopier = BeanCopier.create(CompanyDO.class, RiskChgCoDo.class, false);
                RiskChgCoDo rcco = new RiskChgCoDo();
                beanCopier.copy(companyDO, rcco, null);

                rcco.setCompanyName(companyDO.getName());
                rcco.setCompanyType((companyType==-1)?null:companyType);

                rcco.setOldRiskLevel(oldRiskLevel);
                rcco.setRiskLevel(riskLevelForPToP);
                rcco.setSource(RiskChgCoSource.MODEL_SCORE.type());

                rcco.setCreateBy("updateCoRiskLevelTask");

                try {
                    this.coChgMonitorService.saveRiskChgCo(rcco);
                } catch (Exception e) {
                    logger.error("保存风险变化公司失败！companyId：" + companyId, e);
                }
            }
        } catch (Exception e) {
            logger.error(String.format("dataType＝p2pRiskLevel&plat_name=%s return bad value", plat.getPlat_name()));
        }
    }

    public Map<String, PlatListDO> getWangdaiCompanyList() {
        Map<String, PlatListDO> wangdaiCompanyList = new HashMap<>();
        if (p2PImageDao.baseInfoWangDaiApi() == null) {
            return null;
        }
        for (PlatListDO platListDO : p2PImageDao.baseInfoWangDaiApi()) {
            platListDO.setCompany_name(platListDO.getCompany_name().trim());
            wangdaiCompanyList.put(platListDO.getCompany_name(), platListDO);
        }
        return wangdaiCompanyList;
    }

    @Override
    public PlatListDO getWangdaiCompanyList(String companyName) {
        if (null == getWangdaiCompanyList()) {
            return null;
        }
        return getWangdaiCompanyList().get(companyName);
    }

    @Override
    public List<WangdaiData> getWangdai(ExportCondition exportCondition, PageBean pageBean) {
        pageBean.setTotalCount(platCoreDataMapper.countWangdai(exportCondition));
        return platCoreDataMapper.getWangdai(exportCondition, pageBean);
    }

    @Override
    public List<WaiTanData> getWaiTanOther(ExportCondition exportCondition, PageBean pageBean) {
        pageBean.setTotalCount(platCoreDataMapper.countWaiTanOther(exportCondition));
        return platCoreDataMapper.getWaiTanOther(exportCondition, pageBean);
    }

    @Override
    public void recordWangdai(WangdaiModify wangdaiModify) {
        platformMapper.recordWangdai(wangdaiModify);
    }

    @Override
    public String getTaskKey() {
        return "p2pImageJob";
    }

    @Override
    public String getTaskGroup() {
        return "wd_work";
    }

    @Override
    public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
        return p2pImageDataLandTask(taskId);
    }

    @Override
    public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {
        return executeFailTaskByTaskId(runMode, oldTaskId, newTaskId);
    }

    @Override
    public void stopExecute(Integer taskId) {
        stopTask();
    }

    @Override
    public void resetTask() {
        this.isShutdown = false;
    }

    @Override
    public void stopTask() {
        isShutdown = true;
    }
}
