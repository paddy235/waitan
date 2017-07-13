package com.bbd.bgo.service.task;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.service.LogInfoService;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class OfflineFinancialListTaskServiceImpl extends BaseServiceImpl implements OfflineFinancialListTaskService {


	private static String TASK_NAME = "offlineFinanceJob";

	private static String TASK_GROUP = "bbd_work";

	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;

	Logger logger = LoggerFactory.getLogger(OfflineFinancialListTaskServiceImpl.class);

	@Override
	@LogRecord(logMsg = "线下理财名单：%s", params = {"loginName"}, page = Operation.Page.licaiHome, type = Operation.Type.modify)
	public void offlineFinancialListUpdate() {
		TaskSuccessFailInfoDO task = taskSuccessFailInfoMapper.getTaskRecentInfo(TASK_NAME,TASK_GROUP);
		String executeDate = DateFormatUtils.format(task.getCreateDate(), "yyyy-MM-dd");
		List<CompanyDO> companyList = companyMapper.getLineCompanyListMoreThanExecuteDate(executeDate);
	}
}
