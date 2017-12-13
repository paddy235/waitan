package com.bbd.bgo.service.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.excel.imp.utils.FileUtil;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.util.HttpUtil;
import com.bbd.wtyh.util.WtyhHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.service.RelationDataService;
import com.bbd.wtyh.service.SyncDataService;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-18 9:53.
 */
@Service
public class SyncFileServiceImpl extends BaseServiceImpl implements SyncFileService, TaskService {

	private static final Logger logger = LoggerFactory.getLogger(SyncFileServiceImpl.class);

	private static final String PULL_FILE_SAVE_PATH = WtyhHelper.fileRootPath + "/admin/";

	@Autowired
	private SyncDataService syncDataService;
	@Autowired
	private RelationDataService relationDataService;
	@Autowired
	private TaskFailInfoMapper taskFailInfoMapper;

	@Value("${api.bbd.broker.ip}")
	private String brokerIp;
	private String brokerUri = "/syncFile/supplyFile.do";
	private String brokerUrl = "/syncFile/generateFile.do";


	@Override
	public void stopTask() {
		this.syncDataService.stopTask();
	}

	@Override
	public TaskResultDO pullFile(Integer taskId) {
		logger.info("--- offline data job begin ---");
		TaskResultDO taskResult = null;
		File file = null;
		try {
			String dataVersion = relationDataService.getNewestDataVersion();
			String[] fileNames = pullFile(dataVersion ,taskId);
			for(String fileName : fileNames){
				file = new File(PULL_FILE_SAVE_PATH + fileName);
				logger.info("--------- parse "+fileName+" data file start -----");
				taskResult = this.syncDataService.receiveFileData(file);
				// 表示有错误数据，需要记录
				if (taskResult != null && taskResult.getFailCount().compareTo(0) == 1) {
					taskRecord(taskId, dataVersion);
				}
				logger.info("--------- parse "+fileName+" data file end -------");
			}

		} catch (Exception e) {
			if (null == taskResult) {
				taskResult = new TaskResultDO(0, 0, 0);
			}
			taskResult.setState(TaskState.ERROR);
			logger.error("处理线下理财风险数据异常。", e);
		}
		logger.info("--- offline data job end ---");
		return taskResult;
	}

	@Override
	public TaskResultDO rePullFile(Integer oldTaskId, Integer newTaskId) {
		logger.info("--- offline data handle begin ---");
		String dataVersion = null;
		File file =  null;
		TaskResultDO taskResult = new TaskResultDO(0,0,0);
		try {
			List<TaskFailInfoDO> taskFailList = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
			if (CollectionUtils.isEmpty(taskFailList)) {
				return taskResult;
			}
			TaskFailInfoDO taskFail = taskFailList.get(0);
			dataVersion = taskFail.getDataVersion();
			String[] fileNames = pullFile(dataVersion ,newTaskId);
			for(String fileName : fileNames) {
				file = new File(PULL_FILE_SAVE_PATH + fileName);
				logger.info("--------- parse "+fileName+" data file start -----");
				taskResult = this.syncDataService.receiveFileData(file);

				// 表示有错误数据，需要记录
				if (taskResult != null && taskResult.getFailCount().compareTo(0) == 1) {
					taskRecord(newTaskId, dataVersion);
				}
				logger.info("--------- parse  "+fileName+" data file end -------");
			}
		} catch (Exception e) {
			taskRecord(newTaskId, dataVersion);
			taskResult.setPlanCount(1);
			taskResult.setSuccessCount(0);
			taskResult.setFailCount(1);
			taskResult.setState(TaskState.ERROR);
			logger.error("处理线下理财风险数据异常。", e);
		}
		logger.info("--- offline data handle end ---");
		return taskResult;
	}

	private void taskRecord(Integer taskId, String dataVersion) {
		TaskFailInfoDO taskFail = new TaskFailInfoDO();
		taskFail.setTaskId(taskId);
		taskFail.setDataVersion(dataVersion);
		taskFail.setFailName(dataVersion);
		taskFail.setCreateBy("system");
		taskFail.setCreateDate(new Date());
		this.taskFailInfoMapper.addTaskFailInfo(taskFail);
	}

	public String[] pullFile(String dataVersion,Integer taskId){
		logger.info("--------- pull data file start,dataVersion:{} ------", dataVersion);
		//String fileName = dataVersion + ".txt";

		//if (file.exists() && file.length() > 0) {
		//	logger.info("--------- pull data file end. File from the local ------");
		//	return file;
	//	}

		InputStream input = null;
		OutputStream out = null;
		File file = null;
		String[] fileNames = null;
			//请求返回生成文件名称
			dataVersion = "20171119";
			String url =  brokerIp + brokerUrl + "?dataVersion=" + dataVersion;
			String nameStr = null;
			try {
				nameStr = HttpUtil.get(url, 36000, String.class);
			} catch (Exception e) {
				e.printStackTrace();
				TaskFailInfoDO taskFail = new TaskFailInfoDO();
				taskFail.setTaskId(taskId);
				taskFail.setDataVersion(dataVersion);
				taskFail.setFailName("borker生成文件错误");
				taskFail.setCreateBy("system");
				taskFail.setCreateDate(new Date());
				this.taskFailInfoMapper.addTaskFailInfo(taskFail);
			}
			fileNames = nameStr.split(",");
			for(String fileName :fileNames){
				try {
					file = new File(PULL_FILE_SAVE_PATH + fileName);
					url = brokerIp + brokerUri + "?fileName=" + fileName+"&dataVersion="+dataVersion;
					input = HttpUtil.get(url, 36000, InputStream.class);
					//file = new File(PULL_FILE_SAVE_PATH + fileName);
					FileUtil.forceMkdirParent(file);
					out = new FileOutputStream(file);
					IOUtils.copyLarge(input, out);
				} catch (Exception e) {
					e.printStackTrace();
					TaskFailInfoDO taskFail = new TaskFailInfoDO();
					taskFail.setTaskId(taskId);
					taskFail.setDataVersion(dataVersion);
					taskFail.setFailName(fileName);
					taskFail.setFailReason("拉取文件错误");
					taskFail.setCreateBy("system");
					taskFail.setCreateDate(new Date());
					this.taskFailInfoMapper.addTaskFailInfo(taskFail);
				}
			}
			logger.info("--------- pull data file end. File from the Beijing server --------");
			FileUtil.closeResource(input, out);
		return fileNames;
	}

	@Override
	public String getTaskKey() {
		return "offlineFinanceJob";
	}

	@Override
	public String getTaskGroup() {
		return "bbd_work";
	}

	@Override
	public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
		TaskResultDO taskResultDO = pullFile(taskId);
		return taskResultDO;
	}

	@Override
	public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {
		TaskResultDO taskResultDO = rePullFile(oldTaskId, newTaskId);
		return taskResultDO;
	}

	@Override
	public void stopExecute(Integer taskId) {
		stopTask();
	}

	@Override
	public void resetTask() {
		syncDataService.resetShutDown();
	}

}
