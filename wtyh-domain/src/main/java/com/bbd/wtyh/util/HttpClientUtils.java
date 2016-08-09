package com.bbd.wtyh.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HttpClientUtils {
	
	private static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);  
	
	private final static int retry = 3;
	
	public static String httpGet(String strUrl) throws Exception {
		return httpGet(strUrl,0);
	}
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static String httpGet(String strUrl,int num) throws Exception {
		 HttpClient client = null;
		 InputStream in = null;  
		 BufferedReader reader = null;
		 String responseBody = "";
		 String r = "";
		 if(num >= retry)
	    	{
	    		throw new Exception("请求链接无效" + strUrl);
	    	}
		try{  
			URL url = new URL(strUrl);
	    	URI urlPath = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
			
			client = HttpClientManager.getHttpClient();  
		    Collection collection = new ArrayList();
	        collection.add(new BasicHeader("Accept", "text/html, application/xhtml+xml, */*"));
	        collection.add(new BasicHeader("Accept-Language", "zh-CN"));
	        collection.add(new BasicHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)"));
	        collection.add(new BasicHeader("DNT", "1"));
	        collection.add(new BasicHeader("Connection", "Keep-Alive"));
	        client.getParams().setParameter(ClientPNames.DEFAULT_HEADERS, collection);
			client.getParams().setParameter("http.socket.timeout",120000);
			client.getParams().setParameter("http.connection.timeout",20000);
			
			client.getParams().setParameter("http.protocol.allow-circular-redirects", true);
			HttpGet get = new HttpGet(urlPath);
			HttpResponse response = client.execute(get);
			System.out.println(response.getStatusLine().getStatusCode());
			HttpEntity entity =response.getEntity();
			if( entity != null ){ 
                reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8")); //
                String str = reader.readLine();
                while (str != null) {
                    r += str;
                    str = reader.readLine();
                }
				
			 /*in = entity.getContent();
			 BufferedReader br = new BufferedReader(new InputStreamReader(
					 in, "UTF-8"));
				StringBuffer resBuffer = new StringBuffer("\r\n");
				String resTemp = null;
				while ((resTemp = br.readLine()) != null) {
					resBuffer.append(resTemp);
				}

				responseBody = resBuffer.toString();*/

			} 
		}catch (Exception e){
			httpGet(strUrl,num+1);
			e.printStackTrace();
		}finally{  
			if (in != null){  
			try{
				in.close ();
				}catch (IOException e){ 
				e.printStackTrace (); 	
				}
			}  
		}
		return responseBody;  
	}
	
	public static String httpPost(String strUrl,List<NameValuePair> params) throws Exception {
		printUrl(strUrl, params);
		return httpPost(strUrl,params,0);
	}
	
	 /**
     * post请求
     * @return
     */
    public static String httpPost(String strUrl, List<NameValuePair> params, int num) throws Exception {
    	if(num >= retry)
    	{
    		throw new Exception("请求链接无效" + strUrl);
    	}
    	 HttpClient httpClient = null;
         HttpPost httpPost = null;
         String result = null;  
         try{  
             httpClient = HttpClientManager.getHttpClient(); 
             httpPost = new HttpPost(strUrl);
             //设置参数  
             if(params.size() > 0){  
                 UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
                 httpPost.setEntity(entity);  
             }  
             HttpResponse response = httpClient.execute(httpPost);
             if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
             {
            	 HttpEntity resEntity = response.getEntity();
                 if(resEntity != null){  
                     result = EntityUtils.toString(resEntity,"utf-8");
                 }  
             }else
             {
            	 log.error("API URL"+strUrl+"返回结果出错");
             }
         }catch(Exception ex){  
        	 result = httpPost(strUrl,params,num+1);
             ex.printStackTrace();  
         }finally{
        	 if (null != httpClient)
        		 httpPost.releaseConnection();
         } 
         return result; 
	    
		
	}
    
	/**
	 * 
	 * 打印URL链接
	 * 
	 * @param strUrl
	 * @param params
	 */
	public static void printUrl(String strUrl, List<NameValuePair> params) {
		String urlStr = "";
		for (NameValuePair nameValuePair : params) {
			urlStr += nameValuePair.getName() + "=" + nameValuePair.getValue() + "&";
		}
		urlStr = urlStr.substring(0, urlStr.length() - 1);
		log.info(strUrl + "?" + urlStr);
		System.out.println(strUrl + "?" + urlStr);
	}

}
