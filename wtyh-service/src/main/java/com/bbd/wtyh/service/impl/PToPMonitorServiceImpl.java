package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.bbd.wtyh.service.PToPMonitorService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 
* @author Ian.Su
* @since 2016年8月12日 下午2:09:15
*/
@Service
public class PToPMonitorServiceImpl implements PToPMonitorService {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Value("${financial.services.url}")
	private String finSerUrl;
	
	@Autowired
	private PlatformNameInformationMapper platformNameInformationMapper;
	  
    public List<IndustryCompareDTO> getCompareData() throws Exception{
    	

   		String url = this.finSerUrl+"?dataType=industry_compare";
		HttpTemplate httpTemplate = new HttpTemplate();
		try {
			return httpTemplate.get(url, new HttpCallback<List<IndustryCompareDTO>>() {
				@Override
				public boolean valid() {
					return true;
				}
				@Override
				public List<IndustryCompareDTO> parse(String result) {
					return JSON.parseArray(result, IndustryCompareDTO.class);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }













	public List<AreaIndexDTO> getAreaIndex() throws Exception{



		String url = this.finSerUrl+"?dataType=area_index";
		HttpTemplate httpTemplate = new HttpTemplate();
		try {
			return httpTemplate.get(url, new HttpCallback<List<AreaIndexDTO>>() {
				@Override
				public boolean valid() {
					return true;
				}
				@Override
				public List<AreaIndexDTO> parse(String result) {
					return JSON.parseArray(result, AreaIndexDTO.class);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


     	
     }





























    
   public List<PlatRankDataDTO> getPlatRankData() throws Exception{


	   String url = this.finSerUrl+"?dataType=plat_rank_data";
	   HttpTemplate httpTemplate = new HttpTemplate();
	   try {
		   return httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
			   @Override
			   public boolean valid() {
				   return true;
			   }
			   @Override
			   public List<PlatRankDataDTO> parse(String result) {
				   return JSON.parseArray(result, PlatRankDataDTO.class);
			   }
		   });
	   } catch (Exception e) {
		   e.printStackTrace();
		   return null;
	   }
     	
     }



	public Map getPlatRankMapData() throws Exception{

		List<PlatRankDataDTO> list = new ArrayList<>();
		String url = this.finSerUrl+"?dataType=plat_rank_data";
		HttpTemplate httpTemplate = new HttpTemplate();
		try {
			list = httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
				@Override
				public boolean valid() {
					return true;
				}
				@Override
				public List<PlatRankDataDTO> parse(String result) {
					return JSON.parseArray(result, PlatRankDataDTO.class);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<Integer, Integer> map = new HashMap();
		if (!CollectionUtils.isEmpty(list)) {
			for (PlatRankDataDTO platRankDataDTO : list) {
				String plat_name = platRankDataDTO.getPlat_name();
				PlatformNameInformationDO platformNameInformationDO = platformNameInformationMapper.hasOrNotCompany(plat_name);
				if (platformNameInformationDO != null) {
					map.put(platformNameInformationDO.getCompanyId(), 0);
				}
			}
		}
		return map;
	}














	public List<IndustryShanghaiDTO> getData() throws Exception{


		String url = this.finSerUrl+"?dataType=industry_shanghai";
		HttpTemplate httpTemplate = new HttpTemplate();
		try {
			return httpTemplate.get(url, new HttpCallback<List<IndustryShanghaiDTO>>() {
				@Override
				public boolean valid() {
					return true;
				}
				@Override
				public List<IndustryShanghaiDTO> parse(String result) {

					Gson gson = new Gson();

					List<IndustryShanghaiDTO> list = gson.fromJson(result,new TypeToken<List<IndustryShanghaiDTO>>(){}.getType());
					IndustryShanghaiDTO ja = null;
					IndustryShanghaiDTO zb = null;
					return list;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

    }










	public List<IndustryProblemDTO> getProblemData() throws Exception{


		 String url = this.finSerUrl+"?dataType=industry_problem";
		 HttpTemplate httpTemplate = new HttpTemplate();
		 try {
			 return httpTemplate.get(url, new HttpCallback<List<IndustryProblemDTO>>() {
				 @Override
				 public boolean valid() {
					 return true;
				 }
				 @Override
				 public List<IndustryProblemDTO> parse(String result) {
					 return JSON.parseArray(result, IndustryProblemDTO.class);
				 }
			 });
		 } catch (Exception e) {
			 e.printStackTrace();
			 return null;
		 }
    	 
     }







	public static void main(String [] agrs) throws Exception {

//		String url = "http://140.206.51.154:5002/financial_services?dataType=industry_problem";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<IndustryProblemDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<IndustryProblemDTO> parse(String result) {
//					return JSON.parseArray(result, IndustryProblemDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}




//		String url = "http://140.206.51.154:5002/financial_services?dataType=industry_shanghai";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<IndustryShanghaiDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<IndustryShanghaiDTO> parse(String result) {
//					return JSON.parseArray(result, IndustryShanghaiDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}

//
//		String url = "http://140.206.51.154:5002/financial_services?dataType=plat_rank_data";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<PlatRankDataDTO> parse(String result) {
//					return JSON.parseArray(result, PlatRankDataDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}


//		String url = "http://140.206.51.154:5002/financial_services?dataType=industry_compare";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<IndustryCompareDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<IndustryCompareDTO> parse(String result) {
//					return JSON.parseArray(result, IndustryCompareDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}






//报错
		String url ="http://140.206.51.154:5002/financial_services?dataType=area_index";

		HttpTemplate httpTemplate = new HttpTemplate();
		try {
			 httpTemplate.get(url, new HttpCallback<List<AreaIndexDTO>>() {
				@Override
				public boolean valid() {
					return true;
				}
				@Override
				public List<AreaIndexDTO> parse(String result) {
					return JSON.parseArray(result, AreaIndexDTO.class);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}



//		String url = "http://140.206.51.154:5002/financial_services?dataType=plat_rank_data";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<PlatRankDataDTO> parse(String result) {
//					return JSON.parseArray(result, PlatRankDataDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}




	}




















}
