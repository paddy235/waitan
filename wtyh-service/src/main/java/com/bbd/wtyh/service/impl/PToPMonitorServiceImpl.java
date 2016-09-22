package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.PToPMonitorService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ian.Su
 * @since 2016年8月12日 下午2:09:15
 */
@Service
public class PToPMonitorServiceImpl implements PToPMonitorService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Value("${financial.services.url}")
    private String finSerUrl;

    @Autowired
    private PlatformNameInformationMapper platformNameInformationMapper;

    @Autowired
    private RedisDAO redisDAO;

    public List<IndustryCompareDTO> getCompareData() throws Exception {


        String url = this.finSerUrl + "?dataType=industry_compare";
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(url, new HttpCallback<List<IndustryCompareDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<IndustryCompareDTO> parse(String result) {
                    return JSON.parseArray(result, IndustryCompareDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<AreaIndexDTO> getAreaIndex() throws Exception {


        String url = this.finSerUrl + "?dataType=area_index";
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(url, new HttpCallback<List<AreaIndexDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<AreaIndexDTO> parse(String result) {
                    return JSON.parseArray(result, AreaIndexDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


    public List<PlatRankDataDTO> getPlatRankData(String platStatus) throws Exception {


        String url = this.finSerUrl + "?dataType=plat_rank_data";
        HttpTemplate httpTemplate = new HttpTemplate();
        List<PlatRankDataDTO> wangdaizhijiaRst = null;
        try {
            wangdaizhijiaRst = httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<PlatRankDataDTO> parse(String result) {
                    System.out.println(result);
                    return JSON.parseArray(result, PlatRankDataDTO.class);
                }
            });

            if (null != platStatus) {
                List<PlatRankDataDTO> rst = new ArrayList<>();
                for (PlatRankDataDTO platRankDataDTO : wangdaizhijiaRst) {
                    if (platRankDataDTO.getPlat_status().equals(platStatus)) {
                        rst.add(platRankDataDTO);
                    }
                }
                return rst;
            } else {
                return wangdaizhijiaRst;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public Map getPlatRankMapData() throws Exception {

        List<PlatRankDataDTO> list = new ArrayList<>();
        String url = this.finSerUrl + "?dataType=plat_rank_data";
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            list = httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<PlatRankDataDTO> parse(String result) {
                    return JSON.parseArray(result, PlatRankDataDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<Integer, Integer> map = new HashMap();
        if (!CollectionUtils.isEmpty(list)) {
            for (PlatRankDataDTO platRankDataDTO : list) {
                String plat_name = platRankDataDTO.getPlat_name();
                String plat_status = platRankDataDTO.getPlat_status();
                PlatformNameInformationDO platformNameInformationDO = platformNameInformationMapper.hasOrNotCompany(plat_name);
                if (platformNameInformationDO != null) {
                    Integer riskLevel = 4;
                    if ("正常".equals(plat_status)) {
                        riskLevel = 4;
                    } else if ("一般关注".equals(plat_status)) {
                        riskLevel = 3;
                    } else if ("重点关注".equals(plat_status)) {
                        riskLevel = 2;
                    } else if ("问题".equals(plat_status)) {
                        riskLevel = 1;
                    } else {

                    }
                    map.put(platformNameInformationDO.getCompanyId(), riskLevel);
                }
            }
        }
        return map;
    }


    public List<IndustryShanghaiDTO> getData() throws Exception {
        Gson gson = new Gson();
        String json_industry_shanghai = redisDAO.getString(Constants.REDIS_KEY_BUSINESS_CHART_SHOW_INDUSTRY_SHANGHAI);
        if (StringUtils.isEmpty(json_industry_shanghai)) {
            String url = this.finSerUrl + "?dataType=industry_shanghai";
            HttpTemplate httpTemplate = new HttpTemplate();
            try {
                return httpTemplate.get(url, new HttpCallback<List<IndustryShanghaiDTO>>() {
                    @Override
                    public boolean valid() {
                        return true;
                    }

                    @Override
                    public List<IndustryShanghaiDTO> parse(String result) {

                        Gson gson = new Gson();

                        List<IndustryShanghaiDTO> list = gson.fromJson(result, new TypeToken<List<IndustryShanghaiDTO>>() {
                        }.getType());
                        IndustryShanghaiDTO ja = null;
                        IndustryShanghaiDTO zb = null;
                        System.out.print("------"+Constants.cacheDay);
                        if (!CollectionUtils.isEmpty(list)) {
                            redisDAO.addObject(Constants.REDIS_KEY_BUSINESS_CHART_SHOW_INDUSTRY_SHANGHAI, list, Constants.cacheDay, List.class);
                        }
                        return list;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return gson.fromJson(json_industry_shanghai, List.class);
        }
    }


    public List<IndustryProblemDTO> getProblemData() throws Exception {


        String url = this.finSerUrl + "?dataType=industry_problem";
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(url, new HttpCallback<List<IndustryProblemDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<IndustryProblemDTO> parse(String result) {
                    return JSON.parseArray(result, IndustryProblemDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public static void main(String[] agrs) throws Exception {

//		String url = "http://140.206.51.154:5002/financial_services?dataType=industry_problem";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<IndustryProblemDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<IndustryProblemDTO> parse(String result) {
//					return JSON.parseArray(result, IndustryProblemDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}


//		String url = "http://140.206.51.154:5002/financial_services?dataType=industry_shanghai";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<IndustryShanghaiDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<IndustryShanghaiDTO> parse(String result) {
//					return JSON.parseArray(result, IndustryShanghaiDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}

//
//		String url = "http://140.206.51.154:5002/financial_services?dataType=plat_rank_data";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<PlatRankDataDTO> parse(String result) {
//					return JSON.parseArray(result, PlatRankDataDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}


//		String url = "http://140.206.51.154:5002/financial_services?dataType=industry_compare";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<IndustryCompareDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<IndustryCompareDTO> parse(String result) {
//					return JSON.parseArray(result, IndustryCompareDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}


//报错
        String url = "http://140.206.51.154:5002/financial_services?dataType=area_index";

        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            httpTemplate.get(url, new HttpCallback<List<AreaIndexDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<AreaIndexDTO> parse(String result) {
                    return JSON.parseArray(result, AreaIndexDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


//		String url = "http://140.206.51.154:5002/financial_services?dataType=plat_rank_data";
//		HttpTemplate httpTemplate = new HttpTemplate();
//		try {
//			 httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
//				@Override
//				public boolean valid() {
//					return true;
//				}
//				@Override
//				public List<PlatRankDataDTO> parse(String result) {
//					return JSON.parseArray(result, PlatRankDataDTO.class);
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}


    }


}
