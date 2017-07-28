package com.bbd.bgo.service.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.excel.imp.utils.FileUtil;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.util.HttpUtil;
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
public class SyncFileServiceImpl extends BaseServiceImpl implements SyncFileService {

	private static final Logger logger = LoggerFactory.getLogger(SyncFileServiceImpl.class);

	private static final String PULL_FILE_SAVE_PATH = "/data1/wtyh/admin/";

	@Autowired
	private SyncDataService syncDataService;
	@Autowired
	private RelationDataService relationDataService;
	@Autowired
	private TaskFailInfoMapper taskFailInfoMapper;

	@Value("${api.bbd.broker.ip}")
	private String brokerIp;
	private String brokerUri = "/syncFile/supplyFile.do";

	@Override
	public TaskResultDO pullFile(Integer taskId) {
		TaskResultDO taskResult = null;
		try {
			String dataVersion = relationDataService.getNewestDataVersion();
			File file = pullFile(dataVersion);
			logger.info("--------- parse data file start -----");
			taskResult = this.syncDataService.receiveFileData(file);
			// 表示有错误数据，需要记录
			if (taskResult != null && taskResult.getFailCount().compareTo(0) == 1) {
				taskRecord(taskId, dataVersion);
			}
			logger.info("--------- parse data file end -------");
		} catch (Exception e) {
			logger.error("处理线下理财风险数据异常。", e);
		}
		return taskResult;
	}

	@Override
	public TaskResultDO rePullFile(Integer oldTaskId, Integer newTaskId) {
		TaskResultDO taskResult = null;
		try {
			List<TaskFailInfoDO> taskFailList = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
			if (CollectionUtils.isEmpty(taskFailList)) {
				return taskResult;
			}
			TaskFailInfoDO taskFail = taskFailList.get(0);
			String dataVersion = taskFail.getDataVersion();
			File file = pullFile(dataVersion);
			logger.info("--------- parse data file start -----");
			taskResult = this.syncDataService.receiveFileData(file);

			// 表示有错误数据，需要记录
			if (taskResult != null && taskResult.getFailCount().compareTo(0) == 1) {
				taskRecord(newTaskId, dataVersion);
			}
			logger.info("--------- parse data file end -------");

		} catch (Exception e) {
			logger.error("处理线下理财风险数据异常。", e);
		}

		return taskResult;
	}

	private void taskRecord(Integer taskId, String dataVersion) {
		TaskFailInfoDO taskFail = new TaskFailInfoDO();
		taskFail.setTaskId(taskId);
		taskFail.setDataVersion(dataVersion);
		taskFail.setFailName(dataVersion);
		taskFail.setCreateBy("线下理财风险数据定时任务");
		taskFail.setCreateDate(new Date());
		this.taskFailInfoMapper.addTaskFailInfo(taskFail);
	}

	public File pullFile(String dataVersion) throws Exception {
		logger.info("--------- pull data file start,dataVersion:{} ------", dataVersion);
		String fileName = dataVersion + ".txt";
		File file = new File(PULL_FILE_SAVE_PATH + fileName);
		if (file.exists()) {
			logger.info("--------- pull data file end. File from the local ------");
			return file;
		}

		InputStream input = null;
		OutputStream out = null;
		try {
			String url = brokerIp + brokerUri + "?dataVersion=" + dataVersion;
			input = HttpUtil.get(url, 36000, InputStream.class);
			file = new File(PULL_FILE_SAVE_PATH + fileName);
			FileUtil.forceMkdirParent(file);
			out = new FileOutputStream(file);
			IOUtils.copyLarge(input, out);
			logger.info("--------- pull data file end. File from the Beijing server --------");
		} finally {
			FileUtil.closeResource(input, out);
		}
		return file;
	}

}
