package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.EasyExport.OffLineData;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.ResponseBean;

public interface EasyExportExeclService {
    OffLineData getOffLineFinance(ExportCondition exportCondition);
}
