package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.service.PToPMonitorService;
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

    @Override
    public PlatDataDO getPlatData(String platName) {
        PlatDataDO pn = p2PImageDao.getPlatData(platName);
        return pn;
    }


    @Override
    public Map<String, Object> platFormStatus(String platName) {
        PlatDataDO pn = p2PImageDao.getPlatData(platName);
        if (null == pn) {
            return null;
        }

        PlatListDO platListDO = findFromWangdaiPlatList(platName);
        PlatRankDataDTO platRankDataDTO = findFromWangdaiPlatRankData(platName);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("logo", platListDO.getLogo_url());//logo
        result.put("rank", platRankDataDTO.getPlatRank()); // 评级
        result.put("platname", pn.getPlat_name()); // 平台名称
        result.put("companyName", pn.getCompany_name()); // 公司名称
        result.put("status", platRankDataDTO.getPlat_status()); // 营业状态
        return result;
    }

    @Override
    public PlatRankDataDTO findFromWangdaiPlatRankData(String platName) {
        Map<String, PlatRankDataDTO> wangdaiPlatRankData = new HashMap<>();
        try {
            for (PlatRankDataDTO platRankDataDTO : pToPMonitorService.getPlatRankData(null)) {
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
        Map<String, PlatListDO> wangdaiPlatList = new HashMap<>();
        for (PlatListDO platListDO : p2PImageDao.baseInfoWangDaiApi(platName)) {
            wangdaiPlatList.put(platListDO.getPlat_name(), platListDO);
        }
        return wangdaiPlatList.get(platName);
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
    public Map<String, Object> baseInfo(String platName) {
        PlatformNameInformationDO platformNameInformationDO = p2PImageDao.hasOrNotCompany(platName);
        if (null == platformNameInformationDO) {
            return null;
        }
        BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(platformNameInformationDO.getName());
        if (null == baseDataDO) {
            return null;
        }
        ZuZhiJiGoudmDO zuZhiJiGoudmDO = p2PImageDao.baseInfoZuZhiJiGou(platformNameInformationDO.getName());
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
        map.put("platName", platformNameInformationDO.getPlatformName());
        map.put("companyName", platformNameInformationDO.getName());
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
}
