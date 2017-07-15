package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.service.impl.relation.RegisterUniversalFilterChainImp;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author Ian.Su
 * @since 2016年8月12日 下午2:09:15
 */
@Service
public class PToPMonitorServiceImpl implements PToPMonitorService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Value("${financial.services.url}")
    private String finSerUrl;

    @Value("${related.party.dataVersion}")
    private String dataVersion;

    @Autowired
    private OfflineFinanceService offlinefinanceservice;

    @Autowired
    private PlatformNameInformationMapper platformNameInformationMapper;

    @Autowired
    private RedisDAO redisDAO;

    @Autowired
    private RegisterUniversalFilterChainImp relatedCompanyService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private IndustryShanghaiMapper industryShanghaiMapper;

    @Autowired
    private IndustryShanghaiAreaMapper industryShanghaiAreaMapper;

    @Autowired
    private IndustryCompareMapper industryCompareMapper;

    @Autowired
    private PlatRankDataMapper platRankDataMapper;

    private Logger logger = LoggerFactory.getLogger(PToPMonitorServiceImpl.class);

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
        if (StringUtils.isEmpty(this.finSerUrl)) {
            url = "121.40.187.134:5002/financial_services?dataType=industry_shanghai";
        }
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
        if (StringUtils.isEmpty(this.finSerUrl)) {
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

    public List<PlatCompanyDTO> searchPlatListByCompanyName(String companyName) { //by cgj
        List platList = new ArrayList<PlatCompanyDTO>();
        if (StringUtils.isBlank(companyName)) {
            return platList;
        }
        try {
            PToPMonitorService ptps = new PToPMonitorServiceImpl();
            List<PlatCompanyDTO> lpc = ptps.getPlatList();
            for (PlatCompanyDTO pd : lpc) {
                String tarCompName = pd.getCompany_name();
                if (StringUtils.isNotBlank(tarCompName) && companyName.equals(tarCompName)) {
                    platList.add(pd);
                }
            }
        } catch (Exception e) {
        }
        return platList;
    }

    @Override
    public void industryShanghaiDataLandingTask() throws Exception {
        logger.info("start update industry_shanghai date task");
        List<IndustryShanghaiDTO> dtoList = getData();
        for (IndustryShanghaiDTO dto : dtoList) {
            IndustryShanghaiDO industryShanghaiDO = new IndustryShanghaiDO();
            industryShanghaiDO.setNewPlatNum(dto.getNew_plat_num());
            industryShanghaiDO.setInterestRate(dto.getInterest_rate());
            industryShanghaiDO.setTotalPlatNum(dto.getTotal_plat_num());
            industryShanghaiDO.setBorrowedNum(dto.getBorrowed_num());
            industryShanghaiDO.setInterestRate(dto.getInterest_rate());
            industryShanghaiDO.setAmount(dto.getAmount());
            industryShanghaiDO.setDate(dto.getDate());
            industryShanghaiDO.setCreateBy("sys");
            industryShanghaiDO.setCreateDate(new Date());
            industryShanghaiMapper.deleteByDate(dto.getDate());
            industryShanghaiMapper.save(industryShanghaiDO);
            industryShanghaiAreaMapper.deleteByDate(dto.getDate());
            for (String areaName : dto.getArea_num().keySet()) {
                IndustryShanghaiAreaDO areaDO = new IndustryShanghaiAreaDO();
                areaDO.setDate(dto.getDate());
                areaDO.setAreaName(areaName);
                areaDO.setAreaNum((Double) dto.getArea_num().get(areaName));
                areaDO.setCreateBy("sys");
                areaDO.setCreateDate(new Date());
                industryShanghaiAreaMapper.save(areaDO);
            }
        }
        logger.info("end update industry_shanghai date task");

    }

    @Override
    public void industryCompareDataLandingTask() throws Exception {
        logger.info("start update industry_compare date task");
        List<IndustryCompareDTO> dtoList = getCompareData();
        for (IndustryCompareDTO dto : dtoList) {
            IndustryCompareDO industryCompareDO = new IndustryCompareDO();
            industryCompareDO.setDate(dto.getDate());
            industryCompareDO.setArea(dto.getArea());
            industryCompareDO.setAmount(dto.getAmount());
            industryCompareDO.setBalanceLoans(dto.getBalance_loans());
            industryCompareDO.setCreateBy("sys");
            industryCompareDO.setCreateDate(new Date());
            industryCompareMapper.deleteByArea(dto.getDate());
            industryCompareMapper.save(industryCompareDO);
        }
        logger.info("end update industry_compare date task");
    }

    @Override
    public void platRankDataLandingTask() throws Exception {
        List<PlatRankDataDTO> dtoList = getPlatRankData();
        for (PlatRankDataDTO dto : dtoList) {
            PlatRankDataDO platRankDataDO = new PlatRankDataDO();
            platRankDataDO.setAmount(dto.getAmount());
            platRankDataDO.setAreaId(dto.getArea_id());
            platRankDataDO.setIncomeRate(dto.getIncome_rate());
            platRankDataDO.setLoanPeriod(dto.getLoan_period());
            platRankDataDO.setPlatName(dto.getPlat_name());
            platRankDataDO.setPlatStatus(dto.getPlat_status());
            platRankDataDO.setRank(dto.getRank());
            platRankDataDO.setRegisteredAddress(dto.getRegistered_address());
            platRankDataDO.setStayStillOfTotal(dto.getStay_still_of_total());
            platRankDataDO.setCreateBy("sys");
            platRankDataDO.setCreateDate(new Date());
            platRankDataMapper.deleteByPlatName(dto.getPlat_name());
            platRankDataMapper.save(platRankDataDO);
        }
        logger.info("start update plat_rank_data date task");
    }

    public static void main(String[] agrs) throws Exception {

        try {
            PToPMonitorService ptps = new PToPMonitorServiceImpl();
            List<PlatCompanyDTO> lpc = ptps.getPlatList();
            int num = lpc.size();
            num = num;
        } catch (Exception e) {
        }

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
