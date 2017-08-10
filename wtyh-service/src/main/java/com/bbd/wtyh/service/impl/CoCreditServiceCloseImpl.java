package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
@Service
public class CoCreditServiceCloseImpl implements TaskService {

    private Logger logger = LoggerFactory.getLogger(CoCreditServiceCloseImpl.class);

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
        logger.info("--- credit close job begin ---");
        coCreditScoreService.colseScoreCalculate();
        logger.info("--- credit close job end ---");
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
