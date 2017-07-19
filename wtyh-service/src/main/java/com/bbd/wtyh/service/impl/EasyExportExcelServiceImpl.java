
/**
 * @Title: AreaServiceImpl.java
 * @Package com.bbd.wtyh.service.impl
 * @Description: TODO
 * @author Ian.Su
 * @date 2016年8月5日 下午1:48:36
 * @version V1.0
 */

package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.EasyExport.OffLineData;
import com.bbd.wtyh.service.EasyExportExeclService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import org.springframework.stereotype.Service;

@Service("easyExportExeclService")
public class EasyExportExcelServiceImpl implements EasyExportExeclService {

    @Override
    public OffLineData getOffLineFinance(ExportCondition exportCondition) {
        return null;
    }
}
