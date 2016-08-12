package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
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
    	
    	List<IndustryCompareDTO> list;
   	 
    	
    	List<NameValuePair> param = new ArrayList<>();
     	param.add(new BasicNameValuePair("dataType", "industry_compare"));
     	
    	String json = HttpClientUtils.httpPost(this.finSerUrl,param);
    	
     	Gson gson = new Gson();
     	list = gson.fromJson(json, new TypeToken<ArrayList<IndustryCompareDTO>>(){}.getType());
     	
     	return list;
    	
    }
    
    
    public List<AreaIndexDTO> getAreaIndex() throws Exception{
     	
     	List<AreaIndexDTO> list;
   	 
    	
    	List<NameValuePair> param = new ArrayList<>();
     	param.add(new BasicNameValuePair("dataType", "area_index"));
     	
    	String json = HttpClientUtils.httpPost(this.finSerUrl,param);
    	
     	log.info(json);
     	Gson gson = new Gson();
     	list = gson.fromJson(json, new TypeToken<ArrayList<AreaIndexDTO>>(){}.getType());
     	
     	return list;
     	
     }
    
    
   public List<PlatRankDataDTO> getPlatRankData() throws Exception{
     	
     	List<PlatRankDataDTO> list ;
     	
     	List<NameValuePair> param = new ArrayList<>();
     	param.add(new BasicNameValuePair("dataType", "plat_rank_data"));
     	
    	String json = HttpClientUtils.httpPost(this.finSerUrl,param);
     	
     	log.info(json);
     	Gson gson = new Gson();
     	list = gson.fromJson(json, new TypeToken<ArrayList<PlatRankDataDTO>>(){}.getType());
     	
     	return list;
     	
     }
     

    public List<IndustryShanghaiDTO> getData() throws Exception{
    	
    	
    	List<NameValuePair> param = new ArrayList<>();
     	param.add(new BasicNameValuePair("dataType", "industry_shanghai"));
     	
    	String json = HttpClientUtils.httpPost(this.finSerUrl,param);
    
    	log.info(json);
    	Gson gson = new Gson();
    	List<IndustryShanghaiDTO> list  = gson.fromJson(json, new TypeToken<ArrayList<IndustryShanghaiDTO>>(){}.getType());
    	
    	return list;
    }
    
    
    
    
     public List<IndustryProblemDTO> getProblemData() throws Exception{
     	
     	List<IndustryProblemDTO> list;
    	
     	List<NameValuePair> param = new ArrayList<>();
     	param.add(new BasicNameValuePair("dataType", "industry_problem"));
     	
    	String json = HttpClientUtils.httpPost(this.finSerUrl,param);
     	log.info(json);
     	Gson gson = new Gson();
     	list = gson.fromJson(json, new TypeToken<ArrayList<IndustryProblemDTO>>(){}.getType());
     	
     	return list;
    	 
     }
     
     
    
}
