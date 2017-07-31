package com.bbd.wtyh.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.dao.CrowdFundingDao;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.EasyExport.CrowdfundData;
import com.bbd.wtyh.domain.wangDaiAPI.CrowdFundingStatisticsDTO;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
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
public class CrowdFundingServiceImpl implements CrowdFundingService {


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
        Integer planCount = 5;
        Integer failCount = 0;
        try {
            updateCrowdFundingCompany();
        } catch (Exception e) {
            e.printStackTrace();
            TaskFailInfoDO taskFailInfoDO = new TaskFailInfoDO();
            taskFailInfoDO.setTaskId(taskId);
            taskFailInfoDO.setFailName("dataType=1");
            taskFailInfoDO.setCreateBy("sys");
            taskFailInfoDO.setCreateDate(new Date());
            taskFailInfoMapper.addTaskFailInfo(taskFailInfoDO);
            failCount++;
        }

        for (int i = 2; i <= 5; i++) {
            try {
                updateCrowdFundingCommon(String.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
                TaskFailInfoDO taskFailInfoDO = new TaskFailInfoDO();
                taskFailInfoDO.setTaskId(taskId);
                taskFailInfoDO.setFailName(String.format("dataType=%s", i));
                taskFailInfoDO.setCreateBy("sys");
                taskFailInfoDO.setCreateDate(new Date());
                taskFailInfoMapper.addTaskFailInfo(taskFailInfoDO);
                failCount++;
            }
        }
        TaskResultDO taskResultDO = new TaskResultDO();
        taskResultDO.setPlanCount(planCount);
        taskResultDO.setFailCount(failCount);
        taskResultDO.setSuccessCount(planCount - failCount);
        return taskResultDO;
    }

    @Override
    public TaskResultDO executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId) {
        List<TaskFailInfoDO> list = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
        Integer planCount = list.size();
        Integer failCount = 0;
        for (TaskFailInfoDO wangdaiTaskInfo : list) {
            if (wangdaiTaskInfo.getFailName().equals("dataType=1")) {
                try {
                    updateCrowdFundingCompany();
                } catch (Exception e) {
                    e.printStackTrace();
                    TaskFailInfoDO taskFailInfoDO = new TaskFailInfoDO();
                    taskFailInfoDO.setTaskId(taskId);
                    taskFailInfoDO.setFailName("dataType=1");
                    taskFailInfoDO.setCreateBy("sys");
                    taskFailInfoDO.setCreateDate(new Date());
                    taskFailInfoMapper.addTaskFailInfo(taskFailInfoDO);
                    failCount++;
                }
            } else {
                try {
                    updateCrowdFundingCommon(wangdaiTaskInfo.getFailName().split("=")[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                    TaskFailInfoDO taskFailInfoDO = new TaskFailInfoDO();
                    taskFailInfoDO.setTaskId(taskId);
                    taskFailInfoDO.setFailName(String.format("dataType=%s", i));
                    taskFailInfoDO.setCreateBy("sys");
                    taskFailInfoDO.setCreateDate(new Date());
                    taskFailInfoMapper.addTaskFailInfo(taskFailInfoDO);
                    failCount++;
                }
            }
        }
        TaskResultDO taskResultDO = new TaskResultDO();
        taskResultDO.setPlanCount(planCount);
        taskResultDO.setFailCount(failCount);
        taskResultDO.setSuccessCount(planCount - failCount);
        return taskResultDO;
    }

    private void updateCrowdFundingCommon(String type) {
        CrowdFundingCommonDO crowdFundingCommonDO = new CrowdFundingCommonDO();
        Map map = crowdFundingDao.lastMonthType(type);
        crowdFundingCommonDO.setReward((String) map.get("奖励众筹"));    //TODO:key为汉字不妥
        crowdFundingCommonDO.setNonPulicEquityFinancing((String) map.get("非公开股权融资"));
        crowdFundingCommonDO.setPublicWelfare((String) map.get("公益众筹"));
        if (map.get("混合众筹") != null) {
            crowdFundingCommonDO.setBlend((String) map.get("混合众筹"));
        }
        crowdFundingCommonDO.setType(type);
        crowdFundingCommonDO.setCreateBy("sys");
        crowdFundingCommonDO.setCreateDate(new Date());
//        crowdFundingCommonMapper.deleteByType(type);
        crowdFundingCommonMapper.save(crowdFundingCommonDO);
    }

    private void updateCrowdFundingCompany() throws Exception {
        List<CrowdFundingCompanyDO> dtoList = crowdFundingDao.allCompanys();
        if (dtoList == null) {
            throw new Exception("pull data error");
        }
        for (CrowdFundingCompanyDO dto : dtoList) {
            dto.setCreateBy("sys");
            dto.setCreateDate(new Date());
//            crowdFundingCompanyMapper.deleteByPlatName(dto.getPlatformName());
            crowdFundingCompanyMapper.saveForDataLand(dto);
        }
    }

    @Override
    public List<CrowdfundData> getCrowdfund(ExportCondition exportCondition) {
        return crowdFundingCompanyMapper.getCrowdfund(exportCondition);
    }
}
