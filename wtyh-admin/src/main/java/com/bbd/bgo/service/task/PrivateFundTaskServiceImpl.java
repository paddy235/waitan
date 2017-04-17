package com.bbd.bgo.service.task;


import com.bbd.wtyh.core.base.BaseServiceImpl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class PrivateFundTaskServiceImpl extends BaseServiceImpl implements PrivateFundTaskService {

	/**
	 * 私募企业列表的“备案状态”根据私募证券业协会官网上的状态更新
	 */
	@Override
	@Scheduled(cron = "0 0 1 * * ?")
	public void updateCompanyStatus() {

	}
}
