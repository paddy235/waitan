package com.bbd.bgo.service.task;

import com.bbd.bgo.service.SyncFileService;
import com.bbd.wtyh.service.CoCreditScoreService;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@Scheduled(cron = "0 0 23 * * *")
	public void pullDataFileFromBBDTask() {
		syncFileService.pullFile();
	}

	public void shangHaiCreditTask() {
		coCreditScoreService.creditScoreCalculate();

		// while (true) {
		// try {
		// Thread.sleep(5 * 1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// System.out.println(LocalDateTime.now());
		// }
	}

	public void closeShangHaiCreditTask() throws Exception {
		coCreditScoreService.colseScoreCalculate();
		// coCreditScoreService.creditScoreCalculate();

		// Scheduler scheduler = schedulerFactoryBean.getScheduler();
		//
		// JobKey jobKey = JobKey.jobKey("shangHaiCreditJob", "credit_work");
		// scheduler.deleteJob(jobKey);
	}

}
