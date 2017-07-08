package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.bbd.wtyh.domain.CompanyCreditRawInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2017/5/4.
 */

public interface CompanyCreditFailInfoMapper {

	List<CompanyCreditFailInfoDO> getCompanyCreditFailInfo(@Param("param") Map<String, Object> params);

	int getCompanyCreditFailInfoCounts(@Param("param") Map<String, Object> params);

	List<CompanyCreditFailInfoDO> getCompanyCreditFailInfoByTaskId(@Param("taskId")Integer taskId,@Param("resultCode")List<String> resultCode);

}