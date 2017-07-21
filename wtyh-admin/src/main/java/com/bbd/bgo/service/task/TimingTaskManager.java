package com.bbd.bgo.service.task;


import com.bbd.bgo.quartz.TaskUtil;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
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
	private P2PImageService p2pImageService;
	@Autowired
	private PToPMonitorService p2pMonitorService;
	@Autowired
	private DataLoadingService dataLoadingService;
    @Autowired
    private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;
    @Autowired
    private CrowdFundingService crowdFundingService;
	@Autowired
	private WangdaiTaskInfoService wangdaiTaskInfoService;


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

            taskEnd(map,taskId,planCount,successCount,failCount,null);
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

            taskEnd(map,taskId,planCount,successCount,failCount,null);
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

            taskEnd(map,taskId,planCount,successCount,failCount,null);
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

            taskEnd(map,taskId,planCount,successCount,failCount,null);
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

            taskEnd(map,taskId,planCount,successCount,failCount,null);
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
	 * 网络借贷检测全量数据
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
            map = p2pMonitorService.pToPMonitorDataLandTask(taskId);

		} catch (Exception e) {
			logger.error("pullP2PMonitorTask"+e);
		}finally {
            taskEnd(map,taskId,planCount,successCount,failCount,null);
		}
	}

    /**
     * 数据落地-网贷之家
     *
     * 网络借贷平台画像
     */
    public void pullP2PImageTask() throws Exception {
        Integer taskId=null;
        Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
        Integer successCount=null;
        Integer failCount=null;
        Map map = null;
        try {

            String dataVersion= null;//有版本号的传版本号，没有的不传，根据自己的业务规则定
            Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
            taskId=TaskUtil.taskStart(TaskUtil.p2pImageJob[0],TaskUtil.p2pImageJob[1],dataVersion,runMode,null,null);
            //需要传 taskId 给业务接口
            map = p2pImageService.p2pImageDataLandTask(taskId);

        } catch (Exception e) {
            logger.error("pullP2PMonitorTask"+e);
        }finally {
            taskEnd(map,taskId,planCount,successCount,failCount,null);
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
            map=crowdFundingService.crowdFundingDataLandTask(taskId);
		} catch (Exception e) {
			logger.error("updateCrowdFundingData"+e);
		}finally {

            taskEnd(map,taskId,planCount,successCount,failCount,null);
		}
	}

	public void reExecuteTask(Integer oldTaskId, String taskKey, String taskGroup){
		Integer runMode=1;
		Integer newTaskId=null;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		Map map =null;

		if(TaskUtil.shangHaiCreditJob[0].equals(taskKey)){

			//公信数据落地
			try {
				newTaskId = TaskUtil.taskStart(TaskUtil.shangHaiCreditJob[0], TaskUtil.shangHaiCreditJob[1], null, runMode, null, null);
                taskSuccessFailInfoMapper.updateReExecuteById(2,oldTaskId);
				map=coCreditScoreService.executeFailCompanyByTaskId(runMode, oldTaskId, newTaskId);
			}catch (Exception e){
				logger.error("reExecuteTask-shangHaiCreditJob"+e);
			}finally {
                taskEnd(map,newTaskId,planCount,successCount,failCount,null);
			}

		}else if(TaskUtil.offlineFinanceJob[0].equals(taskKey)){
			//BBD数据落地-线下理财

		}else if(TaskUtil.holographicAndOpinionJob[0].equals(taskKey)){
			//BBD数据落地-权限舆情

		}else if(TaskUtil.pToPMonitorJob[0].equals(taskKey)){
			//网贷之家数据落地-网络借贷-监测

			try {
				newTaskId = TaskUtil.taskStart(TaskUtil.pToPMonitorJob[0], TaskUtil.pToPMonitorJob[1], null, runMode, null, null);
				taskSuccessFailInfoMapper.updateReExecuteById(2,oldTaskId);
				map=p2pMonitorService.executeFailTaskByTaskId(runMode, oldTaskId, newTaskId);
			}catch (Exception e){
				logger.error("reExecuteTask-pToPMonitorJob"+e);
			}finally {
				taskEnd(map,newTaskId,planCount,successCount,failCount,null);
			}

		}else if(TaskUtil.p2pImageJob[0].equals(taskKey)){
			//网贷之家数据落地-网络借贷-平台画像
			try {
				newTaskId = TaskUtil.taskStart(TaskUtil.p2pImageJob[0], TaskUtil.p2pImageJob[1], null, runMode, null, null);
				taskSuccessFailInfoMapper.updateReExecuteById(2,oldTaskId);
				map=p2pImageService.executeFailTaskByTaskId(runMode, oldTaskId, newTaskId);
			}catch (Exception e){
				logger.error("reExecuteTask-p2pImageJob"+e);
			}finally {
				taskEnd(map,newTaskId,planCount,successCount,failCount,null);
			}

		}else if(TaskUtil.crowdFundingJob[0].equals(taskKey)){
			//网贷之家数据落地-众筹
			try {
				newTaskId = TaskUtil.taskStart(TaskUtil.crowdFundingJob[0], TaskUtil.crowdFundingJob[1], null, runMode, null, null);
				taskSuccessFailInfoMapper.updateReExecuteById(2,oldTaskId);
				map=crowdFundingService.executeFailTaskByTaskId(runMode, oldTaskId, newTaskId);
			}catch (Exception e){
				logger.error("reExecuteTask-crowdFundingJob"+e);
			}finally {
				taskEnd(map,newTaskId,planCount,successCount,failCount,null);
			}

		}else if(TaskUtil.riskLevelJob[0].equals(taskKey)){
			//系统数据更新-风险等级

		}else if(TaskUtil.companyBaseInfo[0].equals(taskKey)){
			//系统数据更新-企业基本信息

		}
	}

	public void taskEnd(Map map,Integer taskId,Integer planCount,Integer successCount,Integer failCount,String creatBy){
        if(null!=map){
            planCount=map.get("planCount")==null?null:(Integer)map.get("planCount");
            successCount=map.get("successCount")==null?null:(Integer)map.get("successCount");
            failCount=map.get("failCount")==null?null:(Integer)map.get("failCount");
        }
        TaskUtil.taskEnd(taskId,planCount,successCount,failCount,null);
    }


	public List<TaskFailInfoDO> downloadTaskInfo(Integer taskId, String taskKey, String taskGroup){
		List<TaskFailInfoDO> list=null;
		if(TaskUtil.shangHaiCreditJob[0].equals(taskKey)){
			//公信数据落地
			list=coCreditScoreService.getCreditFailInfoByTaskId(taskId);

		}else if(TaskUtil.offlineFinanceJob[0].equals(taskKey)){
			//BBD数据落地-线下理财

		}else if(TaskUtil.holographicAndOpinionJob[0].equals(taskKey)){
			//BBD数据落地-权限舆情

		}else if(TaskUtil.pToPMonitorJob[0].equals(taskKey)
				|| TaskUtil.p2pImageJob[0].equals(taskKey)
				|| TaskUtil.crowdFundingJob[0].equals(taskKey)){
			//网贷之家数据落地-网络借贷-监测
			//网贷之家数据落地-网络借贷-平台画像
			//网贷之家数据落地-众筹
			list=wangdaiTaskInfoService.listByTaskId(taskId);

		}else if(TaskUtil.riskLevelJob[0].equals(taskKey)){
			//系统数据更新-风险等级

		}else if(TaskUtil.companyBaseInfo[0].equals(taskKey)){
			//系统数据更新-企业基本信息

		}

		return list;
	}



}
