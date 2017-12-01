package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskResultDO;

/**
 * @Author:WLL
 * @Date:Create on 9:552017/11/21
 */
public interface UpdateWhiteCompanyRiskGradeService {
    void startUpdate();

    /**
     * 更新线下白名单风险等级自动执行
     */
    TaskResultDO updateOfflineWhiteAutomaticOperate(Integer taskId);

    /**
     * 更新线下白名单风险等级手动执行
     */
    TaskResultDO updateOfflineWhiteManualOperate(Integer oldTaskId,Integer newTaskId);

    void stopTask();
}
