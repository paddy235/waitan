package com.bbd.wtyh.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-07-12 14:52.
 */
public class HttpUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	private static final String PROXY_ENV_NAME = "http_proxy";

	public static String post(String url) throws Exception {
		return post(url, null, null, 0);
	}

	public static String post(String url, Map<String, Object> params) throws Exception {
		return post(url, null, params, 0);
	}

	public static String post(String url, Map<String, Object> params, int timeout) throws Exception {
		return post(url, null, params, timeout);
	}

	public static String post(String url, Map<String, String> header, Map<String, Object> params) throws Exception {
		return post(url, header, params, 0);
	}

	public static String post(String url, Map<String, String> header, Map<String, Object> params, int timeout) throws Exception {
		HttpEntity httpEntity = httpPostEntity(url, header, params, timeout, null);
		return EntityUtils.toString(httpEntity);
	}

	public static <T> T post(String url, Class<T> clazz) throws Exception {
		return post(url, null, null, 0, clazz);
	}

	public static <T> T post(String url, Map<String, Object> params, Class<T> clazz) throws Exception {
		return post(url, null, params, 0, clazz);
	}

	public static <T> T post(String url, Map<String, Object> params, int timeout, Class<T> clazz) throws Exception {
		return post(url, null, params, timeout, clazz);
	}

	public static <T> T post(String url, Map<String, String> header, Map<String, Object> params, Class<T> clazz) throws Exception {
		return post(url, header, params, 0, clazz);
	}

	public static <T> T post(String url, Map<String, String> header, Map<String, Object> params, int timeout, Class<T> clazz)
			throws Exception {
		HttpEntity httpEntity = httpPostEntity(url, header, params, timeout, clazz);
		if (clazz.equals(InputStream.class)) {
			return (T) httpEntity.getContent();
		}
		String str = EntityUtils.toString(httpEntity);
		return JSON.parseObject(str, clazz);
	}

	private static HttpEntity httpPostEntity(String url, Map<String, String> header, Map<String, Object> params, int timeout,
			Class<?> clazz) throws Exception {
		HttpEntityEnclosingRequestBase httpRequest = new HttpPost(url);
		// 构建请求参数
		if (params != null && !params.isEmpty()) {
			List<NameValuePair> paramList = new ArrayList<>();
			for (Map.Entry<String, Object> e : params.entrySet()) {
				NameValuePair nameValuePair = new BasicNameValuePair(e.getKey(), e.getValue().toString());
				paramList.add(nameValuePair);
			}
			httpRequest.setEntity(new UrlEncodedFormEntity(paramList));
		}
		return httpEntity(httpRequest, url, header, params, timeout, clazz);
	}

	/******************************************************** get ************************************************************/
	public static String get(String url) throws Exception {
		return get(url, null, null, 0);
	}

	public static String get(String url, Map<String, Object> params) throws Exception {
		return get(url, null, params, 0);
	}

	public static String get(String url, Map<String, Object> params, int timeout) throws Exception {
		return get(url, null, params, timeout);
	}

	public static String get(String url, Map<String, String> header, Map<String, Object> params) throws Exception {
		return get(url, header, params, 0);
	}

	public static String get(String url, Map<String, String> header, Map<String, Object> params, int timeout) throws Exception {
		HttpEntity httpEntity = httpGetEntity(url, header, params, timeout, null);
		return EntityUtils.toString(httpEntity);
	}

	public static <T> T get(String url, Class<T> clazz) throws Exception {
		return get(url, null, null, 0, clazz);
	}

	public static <T> T get(String url, Map<String, Object> params, Class<T> clazz) throws Exception {
		return get(url, null, params, 0, clazz);
	}

	public static <T> T get(String url, Map<String, Object> params, int timeout, Class<T> clazz) throws Exception {
		return get(url, null, params, timeout, clazz);
	}

	public static <T> T get(String url, Map<String, String> header, Map<String, Object> params, Class<T> clazz) throws Exception {
		return get(url, header, params, 0, clazz);
	}

	public static <T> T get(String url, Map<String, String> header, Map<String, Object> params, int timeout, Class<T> clazz)
			throws Exception {
		HttpEntity httpEntity = httpGetEntity(url, header, params, timeout, clazz);
		if (clazz.equals(InputStream.class)) {
			return (T) httpEntity.getContent();
		}
		String str = EntityUtils.toString(httpEntity);
		return JSON.parseObject(str, clazz);
	}

	private static HttpEntity httpGetEntity(String url, Map<String, String> header, Map<String, Object> params, int timeout, Class<?> clazz)
			throws Exception {
		// 构建请求参数
		StringBuilder sb = new StringBuilder(url);
		if (params != null && !params.isEmpty()) {
			if (!url.contains("?")) {
				sb.append("?");
			}
			for (Map.Entry<String, Object> e : params.entrySet()) {
				sb.append(e.getKey());
				sb.append("=");
				sb.append(URLEncoder.encode(e.getValue().toString(), "UTF-8"));
				sb.append("&");
			}
		}
		url = sb.toString();
		HttpGet httpRequest = new HttpGet(url);
		return httpEntity(httpRequest, url, header, params, timeout, clazz);
	}

	protected static HttpClientBuilder createHttpClientBuilder(String url) throws Exception {
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		String httpProxy = System.getenv(PROXY_ENV_NAME);
		// 设置http代理
		if (StringUtils.isNotEmpty(httpProxy)) {
			URI httpProxyUri = new URI(httpProxy);
			if (StringUtils.isNotEmpty(httpProxyUri.getUserInfo())) {
				CredentialsProvider credsProvider = new BasicCredentialsProvider();
				credsProvider.setCredentials(new AuthScope(httpProxyUri.getHost(), httpProxyUri.getPort()),
						new UsernamePasswordCredentials(httpProxyUri.getUserInfo()));
				httpClientBuilder.setDefaultCredentialsProvider(credsProvider);
			}
			httpClientBuilder.setProxy(new HttpHost(httpProxyUri.getHost(), httpProxyUri.getPort(), httpProxyUri.getScheme()));
		}

		// 非https请求
		if (!url.toUpperCase().startsWith("HTTPS://")) {
			return httpClientBuilder;
		}
		// 后续处理支持https

		// 信任所有
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		httpClientBuilder.setSSLSocketFactory(sslsf);
		return httpClientBuilder;
	}

	protected static void closeHttpResource(CloseableHttpClient closeableHttpClient, CloseableHttpResponse closeableHttpResponse)
			throws Exception {
		if (closeableHttpResponse != null) {
			closeableHttpResponse.close();
		}
		if (closeableHttpClient != null) {
			closeableHttpClient.close();
		}
	}

	private static HttpEntity httpEntity(HttpRequestBase httpRequest, String url, Map<String, String> header, Map<String, Object> params,
			int timeout, Class<?> clazz) throws Exception {
		HttpClientBuilder httpClientBuilder = createHttpClientBuilder(url);

		RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
		if (timeout > 0) {
			requestConfigBuilder.setConnectTimeout(timeout * 1000).setSocketTimeout(timeout * 1000);
		}
		if (MapUtils.isNotEmpty(header)) {
			for (Map.Entry<String, String> map : header.entrySet()) {
				httpRequest.setHeader(map.getKey(), map.getValue());
			}
		}
		httpRequest.setConfig(requestConfigBuilder.build());

		CloseableHttpClient closeableHttpClient = null;
		CloseableHttpResponse closeableHttpResponse = null;
		try {
			closeableHttpClient = httpClientBuilder.build();
			closeableHttpResponse = closeableHttpClient.execute(httpRequest);
			logger.debug("execute {} request。url:{};params:{};header:{}", httpRequest.getMethod(), url, params, header);
			return closeableHttpResponse.getEntity();
		} finally {
			if (!InputStream.class.equals(clazz)) {
				closeHttpResource(closeableHttpClient, closeableHttpResponse);
			}
		}
	}

}
