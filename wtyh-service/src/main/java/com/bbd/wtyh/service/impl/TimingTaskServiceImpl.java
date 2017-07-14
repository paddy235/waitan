package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.service.TimingTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
@Service
public class TimingTaskServiceImpl  extends BaseServiceImpl implements TimingTaskService {
    @Autowired
    private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;

    @Override
    public List<TaskInfoDO> getTaskInfo() {
        List<TaskInfoDO> taskList = this.selectAll(TaskInfoDO.class, "is_show=1");
        return taskList;
    }

    @Override
    public List<TaskInfoDO> getLatestTaskInfo() {
        List<TaskInfoDO> taskList = this.selectAll(TaskInfoDO.class, "is_show=1");
        CronSequenceGenerator cronSequenceGenerator ;
        for(TaskInfoDO taskInfoDO:taskList){
            cronSequenceGenerator = new CronSequenceGenerator(taskInfoDO.getCron());
            taskInfoDO.setNextStartDate(cronSequenceGenerator.next(new Date()));//lastMinute 我这里是上一分钟的date类型对象

        }
        return taskList;
    }

    @Override
    public List<TaskSuccessFailInfoDO> getHistoryTaskInfo(String task_name,String task_group) {
        List<TaskSuccessFailInfoDO> list = taskSuccessFailInfoMapper.getTaskInfoByNameAndGroup(task_name,task_group);
        return list;
    }
}
