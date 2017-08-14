package com.bbd.bgo.service.task;


import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.service.impl.companyInfoModify.CompanyInfoMudifyUtil;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class PlatUpdateTaskServiceImpl extends BaseServiceImpl implements PlatUpdateTaskService,TaskService {

	private Logger logger = LoggerFactory.getLogger(PlatUpdateTaskServiceImpl.class);
	@Autowired
	private PlatformNameInformationMapper platformNameInformationMapper;
	@Autowired
	private TaskFailInfoMapper taskFailInfoMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private CompanyInfoMudifyUtil companyInfoMudifyUtil;

	private Integer taskId = null;

	private volatile boolean isShutdown = false;//任务停止标志

	@Override
	public void stopTask() {
		isShutdown = true;
	}
	/**
	 * 更新网贷平台与企业对照关系自动执行
	 */
	@Override
	@LogRecord(logMsg = "自动更新网贷平台：%s", params = {"loginName"}, page = Operation.Page.netLendingPlatform, type = Operation.Type.modify)
	public TaskResultDO updatePlatAutomaticOperate(Integer taskId) {
		return this.updatePlat(taskId,null);
	}

	/**
	 * 更新网贷平台与企业对照关系手动
	 */
	@Override
	@LogRecord(logMsg = "手动更新网贷平台：%s", params = {"loginName"}, page = Operation.Page.netLendingPlatform, type = Operation.Type.modify)
	public TaskResultDO updatePlatManualOperate(Integer oldTaskId,Integer newTaskId){
		return this.updatePlat(oldTaskId,newTaskId);
	}


	private TaskResultDO updatePlat(Integer oldTaskId,Integer newTaskId) {
		logger.info("--- platform job begin ---");
		isShutdown=false;
		TaskResultDO taskResultDO = new TaskResultDO();
		if(null==newTaskId){
			this.taskId=oldTaskId;
		}else{
			this.taskId=newTaskId;
		}
		Integer dataError = 0;
		Integer dataTotal = 0;
		//网贷平台拉取企业数据
		List<PlatListDO> platList= this.getPlatList();
		if(null==platList||platList.size()<1){
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(dataError);
			taskResultDO.setSuccessCount(dataTotal-dataError);
			return taskResultDO;
		}
		dataTotal = platList.size();
		//根据企业名称获取公司id
		List<PlatformNameInformationDO> platInfoList = new ArrayList<PlatformNameInformationDO>();
		//手动执行
		if(null!=newTaskId){
			List<TaskFailInfoDO> failList = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
			List<String> failStrList=new ArrayList<String>();
			for(TaskFailInfoDO fail:failList){
				if (isShutdown) {
					break;
				}
				failStrList.add(fail.getFailName());
			}
			List<String> failPlatList=new ArrayList<>();
			dataTotal = failList.size();
			Iterator<PlatListDO> it = platList.iterator();
			while(it.hasNext()){
				if (isShutdown) {
					break;
				}
				PlatListDO plat = it.next();
				if(!failStrList.contains(plat.getPlat_name())){
					it.remove();
				}
			}
		}
		this.setCompanyId(platList,platInfoList);
		dataError = platList.size()-platInfoList.size();
//		Collections.sort(platInfoList, new Comparator<PlatformNameInformationDO>() {
//			@Override
//			public int compare(PlatformNameInformationDO o1, PlatformNameInformationDO o2) {
//				return o1.getCompanyId()-o2.getCompanyId();
//			}
//		});
		Collections.sort(platInfoList,(o1,o2) -> o1.getCompanyId()-o2.getCompanyId());
		if(null==newTaskId){
			int delNum = this.executeCUD("delete from platform_name_information");
			logger.info("delete plat number:"+delNum);
		}
		dataError += updatePlatData(platInfoList);
		logger.info("end update plat,update number:"+(dataTotal-dataError));
		try {
			platformNameInformationMapper.deleteRepeatPlat();
		} catch (Exception e) {
			logger.info("delete repeat plat error");
		}
		if (isShutdown) {
			taskResultDO.setFailCount(0);
			taskResultDO.setSuccessCount(0);
		}else{
			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(dataError);
			taskResultDO.setSuccessCount(dataTotal-dataError);
		}
		logger.info("--- platform job end ---");
		return taskResultDO;
	}

	public void setCompanyId(List<PlatListDO> platList, List<PlatformNameInformationDO> platInfoList){
		List<String> names = new ArrayList<String>();
		PlatformNameInformationDO platInfo=null;
		for(PlatListDO plat:platList){
			platInfo=new PlatformNameInformationDO();
			platInfo.setName(plat.getCompany_name());
			platInfo.setPlatformName(plat.getPlat_name());
			if(!names.contains(plat.getCompany_name())){
				platInfoList.add(platInfo);
				names.add(plat.getCompany_name());
			}
		}
		List<CompanyDO> comList = companyMapper.findCompanyByName(names);
		Map<String,CompanyDO> map=new HashMap<String,CompanyDO>();
		for(CompanyDO com:comList){
			map.put(com.getName(),com);
		}
		Iterator<PlatformNameInformationDO> it = platInfoList.iterator();
		while(it.hasNext()){
			PlatformNameInformationDO plat = it.next();
			if(null==map.get(plat.getName())){
				TaskFailInfoDO fail = new TaskFailInfoDO();
				fail.setFailReason("company表未查询到数据");
				fail.setFailName(plat.getPlatformName());
				fail.setTaskId(taskId);
				taskFailInfoMapper.addTaskFailInfo(fail);
				it.remove();
			}else{
				plat.setCompanyId(map.get(plat.getName()).getCompanyId());

				//拉下网贷数据的时候，将Company表中的company_type修改为1(若本身为1则不做任何处理?仍要做记录)
				Byte industryBefore = map.get(plat.getName()).getCompanyType();//数据库中的行业，亦是修改前行业
				ModifyData modifyData = new ModifyData();
				modifyData.setName(map.get(plat.getName()).getName());
				modifyData.setLevel(map.get(plat.getName()).getRiskLevel()+"");
				modifyData.setIndustry(CompanyInfo.TYPE_P2P_1+"");//修改后固定为网贷
				modify(modifyData,industryBefore);


			}
		}
	}

	public void modify(ModifyData modifyData,Byte industryBefore){
		try {
			if (CompanyInfo.TYPE_P2P_1 == industryBefore) { // 网络借贷转网络借贷
				companyInfoMudifyUtil.modifyWangdai(modifyData);
			} else { // 其它转网络借贷
				companyInfoMudifyUtil.modifyTimingTask(modifyData);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.info(e.getMessage());
		}

	}



	public Integer updatePlatData(List<PlatformNameInformationDO> platInfoList){
		int errorNum = 0;
		if(platInfoList.size()>0){
			//剩下的数据
			for(PlatformNameInformationDO plat:platInfoList){
				try {
					platformNameInformationMapper.addPlatOne(plat);
				} catch (Exception e) {
					TaskFailInfoDO fail = new TaskFailInfoDO();
					fail.setFailReason("数据插入错误");
					fail.setFailName(plat.getName());
					fail.setTaskId(taskId);
					taskFailInfoMapper.addTaskFailInfo(fail);
					errorNum++;
				}
			}
		}
		return errorNum;
	}

	public  List<PlatListDO> getPlatList() {
		String url="http://121.40.187.134:5002/financial_services?dataType=plat_list";
		try {
			String result = new HttpTemplate().get(url);
			Gson gson = new Gson();
			List<PlatListDO> platList = gson.fromJson(result, new TypeToken<List<PlatListDO>>() {}.getType());
			return platList;
		} catch (Exception e) {
			logger.error("Method getPlatList get Exception." + e.getMessage());
			return null;
		}
	}

	@Override
	public String getTaskKey() {
		return "platformJob";
	}

	@Override
	public String getTaskGroup() {
		return "job_work";
	}

	@Override
	public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
		TaskResultDO taskResultDO = updatePlatAutomaticOperate(taskId);
		return taskResultDO;
	}

	@Override
	public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {

		TaskResultDO taskResultDO=updatePlatManualOperate(oldTaskId, newTaskId);
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
