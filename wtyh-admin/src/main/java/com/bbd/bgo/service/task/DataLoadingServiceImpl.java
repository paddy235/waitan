package com.bbd.bgo.service.task;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.DataLoadingFailInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.dataLoading.*;
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

	private static String TASK_NAME = "shangHaiCreditJob";

	private static String TASK_GROUP = "data_loading";

    @Autowired
    private DataLoadingMapper dataLoadingMapper;
	@Autowired
	private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;
	@Autowired
	private DataLoadingFailInfoMapper dataLoadingFailInfoMapper;


	@Override
	public void dataLoading() {
		String dataVersion = DateFormatUtils.format(new Date(), "yyyyMMdd");
		//taskSuccessFailInfoMapper.getTaskSuccessFailInfo()
		List<String> list = txt2String(new File(FILE_PATH));
		Gson gson = new Gson();
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
				String bbd_qyxx_id = String.valueOf(jsonObject.get("bbd_qyxx_id"));
				JSONObject jsonData = JSONObject.fromObject(String.valueOf(data));
				Object dataName = jsonData.get(tn);
				String dataStr = String.valueOf(dataName);
				addDataToList(gson,tn,dataStr,bbd_qyxx_id,disList,ktggList,yuQingList,basicList,baxxList,gdxxList,
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
		map.put("dishonesty",1);
		map.put("ktgg",1);
		map.put("qyxg_yuqing",1);
		map.put("qyxx_basic",1);
		map.put("qyxx_baxx",1);
		map.put("qyxx_gdxx",1);
		map.put("qyxx_zhuanli",1);
		map.put("zgcpwsw",1);
		map.put("zhixing",1);
		map.put("rmfygg",1);
		if(disList.size()>0){
			try {
				dataLoadingMapper.saveDishonestyDO(disList);
			} catch (Exception e) {
				map.put("dishonesty",0);
				e.printStackTrace();
			}
		}
		if(ktggList.size()>0){
			try {
				dataLoadingMapper.saveKtggDO(ktggList);
			} catch (Exception e) {
				map.put("ktgg",0);
				e.printStackTrace();
			}
		}
		if(yuQingList.size()>0){
			try {
				dataLoadingMapper.saveQyxgYuqingDO(yuQingList);
			} catch (Exception e) {
				map.put("qyxg_yuqing",0);
				e.printStackTrace();
			}
		}
		if(basicList.size()>0){
			try {
				dataLoadingMapper.saveQyxxBasicDO(basicList);
			} catch (Exception e) {
				map.put("qyxx_basic",0);
				e.printStackTrace();
			}
		}

		if(baxxList.size()>0){
			try {
				dataLoadingMapper.saveQyxxBaxxDO(baxxList);
			} catch (Exception e) {
				map.put("qyxx_baxx",0);
				e.printStackTrace();
			}
		}

		if(gdxxList.size()>0){
			try {
				dataLoadingMapper.saveQyxxGdxxDO(gdxxList);
			} catch (Exception e) {
				map.put("qyxx_gdxx",0);
				e.printStackTrace();
			}
		}

		if(zhuanliList.size()>0){
			try {
				dataLoadingMapper.saveQyxxZhuanliDO(zhuanliList);
			} catch (Exception e) {
				map.put("qyxx_zhuanli",0);
				e.printStackTrace();
			}
		}
		if(rmfyggList.size()>0) {
			try {
				dataLoadingMapper.saveRmfyggDO(rmfyggList);
			} catch (Exception e) {
				map.put("rmfygg",0);
				e.printStackTrace();
			}
		}
		if(zgcpwswList.size()>0){
			try {
				dataLoadingMapper.saveZgcpwswDO(zgcpwswList);
			} catch (Exception e) {
				map.put("zgcpwsw",0);
				e.printStackTrace();
			}
		}

		if(zhixingList.size()>0){
			try {
				dataLoadingMapper.saveZhixingDO(zhixingList);
			} catch (Exception e) {
				map.put("zhixing",10);
				e.printStackTrace();
			}
		}
		return map;
	}

	public void addDataToList(Gson gson,String tn,String dataStr,String bbd_qyxx_id,List<DishonestyDO> disList,List<KtggDO> ktggList,
							  List<QyxgYuqingDO> yuQingList,List<QyxxBasicDO> basicList,List<QyxxBaxxDO> baxxList, List<QyxxGdxxDO> gdxxList,
							  List<QyxxZhuanliDO> zhuanliList,List<RmfyggDO> rmfyggList, List<ZgcpwswDO> zgcpwswList,List<ZhixingDO> zhixingList){
		switch (tn){
			case "dishonesty" :
				List<DishonestyDO> dataList1 = gson.fromJson(dataStr, new TypeToken<List<DishonestyDO>>() {}.getType());
				for(DishonestyDO data:dataList1){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				disList.addAll(dataList1);
				break;
			case "ktgg" :
				List<KtggDO> dataList2 = gson.fromJson(dataStr, new TypeToken<List<KtggDO>>() {}.getType());
				for(KtggDO data:dataList2){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				ktggList.addAll(dataList2);
				break;
			case "qyxg_yuqing" :
				List<QyxgYuqingDO> dataList3 = gson.fromJson(dataStr, new TypeToken<List<QyxgYuqingDO>>() {}.getType());
				for(QyxgYuqingDO data:dataList3){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				yuQingList.addAll(dataList3);
				break;
			case "qyxx_basic" :
				List<QyxxBasicDO> dataList4 = gson.fromJson(dataStr, new TypeToken<List<QyxxBasicDO>>() {}.getType());
				for(QyxxBasicDO data:dataList4){
					data.setBbd_qyxx_id(bbd_qyxx_id);
					StringBuffer history_name = new StringBuffer();
					for(String s:data.getBbd_history_name()){
						history_name.append(s);
					}
					data.setBbd_history_names(history_name.toString());
				}
				basicList.addAll(dataList4);
				break;
			case "qyxx_baxx" :
				List<QyxxBaxxDO> dataList5 = gson.fromJson(dataStr, new TypeToken<List<QyxxBaxxDO>>() {}.getType());
				for(QyxxBaxxDO data:dataList5){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				baxxList.addAll(dataList5);
				break;
			case "qyxx_gdxx" :
				List<QyxxGdxxDO> dataList6 = gson.fromJson(dataStr, new TypeToken<List<QyxxGdxxDO>>() {}.getType());
				for(QyxxGdxxDO data:dataList6){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				gdxxList.addAll(dataList6);
				break;
			case "qyxx_zhuanli" :
				List<QyxxZhuanliDO> dataList7 = gson.fromJson(dataStr, new TypeToken<List<QyxxZhuanliDO>>() {}.getType());
				for(QyxxZhuanliDO data:dataList7){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				zhuanliList.addAll(dataList7);
				break;
			case "rmfygg" :
				List<RmfyggDO> dataList8 = gson.fromJson(dataStr, new TypeToken<List<RmfyggDO>>() {}.getType());
				for(RmfyggDO data:dataList8){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				rmfyggList.addAll(dataList8);
				break;
			case "zgcpwsw" :
				List<ZgcpwswDO> dataList9 = gson.fromJson(dataStr, new TypeToken<List<ZgcpwswDO>>() {}.getType());
				for(ZgcpwswDO data:dataList9){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				zgcpwswList.addAll(dataList9);
				break;
			case "zhixing" :
				List<ZhixingDO> dataList10 = gson.fromJson(dataStr, new TypeToken<List<ZhixingDO>>() {}.getType());
				for(ZhixingDO data:dataList10){
					data.setBbd_qyxx_id(bbd_qyxx_id);
				}
				zhixingList.addAll(dataList10);
				break;
		}
	}

	public List<String> txt2String(File file){
		if(null == file || !file.exists()){
			return null;
		}
		List<String> list=new ArrayList<String>();
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
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
		return list;
	}
}
