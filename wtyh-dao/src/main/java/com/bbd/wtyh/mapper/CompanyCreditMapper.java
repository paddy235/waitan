package com.bbd.wtyh.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by cgj on 2017/5/4.
 */

public interface CompanyCreditMapper {



	int countCreditFailInfo(@Param("taskId") Integer taskId);

	int countCreditFailHistoryInfo(@Param("taskId") Integer taskId);

	int countCreditRawInfo(@Param("taskId") Integer taskId);

	int countCreditRawHistoryInfo(@Param("taskId") Integer taskId);



}