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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.stereotype.Service;

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
    public List<TaskInfoDTO> getLatestTaskInfo() {
        List<TaskInfoDTO> list =new ArrayList<>();
        List<TaskInfoDO> taskList = this.selectAll(TaskInfoDO.class, "is_show=1");
        CronSequenceGenerator cronSequenceGenerator ;
        BeanCopier beanCopier = BeanCopier.create(TaskInfoDO.class, TaskInfoDTO.class, false);

        for(TaskInfoDO taskInfoDO:taskList){

            cronSequenceGenerator = new CronSequenceGenerator(taskInfoDO.getCron());
            taskInfoDO.setNextStartDate(cronSequenceGenerator.next(new Date()));//lastMinute 我这里是上一分钟的date类型对象
            TaskInfoDTO taskInfoDTO= new TaskInfoDTO();
            beanCopier.copy(taskInfoDO,taskInfoDTO,null);
            taskInfoDTO.setReExecute(0);
            taskInfoDTO.setState(TaskState.NONSTARTER.state());
            TaskSuccessFailInfoDO taskDO=taskSuccessFailInfoMapper.getTaskRecentInfo(taskInfoDO.getTaskKey(),taskInfoDO.getTaskGroup());
            if(taskDO!=null) {
                taskInfoDTO.setId(taskDO.getId());
                taskInfoDTO.setReExecute(taskDO.getReExecute());
                taskInfoDTO.setState(taskDO.getState());
            }

            list.add(taskInfoDTO);

        }
        return list;
    }

    @Override
    public List<TaskInfoDTO> getHistoryTaskInfo(String task_name,String task_group) {

        List<TaskInfoDTO> list = timingTaskMapper.getHistoryTaskInfoByNameAndGroup(task_name,task_group);


        return list;
    }
}
