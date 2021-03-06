package com.bbd.bgo.service.task;

import com.bbd.data.mapper.PABPublicSentimentMapper;
import com.bbd.higgs.utils.ListUtil;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.ParkDO;
import com.bbd.wtyh.domain.vo.NewsVO;
import com.bbd.wtyh.mapper.BuildingMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.ParkMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Barney on 2017/8/17.
 */
@Service
public class PABSentimentTaskServiceImpl implements PABSentimentTaskService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ParkMapper parkMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Value("${api.baidu.batch.news.url}")
    private String batchNewsUrl;
    @Value("${api.baidu.batch.news.ktype}")
    private int ktype;
    @Value("${api.baidu.batch.news.ak}")
    private String appkey;
    @Value("${api.yuqing.url}")
    private String yuqingUrl;
    @Value("${api.dataom.url}")
    private String dataomUrl;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private PABPublicSentimentMapper pabPublicSentimentMapper;

    private String httpProxy = System.getenv("http_proxy");
    private static final String NEWS_TYPES = "qyxg_shanghai_fta,qyxg_national_economy";
    private static final Integer DEFAULT_PAGE_SIZE = 50;

    @Override
    @Scheduled(cron = "0 30 0 * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void saveParkPublicSentiment() throws Exception {
        try {
            List<ParkDO> parkList = parkMapper.queryAllPark();
            if (ListUtil.isNotEmpty(parkList)) {
                parkList.forEach((ParkDO park) -> {
                    if (null == park || StringUtils.isEmpty(park.getAreaId()) || StringUtils.isEmpty(park.getName()))
                        return;
                    List<String> companyNameList = companyMapper.queryCompanyNamesNew(park.getParkId(), null);
                    if (ListUtil.isNotEmpty(companyNameList)) {
                        NewsVO newsVO = this.queryBatchNews(companyNameList);
                        if (null == newsVO || ListUtil.isEmpty(newsVO.getResults())) {
                            newsVO = this.queryTypeNews();
                        }
                        if (null == newsVO || ListUtil.isEmpty(newsVO.getResults()))
                            return;
                        newsVO.getResults().forEach((NewsVO.Result r) -> {
                            r.setArea_id(park.getAreaId());
                            r.setPark(park.getName());
                            pabPublicSentimentMapper.addParkPublicSentiment(r);
                        });
                    }
                });
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }finally {
            pabPublicSentimentMapper.deleteRepeatParkPublicSentiment();
        }
    }

    @Override
    @Scheduled(cron = "0 30 0 * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void saveBuildingPublicSentiment() throws Exception {
        try {
            List<BuildingDO> buildingList = buildingMapper.queryAllBuilding();
            if (ListUtil.isNotEmpty(buildingList)) {
                buildingList.forEach((BuildingDO building) -> {
                    if (null == building || StringUtils.isEmpty(building.getBuildingId()))
                        return;
                    List<String> companyNameList = companyMapper.queryCompanyNamesByBuildId(building.getBuildingId());
                    if (ListUtil.isNotEmpty(companyNameList)) {
                        NewsVO newsVO = this.queryBatchNews(companyNameList);
                        if (null == newsVO || ListUtil.isEmpty(newsVO.getResults())) {
                            newsVO = new NewsVO();
                            newsVO.addNewsVO(findNews("qyxg_shanghai_finance_office", 7));
                            newsVO.addNewsVO(findNews("qyxg_weiyangwang", 6));
                            if (ListUtil.isEmpty(newsVO.getResults()))
                                newsVO.addNewsVO(findNews("qyxg_chinesefinancialnews", 20));
                            else
                                newsVO.addNewsVO(findNews("qyxg_chinesefinancialnews",20 - newsVO.getResults().size()));
                        }
                        if (ListUtil.isEmpty(newsVO.getResults()))
                            return;
                        newsVO.getResults().forEach((NewsVO.Result r) -> {
                            r.setBuilding_id(building.getBuildingId());
                            pabPublicSentimentMapper.addBuildingPublicSentiment(r);
                        });
                    }
                });
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }finally {
            //????????????????????????
            pabPublicSentimentMapper.deleteRepeatBuildingPublicSentiment();
        }
    }

    /**
     * ??????????????????
     *
     * @param list
     * @return
     */
    private NewsVO queryBatchNews(List<String> list) {
        if (ListUtil.isEmpty(list) || StringUtils.isEmpty(batchNewsUrl))
            return null;
        String result = "";
        Gson gson = new Gson();
        NewsVO newsVO = new NewsVO();
        int size = list.size();
        for (int i = 0; i < size;) {
            StringBuilder buffer = new StringBuilder();
            List<String> subNameList = list.subList(i, (i += 20) < size ? i : size);
            for (String name : subNameList) {
                buffer.append(buffer.length() > 0 ? "," : "").append(name);
            }

            StringBuilder builder = new StringBuilder("?keys=").append(buffer);
            builder.append("&ktype=").append(ktype).append("&page=1&pageSize=20&appkey=").append(appkey);
            try {
                //result = this.sendPost(batchNewsUrl, builder.toString());
                result = new HttpTemplate().get(batchNewsUrl+builder.toString());
                if (StringUtils.isEmpty(result))
                    return null;
                NewsVO vo = gson.fromJson(result, new TypeToken<NewsVO>(){}.getType());
                newsVO.addNewsVO(vo);
                if (ListUtil.isNotEmpty(newsVO.getResults()) && newsVO.getResults().size() >= 20) {
                    newsVO.setResults(newsVO.getResults().subList(0, 20));
                    break;
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return null;
            }
        }
        return newsVO;

    }

    /**
     * HttpTemplate??????post?????????post????????????????????????---By Barney
     *
     * @param url ????????????
     * @param params ?????????e.g.---aaa=3&bbb=4
     * @return
     */
    private String sendPost(String url, String params) {
        if (StringUtils.isEmpty(url))
            return null;
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            if(!StringUtils.isEmpty(httpProxy)){ // ??????????????????
                URI proxyURI = new URI(httpProxy);
                Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyURI.getHost(), proxyURI.getPort()));
                conn = (HttpURLConnection) realUrl.openConnection(proxy);
            }else{
                conn = (HttpURLConnection) realUrl.openConnection();
            }
			/* post???????????? */
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            /* ??????????????????????????? */
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conn.connect();

            out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            if (!StringUtils.isEmpty(params))
                out.write(params);
            // ??????
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return result;
        } finally{
            try{
                if(null != out)
                    out.close();
                if(null != in)
                    in.close();
            } catch(IOException ex){
                logger.error(ex.getMessage(), ex);
            }
        }
        return result;
    }

    /**
     * ????????????????????????
     *
     * @return
     */
    public NewsVO queryTypeNews() {
        if (StringUtils.isEmpty(yuqingUrl))
            return null;
        String url = String.format(yuqingUrl, NEWS_TYPES, DEFAULT_PAGE_SIZE);
        try {
            String result = new HttpTemplate().get(url);
            if (StringUtils.isEmpty(result))
                return null;
            Gson gson = new Gson();
            NewsVO vo = gson.fromJson(result, new TypeToken<NewsVO>(){}.getType());

            if(null != vo && ListUtil.isNotEmpty(vo.getResults())){
                Iterator<NewsVO.Result> it = vo.getResults().iterator();
                while (it.hasNext()) {
                    NewsVO.Result rt = it.next();
                    /* ?????????????????? */
                    if("qyxg_financial_times".equals(rt.getBbd_type()) && !"??????".equals(rt.getPlate())) {
                        it.remove();
                    } else if ("qyxg_sinafinance".equals(rt.getBbd_type()) && !"????????????".equals(rt.getPlate())&& !"????????????".equals(rt.getPlate())&& !"????????????".equals(rt.getPlate())) {
                        it.remove();
                    } else {}
                }
                if(vo.getResults().size() > 20)
                    vo.setResults(vo.getResults().subList(0, 20));
            }
            return vo;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * ???????????????????????????
     *
     * @param key ???????????????
     * @param size ??????????????????
     * @return
     */
    public NewsVO findNews(String key, Integer size) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(dataomUrl))
            return null;
        if (null == size)
            size = 20;
        String url = String.format(dataomUrl, key, size);
        try {
            String result = new HttpTemplate().get(url);
            if (StringUtils.isEmpty(result))
                return null;
            Gson gson = new Gson();
            NewsVO vo = gson.fromJson(result, new TypeToken<NewsVO>(){}.getType());
            return vo;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

}
