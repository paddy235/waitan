package com.bbd.wtyh.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.Closeable;
import java.io.IOException;
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

    public static String post(String url, Map<String, Object> params, int timeoutSecond) throws Exception {
        return post(url, null, params, timeoutSecond);
    }

    public static String post(String url, Map<String, String> header, Map<String, Object> params) throws Exception {
        return post(url, header, params, 0);
    }

    public static String post(String url, Map<String, String> header, Map<String, Object> params, int timeoutSecond) throws Exception {
        return post(url, header, params, timeoutSecond, String.class);
    }

    public static <T> T post(String url, Class<T> clazz) throws Exception {
        return post(url, null, null, 0, clazz);
    }

    public static <T> T post(String url, Map<String, Object> params, Class<T> clazz) throws Exception {
        return post(url, null, params, 0, clazz);
    }

    public static <T> T post(String url, Map<String, Object> params, int timeoutSecond, Class<T> clazz) throws Exception {
        return post(url, null, params, timeoutSecond, clazz);
    }

    public static <T> T post(String url, Map<String, String> header, Map<String, Object> params, Class<T> clazz) throws Exception {
        return post(url, header, params, 0, clazz);
    }

    public static <T> T post(String url, Map<String, String> header, Map<String, Object> params, int timeoutSecond, Class<T> clazz)
            throws Exception {
        return httpRequest(url, "post", header, params, timeoutSecond, clazz);
    }

    /********************************************************
     * get
     ********************************************************/
    public static String get(String url) throws Exception {
        return get(url, null, null, 0);
    }

    public static String get(String url, Map<String, Object> params) throws Exception {
        return get(url, null, params, 0);
    }

    public static String get(String url, Map<String, Object> params, int timeoutSecond) throws Exception {
        return get(url, null, params, timeoutSecond);
    }

    public static String get(String url, Map<String, String> header, Map<String, Object> params) throws Exception {
        return get(url, header, params, 0);
    }

    public static String get(String url, Map<String, String> header, Map<String, Object> params, int timeoutSecond) throws Exception {
        return get(url, header, params, timeoutSecond, String.class);
    }

    public static <T> T get(String url, Class<T> clazz) throws Exception {
        return get(url, null, null, 0, clazz);
    }

    public static <T> T get(String url, int timeoutSecond, Class<T> clazz) throws Exception {
        return get(url, null, null, timeoutSecond, clazz);
    }

    public static <T> T get(String url, Map<String, Object> params, Class<T> clazz) throws Exception {
        return get(url, null, params, 0, clazz);
    }

    public static <T> T get(String url, Map<String, Object> params, int timeoutSecond, Class<T> clazz) throws Exception {
        return get(url, null, params, timeoutSecond, clazz);
    }

    public static <T> T get(String url, Map<String, String> header, Map<String, Object> params, Class<T> clazz) throws Exception {
        return get(url, header, params, 0, clazz);
    }

    public static <T> T get(String url, Map<String, String> header, Map<String, Object> params, int timeoutSecond, Class<T> clazz)
            throws Exception {
        return httpRequest(url, "get", header, params, timeoutSecond, clazz);
    }

    private static <T> T httpRequest(String url, String method, Map<String, String> header, Map<String, Object> params, int timeoutSecond,
            Class<T> clazz) throws Exception {
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            // 创建 HttpClient
            closeableHttpClient = createHttpClient(url, true);

            HttpRequestBase httpRequest = createHttpRequest(url, method, params);
            if (httpRequest == null) {
                return null;
            }
            // 设置请求头
            setHeader(httpRequest, header);
            // 设置其它配置，如超时
            setConfig(httpRequest, timeoutSecond);

            //执行请求
            httpResponse = closeableHttpClient.execute(httpRequest);
            logger.debug("execute {} request。url:{}; params:{}; header:{}", method, url, params, header);

            return httpRequestResult(httpResponse, clazz);
        } finally {
            if (!clazz.equals(InputStream.class)) {
                closeResource(closeableHttpClient, httpResponse);
            }
        }
    }

    protected static CloseableHttpClient createHttpClient(String url, boolean addProxy) throws Exception {
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        String httpProxy = System.getenv(PROXY_ENV_NAME);
        // 设置http代理
        if (addProxy && StringUtils.isNotEmpty(httpProxy)) {
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
            return httpClientBuilder.build();
        }
        // 后续处理支持https

        // 信任所有
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        httpClientBuilder.setSSLSocketFactory(sslsf);
        return httpClientBuilder.build();
    }

    /**
     * 创建HttpRequest
     * 
     * @param url 请求地址
     * @param method 请求方法
     * @param params 参数 K-V
     * @return HttpRequest 请求对象
     * @throws Exception
     */
    private static HttpRequestBase createHttpRequest(String url, String method, Map<String, Object> params) throws Exception {
        if (HttpPost.METHOD_NAME.equalsIgnoreCase(method)) {
            HttpPost httpRequest = new HttpPost(url);
            // 设置请求参数
            setPostParam(httpRequest, params);
            return httpRequest;

        } else if (HttpGet.METHOD_NAME.equalsIgnoreCase(method)) {
            HttpGet httpRequest = new HttpGet(url);
            // 设置请求参数
            setGetParam(httpRequest, params);
            return httpRequest;
        } else {
            return null;
        }
    }

    /**
     * http 请求返回结果
     * 
     * @param httpResponse
     * @param clazz
     * @return T
     * @throws Exception
     */
    private static <T> T httpRequestResult(HttpResponse httpResponse, Class<T> clazz) throws Exception {

        final StatusLine statusLine = httpResponse.getStatusLine();
        final HttpEntity httpEntity = httpResponse.getEntity();
        if (statusLine.getStatusCode() >= 300) {
            EntityUtils.consume(httpEntity);
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }

        if (httpEntity == null) {
            return null;
        }

        if (clazz.equals(InputStream.class)) {
            return (T) httpEntity.getContent();
        }
        String str = EntityUtils.toString(httpEntity);
        if (StringUtils.isBlank(str)) {
            return null;
        }

        if (clazz.equals(String.class)) {
            return (T) str;
        }

        return JSON.parseObject(str, clazz);
    }

    /**
     * get 请求方式设置参数
     * 
     * @param httpRequest get请求对象
     * @param params 参数 K-V
     * @throws Exception
     */
    private static void setGetParam(HttpGet httpRequest, Map<String, Object> params) throws Exception {
        String url = httpRequest.getURI().toString();
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
        URI uri = new URI(sb.toString());
        httpRequest.setURI(uri);
    }

    /**
     * post 请求方式设置参数
     * 
     * @param httpRequest post请求对象
     * @param params 参数 K-V
     * @throws Exception
     */
    private static void setPostParam(HttpPost httpRequest, Map<String, Object> params) throws Exception {

        // 构建请求参数
        if (params != null && !params.isEmpty()) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (Map.Entry<String, Object> e : params.entrySet()) {
                NameValuePair nameValuePair = new BasicNameValuePair(e.getKey(), e.getValue().toString());
                paramList.add(nameValuePair);
            }
            httpRequest.setEntity(new UrlEncodedFormEntity(paramList));
        }

    }

    /**
     * 设置请求头
     * 
     * @param httpRequest 请求对象
     * @param header header key-value
     */
    private static void setHeader(HttpRequestBase httpRequest, Map<String, String> header) {
        if (MapUtils.isNotEmpty(header)) {
            for (Map.Entry<String, String> map : header.entrySet()) {
                httpRequest.setHeader(map.getKey(), map.getValue());
            }
        }
    }

    /**
     * 配置设置
     * 
     * @param httpRequest 请求对象
     * @param timeoutSecond 超时时间（S）
     */
    private static void setConfig(HttpRequestBase httpRequest, int timeoutSecond) {
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
        //设置超时
        setTimeout(requestConfigBuilder, timeoutSecond);
        httpRequest.setConfig(requestConfigBuilder.build());
    }

    private static void setTimeout(RequestConfig.Builder requestConfigBuilder, int timeoutSecond) {
        if (timeoutSecond > 0) {
            requestConfigBuilder.setConnectTimeout(timeoutSecond * 1000).setSocketTimeout(timeoutSecond * 1000);
        }
    }

    private static void closeResource(Closeable... closeables) throws IOException {
        if (closeables == null || closeables.length == 0) {
            return;
        }
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                closeable.close();
            }
        }
    }

}
