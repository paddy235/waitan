package com.bbd.bgo.service.task;

import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.P2PImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 所有定时任务统一管理接口实现类
 *
 * @author Created by LiYao on 2017-04-25 14:43.
 */
@Component
public class TimingTaskManager {

	@Autowired
	private SyncFileService syncFileService;
	@Autowired
	private CoCreditScoreService coCreditScoreService;
	@Autowired
	private OfflineFinanceService offlineFinanceService;
	@Autowired
	private SystemDataUpdateService systemDataUpdateService;
	@Autowired
	private P2PImageService pImageService;

	/**
	 * 拉取线下理财数据
	 * 频率：每晚11点开始
	 */
	public void pullDataFileFromBBDTask() {

		syncFileService.pullFile();
	}
	/**
	 * 拉取公信中心数据
	 * 频率：18点开始
	 */
	public void shangHaiCreditTask() {

		coCreditScoreService.creditScoreCalculate();
	}
	/**
	 * 关闭拉取公信中心数据
	 * 频率：07点开始
	 */
	public void closeShangHaiCreditTask() throws Exception {
		coCreditScoreService.colseScoreCalculate();
	}
	/**
	 * 更新企业风险等级
	 * 频率：每天16：20：00执行
	 */
	public void updateCompanyRiskLevel() throws Exception {
		offlineFinanceService.updateCompanyRiskLevel();
	}

	/**
	 * 更新企业基本信息
	 * 频率：每月2日晚上8点
	 */
	public void updateCompanyBaseInfo() throws Exception {
		systemDataUpdateService.updateCompanyTableAreaIdAndAddress();
	}

	/**
	 * 更新网络借贷舆情数据
	 * @throws Exception
	 */
	public void updateYuQing()throws Exception{
		pImageService.updateWangDaiYuQingTask();
	}

}
