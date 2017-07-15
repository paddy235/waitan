package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.dto.PlatCompanyDTO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingWarningDO;
import com.bbd.wtyh.mapper.YuQingWarningMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.service.PToPMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * P2P平台状态信息业务层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Service("p2PImageService")
public class P2PImageServiceImpl implements P2PImageService {
    @Autowired
    private P2PImageDao p2PImageDao;

    @Autowired
    private PToPMonitorService pToPMonitorService;

    @Autowired
    private RedisDAO redisDAO;

    @Autowired
    private YuQingWarningMapper yuQingWarningMapper;


    private static final String PLAT_FORM_STATUS_CACHE_PRIFIX = "wtyh:P2PImage:platFormStatus";

    private Logger logger = LoggerFactory.getLogger(P2PImageServiceImpl.class);

    @Override
    public PlatDataDO getPlatData(String platName) {
        PlatDataDO pn = p2PImageDao.getPlatData(platName);
        return pn;
    }


    @Override
    public Map<String, Object> platFormStatus(String platName) {
        PlatDataDO pn = p2PImageDao.getPlatData(platName);  // 查询网贷API
        if (null == pn) {
            return null;
        }

        Map<String, Map<String, Object>> platSts = (Map<String, Map<String, Object>>) redisDAO.getObject(PLAT_FORM_STATUS_CACHE_PRIFIX);
        PlatRankDataDTO platRankDataDTO = null;
        if (null != platSts) {
            Map<String, Object> platSt = (Map) platSts.get(platName);
            if (null != platSt) {
                platRankDataDTO = new PlatRankDataDTO();
                platRankDataDTO.setPlat_status((null != platSt.get("plat_status")) ? (String) platSt.get("plat_status") : null);
            }
        }
        //缓存取不到，就取实时数据
        if (null == platRankDataDTO) {
            platRankDataDTO = findFromWangdaiPlatRankData(platName);
        }

        PlatListDO platListDO = findFromWangdaiPlatList(platName);  // 获取logo

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("logo", (null == platListDO) ? null : platListDO.getLogo_url());//logo
        result.put("score", platRankDataDTO.getPlatRank()); // 评级
        result.put("platname", pn.getPlat_name()); // 平台名称
        result.put("companyName", pn.getCompany_name()); // 公司名称
        result.put("status", platRankDataDTO.getPlat_status()); // 营业状态
        return result;
    }

    @Override
    public PlatRankDataDTO findFromWangdaiPlatRankData(String platName) {
        Map<String, PlatRankDataDTO> wangdaiPlatRankData = new HashMap<>();
        try {
            for (PlatRankDataDTO platRankDataDTO : pToPMonitorService.getPlatRankData()) {
                wangdaiPlatRankData.put(platRankDataDTO.getPlat_name(), platRankDataDTO);
            }
            return wangdaiPlatRankData.get(platName);
        } catch (Exception e) {
            e.printStackTrace();
            return new PlatRankDataDTO();
        }
    }

    @Override
    public PlatListDO findFromWangdaiPlatList(String platName) {
        return getWangdaiPlatList().get(platName);
    }

    @Override
    public Map<String, PlatListDO> getWangdaiPlatList() {
        Map<String, PlatListDO> wangdaiPlatList = new HashMap<>();
        for (PlatListDO platListDO : p2PImageDao.baseInfoWangDaiApi()) {
            platListDO.setCompany_name(platListDO.getCompany_name().trim());
            wangdaiPlatList.put(platListDO.getPlat_name(), platListDO);
        }
        return wangdaiPlatList;
    }

    @Override
    public YuQingDO platformConsensus(String platName) {
        return p2PImageDao.platformConsensus(platName);
    }

    @Override
    public Map<String, Object> lawsuitMsg(String platName) {
        PlatDataDO platDataDO = p2PImageDao.getPlatData(platName);
        if (null == platDataDO) {
            return null;
        }
//        System.out.println("13"+platDataDO.getCompany_name());
        Map<String, Object> result = p2PImageDao.lawsuitMsg(platDataDO.getCompany_name());
        if (null == result || result.size() == 0) {
            return null;
        }
        return result;
    }

    @Override
    public Map<String, Object> radarScore(String platName) {
        PlatDataDO platData = p2PImageDao.getPlatData(platName);
        if (null == platData) {
            return null;
        }
        Map<String, Object> data = p2PImageDao.radarScore(platName);
        if (null == data || data.size() == 0) {
            return null;
        }
        data.put("sumScore", platData.getPlat_score());
        return data;
    }

    @Override
    public String findCompanyNameFromDbThenAPI(String platName, Map<String, PlatListDO> wangdaiList) {
        PlatformNameInformationDO platformNameInformationDO = p2PImageDao.hasOrNotCompany(platName);
        PlatListDO platListDO = wangdaiList.get(platName);

        String companyName = "";
        if (null != platformNameInformationDO) {
            companyName = platformNameInformationDO.getName();
        } else if (null != platListDO) {
            companyName = platListDO.getCompany_name();
        } else {
            return null;
        }
        return companyName;
    }

    @Override
    public Map<String, Object> baseInfo(String platName) {
        Map<String, PlatListDO> wangdaiList = getWangdaiPlatList();
        String companyName = findCompanyNameFromDbThenAPI(platName, wangdaiList);
        BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(companyName);
        if (null == baseDataDO) {
            return null;
        }
        ZuZhiJiGoudmDO zuZhiJiGoudmDO = p2PImageDao.baseInfoZuZhiJiGou(companyName);
        if (null == zuZhiJiGoudmDO) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        for (BaseDataDO.Results result : baseDataDO.getResults()) {
            map.put("legalPeople", result.getJbxx().getFrname());
            map.put("capital", result.getJbxx().getRegcap());
            map.put("address", result.getJbxx().getAddress());
            map.put("openedTime", result.getJbxx().getEsdate());
            map.put("verifiedTime", result.getJbxx().getApproval_date());
            map.put("registerOffice", result.getJbxx().getRegorg());
        }
        for (ZuZhiJiGoudmDO.Result result : zuZhiJiGoudmDO.getResults()) {
            map.put("companyCode", result.getJgdm());
        }
        map.put("platName", platName);
        map.put("companyName", companyName);
        return map;
    }

    @Override
    public Map<String, Object> coreDataInfo(String platName) {
        Map<String, Object> data = p2PImageDao.coreDataInfo(platName);
        if (null == data || data.size() == 0) {
            return null;
        }
        return data;
    }

    @Override
    public List<List<String>> coreDataDealTrend(String platName) {
        PlatDataDO data = p2PImageDao.getPlatData(platName);
        if (null == data) {
            return null;
        }
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> amounts = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            BigDecimal dayAmount = new BigDecimal(String.valueOf(pdsm.getDay_amount()));
            amounts.add(dayAmount.toPlainString());
        }
        List<List<String>> result = new ArrayList<>();
        List<String> days1 = new ArrayList<>();
        List<String> amounts1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            days1.add(days.get(i));
            amounts1.add(amounts.get(i));
        }
        Collections.reverse(days1);
        Collections.reverse(amounts1);
        result.add(days1);
        result.add(amounts1);
        return result;
    }

    @Override
    public List<List<String>> coreDataInterestRateTrend(String plat_name) {
        // 处理数据转换
        PlatDataDO data = p2PImageDao.getPlatData(plat_name);
        if (null == data) {
            return null;
        }
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> interestRates = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            interestRates.add(String.valueOf(pdsm.getDay_interest_rate()));
        }
        List<String> days1 = new ArrayList<>();
        List<String> interestRates1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            days1.add(days.get(i));
            interestRates1.add(interestRates.get(i));
        }
        Collections.reverse(days1);
        Collections.reverse(interestRates1);
        List<List<String>> result = new ArrayList<>();
        result.add(days1);
        result.add(interestRates1);
        return result;
    }

    @Override
    public List<List<String>> coreDataLoadOverage(String plat_name) {
        // 处理数据转换
        PlatDataDO data = p2PImageDao.getPlatData(plat_name);
        if (null == data) {
            return null;
        }
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> loanOverages = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            BigDecimal dayAmount = new BigDecimal(String.valueOf(pdsm.getDay_money_stock()));
            loanOverages.add(dayAmount.toPlainString());
        }
        List<String> days1 = new ArrayList<>();
        List<String> loanOverages1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            days1.add(days.get(i));
            loanOverages1.add(loanOverages.get(i));
        }
        Collections.reverse(days1);
        Collections.reverse(loanOverages1);
        List<List<String>> result = new ArrayList<>();
        result.add(days1);
        result.add(loanOverages1);
        return result;
    }

    @Override
    public PlatformNameInformationDO hasOrNotCompany(String platName) {
        return p2PImageDao.hasOrNotCompany(platName);
    }

    @Override
    public List<PlatformNameInformationDO> associatedCompanys(String platName) {
        List<PlatformNameInformationDO> rst = new ArrayList<>();
        List<PlatformNameInformationDO> platNames = p2PImageDao.associatedPlatName(platName);
        rst.addAll(platNames);
        // 拼接 5 个元素的列表
        if (5 > platNames.size()) {
            List<PlatformNameInformationDO> companyNames = p2PImageDao.associatedCompanyName(platName, 5 - platNames.size());
            rst.addAll(companyNames);
        }
        return rst;
    }

    @Override
    public void updateWangDaiYuQingTask() {
        logger.info("start get wangdai yuqing data");

        List<PlatCompanyDTO> platList = null;
        try {
            platList = pToPMonitorService.getPlatList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return;
        }
        for (PlatCompanyDTO platCompanyDTO : platList) {
            try {
                YuQingDO yuQingDO = this.platformConsensus(platCompanyDTO.getPlat_name());
                if (yuQingDO != null) {
                    yuQingWarningMapper.delByPlatName(yuQingDO.getPlat_name());
                    for (YuQingDO.Warning warning : yuQingDO.getWarning()) {
                        YuQingWarningDO warningDO = new YuQingWarningDO();
                        warningDO.setPlatName(yuQingDO.getPlat_name());
                        warningDO.setTitle(warning.getTitle());
                        warningDO.setContent(warning.getContent());
                        warningDO.setDate(warning.getDate());
                        warningDO.setSource(warning.getSource());
                        warningDO.setCreateBy("sys");
                        warningDO.setCreateDate(new Date());
                        yuQingWarningMapper.save(warningDO);
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                continue;
            }
        }

        logger.info("end get wangdai yuqing data");
    }

    @Override
    public Map<String, PlatListDO> getWangdaiCompanyList() {
        Map<String, PlatListDO> wangdaiCompanyList = new HashMap<>();
        for (PlatListDO platListDO : p2PImageDao.baseInfoWangDaiApi()) {
            platListDO.setCompany_name(platListDO.getCompany_name().trim());
            wangdaiCompanyList.put(platListDO.getCompany_name(), platListDO);
        }
        return wangdaiCompanyList;
    }

    @Override
    public PlatListDO getWangdaiCompanyList(String companyName) {
        return getWangdaiCompanyList().get(companyName);
    }
}
