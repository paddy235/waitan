package com.bbd.wtyh.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.dao.CrowdFundingDao;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.EasyExport.CrowdfundData;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
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
        isShutdown = false;
        Integer planCount = 5;
        Integer failCount = 0;
        try {
            updateCrowdFundingCompany();
        } catch (Exception e) {
            e.printStackTrace();
            addFailTaskInfo(taskId, "平台基本情况(dataType=1)", e.getClass().getSimpleName());
            failCount++;
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
            }
        }
        TaskResultDO taskResultDO = new TaskResultDO();
        taskResultDO.setPlanCount(planCount);
        if (isShutdown) {
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        }else{
            taskResultDO.setFailCount(failCount);
            taskResultDO.setSuccessCount(planCount - failCount);
        }
        return taskResultDO;
    }

    @Override
    public TaskResultDO executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId) {
        isShutdown = false;
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
                }
            }
        }
        TaskResultDO taskResultDO = new TaskResultDO();
        taskResultDO.setPlanCount(planCount);
        if (isShutdown) {
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        }else{
            taskResultDO.setFailCount(failCount);
            taskResultDO.setSuccessCount(planCount - failCount);
        }
        return taskResultDO;
    }

    @Override
    public void stopTask() {
        isShutdown = true;
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
            } catch (Exception e) {
                throw new SQLException();
            }
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
}
