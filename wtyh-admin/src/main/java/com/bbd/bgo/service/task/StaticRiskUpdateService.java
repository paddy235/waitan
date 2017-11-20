package com.bbd.bgo.service.task;

import com.bbd.wtyh.domain.TaskResultDO;

/**
 * Created by zhw on 2017/11/20.
 */
public interface StaticRiskUpdateService {

    /**
     * 更新静态风险相关手动执行
     * (by zhw)
     */
    TaskResultDO updateStaticRiskManualOperate(Integer oldTaskId, Integer newTaskId);

    /**
     * 更新静态风险相关自动执行
     * (by zhw)
     */
    TaskResultDO updateStaticRiskAutomaticOperate(Integer taskId);

    public void stopTask();
}
