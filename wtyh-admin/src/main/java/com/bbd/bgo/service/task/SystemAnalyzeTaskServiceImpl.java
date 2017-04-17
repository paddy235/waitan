package com.bbd.bgo.service.task;


import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.mapper.CompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class SystemAnalyzeTaskServiceImpl extends BaseServiceImpl implements SystemAnalyzeTaskService {

	private Logger logger = LoggerFactory.getLogger(SystemAnalyzeTaskServiceImpl.class);
	@Autowired
	private CompanyMapper companyMapper;
	/**
	 * 每月1日晚上8点，更新首页的企业数量
	 */
	@Override
	@Scheduled(cron = "0 0 20 1 * ?")
	public void updateCompanyCount() {
		try {
			int count=companyMapper.countAllCompany();
			logger.info("start update company count:"+count);
			if(count>0){
				this.executeCUD("UPDATE system_analyze SET company_count=?",count);
			}
			logger.info("end update company count:"+count);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}
