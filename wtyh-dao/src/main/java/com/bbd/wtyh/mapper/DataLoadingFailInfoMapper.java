package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.DataLoadingFailInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * Created by cgj on 2017/5/4.
 */

public interface DataLoadingFailInfoMapper {


	List<DataLoadingFailInfoDO> getDataLoadingFailInfoByTaskId(@Param("taskId") Integer taskId);

	/**
	 * 分页获取失败信息
	 *
	 * @param params
	 * @return
	 */
	List<DataLoadingFailInfoDO> findByPage(Map<String, Object> params);

	int addTaskFailInfo(DataLoadingFailInfoDO dataSuccessFailInfoDO);

	/**
	 * 获取某任务失败总条数
	 *
	 * @return
	 */
	int countFailByTaskId(@Param("taskId") Integer taskId);


	//void updateTaskSuccessFailInfo(TaskSuccessFailInfoDO taskSuccessFailInfoDO);
}