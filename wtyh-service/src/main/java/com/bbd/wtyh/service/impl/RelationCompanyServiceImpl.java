package com.bbd.wtyh.service.impl;


import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.RelationCompanyService;
import com.bbd.wtyh.service.impl.relation.common.APIConstants;
import com.bbd.wtyh.service.impl.relation.param.RelatedParameters;
import com.bbd.wtyh.util.relation.BbdException;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 关联方数据接口实现层
 *
 * @author
 * @since 2016.08.10
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
     * @param companyName
     * @param degreesLevel
     * @param dataVersion
     * @return
     * @throws Exception
     */
    public String getAPIDynamicRelatedPartUploadJTTP(String companyName, int degreesLevel, String dataVersion) throws Exception {
        //目标公司原始数据
        String data = null;
        if (!StringUtils.isEmpty(companyName)) {
            data = targetCorpData(companyName, degreesLevel, dataVersion);
        }
        //存储到redis   目标公司原始数据data
        if (!StringUtils.isEmpty(data)) {
            redisDAO.delete(companyName + APIConstants.redis_relation_LinksDataJTTP + dataVersion);
            redisDAO.addString(companyName + APIConstants.redis_relation_LinksDataJTTP + dataVersion, data, Constants.cacheDay);
        }
        return data;
    }

    /**
     * @param companyName
     * @param degreesLevel
     * @param dataVersion
     * @return
     * @throws Exception
     */
    public String targetCorpData(String companyName, int degreesLevel, String dataVersion) throws Exception {
        //目标公司数据
        RelatedParameters relatedParameters = new RelatedParameters();
        relatedParameters.setCompany(companyName);//用户名
        relatedParameters.setDate(dataVersion);//版本号
        relatedParameters.setDegree(String.valueOf(degreesLevel));
        String Assemble_url = dataAddressCombination(url, relatedParameters);
        String data = APIDynamicRelatedParty(Assemble_url, APIConstants.show_charset);
        return data;
    }

    /**
     * @param url
     * @param charSet
     * @return
     * @throws Exception
     */
    public String APIDynamicRelatedParty(String url, String charSet) throws Exception {
        return APIDynamicRelatedParty(url, charSet, 0);
    }

    /**
     * @param url
     * @param charset
     * @param num
     * @return
     * @throws Exception
     */
    public String APIDynamicRelatedParty(String url, String charset, int num) throws Exception {

        String result = null;
        int retry = 3;
        for (int i = 0; i < retry; i++) {
            result = new HttpTemplate().get(url);
            if (StringUtils.isNotEmpty(result)) {
                break;
            }
        }
        if (StringUtils.isEmpty(result)) {
            throw new BbdException("can not get result from api:" + url);
        }
        JSONObject rep = JSONObject.fromObject(result);
        return java.net.URLDecoder.decode(rep.get("data").toString(), charset);
    }

    /**
     * @param url               地址
     * @param relatedParameters 地址栏参数
     * @return
     */
    public String dataAddressCombination(String url, RelatedParameters relatedParameters) {
        String query = null;
        StringBuilder sb = new StringBuilder();
        try {
            // TODO Auto-generated method stub

            java.lang.reflect.Field[] field = relatedParameters.getClass().getDeclaredFields();
            for (int j = 0; j < field.length; j++) {
                String name = field[j].getName();    //获取属性的名字
                String capitalName = name.substring(0, 1).toUpperCase() + name.substring(1); //将属性的首字符大写，方便构造get，set方法
                String type = field[j].getGenericType().toString();    //获取属性的类型
                if (type.equals("class java.lang.String")) {   //如果type是类类型，则前面包含"class "，后面跟类名
                    Method month = relatedParameters.getClass().getMethod("get" + capitalName);
                    String value = (String) month.invoke(relatedParameters);    //调用getter方法获取属性值
                    if (value != null) {
                        sb.append(name);
                        sb.append("=");
                        sb.append(value.replaceAll(" ", "%20"));
                        sb.append("&");
                    }
                }
            }

            query = url + "?" + sb.substring(0, sb.length() - 1);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return query;
    }

}
