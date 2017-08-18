package com.bbd.data.service.impl;

import com.bbd.data.service.PABPublicSentimentService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
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
public class PABPublicSentimentServiceImpl implements PABPublicSentimentService {

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

    private String httpProxy = System.getenv("http_proxy");

    @Override
    // @Scheduled(cron = "0/10 * * * * ?")
    public void saveParkPublicSentiment() {
        List<ParkDO> parkList = parkMapper.queryAllPark();
        if (ListUtil.isNotEmpty(parkList)) {
            parkList.forEach((ParkDO park) -> {
                List<String> companyNameList = companyMapper.queryCompanyNames(park.getAreaId(), null, park.getName());
                NewsVO newsVO = this.queryBatchNews(companyNameList);
                if (null == newsVO || 0 == newsVO.getRsize()) {
                    newsVO = this.queryTypeNews();
                    // TODO 新增园区舆情
                } else {
                    // TODO 直接新增园区舆情
                }
            });
        }
    }

    @Override
    // @Scheduled(cron = "0/10 * * * * ?")
    public void saveBuildingPublicSentiment() {
        List<BuildingDO> buildingList = buildingMapper.queryAllBuilding();
        if (ListUtil.isNotEmpty(buildingList)) {
            buildingList.forEach((BuildingDO building) -> {
                List<String> companyNameList = companyMapper.queryCompanyNames(null, building.getBuildingId(), null);
                NewsVO newsVO = this.queryBatchNews(companyNameList);
                if (null == newsVO || 0 == newsVO.getRsize()) {
                    NewsVO vo = new NewsVO();
                    vo.addNewsVO(findNews("qyxg_shanghai_finance_office",7));
                    vo.addNewsVO(findNews("qyxg_weiyangwang",6));
                    vo.addNewsVO(findNews("qyxg_chinesefinancialnews",20 - vo.getRsize()));
                    // TODO 新增楼宇舆情
                } else {
                    // TODO 直接新增楼宇舆情
                }
            });
        }
    }

    /**
     * 批量舆情查询
     *
     * @param list
     * @return
     */
    private NewsVO queryBatchNews(List<String> list) {
        String result = null;
        Gson gson = new Gson();
        NewsVO newsVO = new NewsVO();
        if (ListUtil.isNotEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size;) {
                StringBuilder buffer = new StringBuilder();
                List<String> subNameList = list.subList(i, (i += 100) < size ? i : size);
                for (String name : subNameList) {
                    buffer.append(buffer.length() > 0 ? "," : "").append(name);
                }

                StringBuilder builder = new StringBuilder("keys=").append(buffer);
                builder.append("&ktype=").append(ktype).append("&page=1&pageSize=20&appkey=").append(appkey);
                try {
                    result = this.sendPost(batchNewsUrl, builder.toString());
                    NewsVO vo = gson.fromJson(result, new TypeToken<NewsVO>(){}.getType());
                    newsVO.addNewsVO(vo);
                    if (null != newsVO.getResults() && newsVO.getResults().size() >= 20) {
                        newsVO.setResults(newsVO.getResults().subList(0, 20));
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return newsVO;

    }

    /**
     * HttpTemplate中的post是个伪post，这里写个原生的---By Barney
     *
     * @param url 请求地址
     * @param params 参数，e.g.---aaa=3&bbb=4
     * @return
     */
    private String sendPost(String url, String params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            if(!StringUtils.isEmpty(httpProxy)){ // 使用代理模式
                URI proxyURI = new URI(httpProxy);
                Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyURI.getHost(), proxyURI.getPort()));
                conn = (HttpURLConnection) realUrl.openConnection(proxy);
            }else{
                conn = (HttpURLConnection) realUrl.openConnection();
            }
			/* post请求设置 */
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conn.connect();

            out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out.write(params);
            // 清流
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        } finally{
            try{
                if(null != out)
                    out.close();
                if(null != in)
                    in.close();
            } catch(IOException ex){
            }
        }
        return result;
    }

    public NewsVO queryTypeNews() {
        String url = String.format(yuqingUrl, "qyxg_shanghai_fta,qyxg_national_economy", 50);
        try {
            String result = new HttpTemplate().get(url);
            Gson gson = new Gson();
            NewsVO vo = gson.fromJson(result,new TypeToken<NewsVO>(){}.getType());

            if(null != vo && null != vo.getResults()){
                Iterator<NewsVO.Result> it = vo.getResults().iterator();
                while (it.hasNext()) {
                    NewsVO.Result rt = it.next();
                    if("qyxg_financial_times".equals(rt.getBbd_type()) && !"金融".equals(rt.getPlate())){
                        it.remove();
                    } else if ("qyxg_sinafinance".equals(rt.getBbd_type()) && !"宏观经济".equals(rt.getPlate())&& !"金融新闻".equals(rt.getPlate())&& !"国内财经".equals(rt.getPlate())){
                        it.remove();
                    } else {}
                }
                if(vo.getResults().size() > 20)
                    vo.setResults(vo.getResults().subList(0, 20));
            }
            return vo;
        } catch (Exception e) {
            return new NewsVO();
        }
    }

    public NewsVO findNews(String key, Integer size) {
        String url = String.format(dataomUrl, key, size);
        try {
            String result = new HttpTemplate().get(url);
            Gson gson = new Gson();
            NewsVO vo = gson.fromJson(result,new TypeToken<NewsVO>(){}.getType());
            return vo;
        } catch (Exception e) {
            return null;
        }
    }

}
