package com.bbd.bgo.service.task;

import com.bbd.wtyh.domain.TaskResultDO;

import java.util.Map;

/**
 * Created by cgj on 2017/4/20.
 */
public interface SystemDataUpdateService {

    /**
     * 更新企业表和背景表手动执行
     * (by zhw)
     */
    TaskResultDO updateCompanyAndBackgroundManualOperate(Integer oldTaskId,Integer newTaskId);

    /**
     * 更新企业表和背景表自动执行
     * (by zhw)
     */
    TaskResultDO updateCompanyAndBackgroundAutomaticOperate(Integer taskId);

    public void stopTask();
}
