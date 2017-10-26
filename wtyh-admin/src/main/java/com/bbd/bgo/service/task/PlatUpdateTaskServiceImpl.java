package com.bbd.bgo.service.task;


import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.constants.TaskState;
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

	private static final String PLAT_LIST = "网贷平台列表(plat_list)";

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
		logger.info("----- platform job begin -----");
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
		List<PlatListDO> platList = null;
		try{
			platList= this.getPlatList();
		} catch (Exception e) {

			logger.error(e.getMessage(), e);

			TaskFailInfoDO fail = new TaskFailInfoDO();
			fail.setFailReason("接口调用失败");
			fail.setFailName(PLAT_LIST);
			fail.setTaskId(taskId);
			taskFailInfoMapper.addTaskFailInfo(fail);

			taskResultDO.setPlanCount(1);
			taskResultDO.setFailCount(1);
			taskResultDO.setSuccessCount(0);
			taskResultDO.setState(TaskState.ERROR);
			return taskResultDO;
		}

		if(null==platList||platList.size()<1){

			taskResultDO.setPlanCount(dataTotal);
			taskResultDO.setFailCount(dataError);
			taskResultDO.setSuccessCount(dataTotal-dataError);
		}
		dataTotal = platList.size();
		//根据企业名称获取公司id
		List<PlatformNameInformationDO> platInfoList = new ArrayList<>();
		//手动执行
		if(null!=newTaskId){

			boolean runFlag=true;

			List<TaskFailInfoDO> failList = taskFailInfoMapper.getTaskFailInfoByTaskId(oldTaskId);
			if(failList!=null && failList.size()==1){
				TaskFailInfoDO taskFailInfoDO=failList.get(0);
				if(PLAT_LIST.equals(taskFailInfoDO.getFailName())){
					runFlag=false;
				}
			}

			if(runFlag){
				List<String> failStrList=new ArrayList<>();

				for(TaskFailInfoDO fail:failList){
					failStrList.add(fail.getFailName());
				}
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

		}
		this.setCompanyId(platList,platInfoList);

		Collections.sort(platInfoList,(o1,o2) -> o1.getCompanyId()-o2.getCompanyId());
		if(null==newTaskId){
			int delNum = this.executeCUD("delete from platform_name_information");
			logger.info("delete plat number:"+delNum);
		}
		updatePlatData(platInfoList);
		logger.info("end update plat,update number:"+(dataTotal-dataError));
		try {
			platformNameInformationMapper.deleteRepeatPlat();
		} catch (Exception e) {
			logger.info("delete repeat plat error");
		}
        dataError=taskFailInfoMapper.countFailByTaskId(taskId);
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
		List<String> names = new ArrayList<>();
		List<String> plats = new ArrayList<>();
		PlatformNameInformationDO platInfo;
		for(PlatListDO plat:platList){

		    String platCompanyName=plat.getCompany_name()!=null?plat.getCompany_name().trim():plat.getCompany_name();
			String platName=plat.getPlat_name();
			platInfo=new PlatformNameInformationDO();
			platInfo.setName(platCompanyName);
			platInfo.setPlatformName(platName);

			if(!names.contains(platCompanyName)){
				names.add(platCompanyName);
			}
			if(!plats.contains(platName)){
				plats.add(platName);
				platInfoList.add(platInfo);
			}

		}
		//从company表取企业ID
		Map<String,CompanyDO> map=getCompanyInfo(names);

		//企业在company不存在，需要新增
		addNewCompanyForPlat(names, map);

		//新增不存在的企业后，重新从company表取企业ID
		map=getCompanyInfo(names);

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
                Integer level=map.get(plat.getName()).getRiskLevel();
				modifyData.setLevel(level==null?null:level.toString());
				modifyData.setIndustry(CompanyInfo.TYPE_P2P_1+"");//修改后固定为网贷
				modify(modifyData,industryBefore);


			}
		}
	}

	public void modify(ModifyData modifyData,Byte industryBefore){
		try {
			// 其它行业转网络借贷,需要清空原来的风险等级
			if (null != industryBefore && CompanyInfo.TYPE_P2P_1!=industryBefore) {

				companyInfoMudifyUtil.modifyForTask(modifyData);
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
			logger.error("Method getPlatList get Exception." , e.getMessage());
			throw new RuntimeException(e);
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

	private Map<String,CompanyDO> getCompanyInfo(List<String> names){

		List<CompanyDO> comList = companyMapper.findCompanyByName(names);
		Map<String,CompanyDO> map=new HashMap<>();
		for(CompanyDO com:comList){
			map.put(com.getName(),com);
		}

		return map;

	}
	private void addNewCompanyForPlat(List<String> names,Map<String,CompanyDO> map){
		try {
			List<CompanyDO> newCompanys=new ArrayList<>();
			for(String tempName:names){
				if(null==map.get(tempName)){
					CompanyDO companyDO=new CompanyDO();
					companyDO.setName(tempName);
					companyDO.setCompanyType(Byte.valueOf("1"));
					newCompanys.add(companyDO);
				}
			}
			CompanyImportAssist companyImportAssist=new CompanyImportAssist(null,null);
			companyImportAssist.processCp(newCompanys,true);
			companyImportAssist.saveForNewSource("updatePlat");
			companyImportAssist.clearList();
		}catch (Exception e){
			logger.error("Method addNewCompanyForPlat get Exception." , e.getMessage());
		}
	}
}
