package com.bbd.bgo.web.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.ParkCompanyDo;
import com.bbd.wtyh.domain.query.NaturalPersonQuery;
import com.bbd.wtyh.domain.vo.NaturalPersonVO;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.service.NaturalPersonService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * Created by Barney on 2017/7/5.
 */
@Controller
@RequestMapping("/natural-person")
public class NaturalPersonController {

    @Autowired
    private NaturalPersonService naturalPersonService;

    @RequestMapping("/query")
    public @ResponseBody ResponseBean queryNaturalPerson(NaturalPersonQuery query) {
        return ResponseBean.successResponse(naturalPersonService.queryNaturalPerson(query));
    }

    @RequestMapping("/download")
    public @ResponseBody ResponseBean downloadNaturalPerson(NaturalPersonQuery query, HttpServletRequest request) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String excelName = "自然人信息-" + timeStamp;

        ExportExcel exportExcel = new ExportExcel(excelName);
        try {
            List<NaturalPersonVO> list = naturalPersonService.queryNaturalPerson(query);
            exportExcel.createSheet(list);
            exportExcel.exportExcel();

            UserLogRecord.record("导出自然人列表", Operation.Type.DATA_EXPORT, Operation.Page.naturalPerson,
                    Operation.System.back, request);
            return ResponseBean.successResponse(exportExcel.getDownloadURL());
        } catch (Exception e) {
            return ExceptionHandler.handlerException(e);
        }

    }

}
