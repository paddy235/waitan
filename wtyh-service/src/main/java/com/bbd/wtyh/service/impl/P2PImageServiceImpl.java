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
        if (platListDO.get(0).getLogo_url()==null) {
            result.put("logo", null);
        }
//        result.put("logo", platListDO.getLogo_url());//logo
        result.put("logo", platListDO.get(0).getLogo_url());//logo
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
        List<PlatListDO> platListDO = p2PImageDao.baseInfoWangDaiApi(platName);
        BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(String.valueOf(platListDO.get(0).getCompany_name()));
        ZuZhiJiGoudmDO zuZhiJiGoudmDO = p2PImageDao.baseInfoZuZhiJiGou(String.valueOf(platListDO.get(0).getCompany_name()));
        Map<String, Object> map = new HashMap<>();
        // TODO 接口可能有问题
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
        map.put("platName", platListDO.get(0).getPlat_name());
        map.put("companyName", platListDO.get(0).getCompany_name());
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
            amounts.add(String.valueOf(pdsm.getDay_amount()));
        }
        
        List<List<String>> result = new ArrayList<>();
        result.add(days);
        result.add(amounts);
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

        List<List<String>> result = new ArrayList<>();
        result.add(days);
        result.add(interestRates);
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
            loanOverages.add(String.valueOf(pdsm.getDay_money_stock()));
        }

        List<List<String>> result = new ArrayList<>();
        result.add(days);
        result.add(loanOverages);
        return result;
    }

    @Override
    public PlatformNameInformationDO hasOrNotCompany(String platName) {
        return p2PImageDao.hasOrNotCompany(platName);
    }
}
