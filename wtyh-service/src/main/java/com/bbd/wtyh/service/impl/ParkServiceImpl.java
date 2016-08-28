package com.bbd.wtyh.service.impl;

import java.util.*;

import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.DataomApiBbdservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
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
import com.bbd.wtyh.service.ParkService;
import com.bbd.wtyh.util.relation.HttpClientUtils;

/**
* 
* @author Ian.Su
* @since 2016年8月5日 下午5:45:41
*/
@Service
public class ParkServiceImpl implements ParkService {


	private static Logger log = LoggerFactory.getLogger(ParkServiceImpl.class);
	
	
	@Value("${api.baidu.batch.news.url}")
	private String batchNewsUrl;
	
	@Value("${api.baidu.batch.news.ktype}")
	private int ktype;

	@Value("${api.baidu.batch.news.ak}")
	private String ak;

	@Autowired
	private DataomApiBbdservice dataomApiBbdservice;

	@Autowired
	private StaticRiskMapper staticRiskMapper;
	
	@Autowired
	private BuildingMapper buildingMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	
	@Autowired
	private ParkMapper parkMapper;

	@Autowired
	private CompanyNewsService cns;
	
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

		String result = null;
		String names = companyMapper.queryCompanyNames(areaId,null);
		log.info("園區舆情公司爲："+names);
		if(!StringUtils.isEmpty(names)){
			List<NameValuePair> list = new ArrayList<>();
			list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1)   ));
			list.add(new BasicNameValuePair("ktype", ""+ktype));
			list.add(new BasicNameValuePair("page", pageNum+""));
			list.add(new BasicNameValuePair("pageSize", pageSize+""));
			list.add(new BasicNameValuePair("ak",ak));
			try {
				result = HttpClientUtils.httpPost(batchNewsUrl, list );

				log.info("舆情："+batchNewsUrl+" 返回值为:"+result);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if( !StringUtils.hasText(result) || result.contains("\"total\": 0")){
			return cns.getCompanyNews();
		}

		return result;
		
	}



	@Override
	public String buildingNews(Integer buildingId) {
		
		String names = companyMapper.queryCompanyNames(null,buildingId);
		String result = null;
		if(!StringUtils.isEmpty(names)){
			List<NameValuePair> list = new ArrayList<>();
			list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1)   ));
			list.add(new BasicNameValuePair("ktype", ""+ktype));
			list.add(new BasicNameValuePair("page", "1"));
			list.add(new BasicNameValuePair("pageSize", "20"));
			list.add(new BasicNameValuePair("ak",ak));
			try {
				result = HttpClientUtils.httpPost(batchNewsUrl, list );
				log.info("舆情："+batchNewsUrl+" 返回值为:"+result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if( !StringUtils.hasText(result) || result.contains("\"total\": 0")){
			return cns.getCompanyNews();
		}

		return result;
		
	}
	
	
	

	@Override
	public List<CompanyTypeCountDO> businessDistribute(Integer areaId) {
		
		List<CompanyTypeCountDO> ljr = new ArrayList<>();
		
		countType(ljr , areaId ,CompanyDO.TYPE_P2P_1,"P2P");
		countType(ljr , areaId ,CompanyDO.TYPE_XD_2,"小额贷款");
		countType(ljr , areaId ,CompanyDO.TYPE_RZDB_3,"融资担保");
		countType(ljr , areaId ,CompanyDO.TYPE_XXLC_4,"线下理财");
		countType(ljr , areaId ,CompanyDO.TYPE_SMJJ_5,"私募基金");
		countType(ljr , areaId ,CompanyDO.TYPE_ZC_6,"众筹");
		countType(ljr , areaId ,CompanyDO.TYPE_JYS_9,"交易所");
		countType(ljr , areaId ,CompanyDO.TYPE_SYBL_10,"商业保理");
		countType(ljr , areaId ,CompanyDO.TYPE_YFK_11,"预付卡");
		countType(ljr , areaId ,CompanyDO.TYPE_DD_12,"典当");
		countType(ljr , areaId ,CompanyDO.TYPE_RZZL_13,"融资租赁");
		//公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:金融 8:其他 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁

		List<CompanyTypeCountDO> bigType = new ArrayList<>();
		
		CompanyTypeCountDO ljrCount = new CompanyTypeCountDO();
		
		for (CompanyTypeCountDO ctc : ljr) {
			ljrCount.setCount( ljrCount.getCount()+ctc.getCount() );
		}
		ljrCount.setChildren(ljr);
		bigType.add(ljrCount.setType("新型金融"));
		
		countType(bigType , areaId ,CompanyDO.TYPE_JR_7,"金融");
		countType(bigType , areaId ,CompanyDO.TYPE_QT_8,"其他");
		
		return bigType;
	}
	
	private void countType( List<CompanyTypeCountDO> list , Integer areaId ,Byte type,String name){
		CompanyTypeCountDO b = companyMapper.countByType(areaId, type);
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
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_P2P_1,"P2P");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_XD_2,"小额贷款");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_RZDB_3,"融资担保");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_XXLC_4,"线下理财");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_SMJJ_5,"私募基金");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_ZC_6,"众筹");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_JYS_9,"交易所");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_SYBL_10,"商业保理");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_YFK_11,"预付卡");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_DD_12,"典当");
		countTypeByBuild(ljr , buildingId ,CompanyDO.TYPE_RZZL_13,"融资租赁");
		
		List<CompanyTypeCountDO> bigType = new ArrayList<>();
		
		CompanyTypeCountDO ljrCount = new CompanyTypeCountDO();
		
		for (CompanyTypeCountDO ctc : ljr) {
			ljrCount.setCount( ljrCount.getCount()+ctc.getCount() );
		}
		ljrCount.setChildren(ljr);
		
		bigType.add(ljrCount.setType("新型金融"));
		
		countTypeByBuild(bigType , buildingId ,CompanyDO.TYPE_JR_7,"金融");
		countTypeByBuild(bigType , buildingId ,CompanyDO.TYPE_QT_8,"其他");
		
		return bigType;
		
	}
	
	private void countTypeByBuild( List<CompanyTypeCountDO> list , Integer buildingId ,Byte type,String name){
		CompanyTypeCountDO b = companyMapper.countTypeByBuild(buildingId, type);
		list.add(b.setType(name));
		
	}


	@Override
	public List<CompanyTypeCountDO> buildingBackground(Integer buildingId) {

		List<CompanyDO> data = buildingCompany(buildingId,null,"asc");

		List<CompanyTypeCountDO> list = new ArrayList<>();
		CompanyTypeCountDO gq = new CompanyTypeCountDO();
		gq.setType(CompanyBackgroundDO.Bg.Gq.CN);
		list.add(gq);
		CompanyTypeCountDO myqy = new CompanyTypeCountDO();
		myqy.setType(CompanyBackgroundDO.Bg.Myqy.CN);
		list.add(myqy);
		for (CompanyDO cdo:data) {
			if(cdo.getBackground()==3){
				gq.setCount(gq.getCount()+1);
			}else{
				myqy.setCount(myqy.getCount()+1);
			}
		}
		
		return list;
	}







	@Override
	public List<CompanyAnalysisResultDO> queryRiskByBuilding(Integer buildingId) {

		List<CompanyAnalysisResultDO> list = carMapper.queryRiskByBuilding(buildingId);
		List<CompanyAnalysisResultDO> black_1 = new ArrayList();
		List<CompanyAnalysisResultDO> other_234 = new ArrayList();

		for (CompanyAnalysisResultDO car : list) {
			log.info("企业名称："+car.getName());
			if(car.getAnalysisResult()!=null && car.getAnalysisResult() == 1){
				black_1.add(car);
			}else{
				Float staticsRiskIndex = staticRiskMapper.queryStaticsRiskIndex(car.getName());
				staticsRiskIndex = staticsRiskIndex==null?0:staticsRiskIndex;
				car.setStaticRiskIndex(staticsRiskIndex+"");
				car.setAnalysisResult(getIndex(staticsRiskIndex));
				other_234.add(car);
			}
		}
		sortByDate(black_1);
		sortByIndex(other_234);

		black_1.addAll(other_234);

		return black_1;
	}



	private void sortByIndex(List<CompanyAnalysisResultDO> list){
		Collections.sort(list, new Comparator<CompanyAnalysisResultDO>() {
			@Override
			public int compare(CompanyAnalysisResultDO o1, CompanyAnalysisResultDO o2) {
				if(o1.getStaticRiskIndex()==null ){
					return -1;
				}
				if(o2.getStaticRiskIndex()==null){
					return 1;
				}
				return new Float(o1.getStaticRiskIndex()).compareTo(new Float(o2.getStaticRiskIndex()));
			}
		});
	}



	private void sortByDate(List<CompanyAnalysisResultDO> black_1){
		Collections.sort(black_1, new Comparator<CompanyAnalysisResultDO>() {
			@Override
			public int compare(CompanyAnalysisResultDO o1, CompanyAnalysisResultDO o2) {
				if(o1.getExposureDate()==null ){
					return -1;
				}
				if(o2.getExposureDate()==null){
					return 1;
				}

				return o1.getExposureDate().compareTo(o2.getExposureDate());
			}
		});
	}



	// 颜色 1:已曝光(黑) 2:高危(红) 3:关注(黄) 4:正常(绿)
	private byte getIndex(float index){
		if (index > 70) {
			return 2;//2:高危(红)
		} else if (index >= 60 && index < 70) {
			return 3; // 3:关注(黄)
		} else {
			return 4; // 4:正常(绿)
		}
	}
	

}
