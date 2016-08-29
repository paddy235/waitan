package com.bbd.wtyh.service.impl.relation;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.relation.APIConstants;
import com.bbd.wtyh.util.relation.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ApiContainerService {

	private	final String PARAM_TOKEN = "access_token";//系统级参数，用户或APP接入唯一标识
	
	private final String PARAM_TABLE = "table";//数据类型，对应mongo中表名
	
	private final String PARAM_FIELD = "fields";//对应匹配公司名的字段
	
	private final String PARAM_COMPANYNAME = "company_name";//公司名称
	
	private final String PARAM_VERSION = "version";//API 版本号
	
	private final String PARAM_SEARCHTYPE = "searchtype";//模糊搜索传search，返回最多10条 精确匹配传detail，返回最多1条
	
	private final String PARAM_REQUIRE = "require";//返回数据的字段，不传会返回所有字段
	
	private final String JSON_OBJ_MSG = "msg";
	
	private final String JSON_OBJ_OK = "OK";
	
	private final String JSON_OBJ_RDATA = "rdata";

	private final String PARAM_PAGE_NO = "page_no";

	private final String PARAM_PAGE_SIZE = "page_size";
	/**
	 * API Container Post接口方法
	 * 
	 * @param url
	 *            URL
	 * @param table
	 *            表名
	 * @param company_name
	 *            公司名
	 * @param searchtype
	 *            查询类型
	 * @param require
	 *            必选字段
	 * @return
	 */
	protected String apiContainerServicePost(String url, String table, String company_name, String field, String searchtype,String version,String... require)
			throws Exception {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		paramList.add(new BasicNameValuePair(PARAM_TOKEN, APIConstants.ACCESS_TOKEN));
		paramList.add(new BasicNameValuePair(PARAM_TABLE, table));
		paramList.add(new BasicNameValuePair(PARAM_FIELD, field));
		paramList.add(new BasicNameValuePair(PARAM_COMPANYNAME, company_name));
		if(StringUtils.isNotNullOrEmpty(version))
		{
			paramList.add(new BasicNameValuePair(PARAM_VERSION, version));
		}
		if(StringUtils.isNotNullOrEmpty(searchtype))
		{
			paramList.add(new BasicNameValuePair(PARAM_SEARCHTYPE, searchtype));
		}
		if (require != null) {
			for (int i = 0; i < require.length; i++) {
 				paramList.add(new BasicNameValuePair(PARAM_REQUIRE, require[i].trim()));
			}
		}
		return new HttpTemplate().post(url, paramList);
	}

	//分页查询API
	protected String apiContainerServicePostByPage(String url, String table, String company_name, String[] field, String searchtype, String version, Integer page_no, Integer page_size,String... require)
			throws Exception {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		paramList.add(new BasicNameValuePair(PARAM_TOKEN, APIConstants.ACCESS_TOKEN));
		paramList.add(new BasicNameValuePair(PARAM_TABLE, table));
		if (field != null) {
			for (int i = 0; i < field.length; i++) {
				paramList.add(new BasicNameValuePair(PARAM_FIELD, field[i].trim()));
			}
		}
		paramList.add(new BasicNameValuePair(PARAM_COMPANYNAME, company_name));
		if (StringUtils.isNotNullOrEmpty(version)) {
			paramList.add(new BasicNameValuePair(PARAM_VERSION, version));
		}
		if (StringUtils.isNotNullOrEmpty(searchtype)) {
			paramList.add(new BasicNameValuePair(PARAM_SEARCHTYPE, searchtype));
		}
		//分页
		paramList.add(new BasicNameValuePair(PARAM_PAGE_NO, page_no.toString()));
		paramList.add(new BasicNameValuePair(PARAM_PAGE_SIZE, page_size.toString()));
		if (require != null) {
			for (int i = 0; i < require.length; i++) {
				paramList.add(new BasicNameValuePair(PARAM_REQUIRE, require[i].trim()));
			}
		}
		return new HttpTemplate().post(url, paramList);
	}

	//不分页查询API
	protected String apiContainerServicePost(String url, String table, String company_name, String[] field, String searchtype, String version, String... require)
			throws Exception {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		paramList.add(new BasicNameValuePair(PARAM_TOKEN, APIConstants.ACCESS_TOKEN));
		paramList.add(new BasicNameValuePair(PARAM_TABLE, table));
		if (field != null) {
			for (int i = 0; i < field.length; i++) {
				paramList.add(new BasicNameValuePair(PARAM_FIELD, field[i].trim()));
			}
		}
		paramList.add(new BasicNameValuePair(PARAM_COMPANYNAME, company_name));
		if (StringUtils.isNotNullOrEmpty(version)) {
			paramList.add(new BasicNameValuePair(PARAM_VERSION, version));
		}
		if (StringUtils.isNotNullOrEmpty(searchtype)) {
			paramList.add(new BasicNameValuePair(PARAM_SEARCHTYPE, searchtype));
		}
		if (require != null) {
			for (int i = 0; i < require.length; i++) {
				paramList.add(new BasicNameValuePair(PARAM_REQUIRE, require[i].trim()));
			}
		}
		return new HttpTemplate().post(url, paramList);
	}
	
	public String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}
	/**
	 * 通过原始数据获取rdata 数据
	 * @param originalData
	 * @return
	 */
	protected String getRdata (String originalData)throws Exception
	{
			JSONObject  object= JSONObject.fromObject(originalData);
			String msg = object.getString(JSON_OBJ_MSG);
			String rdataString = "";
			if(JSON_OBJ_OK.equals(msg))
			{
				JSONArray rdata = object.getJSONArray(JSON_OBJ_RDATA);
				if(rdata.size()==0)
				{
					return null;
				}else
				{
					rdataString = rdata.toString();
				}
				
			}else
			{
				rdataString = msg;
			}
			return rdataString;
	}
	
	/**
	 * 将json 中key 由中文转成英文
	 * @param originalJson
	 * @param map
	 * @return
	 */
	protected String translateJsonKey (String originalJson,Map<String,String> map)
	{
		for (String key : map.keySet()) 
		{
			originalJson = originalJson.replace("\""+key+"\":" , "\""+map.get(key)+"\":");
		}
		return originalJson;
		
	}
	
	/**
	 * 校验API 接口数据 是否正常
	 * @param originalData
	 * @return
	 */
	protected boolean checkData (String originalData)
	{
			boolean flag = false;
			JSONObject  object= JSONObject.fromObject(originalData);
			String msg = object.getString(JSON_OBJ_MSG);
			if(JSON_OBJ_OK.equals(msg))
			{
				flag = true;
			}
			return flag;
	}
	
	/**
	 * 此方法用以向第三方http接口请求数据
	 * 
	 * @auther 刘兆强
	 * @date 2015年12月24日 下午2:08:40
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	protected String apiSendHttpPost(String url, Map<String, String> params) throws Exception {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		
		if (null != params && params.size() > 0) {
			Iterator it = params.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				paramList.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
			}
		}
		return new HttpTemplate().post(url, paramList);
	}

}
