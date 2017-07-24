package com.bbd.bgo.quartz;

import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 定时任务相关工具类
 *
 * @author Created by LiYao on 2017-06-14 14:10.
 */
public class TaskUtil {

	private static QuartzHandler quartzHandler = ApplicationContextUtil.getBean(QuartzHandler.class);
	//公信数据落地任务
	public static String[] shangHaiCreditJob= {"shangHaiCreditJob","credit_work"};
	public static String[] closeShangHaiCreditJob= {"closeShangHaiCreditJob","credit_work"};
	//BBD数据落地任务
	public static String[] offlineFinanceJob= {"offlineFinanceJob","bbd_work"};
	public static String[] holographicAndOpinionJob= {"holographicAndOpinionJob","bbd_work"};
	//网贷之家数据落地任务
	public static String[] pToPMonitorJob= {"p2pMonitorJob","wd_work"};//网络借贷-检测
	public static String[] p2pImageJob= {"p2pImageJob","wd_work"};//网络借贷-平台画像
	public static String[] crowdFundingJob= {"crowdFundingJob","wd_work"};//众筹
	//系统数据更新任务
	public static String[] riskLevelJob= {"riskLevelJob","job_work"};//风险等级
	public static String[] companyBaseInfo= {"companyBaseInfoJob","job_work"};//风险等级
	public static String[] platformJob= {"platformJob","job_work"};//企业与网贷平台对照表


	/**
	 * 任务开始
	 **/
	public static Integer taskStart(String taskName,String taskGroup,String dataVersion,Integer runMode,Integer planCount,String createBy ) {
		return quartzHandler.taskStart(taskName,taskGroup,dataVersion,runMode,planCount,createBy);
	}
	/**
	 * 任务结束
	**/
	public static void taskEnd(Integer taskId, Integer planCount, Integer successCount, Integer failCount,String updateBy,Integer reExecute) {
		quartzHandler.taskEnd(taskId,planCount,successCount,failCount,updateBy,reExecute);
	}


}
