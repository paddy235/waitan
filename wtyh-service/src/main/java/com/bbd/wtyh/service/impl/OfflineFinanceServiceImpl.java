package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bbd.common.APIConstants;
import com.bbd.common.Constants;
import com.bbd.exception.BbdException;
import com.bbd.higgs.utils.ListUtil;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.param.RelatedParameters;
import com.bbd.wtyh.domain.dto.KunLunApiResultDTO;
import com.bbd.wtyh.domain.dto.RelationDataDTO;
import com.bbd.wtyh.domain.vo.LineVO;
import com.bbd.wtyh.domain.vo.PointVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import com.bbd.wtyh.mapper.StaticRiskMapper;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.util.DateUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 线下理财接口实现层
 * @author zhouxuan
 * @since  2016.08.05
 */
@Service("offlineFinanceService")
public class OfflineFinanceServiceImpl implements OfflineFinanceService {
    private Logger logger = LoggerFactory.getLogger(OfflineFinanceServiceImpl.class);
    @Resource
    private HttpTemplate httpTemplate;

    @Resource
    private StaticRiskMapper staticRiskMapper;

    @Value("${related.party.url}")
    private String url;

    public HttpGet httpGet;

    public HttpClient client;

    private final static int retry = 3;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Map<String, List> queryRelation(String companyName, String dataVersion) throws Exception  {
        List<List<String>> list = null;
        JSONArray jsonArr = null;
        String json = "";
//                String json = redisDao.getString(companyName + APIConstants.redis_relation_LinksDataJTTP + dataVersion);
        if (StringUtils.isEmpty(json)) {
            json = this.getAPIDynamicRelatedPartUploadJTTP(companyName, APIConstants.show_relation_E, dataVersion);
        }
        if (StringUtils.isEmpty(json)) {
            json="[]"; // 没有查询到数据的情况
        }
        jsonArr = JSONArray.fromObject(json);
        list = JSONArray.toList(jsonArr, new String(), new JsonConfig());
        Map<String, List> map = this.getRelationData(list);
        return map;
    }

    @Override
    public List<Map> companyNews(String companyName) {
        return null;
    }

    @Override
    public List<Map> staticRiskIndex(String companyName) {
        return null;
    }

    @Override
    public List<Map> staticRiskList(String companyName) {
        return null;
    }

    @Override
    public List<StatisticsVO> queryStatistics(String companyName, String tabIndex, String areaCode) throws ParseException {
        List<StatisticsVO> avgList = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("companyName", companyName);
        params.put("areaCode", areaCode);
        avgList = this.getAvgRiskIndex(params, tabIndex);
        this.getRiskIndex(avgList, params, tabIndex);
        List<StatisticsVO> result = new ArrayList<StatisticsVO>();
        if (ListUtil.isEmpty(avgList)) {
			/* 查询无结果，返回坐标系为零数据 */
            for (int i = 0; i < 6; i++) {
                StatisticsVO vo = new StatisticsVO();
                vo.setAvgRiskIndex(BigDecimal.ZERO);
                vo.setRiskIndex(BigDecimal.ZERO);
                vo.setDate(DateUtils.getLastMonth(new Date(), i - 5));
                vo.setRiskName(this.getTableText(tabIndex));
                result.add(vo);
            }
        } else {
            DateFormat df = new SimpleDateFormat("yyyy-MM");
            StatisticsVO lastVO = avgList.get(avgList.size() - 1);
            StatisticsVO firstVO = avgList.get(0);
            int subMonth = this.getSubMonth(lastVO, firstVO); // 月份差
            if (subMonth == 0) { // 这里表示只有一个月有数据
				/* 以有数据月份为准，向前推5个月的为零数据 */
                for (int i = 0; i < 5; i++) {
                    StatisticsVO vo = new StatisticsVO();
                    vo.setAvgRiskIndex(BigDecimal.ZERO);
                    vo.setRiskIndex(BigDecimal.ZERO);
                    vo.setDate(DateUtils.getLastMonth(df.parse(firstVO.getDate()), i - 5));
                    vo.setRiskName(this.getTableText(tabIndex));
                    result.add(vo);
                }
                result.add(firstVO);
            } else {
                result.add(firstVO);
				/* 填充最大、最小时间之间的数据 */
                for (int i = 1; i < subMonth; i++) {
                    String date = DateUtils.getLastMonth(df.parse(firstVO.getDate()), i);
                    StatisticsVO existVO = this.getExistVO(avgList, date);
                    if (null != existVO) { // 存在数据
                        result.add(existVO);
                        continue;
                    }
					/* 未存在数据则填充零数据 */
                    StatisticsVO vo = new StatisticsVO();
                    vo.setAvgRiskIndex(BigDecimal.ZERO);
                    vo.setRiskIndex(BigDecimal.ZERO);
                    vo.setDate(date);
                    vo.setRiskName(this.getTableText(tabIndex));
                    result.add(vo);
                }
                result.add(lastVO);
                int resultSize = result.size();
                List<StatisticsVO> supplementList = new ArrayList<StatisticsVO>();
				/* 最终结果依然小于半年数据，则在最早时间前填充零数据 */
                if (resultSize < 6) {
                    for (int i = 0; i < 6 - resultSize; i++) {
                        StatisticsVO vo = new StatisticsVO();
                        vo.setAvgRiskIndex(BigDecimal.ZERO);
                        vo.setRiskIndex(BigDecimal.ZERO);
                        vo.setDate(DateUtils.getLastMonth(df.parse(firstVO.getDate()), (i - 6 + resultSize)));
                        vo.setRiskName(this.getTableText(tabIndex));
                        supplementList.add(vo);
                    }
                }
                List<StatisticsVO> allList = new ArrayList<StatisticsVO>();
                allList.addAll(supplementList);
                allList.addAll(result);
                return allList;
            }
        }
        return result;
    }

    /**
     * 获取行业平均风险
     * @param params
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<StatisticsVO> getAvgRiskIndex(Map<String, Object> params, String type) {
        List<StatisticsVO> avgList = null;
        if (!StringUtils.isEmpty(type)) {
            switch (type) {
                case "0":
//                    avgList = (List<StatisticsVO>) redisDAO.getObject(REDIS_KEY_STATIC_RISK_INDEX);
                    if (ListUtil.isEmpty(avgList)) {
                        avgList = staticRiskMapper.queryIndStatistics(params);
                        if (ListUtil.isNotEmpty(avgList)) {
//                            redisDAO.addObject(REDIS_KEY_STATIC_RISK_INDEX, avgList, Constants.cacheDays, List.class);
                        }
                    }
                    break;
                case "1":
//                    avgList = (List<StatisticsVO>) redisDAO.getObject(REDIS_KEY_SJKZR_RISK);
                    if (ListUtil.isEmpty(avgList)) {
                        avgList = staticRiskMapper.queryIndStsSJKZR(params);
                        if (ListUtil.isNotEmpty(avgList)) {
//                            redisDAO.addObject(REDIS_KEY_SJKZR_RISK, avgList, Constants.cacheDays, List.class);
                        }
                    }
                    break;
                case "2":
//                    avgList = (List<StatisticsVO>) redisDAO.getObject(REDIS_KEY_GSKZLJ_RISK);
                    if (ListUtil.isEmpty(avgList)) {
                        avgList = staticRiskMapper.queryIndStsGSKZLJ(params);
                        if (ListUtil.isNotEmpty(avgList)) {
//                            redisDAO.addObject(REDIS_KEY_GSKZLJ_RISK, avgList, Constants.cacheDays, List.class);
                        }
                    }
                    break;
                case "3":
//                    avgList = (List<StatisticsVO>) redisDAO.getObject(REDIS_KEY_ZXJJH_RISK);
                    if (ListUtil.isEmpty(avgList)) {
                        avgList = staticRiskMapper.queryIndStsZXJJH(params);
                        if (ListUtil.isNotEmpty(avgList)) {
//                            redisDAO.addObject(REDIS_KEY_ZXJJH_RISK, avgList, Constants.cacheDays, List.class);
                        }
                    }
                    break;
                case "4":
//                    avgList = (List<StatisticsVO>) redisDAO.getObject(REDIS_KEY_FFRZYS_RISK);
                    if (ListUtil.isEmpty(avgList)) {
                        avgList = staticRiskMapper.queryIndStsFFRZYS(params);
                        if (ListUtil.isNotEmpty(avgList)) {
//                            redisDAO.addObject(REDIS_KEY_FFRZYS_RISK, avgList, Constants.cacheDays, List.class);
                        }
                    }
                    break;
                case "5":
//                    avgList = (List<StatisticsVO>) redisDAO.getObject(REDIS_KEY_DQZL_RISK);
                    if (ListUtil.isEmpty(avgList)) {
                        avgList = staticRiskMapper.queryIndStsDQZL(params);
                        if (ListUtil.isNotEmpty(avgList)) {
//                            redisDAO.addObject(REDIS_KEY_DQZL_RISK, avgList, Constants.cacheDays, List.class);
                        }
                    }
                    break;
                case "6":
//                    avgList = (List<StatisticsVO>) redisDAO.getObject(REDIS_KEY_FFRZWG_RISK);
                    if (ListUtil.isEmpty(avgList)) {
                        avgList = staticRiskMapper.queryIndStsFFRZWG(params);
                        if (ListUtil.isNotEmpty(avgList)) {
//                            redisDAO.addObject(REDIS_KEY_FFRZWG_RISK, avgList, Constants.cacheDays, List.class);
                        }
                    }
                    break;
                case "7":
//                    avgList = (List<StatisticsVO>) redisDAO.getObject(REDIS_KEY_RCJG_RISK);
                    if (ListUtil.isEmpty(avgList)) {
                        avgList = staticRiskMapper.queryIndStsRCJG(params);
                        if (ListUtil.isNotEmpty(avgList)) {
//                            redisDAO.addObject(REDIS_KEY_RCJG_RISK, avgList, Constants.cacheDays, List.class);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return avgList;
    }

    private void getRiskIndex(List<StatisticsVO> avgList, Map<String, Object> params, String type) {
        if (ListUtil.isNotEmpty(avgList)) {
            for (StatisticsVO vo : avgList) {
                if (null != params && !StringUtils.isEmpty(type)) {
                    params.put("date", vo.getDate());
                    StatisticsVO comVO = null;
                    switch (type) {
                        case "0":
                            comVO = staticRiskMapper.queryComStatistics(params);
                            break;
                        case "1":
                            comVO = staticRiskMapper.queryComStsSJKZR(params);
                            break;
                        case "2":
                            comVO = staticRiskMapper.queryComStsGSKZLJ(params);
                            break;
                        case "3":
                            comVO = staticRiskMapper.queryComStsZXJJH(params);
                            break;
                        case "4":
                            comVO = staticRiskMapper.queryComStsFFRZYS(params);
                            break;
                        case "5":
                            comVO = staticRiskMapper.queryComStsDQZL(params);
                            break;
                        case "6":
                            comVO = staticRiskMapper.queryComStsFFRZWG(params);
                            break;
                        case "7":
                            comVO = staticRiskMapper.queryComStsRCJG(params);
                            break;
                        default:
                            break;
                    }
                    if (null != comVO) {
                        vo.setRiskIndex(comVO.getRiskIndex());
                    } else {
                        vo.setRiskIndex(BigDecimal.ZERO);
                    }
                }
            }
        }
    }

    @Override
    public List<Map> dynamicComparisonChart(String companyName, String dateA, String dateB) {
        return null;
    }

    @Override
    public List<Map> companyRelatedComparisonChart(String companyName, String dateA, String dateB) {
        return null;
    }

    @Override
    public List<Map> riskFactor() {
        return null;
    }

    @SuppressWarnings("rawtypes")
    private Map<String, List> getRelationData(List<List<String>> list) {
        Map<String, List> map = new HashMap<String, List>();
        if (CollectionUtils.isEmpty(list)) {
            map.put("pointList", this.getPointList(list));
            map.put("lineList", this.getLineList(list));
        }
        return map;
    }

    /**
     * 获取线集合数据
     * @param list
     * @return
     */
    private List<LineVO> getLineList(List<List<String>> list) {
        List<LineVO> lineList = new ArrayList<LineVO>();
        for (List<String> l : list) {
            if (ListUtil.isNotEmpty(l) && l.size() == 7) {
                LineVO line = new LineVO();
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
     * @param list
     * @return
     */
    private List<PointVO> getPointList(List<List<String>> list) {
        List<PointVO> pointList = new ArrayList<PointVO>();
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
        if (ListUtil.isNotEmpty(points)) {
            for (String s : points) {
                s = s.replaceAll("_", ",");
                String[] arr = s.split(",");

                PointVO point = new PointVO();
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
            // TODO 代码模拟的数据
            if ("冠群驰骋投资管理（北京）有限公司".equals(companyName) || "金易融（北京）网络科技有限公司".equals(companyName)) {
                data = DATA_MAP.get(companyName + "_" + dataVersion);
                if (StringUtils.isEmpty(data)) {
                    data = targetCorpData(companyName, degreesLevel, dataVersion);
                }
            } else {
                data = targetCorpData(companyName,degreesLevel,dataVersion);
            }
        }
        //存储到redis   目标公司原始数据data
        if(!StringUtils.isEmpty(data)){
//            redisDao.delete(companyName+APIConstants.redis_relation_LinksDataJTTP + dataVersion);
//            redisDao.addString(companyName+APIConstants.redis_relation_LinksDataJTTP + dataVersion, data,Constants.cacheDays);
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

    private String getTableText(String tabIndex) {
        String text = null;
        switch (tabIndex) {
            case "0":
                text = "静态风险指数";
                break;
            case "1":
                text = "实际控制人风险";
                break;
            case "2":
                text = "公司扩张路径风险";
                break;
            case "3":
                text = "中心积聚化风险";
                break;
            case "4":
                text = "非法融资衍生风险";
                break;
            case "5":
                text = "短期逐利风险";
                break;
            case "6":
                text = "非法融资违规风险";
                break;
            case "7":
                text = "人才结构风险";
                break;
            default:
                break;
        }
        return text;
    }

    private int getSubMonth(StatisticsVO lastVO, StatisticsVO firstVO) {
        int sub = 0;
        if (null != lastVO && null != firstVO) {
            int lastYear = Integer.parseInt(lastVO.getDate().substring(0, 4));
            int lastMonth = Integer.parseInt(lastVO.getDate().substring(5));
            int firstYear = Integer.parseInt(firstVO.getDate().substring(0, 4));
            int firstMonth = Integer.parseInt(firstVO.getDate().substring(5));
            sub = (lastYear - firstYear) * 12 + lastMonth - firstMonth;
        }
        return sub;
    }

    private StatisticsVO getExistVO(List<StatisticsVO> list, String dateStr) {
        for (StatisticsVO vo : list) {
            if (dateStr.equals(vo.getDate())) {
                return vo;
            }
        }
        return null;
    }

    private static final Map<String, String> DATA_MAP = new HashMap<String, String>();

    static {
        DATA_MAP.put("冠群驰骋投资管理（北京）有限公司_20150830", "[[\"刘丰\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘杰\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"曹晓荣\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东、监事\",\"1\",\"0\",\"1\",\"1\"],[\"王占云\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘翠彦\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘云\",\"冠群驰骋投资管理（北京）有限公司\",\"经理、执行董事、法定代表人\",\"1\",\"0\",\"0\",\"1\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋金融信息服务（上海）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋科技（上海）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋投资管理（深圳）有限公司\",\"法人股东\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群天下投资管理（北京）有限公司\",\"法人股东\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"沈阳冠群驰骋投资管理有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"刘云\",\"冠群天下投资管理（北京）有限公司\",\"监事\",\"1\",\"1\",\"0\",\"1\"],[\"赵继姣\",\"冠群驰骋金融信息服务（上海）有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"范晶晶\",\"冠群驰骋金融信息服务（上海）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"张涵\",\"冠群驰骋科技（上海）有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"范晶晶\",\"冠群驰骋科技（上海）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"徐越\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"经理、执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"杨健\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"王茜茜\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人\",\"2\",\"1\",\"1\",\"1\"],[\"杨健\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人\",\"2\",\"1\",\"1\",\"1\"],[\"徐越\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"2\",\"1\",\"1\",\"1\"],[\"赵玉茹\",\"冠群驰骋投资管理（深圳）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"赵继姣\",\"冠群天下投资管理（北京）有限公司\",\"经理、执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"刘英\",\"沈阳冠群驰骋投资管理有限公司\",\"自然人股东、监事\",\"2\",\"1\",\"1\",\"1\"],[\"王笑梅\",\"沈阳冠群驰骋投资管理有限公司\",\"自然人股东、执行董事、法定代表人\",\"2\",\"1\",\"1\",\"1\"],[\"刘云\",\"北京东方正杰贸易有限公司\",\"自然人股东、遗留状态、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"北京东方正杰贸易有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"王占云\",\"北京龙腾逸云经贸有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘翠彦\",\"北京龙腾逸云经贸有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"刘杰\",\"大同市思杰科技有限责任公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"大同市思杰科技有限责任公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"曹晓荣\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘丰\",\"湖南瑞廷文化传播有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"湖南瑞廷文化传播有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘丰\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"刘杰\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"刘云\",\"荆州业兴艺术构建有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"刘杰\",\"荆州业兴艺术构建有限公司\",\"执行董事、法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"刘云\",\"昆明笛光机械设备有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"昆明笛光机械设备有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘丰\",\"三河市冠群驰骋投资咨询有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"三河市冠群驰骋投资咨询有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"陕西金雨林房地产开发有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"陕西金雨林房地产开发有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"重庆伸展物资有限公司\",\"自然人、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"重庆伸展物资有限公司\",\"自然人、执行董事经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘红\",\"北京东方正杰贸易有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"高建利\",\"大同市思杰科技有限责任公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"康保富\",\"大同市思杰科技有限责任公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"闫铁峰\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"闫湖洋\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘秉全\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘晓平\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"夏冬芳\",\"湖南瑞廷文化传播有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"凯伦光伏材料投资有限公司\",\"济宁凯伦光伏材料有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"0\"],[\"林景濠\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"刘湘茂\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"贺学初\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"刘伟\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"施立新\",\"济宁凯伦光伏材料有限公司\",\"法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"刘泓君\",\"昆明笛光机械设备有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘飞\",\"昆明笛光机械设备有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"陕西金雨林房地产开发有限公司\",\"陕西柳鑫置业有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"]]");
        DATA_MAP.put("冠群驰骋投资管理（北京）有限公司_20150905", "[[\"北京冠群天勤信息咨询有限公司\",\"冠群驰骋投资管理（北京）有限公司\",\"企业法人\",\"1\",\"0\",\"1\",\"0\"],[\"曹晓荣\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东、监事\",\"1\",\"0\",\"1\",\"1\"],[\"刘翠彦\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘丰\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘广东\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘杰\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘云\",\"冠群驰骋投资管理（北京）有限公司\",\"经理、执行董事、法定代表人\",\"1\",\"0\",\"0\",\"1\"],[\"王占云\",\"冠群驰骋投资管理（北京）有限公司\",\"投资人\",\"1\",\"0\",\"1\",\"1\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋金融信息服务（上海）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋科技（上海）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋投资管理（深圳）有限公司\",\"法人股东\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群天下投资管理（北京）有限公司\",\"法人股东\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"沈阳冠群驰骋投资管理有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"刘广东\",\"北京冠群天勤信息咨询有限公司\",\"投资人\",\"1\",\"1\",\"1\",\"1\"],[\"刘云\",\"北京冠群天勤信息咨询有限公司\",\"投资人、经理、执行董事、法定代表人\",\"1\",\"1\",\"1\",\"1\"],[\"刘云\",\"冠群天下投资管理（北京）有限公司\",\"监事\",\"1\",\"1\",\"0\",\"1\"],[\"范晶晶\",\"冠群驰骋金融信息服务（上海）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"范晶晶\",\"冠群驰骋科技（上海）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"刘英\",\"沈阳冠群驰骋投资管理有限公司\",\"自然人股东、监事\",\"2\",\"1\",\"1\",\"1\"],[\"王茜茜\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人\",\"2\",\"1\",\"1\",\"1\"],[\"王笑梅\",\"沈阳冠群驰骋投资管理有限公司\",\"自然人股东、执行董事、法定代表人\",\"2\",\"1\",\"1\",\"1\"],[\"徐越\",\"北京冠群天勤信息咨询有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"徐越\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"执行董事、经理、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"徐越\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"2\",\"1\",\"1\",\"1\"],[\"杨健\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"杨健\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人\",\"2\",\"1\",\"1\",\"1\"],[\"张涵\",\"冠群驰骋科技（上海）有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"赵继姣\",\"冠群驰骋金融信息服务（上海）有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"赵继姣\",\"冠群天下投资管理（北京）有限公司\",\"经理、执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"赵玉茹\",\"冠群驰骋投资管理（深圳）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"曹晓荣\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘翠彦\",\"北京龙腾逸云经贸有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"刘丰\",\"湖南瑞廷文化传播有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘丰\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"刘丰\",\"三河市冠群驰骋投资咨询有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘广东\",\"北京冠群驰骋投资控股有限公司\",\"投资人、执行董事\",\"1\",\"2\",\"1\",\"1\"],[\"刘广东\",\"北京冠群恒华信息咨询有限公司\",\"投资人、执行董事\",\"1\",\"2\",\"1\",\"1\"],[\"刘广东\",\"北京冠群汇通信息咨询有限公司\",\"投资人、执行董事\",\"1\",\"2\",\"1\",\"1\"],[\"刘广东\",\"北京金百创经贸有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"北京东方正杰贸易有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"北京金百创经贸有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"大同市思杰科技有限责任公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"湖南瑞廷文化传播有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"济南天盛农产品专业合作社\",\"投资人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"刘杰\",\"荆州业兴艺术构建有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"昆明笛光机械设备有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"三河市冠群驰骋投资咨询有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"陕西金雨林房地产开发有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"重庆伸展物资有限公司\",\"自然人、执行董事经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"北京东方正杰贸易有限公司\",\"自然人股东、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"北京冠群驰骋投资控股有限公司\",\"投资人、经理\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"北京冠群恒华信息咨询有限公司\",\"投资人、经理\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"北京冠群汇通信息咨询有限公司\",\"投资人、经理\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"大同市思杰科技有限责任公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"济南天盛农产品专业合作社\",\"投资人\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"荆州业兴艺术构建有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"昆明笛光机械设备有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"陕西金雨林房地产开发有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"重庆伸展物资有限公司\",\"自然人、监事\",\"1\",\"2\",\"1\",\"1\"],[\"王占云\",\"北京龙腾逸云经贸有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"徐越\",\"北京冠群驰骋投资控股有限公司\",\"监事\",\"2\",\"2\",\"0\",\"1\"],[\"徐越\",\"北京冠群恒华信息咨询有限公司\",\"监事\",\"2\",\"2\",\"0\",\"1\"],[\"徐越\",\"北京冠群汇通信息咨询有限公司\",\"监事\",\"2\",\"2\",\"0\",\"1\"],[\"高建利\",\"大同市思杰科技有限责任公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"贺学初\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"凯伦光伏材料投资有限公司\",\"济宁凯伦光伏材料有限公司\",\"\",\"3\",\"2\",\"1\",\"0\"],[\"康保富\",\"大同市思杰科技有限责任公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"林景濠\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"刘秉全\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘飞\",\"昆明笛光机械设备有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"刘红\",\"北京东方正杰贸易有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘泓君\",\"昆明笛光机械设备有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘伟\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"刘湘茂\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"刘晓平\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"施立新\",\"济宁凯伦光伏材料有限公司\",\"法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"夏冬芳\",\"湖南瑞廷文化传播有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"闫湖洋\",\"北京金百创经贸有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"闫湖洋\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"闫铁峰\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"张瑞盈\",\"北京冠群驰骋投资控股有限公司\",\"投资人\",\"3\",\"2\",\"1\",\"1\"],[\"王茜茜\",\"卓冠九州商务咨询（北京）有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"徐越\",\"深圳市冠群方物创新资产管理有限公司\",\"自然人、总经理\",\"2\",\"3\",\"1\",\"1\"],[\"赵玉茹\",\"深圳冠群朴素资本管理有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"赵玉茹\",\"深圳市冠群方物创新资产管理有限公司\",\"自然人、执行（常务）董事、法定代表人\",\"2\",\"3\",\"1\",\"1\"]]");
        DATA_MAP.put("冠群驰骋投资管理（北京）有限公司_20151030", "[[\"刘丰\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘杰\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"曹晓荣\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东、监事\",\"1\",\"0\",\"1\",\"1\"],[\"王占云\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘云\",\"冠群驰骋投资管理（北京）有限公司\",\"经理、执行董事、法定代表人\",\"1\",\"0\",\"0\",\"1\"],[\"刘翠彦\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘广东\",\"冠群驰骋投资管理（北京）有限公司\",\"投资人\",\"1\",\"0\",\"1\",\"1\"],[\"北京冠群天勤信息咨询有限公司\",\"冠群驰骋投资管理（北京）有限公司\",\"投资人\",\"1\",\"0\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋金融信息服务（上海）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋科技（上海）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋投资管理（深圳）有限公司\",\"法人股东\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群天下投资管理（北京）有限公司\",\"法人股东\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"沈阳冠群驰骋投资管理有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"德立信资产管理有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"刘云\",\"北京东方正杰贸易有限公司\",\"自然人股东、遗留状态、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"北京东方正杰贸易有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘广东\",\"北京冠群驰骋投资控股有限公司\",\"投资人、执行董事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"北京冠群驰骋投资控股有限公司\",\"投资人、经理\",\"1\",\"2\",\"1\",\"1\"],[\"刘广东\",\"北京冠群恒华信息咨询有限公司\",\"投资人、执行董事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"北京冠群恒华信息咨询有限公司\",\"投资人、经理\",\"1\",\"2\",\"1\",\"1\"],[\"刘广东\",\"北京冠群汇通信息咨询有限公司\",\"投资人、执行董事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"北京冠群汇通信息咨询有限公司\",\"投资人、经理\",\"1\",\"2\",\"1\",\"1\"],[\"刘广东\",\"北京冠群天勤信息咨询有限公司\",\"投资人\",\"1\",\"1\",\"1\",\"1\"],[\"刘云\",\"北京冠群天勤信息咨询有限公司\",\"投资人、经理、执行董事、法定代表人\",\"1\",\"1\",\"1\",\"1\"],[\"刘广东\",\"北京金百创经贸有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"北京金百创经贸有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"王占云\",\"北京龙腾逸云经贸有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘翠彦\",\"北京龙腾逸云经贸有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"刘杰\",\"大同市思杰科技有限责任公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"大同市思杰科技有限责任公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"冠群天下投资管理（北京）有限公司\",\"监事\",\"1\",\"1\",\"0\",\"1\"],[\"曹晓荣\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘丰\",\"湖南瑞廷文化传播有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"湖南瑞廷文化传播有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘丰\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"刘杰\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"刘云\",\"荆州业兴艺术构建有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"荆州业兴艺术构建有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"昆明笛光机械设备有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"昆明笛光机械设备有限公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"刘丰\",\"三河市冠群驰骋投资咨询有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"三河市冠群驰骋投资咨询有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"陕西金雨林房地产开发有限公司\",\"自然人股东、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"陕西金雨林房地产开发有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘丰\",\"太原市鑫丰杰信息科技有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"太原市鑫丰杰信息科技有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘云\",\"重庆伸展物资有限公司\",\"自然人、监事\",\"1\",\"2\",\"1\",\"1\"],[\"刘杰\",\"重庆伸展物资有限公司\",\"自然人、执行董事经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"徐越\",\"北京冠群驰骋投资控股有限公司\",\"监事\",\"2\",\"2\",\"0\",\"1\"],[\"徐越\",\"北京冠群恒华信息咨询有限公司\",\"监事\",\"2\",\"2\",\"0\",\"1\"],[\"徐越\",\"北京冠群汇通信息咨询有限公司\",\"监事\",\"2\",\"2\",\"0\",\"1\"],[\"徐越\",\"北京冠群天勤信息咨询有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"赵继姣\",\"冠群驰骋金融信息服务（上海）有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"范晶晶\",\"冠群驰骋金融信息服务（上海）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"张涵\",\"冠群驰骋科技（上海）有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"范晶晶\",\"冠群驰骋科技（上海）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"徐越\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"经理、执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"杨健\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"王茜茜\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人\",\"2\",\"1\",\"1\",\"1\"],[\"赵玉茹\",\"冠群驰骋投资管理（深圳）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"杨健\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人\",\"2\",\"1\",\"1\",\"1\"],[\"徐越\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"2\",\"1\",\"1\",\"1\"],[\"赵继姣\",\"冠群天下投资管理（北京）有限公司\",\"经理、执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"陕西金雨林房地产开发有限公司\",\"陕西柳鑫置业有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"徐越\",\"深圳市冠群方物创新资产管理有限公司\",\"自然人、总经理\",\"2\",\"3\",\"1\",\"1\"],[\"刘英\",\"沈阳冠群驰骋投资管理有限公司\",\"自然人股东、监事\",\"2\",\"1\",\"1\",\"1\"],[\"王笑梅\",\"沈阳冠群驰骋投资管理有限公司\",\"自然人股东、执行董事、法定代表人\",\"2\",\"1\",\"1\",\"1\"],[\"王茜茜\",\"卓冠九州商务咨询（北京）有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"赵玉茹\",\"深圳冠群朴素资本管理有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"赵玉茹\",\"深圳市冠群方物创新资产管理有限公司\",\"自然人、执行（常务）董事、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"陈跃祥\",\"德立信资产管理有限公司\",\"自然人股东、监事\",\"2\",\"1\",\"1\",\"1\"],[\"刘桂东\",\"德立信资产管理有限公司\",\"自然人股东、法定代表人、执行董事、经理\",\"2\",\"1\",\"1\",\"1\"],[\"王茜茜\",\"德立信资产管理有限公司\",\"自然人股东\",\"2\",\"1\",\"1\",\"1\"],[\"张宏明\",\"德立信资产管理有限公司\",\"自然人股东\",\"2\",\"1\",\"1\",\"1\"],[\"北京冠群驰骋投资控股有限公司\",\"北京冠汇世纪股权投资基金管理有限公司\",\"投资人\",\"2\",\"3\",\"1\",\"0\"],[\"张瑞盈\",\"北京冠汇世纪股权投资基金管理有限公司\",\"经理、执行董事\",\"3\",\"3\",\"0\",\"1\"],[\"赵玉茹\",\"北京冠汇世纪股权投资基金管理有限公司\",\"监事\",\"2\",\"3\",\"0\",\"1\"],[\"赵玉茹\",\"北京冠汇睿盈投资管理中心（有限合伙）\",\"投资人\",\"2\",\"3\",\"1\",\"1\"],[\"赵玉茹\",\"北京冠汇安益投资管理中心（有限合伙）\",\"投资人\",\"2\",\"3\",\"1\",\"1\"],[\"赵玉茹\",\"北京冠汇富春投资管理中心（有限合伙）\",\"投资人\",\"2\",\"3\",\"1\",\"1\"],[\"刘红\",\"北京东方正杰贸易有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"张瑞盈\",\"北京冠群驰骋投资控股有限公司\",\"投资人\",\"3\",\"2\",\"1\",\"1\"],[\"闫湖洋\",\"北京金百创经贸有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"高建利\",\"大同市思杰科技有限责任公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"康保富\",\"大同市思杰科技有限责任公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"闫铁峰\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"闫湖洋\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘秉全\",\"冠群中誉投资担保（北京）有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘晓平\",\"湖南辉煌电梯维保服务有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"夏冬芳\",\"湖南瑞廷文化传播有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"林景濠\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"凯伦光伏材料投资有限公司\",\"济宁凯伦光伏材料有限公司\",\"\",\"3\",\"2\",\"1\",\"0\"],[\"刘湘茂\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"贺学初\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"刘伟\",\"济宁凯伦光伏材料有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"施立新\",\"济宁凯伦光伏材料有限公司\",\"法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"刘泓君\",\"昆明笛光机械设备有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘飞\",\"昆明笛光机械设备有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"深圳市冠群方物创新资产管理有限公司\",\"深圳冠群朴素资本管理有限公司\",\"企业法人\",\"3\",\"3\",\"1\",\"0\"],[\"张瑞盈\",\"卓冠九州商务咨询（北京）有限公司\",\"监事\",\"3\",\"3\",\"0\",\"1\"]]");
        DATA_MAP.put("冠群驰骋投资管理（北京）有限公司_20151116", "[[\"冠群驰骋投资管理（北京）有限公司\",\"沈阳冠群驰骋投资管理有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"刘云\",\"冠群驰骋投资管理（北京）有限公司\",\"经理、执行董事、法定代表人\",\"1\",\"0\",\"0\",\"1\"],[\"北京冠群天勤信息咨询有限公司\",\"冠群驰骋投资管理（北京）有限公司\",\"法人股东\",\"1\",\"0\",\"1\",\"0\"],[\"深圳市冠群方物创新资产管理有限公司\",\"深圳冠群朴素资本管理有限公司\",\"企业法人\",\"3\",\"3\",\"1\",\"0\"],[\"徐越\",\"深圳冠群开元创业投资有限公司\",\"自然人\",\"2\",\"3\",\"0\",\"1\"],[\"徐越\",\"深圳市冠群方物创新资产管理有限公司\",\"自然人、总经理\",\"2\",\"3\",\"0\",\"1\"],[\"刘杰\",\"三河市冠群驰骋投资咨询有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"曹晓荣\",\"北京旭日晨光家政服务有限责任公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王占云\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"徐越\",\"北京优道极致健康产业投资股份有限公司\",\"自然人股东、董事\",\"2\",\"3\",\"1\",\"1\"],[\"张宏明\",\"德立信资产管理有限公司\",\"自然人股东\",\"2\",\"1\",\"1\",\"1\"],[\"刘英\",\"北京优道极致健康产业投资股份有限公司\",\"自然人股东、董事长、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"刘英\",\"沈阳冠群驰骋投资管理有限公司\",\"自然人股东、监事\",\"2\",\"1\",\"1\",\"1\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋金融信息服务（上海）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"赵玉茹\",\"深圳冠群朴素资本管理有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"2\",\"3\",\"0\",\"1\"],[\"杨健\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"刘广东\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"王笑梅\",\"沈阳冠群驰骋投资管理有限公司\",\"自然人股东、执行董事、法定代表人\",\"2\",\"1\",\"1\",\"1\"],[\"杨健\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人\",\"2\",\"1\",\"0\",\"1\"],[\"刘杰\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘桂东\",\"德立信资产管理有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"2\",\"1\",\"1\",\"1\"],[\"赵玉茹\",\"深圳冠群开元创业投资有限公司\",\"自然人、监事\",\"2\",\"3\",\"0\",\"1\"],[\"陈跃祥\",\"德立信资产管理有限公司\",\"自然人股东、监事\",\"2\",\"1\",\"1\",\"1\"],[\"赵继姣\",\"北京优道极致健康产业投资股份有限公司\",\"自然人股东、董事\",\"2\",\"3\",\"1\",\"1\"],[\"范晶晶\",\"冠群驰骋科技（上海）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"刘翠彦\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"徐越\",\"冠君征信有限责任公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"胡金鹅\",\"北京旭日晨光家政服务有限责任公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"张涵\",\"冠群驰骋科技（上海）有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"刘云\",\"冠群天下投资管理（北京）有限公司\",\"监事\",\"1\",\"1\",\"0\",\"1\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋科技（上海）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"徐越\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋投资管理（深圳）有限公司\",\"法人股东\",\"0\",\"1\",\"1\",\"0\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群天下投资管理（北京）有限公司\",\"法人股东\",\"0\",\"1\",\"1\",\"0\"],[\"刘丰\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东\",\"1\",\"0\",\"1\",\"1\"],[\"刘翠彦\",\"北京龙腾逸云经贸有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"冠群驰骋投资管理（北京）有限公司\",\"德立信资产管理有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"赵玉茹\",\"深圳市冠群方物创新资产管理有限公司\",\"自然人、执行（常务）董事、法定代表人\",\"2\",\"3\",\"0\",\"1\"],[\"范晶晶\",\"冠群驰骋金融信息服务（上海）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"张瑞盈\",\"冠君征信有限责任公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"王茜茜\",\"德立信资产管理有限公司\",\"自然人股东\",\"2\",\"1\",\"1\",\"1\"],[\"王茜茜\",\"冠群驰骋投资管理（深圳）有限公司\",\"自然人\",\"2\",\"1\",\"0\",\"1\"],[\"徐越\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"经理、执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"王占云\",\"北京龙腾逸云经贸有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"曹倩\",\"北京冠益信科技有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"赵继姣\",\"冠群天下投资管理（北京）有限公司\",\"经理、执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"赵玉茹\",\"冠群驰骋投资管理（深圳）有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"曹晓荣\",\"冠群驰骋投资管理（北京）有限公司\",\"自然人股东、监事\",\"1\",\"0\",\"1\",\"1\"],[\"刘丰\",\"三河市冠群驰骋投资咨询有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠群驰骋商务信息咨询（天津）有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"曹晓荣\",\"北京冠益信科技有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"冠群驰骋投资管理（北京）有限公司\",\"冠君征信有限责任公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"赵继姣\",\"冠群驰骋金融信息服务（上海）有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"]]");
        DATA_MAP.put("金易融（北京）网络科技有限公司_20150830", "[[\"王之焕\",\"金易融（北京）网络科技有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"0\",\"1\",\"1\"],[\"宋在庆\",\"金易融（北京）网络科技有限公司\",\"自然人股东、监事\",\"1\",\"0\",\"1\",\"1\"],[\"田竞宸\",\"金易融（北京）网络科技有限公司\",\"经理\",\"1\",\"0\",\"0\",\"1\"],[\"金易融（北京）网络科技有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"2\",\"1\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"2\",\"1\",\"1\",\"0\"],[\"白丽\",\"金易融（上海）网络科技有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"刘桂宏\",\"金易融（上海）网络科技有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"宋在庆\",\"安徽德聚资产管理有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"宋在庆\",\"安徽省聚汇通资产管理有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰恒金融信息服务有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"安徽钰诚云商电子商务有限公司\",\"执行董事兼总经理、法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"北京钰诚云商资产管理有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"宋在庆\",\"安徽平行者资产管理有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰睿财富资产管理有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰拓寰宇信息科技服务有限公司\",\"企业法人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰翔商务咨询有限公司\",\"企业法人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"上海毅旭实业有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"上海钰申金融信息服务有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"北京市海康制药有限责任公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"圣英金融信息服务（上海）有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽乾亨贸易有限公司\",\"执行董事兼总经理、法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"安徽广汇通资产管理有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"安徽钰霖融资租赁有限公司\",\"董事兼总经理\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"金易融（安徽）网络科技有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰安徽商务咨询有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰（北京）商务咨询有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰（北京）网络科技有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"蚌埠聚汇通投资咨询有限公司\",\"安徽省聚汇通资产管理有限公司\",\"自然人股东\",\"2\",\"2\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽钰诚云商电子商务有限公司\",\"企业法人\",\"2\",\"2\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚云商资产管理有限公司\",\"法人股东\",\"2\",\"2\",\"1\",\"0\"],[\"上海毅旭实业有限公司\",\"融泰融资租赁（上海）有限公司\",\"企业法人\",\"2\",\"2\",\"1\",\"0\"],[\"融泰融资租赁（上海）有限公司\",\"圣英金融信息服务（上海）有限公司\",\"企业法人\",\"2\",\"2\",\"1\",\"0\"],[\"江艳\",\"安徽德聚资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"李虎\",\"安徽省聚汇通资产管理有限公司\",\"执行董事兼总经理、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰恒金融信息服务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"黄赞燕\",\"深圳钰恒金融信息服务有限公司\",\"自然人\",\"3\",\"2\",\"1\",\"1\"],[\"丁延柏\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"高俊俊\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东、董事长兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"宋淑侠\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东、董事\",\"3\",\"2\",\"1\",\"1\"],[\"丁宁\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"王连章\",\"安徽钰诚控股集团股份有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"彭力\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"备选\",\"安徽钰诚控股集团股份有限公司\",\"监事、监事\",\"3\",\"2\",\"0\",\"1\"],[\"张敏\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"李莉\",\"安徽钰诚云商电子商务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁宁\",\"北京钰诚云商资产管理有限公司\",\"经理、执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"上海市虹口区国有资产监督管理委员会\",\"上海虹口投资控股有限公司\",\"机关法人\",\"3\",\"2\",\"1\",\"0\"],[\"徐民富\",\"上海虹口投资控股有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"谢榕榕\",\"上海虹口投资控股有限公司\",\"执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"徐林青\",\"安徽平行者资产管理有限公司\",\"自然人股东、总经理\",\"3\",\"2\",\"1\",\"1\"],[\"江艳\",\"安徽平行者资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"黄赞燕\",\"深圳钰睿财富资产管理有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰睿财富资产管理有限公司\",\"自然人\",\"3\",\"2\",\"1\",\"1\"],[\"石雨光\",\"深圳钰拓寰宇信息科技服务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"黄赞燕\",\"深圳钰拓寰宇信息科技服务有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"1\"],[\"黄赞燕\",\"深圳钰翔商务咨询有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰翔商务咨询有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"1\"],[\"丁延柏\",\"上海毅旭实业有限公司\",\"自然人股东、执行董事、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"安徽钰诚投资发展股份有限公司\",\"上海钰申金融信息服务有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"0\"],[\"许辉\",\"上海钰申金融信息服务有限公司\",\"执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"韩妮娜\",\"北京市海康制药有限责任公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"王黎民\",\"北京市海康制药有限责任公司\",\"自然人股东、遗留状态、总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"陈琳琳\",\"圣英金融信息服务（上海）有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"朱延安\",\"圣英金融信息服务（上海）有限公司\",\"经理\",\"3\",\"2\",\"0\",\"1\"],[\"高增贵\",\"安徽乾亨贸易有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"李群芳\",\"安徽乾亨贸易有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"路涛\",\"安徽广汇通资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"王民\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"彭力\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"杨飞\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁宁\",\"安徽钰诚融资租赁有限公司\",\"董事长、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"郭宁\",\"安徽钰诚融资租赁有限公司\",\"董事兼总经理\",\"3\",\"2\",\"0\",\"1\"],[\"陈国强\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"安徽钰诚投资发展股份有限公司\",\"安徽钰诚融资租赁有限公司\",\"法人股东\",\"3\",\"2\",\"1\",\"0\"],[\"蚌埠市钰诚新材料科技有限公司\",\"安徽钰诚融资租赁有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"0\"],[\"GLENWOODIMPORTANDEXPORTPTYLTD\",\"安徽钰诚融资租赁有限公司\",\"其他投资者\",\"3\",\"2\",\"1\",\"0\"],[\"丁甸\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁未巍\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"李群芳（主席）\",\"安徽钰霖融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"王健\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"许珞\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"陈泳屺\",\"安徽钰霖融资租赁有限公司\",\"\",\"3\",\"2\",\"0\",\"1\"],[\"安徽钰诚投资发展股份有限公司\",\"安徽钰霖融资租赁有限公司\",\"法人股东\",\"3\",\"2\",\"1\",\"0\"],[\"彭力\",\"安徽钰霖融资租赁有限公司\",\"法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"WOOKESCIENCETECHNOLOGYAUSTRALIAPTY.LTD.\",\"安徽钰霖融资租赁有限公司\",\"外国(地区)企业\",\"3\",\"2\",\"1\",\"0\"],[\"李倩倩\",\"安徽钰霖融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"李倩倩\",\"金易融（安徽）网络科技有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"薛敏\",\"钰诚融泰安徽商务咨询有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"钰诚融泰（北京）商务咨询有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"钰诚融泰（北京）网络科技有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"安徽钰诚融资租赁有限公司\",\"安徽钰诚日鑫投资基金（有限合伙）\",\"\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽恒钰贸易有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽金钰投资管理有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽祥旺贸易有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰汇资本管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"上海汉梵企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"白丽\",\"上海汉梵企业管理有限公司\",\"监事\",\"2\",\"3\",\"0\",\"1\"],[\"刘桂宏\",\"上海汉梵企业管理有限公司\",\"执行董事兼总经理、法定代表人\",\"2\",\"3\",\"0\",\"1\"],[\"上海虹口投资控股有限公司\",\"上海和虹资产管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海虹口科技投资发展有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海虹口投资管理公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海仁虹投资管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海市虹口区土地开发有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海中虹（集团）有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"钰诚融泰（北京）商务咨询有限公司\",\"龙口钰诚融泰商务咨询有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"]]");
        DATA_MAP.put("金易融（北京）网络科技有限公司_20150905", "[[\"王之焕\",\"金易融（北京）网络科技有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"0\",\"1\",\"1\"],[\"宋在庆\",\"金易融（北京）网络科技有限公司\",\"自然人股东、监事\",\"1\",\"0\",\"1\",\"1\"],[\"田竞宸\",\"金易融（北京）网络科技有限公司\",\"经理\",\"1\",\"0\",\"0\",\"1\"],[\"金易融（北京）网络科技有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"2\",\"1\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"2\",\"1\",\"1\",\"0\"],[\"刘桂宏\",\"金易融（上海）网络科技有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"白丽\",\"金易融（上海）网络科技有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"王之焕\",\"安徽钰诚云商电子商务有限公司\",\"执行董事兼总经理、法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"北京钰诚云商资产管理有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"上海钰申金融信息服务有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"安徽乾亨贸易有限公司\",\"执行董事兼总经理、法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"宋在庆\",\"安徽平行者资产管理有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽广汇通资产管理有限公司\",\"自然人股东、法定代表人、执行董事兼总经理\",\"1\",\"2\",\"1\",\"1\"],[\"宋在庆\",\"安徽德聚资产管理有限公司\",\"自然人股东、法定代表人、执行董事兼总经理\",\"1\",\"2\",\"1\",\"1\"],[\"宋在庆\",\"安徽省聚汇通资产管理有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"安徽钰霖融资租赁有限公司\",\"董事兼总经理\",\"1\",\"2\",\"0\",\"1\"],[\"田竞宸\",\"深圳钰恒金融信息服务有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰拓寰宇信息科技服务有限公司\",\"企业法人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰睿财富资产管理有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰翔商务咨询有限公司\",\"企业法人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"金易融（安徽）网络科技有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰安徽商务咨询有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰（北京）商务咨询有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰（北京）网络科技有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"北京钰恒投资管理有限公司\",\"自然人股东、经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"上海毅旭实业有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"圣英金融信息服务（上海）有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽钰诚云商电子商务有限公司\",\"企业法人\",\"2\",\"2\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚云商资产管理有限公司\",\"法人股东\",\"2\",\"2\",\"1\",\"0\"],[\"李莉\",\"安徽钰诚云商电子商务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁宁\",\"北京钰诚云商资产管理有限公司\",\"经理、执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"上海市虹口区国有资产监督管理委员会\",\"上海虹口投资控股有限公司\",\"机关法人\",\"3\",\"2\",\"1\",\"0\"],[\"谢榕榕\",\"上海虹口投资控股有限公司\",\"执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"徐民富\",\"上海虹口投资控股有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"安徽钰诚投资发展股份有限公司\",\"上海钰申金融信息服务有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"0\"],[\"许辉\",\"上海钰申金融信息服务有限公司\",\"执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"高增贵\",\"安徽乾亨贸易有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"李群芳\",\"安徽乾亨贸易有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"徐林青\",\"安徽平行者资产管理有限公司\",\"自然人股东、总经理\",\"3\",\"2\",\"1\",\"1\"],[\"江艳\",\"安徽平行者资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"路涛\",\"安徽广汇通资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"姜燕\",\"安徽德聚资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"蚌埠聚汇通投资咨询有限公司\",\"安徽省聚汇通资产管理有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"0\"],[\"李虎\",\"安徽省聚汇通资产管理有限公司\",\"执行董事兼总经理、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"王民\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"彭力\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"杨飞\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁宁\",\"安徽钰诚融资租赁有限公司\",\"董事长、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"郭宁\",\"安徽钰诚融资租赁有限公司\",\"董事兼总经理\",\"3\",\"2\",\"0\",\"1\"],[\"陈国强\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"安徽钰诚投资发展股份有限公司\",\"安徽钰诚融资租赁有限公司\",\"法人股东\",\"3\",\"2\",\"1\",\"0\"],[\"蚌埠市钰诚新材料科技有限公司\",\"安徽钰诚融资租赁有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"0\"],[\"GLENWOODIMPORTANDEXPORTPTYLTD\",\"安徽钰诚融资租赁有限公司\",\"其他投资者\",\"3\",\"2\",\"1\",\"0\"],[\"丁甸\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁未巍\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"李群芳（主席）\",\"安徽钰霖融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"王健\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"许珞\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"WOOKESCIENCETECHNOLOGYAUSTRALIAPTY.LTD.\",\"安徽钰霖融资租赁有限公司\",\"外国(地区)企业\",\"3\",\"2\",\"1\",\"0\"],[\"陈泳屺\",\"安徽钰霖融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"李倩倩\",\"安徽钰霖融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"安徽钰诚投资发展股份有限公司\",\"安徽钰霖融资租赁有限公司\",\"法人股东\",\"3\",\"2\",\"1\",\"0\"],[\"彭力\",\"安徽钰霖融资租赁有限公司\",\"法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰恒金融信息服务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"黄赞燕\",\"深圳钰恒金融信息服务有限公司\",\"自然人\",\"3\",\"2\",\"1\",\"1\"],[\"石雨光\",\"深圳钰拓寰宇信息科技服务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"黄赞燕\",\"深圳钰拓寰宇信息科技服务有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"1\"],[\"黄赞燕\",\"深圳钰睿财富资产管理有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰睿财富资产管理有限公司\",\"自然人\",\"3\",\"2\",\"1\",\"1\"],[\"黄赞燕\",\"深圳钰翔商务咨询有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰翔商务咨询有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"1\"],[\"李倩倩\",\"金易融（安徽）网络科技有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"薛敏\",\"钰诚融泰安徽商务咨询有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"钰诚融泰（北京）商务咨询有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"钰诚融泰（北京）网络科技有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁宁\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"宋淑侠\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"丁延柏\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"高俊俊\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东、董事长兼总经理\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东、董事\",\"3\",\"2\",\"1\",\"1\"],[\"备选\",\"安徽钰诚控股集团股份有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"张敏\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"彭力\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"王连章\",\"安徽钰诚控股集团股份有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"齐松岩\",\"北京钰恒投资管理有限公司\",\"自然人股东、执行董事\",\"3\",\"2\",\"1\",\"1\"],[\"谢洁\",\"北京钰恒投资管理有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁延柏\",\"上海毅旭实业有限公司\",\"自然人股东、执行董事、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"陈琳琳\",\"圣英金融信息服务（上海）有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"朱延安\",\"圣英金融信息服务（上海）有限公司\",\"经理\",\"3\",\"2\",\"0\",\"1\"],[\"融泰融资租赁（上海）有限公司\",\"圣英金融信息服务（上海）有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽金钰投资管理有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽祥旺贸易有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰汇资本管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"上海汉梵企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海和虹资产管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海虹口科技投资发展有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海虹口投资管理公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海仁虹投资管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海市虹口区土地开发有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海中虹（集团）有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"钰诚融泰（北京）商务咨询有限公司\",\"龙口钰诚融泰商务咨询有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽恒钰贸易有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"上海毅旭实业有限公司\",\"融泰融资租赁（上海）有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"]]");
        DATA_MAP.put("金易融（北京）网络科技有限公司_20151030", "[[\"王之焕\",\"金易融（北京）网络科技有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"0\",\"1\",\"1\"],[\"宋在庆\",\"金易融（北京）网络科技有限公司\",\"自然人股东、监事\",\"1\",\"0\",\"1\",\"1\"],[\"田竞宸\",\"金易融（北京）网络科技有限公司\",\"经理\",\"1\",\"0\",\"0\",\"1\"],[\"金易融（北京）网络科技有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"2\",\"1\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"2\",\"1\",\"1\",\"0\"],[\"白丽\",\"金易融（上海）网络科技有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"刘桂宏\",\"金易融（上海）网络科技有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"],[\"王之焕\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"安徽钰诚云商电子商务有限公司\",\"执行董事兼总经理、法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"北京钰诚云商资产管理有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"上海毅旭实业有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"上海达御电子科技中心\",\"法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"上海钰申金融信息服务有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"北京市海康制药有限责任公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"北京市海用物资贸易公司\",\"法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"北京钰恒投资管理有限公司\",\"自然人股东、经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽乾亨贸易有限公司\",\"执行董事兼总经理、法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"安徽宏燕装饰设计工程有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽广汇通资产管理有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"宋在庆\",\"安徽德聚资产管理有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"宋在庆\",\"安徽省聚汇通资产管理有限公司\",\"自然人股东、监事\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"王之焕\",\"安徽钰霖融资租赁有限公司\",\"董事兼总经理\",\"1\",\"2\",\"0\",\"1\"],[\"田竞宸\",\"深圳钰川汇盈金融信息服务有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰恒金融信息服务有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰拓寰宇信息科技服务有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰睿财富资产管理有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"田竞宸\",\"深圳钰翔商务咨询有限公司\",\"自然人、总经理、执行（常务）董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"金易融（安徽）网络科技有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰安徽商务咨询有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰（北京）商务咨询有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰（北京）网络科技有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽钰诚云商电子商务有限公司\",\"企业法人\",\"2\",\"2\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚云商资产管理有限公司\",\"法人股东\",\"2\",\"2\",\"1\",\"0\"],[\"蚌埠聚汇通投资咨询有限公司\",\"安徽省聚汇通资产管理有限公司\",\"自然人股东\",\"2\",\"2\",\"1\",\"0\"],[\"蚌埠市钰诚新材料科技有限公司\",\"安徽钰诚融资租赁有限公司\",\"企业法人\",\"2\",\"2\",\"1\",\"0\"],[\"安徽钰诚投资发展股份有限公司\",\"上海钰申金融信息服务有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"0\"],[\"安徽钰诚投资发展股份有限公司\",\"安徽钰诚融资租赁有限公司\",\"法人股东\",\"3\",\"2\",\"1\",\"0\"],[\"安徽钰诚投资发展股份有限公司\",\"安徽钰霖融资租赁有限公司\",\"法人股东\",\"3\",\"2\",\"1\",\"0\"],[\"彭力\",\"安徽钰霖融资租赁有限公司\",\"法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"丁延柏\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"高俊俊\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东、董事长兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"宋淑侠\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东、董事\",\"3\",\"2\",\"1\",\"1\"],[\"丁宁\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"王连章\",\"安徽钰诚控股集团股份有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"彭力\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"备选\",\"安徽钰诚控股集团股份有限公司\",\"监事、监事\",\"3\",\"2\",\"0\",\"1\"],[\"张敏\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"李莉\",\"安徽钰诚云商电子商务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁宁\",\"北京钰诚云商资产管理有限公司\",\"经理、执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"上海市虹口区国有资产监督管理委员会\",\"上海虹口投资控股有限公司\",\"机关法人\",\"3\",\"2\",\"1\",\"0\"],[\"徐民富\",\"上海虹口投资控股有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"谢榕榕\",\"上海虹口投资控股有限公司\",\"执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"丁甸\",\"云南钰尚企业管理有限公司\",\"监事\",\"3\",\"3\",\"0\",\"1\"],[\"丁延柏\",\"上海毅旭实业有限公司\",\"自然人股东、执行董事、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"许辉\",\"上海钰申金融信息服务有限公司\",\"执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"韩妮娜\",\"北京市海康制药有限责任公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"王黎民\",\"北京市海康制药有限责任公司\",\"自然人股东、遗留状态、总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"北京市燕达出租汽车公司\",\"北京市海用物资贸易公司\",\"其他非自然人投资者\",\"3\",\"2\",\"1\",\"0\"],[\"谢洁\",\"北京钰恒投资管理有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"齐松岩\",\"北京钰恒投资管理有限公司\",\"自然人股东、执行董事\",\"3\",\"2\",\"1\",\"1\"],[\"高增贵\",\"安徽乾亨贸易有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"李群芳\",\"安徽乾亨贸易有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"郭传宏\",\"安徽宏燕装饰设计工程有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"刘燕\",\"安徽宏燕装饰设计工程有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"路涛\",\"安徽广汇通资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"江艳\",\"安徽德聚资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"李虎\",\"安徽省聚汇通资产管理有限公司\",\"执行董事兼总经理、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"王民\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"彭力\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"杨飞\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁宁\",\"安徽钰诚融资租赁有限公司\",\"董事长、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"郭宁\",\"安徽钰诚融资租赁有限公司\",\"董事兼总经理\",\"3\",\"2\",\"0\",\"1\"],[\"陈国强\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"GLENWOODIMPORTANDEXPORTPTYLTD\",\"安徽钰诚融资租赁有限公司\",\"其他投资者\",\"3\",\"2\",\"1\",\"0\"],[\"丁甸\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"丁未巍\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"李群芳（主席）\",\"安徽钰霖融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"王健\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"许珞\",\"安徽钰霖融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"陈泳屺\",\"安徽钰霖融资租赁有限公司\",\"\",\"3\",\"2\",\"0\",\"1\"],[\"WOOKESCIENCETECHNOLOGYAUSTRALIAPTY.LTD.\",\"安徽钰霖融资租赁有限公司\",\"外国(地区)企业\",\"3\",\"2\",\"1\",\"0\"],[\"李倩倩\",\"安徽钰霖融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰川汇盈金融信息服务有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"1\"],[\"黄赞燕\",\"深圳钰川汇盈金融信息服务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰恒金融信息服务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"黄赞燕\",\"深圳钰恒金融信息服务有限公司\",\"自然人\",\"3\",\"2\",\"1\",\"1\"],[\"石雨光\",\"深圳钰拓寰宇信息科技服务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"黄赞燕\",\"深圳钰拓寰宇信息科技服务有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"1\"],[\"黄赞燕\",\"深圳钰睿财富资产管理有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰睿财富资产管理有限公司\",\"自然人\",\"3\",\"2\",\"1\",\"1\"],[\"黄赞燕\",\"深圳钰翔商务咨询有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"石雨光\",\"深圳钰翔商务咨询有限公司\",\"企业法人\",\"3\",\"2\",\"1\",\"1\"],[\"李倩倩\",\"金易融（安徽）网络科技有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"薛敏\",\"钰诚融泰安徽商务咨询有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"钰诚融泰（北京）商务咨询有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"钰诚融泰（北京）网络科技有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽恒钰贸易有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽金钰投资管理有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽祥旺贸易有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰汇资本管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"上海汉梵企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"白丽\",\"上海汉梵企业管理有限公司\",\"监事\",\"2\",\"3\",\"0\",\"1\"],[\"刘桂宏\",\"上海汉梵企业管理有限公司\",\"执行董事兼总经理、法定代表人\",\"2\",\"3\",\"0\",\"1\"],[\"上海虹口投资控股有限公司\",\"上海和虹资产管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海虹口科技投资发展有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海虹口投资管理公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海仁虹投资管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海市虹口区土地开发有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海中虹（集团）有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"钰诚博亚（北京）经济贸易发展有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"云南钰尚企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海毅旭实业有限公司\",\"融泰融资租赁（上海）有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚融资租赁有限公司\",\"安徽钰诚日鑫投资基金（有限合伙）\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"钰诚融泰（北京）商务咨询有限公司\",\"龙口钰诚融泰商务咨询有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京金钰联合商务咨询有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"]]");
        DATA_MAP.put("金易融（北京）网络科技有限公司_20151116", "[[\"安徽钰诚控股集团股份有限公司\",\"钰诚寰盛（北京）投资控股有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"王之焕\",\"安徽钰诚云商电子商务有限公司\",\"执行董事兼总经理、法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"路涛\",\"安徽广汇通资产管理有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"钰诚融泰（北京）商务咨询有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"谢榕榕\",\"上海虹口科技投资发展有限公司\",\"执行董事兼总经理、法定代表人\",\"3\",\"3\",\"0\",\"1\"],[\"安徽金钰投资管理有限公司\",\"上海仁立网络科技有限公司\",\"企业法人\",\"3\",\"3\",\"1\",\"0\"],[\"王之焕\",\"安徽广汇通资产管理有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"丁宁\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"齐松岩\",\"北京钰恒投资管理有限公司\",\"自然人股东、执行董事\",\"3\",\"2\",\"1\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽恒钰贸易有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽钰诚云商电子商务有限公司\",\"企业法人\",\"2\",\"2\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京金钰联合商务咨询有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"徐民富\",\"上海虹口投资控股有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"上海虹口投资控股有限公司\",\"上海虹口科技投资发展有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"王之焕\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"田竞宸\",\"金易融（北京）网络科技有限公司\",\"经理\",\"1\",\"0\",\"0\",\"1\"],[\"北京市燕达出租汽车公司\",\"北京市海用物资贸易公司\",\"其他非自然人投资者\",\"3\",\"2\",\"0\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚云商资产管理有限公司\",\"法人股东\",\"2\",\"2\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海中虹（集团）有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"王之焕\",\"北京市海用物资贸易公司\",\"法定代表人\",\"1\",\"2\",\"0\",\"1\"],[\"高俊俊\",\"北京金钰联合商务咨询有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"3\",\"3\",\"1\",\"1\"],[\"王民\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"白丽\",\"上海充雅企业管理有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"上海虹口投资控股有限公司\",\"上海虹口投资管理公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"白丽\",\"上海汉梵企业管理有限公司\",\"监事\",\"2\",\"3\",\"0\",\"1\"],[\"丁延柏\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰（北京）商务咨询有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"高俊俊\",\"安徽金钰投资管理有限公司\",\"执行董事兼总经理、法定代表人\",\"3\",\"3\",\"0\",\"1\"],[\"刘桂宏\",\"上海风韵服饰有限公司\",\"自然人股东、监事\",\"2\",\"3\",\"1\",\"1\"],[\"谢洁\",\"钰诚寰盛（北京）投资控股有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"3\",\"3\",\"1\",\"1\"],[\"张敏\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"宋在庆\",\"金易融（北京）网络科技有限公司\",\"自然人股东、监事\",\"1\",\"0\",\"1\",\"1\"],[\"备选\",\"安徽钰诚控股集团股份有限公司\",\"监事、监事\",\"3\",\"2\",\"0\",\"1\"],[\"白丽\",\"上海金鸿飞广告有限公司\",\"自然人股东、执行董事、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"刘桂宏\",\"上海仁立网络科技有限公司\",\"执行董事、法定代表人\",\"2\",\"3\",\"0\",\"1\"],[\"宋淑侠\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东\",\"3\",\"2\",\"1\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"上海汉梵企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"丁甸\",\"安徽恒钰贸易有限公司\",\"执行董事兼总经理、法定代表人\",\"3\",\"3\",\"0\",\"1\"],[\"王之焕\",\"北京钰恒投资管理有限公司\",\"自然人股东、经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"钰诚博亚（北京）经济贸易发展有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"丁甸\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东、董事\",\"3\",\"2\",\"1\",\"1\"],[\"王连章\",\"安徽钰诚控股集团股份有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽金钰投资管理有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"彭力\",\"安徽钰诚融资租赁有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"上海虹口投资控股有限公司\",\"上海仁虹投资管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"上海虹口投资控股有限公司\",\"上海风险投资管理中心有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"白丽\",\"上海合翼商贸有限公司\",\"自然人股东、执行董事、法定代表人\",\"2\",\"3\",\"1\",\"1\"],[\"王之焕\",\"钰诚融泰安徽商务咨询有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"丁宁\",\"北京钰诚云商资产管理有限公司\",\"经理、执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"丁甸\",\"云南钰尚企业管理有限公司\",\"监事\",\"3\",\"3\",\"0\",\"1\"],[\"刘桂宏\",\"上海汉梵企业管理有限公司\",\"执行董事兼总经理、法定代表人\",\"2\",\"3\",\"0\",\"1\"],[\"丁宁\",\"安徽恒钰贸易有限公司\",\"监事\",\"3\",\"3\",\"0\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"云南钰尚企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"安徽钰诚控股集团股份有限公司\",\"安徽祥旺贸易有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"杨飞\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"王黎民\",\"北京市海康制药有限责任公司\",\"自然人股东、遗留状态、总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"2\",\"1\",\"1\",\"0\"],[\"谢榕榕\",\"上海虹口投资控股有限公司\",\"执行董事、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"王之焕\",\"北京市海康制药有限责任公司\",\"自然人股东\",\"1\",\"2\",\"1\",\"1\"],[\"丁甸\",\"安徽祥旺贸易有限公司\",\"执行董事兼总经理、法定代表人\",\"3\",\"3\",\"0\",\"1\"],[\"王之焕\",\"钰诚融泰（北京）网络科技有限公司\",\"自然人股东、经理、执行董事、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"安徽金钰投资管理有限公司\",\"上海亦君商务咨询有限公司\",\"企业法人\",\"3\",\"3\",\"1\",\"0\"],[\"钰诚融泰（北京）商务咨询有限公司\",\"龙口钰诚融泰商务咨询有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"GLENWOOD IMPORT AND EXPORT PTY LTD\",\"安徽钰诚融资租赁有限公司\",\"其他投资者\",\"3\",\"2\",\"0\",\"0\"],[\"王之焕\",\"北京钰诚云商资产管理有限公司\",\"监事\",\"1\",\"2\",\"0\",\"1\"],[\"丁甸\",\"安徽金钰投资管理有限公司\",\"监事\",\"3\",\"3\",\"0\",\"1\"],[\"谢洁\",\"钰诚博亚（北京）经济贸易发展有限公司\",\"经理、执行董事、法定代表人\",\"3\",\"3\",\"0\",\"1\"],[\"王之焕\",\"金易融（北京）网络科技有限公司\",\"自然人股东、执行董事、法定代表人\",\"1\",\"0\",\"1\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚雅典娜学苑教育咨询有限公司\",\"法人股东\",\"2\",\"3\",\"1\",\"0\"],[\"陈国强\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"谢洁\",\"北京钰恒投资管理有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"郭宁\",\"安徽钰诚融资租赁有限公司\",\"董事兼总经理\",\"3\",\"2\",\"0\",\"1\"],[\"上海市虹口区国有资产监督管理委员会\",\"上海虹口投资控股有限公司\",\"机关法人\",\"3\",\"2\",\"1\",\"0\"],[\"李莉\",\"安徽钰诚云商电子商务有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰诚企业管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"李倩倩\",\"金易融（安徽）网络科技有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"丁甸\",\"安徽钰诚融资租赁有限公司\",\"监事\",\"3\",\"2\",\"0\",\"1\"],[\"安徽钰诚控股集团股份有限公司\",\"北京钰汇资本管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"张敏\",\"北京钰诚雅典娜学苑教育咨询有限公司\",\"经理、执行董事、法定代表人\",\"3\",\"3\",\"0\",\"1\"],[\"韩妮娜\",\"北京市海康制药有限责任公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"金易融（北京）网络科技有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"0\",\"1\",\"1\",\"0\"],[\"丁甸\",\"北京钰诚企业管理有限公司\",\"经理、执行董事、法定代表人\",\"3\",\"3\",\"0\",\"1\"],[\"薛敏\",\"钰诚融泰安徽商务咨询有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"上海虹口投资控股有限公司\",\"金易融（上海）网络科技有限公司\",\"企业法人\",\"2\",\"1\",\"1\",\"0\"],[\"白丽\",\"金易融（上海）网络科技有限公司\",\"监事\",\"2\",\"1\",\"0\",\"1\"],[\"王之焕\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"1\",\"2\",\"0\",\"1\"],[\"白丽\",\"上海亦君商务咨询有限公司\",\"监事\",\"2\",\"3\",\"0\",\"1\"],[\"丁甸\",\"钰诚融泰（北京）网络科技有限公司\",\"自然人股东、监事\",\"3\",\"2\",\"1\",\"1\"],[\"上海虹口投资控股有限公司\",\"上海和虹资产管理有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"高俊俊\",\"安徽钰诚控股集团股份有限公司\",\"自然人股东、董事长兼总经理、法定代表人\",\"3\",\"2\",\"1\",\"1\"],[\"上海虹口投资控股有限公司\",\"上海市虹口区土地开发有限公司\",\"企业法人\",\"2\",\"3\",\"1\",\"0\"],[\"丁宁\",\"安徽祥旺贸易有限公司\",\"监事\",\"3\",\"3\",\"0\",\"1\"],[\"丁宁\",\"安徽钰诚融资租赁有限公司\",\"董事长、法定代表人\",\"3\",\"2\",\"0\",\"1\"],[\"彭力\",\"安徽钰诚控股集团股份有限公司\",\"董事\",\"3\",\"2\",\"0\",\"1\"],[\"王之焕\",\"金易融（安徽）网络科技有限公司\",\"自然人股东、执行董事兼总经理、法定代表人\",\"1\",\"2\",\"1\",\"1\"],[\"刘桂宏\",\"金易融（上海）网络科技有限公司\",\"执行董事、法定代表人\",\"2\",\"1\",\"0\",\"1\"]]");
    }
}
