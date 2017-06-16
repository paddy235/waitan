package com.bbd.wtyh.mapper;


import java.util.Map;

import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import org.apache.ibatis.annotations.Param;


/**
 * Created by cgj on 2017/5/4.
 */

public interface TaskSuccessFailInfoMapper {

	TaskSuccessFailInfoDO getTaskSuccessFailInfo(@Param("taskName") String taskName,@Param("taskGroup") String taskGroup,@Param("dataVersion") String dataVersion);

	void addTaskSuccessFailInfo(TaskSuccessFailInfoDO taskSuccessFailInfoDO);

	void updateTaskSuccessFailInfo(TaskSuccessFailInfoDO taskSuccessFailInfoDO);
}