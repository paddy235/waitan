package com.bbd.bgo.service.task;

import com.bbd.wtyh.domain.TaskResultDO;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
public interface DataLoadingService {
    /**
     * 新型金融全息数据和舆情数据落地定时手动更新
     */
    TaskResultDO dataLoadingManualOperate(Integer oldTaskId,Integer newTaskId);

    /**
     * 新型金融全息数据和舆情数据落地定时自动更新
     */
    TaskResultDO dataLoadingAutomaticOperate(Integer taskId);

    public void stopTask();
}
