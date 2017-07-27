package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.domain.EasyExport.WangdaiData;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;
import com.bbd.wtyh.domain.wangDaiAPI.*;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class P2PImageServiceImpl implements P2PImageService {
    @Autowired
    private P2PImageDao p2PImageDao;

    @Autowired
    private PToPMonitorService pToPMonitorService;

    @Autowired
    private RedisDAO redisDAO;

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


    private static final String PLAT_FORM_STATUS_CACHE_PRIFIX = "wtyh:P2PImage:platFormStatus";

    private Logger logger = LoggerFactory.getLogger(P2PImageServiceImpl.class);

    @Override
    public PlatDataDO getPlatData(String platName) {
        PlatDataDO pn = p2PImageDao.getPlatData(platName);
        return pn;
    }


    @Override
    public Map<String, Object> platFormStatus(String platName) {
        PlatDataDO pn = p2PImageDao.getPlatData(platName);  // 查询网贷API
        if (null == pn) {
            return null;
        }

        Map<String, Map<String, Object>> platSts = (Map<String, Map<String, Object>>) redisDAO.getObject(PLAT_FORM_STATUS_CACHE_PRIFIX);
        PlatRankDataDTO platRankDataDTO = null;
        if (null != platSts) {
            Map<String, Object> platSt = (Map) platSts.get(platName);
            if (null != platSt) {
                platRankDataDTO = new PlatRankDataDTO();
                platRankDataDTO.setPlat_status((null != platSt.get("plat_status")) ? (String) platSt.get("plat_status") : null);
            }
        }
        //缓存取不到，就取实时数据
        if (null == platRankDataDTO) {
            platRankDataDTO = findFromWangdaiPlatRankData(platName);
        }

        PlatListDO platListDO = findFromWangdaiPlatList(platName);  // 获取logo

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("logo", (null == platListDO) ? null : platListDO.getLogo_url());//logo
        result.put("score", platRankDataDTO.getPlatRank()); // 评级
        result.put("platname", pn.getPlat_name()); // 平台名称
        result.put("companyName", pn.getCompany_name()); // 公司名称
        result.put("status", platRankDataDTO.getPlat_status()); // 营业状态
        return result;
    }

    @Override
    public PlatRankDataDTO findFromWangdaiPlatRankData(String platName) {
        Map<String, PlatRankDataDTO> wangdaiPlatRankData = new HashMap<>();
        try {
            for (PlatRankDataDTO platRankDataDTO : pToPMonitorService.getPlatRankData()) {
                wangdaiPlatRankData.put(platRankDataDTO.getPlat_name(), platRankDataDTO);
            }
            return wangdaiPlatRankData.get(platName);
        } catch (Exception e) {
            e.printStackTrace();
            return new PlatRankDataDTO();
        }
    }

    @Override
    public PlatListDO findFromWangdaiPlatList(String platName) {
        return getWangdaiPlatList().get(platName);
    }

    @Override
    public Map<String, PlatListDO> getWangdaiPlatList() {
        Map<String, PlatListDO> wangdaiPlatList = new HashMap<>();
        for (PlatListDO platListDO : p2PImageDao.baseInfoWangDaiApi()) {
            platListDO.setCompany_name(platListDO.getCompany_name().trim());
            wangdaiPlatList.put(platListDO.getPlat_name(), platListDO);
        }
        return wangdaiPlatList;
    }

    @Override
    public YuQingDTO platformConsensus(String platName) {
        return p2PImageDao.platformConsensus(platName);
    }

    @Override
    public Map<String, Object> lawsuitMsg(String platName) {
        PlatDataDO platDataDO = p2PImageDao.getPlatData(platName);
        if (null == platDataDO) {
            return null;
        }
//        System.out.println("13"+platDataDO.getCompany_name());
        Map<String, Object> result = p2PImageDao.lawsuitMsg(platDataDO.getCompany_name());
        if (null == result || result.size() == 0) {
            return null;
        }
        return result;
    }

    @Override
    public Map<String, Object> radarScore(String platName) {
        PlatDataDO platData = p2PImageDao.getPlatData(platName);
        if (null == platData) {
            return null;
        }
        Map<String, Object> data = p2PImageDao.radarScore(platName);
        if (null == data || data.size() == 0) {
            return null;
        }
        data.put("sumScore", platData.getPlat_score());
        return data;
    }

    @Override
    public String findCompanyNameFromDbThenAPI(String platName, Map<String, PlatListDO> wangdaiList) {
        PlatformNameInformationDO platformNameInformationDO = p2PImageDao.hasOrNotCompany(platName);
        PlatListDO platListDO = wangdaiList.get(platName);

        String companyName = "";
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
        Map<String, PlatListDO> wangdaiList = getWangdaiPlatList();
        String companyName = findCompanyNameFromDbThenAPI(platName, wangdaiList);
        BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(companyName);
        if (null == baseDataDO) {
            return null;
        }
        ZuZhiJiGoudmDO zuZhiJiGoudmDO = p2PImageDao.baseInfoZuZhiJiGou(companyName);
        if (null == zuZhiJiGoudmDO) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        for (BaseDataDO.Results result : baseDataDO.getResults()) {
            map.put("legalPeople", result.getJbxx().getFrname());
            map.put("capital", result.getJbxx().getRegcap());
            map.put("address", result.getJbxx().getAddress());
            map.put("openedTime", result.getJbxx().getEsdate());
            map.put("verifiedTime", result.getJbxx().getApproval_date());
            map.put("registerOffice", result.getJbxx().getRegorg());
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
        Map<String, Object> data = p2PImageDao.coreDataInfo(platName);
        if (null == data || data.size() == 0) {
            return null;
        }
        return data;
    }

    @Override
    public List<List<String>> coreDataDealTrend(String platName) {
        PlatDataDO data = p2PImageDao.getPlatData(platName);
        if (null == data) {
            return null;
        }
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> amounts = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            BigDecimal dayAmount = new BigDecimal(String.valueOf(pdsm.getDay_amount()));
            amounts.add(dayAmount.toPlainString());
        }
        List<List<String>> result = new ArrayList<>();
        List<String> days1 = new ArrayList<>();
        List<String> amounts1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            days1.add(days.get(i));
            amounts1.add(amounts.get(i));
        }
        Collections.reverse(days1);
        Collections.reverse(amounts1);
        result.add(days1);
        result.add(amounts1);
        return result;
    }

    @Override
    public List<List<String>> coreDataInterestRateTrend(String plat_name) {
        // 处理数据转换
        PlatDataDO data = p2PImageDao.getPlatData(plat_name);
        if (null == data) {
            return null;
        }
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> interestRates = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            interestRates.add(String.valueOf(pdsm.getDay_interest_rate()));
        }
        List<String> days1 = new ArrayList<>();
        List<String> interestRates1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            days1.add(days.get(i));
            interestRates1.add(interestRates.get(i));
        }
        Collections.reverse(days1);
        Collections.reverse(interestRates1);
        List<List<String>> result = new ArrayList<>();
        result.add(days1);
        result.add(interestRates1);
        return result;
    }

    @Override
    public List<List<String>> coreDataLoadOverage(String plat_name) {
        // 处理数据转换
        PlatDataDO data = p2PImageDao.getPlatData(plat_name);
        if (null == data) {
            return null;
        }
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> loanOverages = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            BigDecimal dayAmount = new BigDecimal(String.valueOf(pdsm.getDay_money_stock()));
            loanOverages.add(dayAmount.toPlainString());
        }
        List<String> days1 = new ArrayList<>();
        List<String> loanOverages1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            days1.add(days.get(i));
            loanOverages1.add(loanOverages.get(i));
        }
        Collections.reverse(days1);
        Collections.reverse(loanOverages1);
        List<List<String>> result = new ArrayList<>();
        result.add(days1);
        result.add(loanOverages1);
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
    public Map p2pImageDataLandTask(Integer taskId) {
        logger.info("start p2pImageDataLandTask ");
        List<PlatListDO> platList = new ArrayList<>();
        try {
            platList = p2PImageDao.baseInfoWangDaiApi();
            if (platList == null) {
                throw new Exception("dataType=plat_list 调用异常");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        Integer platCount = platList.size();
        Integer failCount = 0;
        for (PlatListDO plat : platList) {
            logger.info(String.format("start update %s data", plat.getPlat_name()));
            try {
                //保存platList 基本信息
                updatePlatList(plat);

                //保存平台核心数据
                updatePlatCoreData(plat);

                //保存舆情数据
                updateWangDaiYuQing(plat.getPlat_name());

                //保存雷达数据
                updateRadarScore(plat);

            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                TaskFailInfoDO taskFailInfoDO = new TaskFailInfoDO();
                taskFailInfoDO.setTaskId(taskId);
                taskFailInfoDO.setFailName(plat.getPlat_name());
                taskFailInfoDO.setCreateBy("sys");
                taskFailInfoDO.setCreateDate(new Date());
                taskFailInfoMapper.addTaskFailInfo(taskFailInfoDO);
                failCount++;
            }
            logger.info(String.format("end update %s data", plat.getPlat_name()));
        }

        Map map = new HashMap();
        map.put("planCount", platCount);
        map.put("failCount", failCount);
        map.put("successCount", platCount - failCount);
        return map;
    }

    @Override
    public Map executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId) {
        List<TaskFailInfoDO> list = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
        List<String> platNameList = list.stream().filter(n -> n != null).map(n -> n.getFailName()).collect(Collectors.toList());
        logger.info("start executeFailTaskByTaskId ");
        List<PlatListDO> platList = new ArrayList<>();
        try {
            platList = p2PImageDao.baseInfoWangDaiApi();
            platList = platList.stream().filter(n -> platNameList.contains(n.getPlat_name())).collect(Collectors.toList());
            if (platList == null) {
                throw new Exception("dataType=plat_list 调用异常");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        Integer platCount = platList.size();
        Integer failCount = 0;
        for (PlatListDO plat : platList) {
            logger.info(String.format("start update %s data", plat.getPlat_name()));
            try {
                //保存platList 基本信息
                updatePlatList(plat);

                //保存平台核心数据
                updatePlatCoreData(plat);

                //保存舆情数据
                updateWangDaiYuQing(plat.getPlat_name());

                //保存雷达数据
                updateRadarScore(plat);

            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                TaskFailInfoDO taskFailInfoDO = new TaskFailInfoDO();
                taskFailInfoDO.setTaskId(taskId);
                taskFailInfoDO.setFailName(plat.getPlat_name());
                taskFailInfoDO.setCreateBy("sys");
                taskFailInfoDO.setCreateDate(new Date());
                taskFailInfoMapper.addTaskFailInfo(taskFailInfoDO);
                failCount++;
            }
            logger.info(String.format("end update %s data", plat.getPlat_name()));
        }

        Map map = new HashMap();
        map.put("planCount", platCount);
        map.put("failCount", failCount);
        map.put("successCount", platCount - failCount);
        return map;
    }

    protected void updateWangDaiYuQing(String platName) {
        try {
            YuQingDTO yuQingDTO = this.platformConsensus(platName);
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
                    warningDO.setCreateBy("sys");
                    warningDO.setCreateDate(new Date());
                    yuQingWarningMapper.save(warningDO);
                }
            }
        } catch (JsonSyntaxException e) {
            logger.error(String.format("dataType＝yuqing&plat_name=%s  return bad value", platName));
        }
    }


    protected void updatePlatList(PlatListDO dto) {
        PlatformDO platListDO = new PlatformDO();
        platListDO.setPlatName(dto.getPlat_name());
        platListDO.setCompanyName(dto.getCompany_name());
        platListDO.setLogoUrl(dto.getLogo_url());
        platListDO.setAreaId(dto.getArea_id());
        platListDO.setCreateBy("sys");
        platListDO.setCreateDate(new Date());

//        platformMapper.deleteByPlatName(dto.getPlat_name());
        platformMapper.save(platListDO);
    }


    protected void updatePlatCoreData(PlatListDO platListDO) throws Exception {
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
                platCoreDataDO.setCompanyName(platDataDO.getCompany_name());
                platCoreDataDO.setTop10SumAmount(platDataDO.getTop10_sum_amount());
                platCoreDataDO.setMoneyStock(platDataDO.getMoney_stock());
                platCoreDataDO.setDay30NetInflow(platDataDO.getDay30_net_inflow());
                platCoreDataDO.setTop1SumAmount(platDataDO.getTop1_sum_amount());
                platCoreDataDO.setAmountTotal(platDataDO.getAmount_total());
                platCoreDataDO.setCreateBy("sys");
                platCoreDataDO.setCreateDate(new Date());

//                platCoreDataMapper.deleteByPlatName(platDataDO.getPlat_name());
                platCoreDataMapper.save(platCoreDataDO);
            }
        } catch (JsonSyntaxException e) {
            logger.error(String.format("dataType＝plat_data&plat_name=%s  return bad value", platListDO.getPlat_name()));
        }

    }


    protected void updateRadarScore(PlatListDO plat) {
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
                radarScoreDO.setCreateBy("sys");
                radarScoreDO.setCreateDate(new Date());

 //               radarScoreMapper.deleteByPlatName(object.getPlat_name());
                radarScoreMapper.save(radarScoreDO);
            }
        } catch (JsonSyntaxException e) {
            logger.error(String.format("dataType＝leida&plat_name=%s return bad value", plat.getPlat_name()));
        }
    }

    public Map<String, PlatListDO> getWangdaiCompanyList() {
        Map<String, PlatListDO> wangdaiCompanyList = new HashMap<>();
        for (PlatListDO platListDO : p2PImageDao.baseInfoWangDaiApi()) {
            platListDO.setCompany_name(platListDO.getCompany_name().trim());
            wangdaiCompanyList.put(platListDO.getCompany_name(), platListDO);
        }
        return wangdaiCompanyList;
    }

    @Override
    public PlatListDO getWangdaiCompanyList(String companyName) {
        return getWangdaiCompanyList().get(companyName);
    }

    @Override
    public List<WangdaiData> getWangdai(ExportCondition exportCondition, PageBean pageBean) {
        return platCoreDataMapper.getWangdai(exportCondition, pageBean);
    }

    @Override
    public void recordWangdai(WangdaiModify wangdaiModify) {
        platformMapper.recordWangdai(wangdaiModify);
    }
}
