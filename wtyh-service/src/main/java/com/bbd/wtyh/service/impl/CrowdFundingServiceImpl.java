package com.bbd.wtyh.service.impl;

import java.sql.SQLException;
import java.util.*;

import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.dao.CrowdFundingDao;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.EasyExport.CrowdfundData;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoMudifyUtil;
import com.bbd.wtyh.util.AddCompanyUtil;
import com.bbd.wtyh.util.CompanyUtils;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.service.CrowdFundingService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import static y.layout.orthogonal.e.bb.i;

/**
 * @author Ian.Su
 * @since 2016年8月11日 下午4:13:50
 */
@Service
public class CrowdFundingServiceImpl implements CrowdFundingService,TaskService {

    private Logger logger = LoggerFactory.getLogger(CrowdFundingServiceImpl.class);

    @Autowired
    private CrowdFundingBusinessStatisticsMapper cfbsMapper;

    @Autowired
    private CrowdFundingStatisticsMapper cfsMapper;

    @Autowired
    private CrowdFundingCompanyMapper cfcMapper;

    @Autowired
    private CrowdFundingDao crowdFundingDao;

    @Autowired
    private CrowdFundingCompanyMapper crowdFundingCompanyMapper;

    @Autowired
    private CrowdFundingCommonMapper crowdFundingCommonMapper;

    @Autowired
    private TaskFailInfoMapper taskFailInfoMapper;

    @Autowired
    private  CompanyService companyService;

    @Autowired
    private CompanyInfoMudifyUtil companyInfoMudifyUtil;

    private volatile boolean isShutdown = false;//任务停止标志

    @Override
    public List<NvDO> lastMonthData() {
        return cfbsMapper.lastMonthData();
    }

    @Override
    public Map<String, String> lastMonthType(String dataType) {
        return crowdFundingDao.lastMonthType(dataType);
    }


    @Override
    public List<CrowdFundingCompanyDO> allCompanys() {
        List<CrowdFundingCompanyDO> list = crowdFundingDao.allCompanys();
        if (!CollectionUtils.isEmpty(list)) {
            for (CrowdFundingCompanyDO crowdFundingCompanyDO : list) {
                String websiteUrl = crowdFundingCompanyDO.getWebsiteUrl();
                if (StringUtils.isEmpty(websiteUrl)) {
                    continue;
                }
                if (!websiteUrl.contains("http://")) {
                    crowdFundingCompanyDO.setWebsiteUrl("http://" + websiteUrl);
                }
            }
        }
        return list;
    }

    @Override
    public List<String> queryCompany(String keyword) {
        return cfcMapper.queryCompany(keyword);
    }

    @Override
    public TaskResultDO crowdFundingDataLandTask(Integer taskId) {
        logger.info("--- crowd data job begin ---");
        isShutdown = false;
        TaskResultDO taskResultDO = new TaskResultDO();
        Integer planCount = 5;
        Integer failCount = 0;
        try {
            updateCrowdFundingCompany();
        } catch (Exception e) {
            e.printStackTrace();
            addFailTaskInfo(taskId, "平台基本情况(dataType=1)", e.getClass().getSimpleName());
            failCount++;
            taskResultDO.setState(TaskState.ERROR);
        }

        for (int i = 2; i <= 5; i++) {
            if(isShutdown){
                break;
            }
            try {
                updateCrowdFundingCommon(String.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
                String apiName = "";
                switch (i){
                    case 2:
                        apiName = "业务类型分布(dataType=2)";
                        break;
                    case 3:
                        apiName = "上月上海各类众筹平台新增项目数(dataType=3)";
                        break;
                    case 4:
                        apiName = "上月上海各类众筹平台新增项目的投资人次(dataType=4)";
                        break;
                    default:
                        apiName = "上月上海各类众筹平台新增项目数的成功筹资金额(dataType=5)";

                }
                addFailTaskInfo(taskId, apiName, e.getClass().getSimpleName());
                failCount++;
                taskResultDO.setState(TaskState.ERROR);
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
        logger.info("--- crowd data job end ---");
        return taskResultDO;
    }

    @Override
    public TaskResultDO executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId) {
        logger.info("--- crowd data handle begin ---");
        isShutdown = false;
        TaskResultDO taskResultDO = new TaskResultDO();
        List<TaskFailInfoDO> list = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
        Integer planCount = list.size();
        Integer failCount = 0;
        for (TaskFailInfoDO wangdaiTaskInfo : list) {
            if(isShutdown){
                break;
            }
            if (wangdaiTaskInfo.getFailName().equals("平台基本情况(dataType=1)")) {
                try {
                    updateCrowdFundingCompany();
                } catch (Exception e) {
                    e.printStackTrace();
                    addFailTaskInfo(taskId, "平台基本情况(dataType=1)", e.getClass().getSimpleName());
                    failCount++;
                    taskResultDO.setState(TaskState.ERROR);
                }
            } else {
                String type = wangdaiTaskInfo.getFailName().split("\\(")[1].replace(")","");
                try {
                    updateCrowdFundingCommon(type.split("=")[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                    String apiName = "";
                    switch (type){
                        case "dataType=2":
                            apiName = "业务类型分布(dataType=2)";
                            break;
                        case "dataType=3":
                            apiName = "上月上海各类众筹平台新增项目数(dataType=3)";
                            break;
                        case "dataType=4":
                            apiName = "上月上海各类众筹平台新增项目的投资人次(dataType=4)";
                            break;
                        default:
                            apiName = "上月上海各类众筹平台新增项目数的成功筹资金额(dataType=5)";

                    }
                    addFailTaskInfo(taskId, apiName, e.getClass().getSimpleName());
                    failCount++;
                    taskResultDO.setState(TaskState.ERROR);
                }
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
        logger.info("--- crowd data handle end ---");
        return taskResultDO;
    }

    @Override
    public void stopTask() {
        isShutdown = true;
    }

    @Override
    public Map<String, String> queryStatisticsData(String type) {
        return crowdFundingCommonMapper.queryStatisticsData(type);
    }

    @Override
    public List<CrowdFundingCompanyDO> queryBaseOfPlat() {
        return crowdFundingCompanyMapper.queryBaseOfPlat();
    }

    protected void addFailTaskInfo(Integer taskId, String api, String failReason) {
        TaskFailInfoDO taskFailInfoDO = new TaskFailInfoDO();
        taskFailInfoDO.setTaskId(taskId);
        taskFailInfoDO.setFailName(api);
        switch (failReason) {
            case "ConnectTimeoutException":
                taskFailInfoDO.setFailReason("众筹接口连接超时");
                break;
            case "JsonSyntaxException":
                taskFailInfoDO.setFailReason("众筹接口返回数据解析失败");
                break;
            case "SQLException":
                taskFailInfoDO.setFailReason("众筹入库失败");
                break;
            default:
                taskFailInfoDO.setFailReason("众筹接口调用失败");
        }
        taskFailInfoDO.setCreateBy("system");
        taskFailInfoDO.setCreateDate(new Date());
        taskFailInfoMapper.addTaskFailInfo(taskFailInfoDO);
    }

    private void updateCrowdFundingCommon(String type) {
        if(isShutdown){
            return;
        }
        CrowdFundingCommonDO crowdFundingCommonDO = new CrowdFundingCommonDO();
        Map map = crowdFundingDao.lastMonthType(type);
        crowdFundingCommonDO.setReward((String) map.get("奖励众筹"));
        crowdFundingCommonDO.setNonPulicEquityFinancing((String) map.get("非公开股权融资"));
        crowdFundingCommonDO.setPublicWelfare((String) map.get("公益众筹"));
        if (map.get("混合众筹") != null) {
            crowdFundingCommonDO.setBlend((String) map.get("混合众筹"));
        }
        crowdFundingCommonDO.setType(type);
        crowdFundingCommonDO.setCreateBy("system");
        crowdFundingCommonDO.setCreateDate(new Date());
//        crowdFundingCommonMapper.deleteByType(type);
        crowdFundingCommonMapper.save(crowdFundingCommonDO);
    }

    private void updateCrowdFundingCompany() throws Exception {
        if(isShutdown){
            return;
        }
        List<CompanyDO> newCompanys= new ArrayList<>();
        List<CrowdFundingCompanyDO> dtoList = crowdFundingDao.allCompanys();
        for (CrowdFundingCompanyDO dto : dtoList) {
            if(isShutdown){
                break;
            }
            dto.setCreateBy("system");
            dto.setCreateDate(new Date());
//            crowdFundingCompanyMapper.deleteByPlatName(dto.getPlatformName());
            try {
                crowdFundingCompanyMapper.saveForDataLand(dto);
                //拉下众筹数据的时候，将Company表 company_type为空或者为4的 company_type修改为6
                CompanyDO companyDO = companyService.getCompanyByName(CompanyUtils.dealCompanyName(dto.getCompanyName()));
                if(companyDO != null
                        && !StringUtils.isEmpty(companyDO.getName())
                        && CompanyInfo.TYPE_XXLC_4==(companyDO.getCompanyType()==null?CompanyInfo.TYPE_XXLC_4:companyDO.getCompanyType())
                        ){
                    ModifyData modifyData = new ModifyData();
                    modifyData.setName(CompanyUtils.dealCompanyName(companyDO.getName()));
                    modifyData.setLevel(null);//修改后无风险等级
                    modifyData.setIndustry(CompanyInfo.TYPE_ZC_6+"");//修改后固定为众筹
                    modify(modifyData);//
                }
                if(companyDO == null || null==companyDO.getCompanyId()){
                    if(org.apache.commons.lang.StringUtils.isNotEmpty(dto.getCompanyName())){
                        CompanyDO tempDo=new CompanyDO();
                        tempDo.setName(CompanyUtils.dealCompanyName(dto.getCompanyName()));
                        tempDo.setCompanyType(CompanyInfo.TYPE_ZC_6);
                        newCompanys.add(tempDo);
                    }
                }

            } catch (Exception e) {
                throw new SQLException();
            }
        }

        addNewCompanyForPlat(newCompanys);
    }

    public void modify(ModifyData modifyData){
        try {

            companyInfoMudifyUtil.modifyForTask(modifyData);

        }catch(Exception e){
            e.printStackTrace();
            logger.info(e.getMessage());
        }

    }


    @Override
    public List<CrowdfundData> getCrowdfund(ExportCondition exportCondition, PageBean pagination) {
        pagination.setTotalCount(crowdFundingCompanyMapper.countCrowdfund(exportCondition));
        return crowdFundingCompanyMapper.getCrowdfund(exportCondition, pagination);
    }

    @Override
    public String getTaskKey() {
        return "crowdFundingJob";
    }

    @Override
    public String getTaskGroup() {
        return "wd_work";
    }

    @Override
    public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
        TaskResultDO taskResultDO=crowdFundingDataLandTask(taskId);
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

    private void addNewCompanyForPlat(List<CompanyDO> newCompanys){
        try {
            if(!CollectionUtils.isEmpty(newCompanys)){
                AddCompanyUtil addCompanyUtil=new AddCompanyUtil();
                addCompanyUtil.processCp(newCompanys);
                addCompanyUtil.saveForNewSource("updateCorwd");
                addCompanyUtil.clearList();
            }
        }catch (Exception e){
            logger.error("Method addNewCompanyForPlat get Exception." , e.getMessage());
        }
    }
}
