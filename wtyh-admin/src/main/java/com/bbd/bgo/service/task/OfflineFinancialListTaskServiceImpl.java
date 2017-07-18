package com.bbd.bgo.service.task;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
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
import net.sf.json.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
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
		String executeDate = DateFormatUtils.format(task.getCreateDate(), "yyyy-MM-dd");
		List<CompanyDO> companyList = companyMapper.getLineCompanyListMoreThanExecuteDate(executeDate);
		for(CompanyDO com:companyList){
			//先去库里查，查不到调接口
			List<QyxxBasicDO> coms = dataLoadingMapper.getCompanyBasicInfoByName(com.getName());
			String bbdqQyxxId = null;
			if(null!=com&&coms.size()>0){
				bbdqQyxxId=coms.get(0).getBbd_qyxx_id();
			}else{
				bbdqQyxxId=getQyxxIdByName(com.getName());
			}
			addTagWhite(com.getName(),bbdqQyxxId);
		}
	}

	public String getQyxxIdByName(String companyName) {
		String qyxxId = null;
		StringBuffer sb = new StringBuffer();
		sb.append("http://dataapi.bbdservice.com/api/add_tag_white/?appkey=")
				.append(appkey)
				.append("&company_name=")
				.append(companyName);
		try {
			String result = new HttpTemplate().get(sb.toString());
			JSONObject jsonObject = JSONObject.fromObject(result);
			String message = jsonObject.getString("results");
			JSONObject resObject = JSONObject.fromObject(message);
			qyxxId = resObject.getString("bbd_qyxx_id");
		} catch (Exception e) {
			return null;
		}
		return qyxxId;
	}

	public  void addTagWhite(String companyName,String qyxxId) {
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
			}
		} catch (Exception e) {
			logger.error("线下理财名单数据上传错误，错误公司："+companyName+"错误原因："+e);
		}
	}
}
