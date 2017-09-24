package com.bbd.wtyh.mapper;

import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.OffLineModify;
import com.bbd.wtyh.domain.EasyExport.OffLineData;
import com.bbd.wtyh.domain.RiskCompanyInfoDO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RiskCompanyMapper {

    List<RiskCompanyInfoDO> getScanner(Map<String, Object> params);

    int getScannerCount(Map<String, Object> params);

    List<RiskCompanyInfoDO> getTop(Map<String, Object> params);

    int getTopCount(Map<String, Object> params);

    String getLastDataVersion();

    CompanyInfo getOffLineFinanceByName(@Param(value = "name") String name);

    List<OffLineData> getOffLineFinance(@Param(value = "exportCondition") ExportCondition exportCondition,
            @Param(value = "pagination") PageBean pagination);

    void modifyLevel(@Param(value = "name") String name, @Param(value = "afterLevel") String afterLevel);

    void recordOffLine(OffLineModify offLineModify);

    void modifyIndustry(@Param(value = "name") String name, @Param(value = "industry") String industry);

    Long countOffLineFinance(@Param(value = "exportCondition") ExportCondition exportCondition);

    @MapKey("city")
    Map<String, Integer> area();
}
