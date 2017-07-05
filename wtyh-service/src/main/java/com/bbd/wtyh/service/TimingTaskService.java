package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskInfoDo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public interface TimingTaskService {
    List<TaskInfoDo> getBaseInfo();

    List<TaskInfoDo> getLatestInfo();
}
