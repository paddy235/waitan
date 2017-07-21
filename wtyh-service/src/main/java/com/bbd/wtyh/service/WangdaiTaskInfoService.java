package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskFailInfoDO;

import java.util.List;

/**
 * Created by lixudong on 2017/7/21.
 */
public interface WangdaiTaskInfoService {

    List<TaskFailInfoDO> listByTaskId(Integer taskId);
}
