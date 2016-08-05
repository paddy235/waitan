package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.entity.Area;

/**
* @ClassName: ParkService
* @Description: 园区相关接口
* @author Ian.Su
* @date 2016年8月5日 上午11:57:08
*/
public interface AreaService {

	
	/**
	*
	* @Title: 获取所有的区域
	* @Description: TODO
	* @param   设定文件
	* @return List<Area>    返回类型
	* @throws
	* @author Ian.Su
	* @date 2016年8月5日 下午1:47:54 
	*/
	public List<Area> list();

}
