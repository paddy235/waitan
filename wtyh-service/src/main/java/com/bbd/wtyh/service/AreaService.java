package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.domain.AreaDO;

/**
* 园区相关接口
* @author Ian.Su
* @since 2016年8月5日 上午11:57:08
*/
public interface AreaService {

	
	/**
	*
	* 获取所有的区域
	* @return List<Area>
	*/
	public List<AreaDO> areaList();

}
