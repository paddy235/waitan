package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.constants.*;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.domain.enums.WangDaiRiskLevel;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.mapper.CoRiskChgMapper;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 企业变化监测-风险变化企业
 *
 * @author Created by LiYao on 2017-04-19 16:45.
 */
@Service
public class CoRiskChgServiceImpl extends BaseServiceImpl implements CoRiskChgService {

    @Autowired
    private CoRiskChgMapper coRiskChgMapper;

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Map<String, Object>> riskChgCoBuilding(String areaSet) {

        return this.coRiskChgMapper.riskChgCoBuilding(areaSet);
    }

    @Override
    public List<RiskChgCoDo> queryPageData(Map<String, String> paramMap, Pagination page) {

        String where = this.generateDynamicWhere(paramMap);

        List<RiskChgCoDo> list = this.selectByPage(RiskChgCoDo.class, page, where);
        page.setList(list);
        return list;

    }

    @Override
    public List<RiskChgCoDo> queryAllData(Map<String, String> paramMap) {
        String where = this.generateDynamicWhere(paramMap);
        return this.selectAll(RiskChgCoDo.class, where);

    }

    @Override
    public RiskChgCoDo generateNewRecord(ModifyData modifyData, String createBy, RiskChgCoSource riskChgCoSource) {
        CompanyDO companyDO = companyService.getCompanyByName(modifyData.getName());
        if (companyDO == null) {
            return null;
        }
        int companyType = Byte.parseByte(modifyData.getIndustry());

        RiskChgCoDo riskChgCoDo = new RiskChgCoDo();
        BeanCopier beanCopier = BeanCopier.create(CompanyDO.class, RiskChgCoDo.class, false);
        beanCopier.copy(companyDO, riskChgCoDo, null);

        riskChgCoDo.setCompanyName(companyDO.getName());
        riskChgCoDo.setCompanyType(companyType);
        // 1表示手工修改
        riskChgCoDo.setSource(riskChgCoSource.type());
        riskChgCoDo.setChangeDate(new Date());
        riskChgCoDo.setCreateBy(createBy);
        riskChgCoDo.setCreateDate(new Date());
        riskChgCoDo.setUpdateBy(null);
        riskChgCoDo.setUpdateDate(null);

        // 设值失败，则不继续处理
        if (!setRiskLevel(companyType, companyDO, riskChgCoDo, modifyData.getLevel(), modifyData.getInnerLevel(), modifyData.getOutLevel(),
                modifyData.getLiveLevel())) {
            return null;
        }

        // 区域
        AreaDO areaDO = this.companyService.selectById(AreaDO.class, riskChgCoDo.getAreaId());
        if (areaDO != null) {
            riskChgCoDo.setAreaName(areaDO.getName());
        }

        // 楼宇
        BuildingDO buildingDO = this.companyService.selectById(BuildingDO.class, riskChgCoDo.getCompanyId());
        if (buildingDO != null) {
            riskChgCoDo.setBuildingId(buildingDO.getBuildingId());
            riskChgCoDo.setBuildingName(buildingDO.getName());
        }
        return riskChgCoDo;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    public boolean setRiskLevel(int toCompanyType, CompanyDO companyDO, RiskChgCoDo riskChgCoDo, String level, String innerLevel,
            String outLevel, String liveLevel) {
        // 网络借贷
        if (CompanyType.TYPE_P2P_1.type().equals(toCompanyType)) {
            return setLevelFromCompany(companyDO, riskChgCoDo, WangDaiRiskLevel.getRiskType(level));
        }
        // 小额贷款 融资担保
        if (CompanyType.TYPE_XD_2.type().equals(toCompanyType) || CompanyType.TYPE_RZDB_3.type().equals(toCompanyType)) {
            return setPettyLoanLevel(companyDO, riskChgCoDo, innerLevel, outLevel, liveLevel);
        }
        // 线下理财
        if (CompanyType.TYPE_XXLC_4.type().equals(toCompanyType)) {
            return setLevelFromCompany(companyDO, riskChgCoDo, stringToInt(level));
        }
        // 私募基金
        if (CompanyType.TYPE_SMJJ_5.type().equals(toCompanyType)) {
            return false;
        }
        // 众筹
        if (CompanyType.TYPE_ZC_6.type().equals(toCompanyType)) {
            return false;
        }
        // 其它
        if (CompanyType.TYPE_JR_7.type().equals(toCompanyType)) {
            return false;
        }
        // 金融
        if (CompanyType.TYPE_QT_8.type().equals(toCompanyType)) {
            return false;
        }
        // 交易场所
        if (CompanyType.TYPE_JYS_9.type().equals(toCompanyType)) {
            return setLevelFromCompany(companyDO, riskChgCoDo, stringToInt(level));
        }
        // 商业保理
        if (CompanyType.TYPE_SYBL_10.type().equals(toCompanyType)) {
            return false;
        }
        // 预付卡
        if (CompanyType.TYPE_YFK_11.type().equals(toCompanyType)) {
            return setPrepaidLevel(companyDO, riskChgCoDo, stringToInt(level));
        }
        // 典当
        if (CompanyType.TYPE_DD_12.type().equals(toCompanyType)) {
            return false;
        }
        // 融资租赁
        if (CompanyType.TYPE_RZZL_13.type().equals(toCompanyType)) {
            return setFinancingLeaseLevel(companyDO, riskChgCoDo, stringToInt(level));
        }
        return false;
    }

    private boolean setFinancingLeaseLevel(CompanyDO companyDO, RiskChgCoDo riskChgCoDo, Integer newLevel) {
        boolean newHasError = !nullToMinus1(newLevel).equals(-1);
        List<FinanceLeaseRiskDO> dataList = selectAll(FinanceLeaseRiskDO.class,
                "company_id = ? AND risk_type BETWEEN 1 AND 4 AND risk_status = true", companyDO.getCompanyId());
        boolean oldHasError = !CollectionUtils.isEmpty(dataList);
        if (newHasError == oldHasError) {
            return false;
        }
        riskChgCoDo.setHaveRisk(newHasError);
        riskChgCoDo.setOldHaveRisk(oldHasError);
        return true;
    }

    private boolean setPrepaidLevel(CompanyDO companyDO, RiskChgCoDo riskChgCoDo, Integer newLevel) {
        Integer oldLevel = -1;
        newLevel = nullToMinus1(newLevel);
        CompanyAnalysisResultDO analysisResult = selectById(CompanyAnalysisResultDO.class, companyDO.getCompanyId());

        if (analysisResult != null && analysisResult.getAnalysisResult() != null) {
            oldLevel = analysisResult.getAnalysisResult().intValue();
        }

        if (newLevel.equals(oldLevel)) {
            return false;
        }
        riskChgCoDo.setOldRiskLevel(minus1ToNull(oldLevel));
        riskChgCoDo.setRiskLevel(minus1ToNull(newLevel));
        return true;
    }

    private boolean setLevelFromCompany(CompanyDO companyDO, RiskChgCoDo riskChgCoDo, Integer newLevel) {
        Integer oldLevel = nullToMinus1(companyDO.getRiskLevel());
        newLevel = nullToMinus1(newLevel);
        if (newLevel.equals(oldLevel)) {
            return false;
        }
        riskChgCoDo.setOldRiskLevel(minus1ToNull(oldLevel));
        riskChgCoDo.setRiskLevel(minus1ToNull(newLevel));
        return true;
    }

    private Integer stringToInt(String numStr) {
        if (StringUtils.isBlank(numStr)) {
            return null;
        }
        return Integer.parseInt(numStr);
    }

    /**
     * 如果num为-1，则转为 null。否则不变
     * 
     * @param num
     * @return
     */
    private Integer minus1ToNull(Integer num) {
        return num.equals(-1) ? null : num;
    }

    /**
     * 如果num为null，则转为 -1。否则不变
     * 
     * @param num
     * @return
     */
    private Integer nullToMinus1(Integer num) {
        return num == null ? -1 : num;
    }

    private boolean setPettyLoanLevel(CompanyDO companyDO, RiskChgCoDo riskChgCoDo, String innerLevel, String outLevel, String liveLevel) {
        CompanyLevelDO oldLevelDO = selectById(CompanyLevelDO.class, companyDO.getCompanyId());
        if (oldLevelDO == null) {
            oldLevelDO = new CompanyLevelDO();
        }
        boolean hasChange = false;

        Integer newOutLevel = Integer.parseInt(StringUtils.defaultIfBlank(outLevel, "-1"));
        Integer oldOutLevel = nullToMinus1(oldLevelDO.getOutLevel());
        if (!newOutLevel.equals(oldOutLevel)) {
            hasChange = true;
            riskChgCoDo.setOldOutLevel(minus1ToNull(oldOutLevel));
            riskChgCoDo.setOutLevel(minus1ToNull(newOutLevel));
        }

        Integer newInnerLevel = Integer.parseInt(StringUtils.defaultIfBlank(innerLevel, "-1"));
        Integer oldInnerLevel = nullToMinus1(oldLevelDO.getInnerLevel());
        if (!newInnerLevel.equals(oldInnerLevel)) {
            hasChange = true;
            riskChgCoDo.setOldInnerLevel(minus1ToNull(oldInnerLevel));
            riskChgCoDo.setInnerLevel(minus1ToNull(newInnerLevel));
        }

        Integer newLiveLevel = Integer.parseInt(StringUtils.defaultIfBlank(liveLevel, "-1"));
        Integer oldLiveLevel = nullToMinus1(oldLevelDO.getLiveLevel());
        if (!newLiveLevel.equals(oldLiveLevel)) {
            hasChange = true;
            riskChgCoDo.setOldLiveLevel(minus1ToNull(oldLiveLevel));
            riskChgCoDo.setLiveLevel(minus1ToNull(newLiveLevel));
        }
        return hasChange;
    }

    /**
     * 生产动态where语句
     * 
     * @param paramMap
     * @return
     */
    private String generateDynamicWhere(Map<String, String> paramMap) {

        // 金融类型 financialType
        String financialType = paramMap.get("financialType");

        if (StringUtils.isBlank(financialType)) {
            throw new BusinessException("公司类型不能为空。");
        }

        Integer companyType = Integer.parseInt(financialType);

        StringBuilder dynamicWhere = new StringBuilder();
        dynamicWhere.append("company_type = ").append(companyType);

        // 楼宇 buildId
        String buildId = paramMap.get("buildId");
        if (StringUtils.isNotBlank(buildId)) {
            dynamicWhere.append(" AND building_id = ").append(buildId);
        }

        // 风险等级 riskLevel
        String riskLevel = paramMap.get("riskLevel");
        this.setDynamicRiskWhere(dynamicWhere, companyType, riskLevel);

        // 来源 source
        String source = paramMap.get("source");
        if (StringUtils.isNotBlank(source)) {
            dynamicWhere.append(" AND source = ").append(source);
        }

        // 开始时间 sdate
        String sdate = paramMap.get("sdate");
        if (StringUtils.isNotBlank(sdate)) {
            sdate = sdate + "-01";
            dynamicWhere.append(" AND change_date >= TIMESTAMP('").append(sdate).append(" 00:00:00')");
        }

        // 结束时间 edate
        String edate = paramMap.get("edate");
        if (StringUtils.isNotBlank(edate)) {
            edate = LocalDate.parse(edate + "-01").with(TemporalAdjusters.lastDayOfMonth()).toString();
            dynamicWhere.append(" AND change_date <= TIMESTAMP('").append(edate).append(" 23:59:59')");
        }

        // 选择区域 areaSet
        String areaSet = paramMap.get("areaSet");
        if (StringUtils.isNotBlank(areaSet) && !"0".equals(areaSet)) {
            dynamicWhere.append(" AND area_id IN (").append(areaSet).append(") ");
        }

        // 排序
        String statusSort = paramMap.get("statusSort");
        if (StringUtils.isNotBlank(statusSort) && !"DEFAULT".equals(statusSort)) {
            // 融资租赁 需要按照 old_have_risk 排序
            if (CompanyDO.TYPE_RZZL_13 == companyType.byteValue()) {
                dynamicWhere.append(" ORDER BY old_have_risk ").append(statusSort);
            } else {
                dynamicWhere.append(" ORDER BY old_risk_level ").append(statusSort);
            }
        } else {
            dynamicWhere.append(" ORDER BY change_date DESC");
        }

        return dynamicWhere.toString();
    }

    private void setDynamicRiskWhere(StringBuilder dynamicWhere, Integer companyType, String riskLevel) {
        if (StringUtils.isBlank(riskLevel)) {
            return;
        }

        Integer level = Integer.parseInt(riskLevel);
        if (level.equals(0)) {
            return;
        }
        byte type = companyType.byteValue();

        switch (type) {

        case CompanyDO.TYPE_P2P_1:// 网络借贷
        case CompanyDO.TYPE_XXLC_4:// 线下理财
            dynamicWhere.append(" AND risk_level = ").append(riskLevel);
            break;
        case CompanyDO.TYPE_JYS_9:// 交易所
            if (level.equals(1)) {
                dynamicWhere.append(" AND risk_level = 1");
            } else {
                dynamicWhere.append(" AND risk_level != 1");
            }
            break;

        case CompanyDO.TYPE_RZZL_13:// 融资租赁
            if (level.equals(RZZLCoRiskLevel.NORMAL.type())) {
                dynamicWhere.append(" AND have_risk = 0");
            }
            if (level.equals(RZZLCoRiskLevel.LATENT.type())) {
                dynamicWhere.append(" AND have_risk = 1");
            }
            break;

        case CompanyDO.TYPE_YFK_11:// 预付卡
            if (level.equals(PrepaidCoRiskLevel.NORMAL.type())) {
                dynamicWhere.append(" AND ").append(CompanyAnalysisResult.IMPORT_FOCUS.getType()).append(" != risk_level");
                dynamicWhere.append(" AND ").append(CompanyAnalysisResult.COMMON_FOCUS.getType()).append(" != risk_level");
            }
            if (level.equals(PrepaidCoRiskLevel.LATENT.type())) {
                dynamicWhere.append(" AND risk_level = ").append(CompanyAnalysisResult.COMMON_FOCUS.getType());
            }
            if (level.equals(PrepaidCoRiskLevel.HAPPEN.type())) {
                dynamicWhere.append(" AND risk_level = ").append(CompanyAnalysisResult.IMPORT_FOCUS.getType());
            }
            break;
        }
    }

}
