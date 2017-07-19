package com.bbd.bgo.service.task;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
public interface DataLoadingService {
    /**
     * 新型金融全息数据和舆情数据落地定时手动更新
     */
    Map<String,Integer> dataLoadingManualOperate(Integer taskId);

    /**
     * 新型金融全息数据和舆情数据落地定时自动更新
     */
    Map<String,Integer> dataLoadingAutomaticOperate(Integer taskId);
}
