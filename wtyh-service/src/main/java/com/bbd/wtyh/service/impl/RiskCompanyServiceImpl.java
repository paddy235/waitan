package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.OffLineModify;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.EasyExport.OffLineData;
import com.bbd.wtyh.domain.RiskCompanyInfoDO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.domain.enums.WangDaiRiskLevel;
import com.bbd.wtyh.mapper.RiskCompanyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.PrepaidCompanyStaticService;
import com.bbd.wtyh.service.RiskCompanyService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RiskCompanyServiceImpl implements RiskCompanyService {

    @Autowired
    private PrepaidCompanyStaticService predService;
    @Autowired
    private RiskCompanyMapper riskCompanyMapper;
    private static final int SCANNER_COUNT = 1000;
    private static final String RISK = String.valueOf(CompanyAnalysisResult.RISK.getType());
    @Autowired
    private RedisDAO redisDAO;
    //    private static final String SCANNER_PREFIX_KEY = "scanner_";
    //    private static final String TOP_PREFIX_KEY = "top_";

    @Override
    @SuppressWarnings("unchecked")
    public List<RiskCompanyInfoDO> getScanner(Map<String, Object> params) {
        //        String key = SCANNER_PREFIX_KEY + params.get("area") + "_" + params.get("minRegCapital") + "_"
        //                + params.get("maxRegCapital") + "_" + params.get("companyQualification") + "_"
        //                + params.get("minReviewTime") + "_" + params.get("maxReviewTime") + "_"
        //                + params.get("riskLevel") + "_" + params.get("areaId");

        //        List<RiskCompanyInfoDO> scannerList = (List<RiskCompanyInfoDO>) redisDAO.getObject(key);
        List<RiskCompanyInfoDO> scannerList = null;

        //        if (null == scannerList || scannerList.size() == 0) {
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
        //            redisDAO.addObject(key, scannerList, Constants.REDIS_5, List.class); // ??????5???
        //        }
        return scannerList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RiskCompanyInfoDO> getTop(Map<String, Object> params) {
        // + ((Pagination) params.get("pagination")).getPageNumber()
        //        String key = TOP_PREFIX_KEY + params.get("area") + "_" + params.get("minRegCapital") + "_"
        //                + params.get("maxRegCapital") + "_" + params.get("companyQualification") + "_"
        //                + params.get("minReviewTime") + "_" + params.get("maxReviewTime") + "_" + params.get("sortType") + "_"
        //                + "_" + params.get("riskLevel");
        //        List<RiskCompanyInfoDO> list = ((List<RiskCompanyInfoDO>) redisDAO.getObject(key));
        List<RiskCompanyInfoDO> list = riskCompanyMapper.getTop(params);
        //        if (ListUtil.isEmpty(list)) {
        //            list = riskCompanyMapper.getTop(params);
        //            if (ListUtil.isNotEmpty(list))
        //                redisDAO.addObject(key, list, Constants.REDIS_5, List.class); // ??????5???
        //        }
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
    public List<OffLineData> getOffLineFinance(ExportCondition exportCondition, PageBean pageBean) {
        pageBean.setTotalCount(riskCompanyMapper.countOffLineFinance(exportCondition));
        return riskCompanyMapper.getOffLineFinance(exportCondition, pageBean);
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
    public void modifyOffLineLevel(RecordInfo recordInfo) {
        String level = null;
        try {
            level = ""+Integer.parseInt((recordInfo.getAfterLevel()));
        }catch (Exception e) {
            try {
                level = WangDaiRiskLevel.getRiskType(recordInfo.getAfterLevel()).toString();
            }catch (Exception e1) {
                level=null;
            }
        }
        if(null!=level){
            riskCompanyMapper.modifyLevel(recordInfo.getName(), level);
            if (RISK.equals(level)) {
                CompanyAnalysisResultDO analysisResultDO = new CompanyAnalysisResultDO();
                analysisResultDO.setCompanyId(recordInfo.getCompanyId());
                analysisResultDO.setCreateBy("companyUpdate");
                analysisResultDO.setUpdateBy("companyUpdate");
                int i = predService.updateCompanyAnalysisResultWhenBlack(analysisResultDO);
                if (i == 0) {
                    predService.addCompanyAnalysisResultWhenBlack(analysisResultDO);
                }
            } else {
                if (!StringUtils.isNullOrEmpty(level)) {
                    predService.deleteByCompanyId(recordInfo);
                }
            }
        }
    }

    @Override
    public void modifyIndustry(String name, String industry) {
        riskCompanyMapper.modifyIndustry(name, industry);
    }

    @Override
    public Map<String, Integer> area() {
        return riskCompanyMapper.area();
    }

}
