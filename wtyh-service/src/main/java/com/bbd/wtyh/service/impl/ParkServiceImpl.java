package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyBackgroundDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;
import com.bbd.wtyh.mapper.BuildingMapper;
import com.bbd.wtyh.mapper.CompanyAnalysisResultMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.ParkMapper;
import com.bbd.wtyh.service.ParkService;
import com.bbd.wtyh.util.relation.HttpClientUtils;

/**
* 
* @author Ian.Su
* @since 2016年8月5日 下午5:45:41
*/
@Service
public class ParkServiceImpl implements ParkService {

	
	
	@Value("${api.baidu.batch.news.url}")
	private String batchNewsUrl;
	
	@Value("${api.baidu.batch.news.ktype}")
	private int ktype;

	@Value("${api.baidu.batch.news.ak}")
	private String ak;
	
	@Autowired
	private BuildingMapper buildingMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	
	@Autowired
	private ParkMapper parkMapper;
	
	@Autowired
	private CompanyAnalysisResultMapper carMapper;

	@Override
	public List<BuildingDO> queryBuildings(Integer areaId) {
		
		return buildingMapper.queryBuildings(areaId);
		
	}

	

	@Override
	public List<InBusinessDO> inBusiness(Integer areaId) {
		
		List<InBusinessDO> list = new ArrayList<>();
		
		Date now = new Date();
		
		Date year10 = DateUtils.addYears(now, -10);
		Date year5 = DateUtils.addYears(now, -5);
		Date year3 = DateUtils.addYears(now, -3);
		Date year1 = DateUtils.addYears(now, -1);

		list.add(inBusiness("10年以上",areaId, null    , DateFormatUtils.format(year10,"yyyy-MM-dd")));
		list.add(inBusiness("5-10年" ,areaId,  DateFormatUtils.format(year10,"yyyy-MM-dd")  ,
				                               DateFormatUtils.format(year5,"yyyy-MM-dd")));
		list.add(inBusiness("3-5年",areaId,    DateFormatUtils.format(year5,"yyyy-MM-dd")   ,
				                               DateFormatUtils.format(year3,"yyyy-MM-dd")));
		list.add(inBusiness("1-3年",areaId,    DateFormatUtils.format(year3,"yyyy-MM-dd")   ,
				                               DateFormatUtils.format(year1,"yyyy-MM-dd")));
		list.add(inBusiness("1年以下",areaId,   DateFormatUtils.format(year1,"yyyy-MM-dd")    ,
				                               DateFormatUtils.format(now,"yyyy-MM-dd")));
		
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
	public InBusinessDO inBusiness(String dateRange,Integer areaId,String start,String end) {
		
		InBusinessDO bean = companyMapper.countByDate(areaId, start, end);
		
		bean.setDate(dateRange);
		 
		return bean;
	}
	
	

	@Override
	public String queryParkNews(Integer areaId,Integer pageSize,Integer pageNum){
		
		String names = companyMapper.queryCompanyNames(areaId,null);
		if(StringUtils.isEmpty(names)){
			//return null;
			names = "DCM投资管理咨询（北京）有限公司上海分公司,GMS中国办事处,I.TCHINA,《国际金融报》社有限公司,一创（上海）投资管理中心（有限合伙）,一半堂投资管理（上海）有限公司,一尘（上海）投资管理有限公司,一忆（上海）股权投资管理有限公司,一思资产管理（上海）有限公司,一村资产管理有限公司,一村资本有限公司,一欣投资管理（上海）有限公司,一济投资管理有限公司,一溪投资管理（上海）有限公司,一炫定稚资产管理（上海）有限公司,一片蓝（上海）投资管理合伙企业（有限合伙）,一翼（上海）互联网金融信息服务有限公司,一诺千诚投资管理（上海）有限公司,一诺千诚金融信息服务（上海）有限公司,一财众联财富管理有限公司,一财长富资产管理有限公司";
		}
		List<NameValuePair> list = new ArrayList<>();
		list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1)   ));
		list.add(new BasicNameValuePair("ktype", ""+ktype));
		list.add(new BasicNameValuePair("page", pageNum+""));
		list.add(new BasicNameValuePair("pageSize", pageSize+""));
		list.add(new BasicNameValuePair("ak",ak));
		
	
		try {
			return HttpClientUtils.httpPost(batchNewsUrl, list );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}



	@Override
	public String buildingNews(Integer buildingId) {
		
		String names = companyMapper.queryCompanyNames(null,buildingId);
		if(StringUtils.isEmpty(names)){
			return null;
		}
		List<NameValuePair> list = new ArrayList<>();
		list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1)  ));
		list.add(new BasicNameValuePair("ktype", ""+ktype));
		list.add(new BasicNameValuePair("pageSize", "20"));
		list.add(new BasicNameValuePair("page", "1"));
		list.add(new BasicNameValuePair("ak",ak));
		try {
			return HttpClientUtils.httpPost(batchNewsUrl, list );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
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
		
		List<CompanyDO>  list = companyMapper.buildingCompany(buildingId,orderField,descAsc);
		
		
		return list;
		
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
	public List<CompanyAnalysisResultDO> queryRiskByBuilding(Integer buildingId) {

		List<CompanyAnalysisResultDO> list = carMapper.queryRiskByBuilding(buildingId);

		return list;
		
	}



	

}
