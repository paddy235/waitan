package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.mapper.UpdateWhiteCompanyRiskGradeMapper;
import com.bbd.wtyh.service.CoAddOrCloseService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.service.UpdateWhiteCompanyRiskGradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:WLL
 * @Date:Create on 9:562017/11/21
 */
@Service
public class UpdateWhiteCompanyRiskGradeServiceImpl implements UpdateWhiteCompanyRiskGradeService,TaskService {
    private static final Logger logger = LoggerFactory.getLogger(UpdateWhiteCompanyRiskGradeServiceImpl.class);

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;
    @Autowired
    private UpdateWhiteCompanyRiskGradeMapper updateWhiteGradeMapper;
    @Autowired
    private CoAddOrCloseService coChgMonitorService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private TaskFailInfoMapper taskFailInfoMapper;

    private static final String WHITE_LIST  = "线下白名单风险等级";

    private Integer taskId = null;

    private volatile boolean isShutdown = false;//任务停止标志
    //白名单企业名称
    List<String> companyNames = new ArrayList<>();
    //5万家白名单企业的公信中心数据包含：限制出境、限制高消费和网上追讨的公司名单
    List<String> creditNames = new ArrayList<>();
    //前1~200家企业名单
    List<String> names1 = new ArrayList<>();
    //201~1000家企业名单
    List<String> names2 = new ArrayList<>();

    //更新之前的白名单实体
    List<CompanyDO> oldCompanys = new ArrayList<>();
    //更新之后的白名单实体
    List<CompanyDO> newCompanys = new ArrayList<>();
    //5万家白名单企业风险等级更新

    @Override
    public void stopTask() {
        isShutdown = true;
    }

    @Override
    public  void startUpdate(){
        logger.info("白名单企业风险等级更新开始");

        companyNames = updateWhiteGradeMapper.WhiteCompanyList();
        logger.info("白名单企业共有："+companyNames.size());

        creditNames = updateWhiteGradeMapper.query_raw_info();
        logger.info("企业的公信中心数据中包含：限制出境、限制高消费和网上追讨 的企业数："+creditNames.size());

        names1 = updateWhiteGradeMapper.find(0,200);
        logger.info(names1.size()+"");

        names2 = updateWhiteGradeMapper.find(200,800);
        logger.info(names2.size()+"");

        if(companyNames==null ||companyNames.isEmpty()){
            logger.info("白名单为空！");
            return ;
        }

        CompanyDO cd = new CompanyDO();
        //获取更新之前的线下理财白名单实体
//        for (String name :companyNames){
//            //cd = updateWhiteGradeMapper.findCompany(name);
//            cd = companyService.getCompanyByName(name);
//            oldCompanys.add(cd);
//        }

        //5万家企业进行等级划分。前1~200家为重点关注企业，201~1000家为一般关注企业，其他为正常企业
        for(String name :companyNames) {
            //前1~200家为重点关注企业
            if(names1!=null && !names1.isEmpty()&&names1.contains(name)){
                //更新company重点关注企业
                this.updateWhiteGradeMapper.updateCompanyRisk_level(name,2);
                continue;
            }
            //201~1000家为一般关注企业
            if(names2!=null && !names2.isEmpty()&&names2.contains(name)){
                //更新company一般关注企业
                this.updateWhiteGradeMapper.updateCompanyRisk_level(name,3);
                continue;
            }
            //其他为正常企业
            this.updateWhiteGradeMapper.updateCompanyRisk_level(name,4);
            continue;
        }

        //公信中心数据中包含：限制出境、限制高消费和网上追讨三类数据任何一类，则企业风险等级直接赋值为“重点关注”
        if(creditNames!=null && !creditNames.isEmpty()){
            for(String c_name:creditNames){
                this.updateWhiteGradeMapper.updateCompanyRisk_level(c_name,2);
            }
        }

        CompanyDO cd2 = new CompanyDO();
        //获取更新之后的线下理财白名单实体
        for (String name :companyNames) {
            //cd2 = updateWhiteGradeMapper.findCompany(name);
            cd2 = companyService.getCompanyByName(name);
            newCompanys.add(cd2);
        }

        //判断企业风险是否变化了
        for(int i=0;i<oldCompanys.size();i++){
            Integer oldRiskLevel = oldCompanys.get(i).getRiskLevel();
            Integer newRiskLevel = newCompanys.get(i).getRiskLevel();
            CompanyDO cd3 = newCompanys.get(i);
            if(!newRiskLevel.equals(oldRiskLevel)){
                saveRiskCompanyChange(cd3,oldRiskLevel,newRiskLevel);
            }
            continue;
        }

        //把company表中线下企业不是白名单的企业风险等级设置成null
        this.updateWhiteGradeMapper.updateCompanyIsNotWhite();
        logger.info("company表中线下理财非白名单企业风险等级设置成null结束");

        logger.info("白名单企业风险等级更新结束");
    }

    @Override
    public TaskResultDO updateOfflineWhiteAutomaticOperate(Integer taskId) {
        return this.updateOfflineWhite(taskId,null);
    }

    @Override
    public TaskResultDO updateOfflineWhiteManualOperate(Integer oldTaskId, Integer newTaskId) {
        return this.updateOfflineWhite(oldTaskId,newTaskId);
    }

    //更新5万家线下白名单的风险等级
    private TaskResultDO updateOfflineWhite(Integer oldTaskId,Integer newTaskId) {
        logger.info("----- offlineFinacial white job begin -----");
        isShutdown=false;
        TaskResultDO taskResultDO = new TaskResultDO();
        if(null==newTaskId){
            this.taskId=oldTaskId;
        }else{
            this.taskId=newTaskId;
        }
        Integer dataError = 0;
        Integer dataTotal = 0;
        //获取白名单企业名单
        try {
            companyNames = updateWhiteGradeMapper.WhiteCompanyList();
            logger.info("-白名单企业--"+companyNames.size());
            dataTotal = companyNames.size();
        }catch (Exception e) {
            logger.error(e.getMessage(), e);

            TaskFailInfoDO fail = new TaskFailInfoDO();
            fail.setFailReason("查询白名单企业失败");
            fail.setFailName("查询白名单企业");
            fail.setTaskId(taskId);
            taskFailInfoMapper.addTaskFailInfo(fail);

            taskResultDO.setPlanCount(1);
            taskResultDO.setFailCount(1);
            taskResultDO.setSuccessCount(0);
            taskResultDO.setState(TaskState.ERROR);
            return taskResultDO;
        }
        //获取白名单企业公信中心数据名单
        try {
            creditNames = updateWhiteGradeMapper.query_raw_info();
            logger.info("-企业公信中心数据名单--"+creditNames.size());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);

            TaskFailInfoDO fail = new TaskFailInfoDO();
            fail.setFailReason("查询公信中心数据失败");
            fail.setFailName("查询公信中心数据");
            fail.setTaskId(taskId);
            taskFailInfoMapper.addTaskFailInfo(fail);

            taskResultDO.setPlanCount(1);
            taskResultDO.setFailCount(1);
            taskResultDO.setSuccessCount(0);
            taskResultDO.setState(TaskState.ERROR);
            return taskResultDO;
        }
        //获取前200白名单
        try {
            names1 = updateWhiteGradeMapper.find(0,200);
            logger.info("-前200白名单--"+names1.size());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);

            TaskFailInfoDO fail = new TaskFailInfoDO();
            fail.setFailReason("查询前200白名单失败");
            fail.setFailName("查询前200白名单");
            fail.setTaskId(taskId);
            taskFailInfoMapper.addTaskFailInfo(fail);

            taskResultDO.setPlanCount(1);
            taskResultDO.setFailCount(1);
            taskResultDO.setSuccessCount(0);
            taskResultDO.setState(TaskState.ERROR);
            return taskResultDO;
        }
        //获取前200-1000白名单
        try {
            names2 = updateWhiteGradeMapper.find(200,800);
            logger.info("-前200-1000白名单--"+names2.size());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);

            TaskFailInfoDO fail = new TaskFailInfoDO();
            fail.setFailReason("查询前200-1000白名单失败");
            fail.setFailName("查询前200-1000白名单");
            fail.setTaskId(taskId);
            taskFailInfoMapper.addTaskFailInfo(fail);

            taskResultDO.setPlanCount(1);
            taskResultDO.setFailCount(1);
            taskResultDO.setSuccessCount(0);
            taskResultDO.setState(TaskState.ERROR);
            return taskResultDO;
        }
        //判断白名单是否为空
        if(companyNames==null ||companyNames.isEmpty()){
            logger.info("白名单为空！");
            taskResultDO.setPlanCount(1);
            taskResultDO.setFailCount(1);
            taskResultDO.setSuccessCount(0);
            taskResultDO.setState(TaskState.ERROR);
            return taskResultDO;
        }


        CompanyDO cd = new CompanyDO();
        //获取更新之前的线下理财白名单实体
        for (String name :companyNames){
            //cd = updateWhiteGradeMapper.findCompany(name);
            try{
                cd = companyService.getCompanyByName(name);
                oldCompanys.add(cd);
            }catch (Exception e) {
                logger.info("select  error");
            }
        }

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        //5万家企业进行等级划分。前1~200家为重点关注企业，201~1000家为一般关注企业，其他为正常企业
        for(String name :companyNames) {
            //前1~200家为重点关注企业
            if(names1!=null && !names1.isEmpty()&&names1.contains(name)){
                //更新company重点关注企业
                try{
                    this.updateWhiteGradeMapper.updateCompanyRisk_level(name,2);
                    count1++;
                    logger.info(count1+"-更新白名单企业--"+name+"风险等级为"+2);
                    continue;
                }catch (Exception e) {
                    logger.info("update error");
                }
            }
            //201~1000家为一般关注企业
            if(names2!=null && !names2.isEmpty()&&names2.contains(name)){
                //更新company一般关注企业
                try{
                    this.updateWhiteGradeMapper.updateCompanyRisk_level(name,3);
                    count2++;
                    logger.info(count2+"-更新白名单企业--"+name+"风险等级为"+3);
                    continue;
                }catch (Exception e) {
                    logger.info("update error");
                }
            }

            //其他为正常企业
            try{
                this.updateWhiteGradeMapper.updateCompanyRisk_level(name,4);
                count3++;
                logger.info(count3+"-更新白名单企业--"+name+"风险等级为"+4);
                continue;
            }catch (Exception e) {
                logger.info("update error");
            }
        }

        //公信中心数据中包含：限制出境、限制高消费和网上追讨三类数据任何一类，则企业风险等级直接赋值为“重点关注”
        if(creditNames!=null && !creditNames.isEmpty()){
            for(String c_name:creditNames){
                try{
                    this.updateWhiteGradeMapper.updateCompanyRisk_level(c_name,2);
                    logger.info("-更新公信中心数据中白名单企业--"+c_name+"风险等级为"+2);
                }catch (Exception e) {
                    logger.info("update error");
                }
            }
        }

        CompanyDO cd2 = new CompanyDO();
        //获取更新之后的线下理财白名单实体
        for (String name :companyNames) {
            //cd2 = updateWhiteGradeMapper.findCompany(name);
            try{
                cd2 = companyService.getCompanyByName(name);
                newCompanys.add(cd2);
            }catch (Exception e) {
                logger.info("select  error");
            }
        }

        //判断企业风险是否变化了
        for(int i=0;i<oldCompanys.size();i++){
            Integer oldRiskLevel = oldCompanys.get(i).getRiskLevel();
            Integer newRiskLevel = newCompanys.get(i).getRiskLevel();
            CompanyDO cd3 = newCompanys.get(i);
            if(!newRiskLevel.equals(oldRiskLevel)){
                saveRiskCompanyChange(cd3,oldRiskLevel,newRiskLevel);
            }
            continue;
        }

        //把company表中线下企业不是白名单的企业风险等级设置成null
        try{
            this.updateWhiteGradeMapper.updateCompanyIsNotWhite();
            logger.info("-company表中线下企业不是白名单的企业风险等级--"+"风险等级为null");
//            isShutdown = true;
        }catch (Exception e) {
            logger.info("update error");
        }

        if (isShutdown) {
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        }else{
            taskResultDO.setPlanCount(dataTotal);
            taskResultDO.setFailCount(dataError);
            taskResultDO.setSuccessCount(dataTotal-dataError);
        }
        logger.info("count1="+count1);
        logger.info("count2="+count2);
        logger.info("count3="+count3);
        logger.info("--- offlineFinacial white job end ---");

        return taskResultDO;
    }

    // 添加风险变化公司(表：risk_company_change)
    public void saveRiskCompanyChange(CompanyDO companyDO,Integer oldRiskLevel,Integer riskLevel){
        Integer companyType=(companyDO!=null && companyDO.getCompanyType() != null)?companyDO.getCompanyType().intValue():-1;
        // 添加风险变化公司
        BeanCopier beanCopier = BeanCopier.create(CompanyDO.class, RiskChgCoDo.class, false);
        RiskChgCoDo rcco = new RiskChgCoDo();
        beanCopier.copy(companyDO, rcco, null);

        rcco.setCompanyName(companyDO.getName());
        rcco.setCompanyType((companyType==-1)?null:companyType);

        rcco.setOldRiskLevel(oldRiskLevel);
        rcco.setRiskLevel(riskLevel);
        rcco.setSource(RiskChgCoSource.MODEL_SCORE.type());

        rcco.setCreateBy("updateOfflineFinacialWhite");

        try {
            this.coChgMonitorService.saveRiskChgCo(rcco);
        } catch (Exception e) {
            logger.error("保存风险变化公司失败！companyId：" + companyDO.getCompanyId(), e);
        }
    }


    @Override
    public String getTaskKey() {
        return "offlineFinanceRiskLevelCalcJob";
    }

    @Override
    public String getTaskGroup() {
        return "job_work";
    }

    @Override
    public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
        TaskResultDO taskResultDO=updateOfflineWhiteAutomaticOperate(taskId);
        return taskResultDO;
    }

    @Override
    public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {
        TaskResultDO taskResultDO=updateOfflineWhiteManualOperate(oldTaskId, newTaskId);
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
