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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
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
public class DataLoadingServiceImpl extends BaseServiceImpl implements DataLoadingTaskService {

	private static final Logger logger = LoggerFactory.getLogger(DataLoadingServiceImpl.class);

	private static final String FILE_PATH = "C:\\\\Users\\\\ibm\\\\Desktop\\\\changjiang_20170704_test.test";

	private static String TASK_NAME = "holographicNewsDataLoading";

	private static String TASK_GROUP = "bbd_work";

	private static final String DISHONESTY = "dishonesty";
	private static final String KTGG = "ktgg";
	private static final String QYXG_YUQING = "qyxg_yuqing";
	private static final String QYXX__BASIC = "qyxx_basic";
	private static final String QYXX_BAXX = "qyxx_baxx";
	private static final String QYXX_GDXX = "qyxx_gdxx";
	private static final String QYXX_ZHUANLI = "qyxx_zhuanli";
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
	public void dataLoading() {
		TaskSuccessFailInfoDO task = taskSuccessFailInfoMapper.getTaskRecentInfo(TASK_NAME,TASK_GROUP);
		//首次跑全量数据
		if(task==null){
			operateUpdate(null);
		}
		//已跑过，且上次出错,只跑错误部分数据
		if(null!=task&&task.getFailCount()>0){
			List<DataLoadingFailInfoDO> failList = dataLoadingFailInfoMapper.getDataLoadingFailInfoByTaskId(task.getId());
			List<String> failTableList=new ArrayList<String>();
			for(DataLoadingFailInfoDO fail:failList){
				failTableList.add(fail.getTableName());
			}
			operateUpdate(failTableList);
		}
	}

	public void operateUpdate(List<String> failTableList){
		String dataVersion = DateFormatUtils.format(new Date(), "yyyyMMdd");
		List<File> fileList=new ArrayList<File>();
		fileList.add(new File(FILE_PATH));
		List<String> list = txt2String(fileList);
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
		Gson gson = new Gson();
		for(String s:list){
			//解析json错误
			try {
				JSONObject jsonObject = JSONObject.fromObject(s);
				Object data = jsonObject.get("data");
				String tn = String.valueOf(jsonObject.get("tn"));
				//String bbd_qyxx_id = String.valueOf(jsonObject.get("bbd_qyxx_id"));
				JSONObject jsonData = JSONObject.fromObject(String.valueOf(data));
				Object dataName = jsonData.get(tn);
				String dataStr = String.valueOf(dataName);
				addDataToList(failTableList,gson,tn,dataStr,disList,ktggList,yuQingList,basicList,baxxList,gdxxList,
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
		TaskSuccessFailInfoDO taskSuccessFailInfoDO = new TaskSuccessFailInfoDO();
		taskSuccessFailInfoDO.setTaskName(TASK_NAME);
		taskSuccessFailInfoDO.setTaskGroup(TASK_GROUP);
		taskSuccessFailInfoDO.setDataVersion(dataVersion);
		taskSuccessFailInfoDO.setSuccessCount(successNum);
		taskSuccessFailInfoDO.setFailCount(failTables.size());
		taskSuccessFailInfoDO.setCreateBy("system");
		taskSuccessFailInfoDO.setCreateDate(new Date());
		logger.info("add data loading task to taskSuccessFailInfo table");
		int id = taskSuccessFailInfoMapper.addTaskSuccessFailInfo(taskSuccessFailInfoDO);
		for(String table:failTables){
			DataLoadingFailInfoDO fail = new DataLoadingFailInfoDO();
			fail.setTaskId(id);
			fail.setTableName(table);
			fail.setDataVersion(dataVersion);
			fail.setCreateBy("system");
			fail.setCreateDate(new Date());
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
				int disNum = dataLoadingMapper.saveDishonestyDO(disList);
				logger.info("end batch save Dishonesty , count:"+disNum);
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
				int ktggNum = dataLoadingMapper.saveKtggDO(ktggList);
				logger.info("end batch save ktgg , count:"+ ktggNum);
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
				int yuqingNum = dataLoadingMapper.saveQyxgYuqingDO(yuQingList);
				logger.info("end batch save Yuqing , count:"+ yuqingNum);
			} catch (Exception e) {
				map.put(QYXG_YUQING,0);
				logger.info("end batch save Yuqing because of error,e:"+e);
			}
		}
		map.put(QYXX__BASIC,1);
		if(basicList.size()>0){
			try {
				UserLogRecord.record("批量新增企业基础信息", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int basicNum = dataLoadingMapper.saveQyxxBasicDO(basicList);
				logger.info("end batch save basic , count:"+ basicNum);
			} catch (Exception e) {
				map.put(QYXX__BASIC,0);
				logger.info("end batch save basic because of error,e:"+e);
			}
		}
		map.put(QYXX_BAXX,1);
		if(baxxList.size()>0){
			try {
				UserLogRecord.record("批量新增企业高管信息", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int baxxNum = dataLoadingMapper.saveQyxxBaxxDO(baxxList);
				logger.info("end batch save baxx , count:"+ baxxNum);
			} catch (Exception e) {
				map.put(QYXX_BAXX,0);
				logger.info("end batch save baxx because of error,e:"+e);
			}
		}
		map.put(QYXX_GDXX,1);
		if(gdxxList.size()>0){
			try {
				UserLogRecord.record("批量新增企业股东信息", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int gdxxNum = dataLoadingMapper.saveQyxxGdxxDO(gdxxList);
				logger.info("end batch save gdxx , count:"+ gdxxNum);
			} catch (Exception e) {
				map.put(QYXX_GDXX,0);
				logger.info("end batch save gdxx because of error,e:"+e);
			}
		}
		map.put(QYXX_ZHUANLI,1);
		if(zhuanliList.size()>0){
			try {
				UserLogRecord.record("批量新增企业专利信息", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int zhuanliNum = dataLoadingMapper.saveQyxxZhuanliDO(zhuanliList);
				logger.info("end batch save zhuanli , count:"+ zhuanliNum);
			} catch (Exception e) {
				map.put(QYXX_ZHUANLI,0);
				logger.info("end batch save zhuanli because of error,e:"+e);
			}
		}
		map.put(RMFYGG,1);
		if(rmfyggList.size()>0) {
			try {
				UserLogRecord.record("批量新增人民法院公告", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int rmfyggNum = dataLoadingMapper.saveRmfyggDO(rmfyggList);
				logger.info("end batch save rmfygg , count:"+ rmfyggNum);
			} catch (Exception e) {
				map.put(RMFYGG,0);
				logger.info("end batch save rmfygg because of error,e:"+e);
			}
		}
		map.put(ZGCPWSW,1);
		if(zgcpwswList.size()>0){
			try {
				UserLogRecord.record("批量新增中国裁判文书", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int zgcpwswNum = dataLoadingMapper.saveZgcpwswDO(zgcpwswList);
				logger.info("end batch save zgcpwsw , count:"+ zgcpwswNum);
			} catch (Exception e) {
				map.put(ZGCPWSW,0);
				logger.info("end batch save zgcpwsw because of error,e:"+e);
			}
		}
		map.put(ZHIXING,1);
		if(zhixingList.size()>0){
			try {
				UserLogRecord.record("批量新增执行", Operation.Type.add, Operation.Page.hologram,
						Operation.System.back);
				int zhixingNum = dataLoadingMapper.saveZhixingDO(zhixingList);
				logger.info("end batch save zhixing , count:"+ zhixingNum);
			} catch (Exception e) {
				map.put(ZHIXING,10);
				logger.info("end batch save zhixing because of error,e:"+e);
			}
		}
		return map;
	}

	public void addDataToList(List<String> failTableList,Gson gson,String tn,String dataStr,List<DishonestyDO> disList,List<KtggDO> ktggList,
							  List<QyxgYuqingDO> yuQingList,List<QyxxBasicDO> basicList,List<QyxxBaxxDO> baxxList, List<QyxxGdxxDO> gdxxList,
							  List<QyxxZhuanliDO> zhuanliList,List<RmfyggDO> rmfyggList, List<ZgcpwswDO> zgcpwswList,List<ZhixingDO> zhixingList){

		if(null!=failTableList&&!failTableList.contains(tn)){
			return;
		}
		switch (tn){
			case DISHONESTY :
				List<DishonestyDO> dataList1 = gson.fromJson(dataStr, new TypeToken<List<DishonestyDO>>() {}.getType());
				disList.addAll(dataList1);
				break;
			case KTGG :
				List<KtggDO> dataList2 = gson.fromJson(dataStr, new TypeToken<List<KtggDO>>() {}.getType());
				ktggList.addAll(dataList2);
				break;
			case QYXG_YUQING:
				List<QyxgYuqingDO> dataList3 = gson.fromJson(dataStr, new TypeToken<List<QyxgYuqingDO>>() {}.getType());
				yuQingList.addAll(dataList3);
				break;
			case QYXX__BASIC :
				List<QyxxBasicDO> dataList4 = gson.fromJson(dataStr, new TypeToken<List<QyxxBasicDO>>() {}.getType());
				basicList.addAll(dataList4);
				break;
			case QYXX_BAXX :
				List<QyxxBaxxDO> dataList5 = gson.fromJson(dataStr, new TypeToken<List<QyxxBaxxDO>>() {}.getType());
				baxxList.addAll(dataList5);
				break;
			case QYXX_GDXX:
				List<QyxxGdxxDO> dataList6 = gson.fromJson(dataStr, new TypeToken<List<QyxxGdxxDO>>() {}.getType());
				gdxxList.addAll(dataList6);
				break;
			case QYXX_ZHUANLI :
				List<QyxxZhuanliDO> dataList7 = gson.fromJson(dataStr, new TypeToken<List<QyxxZhuanliDO>>() {}.getType());
				zhuanliList.addAll(dataList7);
				break;
			case RMFYGG :
				List<RmfyggDO> dataList8 = gson.fromJson(dataStr, new TypeToken<List<RmfyggDO>>() {}.getType());
				rmfyggList.addAll(dataList8);
				break;
			case ZGCPWSW :
				List<ZgcpwswDO> dataList9 = gson.fromJson(dataStr, new TypeToken<List<ZgcpwswDO>>() {}.getType());
				zgcpwswList.addAll(dataList9);
				break;
			case ZHIXING :
				List<ZhixingDO> dataList10 = gson.fromJson(dataStr, new TypeToken<List<ZhixingDO>>() {}.getType());
				zhixingList.addAll(dataList10);
				break;
		}
	}

	//文件转化为sring集合
	public List<String> txt2String(List<File> fileList){
		List<String> list=new ArrayList<String>();
		for(File file:fileList){
			if(null == file || !file.exists()){
				continue;
			}
			BufferedReader br = null;
			try{
				br = new BufferedReader(new FileReader(file));
				String s = null;
				while((s = br.readLine())!=null){//使用readLine方法，一次读一行
					list.add(s);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try{
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
