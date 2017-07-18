package com.bbd.bgo.service.task;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.DataLoadingFailInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.dataLoading.*;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.mapper.DataLoadingFailInfoMapper;
import com.bbd.wtyh.mapper.DataLoadingMapper;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.util.DataLoadingUtil;
import com.bbd.wtyh.util.PullFileUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-18 9:53.
 */
@Service
public class DataLoadingServiceImpl extends BaseServiceImpl implements DataLoadingService {

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
	private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;
	@Autowired
	private DataLoadingFailInfoMapper dataLoadingFailInfoMapper;

	@Override
	public Map<String,Integer> dataLoadingManualOperate(Integer taskId) {
		this.taskId = taskId;
		//手动执行，查询之前任务失败记录，更新插入失败表
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		List<DataLoadingFailInfoDO> failList = dataLoadingFailInfoMapper.getDataLoadingFailInfoByTaskId(taskId);
		//上次出错,只跑错误部分数据
		if(null!=failList&&failList.size()>0){
			List<String> failTableList=new ArrayList<String>();
			for(DataLoadingFailInfoDO fail:failList){
				failTableList.add(fail.getTableName());
			}
			List<File> fileList=new ArrayList<File>();
			Integer pullFileTaskId=failList.get(0).getPullFileTaskId();
			this.pullFileTaskId=pullFileTaskId;
			List<DatasharePullFileDO> pullFileList = dataLoadingMapper.getDatasharePullFileByTaskId(pullFileTaskId);
			if(null!=pullFileList&&pullFileList.size()>0){
				for(DatasharePullFileDO pullFile:pullFileList){
					File file=new File(pullFile.getFile_url());
					if(file.exists()){
						fileList.add(file);
					}
				}
			}
			//operateUpdate(failTableList,Arrays.asList(file.listFiles()));
			operateUpdate(failTableList,fileList,returnMap);
		}
		return returnMap;
	}

	@Override
	public Map<String,Integer> dataLoadingAutomaticOperate(Integer taskId) {
		this.taskId = taskId;
		this.pullFileTaskId=taskId;
		//自动执行，先拉取数据，有数据执行插入，并记录成功失败情况
		Map<String,Integer> returnMap = new HashMap<String,Integer>();
		List<File> list = null;
		try {
			list = PullFileUtil.getFileList(1);
			//File file = new File("D:\\wtyh\\datashare\\data\\data-share-file\\wtyh\\hologram-base");
			//list = Arrays.asList(file.listFiles());
		} catch (Exception e) {
			returnMap.put("fail",10);
			returnMap.put("success",0);
			e.printStackTrace();
		}
		if(null!=list&&list.size()>0){
			List<DatasharePullFileDO> fileList = new ArrayList<DatasharePullFileDO>();
			for(File file:list){
				DatasharePullFileDO pullFile = new DatasharePullFileDO();
				pullFile.setCreate_by("system");
				pullFile.setTask_id(taskId);
				pullFile.setFile_name(file.getName());
				pullFile.setFile_url(file.getAbsolutePath());
				fileList.add(pullFile);
			}
			dataLoadingMapper.saveDatasharePullFileDO(fileList);
			operateUpdate(null,list,returnMap);
		}
		return returnMap;
	}

	public void operateUpdate(List<String> failTableList,List<File> fileList,Map<String,Integer> returnMap){
		//删除失败表数据
		if(null!=failTableList&&failTableList.size()>0){
			for(String tableName:failTableList){
				logger.info("start delete from "+tableName+" where task_id="+taskId);
				int deleteNum = this.executeCUD("delete from "+tableName+" where task_id = "+taskId);
				logger.info("end delete from "+tableName+" where task_id="+taskId+",delete number:"+deleteNum);
			}
		}
		List<String> list = DataLoadingUtil.txt2String(fileList);
		List<DishonestyDO> disList=new ArrayList<DishonestyDO>();
		List<KtggDO> ktggList=new ArrayList<KtggDO>();
		List<QyxgYuqingDO> yuQingList=new ArrayList<QyxgYuqingDO>();
		List<QyxxBasicDO> basicList=new ArrayList<QyxxBasicDO>();
		List<QyxxBaxxDO> baxxList=new ArrayList<QyxxBaxxDO>();
		List<QyxxGdxxDO> gdxxList=new ArrayList<QyxxGdxxDO>();
		List<QyxxZhuanliDO> zhuanliList=new ArrayList<QyxxZhuanliDO>();
		List<RmfyggDO> rmfyggList=new ArrayList<RmfyggDO>();
		List<ZgcpwswDO> zgcpwswList=new ArrayList<ZgcpwswDO>();
		List<ZhixingDO> zhixingList=new ArrayList<ZhixingDO>();
		for(String s:list){
			//解析json错误
			try {
				JSONObject jsonObject = JSONObject.fromObject(s);
				Object data = jsonObject.get("data");
				String tn = String.valueOf(jsonObject.get("tn"));
				JSONObject jsonData = JSONObject.fromObject(String.valueOf(data));
				Object dataName = jsonData.get(tn);
				String dataStr = String.valueOf(dataName);
				DataLoadingUtil.addDataToList(failTableList,tn,dataStr,disList,ktggList,yuQingList,basicList,baxxList,gdxxList,
						zhuanliList,rmfyggList,zgcpwswList,zhixingList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Map<String,Integer> successMap = insertData(disList,ktggList,yuQingList,basicList,baxxList,gdxxList,
				zhuanliList,rmfyggList,zgcpwswList,zhixingList);
		List<String> failTables=new ArrayList<String>();
		for (String key : successMap.keySet()) {
			if(successMap.get(key)==0){
				failTables.add(key);
			}
		}
		int successNum = 10-failTables.size();
		returnMap.put("fail",failTables.size());
		returnMap.put("success",successNum);
		//TaskSuccessFailInfoDO taskSuccessFailInfoDO = new TaskSuccessFailInfoDO();
		//taskSuccessFailInfoDO.setTaskName(TASK_NAME);
		//taskSuccessFailInfoDO.setTaskGroup(TASK_GROUP);
		//taskSuccessFailInfoDO.setDataVersion(dataVersion);
		//taskSuccessFailInfoDO.setSuccessCount(successNum);
		//taskSuccessFailInfoDO.setFailCount(failTables.size());
		//taskSuccessFailInfoDO.setCreateBy("system");
		//taskSuccessFailInfoDO.setCreateDate(new Date());
		//int id = taskSuccessFailInfoMapper.addTaskSuccessFailInfo(taskSuccessFailInfoDO);
		//手动执行时，更新task表记录，删除失败表记录，新增本次失败记录
		if(null != failTableList){
			TaskSuccessFailInfoDO taskDo = taskSuccessFailInfoMapper.getTaskInfoById(taskId);
			if(null!=taskDo){
				taskDo.setUpdateBy("system");
				taskDo.setUpdateDate(new Date());
				taskDo.setSuccessCount(taskDo.getSuccessCount()+(taskDo.getFailCount()-failTableList.size()));
				taskDo.setFailCount(failTableList.size());
				taskSuccessFailInfoMapper.updateTaskSuccessFailInfo(taskDo);
			}
		}
		this.executeCUD("delete from data_loading_fail_info where task_id = "+taskId);
		logger.info("add data loading task to taskSuccessFailInfo table");
		for(String table:failTables){
			DataLoadingFailInfoDO fail = new DataLoadingFailInfoDO();
			fail.setTaskId(taskId);
			fail.setTableName(table);
			//fail.setDataVersion(dataVersion);
			fail.setCreateBy("system");
			fail.setCreateDate(new Date());
			fail.setPullFileTaskId(pullFileTaskId);
			dataLoadingFailInfoMapper.addTaskFailInfo(fail);
		}
	}

	public Map<String,Integer> insertData(List<DishonestyDO> disList,List<KtggDO> ktggList,
						   List<QyxgYuqingDO> yuQingList,List<QyxxBasicDO> basicList,List<QyxxBaxxDO> baxxList, List<QyxxGdxxDO> gdxxList,
						   List<QyxxZhuanliDO> zhuanliList,List<RmfyggDO> rmfyggList, List<ZgcpwswDO> zgcpwswList,List<ZhixingDO> zhixingList){
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put(DISHONESTY,1);
		if(disList.size()>0){
			try {
				UserLogRecord.record("批量新增失信被执行人", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				this.setListTaskId(disList);
				int disSourceNum = disList.size();
				//int disNum = dataLoadingMapper.saveDishonestyDO(disList);
				int disInsertNum = batchInsertData(disList);
				logger.info("end batch save Dishonesty , count:"+disInsertNum);
				if(disInsertNum!=disSourceNum){
					map.put(DISHONESTY,0);
				}
			} catch (Exception e) {
				logger.info("end batch save Dishonesty because of error,e:"+e);
				map.put(DISHONESTY,0);
			}
		}
		map.put(KTGG,1);
		if(ktggList.size()>0){
			try {
				UserLogRecord.record("批量新增开庭公告", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				//int ktggNum = dataLoadingMapper.saveKtggDO(ktggList);
				this.setListTaskId(ktggList);
				int ktggSourceNum = ktggList.size();
				int ktggInsertNum = batchInsertData(ktggList);
				logger.info("end batch save ktgg , count:"+ ktggInsertNum);
				if(ktggSourceNum!=ktggInsertNum){
					map.put(KTGG,0);
				}
			} catch (Exception e) {
				map.put(KTGG,0);
				logger.info("end batch save ktgg because of error,e:"+e);
			}
		}
		map.put(QYXG_YUQING,1);
		if(yuQingList.size()>0){
			try {
				UserLogRecord.record("批量新增舆情", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				this.setListTaskId(yuQingList);
				//int yuqingNum = dataLoadingMapper.saveQyxgYuqingDO(yuQingList);
				int yuQingSourceNum = yuQingList.size();
				int yuQingInsertNum = batchInsertData(yuQingList);
				logger.info("end batch save Yuqing , count:"+ yuQingInsertNum);
				if(yuQingSourceNum!=yuQingInsertNum){
					map.put(KTGG,0);
				}
			} catch (Exception e) {
				map.put(QYXG_YUQING,0);
				logger.info("end batch save Yuqing because of error,e:"+e);
			}
		}
		map.put(QYXX__BASIC,1);
		if(basicList.size()>0){
			try {
				int basicSourceNum = basicList.size();
				this.setListTaskId(basicList);
				UserLogRecord.record("批量新增企业基础信息", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				//int basicNum = dataLoadingMapper.saveQyxxBasicDO(basicList);
				int basicInsertNum = batchInsertData(basicList);
				if(basicInsertNum != basicSourceNum){
					map.put(QYXX__BASIC,0);
				}
				logger.info("end batch save basic , count:"+ basicInsertNum);
			} catch (Exception e) {
				map.put(QYXX__BASIC,0);
				logger.info("end batch save basic because of error,e:"+e);
			}
		}
		map.put(QYXX_BAXX,1);
		if(baxxList.size()>0){
			try {
				this.setListTaskId(baxxList);
				UserLogRecord.record("批量新增企业高管信息", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int baxxSourceNum = baxxList.size();
				int baxxInsertNum = batchInsertData(baxxList);
				logger.info("end batch save baxx , count:"+ baxxInsertNum);
				if(baxxInsertNum!=baxxSourceNum){
					map.put(QYXX_BAXX,0);
				}
			} catch (Exception e) {
				map.put(QYXX_BAXX,0);
				logger.info("end batch save baxx because of error,e:"+e);
			}
		}
		map.put(QYXX_GDXX,1);
		if(gdxxList.size()>0){
			try {
				this.setListTaskId(gdxxList);
				UserLogRecord.record("批量新增企业股东信息", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int gdxxSourceNum = gdxxList.size();
				int gdxxInsertNum = batchInsertData(gdxxList);
				logger.info("end batch save gdxx , count:"+ gdxxInsertNum);
				if(gdxxInsertNum!=gdxxSourceNum){
					map.put(QYXX_GDXX,0);
				}
			} catch (Exception e) {
				map.put(QYXX_GDXX,0);
				logger.info("end batch save gdxx because of error,e:"+e);
			}
		}
		map.put(QYXX_ZHUANLI,1);
		if(zhuanliList.size()>0){
			try {
				this.setListTaskId(zhuanliList);
				UserLogRecord.record("批量新增企业专利信息", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int zhuanliSourceNum = zhuanliList.size();
				int zhuanliInsertNum = batchInsertData(zhuanliList);
				logger.info("end batch save zhuanli , count:"+ zhuanliInsertNum);
				if(zhuanliSourceNum!=zhuanliInsertNum){
					map.put(QYXX_ZHUANLI,0);
				}
			} catch (Exception e) {
				map.put(QYXX_ZHUANLI,0);
				logger.info("end batch save zhuanli because of error,e:"+e);
			}
		}
		map.put(RMFYGG,1);
		if(rmfyggList.size()>0) {
			try {
				this.setListTaskId(rmfyggList);
				UserLogRecord.record("批量新增人民法院公告", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int rmfyggSourceNum = rmfyggList.size();
				int rmfyggInsertNum = batchInsertData(rmfyggList);
				logger.info("end batch save rmfygg , count:"+ rmfyggInsertNum);
				if(rmfyggSourceNum!=rmfyggInsertNum){
					map.put(RMFYGG,0);
				}
			} catch (Exception e) {
				map.put(RMFYGG,0);
				logger.info("end batch save rmfygg because of error,e:"+e);
			}
		}
		map.put(ZGCPWSW,1);
		if(zgcpwswList.size()>0){
			try {
				this.setListTaskId(zgcpwswList);
				UserLogRecord.record("批量新增中国裁判文书", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int zgcpwswSourceNum=zgcpwswList.size();
				int zgcpwswInsertNum = batchInsertData(zgcpwswList);
				if(zgcpwswSourceNum != zgcpwswInsertNum){
					map.put(ZGCPWSW,0);
				}
				logger.info("end batch save zgcpwsw , count:"+ zgcpwswInsertNum);
			} catch (Exception e) {
				map.put(ZGCPWSW,0);
				logger.info("end batch save zgcpwsw because of error,e:"+e);
			}
		}
		map.put(ZHIXING,1);
		if(zhixingList.size()>0){
			try {
				this.setListTaskId(zhixingList);
				UserLogRecord.record("批量新增执行", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int zhixingSourceNum = zhixingList.size();
				int zhixingInsertNum = batchInsertData(zhixingList);
				logger.info("end batch save zhixing , count:"+ zhixingInsertNum);
				if(zhixingSourceNum!=zhixingInsertNum){
					map.put(ZHIXING,0);
				}
			} catch (Exception e) {
				map.put(ZHIXING,0);
				logger.info("end batch save zhixing because of error,e:"+e);
			}
		}
		return map;
	}

	public Integer batchInsertData(Object obj){
		int updateNum = 0;
		if(obj instanceof List){
			List list = (List)obj;
			if(list.size()>0){
				Object o = list.get(0);
				int pointsDataLimit = 1000;//限制条数
				Integer size = list.size();
				if(o instanceof DishonestyDO){
					List<DishonestyDO> dataList = (List<DishonestyDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<DishonestyDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveDishonestyDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveDishonestyDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveDishonestyDO(dataList);
					}
				}else if(o instanceof KtggDO){
					List<KtggDO> dataList = (List<KtggDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<KtggDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveKtggDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveKtggDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveKtggDO(dataList);
					}
				}else if(o instanceof QyxgYuqingDO){
					List<QyxgYuqingDO> dataList = (List<QyxgYuqingDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<QyxgYuqingDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveQyxgYuqingDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveQyxgYuqingDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveQyxgYuqingDO(dataList);
					}
				}else if(o instanceof QyxxBasicDO){
					List<QyxxBasicDO> dataList = (List<QyxxBasicDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<QyxxBasicDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveQyxxBasicDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveQyxxBasicDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveQyxxBasicDO(dataList);
					}
				}else if(o instanceof QyxxBaxxDO){
					List<QyxxBaxxDO> dataList = (List<QyxxBaxxDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<QyxxBaxxDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveQyxxBaxxDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveQyxxBaxxDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveQyxxBaxxDO(dataList);
					}
				}else if(o instanceof QyxxGdxxDO){
					List<QyxxGdxxDO> dataList = (List<QyxxGdxxDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<QyxxGdxxDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveQyxxGdxxDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveQyxxGdxxDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveQyxxGdxxDO(dataList);
					}
				}else if(o instanceof QyxxZhuanliDO){
					List<QyxxZhuanliDO> dataList = (List<QyxxZhuanliDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<QyxxZhuanliDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveQyxxZhuanliDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveQyxxZhuanliDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveQyxxZhuanliDO(dataList);
					}
				}else if(o instanceof RmfyggDO){
					List<RmfyggDO> dataList = (List<RmfyggDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<RmfyggDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveRmfyggDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						//剩下的数据
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveRmfyggDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveRmfyggDO(dataList);
					}
				}else if(o instanceof ZgcpwswDO){
					List<ZgcpwswDO> dataList = (List<ZgcpwswDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<ZgcpwswDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveZgcpwswDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						//剩下的数据
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveZgcpwswDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveZgcpwswDO(dataList);
					}
				}else{
					List<ZhixingDO> dataList = (List<ZhixingDO>)list;
					if(pointsDataLimit<size){
						int part = size/pointsDataLimit;//分批数
						for(int i=0;i<part;i++){
							List<ZhixingDO> listPage = dataList.subList(0,pointsDataLimit);
							updateNum+=dataLoadingMapper.saveZhixingDO(listPage);
							dataList.subList(0,pointsDataLimit).clear();
						}
						//剩下的数据
						if(!dataList.isEmpty()){
							updateNum+=dataLoadingMapper.saveZhixingDO(dataList);
						}
					}else{
						updateNum+=dataLoadingMapper.saveZhixingDO(dataList);
					}
				}
			}
		}


		return updateNum;
	}

	public void setListTaskId(Object obj){
		if(obj instanceof List){
			List list = (List)obj;
			if(list.size()>0){
				Object o = list.get(0);
				int pointsDataLimit = 1000;//限制条数
				Integer size = list.size();
				if(o instanceof DishonestyDO){
					List<DishonestyDO> dataList = (List<DishonestyDO>)list;
					for(DishonestyDO data:dataList){
						data.setTask_id(taskId);
					}
				}else if(o instanceof KtggDO){
					List<KtggDO> dataList = (List<KtggDO>)list;
					for(KtggDO data:dataList){
						data.setTask_id(taskId);
					}
				}else if(o instanceof QyxgYuqingDO){
					List<QyxgYuqingDO> dataList = (List<QyxgYuqingDO>)list;
					for(QyxgYuqingDO data:dataList){
						data.setTask_id(taskId);
					}
				}else if(o instanceof QyxxBasicDO){
					List<QyxxBasicDO> dataList = (List<QyxxBasicDO>)list;
					for(QyxxBasicDO data:dataList){
						data.setTask_id(taskId);
					}
				}else if(o instanceof QyxxBaxxDO){
					List<QyxxBaxxDO> dataList = (List<QyxxBaxxDO>)list;
					for(QyxxBaxxDO data:dataList){
						data.setTask_id(taskId);
					}
				}else if(o instanceof QyxxGdxxDO){
					List<QyxxGdxxDO> dataList = (List<QyxxGdxxDO>)list;
					for(QyxxGdxxDO data:dataList){
						data.setTask_id(taskId);
					}
				}else if(o instanceof QyxxZhuanliDO){
					List<QyxxZhuanliDO> dataList = (List<QyxxZhuanliDO>)list;
					for(QyxxZhuanliDO data:dataList){
						data.setTask_id(taskId);
					}
				}else if(o instanceof RmfyggDO){
					List<RmfyggDO> dataList = (List<RmfyggDO>)list;
					for(RmfyggDO data:dataList){
						data.setTask_id(taskId);
					}
				}else if(o instanceof ZgcpwswDO){
					List<ZgcpwswDO> dataList = (List<ZgcpwswDO>)list;
					for(ZgcpwswDO data:dataList){
						data.setTask_id(taskId);
					}
				}else{
					List<ZhixingDO> dataList = (List<ZhixingDO>)list;
					for(ZhixingDO data:dataList){
						data.setTask_id(taskId);
					}
				}
			}
		}

	}


}
