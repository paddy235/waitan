package com.bbd.bgo.service.task;

import com.bbd.bgo.service.SyncFileService;
import com.bbd.wtyh.service.CoCreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 所有定时任务统一管理接口实现类
 *
 * @author Created by LiYao on 2017-04-25 14:43.
 */
@Component
public class TimingTaskManager {

	@Autowired
	private SyncFileService syncFileService;
	@Autowired
	private CoCreditScoreService coCreditScoreService;

	@Scheduled(cron = "0 0 23 * * *")
	public void pullDataFileFromBBDTask() {
		syncFileService.pullFile();
	}

	public void shangHaiCreditTask() {
		coCreditScoreService.creditScoreCalculate(0);
	}

	public void closeShangHaiCreditTask() throws Exception {
		coCreditScoreService.colseScoreCalculate();
	}

}
