package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.RelationCompanyService;
import com.bbd.wtyh.service.impl.relation.common.APIConstants;
import com.bbd.wtyh.service.impl.relation.exception.BbdException;
import com.bbd.wtyh.service.impl.relation.param.RelatedParameters;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 关联方数据接口实现层
 * @author
 * @since  2016.08.10
 */
@Service("relationCompanyService")
public class RelationCompanyServiceImpl implements RelationCompanyService {

    private Logger logger = LoggerFactory.getLogger(RelationCompanyServiceImpl.class);

    @Resource
    private RedisDAO redisDAO;

    @Value("${related.party.url}")
    private String url;

    public HttpGet httpGet;

    public HttpClient client;

    private final static int retry = 3;
    /**
     *
     * @param companyName
     * @param degreesLevel
     * @param dataVersion
     * @return
     * @throws Exception
     */
    public String getAPIDynamicRelatedPartUploadJTTP(String companyName,int degreesLevel,String dataVersion) throws Exception{
        //目标公司原始数据
        String data = null;
        if (!StringUtils.isEmpty(companyName)) {
            data = targetCorpData(companyName,degreesLevel,dataVersion);
        }
        //存储到redis   目标公司原始数据data
        if(!StringUtils.isEmpty(data)){
            redisDAO.delete(companyName+APIConstants.redis_relation_LinksDataJTTP + dataVersion);
            redisDAO.addString(companyName+APIConstants.redis_relation_LinksDataJTTP + dataVersion, data, Constants.cacheDay);
        }
        return data;
    }

    /**
     *
     * @param companyName
     * @param degreesLevel
     * @param dataVersion
     * @return
     * @throws Exception
     */
    public String targetCorpData(String companyName,int degreesLevel,String dataVersion) throws Exception{
        //目标公司数据
        RelatedParameters relatedParameters = new RelatedParameters();
        relatedParameters.setCompany(companyName);//用户名
        relatedParameters.setDate(dataVersion);//版本号
        relatedParameters.setDegree(String.valueOf(degreesLevel));
        String Assemble_url = dataAddressCombination(url,relatedParameters);
        String data = APIDynamicRelatedParty(Assemble_url,APIConstants.show_charset);
        return data;
    }

    /**
     *
     * @param url
     * @param charSet
     * @return
     * @throws Exception
     */
    public String APIDynamicRelatedParty(String url,String charSet) throws Exception {
        return APIDynamicRelatedParty(url,charSet,0);
    }

    /**
     *
     * @param url
     * @param charset
     * @param num
     * @return
     * @throws Exception
     */
    public String APIDynamicRelatedParty(String url, String charset ,int num) throws Exception {
        InputStream in = null;
        if(num >= retry)
        {
            throw new BbdException("请求链接无效" + url);
        }
        String r = "";
        HttpEntity entity = null;
        BufferedReader reader = null;
        HttpResponse rs = null;
        try {
            httpGet = new HttpGet(url);
            httpGet.setHeader("Accept", "text/html, application/xhtml+xml, */*");
            httpGet.setHeader("Accept-Language", "zh-CN");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)");
            httpGet.setHeader("DNT", "1");
            httpGet.setHeader("Connection", "Keep-Alive");
            httpGet.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
            httpGet.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 7*60*1000);
            httpGet.getParams().setParameter("http.protocol.allow-circular-redirects", true);
            client = new DefaultHttpClient();
            rs = client.execute(httpGet);
            if (rs.getStatusLine().getStatusCode() == 200) {
                entity = rs.getEntity();
                in = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        in, "UTF-8"));
                StringBuffer resBuffer = new StringBuffer("\r\n");
                String resTemp = null;
                while ((resTemp = br.readLine()) != null) {
                    resBuffer.append(resTemp);
                }
                JSONObject rep = JSONObject.fromObject(resBuffer.toString());
                r = java.net.URLDecoder.decode(rep.get("data").toString(), charset);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //Thread.sleep(60*1000*num);
            System.out.println("已使用次数"+num);
            APIDynamicRelatedParty(url,"UTF-8",num+1);
            r = "";
        }  finally {

            if (in != null){
                try{
                    in.close ();
                }catch (IOException e){
                    e.printStackTrace ();
                }
            }
        }
        return r;
    }

    /**
     *
     * @param 	url  地址
     * @param   relatedParameters   地址栏参数
     * @return
     */
    public String dataAddressCombination(String url,RelatedParameters relatedParameters) {
        String query = null;
        StringBuilder sb = new StringBuilder();
        try{
            // TODO Auto-generated method stub

            java.lang.reflect.Field[] field = relatedParameters.getClass().getDeclaredFields();
            for (int j = 0; j < field.length; j++) {
                String name = field[j].getName();    //获取属性的名字
                String capitalName = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
                String type = field[j].getGenericType().toString();    //获取属性的类型
                if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
                    Method month = relatedParameters.getClass().getMethod("get"+capitalName);
                    String value = (String) month.invoke(relatedParameters);    //调用getter方法获取属性值
                    if(value != null){
                        sb.append(name);
                        sb.append("=");
                        sb.append(value.replaceAll(" ", "%20"));
                        sb.append("&");
                    }
                }
            }

            query = url + "?" + sb.substring(0, sb.length() - 1);
            System.out.println(query);
        }catch(Exception e){
            e.printStackTrace();
        }

        return query;
    }

}
