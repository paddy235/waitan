package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.DataLoadingFailInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by cgj on 2017/5/4.
 */

public interface DataLoadingFailInfoMapper {


	List<DataLoadingFailInfoDO> getDataLoadingFailInfoByTaskId(@Param("taskId") Integer taskId);

	int addTaskFailInfo(DataLoadingFailInfoDO dataSuccessFailInfoDO);

	//void updateTaskSuccessFailInfo(TaskSuccessFailInfoDO taskSuccessFailInfoDO);
}