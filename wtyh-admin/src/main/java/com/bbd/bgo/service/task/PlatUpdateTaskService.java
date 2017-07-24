package com.bbd.bgo.service.task;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
public interface PlatUpdateTaskService {
    /**
     * 更新网贷平台与企业对照关系自动执行
     */
    Map<String,Integer> updatePlatAutomaticOperate(Integer taskId);

    /**
     * 更新网贷平台与企业对照关系手动执行
     */
    Map<String,Integer> updatePlatManualOperate(Integer oldTaskId,Integer newTaskId);
}
