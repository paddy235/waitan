package com.bbd.bgo.service.task;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.dataLoading.QyxgYuqingDO;
import com.bbd.wtyh.domain.vo.NewsVO;
import com.bbd.wtyh.mapper.DataLoadingMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
@Service
public class RealTimeMonitorNewsServiceImpl implements  RealTimeMonitorNewsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${api.yuqing.url}")
    private String apiYuqingUrl;

    @Autowired
    private DataLoadingMapper dataLoadingMapper;

    @Override
    public void saveRealTimeMonitorNews() throws Exception {
        int size=20;
        int len=size+30;
        String types = "qyxg_weiyangwang,qyxg_shanghai_finance,qyxg_chinesefinance,qyxg_financial_times,qyxg_sinafinance,qyxg_national_economy";
        long start = System.currentTimeMillis();
        String url = String.format(apiYuqingUrl,types,len);
        NewsVO vo ;
        try {

            //数据库没有，从接口取舆情
            String result = new HttpTemplate().get(url);
            Gson gson = new Gson();
            vo = gson.fromJson(result,new TypeToken<NewsVO>(){}.getType());

            logger.info("舆情请求耗时：{}ms,url地址为：{}",System.currentTimeMillis()-start,url);

            if(vo!=null && vo.getResults()!=null){

                Iterator<NewsVO.Result> it = vo.getResults().iterator();

                while (it.hasNext()) {
                    NewsVO.Result r = it.next();
                    if( "qyxg_financial_times".equals(r.getBbd_type()) &&
                            !"金融".equals(r.getPlate())){

                        it.remove();

                    }else if("qyxg_sinafinance".equals(r.getBbd_type()) &&
                            !"金融新闻".equals(r.getPlate())&&
                            !"宏观经济".equals(r.getPlate())&&
                            !"国内财经".equals(r.getPlate())){

                        it.remove();
                    }
                }
                if(vo.getResults().size()>size){
                    vo.setResults(vo.getResults().subList(0,size));
                }

                //入库
                Date today=new Date();//因接口返回的数据没有bbd_xgxx_id，每天可能有重复的舆情数据，需要用日期时间作为版本号
                List<QyxgYuqingDO> list=new ArrayList<>();
                QyxgYuqingDO yuqingDO;
                BeanCopier beanCopier = BeanCopier.create(NewsVO.Result.class, QyxgYuqingDO.class , false);
                for(NewsVO.Result r:vo.getResults()){
                    yuqingDO=new QyxgYuqingDO();
                    beanCopier.copy(r,yuqingDO,null);
                    yuqingDO.setArticleAbstract(r.getaBstract());
                    yuqingDO.setPubdate(DateUtils.parseDate(r.getPubdate(),"yyyy-MM-dd HH:mm:ss"));
                    yuqingDO.setCreate_time(today);
                    list.add(yuqingDO);
                    //dataLoadingMapper.saveOneQyxgYuqingDO(yuqingDO);
                }
                dataLoadingMapper.saveQyxgYuqingDO(list);
            }


        } catch (Exception e) {
            logger.error("Method saveRealTimeMonitorNews get Exception." + e.getMessage());

        }
    }


}
