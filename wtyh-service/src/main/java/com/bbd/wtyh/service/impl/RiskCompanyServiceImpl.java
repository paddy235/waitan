package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.OffLineModify;
import com.bbd.wtyh.domain.EasyExport.OffLineData;
import com.bbd.wtyh.domain.RiskCompanyInfoDO;
import com.bbd.wtyh.mapper.RiskCompanyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.RiskCompanyService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RiskCompanyServiceImpl implements RiskCompanyService {

    @Autowired
    private RiskCompanyMapper riskCompanyMapper;
    private static final int SCANNER_COUNT = 1000;
    @Autowired
    private RedisDAO redisDAO;
    private static final String SCANNER_PREFIX_KEY = "scanner_";
    private static final String TOP_PREFIX_KEY = "top_";

    @Override
    @SuppressWarnings("unchecked")
    public List<RiskCompanyInfoDO> getScanner(Map<String, Object> params) {
        String key = SCANNER_PREFIX_KEY + params.get("area") + "_" + params.get("minRegCapital") + "_"
                + params.get("maxRegCapital") + "_" + params.get("companyQualification") + "_"
                + params.get("minReviewTime") + "_" + params.get("maxReviewTime") + "_"
                + params.get("riskLevel") + "_" + params.get("areaId");

        List<RiskCompanyInfoDO> scannerList = (List<RiskCompanyInfoDO>) redisDAO.getObject(key);

        if (null == scannerList || scannerList.size() == 0) {
            int realCount = riskCompanyMapper.getScannerCount(params);
            int result = realCount / SCANNER_COUNT;
            List<RiskCompanyInfoDO> list = riskCompanyMapper.getScanner(params);
            scannerList = new ArrayList<>();
            if (result >= 2 && null != list && list.size() >= 1) {
                for (int i = 0; i < list.size(); i++) {
                    RiskCompanyInfoDO riskCompanyInfoDO = list.get(i);
                    if (i % result == 0) {
                        scannerList.add(riskCompanyInfoDO);
                    } else if (i == list.size() - 1) {
                        scannerList.add(riskCompanyInfoDO);
                    } else {
                    }
                }
            } else {
                scannerList = list;
            }
            redisDAO.addObject(key, scannerList, Constants.REDIS_5, List.class); // 保留5天
        }
        return scannerList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RiskCompanyInfoDO> getTop(Map<String, Object> params) {
        // + ((Pagination) params.get("pagination")).getPageNumber()
        String key = TOP_PREFIX_KEY + params.get("area") + "_" + params.get("minRegCapital") + "_"
                + params.get("maxRegCapital") + "_" + params.get("companyQualification") + "_"
                + params.get("minReviewTime") + "_" + params.get("maxReviewTime") + "_" + params.get("sortType") + "_"
                + "_" + params.get("riskLevel");
        List<RiskCompanyInfoDO> list = ((List<RiskCompanyInfoDO>) redisDAO.getObject(key));
        list = riskCompanyMapper.getTop(params);
        if (ListUtil.isEmpty(list)) {
            list = riskCompanyMapper.getTop(params);
            if (ListUtil.isNotEmpty(list))
                redisDAO.addObject(key, list, Constants.REDIS_5, List.class); // 保留5天
        }
        return list;
    }

    @Override
    public int getTopCount(Map<String, Object> params) {
        return riskCompanyMapper.getTopCount(params);
    }

    @Override
    public String getLastDataVersion() {
        return riskCompanyMapper.getLastDataVersion();
    }

    @Override
    public CompanyInfo getOffLineFinanceByCompanyName(String name) {
        return riskCompanyMapper.getOffLineFinanceByName(name);
    }

    @Override
    public List<OffLineData> getOffLineFinance(ExportCondition exportCondition) {
        return riskCompanyMapper.getOffLineFinance(exportCondition);
    }

    @Override
    public void modifyLevel(String name, String afterLevel) {
        riskCompanyMapper.modifyLevel(name, afterLevel);
    }

    @Override
    public void recordOffLine(OffLineModify offLineModify) {
        riskCompanyMapper.recordOffLine(offLineModify);
    }

    @Override
    public void modifyOffLine(OffLineModify offLineModify) {
        riskCompanyMapper.modifyLevel(offLineModify.getName(), offLineModify.getAfterLevel());
    }

    @Override
    public void modifyIndustry(String name, String industry) {
        riskCompanyMapper.modifyIndustry(name, industry);
    }

}
