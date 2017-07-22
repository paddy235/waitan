package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.mapper.WangdaiTaskInfoMapper;
import com.bbd.wtyh.service.WangdaiTaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lixudong on 2017/7/21.
 */
@Service
public class WangdaiTaskInfoServiceImpl implements WangdaiTaskInfoService {

    @Autowired
    private WangdaiTaskInfoMapper wangdaiTaskInfoMapper;

    @Override
    public List<TaskFailInfoDO> listByTaskId(Integer taskId) {
        return wangdaiTaskInfoMapper.list(taskId);
    }
}
