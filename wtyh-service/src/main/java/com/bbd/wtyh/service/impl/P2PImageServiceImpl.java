package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.bbdAPI.BBDLogoDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompanyDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
import com.bbd.wtyh.service.P2PImageService;
import com.sun.org.apache.xpath.internal.SourceTree;
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

    @Override
    public Map<String, Object> platFormStatus(String platName) {
        PlatDataDO pn = p2PImageDao.getPlatData(platName);
        List<PlatListDO> platListDO = p2PImageDao.baseInfoWangDaiApi(platName);
        Map<String, Object> result = new LinkedHashMap<>();
        for (int i=0; i<platListDO.size(); i++) {
            if (platListDO.get(i).getLogo_url()==null) {
                result.put("logo", null);
            }
            if (platListDO.get(i).getPlat_name()!=null && platName.equals(platListDO.get(i).getPlat_name())) {
                result.put("logo", platListDO.get(i).getLogo_url());//logo
            }
        }
        result.put("score",pn.getPlat_score()); // 评分
        result.put("platname",pn.getPlat_name()); // 平台名称
        result.put("status",pn.getPlat_status()); // 营业状态
        return result;
    }

    @Override
    public YuQingDO platformConsensus(String platName) {
        return p2PImageDao.platformConsensus(platName);
    }

    @Override
    public Map<String, Object> lawsuitMsg(String platName) {
        PlatDataDO pn = p2PImageDao.getPlatData(platName);
        return p2PImageDao.lawsuitMsg(pn.getCompany_name());
    }

    @Override
    public Map<String, Object> radarScore(String platName) {
        PlatDataDO platData = p2PImageDao.getPlatData(platName);
        Map<String, Object> data = p2PImageDao.radarScore(platName);
        data.put("sumScore",platData.getPlat_score());
        return data;
    }

    @Override
    public Map<String, Object> baseInfo(String platName) {
        PlatformNameInformationDO platformNameInformationDO = p2PImageDao.hasOrNotCompany(platName);
        BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(platformNameInformationDO.getName());
        ZuZhiJiGoudmDO zuZhiJiGoudmDO = p2PImageDao.baseInfoZuZhiJiGou(platformNameInformationDO.getName());
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
        return data;
    }

    @Override
    public List<List<String>> coreDataDealTrend(String platName) {
        PlatDataDO data = p2PImageDao.getPlatData(platName);
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> amounts = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            BigDecimal dayAmount = new BigDecimal(String.valueOf(pdsm.getDay_amount()));
            amounts.add(dayAmount.toPlainString());
        }
        
        List<List<String>> result = new ArrayList<>();
        Collections.reverse(days);
        Collections.reverse(amounts);
        List<String> days1 = new ArrayList<>();
        List<String> amounts1 = new ArrayList<>();
        for (int i=0; i<15; i++) {
            days1.add(days.get(i));
            amounts1.add(amounts.get(i));
        }
        result.add(days1);
        result.add(amounts1);
        return result;
    }

    @Override
    public List<List<String>> coreDataInterestRateTrend(String plat_name) {
        // 处理数据转换
        PlatDataDO data = p2PImageDao.getPlatData(plat_name);
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> interestRates = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            interestRates.add(String.valueOf(pdsm.getDay_interest_rate()));
        }
        Collections.reverse(days);
        Collections.reverse(interestRates);
        List<String> days1 = new ArrayList<>();
        List<String> interestRates1 = new ArrayList<>();
        for (int i=0; i<15; i++) {
            days1.add(days.get(i));
            interestRates1.add(interestRates.get(i));
        }
        List<List<String>> result = new ArrayList<>();
        result.add(days1);
        result.add(interestRates1);
        return result;
    }

    @Override
    public List<List<String>> coreDataLoadOverage(String plat_name) {
        // 处理数据转换
        PlatDataDO data = p2PImageDao.getPlatData(plat_name);
        List<PlatDataDO.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> loanOverages = new ArrayList<>();
        for (PlatDataDO.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            BigDecimal dayAmount = new BigDecimal(String.valueOf(pdsm.getDay_money_stock()));
            loanOverages.add(dayAmount.toPlainString());
        }
        Collections.reverse(days);
        Collections.reverse(loanOverages);
        List<String> days1 = new ArrayList<>();
        List<String> loanOverages1 = new ArrayList<>();
        for (int i=0; i<15; i++) {
            days1.add(days.get(i));
            loanOverages1.add(loanOverages.get(i));
        }
        List<List<String>> result = new ArrayList<>();
        result.add(days1);
        result.add(loanOverages1);
        return result;
    }

    @Override
    public PlatformNameInformationDO hasOrNotCompany(String platName) {
        return p2PImageDao.hasOrNotCompany(platName);
    }
}
