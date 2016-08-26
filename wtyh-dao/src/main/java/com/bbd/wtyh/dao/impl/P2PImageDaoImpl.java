package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompanyDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * p2p检测平台dao层实现类
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Repository("p2PImageDao")
public class P2PImageDaoImpl implements P2PImageDao {

    @Value("${api.finnacial.url}")
    private String url;

    @Value("${api.bbd_qyxx.url}")
    private String bbdQyxxURL;

    @Value("${api.bbd_qyxx.ak}")
    private String bbdQyxxAK;

    @Value("${api.bbdZuzhiJiGoudm.url}")
    private String zuZhiJiGouURL;

    @Value("${api.bbdZuzhiJiGoudm.ak}")
    private String zuZhiJiGouAK;

    @Autowired
    private PlatformNameInformationMapper platformNameInformationMapper;

    @Autowired
    private RedisDAO redisDAO;

    @Override
    public YuQingDO platformConsensus(String platName) {
        String yuqingURL = url + "?dataType=yuqing" + "&plat_name=" + platName;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(yuqingURL, new HttpCallback<YuQingDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public YuQingDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, YuQingDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> lawsuitMsg(String company) {
        String URL = String.format("http://dataom.api.bbdservice.com/api/bbd_ktgg/?company=%s&ak=ee372b938ef17a245f6b781beec4499e", company);
        HttpTemplate httpTemplate = new HttpTemplate();
        final Map<String, Object> data = new HashMap<>();
        try {
            httpTemplate.get(URL, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public Object parse(String s) {
                    JSONObject jsonObject = JSON.parseObject(s);
                    data.put("total", jsonObject.get("total")==""?0:jsonObject.get("total"));
                    return data;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<String, Object> radarScore(String platName) {
        String _url = String.format(url + "?dataType=leida&plat_name=%s", platName);
        HttpTemplate httpTemplate = new HttpTemplate();
        final Map<String, Object> source = new LinkedHashMap<>();
        try {
            httpTemplate.get(_url, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return false;
                }

                @Override
                public Object parse(String result) {
                    JSONObject object = JSON.parseObject(result);
                    source.put("运营能力", object.get("operation"));
                    source.put("违约成本", object.get("penalty_cost"));
                    source.put("分散度", object.get("dispersion"));
                    source.put("资本充足", object.get("capital"));
                    source.put("流动性", object.get("fluidity"));
                    source.put("信息披露", object.get("info_disclosure"));
                    return source;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        //数据格式化
        Map<String, Object> result = new LinkedHashMap<>();
        List<LinkedHashMap<String, Object>> indicator = new ArrayList<>();
        Set<Map.Entry<String, Object>> entries = source.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            LinkedHashMap<String, Object> score = new LinkedHashMap<>();
            score.put("name", entry.getKey());
            score.put("max", entry.getValue());
            indicator.add(score);
        }
        List<List<Object>> series = new ArrayList<>();
        List<Object> serie = new ArrayList<>();
        serie.add(source.get("违约成本"));
        serie.add(source.get("信息披露"));
        serie.add(source.get("资本充足"));
        serie.add(source.get("运营能力"));
        serie.add(source.get("流动性"));
        serie.add(source.get("分散度"));
        series.add(serie);
        result.put("indicator", indicator);
        result.put("series", series);
        result.put("code", "1");
        return result;
    }

    /**
     * 基本信息--网贷接口数据
     *
     */
    public  List<PlatListDO> baseInfoWangDaiApi(String platName){
        String platFormName = url + "?dataType=plat_list&plat_name="+platName;
        final Map<String, Object> data = new HashMap<>();
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(platFormName, new HttpCallback<List<PlatListDO>>() {
                @Override
                public boolean valid() {

                    return true;
                }
                @Override
                public  List<PlatListDO> parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, new TypeToken<List<PlatListDO>>(){}.getType());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 基本信息--BBD数据平台接口
     *
     */
    @Override
    public BaseDataDO baseInfoBBDData(String companyName) {
        BaseDataDO baseDataDO = (BaseDataDO) redisDAO.getObject(Constants.REDIS_KEY_BASE_INFO_BBD_DATA);
        if (baseDataDO != null) {
            return baseDataDO;
        } else {
            String baseURL = bbdQyxxURL + "?company=" + companyName + "&ak=" + bbdQyxxAK;
            HttpTemplate httpTemplate = new HttpTemplate();
            try {
                return httpTemplate.get(baseURL, new HttpCallback<BaseDataDO>() {
                    @Override
                    public boolean valid() {
                        return true;
                    }
                    @Override
                    public BaseDataDO parse(String result) {
                        Gson gson = new Gson();
                        redisDAO.addObject(Constants.REDIS_KEY_BASE_INFO_BBD_DATA, gson.fromJson(result, BaseDataDO.class), Constants.cacheDay, BaseDataDO.class);
                        return gson.fromJson(result, BaseDataDO.class);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    /**
     * 基本信息--组织机构代码api
     *
     */
    public ZuZhiJiGoudmDO baseInfoZuZhiJiGou(String companyName) {
//        String url = zuZhiJiGouURL+"?company="+companyName+"&ak="+zuZhiJiGouURL;
        String URL = "http://dataom.api.bbdservice.com/api/bbd_zuzhijigoudm/?company="+companyName+"&ak=605f60df40668579e939515fef710d2b";
        final Map<String, Object> map = new LinkedHashMap<>();
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(URL, new HttpCallback<ZuZhiJiGoudmDO>() {
                @Override
                public boolean valid() {
                    return true;
                }
                @Override
                public ZuZhiJiGoudmDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, ZuZhiJiGoudmDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 企业logo信息
     *
     */
    public PlatListDO wangDaiLogo(String platName) {
        String coreDataDealURL = url + "?dataType=plat_list" + "&plat_name=" + platName;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(coreDataDealURL, new HttpCallback<PlatListDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public PlatListDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, PlatListDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> coreDataInfo(String platName) {
        String _url = String.format(url + "?dataType=plat_data&plat_name=%s", platName);
        final Map<String, Object> data = new LinkedHashMap<>();
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            httpTemplate.get(_url, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public Object parse(String result) {
                    JSONObject jsonObject = JSON.parseObject(result);
                    data.put("amount_total", jsonObject.get("amount_total"));
                    data.put("money_stock", jsonObject.get("money_stock"));
                    data.put("interest_rate", jsonObject.get("interest_rate"));
                    data.put("month_net_inflow", jsonObject.get("30_day_net_inflow"));
                    data.put("bid_num_stay_stil", jsonObject.get("bid_num_stay_stil"));
                    data.put("bor_num_stay_stil", jsonObject.get("bor_num_stay_stil"));
                    data.put("top1_sum_amount", jsonObject.get("top1_sum_amount"));
                    data.put("top10_sum_amount", jsonObject.get("top10_sum_amount"));
                    return data;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public PlatDataDO getPlatData(String platName) {
        String platDataURL = url + "?dataType=plat_data" + "&plat_name=" + platName;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(platDataURL, new HttpCallback<PlatDataDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public PlatDataDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, new TypeToken<PlatDataDO>(){}.getType());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PlatformNameInformationDO hasOrNotCompany(String platName) {
        return platformNameInformationMapper.hasOrNotCompany(platName);

    }

    public SearchCompanyDO hasOrNotCompanyBackup(String plat_name) {

        String api = url + "?dataType=plat_list" + "&plat_name=" + plat_name;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<SearchCompanyDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public SearchCompanyDO parse(String result) {
                    return JSON.parseObject(result, SearchCompanyDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
