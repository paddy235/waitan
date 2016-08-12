package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.service.CompanySearchAPIService;
import com.bbd.wtyh.util.relation.HttpClientUtils;

/**
* 
* @author Ian.Su
* @since 2016年8月11日 上午10:38:54
*/
@Service
public class CompanySearchAPIServiceImpl implements CompanySearchAPIService {
	
	@Value("${api.search.company.url}")
	private String url;
	
	
	@Value("${api.search.company.version}")
	private String apiVersion;
	
	@Value("${api.search.company.access.token}")
	private String token;
	

	/**
	 * 调用第三方接口
	 * 
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public String searchCompanyByKeyword(String keyword) throws Exception {
		if (StringUtils.isEmpty(url)) {
			throw new Exception("调用第三方接口地址为空，url=" + url);
		}
		return HttpClientUtils.httpPost(url, getUrlParam(keyword));
	}
	
	/**
	 * 查询参数组装
	 * 
	 * @param keyword
	 * @param areaCode
	 * @return
	 */
	private List<NameValuePair> getUrlParam(String keyword) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("access_token", this.token));
		params.add(new BasicNameValuePair("fields", "名称"));//URLEncoder.encode(Constants.SEARCH_API_FIELDS, Constants.CHARACTER_CODE)));
		params.add(new BasicNameValuePair("fields", "history_name"));
		params.add(new BasicNameValuePair("table", "qyxx"));
		params.add(new BasicNameValuePair("version", this.apiVersion));
		params.add(new BasicNameValuePair("company_name", keyword.trim()));// URLEncoder.encode(keyword.trim(), Constants.CHARACTER_CODE)));
		params.add(new BasicNameValuePair("page_size", "5"));
		params.add(new BasicNameValuePair("searchtype", "detail"));
		params.add(new BasicNameValuePair("filter", "dafei_users:shanghai" ));
		return params;
	}


}
