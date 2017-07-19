package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.dto.TaskInfoDTO;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public interface TimingTaskService {
    List<TaskInfoDTO> getTaskInfo();

    List<TaskInfoDTO> getLatestTaskInfo(String taskState, String taskDataSource);

    List<TaskInfoDTO> getHistoryTaskInfo(String task_name,String task_group,String taskState, String taskDataSource );

}
