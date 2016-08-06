package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyNewsDO;
import com.bbd.wtyh.domain.InBusiness;


/**
* 园区相关接口
* @author Ian.Su
* @since 2016年8月5日 上午11:57:08
*/
public interface ParkService {

	
	
	/**
	* 根据区域id查询类金融企业集中度
	*
	* @param areaId  区域id
	* @return List<BuildingDO>
	*/
	List<BuildingDO> queryBuildings(Integer parkId );
	
	
	/**
	* 根据区域id查询类金融企业集中度
	*
	* @param areaId  区域id
	* @return List<BuildingDO>
	*/
	List<InBusiness> inBusiness(Integer areaId );
	
	
	/**
	* 查询园区舆情
	*
	* @param areaId 区域id
	* @param pageSize 每页数量
	* @param pageNum 页码
	* @author Ian.Su   
	* @return List<CompanyNewsDO>
	*/
	List<CompanyNewsDO> queryParkNews(Integer areaId,Integer pageSize,Integer pageNum);
	

}
