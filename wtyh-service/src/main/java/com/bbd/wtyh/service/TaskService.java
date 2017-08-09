package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskResultDO;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public interface TaskService {

    String getTaskKey();

    String getTaskGroup();

    public TaskResultDO autoExecute(Integer taskId, Integer runMode);

    public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId,Integer runMode);

    public void stopExecute(Integer taskId);
}
