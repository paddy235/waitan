package com.bbd.wtyh.mapper;


import java.util.List;

import com.bbd.wtyh.domain.dto.TaskInfoDTO;
import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;


/**
 * Created by cgj on 2017/5/4.
 */

public interface TimingTaskMapper {

	List<TaskInfoDTO> getHistoryTaskInfoByNameAndGroup(@Param("taskName") String taskName, @Param("taskGroup") String taskGroup,
													   @Param("taskState") String taskState, @Param("taskDataSource") String taskDataSource,
													   @Param("taskUpdateDate")  String taskUpdateDate);

}