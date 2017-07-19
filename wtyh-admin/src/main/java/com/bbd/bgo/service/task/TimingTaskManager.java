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
	@Autowired
	private DataLoadingService dataLoadingService;

	private Logger logger = LoggerFactory.getLogger(TimingTaskManager.class);

	/**
	 * 普通任务
	 *
	 * 更新企业风险等级
	 * 频率：每天16：20：00执行
	 */
	public void updateRiskLevelTask() throws Exception {
		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map =null;
		try {
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart(TaskUtil.riskLevelJob[0],TaskUtil.riskLevelJob[1],null,runMode,null,null);
			//需要传 taskId 给业务接口
			offlineFinanceService.updateCompanyRiskLevel();
		} catch (Exception e) {
			logger.error("riskLevelTask"+e);
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
	 * 普通任务
	 *
	 * 更新企业基本信息
	 * 频率：每月2日晚上8点
	 */
	public void updateCompanyBaseInfoTask() throws Exception {
		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map =null;
		try {
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart(TaskUtil.companyBaseInfo[0],TaskUtil.companyBaseInfo[1],null,runMode,null,null);
			//需要传 taskId 给业务接口
			systemDataUpdateService.updateCompanyTableAreaIdAndAddress();
		} catch (Exception e) {
			logger.error("companyBaseInfoTask"+e);
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
	 * 数据落地-BBD
	 *
	 * 拉取线下理财数据
	 * 频率：每晚11点开始
	 */
	public void pullOfflineFinanceTask() {
		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map =null;
		try {
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart(TaskUtil.offlineFinanceJob[0],TaskUtil.offlineFinanceJob[1],null,runMode,null,null);
			//需要传 taskId 给业务接口
			syncFileService.pullFile();

		} catch (Exception e) {
			logger.error("pullDataFileFromBBDTask"+e);
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
	 * 数据落地-BBD
	 *
	 * 全息数据+舆情
	 * 频率：
	 */
	public void pullHolographicAndOpinionTask() {
		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map =null;
		try {
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart(TaskUtil.holographicAndOpinionJob[0],TaskUtil.holographicAndOpinionJob[1],null,runMode,null,null);
			//需要传 taskId 给业务接口
			map=dataLoadingService.dataLoadingAutomaticOperate(taskId);
		} catch (Exception e) {
			logger.error("pullHolographicAndOpinionTask"+e);
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
	 * 数据落地-公信中心
	 *
	 * 拉取公信中心数据
	 * 频率：18点开始
	 */
	public void pullCreditTask() {
		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map =null;
		try {
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart(TaskUtil.shangHaiCreditJob[0],TaskUtil.shangHaiCreditJob[1],null,runMode,null,null);
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
	 * 数据落地-公信中心
	 *
	 * 关闭拉取公信中心数据
	 * 频率：07点开始
	 */
	public void closeCreditTask() throws Exception {
		coCreditScoreService.colseScoreCalculate();
	}



	/**
	 * 数据落地-网贷之家
	 *
	 * 更新网络借贷舆情数据
	 * @throws Exception
	 */
	public void pullYuQing()throws Exception{
		pImageService.updateWangDaiYuQingTask();

	}

	/**
	 * 数据落地-网贷之家
	 *
	 * 更新网贷之家数据
	 */
	public void pullP2PMonitorTask() throws Exception {
		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map = null;
		try {

			String dataVersion= null;//有版本号的传版本号，没有的不传，根据自己的业务规则定
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart(TaskUtil.pToPMonitorJob[0],TaskUtil.pToPMonitorJob[1],dataVersion,runMode,null,null);
			//需要传 taskId 给业务接口
			map = pToPMonitorService.pToPMonitorDataLanding(taskId);
//			pToPMonitorService.industryCompareDataLandingTask();
//			pToPMonitorService.platRankDataLandingTask();

		} catch (Exception e) {
			logger.error("pullP2PMonitorTask"+e);
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
	 * 数据落地-网贷之家
	 *
	 * 更新众筹数据
	 * @throws Exception
	 */
	public void pullCrowdFundingTask()throws Exception{

		Integer taskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map =null;
		try {
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			taskId=TaskUtil.taskStart(TaskUtil.crowdFundingJob[0],TaskUtil.crowdFundingJob[1],null,runMode,null,null);
			//需要传 taskId 给业务接口
		} catch (Exception e) {
			logger.error("updateCrowdFundingData"+e);
		}finally {

			if(null!=map){
				planCount=map.get("planCount")==null?null:(Integer)map.get("planCount");
				successCount=map.get("successCount")==null?null:(Integer)map.get("successCount");
				failCount=map.get("failCount")==null?null:(Integer)map.get("failCount");
			}
			TaskUtil.taskEnd(taskId,planCount,successCount,failCount,null);
		}
	}

}
