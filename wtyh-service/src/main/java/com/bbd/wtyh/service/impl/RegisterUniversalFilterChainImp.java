package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.vo.LineVO;
import com.bbd.wtyh.domain.vo.PointVO;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.RegisterUniversalFilterChainService;
import com.bbd.wtyh.service.RelationCompanyService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import com.bbd.wtyh.service.impl.relation.common.APIConstants;
import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  David 
 * @param
 */
@Service("registerUniversalFilterChainService")
public class RegisterUniversalFilterChainImp implements RegisterUniversalFilterChainService {

	@Resource
	private RedisDAO redisDAO;
	@Resource
	private RelationCompanyService relationCompanyService;
	public HttpGet httpGet;
	
	public HttpClient client;
	
	private final static int retry = 3;
	
	@Value("${related.party.url}")
	private String url;
    
    /**
	 * @author  David 
	 * YED套系数据来源 并且 excel下载
	 * @param company
	 * @param
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<List<Object>> HierarchicalFuzzySearchDataJTTP(String company,String dataVersion) throws Exception
	{
	        //变为list后的数据
			List<List<Object>> list = new ArrayList<List<Object>>();
			JSONArray CombinationDataAll = null;
			String jstr = redisDAO.getString(company+APIConstants.redis_relation_LinksDataJTTP + dataVersion);
            if(!StringUtils.isEmpty(jstr)){
            	CombinationDataAll = JSONArray.fromObject(jstr);
            	list = JSONArray.toList(CombinationDataAll);	
            }else{
        	   jstr = relationCompanyService.getAPIDynamicRelatedPartUploadJTTP(company,APIConstants.show_relation_E,dataVersion);
        	   if (!StringUtils.isEmpty(jstr)) {
        		   CombinationDataAll = JSONArray.fromObject(jstr);
               	   list = JSONArray.toList(CombinationDataAll);   
        	   }
         } 
         return list;
		
	}

}
