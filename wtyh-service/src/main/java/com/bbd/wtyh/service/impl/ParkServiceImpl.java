package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyBackgroundDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyNewsDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;
import com.bbd.wtyh.mapper.BuildingMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.CompanyNewsMapper;
import com.bbd.wtyh.mapper.ParkMapper;
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
	
	@Autowired
	private ParkMapper parkMapper;

	@Override
	public List<BuildingDO> queryBuildings(Integer areaId) {
		
		return buildingMapper.queryBuildings(areaId);
		
	}

	

	@Override
	public List<InBusinessDO> inBusiness(Integer areaId) {
		
		List<InBusinessDO> list = new ArrayList<>();
		
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
	* @param dateRange 时间范围
	* @param areaId 区域id
	* @param start 时间年限起
	* @param end 时间年限止
	* @return InBusiness
	*/
	public InBusinessDO inBusiness(String dateRange,Integer areaId,Date start,Date end) {
		
		InBusinessDO bean = companyMapper.countByDate(areaId, start, end);
		
		bean.setDate(dateRange);
		 
		return bean;
	}
	
	

	@Override
	public List<CompanyNewsDO> queryParkNews(Integer areaId,Integer pageSize,Integer pageNum){
		
		pageSize = (pageSize==null?10:pageSize);  
		
		pageNum = (pageNum==null?1:pageNum);  
		
		return newsMapper.queryParkNews(areaId,pageNum*pageSize-pageSize,pageSize);
		
	}


	

	@Override
	public List<CompanyTypeCountDO> businessDistribute(Integer areaId) {
		
		List<CompanyTypeCountDO> ljr = new ArrayList<>();
		
		countType(ljr , areaId ,CompanyDO.TYPE_P2P_1,"p2p");
		
		countType(ljr , areaId ,CompanyDO.TYPE_XD_2,"小额贷款");
		
		countType(ljr , areaId ,CompanyDO.TYPE_RZDB_3,"融资担保");
		
		countType(ljr , areaId ,CompanyDO.TYPE_XXLC_4,"线下理财");
		
		countType(ljr , areaId ,CompanyDO.TYPE_SMJJ_5,"私募基金");
		
		countType(ljr , areaId ,CompanyDO.TYPE_ZC_6,"众筹");
		
		List<CompanyTypeCountDO> bigType = new ArrayList<>();
		
		CompanyTypeCountDO ljrCount = new CompanyTypeCountDO();
		
		for (CompanyTypeCountDO ctc : ljr) {
			ljrCount.setCount( ljrCount.getCount()+ctc.getCount() );
		}
		ljrCount.setChildren(ljr);
		bigType.add(ljrCount.setType("类金融"));
		
		countType(bigType , areaId ,CompanyDO.TYPE_JR_7,"金融");
		countType(bigType , areaId ,CompanyDO.TYPE_QT_8,"其他");
		
		return bigType;
	}
	
	private void countType( List<CompanyTypeCountDO> list , Integer areaId ,Byte type,String name){
		CompanyTypeCountDO b = companyMapper.countByType(areaId, CompanyDO.TYPE_P2P_1);
		list.add(b.setType(name));
		
	}
	
	
	
	
	

	public String parkImg(Integer areaId){
		
		return parkMapper.parkImg(areaId);
		
	}



	@Override
	public List<CompanyDO> buildingCompany(Integer buildingId,Integer orderField,String descAsc) {
		
		return companyMapper.buildingCompany(buildingId,orderField,descAsc);
		
	}



	
	@Override
	public List<CompanyTypeCountDO> buildingBusinessDistribute(Integer buildingId) {
		
		List<CompanyTypeCountDO> ljr = new ArrayList<>();
		
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_P2P_1,"p2p");
		
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_XD_2,"小额贷款");
		
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_RZDB_3,"融资担保");
		
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_XXLC_4,"线下理财");
		
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_SMJJ_5,"私募基金");
		
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_ZC_6,"众筹");
		
		List<CompanyTypeCountDO> bigType = new ArrayList<>();
		
		CompanyTypeCountDO ljrCount = new CompanyTypeCountDO();
		
		for (CompanyTypeCountDO ctc : ljr) {
			ljrCount.setCount( ljrCount.getCount()+ctc.getCount() );
		}
		ljrCount.setChildren(ljr);
		
		bigType.add(ljrCount.setType("类金融"));
		
		countTypeByBuild(bigType , buildingId ,CompanyDO.TYPE_JR_7,"金融");
		
		countTypeByBuild(bigType , buildingId ,CompanyDO.TYPE_QT_8,"其他");
		
		return bigType;
		
	}
	
	private void countTypeByBuild( List<CompanyTypeCountDO> list , Integer buildingId ,Byte type,String name){
		CompanyTypeCountDO b = companyMapper.countTypeByBuild(buildingId, CompanyDO.TYPE_P2P_1);
		list.add(b.setType(name));
		
	}


	@Override
	public List<CompanyTypeCountDO> buildingBackground(Integer buildingId) {
		
		List<CompanyTypeCountDO> list = new ArrayList<>();
		
		CompanyTypeCountDO gq = companyMapper.buildingBackground(buildingId,CompanyBackgroundDO.Bg.Gq.val);
		gq.setType(CompanyBackgroundDO.Bg.Gq.CN);
		list.add(gq);
		
		CompanyTypeCountDO myqy = companyMapper.buildingBackground(buildingId,CompanyBackgroundDO.Bg.Myqy.val);
		myqy.setType(CompanyBackgroundDO.Bg.Myqy.CN);
		list.add(myqy);
		
		return list;
	}



	@Override
	public List<CompanyNewsDO> buildingNews(Integer buildingId) {
		return buildingMapper.buildingNews(buildingId);
	}

}
