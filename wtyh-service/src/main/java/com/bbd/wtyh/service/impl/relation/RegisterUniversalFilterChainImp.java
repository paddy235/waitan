package com.bbd.wtyh.service.impl.relation;


import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.common.relation.APIConstants;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.util.relation.ListUtils;
import com.bbd.wtyh.util.relation.StringUtils;
import com.bbd.wtyh.web.relationPara.param.RelatedParameters;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David
 *         DataAddressCombination   地址栏拼接
 *         sendRequest				发送http请求
 *         dataSplit				数据拆分并组合数据
 *         dataDeWeight				数据去重
 *         dataHierarchy    		数据分层次
 */
@Service("registerUniversalFilterChainImp")
public class RegisterUniversalFilterChainImp {

    @Autowired
    private RedisDAO redisDAO;

    private final static int retry = 3;

    @Value("${relation.real.url}")
    private String url;

    /**
     * @param companyName
     * @return
     * @throws Exception
     * @author David
     * 返回曹宇下载 静态图谱    linkList
     */
    public String getAPIDynamicRelatedPartUploadJTTP(String companyName, int degreesLevel, String dataVersion) throws Exception {
        //目标公司原始数据
        String data = null;
        if (StringUtils.isNotNullOrEmpty(companyName)) {
            data = targetCorpData(companyName, degreesLevel, dataVersion);
        }
        //存储到redis   目标公司原始数据data
        if (StringUtils.isNotNullOrEmpty(data)) {
            redisDAO.delete(companyName + APIConstants.redis_relation_LinksDataJTTP + dataVersion + degreesLevel);
            redisDAO.addString(companyName + APIConstants.redis_relation_LinksDataJTTP + dataVersion + degreesLevel, data, Constants.cacheDay);
        }
        return data;
    }

    /**
     * @param companyName 目标公司
     * @author David
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
     * @param url               地址
     * @param relatedParameters 地址栏参数
     * @return
     * @author David
     */
    public String dataAddressCombination(String url, RelatedParameters relatedParameters) {
        String query = null;
        StringBuilder sb = new StringBuilder();
        try {

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

    /**
     * 动态关联方图谱 SEARCH Post接口方法
     *
     * @param url URL
     * @return
     */
    public String APIDynamicRelatedParty(String url, String charSet) throws Exception {
        return APIDynamicRelatedParty(url, charSet, 0);
    }


    /**
     * 动态关联方图谱 SEARCH Post接口方法
     *
     * @param url     URL
     * @param charset 字符编码
     * @return
     */
    @SuppressWarnings("unused")
    public String APIDynamicRelatedParty(String url, final String charset, int num) throws Exception {
        InputStream in = null;
        if (num >= retry) {
            throw new Exception("请求链接无效" + url);
        }
        HttpTemplate httpTemplate = new HttpTemplate();

        return httpTemplate.get(url, new HttpCallback<String>() {
            @Override
            public boolean valid() {
                return true;
            }

            @Override
            public String parse(String result) {
                JSONObject rep = JSONObject.fromObject(result);
                try {
                    return java.net.URLDecoder.decode(rep.get("data").toString(), charset);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return "";
                }
            }
        });
    }

    // TODO - 暂存方法，后续可能会替换掉
    /**
     * 查询关联图谱
     */
    @Deprecated
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<List<Object>> HierarchicalFuzzySearchDataJTTP(String companyName, String dataVersion, Integer degree) throws Exception
    {
        String json = redisDAO.getString(companyName + APIConstants.redis_relation_LinksDataJTTP + dataVersion + degree);
        if (StringUtils.isNullOrEmpty(json)) {
            json = this.getAPIDynamicRelatedPartUploadJTTP(companyName, degree, dataVersion);
        }
        if (StringUtils.isNullOrEmpty(json)) {
            json = "[]"; // 没有查询到数据的情况
        }
        JSONArray jsonArr = JSONArray.fromObject(json);
        List<List<Object>> list = JSONArray.toList(jsonArr, new String(), new JsonConfig());
        return list;

    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    public Map<String, List> queryRelation(String companyName, String dataVersion, Integer degree) throws Exception {
        String json = redisDAO.getString(companyName + APIConstants.redis_relation_LinksDataJTTP + "-" + dataVersion + "-" + degree);
        if (StringUtils.isNullOrEmpty(json)) {
            json = this.getAPIDynamicRelatedPartUploadJTTP(companyName, degree, dataVersion);
        }
        if (StringUtils.isNullOrEmpty(json) || "null".equals(json) || "NULL".equals(json)) {
            json = "[]"; // 没有查询到数据的情况
        }
        JSONArray jsonArr = JSONArray.fromObject(json);
        List<List<String>> list = JSONArray.toList(jsonArr, new String(), new JsonConfig());
        Map<String, List> map = this.getRelationData(list);
        return map;
    }

    @SuppressWarnings("rawtypes")
    private Map<String, List> getRelationData(List<List<String>> list) {
        Map<String, List> map = new HashMap<String, List>();
        if (ListUtils.isNotEmpty(list)) {
            map.put("pointList", this.getPointList(list));
            map.put("lineList", this.getLineList(list));
        }
        return map;
    }

    /**
     * 获取线集合数据
     *
     * @param list
     * @return
     */
    private List<RelationDiagramVO.LineVO> getLineList(List<List<String>> list) {
        List<RelationDiagramVO.LineVO> lineList = new ArrayList<RelationDiagramVO.LineVO>();
        for (List<String> l : list) {
            if (ListUtils.isNotEmpty(l) && l.size() == 7) {
                RelationDiagramVO.LineVO line = new RelationDiagramVO.LineVO();
                line.setOrig(l.get(0));
                line.setTarget(l.get(1));
                line.setType(l.get(2));
                line.setIsFullLine(l.get(5));
                line.setRelationship(l.get(6));
                line.setOrigLevel(l.get(3));
                line.setTarLevel(l.get(4));

                lineList.add(line);
            }
        }
        return lineList;
    }

    /**
     * 获取点集合数据
     *
     * @param list
     * @return
     */
    private List<RelationDiagramVO.PointVO> getPointList(List<List<String>> list) {
        List<RelationDiagramVO.PointVO> pointList = new ArrayList<RelationDiagramVO.PointVO>();
        List<String> points = new ArrayList<String>();
        Map<String, String> sonComMap = new HashMap<String, String>();
        for (List<String> l : list) {
            /* 统计点 */
            String value1 = l.get(0) + "," + l.get(3) + "," + l.get(6) + "_0";
            if (!points.contains(value1)) {
                points.add(value1);
            }
            String value2 = l.get(1) + "," + l.get(4) + ",0_0";
            if ("1".equals(l.get(4)) && "0".equals(l.get(3))) { // 投资方关联度数为0，被投资方关联度数为1，即视为投资方子公司
                sonComMap.put(l.get(1), l.get(1)); // 统计子公司
            }
            if (!points.contains(value2)) {
                points.add(value2);
            }
        }
        if (ListUtils.isNotEmpty(points)) {
            for (String s : points) {
                s = s.replaceAll("_", ",");
                String[] arr = s.split(",");

                RelationDiagramVO.PointVO point = new RelationDiagramVO.PointVO();
                point.setIsPerson(arr[2]);
                if (sonComMap.containsKey(arr[0]) && "1".equals(arr[1])) {
                    point.setIsSonCom("1"); // 子公司
                } else {
                    point.setIsSonCom(arr[3]);
                }
                point.setLevel(arr[1]);
                point.setName(arr[0]);

                pointList.add(point);
            }
        }
        return pointList;
    }



}
