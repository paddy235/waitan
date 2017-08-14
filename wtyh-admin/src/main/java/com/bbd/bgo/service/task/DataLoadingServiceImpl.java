package com.bbd.bgo.service.task;

import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.domain.dataLoading.*;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.mapper.DataLoadingMapper;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.util.DataLoadingUtil;
import com.bbd.wtyh.util.PullFileUtil;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.io.*;
import java.util.*;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-18 9:53.
 */
@Service
public class DataLoadingServiceImpl extends BaseServiceImpl implements DataLoadingService, TaskService {

	private static final Logger logger = LoggerFactory.getLogger(DataLoadingServiceImpl.class);

	private static final String FILE_PATH = "C:\\\\Users\\\\ibm\\\\Desktop\\\\changjiang_20170704_test.test";

	private static String TASK_NAME = "holographicNewsDataLoading";

	private static String TASK_GROUP = "bbd_work";

	private Integer taskId = null;

	private Integer pullFileTaskId = null;

	private static final String DISHONESTY = "dishonesty";
	private static final String KTGG = "ktgg";
	private static final String QYXG_YUQING = "qyxg_yuqing";
	private static final String QYXX__BASIC = "qyxx_basic";
	private static final String QYXX_BAXX = "qyxx_baxx";
	private static final String QYXX_GDXX = "qyxx_gdxx";
	private static final String QYXX_ZHUANLI = "qyxx_wanfang_zhuanli";
	private static final String RMFYGG = "rmfygg";
	private static final String ZGCPWSW = "zgcpwsw";
	private static final String ZHIXING = "zhixing";

	@Autowired
	private DataLoadingMapper dataLoadingMapper;

	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Autowired
	private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;
	@Autowired
	private TaskFailInfoMapper taskFailInfoMapper;

	private volatile boolean isShutdown = false;// 任务停止标志

	@Override
	public void stopTask() {
		isShutdown = true;
	}

	@Override
	public TaskResultDO dataLoadingManualOperate(Integer oldTaskId, Integer newTaskId) {
		logger.info("--- company holographic handle begin ---");
		isShutdown = false;
		this.taskId = newTaskId;
		// 手动执行，查询之前任务失败记录，更新插入失败表
		TaskResultDO taskResultDO = new TaskResultDO();
		Integer dataError = 0;
		Integer dataTotal = 0;
		List<TaskFailInfoDO> failList = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
		// 上次出错,只跑错误部分数据
		if (CollectionUtils.isNotEmpty(failList)) {
			dataTotal = failList.size();
			List<String> failFileList = new ArrayList<>();
			for (TaskFailInfoDO fail : failList) {
				if (isShutdown) {
					break;
				}
				failFileList.add(fail.getFailName());
			}
			List<File> fileList = new ArrayList<>();
			Integer pullFileTaskId = failList.get(0).getSourceTaskId();
			this.pullFileTaskId = pullFileTaskId;
			List<DatasharePullFileDO> pullFileList = dataLoadingMapper.getDatasharePullFileByTaskId(pullFileTaskId);

			List<TaskFailInfoDO> failInfoList = new ArrayList<>();

			if (CollectionUtils.isNotEmpty(pullFileList)) {
				for (DatasharePullFileDO pullFile : pullFileList) {
					if (isShutdown) {
						break;
					}
					File file = null;
					if (pullFile.isPull()) {
						file = new File(pullFile.getFile_url());
					}
					if (file == null || !file.exists()) {
						file = PullFileUtil.pullFile(pullFile.getFile_name());
					}

					if (file == null) {
						TaskFailInfoDO fail = new TaskFailInfoDO();
						fail.setFailReason("获取文件错误");
						setFailDo(fail, file.getName());
						failList.add(fail);
						continue;
					}

					pullFile.setPull(true);
					pullFile.setFile_url(file.getAbsolutePath());
					this.update(pullFile);

					// 文件存在且上次跑出错的文件
					if (failFileList.contains(file.getName())) {
						fileList.add(file);
					}
				}
			}
			dataError = operateUpdate(failInfoList, fileList);
		}
		if (isShutdown) {
			taskResultDO.setFailCount(0);
			taskResultDO.setSuccessCount(0);
		} else {
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(dataError);
			taskResultDO.setSuccessCount(dataTotal - dataError);
		}
		logger.info("--- company holographic handle end ---");
		return taskResultDO;
	}

	@Override
	public TaskResultDO dataLoadingAutomaticOperate(Integer taskId) {
		logger.info("--- company holographic job begin ---");
		isShutdown = false;
		TaskResultDO taskResultDO = new TaskResultDO();
		Integer dataError = 0;
		Integer dataTotal = 0;
		this.taskId = taskId;
		this.pullFileTaskId = taskId;
		// 自动执行，先拉取数据，有数据执行插入，并记录成功失败情况
		Integer maxDataVersion = dataLoadingMapper.maxDataVersion();
		List<Map<String, String>> fileNameList = PullFileUtil.getFileList(1, maxDataVersion);
		List<Map<String, String>> historyFileNameList = dataLoadingMapper.noPullFileNameList();
		if (CollectionUtils.isNotEmpty(fileNameList)) {
			historyFileNameList.addAll(fileNameList);
		}

		if (CollectionUtils.isNotEmpty(historyFileNameList)) {
			dataTotal = historyFileNameList.size();
			List<TaskFailInfoDO> failList = new ArrayList<>();

			List<File> fileList = new ArrayList<>();
			List<DatasharePullFileDO> pullFileList = new ArrayList<>();

			for (Map<String, String> map : historyFileNameList) {

				String fileName = map.get("fileName");
				Integer dataVersion = Integer.parseInt(map.get("dataVersion"));

				DatasharePullFileDO pullFile = new DatasharePullFileDO();
				pullFile.setCreate_by("system");
				pullFile.setTask_id(taskId);
				pullFile.setFile_name(fileName);
				pullFile.setData_version(dataVersion);
				pullFile.setPull(false);
				pullFileList.add(pullFile);

				File file = PullFileUtil.pullFile(fileName);

				if (file == null) {
					TaskFailInfoDO fail = new TaskFailInfoDO();
					fail.setFailReason("拉取文件错误");
					setFailDo(fail, file.getName());
					failList.add(fail);
					continue;
				}
				pullFile.setPull(true);
				pullFile.setFile_url(file.getAbsolutePath());
				fileList.add(file);
			}

			dataError = this.operateUpdate(failList, fileList);
			this.insertList(pullFileList);
		}
		if (isShutdown) {
			taskResultDO.setFailCount(0);
			taskResultDO.setSuccessCount(0);
		} else {
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(dataError);
			taskResultDO.setSuccessCount(dataTotal - dataError);
		}
		logger.info("--- company holographic job end ---");
		return taskResultDO;
	}

	public Integer operateUpdate(List<TaskFailInfoDO> failList, List<File> fileList) {
		int error = 0;
		TaskFailInfoDO fail;
		List<DishonestyDO> disList;
		List<KtggDO> ktggList;
		List<QyxgYuqingDO> yuQingList;
		List<QyxxBasicDO> basicList;
		List<QyxxBaxxDO> baxxList;
		List<QyxxGdxxDO> gdxxList;
		List<QyxxZhuanliDO> zhuanliList;
		List<RmfyggDO> rmfyggList;
		List<ZgcpwswDO> zgcpwswList;
		List<ZhixingDO> zhixingList;
		List<RecruitIndexDO> recruitIndexList;

		if (CollectionUtils.isEmpty(fileList)) {
			return error;
		}
		for (File file : fileList) {
			logger.info("start analysis file , file name:" + file.getName());
			List<String> list = DataLoadingUtil.txt2String(file);
			logger.info(file.getName() + "analysis number:" + list.size());
			// 文件解析出错
			if (null == list) {
				fail = new TaskFailInfoDO();
				fail.setFailReason("文件解析错误");
				setFailDo(fail, file.getName());
				failList.add(fail);
				continue;
			}
			disList = new ArrayList<>();
			ktggList = new ArrayList<>();
			yuQingList = new ArrayList<>();
			basicList = new ArrayList<>();
			baxxList = new ArrayList<>();
			gdxxList = new ArrayList<>();
			zhuanliList = new ArrayList<>();
			rmfyggList = new ArrayList<>();
			zgcpwswList = new ArrayList<>();
			zhixingList = new ArrayList<>();
			recruitIndexList = new ArrayList<>();
			for (String s : list) {
				// 解析json错误
				try {
					// 判断是否为json格式数据
					if (isJson(s)) {
						JSONObject jsonObject = JSONObject.fromObject(s);
						String data = jsonObject.getString("data");
						String tn = jsonObject.getString("tn");
						JSONObject jsonData = JSONObject.fromObject(data);
						Object dataName = jsonData.get(tn);
						String dataStr = String.valueOf(dataName);
						DataLoadingUtil.addJsonDataToList(tn, dataStr, disList, ktggList, yuQingList, basicList, baxxList, gdxxList,
								zhuanliList, rmfyggList, zgcpwswList, zhixingList);
					} else {
						String[] recruits = s.split("\\u0001");
						RecruitIndexDO recruitIndex = new RecruitIndexDO();
						recruitIndex.setTask_id(taskId);
						recruitIndex.setCompany_name(recruits[1]);
						recruitIndex.setRecruit_industryratio(recruits[2]);
						recruitIndex.setRecruit_salaryratio(recruits[3]);
						recruitIndex.setIndex(recruits[4]);
						recruitIndex.setDt(recruits[5]);
						recruitIndexList.add(recruitIndex);
					}
				} catch (Exception e) {
					fail = new TaskFailInfoDO();
					fail.setFailReason("数据格式错误");
					setFailDo(fail, file.getName());
					failList.add(fail);
					// 出错跳出循环
					break;
				}
			}
			// 手动控制事务，异常跑出回滚事务
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 事物隔离级别，开启新事务
			TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
			try {
				insertData(disList, ktggList, yuQingList, basicList, baxxList, gdxxList, zhuanliList, rmfyggList, zgcpwswList, zhixingList,
						recruitIndexList);
				transactionManager.commit(status);
			} catch (Exception e) {
				logger.error("", e);
				transactionManager.rollback(status);
				fail = new TaskFailInfoDO();
				fail.setFailReason("数据插入错误");
				setFailDo(fail, file.getName());
				failList.add(fail);
				// 出错跳出循环
			}
		}
		if (failList.size() > 0) {
			logger.info("add data loading task to taskFailInfo table");
			error = failList.size();
			for (TaskFailInfoDO failInfo : failList) {
				taskFailInfoMapper.addTaskFailInfo(failInfo);
			}
		}
		return error;
	}

	public void setFailDo(TaskFailInfoDO fail, String FileName) {
		fail.setFailName(FileName);
		fail.setTaskId(taskId);
		fail.setCreateBy("system");
		fail.setCreateDate(new Date());
		fail.setSourceTaskId(pullFileTaskId);
	}

	/**
	 * 判断是否是json结构
	 */
	public static boolean isJson(String value) {
		try {
			JSONObject.fromObject(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional(rollbackFor = Exception.class)
	public void insertData(List<DishonestyDO> disList, List<KtggDO> ktggList, List<QyxgYuqingDO> yuQingList, List<QyxxBasicDO> basicList,
			List<QyxxBaxxDO> baxxList, List<QyxxGdxxDO> gdxxList, List<QyxxZhuanliDO> zhuanliList, List<RmfyggDO> rmfyggList,
			List<ZgcpwswDO> zgcpwswList, List<ZhixingDO> zhixingList, List<RecruitIndexDO> recruitIndexList) {
		if (disList.size() > 0) {
			UserLogRecord.record("批量新增失信被执行人", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			this.setListTaskId(disList);
			int disInsertNum = batchInsertData(disList);
			logger.info("end batch save Dishonesty , count:" + disInsertNum);
		}
		if (ktggList.size() > 0) {
			UserLogRecord.record("批量新增开庭公告", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			this.setListTaskId(ktggList);
			int ktggInsertNum = batchInsertData(ktggList);
			logger.info("end batch save ktgg , count:" + ktggInsertNum);
		}
		if (yuQingList.size() > 0) {
			UserLogRecord.record("批量新增舆情", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			this.setListTaskId(yuQingList);
			int yuQingInsertNum = batchInsertData(yuQingList);
			logger.info("end batch save Yuqing , count:" + yuQingInsertNum);
		}
		if (basicList.size() > 0) {
			this.setListTaskId(basicList);
			UserLogRecord.record("批量新增企业基础信息", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			int basicInsertNum = batchInsertData(basicList);
			logger.info("end batch save basic , count:" + basicInsertNum);
		}
		if (baxxList.size() > 0) {
			this.setListTaskId(baxxList);
			UserLogRecord.record("批量新增企业高管信息", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			int baxxInsertNum = batchInsertData(baxxList);
			logger.info("end batch save baxx , count:" + baxxInsertNum);
		}
		if (gdxxList.size() > 0) {
			this.setListTaskId(gdxxList);
			UserLogRecord.record("批量新增企业股东信息", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			int gdxxInsertNum = batchInsertData(gdxxList);
			logger.info("end batch save gdxx , count:" + gdxxInsertNum);
		}
		if (zhuanliList.size() > 0) {
			this.setListTaskId(zhuanliList);
			UserLogRecord.record("批量新增企业专利信息", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			int zhuanliInsertNum = batchInsertData(zhuanliList);
			logger.info("end batch save zhuanli , count:" + zhuanliInsertNum);
		}
		if (rmfyggList.size() > 0) {
			this.setListTaskId(rmfyggList);
			UserLogRecord.record("批量新增人民法院公告", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			int rmfyggInsertNum = batchInsertData(rmfyggList);
			logger.info("end batch save rmfygg , count:" + rmfyggInsertNum);
		}
		if (zgcpwswList.size() > 0) {
			this.setListTaskId(zgcpwswList);
			UserLogRecord.record("批量新增中国裁判文书", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			int zgcpwswInsertNum = batchInsertData(zgcpwswList);
			logger.info("end batch save zgcpwsw , count:" + zgcpwswInsertNum);
		}
		if (zhixingList.size() > 0) {
			this.setListTaskId(zhixingList);
			UserLogRecord.record("批量新增执行", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			int zhixingInsertNum = batchInsertData(zhixingList);
			logger.info("end batch save zhixing , count:" + zhixingInsertNum);
		}
		if (recruitIndexList.size() > 0) {
			UserLogRecord.record("批量新增招聘指数", Operation.Type.add, Operation.Page.hologram, Operation.System.back);
			int insertNum = batchInsertData(recruitIndexList);
			logger.info("end batch save recruitIndex , count:" + insertNum);
		}

	}

	public Integer batchInsertData(Object obj) {
		int updateNum = 0;
		if (obj instanceof List) {
			List list = (List) obj;
			if (list.size() > 0) {
				Object o = list.get(0);
				int pointsDataLimit = 1000;// 限制条数
				Integer size = list.size();
				if (o instanceof DishonestyDO) {
					List<DishonestyDO> dataList = (List<DishonestyDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<DishonestyDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveDishonestyDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveDishonestyDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveDishonestyDO(dataList);
					}
				} else if (o instanceof KtggDO) {
					List<KtggDO> dataList = (List<KtggDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<KtggDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveKtggDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveKtggDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveKtggDO(dataList);
					}
				} else if (o instanceof QyxgYuqingDO) {
					List<QyxgYuqingDO> dataList = (List<QyxgYuqingDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<QyxgYuqingDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveQyxgYuqingDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveQyxgYuqingDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveQyxgYuqingDO(dataList);
					}
				} else if (o instanceof QyxxBasicDO) {
					List<QyxxBasicDO> dataList = (List<QyxxBasicDO>) list;
					CompanyImportAssist.insertCompany(list); //将其中的新企业添加到company表
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<QyxxBasicDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveQyxxBasicDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveQyxxBasicDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveQyxxBasicDO(dataList);
					}
				} else if (o instanceof QyxxBaxxDO) {
					List<QyxxBaxxDO> dataList = (List<QyxxBaxxDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<QyxxBaxxDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveQyxxBaxxDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveQyxxBaxxDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveQyxxBaxxDO(dataList);
					}
				} else if (o instanceof QyxxGdxxDO) {
					List<QyxxGdxxDO> dataList = (List<QyxxGdxxDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<QyxxGdxxDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveQyxxGdxxDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveQyxxGdxxDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveQyxxGdxxDO(dataList);
					}
				} else if (o instanceof QyxxZhuanliDO) {
					List<QyxxZhuanliDO> dataList = (List<QyxxZhuanliDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<QyxxZhuanliDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveQyxxZhuanliDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveQyxxZhuanliDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveQyxxZhuanliDO(dataList);
					}
				} else if (o instanceof RmfyggDO) {
					List<RmfyggDO> dataList = (List<RmfyggDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<RmfyggDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveRmfyggDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						// 剩下的数据
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveRmfyggDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveRmfyggDO(dataList);
					}
				} else if (o instanceof ZgcpwswDO) {
					List<ZgcpwswDO> dataList = (List<ZgcpwswDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<ZgcpwswDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveZgcpwswDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						// 剩下的数据
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveZgcpwswDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveZgcpwswDO(dataList);
					}
				} else if (o instanceof ZhixingDO) {
					List<ZhixingDO> dataList = (List<ZhixingDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<ZhixingDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveZhixingDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						// 剩下的数据
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveZhixingDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveZhixingDO(dataList);
					}
				} else if (o instanceof RecruitIndexDO) {
					List<RecruitIndexDO> dataList = (List<RecruitIndexDO>) list;
					if (pointsDataLimit < size) {
						int part = size / pointsDataLimit;// 分批数
						for (int i = 0; i < part; i++) {
							List<RecruitIndexDO> listPage = dataList.subList(0, pointsDataLimit);
							updateNum += dataLoadingMapper.saveRecruitIndexDO(listPage);
							dataList.subList(0, pointsDataLimit).clear();
						}
						// 剩下的数据
						if (!dataList.isEmpty()) {
							updateNum += dataLoadingMapper.saveRecruitIndexDO(dataList);
						}
					} else {
						updateNum += dataLoadingMapper.saveRecruitIndexDO(dataList);
					}
				}
			}
		}

		return updateNum;
	}

	public void setListTaskId(Object obj) {
		if (obj instanceof List) {
			List list = (List) obj;
			if (list.size() > 0) {
				Object o = list.get(0);
				int pointsDataLimit = 1000;// 限制条数
				Integer size = list.size();
				if (o instanceof DishonestyDO) {
					List<DishonestyDO> dataList = (List<DishonestyDO>) list;
					for (DishonestyDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else if (o instanceof KtggDO) {
					List<KtggDO> dataList = (List<KtggDO>) list;
					for (KtggDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else if (o instanceof QyxgYuqingDO) {
					List<QyxgYuqingDO> dataList = (List<QyxgYuqingDO>) list;
					for (QyxgYuqingDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else if (o instanceof QyxxBasicDO) {
					List<QyxxBasicDO> dataList = (List<QyxxBasicDO>) list;
					for (QyxxBasicDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else if (o instanceof QyxxBaxxDO) {
					List<QyxxBaxxDO> dataList = (List<QyxxBaxxDO>) list;
					for (QyxxBaxxDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else if (o instanceof QyxxGdxxDO) {
					List<QyxxGdxxDO> dataList = (List<QyxxGdxxDO>) list;
					for (QyxxGdxxDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else if (o instanceof QyxxZhuanliDO) {
					List<QyxxZhuanliDO> dataList = (List<QyxxZhuanliDO>) list;
					for (QyxxZhuanliDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else if (o instanceof RmfyggDO) {
					List<RmfyggDO> dataList = (List<RmfyggDO>) list;
					for (RmfyggDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else if (o instanceof ZgcpwswDO) {
					List<ZgcpwswDO> dataList = (List<ZgcpwswDO>) list;
					for (ZgcpwswDO data : dataList) {
						data.setTask_id(taskId);
					}
				} else {
					List<ZhixingDO> dataList = (List<ZhixingDO>) list;
					for (ZhixingDO data : dataList) {
						data.setTask_id(taskId);
					}
				}
			}
		}

	}

	@Override
	public String getTaskKey() {
		return "holographicAndOpinionJob";
	}

	@Override
	public String getTaskGroup() {
		return "bbd_work";
	}

	@Override
	public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
		TaskResultDO taskResultDO = dataLoadingAutomaticOperate(taskId);
		return taskResultDO;
	}

	@Override
	public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {
		TaskResultDO taskResultDO = dataLoadingManualOperate(oldTaskId, newTaskId);
		return taskResultDO;
	}

	@Override
	public void stopExecute(Integer taskId) {
		stopTask();
	}

	@Override
	public void resetTask() {
		this.isShutdown = false;
	}
}
