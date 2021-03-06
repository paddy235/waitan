package com.bbd.wtyh.dao.impl;

import static com.bbd.wtyh.common.Constants.REDIS_KEY_BASE_INFO_BBD_DATA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.domain.wangDaiAPI.*;
import com.bbd.wtyh.mapper.PlatRankDataMapper;
import com.bbd.wtyh.mapper.PlatformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.util.CollectionUtils;

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

    @Value("${api.court.openCourtAnnouncement.url}")
    private String ktggURL;

    @Value("${api.court.openCourtAnnouncement.ak}")
    private String ktggAppKey;


    @Override
    public YuQingDTO platformConsensus(String platName) {
        String yuqingURL = url + "?dataType=yuqing" + "&plat_name=" + platName;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(yuqingURL, new HttpCallback<YuQingDTO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public YuQingDTO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, YuQingDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> lawsuitMsg(String company) {
        String URL = ktggURL + "?appkey=" + ktggAppKey + "&company=" + company;
        HttpTemplate httpTemplate = new HttpTemplate();
        final Map<String, Object> data = new HashMap<>();
        try {
            httpTemplate.get(URL, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public Object parse(String result) {
                    if (null == result || result.length() == 0) {
                        return null;
                    }
                    JSONObject jsonObject = JSON.parseObject(result);
                    data.put("total",
                            "".equals(jsonObject.get("total")) ? 0 : jsonObject.get("total"));
                    return data;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
                    if (null == result || result.length() == 0) {
                        return null;
                    }
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
            return null;
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
        serie.add(source.get("运营能力"));
        serie.add(source.get("违约成本"));
        serie.add(source.get("分散度"));
        serie.add(source.get("资本充足"));
        serie.add(source.get("流动性"));
        serie.add(source.get("信息披露"));
        series.add(serie);
        result.put("indicator", indicator);
        result.put("series", series);
        result.put("code", "1");
        return result;
    }


    @Autowired
    private PlatformMapper platformMapper;

    /**
     * 基本信息--网贷接口数据
     */
    @Override
    public List<PlatListDO> baseInfoWangDaiApi() {
        List<PlatListDO> platList =platformMapper.getPlatListFromDb();
        if ( ! CollectionUtils.isEmpty(platList) ) {
            return platList;
        }
        return baseInfoWangDaiApiFromNet();
    }

    @Override
    public List<PlatListDO> baseInfoWangDaiApiFromNet() {
        String platFormName = url + "?dataType=plat_list";
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(platFormName, new HttpCallback<List<PlatListDO>>() {
                @Override
                public boolean valid() {

                    return true;
                }

                @Override
                public List<PlatListDO> parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, new TypeToken<List<PlatListDO>>() {
                    }.getType());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 基本信息--BBD数据平台接口
     */
    @Override
    public BaseDataDO baseInfoBBDData(String companyName, String bbdQyxxId) {
        final String redisKey = REDIS_KEY_BASE_INFO_BBD_DATA + "_" + (StringUtils.isNullOrEmpty(bbdQyxxId) ? companyName : bbdQyxxId);
        BaseDataDO baseDataDO = (BaseDataDO) redisDAO.getObject(redisKey);
        if (baseDataDO != null) {
            return baseDataDO;
        } else {
            String baseURL = bbdQyxxURL;
            if (StringUtils.isNullOrEmpty(bbdQyxxId))
                baseURL += "?internal=true&company=" + companyName + "&appkey=" + bbdQyxxAK;
            else
                baseURL += "?internal=true&qyxx_id=" + bbdQyxxId + "&appkey=" + bbdQyxxAK;
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
                        redisDAO.addObject(redisKey, gson.fromJson(result, BaseDataDO.class),
                                Constants.cacheDay, BaseDataDO.class);
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
     */
    @Override
    public ZuZhiJiGoudmDO baseInfoZuZhiJiGou(String companyName) {
        String URL = zuZhiJiGouURL + "?company=" + companyName + "&appkey=" + zuZhiJiGouAK;
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
     */
    @Override
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
    public List<PlatformNameInformationDO> associatedPlatName(String platName) {
        return platformNameInformationMapper.associatedPlatName(platName);
    }

    @Override
    public List<PlatformNameInformationDO> associatedCompanyName(String platName,
                                                                 Integer limit_size) {
        return platformNameInformationMapper.associatedCompanyName(platName, limit_size);
    }

    @Override
    public RadarScoreDTO getRadarScore(String platName) throws Exception {
        String radarUrl = url + "?dataType=leida" + "&plat_name=" + platName;
        HttpTemplate httpTemplate = new HttpTemplate();
        return httpTemplate.get(radarUrl, new HttpCallback<RadarScoreDTO>() {
            @Override
            public boolean valid() {
                return true;
            }

            @Override
            public RadarScoreDTO parse(String result) {
                Gson gson = new Gson();
                return gson.fromJson(result, RadarScoreDTO.class);
            }
        });
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
                    if (null == result || result.length() == 0) {
                        return null;
                    }
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
            return null;
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
                    if (null == result || result.length() == 0) {
                        return null;
                    }
                    Gson gson = new Gson();
                    return gson.fromJson(result, PlatDataDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public PlatCoreDataDTO getPlatCoreData(String platName) throws Exception {
        String platDataURL = url + "?dataType=plat_data" + "&plat_name=" + platName;
        HttpTemplate httpTemplate = new HttpTemplate();
        return httpTemplate.get(platDataURL, new HttpCallback<PlatCoreDataDTO>() {
            @Override
            public boolean valid() {
                return true;
            }

            @Override
            public PlatCoreDataDTO parse(String result) {
                if (null == result || result.length() == 0) {
                    return null;
                }
                Gson gson = new Gson();
                return gson.fromJson(result, PlatCoreDataDTO.class);
            }
        });
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
