package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public interface TimingTaskService {
    List<TaskInfoDO> getTaskInfo();

    List<TaskInfoDO> getLatestTaskInfo();

    List<TaskSuccessFailInfoDO> getHistoryTaskInfo();
}
