package com.bbd.bgo.service.task;


import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.mapper.CompanyBackgroundMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.CompanyStaticRiskScoreMapper;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.service.impl.OfflineFinanceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cgj on 2017/4/20.
 */
@Service
public class StaticRiskUpdateServiceImpl implements StaticRiskUpdateService,TaskService {

	private Integer taskId = null;

	private Integer errorNum = null;

	private Logger logger = LoggerFactory.getLogger(OfflineFinanceServiceImpl.class);

	@Autowired
	private CompanyStaticRiskScoreService companyStaticRiskScoreService;

	@Autowired
	private UpdateWhiteCompanyRiskGradeService updateWhiteCompanyRiskGradeService;

	@Autowired
	private CompanyStaticRiskScoreMapper companyStaticRiskScoreMapper;

	@Autowired
	private TaskFailInfoMapper taskFailInfoMapper;


	private volatile boolean isShutdown = false;//任务停止标志

	@Override
	public void stopTask() {
		isShutdown = true;
	}
	//跑历史月份的数据
	@Override
	public TaskResultDO updateOldStaticRiskAutomaticOperate(String newDataVersion) {
		logger.info("--- static risk job begin ---");
		isShutdown=false;
		this.taskId=taskId;
		this.errorNum=0;
		TaskResultDO taskResultDO=new TaskResultDO();
		Integer dataTotal = 0;
		try {
			//查询最新版本,
			String[] DataVersion ={newDataVersion};
			//List<String> DataVersion = companyStaticRiskScoreMapper.getDateVersion();
			for (String dataVersion : DataVersion){
				//查询总公司数
				final int totalCount = companyStaticRiskScoreMapper.findCompanyCount(dataVersion);
				dataTotal = totalCount;
				final int pageSize = 190;
				Pagination pagination = new Pagination();
				pagination.setPageSize(pageSize);
				pagination.setCount(totalCount);
				int total = pagination.getLastPageNumber();
				ExecutorService dataExecutorService = Executors.newFixedThreadPool(12);
				logger.info("start update static risk");
				for (int i = 1; i <= total; i++) {
					final int num = i;
					dataExecutorService.submit(new Runnable() {
						@Override
						public void run() {
							Pagination paginationP = new Pagination();
							paginationP.setPageNumber(num);
							paginationP.setPageSize(pageSize);
							paginationP.setCount(totalCount);
							companyAndBackgroundUpdateThread(dataVersion,paginationP,1,taskId);
						}
					});
				}

				dataExecutorService.shutdown();
				dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
				logger.info(dataVersion+"版本finish");
			}

			//更新5万家白名单企业
			updateWhiteCompanyRiskGradeService.startUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (isShutdown) {
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(0);
			taskResultDO.setSuccessCount(0);
		}else{
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(errorNum);
			taskResultDO.setSuccessCount(dataTotal-errorNum);
		}

		logger.info("--- static risk job end ---");
		return taskResultDO;
	}

	@Override
	public TaskResultDO updateStaticRiskAutomaticOperate(Integer taskId) {
		logger.info("--- static risk job begin ---");
		isShutdown=false;
		this.taskId=taskId;
		this.errorNum=0;
		TaskResultDO taskResultDO=new TaskResultDO();
		Integer dataTotal = 0;
		try {
			//查询最新版本
			String newDataVersion = companyStaticRiskScoreMapper.getNewDataVersion();
			//查询总公司数
			final int totalCount = companyStaticRiskScoreMapper.findCompanyCount(newDataVersion);
			dataTotal = totalCount;
			final int pageSize = 190;
			Pagination pagination = new Pagination();
			pagination.setPageSize(pageSize);
			pagination.setCount(totalCount);
			int total = pagination.getLastPageNumber();
			ExecutorService dataExecutorService = Executors.newFixedThreadPool(12);
			logger.info("start update static risk");
			for (int i = 1; i <= total; i++) {
				final int num = i;
				dataExecutorService.submit(new Runnable() {
					@Override
					public void run() {
						Pagination paginationP = new Pagination();
						paginationP.setPageNumber(num);
						paginationP.setPageSize(pageSize);
						paginationP.setCount(totalCount);
						companyAndBackgroundUpdateThread(newDataVersion,paginationP,1,taskId);
					}
				});
			}
			dataExecutorService.shutdown();
			dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
			//更新5万家白名单企业
			updateWhiteCompanyRiskGradeService.startUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (isShutdown) {
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(0);
			taskResultDO.setSuccessCount(0);
		}else{
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(errorNum);
			taskResultDO.setSuccessCount(dataTotal-errorNum);
		}

		logger.info("--- static risk job end ---");
		return taskResultDO;
	}

	@Override
	public TaskResultDO updateStaticRiskManualOperate(Integer oldTaskId,Integer newTaskId){
		logger.info("--- static risk handle begin ---");
		isShutdown=false;
		TaskResultDO taskResultDO = new TaskResultDO();
		this.taskId=newTaskId;
		this.errorNum=0;
		Integer dataTotal = 0;
		try {
			//查询最新版本
			String newDataVersion = companyStaticRiskScoreMapper.getNewDataVersion();
			final int totalCount = taskFailInfoMapper.countFailByTaskId(oldTaskId);
			dataTotal = totalCount;
			final int pageSize = 190;
			Pagination pagination = new Pagination();
			pagination.setPageSize(pageSize);
			pagination.setCount(totalCount);
			int total = pagination.getLastPageNumber();
			ExecutorService dataExecutorService = Executors.newFixedThreadPool(16);
			logger.info("start update static risk");
			for (int i = 1; i <= 10; i++) {
				if (isShutdown) {
					break;
				}
				final int num = i;
				dataExecutorService.submit(new Runnable() {
					@Override
					public void run() {
						Pagination paginationP = new Pagination();
						paginationP.setPageNumber(num);
						paginationP.setPageSize(pageSize);
						paginationP.setCount(totalCount);
						companyAndBackgroundUpdateThread(newDataVersion,paginationP,2,oldTaskId);
					}
				});
			}
			dataExecutorService.shutdown();
			dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
			//更新5万家白名单企业
			updateWhiteCompanyRiskGradeService.startUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (isShutdown) {
			taskResultDO.setFailCount(0);
			taskResultDO.setSuccessCount(0);
		}else{
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(errorNum);
			taskResultDO.setSuccessCount(dataTotal-errorNum);
		}
		logger.info("--- static risk handle end ---");
		return taskResultDO;
	}


	private void companyAndBackgroundUpdateThread(String newDataVersion,Pagination pagination,Integer type,Integer dataTaskId) {
		if (isShutdown) {
			return;
		}
		Map<String, Object> params = new HashMap<>();
		params.put("pagination", pagination);
		params.put("newDataVersion",newDataVersion);
		StringBuffer companyNameSerial = new StringBuffer();
		List<String> failNameList = new ArrayList<String>();
		if(1==type){
			//分页查询最新版本线下理财公司
			List<CompanyStaticRiskScoreDO> list = companyStaticRiskScoreMapper.findByPage(params);
			if (CollectionUtils.isEmpty(list)) {
				return;
			}
			for (final CompanyStaticRiskScoreDO companyStaticRiskScoreDO : list){
				//更新企业风险值
				try{
					companyStaticRiskScoreService.updateOffLineCompany(newDataVersion,companyStaticRiskScoreDO);
				}catch (Exception e) {
					logger.error(e.getMessage(), e);
					insertFailInfo(null,companyStaticRiskScoreDO.getName(),"计算更新公司风险出错");
				}

			}

		}else{
			params.put("taskId",dataTaskId);
			List<TaskFailInfoDO> failList = taskFailInfoMapper.findByPage(params);
			if (CollectionUtils.isEmpty(failList)) {
				return;
			}
			for (final TaskFailInfoDO fail : failList) {
				List<CompanyStaticRiskScoreDO> list = companyStaticRiskScoreMapper.findByCompanyName(fail.getFailName(), newDataVersion);
				if (CollectionUtils.isEmpty(list)){
					return;
				}
				for (final CompanyStaticRiskScoreDO companyStaticRiskScoreDO : list){
					//更新企业风险值
					try{
						companyStaticRiskScoreService.updateOffLineCompany(newDataVersion,companyStaticRiskScoreDO);
					}catch (Exception e) {
						logger.error(e.getMessage(), e);
						insertFailInfo(null,companyStaticRiskScoreDO.getName(),"计算更新公司风险出错");
					}
				}
			}
		}
	}


	private void insertFailInfo(List<String> list,String companyName,String errorReason){
		TaskFailInfoDO failInfo = new TaskFailInfoDO();
		failInfo.setFailReason(errorReason);
		failInfo.setTaskId(taskId);
		failInfo.setCreateBy("system");
		if(null==list){
			failInfo.setFailName(companyName);
			taskFailInfoMapper.addTaskFailInfo(failInfo);
			errorNum++;
		}else{
			for(String name:list){
				failInfo.setFailName(name);
				taskFailInfoMapper.addTaskFailInfo(failInfo);
				errorNum++;
			}
		}
	}



	@Override
	public String getTaskKey() {
		return "companyBaseInfoJob";
	}

	@Override
	public String getTaskGroup() {
		return "job_work";
	}

	@Override
	public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
		TaskResultDO taskResultDO = updateStaticRiskAutomaticOperate(taskId);
		return taskResultDO;
	}

	@Override
	public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {

		TaskResultDO taskResultDO = updateStaticRiskManualOperate(oldTaskId, newTaskId);
		return taskResultDO;
	}

	@Override
	public void stopExecute(Integer taskId) {
		stopTask();
	}

	@Override
	public void resetTask() {
		this.isShutdown=false;
	}
}


