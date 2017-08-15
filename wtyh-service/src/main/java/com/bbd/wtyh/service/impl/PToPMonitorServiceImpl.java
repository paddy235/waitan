package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.*;

/**
 * @author Ian.Su
 * @since 2016年8月12日 下午2:09:15
 */
@Service("pToPMonitorServiceImpl")
public class PToPMonitorServiceImpl implements PToPMonitorService,TaskService {

    private static final String industry_shanghai = "上海网贷信息(industry_shanghai)";
    private static final String industry_compare = "网贷数据对比(industry_compare)";
    private static final String industry_problem = "问题网贷平台(industry_problem)";
    private static final String plat_rank_data = "网贷平台数据展示(plat_rank_data)";
    private static final String area_index = "上海区域发展指数(area_index)";

    @Value("${financial.services.url}")
    private String finSerUrl;

    @Value("${related.party.dataVersion}")
    private String dataVersion;

    @Autowired
    private OfflineFinanceService offlinefinanceservice;

    @Autowired
    private PlatformNameInformationMapper platformNameInformationMapper;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private IndustryShanghaiMapper industryShanghaiMapper;

    @Autowired
    private IndustryCompareMapper industryCompareMapper;

    @Autowired
    private PlatRankDataMapper platRankDataMapper;

    @Autowired
    private AreaIndexMapper areaIndexMapper;

    @Autowired
    private IndustryProblemMapper industryProblemMapper;

    @Autowired
    private TaskFailInfoMapper taskFailInfoMapper;

    private Logger logger = LoggerFactory.getLogger(PToPMonitorServiceImpl.class);

    private volatile boolean isShutdown = false;//任务停止标志

    @Override
    public Integer getOfflineFinanceNum(String companyName) throws Exception {
        if (companyName.equals("上海陆家嘴国际金融资产交易市场股份有限公司")) {
            return 0;
        }
        //Map<String, List> relationMap = relatedCompanyService.queryRelation(companyName, dataVersion, 1);
        RelationDiagramVO relationDiagramVO = offlinefinanceservice.queryRealRealation(companyName,
                1);
        List<RelationDiagramVO.PointVO> pointList = relationDiagramVO.getPointList();
        if (org.apache.commons.collections.CollectionUtils.isEmpty(pointList)) {
            return 0;
        }

        int offlineFinance = 0;
        for (RelationDiagramVO.PointVO pointVO : pointList) {
            if (pointVO.getIsPerson().equals("1")) {
                continue;
            }
            CompanyDO relatedCompany = companyService.getCompanyByName(pointVO.getCname());
            if (null == relatedCompany || null == relatedCompany.getCompanyType()) {
                continue;
            }
            if (relatedCompany.getCompanyType() == CompanyDO.TYPE_XXLC_4) {
                offlineFinance++;
            }
        }
        if (offlineFinance <= 0) {
            return 0;
        }
        return offlineFinance;
    }

    @Override
    public List<IndustryCompareDTO> getCompareData() throws Exception {

        String url = this.finSerUrl + "?dataType=industry_compare";
        HttpTemplate httpTemplate = new HttpTemplate();
        return httpTemplate.get(url, new HttpCallback<List<IndustryCompareDTO>>() {
            @Override
            public boolean valid() {
                return true;
            }

            @Override
            public List<IndustryCompareDTO> parse(String result) {
                return JSON.parseArray(result, IndustryCompareDTO.class);
            }
        });
    }

    @Override
    public List<AreaIndexDTO> getAreaIndex() throws Exception {

        String url = this.finSerUrl + "?dataType=area_index";
        HttpTemplate httpTemplate = new HttpTemplate();
        return httpTemplate.get(url, new HttpCallback<List<AreaIndexDTO>>() {
            @Override
            public boolean valid() {
                return true;
            }

            @Override
            public List<AreaIndexDTO> parse(String result) {
                return JSON.parseArray(result, AreaIndexDTO.class);
            }
        });

    }

    @Override
    public List<PlatRankDataDTO> getPlatRankData() throws Exception {
        String url = this.finSerUrl + "?dataType=plat_rank_data";
        HttpTemplate httpTemplate = new HttpTemplate();
        return httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
            @Override
            public boolean valid() {
                return true;
            }

            @Override
            public List<PlatRankDataDTO> parse(String result) {
                //System.out.println(result);
                return JSON.parseArray(result, PlatRankDataDTO.class);
            }
        });

    }

    @Override
    public Map getPlatRankMapData() throws Exception {

        List<PlatRankDataDTO> list = new ArrayList<>();
        String url = this.finSerUrl + "?dataType=plat_rank_data";
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            list = httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<PlatRankDataDTO> parse(String result) {
                    return JSON.parseArray(result, PlatRankDataDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<Integer, Integer> map = new HashMap();
        if (!CollectionUtils.isEmpty(list)) {
            for (PlatRankDataDTO platRankDataDTO : list) {
                String plat_name = platRankDataDTO.getPlat_name();
                String plat_status = platRankDataDTO.getPlat_status();
                PlatformNameInformationDO platformNameInformationDO = platformNameInformationMapper.hasOrNotCompany(plat_name);
                if (platformNameInformationDO != null) {
                    Integer riskLevel = 4;
                    if ("正常".equals(plat_status)) {
                        riskLevel = 4;
                    } else if ("一般关注".equals(plat_status)) {
                        riskLevel = 3;
                    } else if ("重点关注".equals(plat_status)) {
                        riskLevel = 2;
                    } else if ("问题".equals(plat_status)) {
                        riskLevel = 1;
                    } else {

                    }
                    map.put(platformNameInformationDO.getCompanyId(), riskLevel);
                }
            }
        }
        return map;
    }

    @Override
    public List<IndustryShanghaiDTO> getData() throws Exception {

        String url = this.finSerUrl + "?dataType=industry_shanghai";
        if (StringUtils.isEmpty(this.finSerUrl)) {
            url = "121.40.187.134:5002/financial_services?dataType=industry_shanghai";
        }
        HttpTemplate httpTemplate = new HttpTemplate();
        return httpTemplate.get(url, new HttpCallback<List<IndustryShanghaiDTO>>() {
            @Override
            public boolean valid() {
                return true;
            }

            @Override
            public List<IndustryShanghaiDTO> parse(String result) {

                Gson gson = new Gson();

                List<IndustryShanghaiDTO> list = gson.fromJson(result,
                        new TypeToken<List<IndustryShanghaiDTO>>() {
                        }.getType());
                IndustryShanghaiDTO ja = null;
                IndustryShanghaiDTO zb = null;
                return list;
            }
        });

    }

    @Override
    public List<IndustryProblemDTO> getProblemData() throws Exception {

        String url = this.finSerUrl + "?dataType=industry_problem";
        HttpTemplate httpTemplate = new HttpTemplate();
        return httpTemplate.get(url, new HttpCallback<List<IndustryProblemDTO>>() {
            @Override
            public boolean valid() {
                return true;
            }

            @Override
            public List<IndustryProblemDTO> parse(String result) {
                return JSON.parseArray(result, IndustryProblemDTO.class);
            }
        });

    }

    @Override
    public List<PlatCompanyDTO> getPlatList() throws Exception { //by cgj
        String url = this.finSerUrl + "?dataType=plat_list";
        if (StringUtils.isEmpty(this.finSerUrl)) {
            url = "http://121.40.187.134:5002/financial_services" + "?dataType=plat_list";
        }
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(url, new HttpCallback<List<PlatCompanyDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<PlatCompanyDTO> parse(String result) {
                    return JSON.parseArray(result, PlatCompanyDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public TaskResultDO pToPMonitorDataLandTask(Integer taskId) {
        logger.info("--- p2p monitor data job begin ---");
        isShutdown = false;
        TaskResultDO taskResultDO = new TaskResultDO();

        Integer planCount = 5;// 计划执行笔数。 可在任务结束时更新
        Integer failCount = 0;
        //type=industry_shanghai 数据落地
        try {
            updateIndustryShanghai();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            addWangdaiTaskInfo(taskId, industry_shanghai, e.getClass().getSimpleName());
            failCount++;//失败条数加一
            taskResultDO.setState(TaskState.ERROR);
            //计入任务表
        }
        //type=industry_compare 数据落地
        try {
            updateIndustryCompare();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            addWangdaiTaskInfo(taskId, industry_compare, e.getClass().getSimpleName());
            failCount++;
            taskResultDO.setState(TaskState.ERROR);
        }
        //type=industry_problem 数据落地
        try {
            updateIndustryProblem();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            addWangdaiTaskInfo(taskId, industry_problem, e.getClass().getSimpleName());
            failCount++;
            taskResultDO.setState(TaskState.ERROR);
        }
        //type = plat_rand_data 数据落地
        try {
            updatePlatRankData();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            addWangdaiTaskInfo(taskId, plat_rank_data, e.getClass().getSimpleName());
            failCount++;
            taskResultDO.setState(TaskState.ERROR);
        }
        //type=area_index 数据落地
        try {
            updateAreaIndex();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            addWangdaiTaskInfo(taskId, area_index, e.getClass().getSimpleName());
            failCount++;
            taskResultDO.setState(TaskState.ERROR);
        }
        taskResultDO.setPlanCount(planCount);
        if (isShutdown) {
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        }else{
            taskResultDO.setFailCount(failCount);
            taskResultDO.setSuccessCount(planCount - failCount);
        }
        logger.info("--- p2p monitor data job end ---");
        return taskResultDO;
    }

    @Override
    public TaskResultDO executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId) {
        logger.info("--- p2p monitor data handle begin ---");
        isShutdown = false;
        TaskResultDO taskResultDO = new TaskResultDO();
        List<TaskFailInfoDO> list = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
        Integer planCount = list.size();
        Integer failCount = 0;
        for (TaskFailInfoDO wangdaiTaskInfoDO : list) {
            if (isShutdown) {
                break;
            }
            switch (wangdaiTaskInfoDO.getFailName()) {
                case industry_shanghai:
                    try {
                        updateIndustryShanghai();
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        addWangdaiTaskInfo(taskId, industry_shanghai, e.getClass().getSimpleName());
                        failCount++;//失败条数加一
                        taskResultDO.setState(TaskState.ERROR);
                        //计入任务表
                    }
                    break;
                case industry_compare:
                    //type=industry_compare 数据落地
                    try {
                        updateIndustryCompare();
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        addWangdaiTaskInfo(taskId, industry_compare, e.getClass().getSimpleName());
                        failCount++;
                        taskResultDO.setState(TaskState.ERROR);
                    }
                    break;
                case industry_problem:
                    //type=industry_problem 数据落地
                    try {
                        updateIndustryProblem();
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        addWangdaiTaskInfo(taskId, industry_problem, e.getClass().getSimpleName());
                        failCount++;
                        taskResultDO.setState(TaskState.ERROR);
                    }
                    break;
                case plat_rank_data:
                    //type = plat_rand_data 数据落地
                    try {
                        updatePlatRankData();
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        addWangdaiTaskInfo(taskId, plat_rank_data, e.getClass().getSimpleName());
                        failCount++;
                        taskResultDO.setState(TaskState.ERROR);
                    }
                    break;
                case area_index:
                    try {
                        updateAreaIndex();
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        addWangdaiTaskInfo(taskId, area_index, e.getClass().getSimpleName());
                        failCount++;
                        taskResultDO.setState(TaskState.ERROR);
                    }
                    break;
                default:
                    continue;
            }
        }
        taskResultDO.setPlanCount(planCount);
        if (isShutdown) {
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        }else{
            taskResultDO.setFailCount(failCount);
            taskResultDO.setSuccessCount(planCount - failCount);
        }
        logger.info("--- p2p monitor data handle end ---");
        return taskResultDO;
    }

    @Override
    public void stopTask() {
        isShutdown = true;
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

    public List<PlatCompanyDTO> searchPlatListByCompanyName(String companyName) { //by cgj
        List platList = new ArrayList<PlatCompanyDTO>();
        if (StringUtils.isBlank(companyName)) {
            return platList;
        }
        try {
            List<PlatCompanyDTO> lpc = this.getPlatList();
            for (PlatCompanyDTO pd : lpc) {
                String tarCompName = pd.getCompany_name();
                if (StringUtils.isNotBlank(tarCompName) && companyName.equals(tarCompName)) {
                    platList.add(pd);
                }
            }
        } catch (Exception e) {
        }
        return platList;
    }


    protected void updateIndustryShanghai() throws Exception {
        if (isShutdown) {
            return;
        }
        logger.info("start update industry_shanghai date task");
        List<IndustryShanghaiDTO> dtoList = getData();
        for (IndustryShanghaiDTO dto : dtoList) {
            if (isShutdown) {
                break;
            }
            IndustryShanghaiDO industryShanghaiDO = new IndustryShanghaiDO();
            industryShanghaiDO.setNewPlatNum(dto.getNew_plat_num());
            industryShanghaiDO.setInterestRate(dto.getInterest_rate());
            industryShanghaiDO.setTotalPlatNum(dto.getTotal_plat_num());
            industryShanghaiDO.setBorrowedNum(dto.getBorrowed_num());
            industryShanghaiDO.setInvestNum(dto.getInvest_num());
            industryShanghaiDO.setAmount(dto.getAmount());
            industryShanghaiDO.setAreaNum(String.valueOf(dto.getArea_num()).replace("=", ":"));
            industryShanghaiDO.setDate(dto.getDate());
            industryShanghaiDO.setCreateBy("system");
            industryShanghaiDO.setCreateDate(new Date());
//            industryShanghaiMapper.deleteByDate(dto.getDate());
            try {
                industryShanghaiMapper.save(industryShanghaiDO);
            } catch (Exception e) {
                throw new SQLException();
            }
        }
        logger.info("end update industry_shanghai date task");
    }

    protected void updateIndustryCompare() throws Exception {
        if (isShutdown) {
            return;
        }
        logger.info("start update industry_compare date task");
        List<IndustryCompareDTO> dtoList = getCompareData();
        for (IndustryCompareDTO dto : dtoList) {
            if (isShutdown) {
                break;
            }
            IndustryCompareDO industryCompareDO = new IndustryCompareDO();
            industryCompareDO.setDate(dto.getDate());
            industryCompareDO.setArea(dto.getArea());
            industryCompareDO.setAmount(dto.getAmount());
            industryCompareDO.setBalanceLoans(dto.getBalance_loans());
            industryCompareDO.setCreateBy("system");
            industryCompareDO.setCreateDate(new Date());
//            industryCompareMapper.deleteByDateArea(dto.getDate(), dto.getArea());
            try {
                industryCompareMapper.save(industryCompareDO);
            } catch (Exception e) {
                throw new SQLException();
            }
        }
        logger.info("end update industry_compare date task");
    }

    protected void updatePlatRankData() throws Exception {
        if (isShutdown) {
            return;
        }
        logger.info("start update plat_rank_data date task");
        List<PlatRankDataDTO> dtoList = getPlatRankData();
        for (PlatRankDataDTO dto : dtoList) {
            if (isShutdown) {
                break;
            }
            PlatRankDataDO platRankDataDO = new PlatRankDataDO();
            platRankDataDO.setAmount(dto.getAmount());
            platRankDataDO.setAreaId(dto.getArea_id());
            platRankDataDO.setIncomeRate(dto.getIncome_rate());
            platRankDataDO.setLoanPeriod(dto.getLoan_period());
            platRankDataDO.setPlatName(dto.getPlat_name());
            WangdaiModify wangdaiModify = platRankDataMapper.getWangdaiModify(dto.getPlat_name());
            if (wangdaiModify != null) {
                platRankDataDO.setPlatStatus(wangdaiModify.getAfterLevel());
            } else {
                platRankDataDO.setPlatStatus(dto.getPlat_status());

            }
            platRankDataDO.setRank(dto.getRank());
            platRankDataDO.setRegisteredAddress(dto.getRegistered_address());
            platRankDataDO.setStayStillOfTotal(dto.getStay_still_of_total());
            platRankDataDO.setCreateBy("system");
            platRankDataDO.setCreateDate(new Date());
//            platRankDataMapper.deleteByPlatName(dto.getPlat_name());
            try {
                platRankDataMapper.save(platRankDataDO);
            } catch (Exception e) {
                throw new SQLException();
            }
        }
        logger.info("end update plat_rank_data date task");
    }

    protected void updateAreaIndex() throws Exception {
        if (isShutdown) {
            return;
        }
        logger.info("start update area_index date task");
        List<AreaIndexDTO> dtoList = getAreaIndex();
        for (AreaIndexDTO dto : dtoList) {
            if (isShutdown) {
                break;
            }
            AreaIndexDO areaIndexDO = new AreaIndexDO();
            areaIndexDO.setArea(dto.getArea());
            areaIndexDO.setRank(dto.getRank());
            areaIndexDO.setEcosystem(dto.getEcosystem());
            areaIndexDO.setScale(dto.getScale());
            areaIndexDO.setPopularity(dto.getPopularity());
            areaIndexDO.setSafety(dto.getSafety());
            areaIndexDO.setRecognition(dto.getRecognition());
            areaIndexDO.setCompetitiveness(dto.getCompetitiveness());
            areaIndexDO.setCreateBy("system");
            areaIndexDO.setCreateDate(new Date());
//            areaIndexMapper.deleteByArea(dto.getArea());
            try {
                areaIndexMapper.save(areaIndexDO);
            } catch (Exception e) {
                throw new SQLException();
            }
        }
        logger.info("end update area_index date task");
    }

    protected void updateIndustryProblem() throws Exception {
        if (isShutdown) {
            return;
        }
        logger.info("start update industry_problem date task");
        List<IndustryProblemDTO> dtoList = getProblemData();
        for (IndustryProblemDTO dto : dtoList) {
            if(isShutdown){
                break;
            }
            IndustryProblemDO industryProblemDO = new IndustryProblemDO();
            industryProblemDO.setDate(dto.getDate());
            industryProblemDO.setArea(dto.getArea());
            industryProblemDO.setProblemPlatNumber(dto.getProblem_plat_number());
            industryProblemDO.setCreateBy("system");
            industryProblemDO.setCreateDate(new Date());

            try {
                industryProblemMapper.save(industryProblemDO);
            } catch (Exception e) {
                throw new SQLException();
            }
        }
        logger.info("end update industry_problem date task");
    }


    @Override
    public String getTaskKey() {
        return "p2pMonitorJob";
    }

    @Override
    public String getTaskGroup() {
        return "wd_work";
    }

    @Override
    public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
        TaskResultDO taskResultDO = pToPMonitorDataLandTask(taskId);
        return taskResultDO;
    }

    @Override
    public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {
        TaskResultDO taskResultDO = executeFailTaskByTaskId(runMode, oldTaskId, newTaskId);
        return taskResultDO;
    }

    @Override
    public void stopExecute(Integer taskId) {
        stopTask();
    }

    @Override
    public void resetTask() {
        this.isShutdown=false;
    }
}
