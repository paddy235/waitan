package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.EasyExport.PawnData;
import com.bbd.wtyh.domain.MortgageStatisticDO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;

import java.util.List;

public interface MortgageStatisticMapper {
    MortgageStatisticDO selectByPrimaryKey(Integer year);

    List<MortgageStatisticDO> selectAll();
}