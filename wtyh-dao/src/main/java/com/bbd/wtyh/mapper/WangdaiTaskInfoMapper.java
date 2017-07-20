package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.WangdaiTaskInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lixudong on 2017/7/20.
 */
public interface WangdaiTaskInfoMapper {

    void save(WangdaiTaskInfoDO wangdaiTaskInfoDO);

    List<WangdaiTaskInfoDO> list(@Param("taskId")String taskId);
}
