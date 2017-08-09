package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
@Service
public class CoCreditServiceCloseImpl implements TaskService {
    @Autowired
    CoCreditScoreService coCreditScoreService;
    @Override
    public String getTaskKey() {
        return "closeShangHaiCreditJob";
    }

    @Override
    public String getTaskGroup() {
        return "credit_work";
    }

    @Override
    public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
        coCreditScoreService.colseScoreCalculate();
        return null;
    }

    @Override
    public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {
        return null;
    }

    @Override
    public void stopExecute(Integer taskId) {
        coCreditScoreService.colseScoreCalculate();
    }

    @Override
    public void resetTask() {
    }
}
