package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.dto.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.service.impl.relation.RegisterUniversalFilterChainImp;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Ian.Su
 * @since 2016年8月12日 下午2:09:15
 */
@Service
public class PToPMonitorServiceImpl implements PToPMonitorService {

    Logger                                  log = LoggerFactory.getLogger(getClass());

    @Value("${financial.services.url}")
    private String                          finSerUrl;

    @Value("${related.party.dataVersion}")
    private String                          dataVersion;

    @Autowired
    private OfflineFinanceService           offlinefinanceservice;

    @Autowired
    private PlatformNameInformationMapper   platformNameInformationMapper;

    @Autowired
    private RedisDAO                        redisDAO;

    @Autowired
    private RegisterUniversalFilterChainImp relatedCompanyService;

    @Autowired
    private CompanyService                  companyService;

    @Override
    public Integer getOfflineFinanceNum(String companyName) throws Exception {
        if (companyName.equals("上海陆家嘴国际金融资产交易市场股份有限公司")) {
            return 0;
        }
        //Map<String, List> relationMap = relatedCompanyService.queryRelation(companyName, dataVersion, 1);
        RelationDiagramVO relationDiagramVO = offlinefinanceservice.queryRealRealation(companyName,
            1);
        List<RelationDiagramVO.PointVO> pointList = relationDiagramVO.getPointList();
        if (org.apache.commons.collections.CollectionUtils.isEmpty(pointList)) {
            return 0;
        }

        int offlineFinance = 0;
        for (RelationDiagramVO.PointVO pointVO : pointList) {
            if (pointVO.getIsPerson().equals("1")) {
                continue;
            }
            CompanyDO relatedCompany = companyService.getCompanyByName(pointVO.getCname());
            if (null == relatedCompany || null == relatedCompany.getCompanyType()) {
                continue;
            }
            if (relatedCompany.getCompanyType() == CompanyDO.TYPE_XXLC_4) {
                offlineFinance++;
            }
        }
        if (offlineFinance <= 0) {
            return 0;
        }
        return offlineFinance;
    }

    @Override
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

    @Override
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

    @Override
    public List<PlatRankDataDTO> getPlatRankData() throws Exception {

        String url = this.finSerUrl + "?dataType=plat_rank_data";
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(url, new HttpCallback<List<PlatRankDataDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<PlatRankDataDTO> parse(String result) {
                    //System.out.println(result);
                    return JSON.parseArray(result, PlatRankDataDTO.class);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
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
                PlatformNameInformationDO platformNameInformationDO = platformNameInformationMapper
                    .hasOrNotCompany(plat_name);
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

    @Override
    public List<IndustryShanghaiDTO> getData() throws Exception {

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

                    List<IndustryShanghaiDTO> list = gson.fromJson(result,
                        new TypeToken<List<IndustryShanghaiDTO>>() {
                    }.getType());
                    IndustryShanghaiDTO ja = null;
                    IndustryShanghaiDTO zb = null;
                    return list;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
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

    @Override
    public List<PlatCompanyDTO> getPlatList() throws Exception { //by cgj
        String url = this.finSerUrl + "?dataType=plat_list";
        if( StringUtils.isEmpty(this.finSerUrl)) {
            url = "http://121.40.187.134:5002/financial_services" + "?dataType=plat_list";
        }
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(url, new HttpCallback<List<PlatCompanyDTO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<PlatCompanyDTO> parse(String result) {
                    return JSON.parseArray(result, PlatCompanyDTO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PlatCompanyDTO> searchPlatListByCompanyName( String companyName ) { //by cgj
        List platList =new ArrayList<PlatCompanyDTO>();
        if ( StringUtils.isBlank(companyName) ) {
            return platList;
        }
        try {
            PToPMonitorService ptps = new PToPMonitorServiceImpl();
            List<PlatCompanyDTO> lpc = ptps.getPlatList();
            for ( PlatCompanyDTO pd : lpc ) {
                String tarCompName =pd.getCompany_name();
                if( StringUtils.isNotBlank(tarCompName) &&companyName.equals(tarCompName) ) {
                    platList.add(pd);
                }
            }
        } catch (Exception e ) {}
        return platList;
    }

    public static void main(String[] agrs) throws Exception {

        try {
            PToPMonitorService ptps = new PToPMonitorServiceImpl();
            List<PlatCompanyDTO> lpc = ptps.getPlatList();
            int num =lpc.size();
            num =num;
        } catch (Exception e) {}

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
        //        String url = "http://140.206.51.154:5002/financial_services?dataType=area_index";
        //
        //        HttpTemplate httpTemplate = new HttpTemplate();
        //        try {
        //            httpTemplate.get(url, new HttpCallback<List<AreaIndexDTO>>() {
        //                @Override
        //                public boolean valid() {
        //                    return true;
        //                }
        //
        //                @Override
        //                public List<AreaIndexDTO> parse(String result) {
        //                    return JSON.parseArray(result, AreaIndexDTO.class);
        //                }
        //            });
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }

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
