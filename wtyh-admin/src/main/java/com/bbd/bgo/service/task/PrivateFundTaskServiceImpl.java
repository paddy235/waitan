package com.bbd.bgo.service.task;


import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.core.base.BaseServiceImpl;

import com.bbd.wtyh.domain.dto.PrivateFundCompanyDTO;
import com.bbd.wtyh.mapper.PrivateFundExtraMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class PrivateFundTaskServiceImpl extends BaseServiceImpl implements PrivateFundTaskService {

	private Logger logger = LoggerFactory.getLogger(PrivateFundTaskServiceImpl.class);

	private PrivateFundExtraMapper privateFundExtraMapper;

	/**
	 * 每月1日晚上10点，私募企业列表的“备案状态”根据私募证券业协会官网上的状态更新
	 */
	@Override
	@Scheduled(cron = "0 0 22 1 * ?")
	public void updateCompanyStatus() {
		try {
			int totalCount = privateFundExtraMapper.countAllCompany();
			Pagination pagination = new Pagination();
			pagination.setPageSize(1000);
			pagination.setCount(totalCount);
			int total = pagination.getLastPageNumber();
			Map<String, Object> params = new HashMap<>();

			ExecutorService dataExecutorService = Executors.newFixedThreadPool(20);
			logger.info("start update private fund company status");
			for (int i = 1; i <= total; i++) {
				pagination.setPageNumber(i);
				params.put("pagination", pagination);
				List<PrivateFundCompanyDTO> list = privateFundExtraMapper.findByPage(params);
				if (!CollectionUtils.isEmpty(list)) {
					for (final PrivateFundCompanyDTO privateFundCompanyDTO : list) {
						dataExecutorService.submit(new Runnable() {

							@Override
							public void run() {
								updatePrivateFundCompanyStatus(privateFundCompanyDTO);
							}
						});
					}
				}
			}
			logger.info("end update private fund company status");
			dataExecutorService.shutdown();

			dataExecutorService.awaitTermination(1, TimeUnit.DAYS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	private void updatePrivateFundCompanyStatus(PrivateFundCompanyDTO privateFundCompanyDTO) {
		String companyName=privateFundCompanyDTO.getName();
		Integer companyId=privateFundCompanyDTO.getCompanyId();
		//根据公司名称查询企业是否已备案
		//update private_fund_extra.record_status

		//this.executeCUD("UPDATE  private_fund_extra SET record_status=1 WHERE company_id=?",companyId);
	}
}
