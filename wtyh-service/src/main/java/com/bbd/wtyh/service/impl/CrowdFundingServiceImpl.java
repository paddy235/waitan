package com.bbd.wtyh.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.dao.CrowdFundingDao;
import com.bbd.wtyh.domain.CrowdFundingCommonDO;
import com.bbd.wtyh.domain.wangDaiAPI.CrowdFundingStatisticsDTO;
import com.bbd.wtyh.mapper.CrowdFundingCommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.mapper.CrowdFundingBusinessStatisticsMapper;
import com.bbd.wtyh.mapper.CrowdFundingCompanyMapper;
import com.bbd.wtyh.mapper.CrowdFundingStatisticsMapper;
import com.bbd.wtyh.service.CrowdFundingService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import static y.layout.orthogonal.e.bb.i;

/**
 * @author Ian.Su
 * @since 2016年8月11日 下午4:13:50
 */
@Service
public class CrowdFundingServiceImpl implements CrowdFundingService {


    @Autowired
    private CrowdFundingBusinessStatisticsMapper cfbsMapper;

    @Autowired
    private CrowdFundingStatisticsMapper cfsMapper;

    @Autowired
    private CrowdFundingCompanyMapper cfcMapper;

    @Autowired
    private CrowdFundingDao crowdFundingDao;

    @Autowired
    private CrowdFundingCompanyMapper crowdFundingCompanyMapper;

    @Autowired
    private CrowdFundingCommonMapper crowdFundingCommonMapper;


    @Override
    public List<NvDO> lastMonthData() {
        return cfbsMapper.lastMonthData();
    }

    @Override
    public Map<String, String> lastMonthType(String dataType) {
        return crowdFundingDao.lastMonthType(dataType);
    }


    @Override
    public List<CrowdFundingCompanyDO> allCompanys() {
        List<CrowdFundingCompanyDO> list = crowdFundingDao.allCompanys();
        if (!CollectionUtils.isEmpty(list)) {
            for (CrowdFundingCompanyDO crowdFundingCompanyDO : list) {
                String websiteUrl = crowdFundingCompanyDO.getWebsiteUrl();
                if (StringUtils.isEmpty(websiteUrl)) {
                    continue;
                }
                if (!websiteUrl.contains("http://")) {
                    crowdFundingCompanyDO.setWebsiteUrl("http://" + websiteUrl);
                }
            }
        }
        return list;
    }

    @Override
    public List<String> queryCompany(String keyword) {
        return cfcMapper.queryCompany(keyword);
    }

    @Override
    public Map crowdFundingDataLandTask(Integer taskId) {
        Integer planCount = 5;
        Integer failCount = 0;
        try {
            crowdFundingCompanyDataLand();
        } catch (Exception e) {
            e.printStackTrace();
            failCount++;
        }

        for (int i = 2; i <= 5; i++) {
            try {
                crowdFundingCommonDataLand(String.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
                failCount++;
            }
        }
        Map map = new HashMap();
        map.put("planCount", planCount);
        map.put("failCount", failCount);
        return map;
    }

    private void crowdFundingCommonDataLand(String type) {
        CrowdFundingCommonDO crowdFundingCommonDO = new CrowdFundingCommonDO();
        Map map = crowdFundingDao.lastMonthType(type);
        crowdFundingCommonDO.setReward((String) map.get("奖励众筹"));
        crowdFundingCommonDO.setNonPulicEquityFinancing((String) map.get("非公开股权融资"));
        crowdFundingCommonDO.setPublicWelfare((String) map.get("公益众筹"));
        if(map.get("混合众筹")!=null){
            crowdFundingCommonDO.setBlend((String) map.get("混合众筹"));
        }
        crowdFundingCommonDO.setType(type);
        crowdFundingCommonDO.setCreateBy("sys");
        crowdFundingCommonDO.setCreateDate(new Date());
        crowdFundingCommonMapper.deleteByType(type);
        crowdFundingCommonMapper.save(crowdFundingCommonDO);
    }

    private void crowdFundingCompanyDataLand() throws Exception {
        List<CrowdFundingCompanyDO> dtoList = crowdFundingDao.allCompanys();
        if (dtoList == null) {
            throw new Exception("pull data error");
        }
        for (CrowdFundingCompanyDO dto : dtoList) {
            dto.setCreateBy("sys");
            dto.setCreateDate(new Date());
            crowdFundingCompanyMapper.deleteByCompanyName(dto.getCompanyName());
            crowdFundingCompanyMapper.saveForDataLand(dto);
        }
    }
}
