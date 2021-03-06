package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.dto.TaskInfoDTO;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.mapper.TimingTaskMapper;
import com.bbd.wtyh.service.TimingTaskService;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.lang3.StringUtils;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
@Service
public class TimingTaskServiceImpl  extends BaseServiceImpl implements TimingTaskService {
    @Autowired
    private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;
    @Autowired
    private TimingTaskMapper timingTaskMapper;


    @Override
    public List<TaskInfoDTO> getTaskInfo() {
        List<TaskInfoDTO> list =new ArrayList<>();
        List<TaskInfoDO> taskList = this.selectAll(TaskInfoDO.class, "is_show=1");

        BeanCopier beanCopier = BeanCopier.create(TaskInfoDO.class, TaskInfoDTO.class, false);
        for(TaskInfoDO taskInfoDO:taskList){
            TaskInfoDTO taskInfoDTO= new TaskInfoDTO();
            beanCopier.copy(taskInfoDO,taskInfoDTO,null);
            list.add(taskInfoDTO);
        }

        return list;
    }

    @Override
    public List<TaskInfoDTO> getLatestTaskInfo(String taskState, String taskDataSource ) {
        int taskStateInt=taskState==null?0:Integer.parseInt(taskState);
        int taskDataSourceInt=taskDataSource==null?0:Integer.parseInt(taskDataSource);
        StringBuffer query=new StringBuffer();
        query.append(" is_show=1 ");
        if(taskDataSourceInt!=0){
            query.append(" AND data_source=");
            query.append(taskDataSourceInt);
        }
        List<TaskInfoDTO> list =new ArrayList<>();
        List<TaskInfoDO> taskList = this.selectAll(TaskInfoDO.class,query.toString());
        CronTriggerImpl trigger = new CronTriggerImpl();
        BeanCopier beanCopier = BeanCopier.create(TaskInfoDO.class, TaskInfoDTO.class, false);

        for(TaskInfoDO taskInfoDO:taskList){
            try {
                //lastMinute spring???5????????????Quartz???6?????????
                trigger.setCronExpression(taskInfoDO.getCron());
                taskInfoDO.setNextStartDate(trigger.getFireTimeAfter(new Date()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            TaskInfoDTO taskInfoDTO= new TaskInfoDTO();
            beanCopier.copy(taskInfoDO,taskInfoDTO,null);
            taskInfoDTO.setReExecute(0);
            taskInfoDTO.setState(TaskState.NONSTARTER.state());
            taskInfoDTO.setStartDate(null);
            taskInfoDTO.setEndDate(null);
            TaskSuccessFailInfoDO taskDO=taskSuccessFailInfoMapper.getTaskRecentInfo(taskInfoDO.getTaskKey(),taskInfoDO.getTaskGroup());
            if(taskDO!=null) {
                taskInfoDTO.setId(taskDO.getId());
                taskInfoDTO.setReExecute(taskDO.getReExecute());
                taskInfoDTO.setState(taskDO.getState());
                taskInfoDTO.setPlanCount(taskDO.getPlanCount());
                taskInfoDTO.setSuccessCount(taskDO.getSuccessCount());
                taskInfoDTO.setFailCount(taskDO.getFailCount());
                taskInfoDTO.setStartDate(taskDO.getBeginDate());
                taskInfoDTO.setEndDate(taskDO.getEndDate());
                int state=taskDO.getState()==null?-1:taskDO.getState().intValue();
                if(TaskState.EXECUTING.state()==state){
                    taskInfoDTO.setCan_stop(1);//???????????????
                }
            }
            if(taskStateInt==0){
                list.add(taskInfoDTO);
            }else if(taskStateInt==(taskInfoDTO.getState()==null?-1:taskInfoDTO.getState())){
                list.add(taskInfoDTO);
            }

        }
        return list;
    }

    @Override
    public List<TaskInfoDTO> getHistoryTaskInfo(String task_name,String task_group,String taskState, String taskDataSource , String taskUpdateDate) {
        if(StringUtils.isEmpty(taskState) || "0".equals(taskState)){
            taskState=null;
        }
        if(StringUtils.isEmpty(taskDataSource)  || "0".equals(taskDataSource)){
            taskDataSource=null;
        }
        if(StringUtils.isEmpty(taskUpdateDate)){
            taskUpdateDate=null;
        }
        List<TaskInfoDTO> list = timingTaskMapper.getHistoryTaskInfoByNameAndGroup(task_name,task_group,taskState,taskDataSource,taskUpdateDate);


        return list;
    }
}
