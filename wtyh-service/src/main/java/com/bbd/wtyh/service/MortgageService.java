package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.EasyExport.PawnData;
import com.bbd.wtyh.domain.MortgageStatisticDO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;

import java.util.List;

/**
 * Created by Marco on 2016/8/10.
 */
public interface MortgageService {

    List<MortgageStatisticDO> getMortgageStatisticList();

}
