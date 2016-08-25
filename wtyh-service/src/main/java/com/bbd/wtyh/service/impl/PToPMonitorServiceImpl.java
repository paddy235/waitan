package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.poi.util.SystemOutLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.dto.AreaIndexDTO;
import com.bbd.wtyh.domain.dto.IndustryCompareDTO;
import com.bbd.wtyh.domain.dto.IndustryProblemDTO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.util.relation.HttpClientUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
					return JSON.parseArray(result, IndustryShanghaiDTO.class);
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
