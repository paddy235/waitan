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
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.NaturalPersonService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.lang.StringUtils;
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

    //@RequestMapping("/query")
    public @ResponseBody ResponseBean queryNaturalPerson(NaturalPersonQuery query) {
        return ResponseBean.successResponse(naturalPersonService.queryNaturalPerson(query));
    }

    //@RequestMapping("/download")
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

    ////cgj

    @RequestMapping("/query2.do")
    /*@LogRecord(logMsg = "检索自然人“%s”的信息，检索类型：%s，企业关键字：%s", params = { "nalName", "type",
            "companyKeyword" }, type = Operation.Type.query, page = Operation.Page.naturalPerson, after = true, before = false)*/
    public @ResponseBody ResponseBean queryNaturalPerson2( @RequestParam String nalName, @RequestParam String type,
                    Boolean isProvince, String companyKeyword, Integer pageSize, Integer page, Boolean noCache ) {
        StringBuffer sb =new StringBuffer("检索自然人“");
        sb.append(nalName).append("”的信息，检索类型：");
        switch (type) {
            case "all" : sb.append("全部"); break;
            case "gdxx" : sb.append("法人、股东"); break;
            case "baxx" : sb.append("董监高"); break;
            default: sb.append("其它");
        }
        if (StringUtils.isNotBlank(companyKeyword)) {
            sb.append("，企业关键字：").append(companyKeyword);
        }
        UserLogRecord.record(sb.toString(), Operation.Type.query, Operation.Page.naturalPerson, Operation.System.back);
        return ResponseBean.successResponse(
                naturalPersonService.queryNaturalPerson2( nalName, type, isProvince, companyKeyword, pageSize, page, noCache) );
    }

    @RequestMapping("/download2.do")
    public @ResponseBody ResponseBean downloadNaturalPerson2( @RequestParam String nalName, @RequestParam String type,
            Boolean isProvince, String companyKeyword,  HttpServletRequest request) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String excelName = "自然人信息-" +nalName +"-" +timeStamp;

        if ( naturalPersonService.allowDownFile() ) {
            ExportExcel exportExcel = new ExportExcel(excelName);
            try {
                Map<String, Object> rst = naturalPersonService.queryNaturalPerson2(
                        nalName, type, isProvince, companyKeyword, 200, 1,false);
                List<NaturalPersonVO> list = (List<NaturalPersonVO>) rst.get("naturalPersons");
                exportExcel.createSheet("自然人信息", list);
                exportExcel.exportExcel();

                UserLogRecord.record("导出自然人“" + nalName + "”的列表", Operation.Type.DATA_EXPORT,
                        Operation.Page.naturalPerson, Operation.System.back, request);
                return ResponseBean.successResponse(exportExcel.getDownloadURL());
            } catch (Exception e) {
                return ExceptionHandler.handlerException(e);
            }
        } else {
            return  ResponseBean.errorResponse("今天的下载次数已用尽。");
        }
    }

}
