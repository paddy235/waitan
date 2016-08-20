package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.NvDO;

import java.util.List;

/**
 * 数据同步
 * @author tracy zhou
 * @since  2016/8/20
*/
public interface SyncDataService {


	public String receiveData(String syncData);
}
