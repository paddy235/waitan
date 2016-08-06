package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyNewsDO;
import com.bbd.wtyh.domain.InBusiness;
import com.bbd.wtyh.mapper.BuildingMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.CompanyNewsMapper;
import com.bbd.wtyh.service.ParkService;

/**
* 
* @author Ian.Su
* @since 2016年8月5日 下午5:45:41
*/
@Service
public class ParkServiceImpl implements ParkService {

	
	@Autowired
	private BuildingMapper buildingMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private CompanyNewsMapper newsMapper;
	
	/**
	* @see com.bbd.wtyh.service.ParkService#queryBuildings(java.lang.String)
	*/
	@Override
	public List<BuildingDO> queryBuildings(Integer parkId) {
		
		return buildingMapper.queryBuildings(parkId);
		
	}

	
	/**
	* @see com.bbd.wtyh.service.ParkService#inBusiness(java.lang.Integer)
	*/
	@Override
	public List<InBusiness> inBusiness(Integer areaId) {
		
		List<InBusiness> list = new ArrayList<>();
		
		Date now = new Date();
		
		Date year10 = DateUtils.setYears(now, 10);
		Date year5 = DateUtils.setYears(now, 5);
		Date year3 = DateUtils.setYears(now, 3);
		Date year1 = DateUtils.setYears(now, 1);
		
		list.add(inBusiness("10年以上",areaId, null    ,year10));
		list.add(inBusiness("5-10年" ,areaId, year10  ,year5));
		list.add(inBusiness("3-5年",areaId,   year5   ,year3));
		list.add(inBusiness("1-3年",areaId,   year3   ,year1));
		list.add(inBusiness("1年以下",areaId,  year1   ,now));
		
		return list;
	}
	
	
	
	/**
	* 根据时间段获取统计信息
	*
	* @param   
	* @return InBusiness
	*/
	public InBusiness inBusiness(String dateRange,Integer areaId,Date start,Date end) {
		
		InBusiness bean = companyMapper.countByDate(areaId, start, end);
		
		bean.setDate(dateRange);
		 
		return bean;
	}
	
	
	
	/**
	* @see com.bbd.wtyh.service.ParkService#queryParkNews(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	*/
	@Override
	public List<CompanyNewsDO> queryParkNews(Integer areaId,Integer pageSize,Integer pageNum){
		
		pageSize = (pageSize==null?10:pageSize);  
		
		pageNum = (pageNum==null?1:pageNum);  
		
		return newsMapper.queryParkNews(areaId,pageNum*pageSize-pageSize,pageSize);
		
	}
	

}
