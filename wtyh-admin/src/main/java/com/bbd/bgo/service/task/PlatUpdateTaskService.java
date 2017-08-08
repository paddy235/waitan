package com.bbd.bgo.service.task;

import com.bbd.wtyh.domain.TaskResultDO;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
public interface PlatUpdateTaskService {
    /**
     * 更新网贷平台与企业对照关系自动执行
     */
    TaskResultDO updatePlatAutomaticOperate(Integer taskId);

    /**
     * 更新网贷平台与企业对照关系手动执行
     */
    TaskResultDO updatePlatManualOperate(Integer oldTaskId,Integer newTaskId);

    public void stopTask();
}
