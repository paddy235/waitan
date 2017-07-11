package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.DataLoadingFailInfoDO;
import org.apache.ibatis.annotations.Param;


/**
 * Created by cgj on 2017/5/4.
 */

public interface DataLoadingFailInfoMapper {


	DataLoadingFailInfoDO getDataLoadingFailInfo(@Param("taskId") Integer taskId);

	int addTaskFailInfo(DataLoadingFailInfoDO dataSuccessFailInfoDO);

	//void updateTaskSuccessFailInfo(TaskSuccessFailInfoDO taskSuccessFailInfoDO);
}