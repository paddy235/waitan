package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.dataLoading.QyxgYuqingDO;
import com.bbd.wtyh.domain.vo.NewsVO;
import com.bbd.wtyh.mapper.YuQingMapper;
import com.bbd.wtyh.service.CompanyNewsService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author tracy zhou
 * @since 2016.08.12
 */
@Service
public class CompanyNewsServiceImpl implements CompanyNewsService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Value("${api.baidu.batch.news.ak}")
    private String ak;

    @Value("${api.baidu.batch.news.ktype}")
    private int ktype;

    @Value("${api.dataom.yuqing.url}")
    private String apiDataomYuqingUrl;


    @Value("${api.dataom.news.url}")
    private String apiDataonNewsUrl;

    @Value("${api.dataom.url}")
    private String apiDataomUrl;

    @Value("${api.yuqing.url}")
    private String apiYuqingUrl;

    @Autowired
    private YuQingMapper yuQingMapper;


    public NewsVO getNewsFromDb(String types,Integer len ){
        NewsVO vo = null;
        List<QyxgYuqingDO> yuqingDOList;
        try{
            String[] typesArr = new String[0];
            if(types!=null){
                typesArr=types.split(",");
            }
            yuqingDOList=yuQingMapper.getYuQingFromDbByType(Arrays.asList(typesArr),len);
            if(!CollectionUtils.isEmpty(yuqingDOList)){
                vo = new NewsVO();
                vo.setMsg("ok");
                vo.setTotal(yuqingDOList.size());
                vo.setRsize(vo.getTotal());
                List<NewsVO.Result> results=new ArrayList<>();
                BeanCopier beanCopier = BeanCopier.create(QyxgYuqingDO.class, NewsVO.Result.class, false);

                for(QyxgYuqingDO yuqingDO:yuqingDOList){
                    NewsVO.Result r= new NewsVO.Result();
                    beanCopier.copy(yuqingDO,r,null);
                    r.setaBstract(yuqingDO.getArticleAbstract());
                    r.setPubdate(DateFormatUtils.format(yuqingDO.getPubdate(),"yyyy-MM-dd"));

                    results.add(r);
                }
                vo.setResults(results);
            }
        }catch(Exception e){
            logger.error("getNewsFromDb : "+e);
            vo=null;
        }
        return  vo;
    }

    public NewsVO mutilTypeNews(String types,Integer size){
        int len=size + 30;
        long start = System.currentTimeMillis();
        String url = String.format(apiYuqingUrl,types,len);
        NewsVO vo ;
        try {
            //????????????????????????
            vo = getNewsFromDb( types, size );
            if(null == vo){
            //????????????????????????????????????
                String result = new HttpTemplate().get(url);
                Gson gson = new Gson();
                vo = gson.fromJson(result,new TypeToken<NewsVO>(){}.getType());
                logger.info("?????????????????????????????????????????????");

            }

            logger.info("?????????????????????{}ms,url????????????{}",System.currentTimeMillis()-start,url);

            if(vo!=null && vo.getResults()!=null){
                Iterator<NewsVO.Result> it = vo.getResults().iterator();
                while (it.hasNext()) {
                    NewsVO.Result r = it.next();
                    if( "qyxg_financial_times".equals(r.getBbd_type()) &&
                        !"??????".equals(r.getPlate())){

                        it.remove();

                    }else if("qyxg_sinafinance".equals(r.getBbd_type()) &&
                            !"????????????".equals(r.getPlate())&&
                            !"????????????".equals(r.getPlate())&&
                            !"????????????".equals(r.getPlate())){

                        it.remove();
                    }
                }
                if(vo.getResults().size()>size){
                    vo.setResults(vo.getResults().subList(0,size));
                }
            }




            return vo;
        } catch (Exception e) {
            logger.error("Method getCompanyNews get Exception." + e.getMessage());
            return null;
        }
    }





    /**
     * @param url     ??????
     * @param company ????????????
     * @return
     * @author David
     */
    public String dataAddressCombination(String url, String company) {
        String query = "";
        query = url + "?" + "company=" + company + "&ak=" + ak;
        return query;
    }

    @Override
    public String getCompanyNews(String company) {
        String result = null;

        try {
            if (!StringUtils.isEmpty(company)) {
                HttpTemplate ht = new HttpTemplate();
                result = ht.get(apiDataonNewsUrl +"&company="+ company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null || result.contains("\"total\": 0")) {
            return getCompanyNews();
        }

        return result;
    }


    @Override
    public String findCompanyNews(String company) {
        String result = null;

        try {
            if (!StringUtils.isEmpty(company)) {
                HttpTemplate ht = new HttpTemplate();
                result = ht.get(apiDataonNewsUrl +"&company=" + company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public String getCompanyNews() {
        try {
            return new HttpTemplate().get(apiDataomYuqingUrl);
        } catch (Exception e) {
            logger.error("Method getCompanyNews get Exception." + e.getMessage());
            return null;
        }
    }



    public NewsVO findNews(String key,Integer size){

        String url = String.format(apiDataomUrl,key,size);
        logger.info("?????????????????????"+url);
        try {
            String result = new HttpTemplate().get(url);

            Gson gson = new Gson();
            NewsVO vo = gson.fromJson(result,new TypeToken<NewsVO>(){}.getType());
            return vo;
        } catch (Exception e) {
            logger.error("Method getCompanyNews get Exception." + e.getMessage());
            return null;
        }
    }







    /**
     * ???????????????????????????????????????7??????+??????????????????6??????+??????????????????7??????
     * qyxg_shanghai_finance_office???qyxg_weiyangwang???qyxg_chinesefinancialnews ???
     * @return NewsVO
     */
    public NewsVO findNews(){
        NewsVO list = new NewsVO();
        list.addNewsVO(findNews("qyxg_shanghai_finance_office",7));
        list.addNewsVO(findNews("qyxg_weiyangwang",6));
        list.addNewsVO(findNews("qyxg_chinesefinancialnews",20-list.getRsize()));
        return list;
    }

}
