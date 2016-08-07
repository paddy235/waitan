package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyNewsDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;


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
	List<BuildingDO> queryBuildings(Integer areaId );
	
	
	/**
	* 根据区域id查询类金融企业集中度
	*
	* @param areaId  区域id
	* @return List<BuildingDO>
	*/
	List<InBusinessDO> inBusiness(Integer areaId );
	
	
	/**
	* 根据区域id查询行业分布
	*
	* @param areaId  区域id
	* @return List<BuildingDO>
	*/
	List<CompanyTypeCountDO> businessDistribute(Integer areaId );
	
	
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


	
	/**
	* 获取园区图片
	*
	* @param  areaId 区域id  
	* @return String 图片地址
	*/
	String parkImg(Integer areaId);


	
	/**
     * 楼宇企业列表
     * @param buildingId 楼宇id,必传
     * @param orderField 排序字段，1：按行业，2：按注册资本,非必须，默认按行业
     * @param descAsc    排序方式：desc:降序，asc:升序
     * @return List<CompanyDO>  
     */
	List<CompanyDO> buildingCompany(Integer buildingId,Integer orderField,String descAsc);


	
	 /**
     * 楼宇行业分布
     * @param buildingId 楼宇id,必传
     * @return List<CompanyTypeCountDO>  
     */
	List<CompanyTypeCountDO> buildingBusinessDistribute(Integer buildingId);


	
	 /**
     * 企业背景情况
     * @param buildingId 楼宇id,必传
     * @return List<CompanyTypeCountDO>  
     */
	List<CompanyTypeCountDO> buildingBackground(Integer buildingId);


	
	 /**
     * 楼宇舆情
     * @param buildingId 楼宇id,必传
     * @return List<CompanyNewsDO>  
     */
	List<CompanyNewsDO> buildingNews(Integer buildingId);
	

}
