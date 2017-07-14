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


	/**
	 * 任务开始
	 **/
	public static Integer taskStart(String taskName,String taskGroup,String dataVersion,Integer runMode,Integer planCount,String createBy ) {
		return quartzHandler.taskStart(taskName,taskGroup,dataVersion,runMode,planCount,createBy);
	}
	/**
	 * 任务结束
	**/
	public static void taskEnd(Integer taskId, Integer planCount, Integer successCount, Integer failCount,String updateBy) {
		quartzHandler.taskEnd(taskId,planCount,successCount,failCount,updateBy);
	}


}
