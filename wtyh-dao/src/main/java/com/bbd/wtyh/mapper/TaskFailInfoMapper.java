package com.bbd.wtyh.mapper;


import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.TaskFailInfoDO;
import org.apache.ibatis.annotations.Param;



/**
 * Created by cgj on 2017/5/4.
 */

public interface TaskFailInfoMapper {


	List<TaskFailInfoDO> getTaskFailInfoByTaskId(@Param("taskId") Integer taskId);

	/**
	 * 分页获取失败信息
	 *
	 * @param params
	 * @return
	 */
	List<TaskFailInfoDO> findByPage(Map<String, Object> params);

	int addTaskFailInfo(TaskFailInfoDO taskFailInfoDO);

	/**
	 * 获取某任务失败总条数
	 *
	 * @return
	 */
	int countFailByTaskId(@Param("taskId") Integer taskId);


}