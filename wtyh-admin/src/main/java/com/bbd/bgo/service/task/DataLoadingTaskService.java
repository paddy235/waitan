package com.bbd.bgo.service.task;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
public interface DataLoadingTaskService {
    /**
     * 新型金融全息数据和舆情数据落地定时更新
     */
    void dataLoading(Integer taskId);
}
