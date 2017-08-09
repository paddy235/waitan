package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.TaskResultDO;

import java.io.File;

/**
 * 数据同步
 * 
 * @author tracy zhou
 * @since 2016/8/20
 */
public interface SyncDataService {

	TaskResultDO receiveFileData(File file) throws Exception;

	public void stopTask();

	public void resetShutDown();
}
