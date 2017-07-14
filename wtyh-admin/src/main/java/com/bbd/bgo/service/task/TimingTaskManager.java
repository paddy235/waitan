package com.bbd.bgo.service.task;


import com.bbd.bgo.quartz.TaskUtil;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.service.PToPMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

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
	private OfflineFinanceService offlineFinanceService;
	@Autowired
	private SystemDataUpdateService systemDataUpdateService;
	@Autowired
	private P2PImageService pImageService;
	@Autowired
	private PToPMonitorService pToPMonitorService;

	private Logger logger = LoggerFactory.getLogger(TimingTaskManager.class);

	/**
	 * 拉取线下理财数据
	 * 频率：每晚11点开始
	 */
	public void pullDataFileFromBBDTask() {

		syncFileService.pullFile();
	}
	/**
	 * 拉取公信中心数据
	 * 频率：18点开始
	 */
	public void shangHaiCreditTask() {
		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map =null;
		try {
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart("shangHaiCreditJob","credit_work",null,runMode,null,null);
			//需要传 taskId 给业务接口
			map=coCreditScoreService.creditScoreCalculate(taskId,runMode);
		} catch (Exception e) {
			logger.error("shangHaiCreditTask"+e);
		}finally {

			if(null!=map){
				planCount=map.get("planCount")==null?null:(Integer)map.get("planCount");
				successCount=map.get("successCount")==null?null:(Integer)map.get("successCount");
				failCount=map.get("failCount")==null?null:(Integer)map.get("failCount");
			}
			TaskUtil.taskEnd(taskId,planCount,successCount,failCount,null);
		}
	}
	/**
	 * 关闭拉取公信中心数据
	 * 频率：07点开始
	 */
	public void closeShangHaiCreditTask() throws Exception {
		coCreditScoreService.colseScoreCalculate();
	}
	/**
	 * 更新企业风险等级
	 * 频率：每天16：20：00执行
	 */
	public void updateCompanyRiskLevel() throws Exception {
		offlineFinanceService.updateCompanyRiskLevel();
	}

	/**
	 * 更新企业基本信息
	 * 频率：每月2日晚上8点
	 */
	public void updateCompanyBaseInfo() throws Exception {
		systemDataUpdateService.updateCompanyTableAreaIdAndAddress();
	}

	/**
	 * 更新网络借贷舆情数据
	 * @throws Exception
	 */
	public void updateYuQing()throws Exception{
		pImageService.updateWangDaiYuQingTask();

	}

	/**
	 * 更新网贷之家数据
	 */
	public void updatePToPMonitorData() throws Exception {
		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		try {

			String dataVersion= null;//有版本号的传版本号，没有的不传，根据自己的业务规则定
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart("pToPMonitorJob","wd_work",dataVersion,runMode,null,null);
			//需要传 taskId 给业务接口
			pToPMonitorService.industryShanghaiDataLandingTask();
//			pToPMonitorService.industryCompareDataLandingTask();
//			pToPMonitorService.platRankDataLandingTask();

		} catch (Exception e) {
			logger.error("updatePToPMonitorData"+e);
		}finally {
			TaskUtil.taskEnd(taskId,planCount,successCount,failCount,null);
		}
	}
}
