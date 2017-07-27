package com.bbd.bgo.service.task;

import com.bbd.wtyh.domain.TaskResultDO;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-18 9:53.
 */
public interface SyncFileService {

	TaskResultDO pullFile(Integer taskId);

	TaskResultDO rePullFile(Integer oldTaskId, Integer newTaskId);
}