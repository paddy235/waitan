package com.bbd.bgo.service.task;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.OfflineFinancialRecordDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.dataLoading.DishonestyDO;
import com.bbd.wtyh.domain.dataLoading.QyxxBasicDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.DataLoadingMapper;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.service.LogInfoService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.velocity.util.ArrayListWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class OfflineFinancialListTaskServiceImpl extends BaseServiceImpl implements OfflineFinancialListTaskService {


	private static String TASK_NAME = "offlineFinanceJob";

	private static String TASK_GROUP = "bbd_work";

	private static String TAG = "外滩线下理财企业";

	@Value("${api.appkey}")
	private String appkey;

	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private DataLoadingMapper dataLoadingMapper;
	@Autowired
	private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;

	Logger logger = LoggerFactory.getLogger(OfflineFinancialListTaskServiceImpl.class);

	@Override
	@LogRecord(logMsg = "线下理财名单：%s", params = {"loginName"}, page = Operation.Page.licaiHome, type = Operation.Type.modify)
	public void offlineFinancialListUpdate(Long taskId) {
		TaskSuccessFailInfoDO task = taskSuccessFailInfoMapper.getTaskRecentInfo(TASK_NAME,TASK_GROUP);
		String executeDate = null;
		if(null!=task){
			executeDate = DateFormatUtils.format(task.getCreateDate(), "yyyy-MM-dd");
		}
		List<CompanyDO> companyList = companyMapper.getLineCompanyListMoreThanExecuteDate(executeDate);
		batchOpeate(companyList);
	}

	//批量操作数据
	public void batchOpeate(List<CompanyDO> companyList){
		int pointsDataLimit = 1000;//限制条数
		Integer size = companyList.size();
		if(pointsDataLimit<size){
			int part = size/pointsDataLimit;//分批数
			for(int i=0;i<part;i++){
				List<CompanyDO> listPage = companyList.subList(0,pointsDataLimit);
				batchGetData(listPage);
				companyList.subList(0,pointsDataLimit).clear();
			}
			if(!companyList.isEmpty()){
				batchGetData(companyList);
			}
		}else{
			batchGetData(companyList);
		}
	}

	public void batchGetData(List<CompanyDO> list){
		String bbdqQyxxId = null;
		//批量获取qyxx_id
		List<QyxxBasicDO> qyxxList = dataLoadingMapper.getCompanyBasicInfoInNames(list);
		Map<String,QyxxBasicDO> map = new HashMap<String,QyxxBasicDO>();
		if(null!=qyxxList&&qyxxList.size()>0){
			for(QyxxBasicDO qyxx:qyxxList){
				map.put(qyxx.getCompany_name(),qyxx);
			}
		}
		List<OfflineFinancialRecordDO> recordList=new ArrayList<OfflineFinancialRecordDO>();
		for(CompanyDO company:list){
			QyxxBasicDO basic = map.get(company.getName());
			if(null!=basic&&!StringUtils.isNullOrEmpty(basic.getBbd_qyxx_id())){
				bbdqQyxxId=basic.getBbd_qyxx_id();
			}else{
				bbdqQyxxId = getQyxxIdByName(company.getName());
			}
			if(!StringUtils.isNullOrEmpty(bbdqQyxxId)){
				if(addTagWhite(company.getName(),bbdqQyxxId)){
					OfflineFinancialRecordDO record = new OfflineFinancialRecordDO();
					record.setCompany_name(company.getName());
					record.setCompany_id(company.getCompanyId());
					record.setCredit_code(company.getCreditCode());
					record.setOrganization_code(company.getOrganizationCode());
					record.setCreateBy("system");
					recordList.add(record);
				}
 			}
		}
		System.out.println(recordList.size());
		if(recordList.size()>0){
			dataLoadingMapper.saveOfflineFinancialRecordDO(recordList);
		}
	}

	public String getQyxxIdByName(String companyName) {
		String qyxxId = null;
		StringBuffer sb = new StringBuffer();
		sb.append("http://dataapi.bbdservice.com/api/bbd_qyxx_batch/?appkey=")
				.append(appkey)
				.append("&keys=")
				.append(companyName);
		try {
			String result = new HttpTemplate().get(sb.toString());
			if(result.indexOf("bbd_qyxx_id")>0){
				String subStr = result.substring(result.indexOf("bbd_qyxx_id"));
				qyxxId = subStr.substring(subStr.indexOf(":\"")+2,subStr.indexOf("\","));
			}
		} catch (Exception e) {
			return null;
		}
		return qyxxId;
	}

	public  boolean addTagWhite(String companyName,String qyxxId) {
		boolean  success = true;
		StringBuffer sb = new StringBuffer();
		sb.append("http://dataapi.bbdservice.com/api/add_tag_white/?tag="+TAG+"&appkey=")
				.append(appkey)
				.append("&company_name=")
				.append(companyName)
				.append("&bbd_qyxx_id=")
				.append(qyxxId);
		try {
			String result = new HttpTemplate().get(sb.toString());
			JSONObject jsonObject = JSONObject.fromObject(result);
			String message = jsonObject.getString("message");
			if(!"ok".equalsIgnoreCase(message)){
				logger.error("线下理财名单数据上传错误，错误公司："+companyName+"错误原因："+message);
				success = false;
			}
		} catch (Exception e) {
			success = false;
			logger.error("线下理财名单数据上传错误，错误公司："+companyName+"错误原因："+e);
		}
		return success;
	}
}
